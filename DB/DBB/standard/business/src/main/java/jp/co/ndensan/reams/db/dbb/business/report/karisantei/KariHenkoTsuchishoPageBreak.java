/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisantei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 仮算定額変更通知書発行一覧表の改頁クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class KariHenkoTsuchishoPageBreak extends PageBreaker<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public KariHenkoTsuchishoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> currentSource,
            ReportLineRecord<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.番地コード.get項目ID())
                && !currentSource.getSource().banchiCode.equals(nextSource.getSource().banchiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.地区１.get項目ID())
                && !currentSource.getSource().chikuCode1.equals(nextSource.getSource().chikuCode1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.地区２.get項目ID())
                && !currentSource.getSource().chikuCode2.equals(nextSource.getSource().chikuCode2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.地区３.get項目ID())
                && !currentSource.getSource().chikuCode3.equals(nextSource.getSource().chikuCode3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.世帯コード.get項目ID())
                && !currentSource.getSource().listUpper_4.equals(nextSource.getSource().listUpper_4)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.識別コード.get項目ID())
                && !currentSource.getSource().shikibetsuCode.equals(nextSource.getSource().shikibetsuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.生年月日.get項目ID())
                && !currentSource.getSource().seinengappiYMD.equals(nextSource.getSource().seinengappiYMD)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.性別.get項目ID())
                && !currentSource.getSource().seibetsuCode.equals(nextSource.getSource().seibetsuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.年金コード.get項目ID())
                && !currentSource.getSource().nenkinCode.equals(nextSource.getSource().nenkinCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.納組コード.get項目ID())
                && !currentSource.getSource().nokumiCode.equals(nextSource.getSource().nokumiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KariHenkoTsuchishoOutPutOrder.生活保護種別.get項目ID())
                && !currentSource.getSource().seihoFlag.equals(nextSource.getSource().seihoFlag)) {
            flag = true;
        }
        return flag;

    }
}
