/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険診断命令書Builderクラスです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
class KaigohokenShindanMeireishoBuiderImpl implements IKaigohokenShindanMeireishoBuider {

    private final IKaigohokenShindanMeireishoEditor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IKaigohokenShindanMeireishoEditor}
     */
    public KaigohokenShindanMeireishoBuiderImpl(IKaigohokenShindanMeireishoEditor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigohokenShindanMeireishoReportSource}
     */
    @Override
    public KaigohokenShindanMeireishoReportSource build() {
        return ReportEditorJoiner.from(new KaigohokenShindanMeireishoReportSource()).join(headerEditor).buildSource();
    }

}
