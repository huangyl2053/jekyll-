/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.param.TokubetsuChoshuIraikingakuMeisaiIchiranInputParam;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のReportです。
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranReport extends Report<TokubetsuChoshuIraikingakuMeisaiIchiranSource> {

    private final List<KariTokuchoKaishiTsuchisyoJoho> 通知書情報List;
    private final RYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param 通知書情報List List<KariTokuchoKaishiTsuchisyoJoho>
     * @param 調定年度 RYear
     * @param 帳票作成日時 帳票作成日時
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranReport(List<KariTokuchoKaishiTsuchisyoJoho> 通知書情報List,
            RYear 調定年度, YMDHMS 帳票作成日時, RString 並び順の１件目, RString 並び順の２件目, RString 並び順の３件目,
            RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List, Association association) {
        this.通知書情報List = 通知書情報List;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> reportSourceWriter) {
        TokubetsuChoshuIraikingakuMeisaiIchiranInputParam headInput
                = new TokubetsuChoshuIraikingakuMeisaiIchiranInputParam(null, 調定年度, 帳票作成日時,
                        並び順の１件目, 並び順の２件目, 並び順の３件目, 並び順の４件目, 並び順の５件目,
                        改頁項目List, association);
        ITokubetsuChoshuIraikingakuMeisaiIchiranEditor headerEditor
                = new TokubetsuChoshuIraikingakuMeisaiIchiranHeaderEditor(headInput);
        for (KariTokuchoKaishiTsuchisyoJoho 通知書情報 : 通知書情報List) {
            TokubetsuChoshuIraikingakuMeisaiIchiranInputParam inputEntity
                    = new TokubetsuChoshuIraikingakuMeisaiIchiranInputParam(通知書情報, 調定年度, 帳票作成日時,
                            並び順の１件目, 並び順の２件目, 並び順の３件目, 並び順の４件目, 並び順の５件目,
                            改頁項目List, association);
            ITokubetsuChoshuIraikingakuMeisaiIchiranEditor bodyEditor
                    = new TokubetsuChoshuIraikingakuMeisaiIchiranBodyEditor(inputEntity);
            ITokubetsuChoshuIraikingakuMeisaiIchiranBuilder builder
                    = new TokubetsuChoshuIraikingakuMeisaiIchiranBuilder(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
