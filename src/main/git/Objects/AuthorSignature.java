package main.git.Objects;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public record AuthorSignature(
    String email,
    String login,
    ZonedDateTime when
) {
    public static final DateTimeFormatter DATE_FORMATTER  = DateTimeFormatter.ofPattern("XX");
    public String format(){
        final var timeStamp = when.toEpochSecond();
		final var timeZone = when.format(DATE_FORMATTER);

		return "%s <%s> %d %s".formatted(login, email, timeStamp, timeZone);
    }
    
}
