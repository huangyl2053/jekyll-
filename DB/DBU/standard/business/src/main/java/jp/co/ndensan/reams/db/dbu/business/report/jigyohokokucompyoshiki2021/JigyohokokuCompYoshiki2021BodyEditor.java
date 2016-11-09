/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2021.JigyohokokuCompYoshiki2021ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
     * @param source JigyohokokuCompYoshiki2021ReportSource
     * @return JigyohokokuCompYoshiki2021ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki2021ReportSource edit(JigyohokokuCompYoshiki2021ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki2021ReportSource editSource(JigyohokokuCompYoshiki2021ReportSource source) {
        source.listList1_1 = decimalToRString(entity.get要支援１());
        source.listList1_2 = decimalToRString(entity.get要支援２());
        source.listList1_3 = new RString(rStringToDecimal(source.listList1_1).add(rStringToDecimal(source.listList1_2)).toString());
        source.listList1_4 = decimalToRString(entity.get非該当());
        source.listList1_5 = decimalToRString(entity.get経過的要介護());
        source.listList1_6 = decimalToRString(entity.get要介護１());
        source.listList1_7 = decimalToRString(entity.get要介護２());
        source.listList1_8 = decimalToRString(entity.get要介護３());
        source.listList1_9 = decimalToRString(entity.get要介護４());
        source.listList1_10 = decimalToRString(entity.get要介護５());
        source.listList1_11 = new RString(rStringToDecimal(source.listList1_4).add(rStringToDecimal(source.listList1_5))
                .add(rStringToDecimal(source.listList1_6)).add(rStringToDecimal(source.listList1_7))
                .add(rStringToDecimal(source.listList1_8)).add(rStringToDecimal(source.listList1_9))
                .add(rStringToDecimal(source.listList1_10)).toString());
        source.listList1_12 = new RString(rStringToDecimal(source.listList1_3).add(rStringToDecimal(source.listList1_11)).toString());
        return source;
    }

    private RString decimalToRString(Decimal data) {
        return new RString(data.toString());
    }

    private Decimal rStringToDecimal(RString data) {
        if (RString.isNullOrEmpty(data)) {
            return Decimal.ZERO;
        }
        return new Decimal(data.toString());
    }

}
