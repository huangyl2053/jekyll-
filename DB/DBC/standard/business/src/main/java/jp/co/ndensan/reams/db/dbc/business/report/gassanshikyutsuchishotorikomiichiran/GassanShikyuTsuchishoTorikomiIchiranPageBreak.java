/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給不支給決定通知書情報取込一覧表帳票PageBreakです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class GassanShikyuTsuchishoTorikomiIchiranPageBreak
        extends PageBreaker<GassanShikyuTsuchishoTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public GassanShikyuTsuchishoTorikomiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyuTsuchishoTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuTsuchishoTorikomiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else {
            return doBreak(currentSource, nextSource);
        }
    }

    private boolean doBreak(ReportLineRecord<GassanShikyuTsuchishoTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanShikyuTsuchishoTorikomiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_1.equals(nextSource.getSource().listUpper_1)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.対象年度.get項目ID())
                && !currentSource.getSource().taishoNendo.equals(nextSource.getSource().taishoNendo)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.支給区分コード.get項目ID())
                && !currentSource.getSource().shikyuKubunCode.equals(nextSource.getSource().shikyuKubunCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyuTsuchishoTorikomiIchiranOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            return true;
        }
        return false;
    }

}
