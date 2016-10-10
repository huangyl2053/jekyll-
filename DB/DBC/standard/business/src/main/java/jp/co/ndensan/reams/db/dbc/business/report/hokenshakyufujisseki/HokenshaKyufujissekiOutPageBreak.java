/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.hokenshakyufujisseki;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 保険者保有給付実績情報作成の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiOutPageBreak extends PageBreaker<KyufuJisekiJohoSofuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public HokenshaKyufujissekiOutPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufuJisekiJohoSofuIchiranSource> currentSource,
            ReportLineRecord<KyufuJisekiJohoSofuIchiranSource> nextSource) {
        if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.保険者番号.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.サービス提供年月.get項目ID())
                && !currentSource.getSource().listUpper_7.equals(nextSource.getSource().listUpper_7)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.事業者番号.get項目ID())
                && !currentSource.getSource().listUpper_9.equals(nextSource.getSource().listUpper_9)) {
            return true;
        }
        return canBreak(currentSource, nextSource);
    }

    private boolean canBreak(ReportLineRecord<KyufuJisekiJohoSofuIchiranSource> currentSource,
            ReportLineRecord<KyufuJisekiJohoSofuIchiranSource> nextSource) {
        if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.入力識別番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.整理番号.get項目ID())
                && !currentSource.getSource().listUpper_10.equals(nextSource.getSource().listUpper_10)) {
            return true;
        } else if (this.breakKeysList.contains(HokenshaKyufujissekiOutOrder.現物償還の別.get項目ID())
                && !currentSource.getSource().listUpper_8.equals(nextSource.getSource().listUpper_8)) {
            return true;
        }
        return false;
    }
}
