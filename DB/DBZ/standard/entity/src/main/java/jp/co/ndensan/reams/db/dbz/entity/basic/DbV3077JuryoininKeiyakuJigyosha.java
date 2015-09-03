package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受領委任事業者Aliveテーブルの項目定義クラスです。
 */
public enum DbV3077JuryoininKeiyakuJigyosha implements IColumnDefinition {
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
     * jigyoshaKeiyakuNo
     */
    jigyoshaKeiyakuNo(10, 0),
    /**
     * kaishiYMD
     */
    kaishiYMD(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * shuryoYMD
     */
    shuryoYMD(2147483647, 0),
    /**
     * todokedeYMD
     */
    todokedeYMD(2147483647, 0),
    /**
     * todokedeAddress
     */
    todokedeAddress(100, 0),
    /**
     * todokedeJigyoshaName
     */
    todokedeJigyoshaName(20, 0),
    /**
     * todokedeDaihyoshaName
     */
    todokedeDaihyoshaName(30, 0),
    /**
     * kozaShubetsu
     */
    kozaShubetsu(1, 0),
    /**
     * kozaNo
     */
    kozaNo(2147483647, 0),
    /**
     * tsuchoKigo
     */
    tsuchoKigo(2147483647, 0),
    /**
     * tsuchoNo
     */
    tsuchoNo(2147483647, 0),
    /**
     * kozaMeiginin
     */
    kozaMeiginin(2147483647, 0),
    /**
     * kozaMeigininKanji
     */
    kozaMeigininKanji(2147483647, 0),
    /**
     * jigyoshaFaxNo
     */
    jigyoshaFaxNo(2147483647, 0),
    /**
     * keiyakuTorokuYMD
     */
    keiyakuTorokuYMD(2147483647, 0),
    /**
     * sofusakiBusho
     */
    sofusakiBusho(80, 0),
    /**
     * eigyoKeitai
     */
    eigyoKeitai(1, 0),
    /**
     * jutakuKaishuKeiyakuUmu
     */
    jutakuKaishuKeiyakuUmu(1, 0),
    /**
     * tokuteiFukushiYoguHanbaiKeiyakuUmu
     */
    tokuteiFukushiYoguHanbaiKeiyakuUmu(1, 0),
    /**
     * shokanbaraiKyufuKeiyakuUmu
     */
    shokanbaraiKyufuKeiyakuUmu(1, 0),
    /**
     * kogakuKyufuKeiyakuUmu
     */
    kogakuKyufuKeiyakuUmu(1, 0),
    /**
     * keiyakuJigyoshaNo
     */
    keiyakuJigyoshaNo(2147483647, 0),
    /**
     * toriatsukaiKakuyakushoUmu
     */
    toriatsukaiKakuyakushoUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV3077JuryoininKeiyakuJigyosha(int maxLength, int scale) {
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
