package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（概況特記）（子）テーブルの項目定義クラスです。
 */
public enum DbT4206GaikyoTokkiChild implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 認定調査依頼履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * 概況特記事項（主訴）
     */
    shuso(2147483647, 0),
    /**
     * 概況特記（主訴）イメージ共有ファイルID
     */
    shusoImageSharedFileId(29, 0),
    /**
     * 概況特記（主訴）マスキングイメージ共有ファイルID
     */
    shusoMaskingImageSharedFileId(29, 0),
    /**
     * 概況特記事項（家族状況）
     */
    kazokuJokyo(2147483647, 0),
    /**
     * 概況特記（家族状況）イメージ共有ファイルID
     */
    kazokuJokyoImageSharedFileId(29, 0),
    /**
     * 概況特記（家族状況）マスキングイメージ共有ファイルID
     */
    kazokuJokyoMaskingImageSharedFileId(29, 0),
    /**
     * 概況特記事項（居住環境）
     */
    kyojuKankyo(2147483647, 0),
    /**
     * 概況特記（居住環境）イメージ共有ファイルID
     */
    kyojuKankyoImageSharedFileId(29, 0),
    /**
     * 概況特記（居住環境）マスキングイメージ共有ファイルID
     */
    kyojuKankyoMaskingImageSharedFileId(29, 0),
    /**
     * 概況特記事項（機器・器械）
     */
    kikaiKiki(2147483647, 0),
    /**
     * 概況特記（機器・器械）イメージ共有ファイルID
     */
    kikaiKikiImageSharedFileId(29, 0),
    /**
     * 概況特記（機器・器械）マスキングイメージ共有ファイルID
     */
    kikaiKikiMaskingImageSharedFileId(29, 0);

    private final int maxLength;
    private final int scale;

    private DbT4206GaikyoTokkiChild(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
