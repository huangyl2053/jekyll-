/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kekkatsuchiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定結果通知一覧表Builderのクラスです。
 *
 * @reamsid_L DBE-0180-020 xuyannan
 */
public class KekkatsuchiIchiranhyoBuilderImpl implements IKekkatsuchiIchiranhyoBuilder {

    private final IKekkatsuchiIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKekkatsuchiIchiranhyoEditor}
     */
    public KekkatsuchiIchiranhyoBuilderImpl(IKekkatsuchiIchiranhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KekkatsuchiIchiranhyoReportSource}
     */
    @Override
    public KekkatsuchiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new KekkatsuchiIchiranhyoReportSource()).join(editor).buildSource();
    }

}
