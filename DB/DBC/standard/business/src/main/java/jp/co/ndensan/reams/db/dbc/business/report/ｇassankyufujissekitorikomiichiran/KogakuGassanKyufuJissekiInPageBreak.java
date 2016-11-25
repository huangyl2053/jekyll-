/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算給付実績取込の改ページ処理するクラスです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInPageBreak extends PageBreaker<GassanKyufujissekiTorikomiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KogakuGassanKyufuJissekiInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanKyufujissekiTorikomiIchiranSource> currentSource,
            ReportLineRecord<GassanKyufujissekiTorikomiIchiranSource> nextSource) {

        if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().list_7.equals(nextSource.getSource().list_7)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.申請年月日.get項目ID())
                && !currentSource.getSource().list_8.equals(nextSource.getSource().list_8)) {
            return true;
        } else if (this.breakKeysList.contains(KogakuGassanKyufuJissekiInOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().shikyuShinseishoSeiriNo.equals(nextSource.getSource().shikyuShinseishoSeiriNo)) {
            return true;
        }

        return false;
    }
}
