package pl.markowski.konrad.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.passay.*;

public class RandomUtils {

    public static String getRandomEmailPrefix(){
        return RandomStringUtils.randomAlphabetic(5,10).toLowerCase();
    }

    public static String getValidPassword(String emailPrefix){
        PasswordGenerator gen = new PasswordGenerator();

        CharacterData emailChar = new CharacterData() {
            @Override
            public String getErrorCode() {
                return null;
            }

            @Override
            public String getCharacters() {
                return emailPrefix;
            }
        };
        CharacterRule emailRule = new CharacterRule(emailChar);
        emailRule.setNumberOfCharacters(1);

        CharacterData upperCaseChar = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChar);
        upperCaseRule.setNumberOfCharacters(1);

        CharacterData digitChar = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChar);
        digitRule.setNumberOfCharacters(1);

        CyrillicCharacterData cyrillicChar = CyrillicCharacterData.LowerCase;
        CharacterRule cyrillicRule = new CharacterRule(cyrillicChar);
        cyrillicRule.setNumberOfCharacters(1);

        CharacterData lowerCaseChar = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChar);
        lowerCaseRule.setNumberOfCharacters(6);

        return gen.generatePassword(10,emailRule,upperCaseRule,digitRule,cyrillicRule,lowerCaseRule);
    }

    public static String getInvalidPassword(){
        return RandomStringUtils.randomAlphabetic(10);
    }
}
