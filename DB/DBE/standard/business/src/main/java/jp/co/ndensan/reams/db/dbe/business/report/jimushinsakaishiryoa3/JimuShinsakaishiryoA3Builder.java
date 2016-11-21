/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局審査会資料組み合わせ一覧A4版Builderクラスです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA3Builder implements IJimuShinsakaishiryoA3Builder {

    private final IJimuShinsakaishiryoA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJimuShinsakaishiryoA3Editor}
     */
    public JimuShinsakaishiryoA3Builder(IJimuShinsakaishiryoA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JimuShinsakaishiryoA3ReportSource}
     */
    @Override
    public JimuShinsakaishiryoA3ReportSource build() {
        return ReportEditorJoiner.from(new JimuShinsakaishiryoA3ReportSource()).join(editor).buildSource();
    }
}
