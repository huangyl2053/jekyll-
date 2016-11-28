/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給決定通知書発行processのPageBreakクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public class GassanShikyuFushikyuKetteishaIchiranPageBreak extends PageBreaker<GassanShikyuFushikyuKetteishaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public GassanShikyuFushikyuKetteishaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> nextSource) {
        boolean flag = false;
        if (!RString.EMPTY.equals(nextSource.getSource().listCerter_2)) {
            if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.被保険者番号.get項目ID())
                    && !currentSource.getSource().listCerter_2.equals(nextSource.getSource().listCerter_2)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請年月日.get項目ID())
                    && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.対象年度.get項目ID())
                    && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
                flag = true;
            } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.申請書整理番号.get項目ID())
                    && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
                flag = true;
            } else {
                setFlag(currentSource, nextSource);
            }
        }
        return flag;
    }

    private boolean setFlag(ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuFushikyuKetteishaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().add_hokenshaNo.equals(nextSource.getSource().add_hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().add_shichosonCode.equals(nextSource.getSource().add_shichosonCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().add_kanaMeisho.equals(nextSource.getSource().add_kanaMeisho)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().add_choikiCode.equals(nextSource.getSource().add_choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().add_gyoseikuCode.equals(nextSource.getSource().add_gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanShikyuFushikyuKetteishaIchiranOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().add_yubinNo.equals(nextSource.getSource().add_yubinNo)) {
            flag = true;
        }
        return flag;
    }
}
