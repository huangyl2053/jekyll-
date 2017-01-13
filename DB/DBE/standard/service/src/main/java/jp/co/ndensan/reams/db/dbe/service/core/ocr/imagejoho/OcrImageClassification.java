/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho;

import java.util.regex.Pattern;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRで取り込むイメージの分類です。
 */
public enum OcrImageClassification {

    調査票_概況調査 {
                @Override
                boolean matchesBackupFileName(CharSequence fileName) {
                    return fileName.toString().contains(new RString("C0007_BAK"));
                }
            },
    調査票_特記事項 {
                @Override
                boolean matchesBackupFileName(CharSequence fileName) {
                    return Pattern.compile("C(3|4).+_BAK\\.(png|PNG)").matcher(fileName).find();
                }
            },
    意見書_規定外_規定外ID {
                @Override
                boolean matchesBackupFileName(CharSequence fileName) {
                    return Pattern.compile("E.+_BAK\\.(png|PNG)").matcher(fileName).find();
                }
            },
    意見書_OCR {
                @Override
                boolean matchesBackupFileName(CharSequence fileName) {
                    return Pattern.compile("D.+_BAK\\.(png|PNG)").matcher(fileName).find();
                }
            },
    その他資料 {
                @Override
                boolean matchesBackupFileName(CharSequence fileName) {
                    return Pattern.compile("F.+_BAK\\.(png|PNG)").matcher(fileName).find();
                }
            };

    /**
     * @param fileName ファイルパス
     * @return 指定のファイルパスがバックアップファイルの物であるとき、{@code true}
     */
    boolean matchesBackupFileName(CharSequence fileName) {
        return false;
    }
}
