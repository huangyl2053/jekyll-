/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ イメージ取込み Processパラメタです。
 *
 * @author n8429
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrImageReadProcessParameter implements IBatchProcessParameter {

    @lombok.Getter
    private final RDate 処理日;
    @lombok.Getter
    private final RString ファイルPath;
    @lombok.Getter
    private final List<RString> imageFilePaths;

    private final Map<RString, RString> imageFilePathMap;
    private static final RString PATH_SEPARATOR;

    static {
        PATH_SEPARATOR = new RString(File.separator);
    }

    /**
     *
     * @param 処理日
     * @param ファイルPath ファイルPath
     * @param imageFilePaths 全イメージファイルのPath
     */
    public OcrImageReadProcessParameter(
            RDate 処理日,
            RString ファイルPath,
            List<RString> imageFilePaths
    ) {
        this.処理日 = 処理日;
        this.ファイルPath = ファイルPath;
        this.imageFilePaths = Collections.unmodifiableList(imageFilePaths);
        imageFilePathMap = toMap(imageFilePaths);
    }

    private static Map<RString, RString> toMap(List<? extends RString> filePaths) {
        Map<RString, RString> map = new HashMap<>();
        for (RString path : filePaths) {
            RString key = path.substringEmptyOnError(path.lastIndexOf(PATH_SEPARATOR) + 1);
            map.put(key, path);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 指定のファイル名（ディレクトリのパスは含まない）のPNG画像について、絶対パスを返します。
     *
     * 存在しない場合、{@link RString#EMPTY}を返します。
     *
     * @param fileName ファイル名（ディレクトリのパスは含まない）
     * @return 絶対パス
     */
    public RString getImageFilePathFromName(RString fileName) {
        RString path = this.imageFilePathMap.get(fileName);
        return path == null ? RString.EMPTY : path;
    }
}
