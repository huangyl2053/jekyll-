/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査依頼一覧表Builderクラスです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
class ChosaIraiIchiranhyoBuilderImpl implements IChosaIraiIchiranhyoBuilder {

    private final IChosaIraiIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link ChosaIraiIchiranhyoEditor}
     */
    public ChosaIraiIchiranhyoBuilderImpl(IChosaIraiIchiranhyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     *
     * @return ChosaIraiIchiranhyoReportSource 認定調査依頼一覧表Sourceクラス
     */
    @Override
    public ChosaIraiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ChosaIraiIchiranhyoReportSource()).join(bodyEditor).buildSource();
    }
}
