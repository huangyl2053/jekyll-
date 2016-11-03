/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinshinsakaishiryoa4.IinShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員審査会資料組み合わせ一覧A4版Builderクラスです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaishiryoA4Builder implements IIinShinsakaishiryoA4Builder {

    private final IIinShinsakaishiryoA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinShinsakaishiryoA4Editor}
     */
    public IinShinsakaishiryoA4Builder(IIinShinsakaishiryoA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IinShinsakaishiryoA4ReportSource}
     */
    @Override
    public IinShinsakaishiryoA4ReportSource build() {
        return ReportEditorJoiner.from(new IinShinsakaishiryoA4ReportSource()).join(editor).buildSource();
    }
}
