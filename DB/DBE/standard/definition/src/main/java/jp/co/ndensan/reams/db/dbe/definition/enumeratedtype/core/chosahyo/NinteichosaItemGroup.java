/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目グループを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaItemGroup implements INinteichosaItemGroup {

    /**
     * 調査項目グループが「なし」であることを表します。
     */
    なし("", "", "", false);
    private final RString no;
    private final RString name;
    private final RString shortName;
    private final boolean kihonChosaGroup;

    private NinteichosaItemGroup(String no, String name, String shortName, boolean kihonChosaGroup) {
        this.no = new RString(no);
        this.name = new RString(name);
        this.shortName = new RString(shortName);
        this.kihonChosaGroup = kihonChosaGroup;
    }

    @Override
    public RString getNo() {
        return no;
    }

    @Override
    public RString getName() {
        return name;
    }

    @Override
    public RString getShortName() {
        return shortName;
    }

    @Override
    public boolean isKihonChosaGroup() {
        return kihonChosaGroup;
    }
}
