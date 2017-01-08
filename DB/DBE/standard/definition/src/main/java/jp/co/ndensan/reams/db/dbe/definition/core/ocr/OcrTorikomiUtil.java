/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR取込処理で用いるユーティリティです。
 */
public final class OcrTorikomiUtil {

    private OcrTorikomiUtil() {
    }

    private enum FileExtentions {

        CSV(".csv"),
        CA3(".ca3"),
        PNG(".png");

        private final RString lowerCase;

        private FileExtentions(String lowerCase) {
            this.lowerCase = new RString(lowerCase);
        }

        private RString asLowerCase() {
            return this.lowerCase;
        }
    }

    /**
     * 指定のファイル名もしくはファイルパスがcsvファイルの物であれば{@code true}、そうでなければ{@code false}を返します。
     *
     * @param fileName ファイル名もしくはファイルパス
     * @return fileNameがcsvファイルの物であれば{@code true}、 そうでなければ{@code false}.
     */
    public static boolean isCsvFile(RString fileName) {
        return fileName.toLowerCase().endsWith(FileExtentions.CSV.asLowerCase());
    }

    /**
     * 指定のファイル名もしくはファイルパスがca3ファイルの物であれば{@code true}、そうでなければ{@code false}を返します。
     *
     * @param fileName ファイル名もしくはファイルパス
     * @return fileNameがca3ファイルの物であれば{@code true}、 そうでなければ{@code false}.
     */
    public static boolean isCa3File(RString fileName) {
        return fileName.toLowerCase().endsWith(FileExtentions.CA3.asLowerCase());
    }

    /**
     * 指定のファイル名もしくはファイルパスがpngファイルの物であれば{@code true}、そうでなければ{@code false}を返します。
     *
     * @param fileName ファイル名もしくはファイルパス
     * @return fileNameがpngファイルの物であれば{@code true}、 そうでなければ{@code false}.
     */
    public static boolean isPngFile(RString fileName) {
        return fileName.toLowerCase().endsWith(FileExtentions.PNG.asLowerCase());
    }

    /**
     * 指定の複数のファイルパスを種類毎に分類します。
     *
     * @param filePaths ファイルパスのリスト
     * @return 種類毎に分類されたファイルパスの{@link Map}
     */
    public static Map<OcrDataType, OcrFiles> groupingByType(Iterable<? extends RString> filePaths) {
        Map<OcrDataType, List<RString>> map = new HashMap<>();
        for (OcrDataType odc : OcrDataType.values()) {
            map.put(odc, new ArrayList<RString>());
        }
        for (RString filePath : filePaths) {
            OcrDataType odc = OcrDataType.toValueFromFilePath(filePath);
            map.get(odc).add(filePath);
        }
        return toOcrFilesMap(map);
    }

    private static Map<OcrDataType, OcrFiles> toOcrFilesMap(Map<OcrDataType, List<RString>> input) {
        Map<OcrDataType, OcrFiles> output = new HashMap<>();
        for (Map.Entry<OcrDataType, List<RString>> entry : input.entrySet()) {
            output.put(entry.getKey(), new OcrFiles(entry.getValue()));
        }
        return output;
    }
}
