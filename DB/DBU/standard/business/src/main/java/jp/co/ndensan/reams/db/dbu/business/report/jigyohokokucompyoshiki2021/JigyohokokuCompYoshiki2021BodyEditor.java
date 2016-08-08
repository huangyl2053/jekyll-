/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki202.JigyohokokuCompYoshiki202ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告月報様式_02のBodyEditorです。
 *
 * @reamsid_L DBU-5560-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki2021BodyEditor implements IJigyohokokuCompYoshiki2021Editor {

    private final JigyohokokuCompResultEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompResultEntity
     */
    public JigyohokokuCompYoshiki2021BodyEditor(JigyohokokuCompResultEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業報告月報様式_02のeditです
     *
     * @param source JigyohokokuCompYoshiki202ReportSource
     * @return JigyohokokuCompYoshiki202ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki202ReportSource edit(JigyohokokuCompYoshiki202ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki202ReportSource editSource(JigyohokokuCompYoshiki202ReportSource source) {
        source.listList1_1 = intToRString(entity.get要支援１());
        source.listList1_2 = intToRString(entity.get要支援２());
        source.listList1_3 = intToRString(entity.get計１());
        source.listList1_4 = intToRString(entity.get非該当());
        source.listList1_5 = intToRString(entity.get経過的要介護());
        source.listList1_6 = intToRString(entity.get要介護１());
        source.listList1_7 = intToRString(entity.get要介護２());
        source.listList1_8 = intToRString(entity.get要介護３());
        source.listList1_9 = intToRString(entity.get要介護４());
        source.listList1_10 = intToRString(entity.get要介護５());
        source.listList1_11 = intToRString(entity.get計２());
        source.listList1_12 = intToRString(entity.get合計());
        return source;
    }

    private RString intToRString(int data) {
        return new RString(String.valueOf(data));
    }

}
