/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収同定一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class TokubetsuChoshuDoteiIchiranPageBreak extends PageBreaker<TokubetsuChoshuDoteiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public TokubetsuChoshuDoteiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuDoteiIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuDoteiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().chokiCode.equals(nextSource.getSource().chokiCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.地区１.get項目ID())
                && !currentSource.getSource().chiku1.equals(nextSource.getSource().chiku1)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.地区２.get項目ID())
                && !currentSource.getSource().chiku2.equals(nextSource.getSource().chiku2)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.地区３.get項目ID())
                && !currentSource.getSource().chiku3.equals(nextSource.getSource().chiku3)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.世帯コード.get項目ID())
                && !currentSource.getSource().setaiCode.equals(nextSource.getSource().setaiCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.識別コード.get項目ID())
                && !currentSource.getSource().shikibetsuCode.equals(nextSource.getSource().shikibetsuCode)) {
            return true;
        } else {
            return isBreakPart2(currentSource, nextSource);
        }
    }

    private boolean isBreakPart2(ReportLineRecord<TokubetsuChoshuDoteiIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuDoteiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaShimei.equals(nextSource.getSource().kanaShimei)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.生年月日.get項目ID())
                && !currentSource.getSource().seinengappiYMD.equals(nextSource.getSource().seinengappiYMD)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.性別.get項目ID())
                && !currentSource.getSource().seibetsuCode.equals(nextSource.getSource().seibetsuCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.年金コード.get項目ID())
                && !currentSource.getSource().nenkinCode.equals(nextSource.getSource().nenkinCode)) {
            return true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuDoteiIchiranOutputOrder.年金番号.get項目ID())
                && !currentSource.getSource().kisoNenkinNo.equals(nextSource.getSource().kisoNenkinNo)) {
            return true;
        }
        return false;
    }

}
