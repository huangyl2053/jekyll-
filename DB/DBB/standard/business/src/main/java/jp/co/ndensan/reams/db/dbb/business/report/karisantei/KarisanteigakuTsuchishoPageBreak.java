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
        //QA971 保留中
        if (this.breakKeysList.contains(KarisanteigakuTsuchishoOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        }
        return flag;
    }
}
