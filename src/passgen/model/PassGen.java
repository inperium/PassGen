package passgen.model;

import java.util.Random;

import passgen.controller.PassGenController;

public class PassGen {

	private PassGenController passGenController;

	private Random random;

	private int[] lowerCaseLetters;
	private int[] upperCaseLetters;
	private int[] numbers;
	private int[] specialCharacters;

	public PassGen(PassGenController passGenController) {
		this.passGenController = passGenController;
		this.random = new Random();

		this.lowerCaseLetters = new int[26];
		this.upperCaseLetters = new int[26];
		this.numbers = new int[10];
		this.specialCharacters = new int[13];

		this.generatePasswordArrays();

	}

	private void generatePasswordArrays() {
		for (int index = 97; index <= 122; index++) {
			this.lowerCaseLetters[index - 97] = index;
		}

		for (int index = 65; index <= 90; index++) {
			this.upperCaseLetters[index - 65] = index;

		}

		for (int index = 0; index < 10; index++) {
			this.numbers[index] = index;
		}

		for (int index = 33; index <= 45; index++) {
			this.specialCharacters[index - 33] = index;
		}
	}

	public String getRandomPassword(int jSliderValue, boolean lowerCase, boolean upperCase, boolean numbers, boolean special) {
		String randomPassword = "";
		for (int index = 0; index < jSliderValue; index++) {
			int passwordLength = randomPassword.length();

			int randomNumber = this.random.nextInt(4);

			if (lowerCase && randomNumber == 0) {
				randomPassword += String.valueOf((char) this.getRandomFromArray(this.lowerCaseLetters));
			} else if (upperCase && randomNumber == 1) {
				randomPassword += String.valueOf((char) this.getRandomFromArray(this.upperCaseLetters));
			} else if (numbers && randomNumber == 2) {
				randomPassword += String.valueOf(this.getRandomFromArray(this.numbers));
			} else if (special && randomNumber == 3) {
				randomPassword += String.valueOf((char) this.getRandomFromArray(this.specialCharacters));
			}

			if (randomPassword.length() == passwordLength) {
				randomPassword += String.valueOf((char) this.getRandomFromArray(this.lowerCaseLetters));
			}
		}
		return randomPassword;
	}

	private int getRandomFromArray(int[] numbers) {
		return (int) numbers[this.random.nextInt(numbers.length)];
	}

}
