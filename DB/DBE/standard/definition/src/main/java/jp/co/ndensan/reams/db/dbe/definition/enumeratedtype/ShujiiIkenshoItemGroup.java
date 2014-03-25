/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目グループを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoItemGroup implements IShujiiIkenshoItemGroup {

    /**
     * 意見書項目グループが「なし」であることを表します。
     */
    なし("", "", "");
    private RString no;
    private RString name;
    private RString shortName;

    private ShujiiIkenshoItemGroup(String no, String name, String shortName) {
        this.no = new RString(no);
        this.name = new RString(name);
        this.shortName = new RString(shortName);
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
}
