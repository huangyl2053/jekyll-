/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranProperty.DBC120030ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 受給者情報更新結果情報取込一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranPageBreak extends PageBreaker<JukyushaKoshinKekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public JukyushaKoshinKekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JukyushaKoshinKekkaIchiranSource> currentSource,
            ReportLineRecord<JukyushaKoshinKekkaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC120030ShutsuryokujunEnum.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }
}
