/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告月報様式_03のBodyEditorのクラスです。
 *
 * @reamsid_L DBU-5560-070 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2120161BodyEditor implements IJigyohokokuGeppoYoshiki2120161Editor {

    private final JigyohokokuCompResultEntity entity;
    private final int index;
    private static final int INDEX_19 = 19;

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompResultEntity
     * @param index index
     */
    protected JigyohokokuGeppoYoshiki2120161BodyEditor(JigyohokokuCompResultEntity entity, int index) {
        this.entity = entity;
        this.index = index;
    }

    @Override
    public JigyohokokuGeppoYoshiki2120161ReportSource edit(JigyohokokuGeppoYoshiki2120161ReportSource source) {
        return editsSource(source);
    }

    private JigyohokokuGeppoYoshiki2120161ReportSource editsSource(JigyohokokuGeppoYoshiki2120161ReportSource source) {
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
        if (INDEX_19 == index) {
            source.listList1_3 = RString.EMPTY;
            source.listList1_11 = RString.EMPTY;
            source.listList1_12 = RString.EMPTY;
        }
        return source;
    }

    private RString decimalToRString(Decimal data) {
        if (data == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private Decimal rStringToDecimal(RString data) {
        if (RString.isNullOrEmpty(data)) {
            return Decimal.ZERO;
        }
        return new Decimal(data.toString());
    }
}
