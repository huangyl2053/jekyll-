/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 Reportクラスです。
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranReport extends Report<TokubetsuChoshuHeijunkaKeisanIchiranSource> {

    private final TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表;
    private final TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final RString title;
    private final YMDHMS 調定日時;
    private final FlexibleYear 調定年度;
    private final IOutputOrder outputOrder;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param 特徴平準化結果対象者一覧表 TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param 特徴平準化結果対象外一覧表 TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 調定日時 YMDHMS
     * @param 調定年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @param title RString
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranReport(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表,
            ChohyoSeigyoKyotsu 帳票制御共通,
            YMDHMS 調定日時,
            FlexibleYear 調定年度,
            Association association,
            IOutputOrder outputOrder,
            RString title) {

        this.特徴平準化結果対象者一覧表 = 特徴平準化結果対象者一覧表;
        this.特徴平準化結果対象外一覧表 = 特徴平準化結果対象外一覧表;
        this.帳票制御共通 = 帳票制御共通;
        this.調定日時 = 調定日時;
        this.調定年度 = 調定年度;
        this.association = association;
        this.outputOrder = outputOrder;
        this.title = title;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanIchiranSource> writer) {

        ITokubetsuChoshuHeijunkaKeisanIchiranEditor headerEditor
                = new TokubetsuChoshuHeijunkaKeisanIchiranHeaderEditor(調定日時, 調定年度, title, outputOrder);

        ITokubetsuChoshuHeijunkaKeisanIchiranEditor bodyEditor
                = new TokubetsuChoshuHeijunkaKeisanIchiranBodyEditor(特徴平準化結果対象者一覧表, 特徴平準化結果対象外一覧表, 帳票制御共通, association);
        ITokubetsuChoshuHeijunkaKeisanIchiranBuilder builder
                = new TokubetsuChoshuHeijunkaKeisanIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);

    }
}
