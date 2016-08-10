/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事業報告複合様式_05のHeadEditorクラスです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251HeadEditor implements IJigyohokokuCompYoshiki251Editor {

    private static final RString 旧市町村 = new RString("1");
    private static final RString 記号 = new RString("（旧）");
    private static final RString 現物分コード = new RString("1");
    private static final RString 償還分コード = new RString("2");
    private static final RString 現物分内容 = new RString("（２）特定入所者介護（介護予防）サービス費（別掲）（現物分）");
    private static final RString 償還分内容 = new RString("（２）特定入所者介護（介護予防）サービス費（別掲）（償還分）");
    private static final RString 集計番号_0105 = new RString("0105");
    private static final RString 集計番号_0106 = new RString("0106");
    private static final RString 集計番号_0205 = new RString("0205");
    private static final RString 集計番号_0206 = new RString("0206");
    private static final RString 総数 = new RString("①総　数");
    private static final RString 被保険者分再掲 = new RString("②第２号被保険者分（再掲）");
    private static final RString 様式２の５ = new RString("（様式２の５）");
    private static final RString 様式２の６ = new RString("（様式２の６）");
    private final RString 集計番号;
    private final RString 給付実績区分コード;
    private final JigyohokokuCompYoshiki201Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     * @param 集計番号 集計番号
     * @param 給付実績区分コード 給付実績区分コード
     */
    public JigyohokokuCompYoshiki251HeadEditor(RString 集計番号, RString 給付実績区分コード, JigyohokokuCompYoshiki201Business business) {
        this.集計番号 = 集計番号;
        this.給付実績区分コード = 給付実績区分コード;
        this.business = business;
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
        source.printTimeStamp = business.get処理日時();
        source.shukeiKubun = business.get年報月報区分();
        source.shuukeiHani = business.get集計年月();
        source.hokenshaNo = business.get保険者コード();
        RStringBuilder builder = new RStringBuilder();
        if (旧市町村.equals(business.get旧市町村区分())) {
            builder.append(記号).append(business.get保険者名());
        } else {
            builder.append(business.get保険者名());
        }
        source.hokenshaName = builder.toRString();
        source.hyoTitle = setHyoTitle(給付実績区分コード);
        if (集計番号_0105.equals(集計番号)
                || 集計番号_0106.equals(集計番号)) {
            source.hyoSubTitle = 総数;
            source.yoshiki = 様式２の５;
        } else if (集計番号_0205.equals(集計番号)
                || 集計番号_0206.equals(集計番号)) {
            source.hyoSubTitle = 被保険者分再掲;
            source.yoshiki = 様式２の６;
        } else {
            source.hyoSubTitle = RString.EMPTY;
            source.yoshiki = RString.EMPTY;
        }
        return source;
    }

    private RString setHyoTitle(RString 給付実績区分コード) {
        RString hyotitle;
        if (現物分コード.equals(給付実績区分コード)) {
            hyotitle = 現物分内容;
        } else if (償還分コード.equals(給付実績区分コード)) {
            hyotitle = 償還分内容;
        } else {
            hyotitle = RString.EMPTY;
        }
        return hyotitle;
    }

}
