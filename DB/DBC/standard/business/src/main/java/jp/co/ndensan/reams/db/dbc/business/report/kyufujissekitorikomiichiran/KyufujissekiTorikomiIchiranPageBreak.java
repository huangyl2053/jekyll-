/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekitorikomiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 給付実績更新結果情報取込一覧表PageBreakクラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufujissekiTorikomiIchiranPageBreak extends PageBreaker<KyufujissekiTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public KyufujissekiTorikomiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufujissekiTorikomiIchiranSource> currentSource,
            ReportLineRecord<KyufujissekiTorikomiIchiranSource> nextSource) {
        if (this.breakKeysList.contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else {
            return isBreakMore(currentSource, nextSource);
        }
    }

    private boolean isBreakMore(ReportLineRecord<KyufujissekiTorikomiIchiranSource> currentSource,
            ReportLineRecord<KyufujissekiTorikomiIchiranSource> nextSource) {
        if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.サービス提供年月.get項目ID())
                && !currentSource.getSource().listUpper_7.equals(nextSource.getSource().listUpper_7)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.事業者番号.get項目ID())
                && !currentSource.getSource().listUpper_9.equals(nextSource.getSource().listUpper_9)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.入力識別番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            return true;
        } else if (this.breakKeysList
                .contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.整理番号.get項目ID())
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
    public boolean is改頁(KyufujissekiTorikomiIchiranEntity currentSource,
            KyufujissekiTorikomiIchiranEntity nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(KyufujissekiTorikomiIchiranProperty.DBC200007_KyufujissekiTorikomiIchiran.保険者番号.get項目ID())
                && !currentSource.get給付実績_保険者番号().equals(nextSource.get給付実績_保険者番号())) {
            return true;
        }
        return flg;
    }
}
