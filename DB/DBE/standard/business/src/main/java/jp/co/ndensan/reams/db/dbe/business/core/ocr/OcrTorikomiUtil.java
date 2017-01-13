/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.FileNameConvertionTheories;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * OCR取込処理で用いるユーティリティです。
 */
public final class OcrTorikomiUtil {

    private static final RString PATH_SEPARATOR = new RString(File.separator);

    private OcrTorikomiUtil() {
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

    /**
     * 指定のフォルダに指定のファイルをコピーします。
     * ファイル名のフルパスは、指定の{@link OcrFiles imageFiles}より取得します。
     * ファイル名の変換ルールは、{@link FileNameConvertionTheories}にて指定します。
     *
     * @param directoryPath コピー先ディレクトリのパス
     * @param imageFileNames コピー対象のファイル
     * @param imageFiles 全イメージファイルのパス
     * @param converter {@link FileNameConvertionTheories}
     * @return コピーに成功した場合、{@code true}.
     */
    public static boolean copyImageFilesToDirectory(RString directoryPath, List<RString> imageFileNames,
            OcrFiles imageFiles, IFileNameConvertionTheory converter) {
        if (imageFileNames == null || imageFileNames.isEmpty()) {
            return false;
        }
        for (RString imageFileName : imageFileNames) {
            RString path = imageFiles.findFilePathFromName(imageFileName);
            if (RString.isNullOrEmpty(path)) {
                //TODO ca3ファイルから読み取ったファイル名に該当するイメージがアップロードファイル中に見つからない場合、ここに制御が移る。
                //入力ファイル不正の可能性あり。適切な処理の検討が必要。
                continue;
            }
            RString newFilePath = new RStringBuilder(directoryPath).append(PATH_SEPARATOR).append(converter.convert(imageFileName)).toRString();
            File.copy(path, newFilePath);
        }
        return true;
    }
}
