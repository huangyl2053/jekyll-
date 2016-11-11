/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
        source.list1_2 = decimalToRString(entity.get要支援１());
        source.list1_3 = decimalToRString(entity.get要支援２());
        source.list1_4 = new RString(rStringToDecimal(source.list1_2).add(rStringToDecimal(source.list1_3)).toString());
        source.list1_5 = decimalToRString(entity.get経過的要介護());
        source.list1_6 = decimalToRString(entity.get要介護１());
        source.list1_7 = decimalToRString(entity.get要介護２());
        source.list1_8 = decimalToRString(entity.get要介護３());
        source.list1_9 = decimalToRString(entity.get要介護４());
        source.list1_10 = decimalToRString(entity.get要介護５());
        source.list1_11 = new RString((rStringToDecimal(source.list1_5))
                .add(rStringToDecimal(source.list1_6)).add(rStringToDecimal(source.list1_7))
                .add(rStringToDecimal(source.list1_8)).add(rStringToDecimal(source.list1_9))
                .add(rStringToDecimal(source.list1_10)).toString());
        source.list1_12 = new RString(rStringToDecimal(source.list1_4).add(rStringToDecimal(source.list1_11)).toString());
        source.list2_2 = decimalToRString(entity.get要支援１＿１());
        source.list2_3 = decimalToRString(entity.get要支援２＿１());
        source.list2_4 = new RString(rStringToDecimal(source.list2_2).add(rStringToDecimal(source.list2_3)).toString());
        source.list2_5 = decimalToRString(entity.get経過的要介護＿１());
        source.list2_6 = decimalToRString(entity.get要介護１＿１());
        source.list2_7 = decimalToRString(entity.get要介護２＿１());
        source.list2_8 = decimalToRString(entity.get要介護３＿１());
        source.list2_9 = decimalToRString(entity.get要介護４＿１());
        source.list2_10 = decimalToRString(entity.get要介護５＿１());
        source.list2_11 = new RString((rStringToDecimal(source.list2_5))
                .add(rStringToDecimal(source.list2_6)).add(rStringToDecimal(source.list2_7))
                .add(rStringToDecimal(source.list2_8)).add(rStringToDecimal(source.list2_9))
                .add(rStringToDecimal(source.list2_10)).toString());
        source.list2_12 = new RString(rStringToDecimal(source.list2_4).add(rStringToDecimal(source.list2_11)).toString());
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
