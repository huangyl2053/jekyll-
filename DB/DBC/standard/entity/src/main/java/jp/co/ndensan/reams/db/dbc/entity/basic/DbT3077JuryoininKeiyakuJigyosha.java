package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3077JuryoininKeiyakuJigyoshaの項目定義クラスです
 *
 */
public enum DbT3077JuryoininKeiyakuJigyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshaKeiyakuNo(10, 0),
    kaishiYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    shuryoYMD(2147483647, 0),
    todokedeYMD(2147483647, 0),
    todokedeAddress(100, 0),
    todokedeJigyoshaName(20, 0),
    todokedeDaihyoshaName(30, 0),
    shikibetsuCode(2147483647, 0),
    jigyoshaFaxNo(2147483647, 0),
    keiyakuTorokuYMD(2147483647, 0),
    sofusakiBusho(80, 0),
    eigyoKeitai(1, 0),
    jutakuKaishuKeiyakuUmu(1, 0),
    tokuteiFukushiYoguHanbaiKeiyakuUmu(1, 0),
    shokanbaraiKyufuKeiyakuUmu(1, 0),
    kogakuKyufuKeiyakuUmu(1, 0),
    keiyakuJigyoshaNo(2147483647, 0),
    toriatsukaiKakuyakushoUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3077JuryoininKeiyakuJigyosha(int maxLength, int scale) {
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
