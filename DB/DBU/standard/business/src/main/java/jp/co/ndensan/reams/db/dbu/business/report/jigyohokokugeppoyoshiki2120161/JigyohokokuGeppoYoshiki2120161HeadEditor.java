/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事業報告月報様式_03のHeadEditorのクラスです。
 *
 * @reamsid_L DBU-5560-070 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2120161HeadEditor implements IJigyohokokuGeppoYoshiki2120161Editor {

    private static final RString 旧市町村 = new RString("1");
    private static final RString 記号 = new RString("（旧）");
    private static final RString 現物分コード = new RString("1");
    private static final RString 償還分コード = new RString("2");
    private static final RString 現物分内容 = new RString("（１）介護給付・予防給付（現物分）");
    private static final RString 償還分内容 = new RString("（１）介護給付・予防給付（償還分）");
    private static final RString 集計番号_0107 = new RString("0107");
    private static final RString 集計番号_0109 = new RString("0109");
    private static final RString 集計番号_0110 = new RString("0110");
    private static final RString 総数_再掲 = new RString("②総　数（再掲：第１号被保険者の２割負担対象者分）");
    private static final RString 様式内容２ = new RString("（様式２）");
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
    protected JigyohokokuGeppoYoshiki2120161HeadEditor(JigyohokokuCompYoshiki201Business business,
            RString title3, RString 集計番号, RString 給付実績区分コード) {
        this.business = business;
        this.title3 = title3;
        this.集計番号 = 集計番号;
        this.給付実績区分コード = 給付実績区分コード;
    }

    @Override
    public JigyohokokuGeppoYoshiki2120161ReportSource edit(JigyohokokuGeppoYoshiki2120161ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuGeppoYoshiki2120161ReportSource editSource(JigyohokokuGeppoYoshiki2120161ReportSource source) {
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
        source.title1 = getTitleOne(給付実績区分コード);
        if (集計番号_0107.equals(集計番号)
                || 集計番号_0109.equals(集計番号)
                || 集計番号_0110.equals(集計番号)) {
            source.yoshiki = 様式内容２;
            source.title2 = 総数_再掲;
        } else {
            source.yoshiki = RString.EMPTY;
            source.title2 = RString.EMPTY;
        }
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

}
