/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.io.File;
import java.io.IOException;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR取込処理で用いるユーティリティです。
 */
public final class OcrTorikomiUtil {

    private OcrTorikomiUtil() {
    }

    /**
     * 指定の共有ファイルエントリを取得し、かつ、それが保持する複数のファイルパスを種類毎に分類して返します。
     *
     * @param rosfd 対象の共有ファイルを指示する{@link ReadOnlySharedFileDescriptor}
     * @return 種類毎に分類されたファイルパスの{@link Map}
     */
    public static Map<OcrDataType, OcrFiles> copyToLocalAndGroupingByType(ReadOnlySharedFileEntryDescriptor rosfd) {
        return groupingByType(readAllOcrDataFileTo(Directory.createTmpDirectory(), rosfd));
    }

    private static List<RString> readAllOcrDataFileTo(RString tempDirPath, ReadOnlySharedFileEntryDescriptor rosfd) {
        File tempDir = new File(tempDirPath.toString());
        SharedFile.copyToLocal(rosfd, new FilesystemPath(tempDirPath));
        return setFilePath(tempDir);
    }

    private static List<RString> setFilePath(File directory) {
        List<RString> list = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try {
                    list.add(new RString(file.getCanonicalPath()));
                } catch (IOException ex) {
                }
            } else {
                list.addAll(setFilePath(file));
            }
        }
        return list;
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
