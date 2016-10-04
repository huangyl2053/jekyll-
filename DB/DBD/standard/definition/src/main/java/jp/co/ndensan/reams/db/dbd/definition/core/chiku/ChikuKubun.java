/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.chiku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区区分を表す列挙型です。
 *
 * @reamsid_L DBD-1790-010 donghj
 */
public enum ChikuKubun {

    /**
     * コード:1 名称:全て 略称:ALL
     */
    全て("1", "全て", "ALL"),
    /**
     * コード:2 名称:住所 略称:JUSHO
     */
    住所("2", "住所", "JUSHO"),
    /**
     * コード:3 名称:行政区 略称:GYOSEIKU
     */
    行政区("3", "行政区", "GYOSEIKU"),
    /**
     * コード:4 名称:組合 略称:CHIKU2
     */
    組合("4", "組合", "CHIKU2"),
    /**
     * コード:5 名称:旧市町村（個別） 略称:KYU-KOBETSU
     */
    旧市町村_個別("5", "旧市町村（個別）", "KYU-KOBETSU"),
    /**
     * コード:6 名称:旧市町村（全て） 略称:KYU-ALL
     */
    旧市町村_全て("6", "旧市町村（全て）", "KYU-ALL");

    private final RString code;
    private final RString kanjiName;
    private final RString name;

    private ChikuKubun(String code, String kanjiName, String name) {
        this.code = new RString(code);
        this.kanjiName = new RString(kanjiName);
        this.name = new RString(name);
    }

    /**
     * 地区区分のコードを返します。
     *
     * @return 地区区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 地区区分の漢字名称を返します。
     *
     * @return 地区区分の漢字名称
     */
    public RString get漢字名称() {
        return kanjiName;
    }

    /**
     * 地区区分の名称を返します。
     *
     * @return 地区区分の名称
     */
    public RString get名称() {
        return name;
    }

    /**
     * 地区区分のコードと一致する内容を探します。
     *
     * @param code 地区区分のコード
     * @return {@code code} に対応する地区区分
     */
    public static ChikuKubun toValue(RString code) {
        for (ChikuKubun value : ChikuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("地区区分"));
    }

}
