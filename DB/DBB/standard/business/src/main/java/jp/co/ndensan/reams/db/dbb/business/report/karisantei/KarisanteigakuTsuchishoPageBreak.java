/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisantei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表の改頁クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class KarisanteigakuTsuchishoPageBreak extends PageBreaker<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public KarisanteigakuTsuchishoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> nextSource) {

        boolean flag = false;
        if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.番地コード.get項目ID())
                && !currentSource.getSource().banchiCode.equals(nextSource.getSource().banchiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.地区１.get項目ID())
                && !currentSource.getSource().chikuCode1.equals(nextSource.getSource().chikuCode1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.地区２.get項目ID())
                && !currentSource.getSource().chikuCode2.equals(nextSource.getSource().chikuCode2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.地区３.get項目ID())
                && !currentSource.getSource().chikuCode3.equals(nextSource.getSource().chikuCode3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.世帯コード.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.識別コード.get項目ID())
                && !currentSource.getSource().shikibetsuCode.equals(nextSource.getSource().shikibetsuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().kanaMeisho.equals(nextSource.getSource().kanaMeisho)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.生年月日.get項目ID())
                && !currentSource.getSource().listUpper_5.equals(nextSource.getSource().listUpper_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.性別.get項目ID())
                && !currentSource.getSource().listUpper_6.equals(nextSource.getSource().listUpper_6)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().hihokenshaNo.equals(nextSource.getSource().hihokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.年金コード.get項目ID())
                && !currentSource.getSource().nenkinCode.equals(nextSource.getSource().nenkinCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.納組コード.get項目ID())
                && !currentSource.getSource().nokumiCode.equals(nextSource.getSource().nokumiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.生活保護種別.get項目ID())
                && !currentSource.getSource().seihoFlag.equals(nextSource.getSource().seihoFlag)) {
            flag = true;
        } else if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.調定事由.get項目ID())
                && !currentSource.getSource().choteiJiyu.equals(nextSource.getSource().choteiJiyu)) {
            flag = true;
        }
        return flag;

    }
}
