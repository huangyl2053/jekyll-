package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3004KyodoShoriyoJukyushaIdoKogakuSofuの項目定義クラスです
 *
 */
public enum DbT3004KyodoShoriyoJukyushaIdoKogakuSofu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    idoYMD(2147483647, 0),
    idoKubunCode(1, 0),
    jukyushaIdoJiyu(2, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    setaiShuyakuNo(2147483647, 0),
    setaiShotokuKubunCode(1, 0),
    shotokuKubunCode(1, 0),
    roureiFukushiNenkinJukyuAriFlag(1, 0),
    riyoshaFutan2DankaiAriFlag(1, 0),
    shikyuShinseishoOutputAriFlag(1, 0),
    teiseiRenrakuhyoFlag(1, 0),
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofu(int maxLength, int scale) {
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
