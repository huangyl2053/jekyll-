package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（特記情報）（子）テーブルの項目定義クラスです。
 */
public enum DbT4205NinteichosahyoTokkijikoChild implements IColumnDefinition {
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
    shinseishoKanriNo(11, 0),
    /**
     * 認定調査依頼履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * 認定調査特記事項番号
     */
    ninteichosaTokkijikoNo(3, 0),
    /**
     * 認定調査特記事項連番
     */
    ninteichosaTokkijikoRenban(1, 0),
    /**
     * 特記事項テキスト・イメージ区分
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     */
    tokkijikoTextImageKubun(1, 0),
    /**
     * 原本マスク区分
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     */
    genponMaskKubun(2147483647, 0),
    /**
     * 特記事項
     */
    tokkiJiko(512, 0),
    /**
     * 特記事項イメージ共有ファイルID
     */
    tokkiJikoImageSharedFileId(29, 0),
    /**
     * 特記事項マスキングイメージ共有ファイルID
     */
    tokkiJikoMaskingImageSharedFileId(29, 0);

    private final int maxLength;
    private final int scale;

    private DbT4205NinteichosahyoTokkijikoChild(int maxLength, int scale) {
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
