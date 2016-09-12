/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
public class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport extends Report<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> {

    private final TokuchoHeijunkaRokuBatchTaishoshaIchiran taishosha;
    private final TokuchoHeijunkaRokuBatchTaishogaiIchiran taishogai;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final IOutputOrder outputOrder;
    private final Association association;
    private static final RString タイトル_特徴平準化対象者一覧表 = new RString("特徴平準化対象者一覧表");
    private static final RString タイトル_特徴平準化対象外一覧表 = new RString("特徴平準化対象外一覧表");

    /**
     * コンストラクタです。
     *
     * @param taishosha TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param taishogai TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     */
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran taishosha,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran taishogai,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, IOutputOrder outputOrder) {
        this.taishosha = taishosha;
        this.taishogai = taishogai;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
        this.outputOrder = outputOrder;
    }

    /**
     * createFormメソッド
     *
     * @param taishosha TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param taishogai TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @return TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport
     */
    public static TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport createForm(
            @NonNull TokuchoHeijunkaRokuBatchTaishoshaIchiran taishosha,
            @NonNull TokuchoHeijunkaRokuBatchTaishogaiIchiran taishogai,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, IOutputOrder outputOrder) {
        return new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(taishosha,
                taishogai, 調定日時, 賦課年度, association, outputOrder);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> writer) {
        RString title = タイトル_特徴平準化対象外一覧表;
        if (taishogai == null) {
            title = タイトル_特徴平準化対象者一覧表;
        }
        ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor headerEditor
                = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranHeaderEditor(調定日時, 賦課年度, title, outputOrder);
        if (taishosha != null) {
            ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor taishoshaBodyEditor
                    = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBodyEditor(taishosha,
                            null, association);
            ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder taishoshaBuilder = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder(
                    headerEditor, taishoshaBodyEditor);
            writer.writeLine(taishoshaBuilder);
        } else {
            ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor bodyEditor
                    = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBodyEditor(null,
                            taishogai, association);
            ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder builder = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder(
                    headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
}
