/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 給付実績更新結果情報取込一覧表PageBreakクラスです。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufujissekiKoshinkekkaIchiranPageBreak extends PageBreaker<KyufujissekiKoshinkekkaIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public KyufujissekiKoshinkekkaIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> currentSource,
            ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> nextSource) {
        if (this.breakKeysList.contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else {
            return isBreakMore(currentSource, nextSource);
        }
    }

    private boolean isBreakMore(ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> currentSource,
            ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> nextSource) {
        if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.サービス提供年月.get項目ID())
                && !currentSource.getSource().listUpper_7.equals(nextSource.getSource().listUpper_7)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.事業者番号.get項目ID())
                && !currentSource.getSource().listUpper_9.equals(nextSource.getSource().listUpper_9)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.入力識別番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.整理番号.get項目ID())
                && !currentSource.getSource().listUpper_10.equals(nextSource.getSource().listUpper_10)) {
            return true;
        }
        return false;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource ChohyoShutsuryokuTaishoDateEntity
     * @param nextSource ChohyoShutsuryokuTaishoDateEntity
     * @return 改頁Flag
     */
    public boolean is改頁(ChohyoShutsuryokuTaishoDateEntity currentSource,
            ChohyoShutsuryokuTaishoDateEntity nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(KyufujissekiKoshinkekkaIchiranProperty.DBC200054_KyufujissekiKoshinkekkaIchiran.保険者番号.get項目ID())
                && !currentSource.get給付実績_コントロールレコード保険者番号().equals(nextSource.get給付実績_コントロールレコード保険者番号())) {
            return true;
        }
        return flg;
    }
}
