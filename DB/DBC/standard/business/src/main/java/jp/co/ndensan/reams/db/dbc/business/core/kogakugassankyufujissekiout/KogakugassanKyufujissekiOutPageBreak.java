/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassankyufujissekiout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算給付実績情報作成の帳票出力PageBreakクラスです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class KogakugassanKyufujissekiOutPageBreak extends PageBreaker<GassanKyufujissekiSofuIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeysList List<RString>
     */
    public KogakugassanKyufujissekiOutPageBreak(List<RString> breakKeysList) {
        this.breakKeysList = breakKeysList;
    }

    @Override
    public List<RString> breakKeys() {
        return this.breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanKyufujissekiSofuIchiranSource> currentSource,
            ReportLineRecord<GassanKyufujissekiSofuIchiranSource> nextSource) {
        boolean flag = false;
        isHihokenBreak(currentSource, nextSource);
        if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().list_7.equals(nextSource.getSource().list_7)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.申請年月日.get項目ID())
                && !currentSource.getSource().list_8.equals(nextSource.getSource().list_8)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_4.equals(nextSource.getSource().list_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.決定年月日.get項目ID())
                && !currentSource.getSource().list_9.equals(nextSource.getSource().list_9)) {
            flag = true;
        }
        return flag;
    }

    private boolean isHihokenBreak(ReportLineRecord<GassanKyufujissekiSofuIchiranSource> currentSource,
            ReportLineRecord<GassanKyufujissekiSofuIchiranSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(KogakugassanKyufujissekiOutputOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }
}
