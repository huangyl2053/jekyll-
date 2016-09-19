/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算支給額計算結果連絡票情報送付一覧表の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class GassanShikyugakuKeisankekkaSofuIchiranPageBreak extends PageBreaker<GassanShikyugakuKeisankekkaSofuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * @param breakKeys ページングキー
     */
    public GassanShikyugakuKeisankekkaSofuIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanShikyugakuKeisankekkaSofuIchiranSource> currentSource,
            ReportLineRecord<GassanShikyugakuKeisankekkaSofuIchiranSource> nextSource) {

        if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listLower_1.equals(nextSource.getSource().listLower_1)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.対象年度.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(GassanShikyugakuKeisankekkaSofuIchiranOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            return true;
        }

        return false;
    }
}
