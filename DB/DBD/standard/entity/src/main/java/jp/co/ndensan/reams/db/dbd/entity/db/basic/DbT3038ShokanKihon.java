package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求基本テーブルの項目定義クラスです。
 */
public enum DbT3038ShokanKihon implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 明細番号
     */
    meisaiNo(4, 0),
    /**
     * 旧措置入所者特例コード
     */
    kyuSochiNyushoshaTokureiCode(1, 0),
    /**
     * 居宅サービス計画作成区分コード
     */
    kyotakuServiceSakuseiKubunCode(1, 0),
    /**
     * 居宅サービス計画事業者番号
     */
    kyotakuserviceJigyoshaNo(2147483647, 0),
    /**
     * 開始年月日
     */
    kaishiYMD(2147483647, 0),
    /**
     * 中止年月日
     */
    chushiYMD(2147483647, 0),
    /**
     * 中止理由・入所（院）前の状況コード
     */
    chushiRiyuNyushomaeJyokyoCode(1, 0),
    /**
     * 入所（院）年月日
     */
    nyushoYMD(2147483647, 0),
    /**
     * 退所（院）年月日
     */
    taishoYMD(2147483647, 0),
    /**
     * 入所（院）実日数
     */
    nyushoJitsuNissu(5, 0),
    /**
     * 外泊日数
     */
    gaihakuNissu(5, 0),
    /**
     * 退所（院）後の状態コード
     */
    taishogoJotaiCode(1, 0),
    /**
     * 保険給付率
     */
    hokenKyufuritsu(2147483647, 0),
    /**
     * サービス単位数
     */
    serviceTanisu(10, 0),
    /**
     * 保険請求額
     */
    hokenSeikyugaku(9, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 緊急時施設療養費請求額
     */
    kinkyuShisetsuRyoyoSeikyugaku(9, 0),
    /**
     * 特定診療費請求額
     */
    tokuteiShinryoSeikyugaku(9, 0),
    /**
     * 特定入所者介護サービス費等請求額
     */
    tokuteiNyushoshaKaigoServiceSeikyugaku(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3038ShokanKihon(int maxLength, int scale) {
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
