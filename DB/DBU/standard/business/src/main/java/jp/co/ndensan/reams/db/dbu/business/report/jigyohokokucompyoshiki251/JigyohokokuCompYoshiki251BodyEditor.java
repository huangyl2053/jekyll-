/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告複合様式_05のBodyEditorクラスです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251BodyEditor implements IJigyohokokuCompYoshiki251Editor {

    private final JigyohokokuCompResultEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompResultEntity
     */
    public JigyohokokuCompYoshiki251BodyEditor(JigyohokokuCompResultEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業報告複合様式_05のeditです
     *
     * @param source JigyohokokuCompYoshiki251ReportSource
     * @return JigyohokokuCompYoshiki251ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki251ReportSource edit(JigyohokokuCompYoshiki251ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki251ReportSource editSource(JigyohokokuCompYoshiki251ReportSource source) {
        source.list1_2 = intToRString(entity.get要支援１());
        source.list1_3 = intToRString(entity.get要支援２());
        source.list1_4 = intToRString(entity.get計１());
        source.list1_5 = intToRString(entity.get経過的要介護());
        source.list1_6 = intToRString(entity.get要介護１());
        source.list1_7 = intToRString(entity.get要介護２());
        source.list1_8 = intToRString(entity.get要介護３());
        source.list1_9 = intToRString(entity.get要介護４());
        source.list1_10 = intToRString(entity.get要介護５());
        source.list1_11 = intToRString(entity.get計２());
        source.list1_12 = intToRString(entity.get合計());
        source.list2_2 = intToRString(entity.get要支援１＿１());
        source.list2_3 = intToRString(entity.get要支援２＿１());
        source.list2_4 = intToRString(entity.get計１＿１());
        source.list2_5 = intToRString(entity.get経過的要介護＿１());
        source.list2_6 = intToRString(entity.get要介護１＿１());
        source.list2_7 = intToRString(entity.get要介護２＿１());
        source.list2_8 = intToRString(entity.get要介護３＿１());
        source.list2_9 = intToRString(entity.get要介護４＿１());
        source.list2_10 = intToRString(entity.get要介護５＿１());
        source.list2_11 = intToRString(entity.get計２＿１());
        source.list2_12 = intToRString(entity.get合計＿１());
        return source;
    }

    private RString intToRString(int data) {
        return new RString(String.valueOf(data));
    }

}
