/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBC200006_受給者台帳（一覧表）PageBreak
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhoernJukyushaDaichoIchiranPageBreak extends PageBreaker<JukyushaKoshinkekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys ページングキー
     */
    public KokuhoernJukyushaDaichoIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JukyushaKoshinkekkaIchiranSource> currentSource,
            ReportLineRecord<JukyushaKoshinkekkaIchiranSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listList1_4.equals(nextSource.getSource().listList1_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.町域コード.get項目ID())
                && !currentSource.getSource().listList2_4.equals(nextSource.getSource().listList2_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.行政区コード.get項目ID())
                && !currentSource.getSource().listList1_6.equals(nextSource.getSource().listList1_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(KokuhorenJukyushaDaichoIchiranProperty.DBC200006ShutsuryokujunEnum.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }
}
