/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRで取り込むファイルの種類の一覧です。
 */
public enum OcrDataType {

    /**
     * 調査票(csv, ca3)
     */
    調査票("OCRCHOSA.CSV", "OCRCHOSA.ca3"),
    /**
     * 意見書(csv, ca3)
     */
    意見書("OCRIKEN.CSV", "OCRIKEN.ca3"),
    /**
     * その他資料(csv, ca3)
     */
    その他資料("OCRSONOTA.CSV", "OCRSONOTA.ca3"),
    /**
     * 二次判定結果記入シート(csv, ca3)
     */
    二次判定結果記入シート("OCRSHINSA.CSV", "OCRSHINSA.ca3"),
    /**
     * イメージファイル(png)
     */
    イメージファイル {
                @Override
                boolean matches(RString filePath) {
                    return (filePath == null ? RString.EMPTY : filePath).toLowerCase().endsWith(".png");
                }
            },
    /**
     * 非該当（無関係のファイル）
     */
    非該当 {
                @Override
                boolean matches(RString filePath) {
                    List<OcrDataType> others = Arrays.asList(values());
                    others.removeAll(Arrays.asList(非該当));
                    for (OcrDataType value : others) {
                        if (value.matches(filePath)) {
                            return false;
                        }
                    }
                    return true;
                }
            };

    private final RString theCsvFileName;
    private final RString theCa3FileName;

    private OcrDataType(String csvFileName, String ca3FileName) {
        this.theCsvFileName = new RString(csvFileName);
        this.theCa3FileName = new RString(ca3FileName);
    }

    private OcrDataType() {
        this.theCsvFileName = RString.EMPTY;
        this.theCa3FileName = RString.EMPTY;
    }

    private RString csvFileName() {
        return this.theCsvFileName;
    }

    private RString ca3FileName() {
        return this.theCa3FileName;
    }

    boolean matches(RString filePath) {
        if (RString.isNullOrEmpty(filePath)) {
            return false;
        }
        RString filePathLC = filePath.toLowerCase();
        return filePathLC.endsWith(csvFileName().toLowerCase())
                || filePathLC.endsWith(ca3FileName().toLowerCase());
    }

    /**
     * @param filePath ファイルパス
     * @return 指定のファイルパスに該当する{@link OcrDataType}.
     */
    public static OcrDataType toValueFromFilePath(RString filePath) {
        List<OcrDataType> without非該当 = new ArrayList<>(Arrays.asList(values()));
        without非該当.removeAll(Arrays.asList(非該当));
        for (OcrDataType value : without非該当) {
            if (value.matches(filePath)) {
                return value;
            }
        }
        return 非該当;
    }
}
