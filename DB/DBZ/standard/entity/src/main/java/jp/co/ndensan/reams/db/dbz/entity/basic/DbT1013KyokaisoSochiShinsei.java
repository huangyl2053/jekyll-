package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1013KyokaisoSochiShinseiの項目定義クラスです
 *
 */
public enum DbT1013KyokaisoSochiShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shinseiYMD(2147483647, 0),
    shoriTimeStamp(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shinsei_HaishiKubun(1, 0),
    shinsei_HaishiYMD(2147483647, 0),
    hogoHuyoKonkyoGengakuKingaku(10, 0),
    kyokaisoShomeishoKofuYMD(2147483647, 0),
    kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(10, 0),
    kyojuhiKeigen_GengakuJikofutanGetsugaku(10, 0),
    kyojuhiKeigen_FutangendogakuDankaiCode(2, 0),
    shokuhiKeigen_GengakuJikofutanGetsugaku(10, 0),
    shokuhiKeigen_FutangendogakuDankaiCode(2, 0),
    riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(10, 0),
    hokenryoGengaku_GengakuJikofutanGetsugaku(10, 0),
    gengakuJikofutanGetsugakuGokeigaku(10, 0),
    kyukaisoSochiKetteiYMD(2147483647, 0),
    sochiGaito_HigaitoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT1013KyokaisoSochiShinsei(int maxLength, int scale) {
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
