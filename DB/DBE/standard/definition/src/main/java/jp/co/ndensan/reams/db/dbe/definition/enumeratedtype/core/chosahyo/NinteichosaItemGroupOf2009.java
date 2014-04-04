/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目グループ（2009年改定版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaItemGroupOf2009 implements INinteichosaItemGroup {

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
    第１群("1", "第１群（身体機能・起居動作）", "第１群", true),
    /**
     * 調査項目グループが「第２群」であることを表します。
     */
    第２群("2", "第２群（生活機能）", "第２群", true),
    /**
     * 調査項目グループが「第３群」であることを表します。
     */
    第３群("3", "第３群（認知機能）", "第３群", true),
    /**
     * 調査項目グループが「第４群」であることを表します。
     */
    第４群("4", "第４群（精神・行動障害）", "第４群", true),
    /**
     * 調査項目グループが「第５群」であることを表します。
     */
    第５群("5", "第５群（社会生活への適応）", "第５群", true),
    /**
     * 調査項目グループが「特別医療」であることを表します。
     */
    特別医療("6", "６ 過去14日間にうけた特別な医療について（複数回答可）", "特別医療", true),
    /**
     * 調査項目グループが「自立度」であることを表します。
     */
    自立度("7", "７ 調査対象者の日常生活自立度について", "自立度", true);
    private RString no;
    private RString name;
    private RString shortName;
    private boolean kihonChosaGroup;

    private NinteichosaItemGroupOf2009(String no, String name, String shortName, boolean kihonChosaGroup) {
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
