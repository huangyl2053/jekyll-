/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranProperty.DBC200014ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額介護サービス費給付対象者一覧表帳票のPageBreakです。
 *
 * @reamsid_L DBC-0980-490 surun
 */
public class KogakuKyufuTaishoshaIchiranPageBreak extends PageBreaker<KogakuKyufuTaishoshaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys ページングキー
     */
    public KogakuKyufuTaishoshaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            if (RString.isNullOrEmpty(currentSource.getSource().listUpper_2)
                    && !RString.isNullOrEmpty(nextSource.getSource().listUpper_2)) {
                flag = true;
            } else if (!RString.isNullOrEmpty(currentSource.getSource().listUpper_2)
                    && !RString.isNullOrEmpty(nextSource.getSource().listUpper_2)) {
                flag = true;
            }
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.サービス提供年月.get項目ID())
                && !currentSource.getSource().listUpper_3.equals(nextSource.getSource().listUpper_3)) {
            if (RString.isNullOrEmpty(currentSource.getSource().listUpper_3)
                    && !RString.isNullOrEmpty(nextSource.getSource().listUpper_3)) {
                flag = true;
            } else if (!RString.isNullOrEmpty(currentSource.getSource().listUpper_3)
                    && !RString.isNullOrEmpty(nextSource.getSource().listUpper_3)) {
                flag = true;
            }
        } else {
            return isBreakNext(currentSource, nextSource);
        }
        return flag;
    }

    private boolean isBreakNext(ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> currentSource,
            ReportLineRecord<KogakuKyufuTaishoshaIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.通知書番号.get項目ID())
                && !currentSource.getSource().listUpper_1.equals(nextSource.getSource().listUpper_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(DBC200014ShutsuryokujunEnum.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        }
        return flag;
    }
}
