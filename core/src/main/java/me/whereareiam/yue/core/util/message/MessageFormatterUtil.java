package me.whereareiam.yue.core.util.message;

import com.vdurmont.emoji.EmojiParser;
import me.whereareiam.yue.core.language.LanguageService;
import net.dv8tion.jda.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MessageFormatterUtil {
	private final LanguageService languageService;

	@Autowired
	public MessageFormatterUtil(LanguageService languageService) {
		this.languageService = languageService;
	}

	public String[] formatMessage(User user, String[] message) {
		for (int i = 0; i < message.length; i++) {
			message[i] = formatMessage(user, message[i]);
		}

		return message;
	}

	public String formatMessage(User user, String message) {
		message = languageService.getTranslation(user, message);
		message = hookTranslationPlaceholders(message);
		message = hookInternalPlaceholders(user, message);
		message = hookEmojiParser(message);

		return message;
	}

	private String hookTranslationPlaceholders(String message) {
		if (message == null) return null;

		final Pattern pattern = Pattern.compile("\\$t\\{(.+?)\\}");

		Matcher matcher = pattern.matcher(message);
		StringBuilder buffer = new StringBuilder();
		while (matcher.find()) {
			String key = matcher.group(1);
			String translation = languageService.getTranslation(key);
			matcher.appendReplacement(buffer, translation);
		}
		matcher.appendTail(buffer);
		return buffer.toString();
	}

	private String hookInternalPlaceholders(User user, String message) {
		return message.replace("{memberTag}", user.getAsMention());
	}

	private String hookEmojiParser(String message) {
		if (message.startsWith(":") && message.endsWith(":")) {
			return EmojiParser.parseToUnicode(message);
		}

		return message;
	}
}
