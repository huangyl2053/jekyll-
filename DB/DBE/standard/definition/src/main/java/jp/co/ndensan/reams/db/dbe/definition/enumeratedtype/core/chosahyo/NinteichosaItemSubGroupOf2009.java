/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目サブグループ（2009年改訂版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaItemSubGroupOf2009 implements INinteichosaItemSubGroup {

    /**
     * 調査項目サブグループが「麻痺等の有無」であることを表します。
     */
    麻痺等の有無("1-1", "1-1 麻痺等の有無(複数回答可)", "麻痺等の有無", true),
    /**
     * 調査項目サブグループが「拘縮の有無」であることを表します。
     */
    拘縮の有無("1-2", "1-2 拘縮の有無(複数回答可)", "拘縮の有無", true),
    /**
     * 調査項目サブグループが「処置内容」であることを表します。
     */
    処置内容("6", "処置内容", "処置内容", true),
    /**
     * 調査項目サブグループが「特別な対応」であることを表します。
     */
    特別な対応("6", "特別な対応", "特別な対応", true);
    private final RString no;
    private final RString name;
    private final RString shortName;
    private final boolean multiSelectable;

    private NinteichosaItemSubGroupOf2009(String no, String name, String shortName, boolean multiSelectable) {
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
