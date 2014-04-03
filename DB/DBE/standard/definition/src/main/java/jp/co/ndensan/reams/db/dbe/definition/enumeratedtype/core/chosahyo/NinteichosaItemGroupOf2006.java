/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目グループ（2006年改訂版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaItemGroupOf2006 implements INinteichosaItemGroup {

    /**
     * 調査項目グループが「サービス状況」であることを表します。
     */
    サービス状況("", "現在受けているサービスの状況", "サービス状況", false),
    /**
     * 調査項目グループが「概況特記事項」であることを表します。
     */
    概況特記事項("", "特記すべき事項", "概況特記事項", false),
    /**
     * 調査項目グループが「第１群」であることを表します。
     */
    第１群("1", "第１群（麻痺拘縮）", "第１群", true),
    /**
     * 調査項目グループが「第２群」であることを表します。
     */
    第２群("2", "第２群（　移動　）", "第２群", true),
    /**
     * 調査項目グループが「第３群」であることを表します。
     */
    第３群("3", "第３群（複雑動作）", "第３群", true),
    /**
     * 調査項目グループが「第４群」であることを表します。
     */
    第４群("4", "第４群（特別介護）", "第４群", true),
    /**
     * 調査項目グループが「第５群」であることを表します。
     */
    第５群("5", "第５群（身の回り）", "第５群", true),
    /**
     * 調査項目グループが「第６群」であることを表します。
     */
    第６群("6", "第６群（意思疏通）", "第６群", true),
    /**
     * 調査項目グループが「第７群」であることを表します。
     */
    第７群("7", "第７群（問題行動）", "第７群", true),
    /**
     * 調査項目グループが「特別医療」であることを表します。
     */
    特別医療("", "＜特別な医療＞", "特別医療", false),
    /**
     * 調査項目グループが「自立度」であることを表します。
     */
    自立度("", "自立度", "自立度", false);
    private RString no;
    private RString name;
    private RString shortName;
    private boolean kihonChosaGroup;

    private NinteichosaItemGroupOf2006(String no, String name, String shortName, boolean kihonChosaGroup) {
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
