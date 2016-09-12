/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事業報告月報様式_01のHeadEditorです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
public class JigyohokokuCompYoshiki201HeadEditor implements IJigyohokokuCompYoshiki201Editor {

    private static final RString 旧市町村 = new RString("1");
    private static final RString 記号 = new RString("（旧）");
    private static final RString 現物分コード = new RString("1");
    private static final RString 償還分コード = new RString("2");
    private static final RString 現物分内容 = new RString("（１）介護給付・予防給付（現物分）");
    private static final RString 償還分内容 = new RString("（１）介護給付・予防給付（償還分）");
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
    private final RString title3;
    private final RString 集計番号;
    private final RString 給付実績区分コード;
    private final JigyohokokuCompYoshiki201Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     * @param title3 タイトル３
     * @param 集計番号 集計番号
     * @param 給付実績区分コード 給付実績区分コード
     */
    protected JigyohokokuCompYoshiki201HeadEditor(JigyohokokuCompYoshiki201Business business,
            RString title3, RString 集計番号, RString 給付実績区分コード) {
        this.business = business;
        this.title3 = title3;
        this.集計番号 = 集計番号;
        this.給付実績区分コード = 給付実績区分コード;
    }

    @Override
    public JigyohokokuCompYoshiki201ReportSource edit(JigyohokokuCompYoshiki201ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki201ReportSource editSource(JigyohokokuCompYoshiki201ReportSource source) {
        source.sakuseinichiji = business.get処理日時();
        source.shorikbn = business.get年報月報区分();
        source.shukeihani = business.get集計年月();
        source.hokenjano = business.get保険者コード();
        RStringBuilder builder = new RStringBuilder();
        if (旧市町村.equals(business.get旧市町村区分())) {
            builder.append(記号).append(business.get保険者名());
        } else {
            builder.append(business.get保険者名());
        }
        source.hokenjamei = builder.toRString();
        source.yoshiki = getYoshiki(集計番号);
        source.title1 = getTitleOne(給付実績区分コード);
        source.title2 = getTitleTwo(集計番号);
        source.title3 = title3;
        return source;
    }

    private RString getTitleOne(RString 給付実績区分コード) {
        RString title;
        if (現物分コード.equals(給付実績区分コード)) {
            title = 現物分内容;
        } else if (償還分コード.equals(給付実績区分コード)) {
            title = 償還分内容;
        } else {
            title = RString.EMPTY;
        }
        return title;
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
}
