/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任事業者が持つ届出者情報のクラスです。
 *
 * @author N3317 塚田 萌
 */
public class Todokedesha {

    private final RString 住所;
    private final RString 事業者名称;
    private final RString 代表者氏名;

    /**
     * コンストラクタです。
     *
     * @param 住所 住所
     * @param 事業者名称 事業者名称
     * @param 代表者氏名 事業者名称
     */
    public Todokedesha(RString 住所, RString 事業者名称, RString 代表者氏名) {
        this.住所 = 住所;
        this.事業者名称 = 事業者名称;
        this.代表者氏名 = 代表者氏名;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return 事業者名称;
    }

    /**
     * 代表者氏名を返します。
     *
     * @return 代表者氏名
     */
    public RString get代表者氏名() {
        return 代表者氏名;
    }
}
