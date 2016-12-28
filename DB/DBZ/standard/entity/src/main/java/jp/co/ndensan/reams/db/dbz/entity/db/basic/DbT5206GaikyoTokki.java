package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（概況特記）テーブルの項目定義クラスです。
 */
public enum DbT5206GaikyoTokki implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 概況特記テキスト・イメージ区分
     * <br/>Enum（DBE：特記事項テキスト・イメージ区分）1:テキスト 2:イメージ
     */
    gaikyoTokkiTextImageKubun(1, 0),
    /**
     * 原本マスク区分
     * <br/>Enum（DBE：原本マスク区分）1:原本  2:マスク
     */
    genponMaskKubun(2147483647, 0),
    /**
     * 住宅改修（改修箇所）
     */
    jutakuKaishu(2147483647, 0),
    /**
     * 市町村特別給付サービス種類名
     */
    tokubetsuKyufuService(2147483647, 0),
    /**
     * 介護保険給付以外の在宅サービス種類名
     */
    zaitakuService(2147483647, 0),
    /**
     * 概況特記事項（主訴）
     */
    shuso(2147483647, 0),
    /**
     * 概況特記事項（家族状況）
     */
    kazokuJokyo(2147483647, 0),
    /**
     * 概況特記事項（居住環境）
     */
    kyojuKankyo(2147483647, 0),
    /**
     * 概況特記事項（機器・器械）
     */
    kikaiKiki(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5206GaikyoTokki(int maxLength, int scale) {
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
