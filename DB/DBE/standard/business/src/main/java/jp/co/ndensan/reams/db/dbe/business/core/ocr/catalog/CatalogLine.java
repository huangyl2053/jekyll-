/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * カタログファイル1行を読み取った結果の値を保持します。
 */
public final class CatalogLine {

    private static final RString MS_PATH_SEPARATOR = new RString("\\");
    private static final int INDEX_OF_CHOHYO_REMBAN = 3;
    private final RString rawValue;
    private final RString model;
    private final RString chohyoRemban;
    private final List<RString> imageFileNames;

    /**
     * @param line 1行の内容
     */
    public CatalogLine(RString line) {
        this.rawValue = line;
        List<RString> splitted = line.split(",");
        this.model = splitted.isEmpty() ? RString.EMPTY : splitted.get(0);
        this.chohyoRemban = (splitted.size() < INDEX_OF_CHOHYO_REMBAN + 1) ? RString.EMPTY : splitted.get(INDEX_OF_CHOHYO_REMBAN);
        this.imageFileNames = toImageFileNames(splitted);
    }

    private static List<RString> toImageFileNames(List<RString> splitted) {
        List<RString> fileNames = new ArrayList<>();
        for (RString column : splitted) {
            if (!column.contains(MS_PATH_SEPARATOR)) {
                continue;
            }
            RString fileName = toFileNameRemovingFolderPath(column);
            fileNames.add(fileName);
        }
        return fileNames;
    }

    private static RString toFileNameRemovingFolderPath(RString fileName) {
        return fileName.substringEmptyOnError(fileName.lastIndexOf(MS_PATH_SEPARATOR) + 1);
    }

    /**
     * @return 未編集の値
     */
    public RString getRawValue() {
        return this.rawValue;
    }

    /**
     * @return モデルの名称
     */
    public RString getモデル名() {
        return model;
    }

    /**
     * @return 帳票一連ID（下8桁）
     */
    public RString get帳票一連ID下8桁() {
        return chohyoRemban;
    }

    /**
     * @return イメージファイル名
     */
    public List<RString> getImageFileNames() {
        return new ArrayList<>(this.imageFileNames);
    }
}
