package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 社会福祉法人等利用者負担軽減テーブルの項目定義クラスです。
 */
public enum DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen implements IColumnDefinition {
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
     * 申請事由
     */
    shinseiJiyu(200, 0),
    /**
     * 生活保護受給有無
     * <br/>1：適用対象者
     * <br/>0：適用外
     */
    seihoJukyuUmu(1, 0),
    /**
     * 老齢福祉年金受給有無
     * <br/>1：適用対象者
     * <br/>0：適用外
     */
    roreiFukushiNenkinJukyuUmu(1, 0),
    /**
     * 生保扶助見直し特例有無
     * <br/>1：適用対象者
     * <br/>0：適用外
     */
    seihoFujoMinaoshiTokureiUmu(1, 0),
    /**
     * 軽減率（分子）
     */
    keigenritsu_Bunshi(4, 0),
    /**
     * 軽減率（分母）
     */
    keigenritsu_Bumbo(4, 0),
    /**
     * 居宅サービス限定
     * <br/>1：該当
     * <br/>0：非該当
     */
    kyotakuServiceGentei(1, 0),
    /**
     * 居住費・食費のみ
     * <br/>1：該当
     * <br/>0：非該当
     */
    kyojuhiShokuhiNomi(1, 0),
    /**
     * 旧措置者ユニット型個室のみ
     * <br/>1：該当
     * <br/>0：非該当
     */
    kyusochishaUnitTypeKoshitsuNomi(1, 0),
    /**
     * 確認番号
     */
    kakuninNo(8, 0),
    /**
     * 減免区分
     * <br/>非課税・老年受給
     * <br/>生保に準ずる
     * <br/>その他
     * <br/>生計困難
     * <br/>激変緩和
     */
    gemmenKubun(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen(int maxLength, int scale) {
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
