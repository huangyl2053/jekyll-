/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsantei;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 保険料額決定通知書発行一覧表の改頁クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class KaigoHokenryogakuPageBreak extends PageBreaker<KaigoHokenryogakuSource> {

    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeys List<RString>
     */
    public KaigoHokenryogakuPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KaigoHokenryogakuSource> currentSource,
            ReportLineRecord<KaigoHokenryogakuSource> nextSource) {
        boolean flag = false;
        //QA971 保留中
        if (this.breakKeysList.contains(KaigoHokenryogakuOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().listLower_2.equals(nextSource.getSource().listLower_2)) {
            flag = true;
        }
        return flag;
    }
}
