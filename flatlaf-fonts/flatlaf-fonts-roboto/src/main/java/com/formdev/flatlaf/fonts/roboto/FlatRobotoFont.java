/*
 * Copyright 2022 FormDev Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.formdev.flatlaf.fonts.roboto;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

/**
 * The Roboto font family.
 * <p>
 * Font home page: <a href="https://fonts.google.com/specimen/Roboto">https://fonts.google.com/specimen/Roboto</a><br>
 * GitHub project: <a href="https://github.com/googlefonts/roboto">https://github.com/googlefonts/roboto</a>
 * <p>
 * To install the font, invoke following once (e.g. in your {@code main()} method; on AWT thread):
 * <pre>{@code
 * FlatRobotoFont.install();
 * }</pre>
 * <p>
 * Use as default font:
 * <pre>{@code
 * FlatLaf.setPreferredFontFamily( FlatRobotoFont.FAMILY );
 * FlatLaf.setPreferredLightFontFamily( FlatRobotoFont.FAMILY_LIGHT );
 * FlatLaf.setPreferredSemiboldFontFamily( FlatRobotoFont.FAMILY_SEMIBOLD );
 * }</pre>
 * <p>
 * Create fonts:
 * <pre>{@code
 * new Font( FlatRobotoFont.FAMILY, Font.PLAIN, 12 );
 * new Font( FlatRobotoFont.FAMILY, Font.ITALIC, 12 );
 * new Font( FlatRobotoFont.FAMILY, Font.BOLD, 12 );
 * new Font( FlatRobotoFont.FAMILY, Font.BOLD | Font.ITALIC, 12 );
 * new Font( FlatRobotoFont.FAMILY_LIGHT, Font.PLAIN, 12 );
 * new Font( FlatRobotoFont.FAMILY_LIGHT, Font.ITALIC, 12 );
 * new Font( FlatRobotoFont.FAMILY_SEMIBOLD, Font.PLAIN, 12 );
 * new Font( FlatRobotoFont.FAMILY_SEMIBOLD, Font.ITALIC, 12 );
 * }</pre>
 *
 * @author Karl Tauber
 */
public class FlatRobotoFont
{
	/**
	 * Family name for basic styles (regular, italic and bold).
	 * <p>
	 * Usage:
	 * <pre>{@code
	 * new Font( FlatRobotoFont.FAMILY, Font.PLAIN, 12 );
	 * new Font( FlatRobotoFont.FAMILY, Font.ITALIC, 12 );
	 * new Font( FlatRobotoFont.FAMILY, Font.BOLD, 12 );
	 * new Font( FlatRobotoFont.FAMILY, Font.BOLD | Font.ITALIC, 12 );
	 * }</pre>
	 */
	public static final String FAMILY = "Roboto";

	/**
	 * Family name for light styles.
	 * <p>
	 * Usage:
	 * <pre>{@code
	 * new Font( FlatRobotoFont.FAMILY_LIGHT, Font.PLAIN, 12 );
	 * new Font( FlatRobotoFont.FAMILY_LIGHT, Font.ITALIC, 12 );
	 * }</pre>
	 */
	public static final String FAMILY_LIGHT = "Roboto Light";

	/**
	 * Family name for semibold styles.
	 * <p>
	 * Usage:
	 * <pre>{@code
	 * new Font( FlatRobotoFont.FAMILY_SEMIBOLD, Font.PLAIN, 12 );
	 * new Font( FlatRobotoFont.FAMILY_SEMIBOLD, Font.ITALIC, 12 );
	 * }</pre>
	 */
	public static final String FAMILY_SEMIBOLD = "Roboto Medium";

	/**
	 * Use for {@link #installStyle(String)} to install single font style.
	 */
	public static final String
		// basic styles
		STYLE_REGULAR = "Roboto-Regular.ttf",
		STYLE_ITALIC = "Roboto-Italic.ttf",
		STYLE_BOLD = "Roboto-Bold.ttf",
		STYLE_BOLD_ITALIC = "Roboto-BoldItalic.ttf",

		// light
		STYLE_LIGHT = "Roboto-Light.ttf",
		STYLE_LIGHT_ITALIC = "Roboto-LightItalic.ttf",

		// semibold
		STYLE_SEMIBOLD = "Roboto-Medium.ttf",
		STYLE_SEMIBOLD_ITALIC = "Roboto-MediumItalic.ttf";


	private FlatRobotoFont() {}

	/**
	 * Creates and registers the fonts for all styles.
	 */
	public static void install() {
		// basic styles
		installStyle( STYLE_REGULAR );
		installStyle( STYLE_ITALIC );
		installStyle( STYLE_BOLD );
		installStyle( STYLE_BOLD_ITALIC );

		// light
		installStyle( STYLE_LIGHT );
		installStyle( STYLE_LIGHT_ITALIC );

		// semibold
		installStyle( STYLE_SEMIBOLD );
		installStyle( STYLE_SEMIBOLD_ITALIC );
	}

	/**
	 * Creates and registers the font for the given style.
	 * See {@code STYLE_} constants.
	 */
	public static boolean installStyle( String name ) {
		try( InputStream in = FlatRobotoFont.class.getResourceAsStream( name ) ) {
			Font font = Font.createFont( Font.TRUETYPE_FONT, in );
			return GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont( font );
		} catch( FontFormatException ex ) {
			ex.printStackTrace();
			return false;
		} catch( IOException ex ) {
			ex.printStackTrace();
			return false;
		}
	}
}
