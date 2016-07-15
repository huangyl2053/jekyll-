/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
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
public class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport extends Report<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> {

    private final List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト;
    private final List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト;
    private final List<RString> 並び順List;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;
    private static final RString タイトル_特徴平準化対象者一覧表 = new RString("特徴平準化対象者一覧表");
    private static final RString タイトル_特徴平準化対象外一覧表 = new RString("特徴平準化対象外一覧表");

    /**
     * コンストラクタです。
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijyunkaTaishoshaEntity>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijyunkaTaishogaiEntity>
     * @param 並び順List List<RString>
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     */
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(
            List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト,
            List<RString> 並び順List, YMDHMS 調定日時, FlexibleYear 賦課年度,
            Association association) {
        this.特徴平準化結果対象者一覧表リスト = 特徴平準化結果対象者一覧表リスト;
        this.特徴平準化結果対象外一覧表リスト = 特徴平準化結果対象外一覧表リスト;
        this.並び順List = 並び順List;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
    }

    /**
     * createFormメソッド
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijyunkaTaishoshaEntity>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijyunkaTaishogaiEntity>
     * @param 並び順List List<RString>
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param association Association
     * @return TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport
     */
    public static TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport createForm(
            @NonNull List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            @NonNull List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト, List<RString> 並び順List,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association) {
        return new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(特徴平準化結果対象者一覧表リスト,
                特徴平準化結果対象外一覧表リスト, 並び順List, 調定日時, 賦課年度, association);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> writer) {
        RString title = タイトル_特徴平準化対象外一覧表;
        if (特徴平準化結果対象外一覧表リスト.isEmpty()) {
            title = タイトル_特徴平準化対象者一覧表;
        }
        ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor headerEditor
                = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranHeaderEditor(調定日時, 賦課年度, title);
        ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor bodyEditor
                = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBodyEditor(特徴平準化結果対象者一覧表リスト,
                        並び順List, 特徴平準化結果対象外一覧表リスト, association);
        ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder builder = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBuilder(
                headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
