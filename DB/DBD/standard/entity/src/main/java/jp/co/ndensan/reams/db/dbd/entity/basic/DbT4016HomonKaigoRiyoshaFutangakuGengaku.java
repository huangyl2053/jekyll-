package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 訪問介護利用者負担額減額テーブルの項目定義クラスです。
 */
public enum DbT4016HomonKaigoRiyoshaFutangakuGengaku implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 法別区分
     * <br/>施行時ホームヘルプ(56)
     * <br/>障害時ホームヘルプ(57)
     * <br/>障害ヘルプ全額免除(58)
     */
    hobetsuKubun(2, 0),
    /**
     * 障害者手帳有無
     * <br/>1：有
     * <br/>0：無
     */
    shogaishaTechoUmu(1, 0),
    /**
     * 障害者手帳等級
     */
    shogaishaTechoTokyu(2, 0),
    /**
     * 障害者手帳番号
     */
    shogaishaTechoNo(7, 0),
    /**
     * 障害者手帳交付年月日
     */
    shogaishaTechoKofuYMD(2147483647, 0),
    /**
     * 申請事由
     */
    shinseiJiyu(200, 0),
    /**
     * 給付率
     */
    kyufuritsu(2147483647, 0),
    /**
     * 公費負担者番号
     */
    kohiFutanshaNo(8, 0),
    /**
     * 公費受給者番号
     */
    kohiJukyushaNo(7, 0);

    private final int maxLength;
    private final int scale;

    private DbT4016HomonKaigoRiyoshaFutangakuGengaku(int maxLength, int scale) {
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
