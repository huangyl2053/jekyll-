/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukarisanteikekkaIchiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukarisanteikekkaIchiran.TokubetsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収仮算定結果一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class TokubetsuChoshuKarisanteiKekkaIchiranPageBreak extends PageBreaker<TokubetsuChoshuKarisanteiKekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public TokubetsuChoshuKarisanteiKekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> nextSource) {
        boolean flag;
        if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.郵便番号.getフォームフィールド名())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.町域コード.getフォームフィールド名())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.行政区コード.getフォームフィールド名())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.世帯コード.getフォームフィールド名())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.識別コード.getフォームフィールド名())
                && !currentSource.getSource().shikibetsuCode.equals(nextSource.getSource().shikibetsuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.氏名５０音カナ.getフォームフィールド名())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.生年月日.getフォームフィールド名())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.性別.getフォームフィールド名())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        } else {
            flag = getBreakFlag(currentSource, nextSource);
        }
        return flag;
    }

    private boolean getBreakFlag(ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKarisanteiKekkaIchiranSource> nextSource) {
        boolean breakFlag = false;
        if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.市町村コード.getフォームフィールド名())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            breakFlag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.通知書番号.getフォームフィールド名())
                && !currentSource.getSource().listLower_1.equals(nextSource.getSource().listLower_1)) {
            breakFlag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.被保険者番号.getフォームフィールド名())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            breakFlag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.徴収方法.getフォームフィールド名())
                && !currentSource.getSource().choshuHoho.equals(nextSource.getSource().choshuHoho)) {
            breakFlag = true;
        } else if (this.breakKeysList.contains(TokubetsuChoshuKarisanteiKekkaIchiranOutPutOrder.特徴開始月.getフォームフィールド名())
                && !currentSource.getSource().tokuchoKaisiTuki.equals(nextSource.getSource().tokuchoKaisiTuki)) {
            breakFlag = true;
        }
        return breakFlag;
    }

}
