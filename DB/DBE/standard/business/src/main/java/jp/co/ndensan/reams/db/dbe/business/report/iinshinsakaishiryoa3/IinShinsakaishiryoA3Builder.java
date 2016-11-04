/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員審査会資料組み合わせ一覧A3Builderのクラスです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Builder implements IIinShinsakaishiryoA3Builder {

    private final IIinShinsakaishiryoA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinShinsakaishiryoA3Editor}
     */
    public IinShinsakaishiryoA3Builder(IIinShinsakaishiryoA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IinShinsakaishiryoA3ReportSource}
     */
    @Override
    public IinShinsakaishiryoA3ReportSource build() {
        return ReportEditorJoiner.from(new IinShinsakaishiryoA3ReportSource()).join(editor).buildSource();
    }

}
