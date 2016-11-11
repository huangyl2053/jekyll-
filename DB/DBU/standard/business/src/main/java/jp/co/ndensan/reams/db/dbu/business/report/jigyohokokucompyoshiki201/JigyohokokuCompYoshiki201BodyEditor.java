/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki201.JigyohokokuCompResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告月報様式_01のBodyEditorです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
public class JigyohokokuCompYoshiki201BodyEditor implements IJigyohokokuCompYoshiki201Editor {

    private static final RString 集計番号_0101 = new RString("0101");
    private static final RString 集計番号_0201 = new RString("0201");
    private static final RString 集計番号_0301 = new RString("0301");
    private static final RString 集計番号_0401 = new RString("0401");
    private static final RString 集計番号_0103 = new RString("0103");
    private static final RString 集計番号_0203 = new RString("0203");
    private static final RString 集計番号_0303 = new RString("0303");
    private static final RString 集計番号_0403 = new RString("0403");
    private static final RString 集計番号_0104 = new RString("0104");
    private static final RString 集計番号_0204 = new RString("0204");
    private static final RString 集計番号_0304 = new RString("0304");
    private static final RString 集計番号_0404 = new RString("0404");
    private static final RString 総数 = new RString("①総　数");
    private static final RString 第２号被保険者分 = new RString("③第２号被保険者分（再掲）");
    private static final RString 総数_再掲 = new RString("④総　数（再掲：介護給付・予防給付の特例分）");
    private static final RString 第２号被保険者分_再掲 = new RString("⑤第２号被保険者分（再掲：介護給付・予防給付の特例分）");
    private static final RString 様式内容２ = new RString("（様式２）");
    private static final RString 様式内容２の２ = new RString("（様式２の２）");
    private static final RString 様式内容２の３ = new RString("（様式２の３）");
    private static final RString 様式内容２の４ = new RString("（様式２の４）");
    private static final RString ア内容 = new RString("ア．件数");
    private static final RString ウ内容 = new RString("ウ．費用額");
    private static final RString エ内容 = new RString("エ．給付額");
    private final JigyohokokuCompResultEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompResultEntity
     */
    protected JigyohokokuCompYoshiki201BodyEditor(JigyohokokuCompResultEntity entity) {
        this.entity = entity;
    }

    @Override
    public JigyohokokuCompYoshiki201ReportSource edit(JigyohokokuCompYoshiki201ReportSource source) {
        return editsSource(source);
    }

    private JigyohokokuCompYoshiki201ReportSource editsSource(JigyohokokuCompYoshiki201ReportSource source) {
        source.title2 = getTitleTwo(entity.get集計番号());
        source.title3 = getTitleThree(entity.get集計番号());
        source.yoshiki = getYoshiki(entity.get集計番号());
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

    private RString getTitleTwo(RString 集計番号) {
        RString title;
        if (集計番号_0101.equals(集計番号)
                || 集計番号_0103.equals(集計番号)
                || 集計番号_0104.equals(集計番号)) {
            title = 総数;
        } else if (集計番号_0201.equals(集計番号)
                || 集計番号_0203.equals(集計番号)
                || 集計番号_0204.equals(集計番号)) {
            title = 第２号被保険者分;
        } else if (集計番号_0301.equals(集計番号)
                || 集計番号_0303.equals(集計番号)
                || 集計番号_0304.equals(集計番号)) {
            title = 総数_再掲;
        } else if (集計番号_0401.equals(集計番号)
                || 集計番号_0403.equals(集計番号)
                || 集計番号_0404.equals(集計番号)) {
            title = 第２号被保険者分_再掲;
        } else {
            title = RString.EMPTY;
        }
        return title;
    }

    private RString getTitleThree(RString 集計番号) {
        RString title;
        if (集計番号_0101.equals(集計番号)
                || 集計番号_0201.equals(集計番号)
                || 集計番号_0301.equals(集計番号)
                || 集計番号_0401.equals(集計番号)) {
            title = ア内容;
        } else if (集計番号_0103.equals(集計番号)
                || 集計番号_0203.equals(集計番号)
                || 集計番号_0303.equals(集計番号)
                || 集計番号_0403.equals(集計番号)) {
            title = ウ内容;
        } else if (集計番号_0104.equals(集計番号)
                || 集計番号_0204.equals(集計番号)
                || 集計番号_0304.equals(集計番号)
                || 集計番号_0404.equals(集計番号)) {
            title = エ内容;
        } else {
            title = RString.EMPTY;
        }
        return title;
    }

    private RString getYoshiki(RString 集計番号) {
        RString yoshiki;
        if (集計番号_0101.equals(集計番号)
                || 集計番号_0103.equals(集計番号)
                || 集計番号_0104.equals(集計番号)) {
            yoshiki = 様式内容２;
        } else if (集計番号_0201.equals(集計番号)
                || 集計番号_0203.equals(集計番号)
                || 集計番号_0204.equals(集計番号)) {
            yoshiki = 様式内容２の２;
        } else if (集計番号_0301.equals(集計番号)
                || 集計番号_0303.equals(集計番号)
                || 集計番号_0304.equals(集計番号)) {
            yoshiki = 様式内容２の３;
        } else if (集計番号_0401.equals(集計番号)
                || 集計番号_0403.equals(集計番号)
                || 集計番号_0404.equals(集計番号)) {
            yoshiki = 様式内容２の４;
        } else {
            yoshiki = RString.EMPTY;
        }
        return yoshiki;
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
