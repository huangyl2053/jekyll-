package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 利用者負担割合テーブルの項目定義クラスです。
 */
public enum DbT3113RiyoshaFutanWariai implements IColumnDefinition {
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
     * 年度
     */
    nendo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 発行不要フラグ
     */
    hakoFuyoFlag(1, 0),
    /**
     * 職権変更フラグ
     */
    shokenFlag(1, 0),
    /**
     * 判定日
     */
    hanteiYMD(2147483647, 0),
    /**
     * 判定区分
     * <br/>1：年次判定　2：異動分判定　3：過年度分判定　3：即時更正
     */
    hanteiKubun(1, 0),
    /**
     * 更正事由
     * <br/>コードマスタ（DBD　種別=999）
     * <br/>00：当初（継続、新規認定）
     * <br/>10：本人所得更正
     * <br/>20：世帯員所得更正
     * <br/>30：世帯構成変更
     * <br/>40: その他（即時判定など）
     */
    koseiJiyu(2147483647, 0),
    /**
     * 発行区分
     * <br/>0：未発行
     * <br/>1：一括発行で発行済み。
     * <br/>2：単票発行で発行済み。
     */
    hakoKubun(1, 0),
    /**
     * 発行日
     */
    hakoYMD(2147483647, 0),
    /**
     * 交付日
     */
    kofuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3113RiyoshaFutanWariai(int maxLength, int scale) {
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
