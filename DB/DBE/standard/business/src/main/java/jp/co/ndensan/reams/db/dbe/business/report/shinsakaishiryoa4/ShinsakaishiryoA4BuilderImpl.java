/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査対象者一覧表A4Builderクラスです。
 *
 * @reamsid_L DBE-0150-260 lishengli
 */
class ShinsakaishiryoA4BuilderImpl implements IShinsakaishiryoA4Builder {

    private final IShinsakaishiryoA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsakaishiryoA4Editor}
     */
    public ShinsakaishiryoA4BuilderImpl(IShinsakaishiryoA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsakaishiryoA4ReportSource}
     */
    @Override
    public ShinsakaishiryoA4ReportSource build() {
        return ReportEditorJoiner.from(new ShinsakaishiryoA4ReportSource()).join(editor).buildSource();
    }
}
