/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OCRで取り込むイメージの分類です。
 */
public enum OcrImageClassification {

    調査票_概況調査 {
                @Override
                Matcher fileNameMatcher(CharSequence fileName) {
                    return Pattern.compile("C0.+\\.(png|PNG)").matcher(fileName);
                }
            },
    調査票_特記事項 {
                @Override
                Matcher fileNameMatcher(CharSequence fileName) {
                    return Pattern.compile("C(3|4).+\\.(png|PNG)").matcher(fileName);
                }
            },
    意見書_規定外_規定外ID {
                @Override
                Matcher fileNameMatcher(CharSequence fileName) {
                    return Pattern.compile("E.+\\.(png|PNG)").matcher(fileName);
                }
            },
    意見書_OCR {
                @Override
                Matcher fileNameMatcher(CharSequence fileName) {
                    return Pattern.compile("D.+\\.(png|PNG)").matcher(fileName);
                }
            },
    その他資料 {
                @Override
                Matcher fileNameMatcher(CharSequence fileName) {
                    return Pattern.compile("F.+\\.(png|PNG)").matcher(fileName);
                }
            };

    /**
     * @param fileName ファイルパス
     * @return 指定のファイルパスがバックアップファイルの物であるとき、{@code true}
     */
    abstract Matcher fileNameMatcher(CharSequence fileName);
}
