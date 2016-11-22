/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局審査会資料組み合わせ一覧A4版Builderクラスです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA4Builder implements IJimuShinsakaishiryoA4Builder {

    private final IJimuShinsakaishiryoA4Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJimuShinsakaishiryoA4Editor}
     */
    public JimuShinsakaishiryoA4Builder(IJimuShinsakaishiryoA4Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JimuShinsakaishiryoA4ReportSource}
     */
    @Override
    public JimuShinsakaishiryoA4ReportSource build() {
        return ReportEditorJoiner.from(new JimuShinsakaishiryoA4ReportSource()).join(editor).buildSource();
    }
}
