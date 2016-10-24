/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収未同定一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class TokubetsuChoshuMidoteiIchiranPageBreak extends PageBreaker<TokubetsuChoshuMidoteiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public TokubetsuChoshuMidoteiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuMidoteiIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuMidoteiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaShimei.equals(nextSource.getSource().kanaShimei)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.生年月日.get項目ID())
                && !currentSource.getSource().seinengappiYMD.equals(nextSource.getSource().seinengappiYMD)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.性別.get項目ID())
                && !currentSource.getSource().seibetsuCode.equals(nextSource.getSource().seibetsuCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.年金コード.get項目ID())
                && !currentSource.getSource().nenkinCode.equals(nextSource.getSource().nenkinCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuMidoteiIchiranOutputOrder.年金番号.get項目ID())
                && !currentSource.getSource().kisoNenkinNo.equals(nextSource.getSource().kisoNenkinNo)) {
            return true;
        }
        return false;
    }

}
