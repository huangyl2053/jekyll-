/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目サブグループ（2009年改訂版）を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoItemSubGroupOf2009 implements IShujiiIkenshoItemSubGroup {

    /**
     * 意見書項目サブグループが「診断名_発症年月日」であることを表します。
     */
    診断名_発症年月日("1-1", "（1）診断名及び発症年月日", "診断名_発症年月日", true),
    /**
     * 意見書項目サブグループが「安定性」であることを表します。
     */
    安定性("1-2", "（2）症状としての安定性", "安定性", true),
    /**
     * 意見書項目サブグループが「傷病_治療内容」であることを表します。
     */
    傷病_治療内容("1-3", "（3）生活機能低下の直接の原因となっている傷病または特定疾病の経過及び投薬内容を含む治療内容", "傷病_治療内容", true),
    /**
     * 意見書項目サブグループが「処置内容」であることを表します。
     */
    処置内容("2-1", "処置内容", "処置内容", true),
    /**
     * 意見書項目サブグループが「特別対応」であることを表します。
     */
    特別対応("2-2", "特別な対応", "特別対応", true),
    /**
     * 意見書項目サブグループが「失禁対応」であることを表します。
     */
    失禁対応("2-3", "失禁への対応", "失禁対応", true),
    /**
     * 意見書項目サブグループが「自立度」であることを表します。
     */
    自立度("3-1", "（1）日常生活の自立度等について", "自立度", true),
    /**
     * 意見書項目サブグループが「中核症状」であることを表します。
     */
    中核症状("3-2", "（2）認知症の中核症状", "中核症状", true),
    /**
     * 意見書項目サブグループが「中核症状」であることを表します。
     */
    周辺症状("3-3", "（3）認知症の周辺症状", "周辺症状", true),
    /**
     * 意見書項目サブグループが「精神_神経症状」であることを表します。
     */
    精神_神経症状("3-4", "（4）その他の精神・神経症状", "精神_神経症状", true),
    /**
     * 意見書項目サブグループが「身体状態」であることを表します。
     */
    身体状態("3-4", "（5）身体の状態", "身体状態", true),
    /**
     * 意見書項目サブグループが「移動」であることを表します。
     */
    移動("4-1", "（1）移動", "移動", true),
    /**
     * 意見書項目サブグループが「栄養_食生活」であることを表します。
     */
    栄養_食生活("4-2", "（2）栄養・食生活", "栄養_食生活", true),
    /**
     * 意見書項目サブグループが「状態_対処方針」であることを表します。
     */
    状態_対処方針("4-3", "（3）現在あるかまたは今後発生の可能性の高い状態とその対処方針", "状態_対処方針", true),
    /**
     * 意見書項目サブグループが「維持_改善見通し」であることを表します。
     */
    維持_改善見通し("4-4", "（4）サービス利用による生活機能の維持・改善の見通し", "維持_改善見通し", true),
    /**
     * 意見書項目サブグループが「管理の必要性」であることを表します。
     */
    管理の必要性("4-5", "（5）医学的管理の必要性", "管理の必要性", true),
    /**
     * 意見書項目サブグループが「留意事項」であることを表します。
     */
    留意事項("4-6", "（6）サービス提供時における医学的観点からの留意事項", "留意事項", true),
    /**
     * 意見書項目サブグループが「感染症」であることを表します。
     */
    感染症("4-7", "（7）感染症の有無", "感染症", true);
    private RString no;
    private RString name;
    private RString shortName;
    private boolean multiSelectable;

    private ShujiiIkenshoItemSubGroupOf2009(String no, String name, String shortName, boolean multiSelectable) {
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
