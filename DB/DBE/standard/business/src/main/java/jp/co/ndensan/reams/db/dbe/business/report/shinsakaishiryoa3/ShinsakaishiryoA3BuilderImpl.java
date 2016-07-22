/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査対象者一覧表A3Builderクラスです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
class ShinsakaishiryoA3BuilderImpl implements IShinsakaishiryoA3Builder {

    private final IShinsakaishiryoA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaishiryoA3Editor}
     */
    public ShinsakaishiryoA3BuilderImpl(IShinsakaishiryoA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaishiryoA3ReportSource}
     */
    @Override
    public ShinsakaishiryoA3ReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaishiryoA3ReportSource()).join(editor).buildSource();
    }
}
