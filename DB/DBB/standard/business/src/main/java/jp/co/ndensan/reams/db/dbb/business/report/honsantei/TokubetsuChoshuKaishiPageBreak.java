/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsantei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収開始通知書発行一覧表の改頁クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class TokubetsuChoshuKaishiPageBreak extends PageBreaker<TokubetsuChoshuKaishiSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public TokubetsuChoshuKaishiPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuKaishiSource> currentSource,
            ReportLineRecord<TokubetsuChoshuKaishiSource> nextSource) {
        boolean flag = false;
        //QA971 保留中
        if (this.breakKeysList.contains(TokubetsuChoshuKaishiPageOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listUpper_2.equals(nextSource.getSource().listUpper_2)) {
            flag = true;
        }
        return flag;
    }

}
