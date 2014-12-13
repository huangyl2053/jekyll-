package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3038ShokanKihonの項目定義クラスです
 *
 */
public enum DbT3038ShokanKihon implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNp(10, 0),
    jigyoshaNo(2147483647, 0),
    yoshikiNo(4, 0),
    shoriTimestamp(2147483647, 0),
    kyuSochiNyushoshaTokureiCode(1, 0),
    kyotakuServiceSakuseiKubunCode(1, 0),
    kyotakuserviceJigyoshaNo(2147483647, 0),
    kaishiYMD(2147483647, 0),
    chushiYMD(2147483647, 0),
    chushiRiyuNyushomaeJyokyoCode(1, 0),
    nyushoYMD(2147483647, 0),
    taishoYMD(2147483647, 0),
    nyushoJitsuNissu(5, 0),
    gaihakuNissu(5, 0),
    taishogoJotaiCode(1, 0),
    hokenKyufuritsu(2147483647, 0),
    serviceTanisu(10, 0),
    hokenSeikyugaku(9, 0),
    riyoshaFutangaku(10, 0),
    kinkyuShisetsuRyoyoSeikyugaku(9, 0),
    tokuteiShinryoSeikyugaku(9, 0),
    tokuteiNyushoshaKaigoServiceSeikyugaku(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3038ShokanKihon(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
