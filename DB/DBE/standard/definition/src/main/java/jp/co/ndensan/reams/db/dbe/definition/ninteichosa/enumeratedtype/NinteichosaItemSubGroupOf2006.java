/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目サブグループ（2006年改定版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaItemSubGroupOf2006 implements INinteichosaItemSubGroup {

    /**
     * 調査項目サブグループが「麻痺」であることを表します。
     */
    麻痺("1", "１．麻痺", "麻痺", true),
    /**
     * 調査項目サブグループが「拘縮」であることを表します。
     */
    拘縮("2", "２．拘縮", "拘縮", true);
    private RString no;
    private RString name;
    private RString shortName;
    private boolean multiSelectable;

    private NinteichosaItemSubGroupOf2006(String no, String name, String shortName, boolean multiSelectable) {
        this.no = new RString(no);
        this.name = new RString(name);
        this.shortName = new RString(shortName);
        this.multiSelectable = multiSelectable;
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
    public boolean isMultiSelectable() {
        return multiSelectable;
    }
}
