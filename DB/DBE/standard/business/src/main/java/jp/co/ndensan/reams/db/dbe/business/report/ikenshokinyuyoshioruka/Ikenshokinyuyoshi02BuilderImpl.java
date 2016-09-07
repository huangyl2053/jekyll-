/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書（オルカ）Builderのクラスです。
 *
 * @reamsid_L DBE-1600-021 lishengli
 */
public class Ikenshokinyuyoshi02BuilderImpl implements IIkenshokinyuyoshi02Builder {

    private final IIkenshokinyuyoshi02Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIkenshokinyuyoshi02Editor}
     */
    public Ikenshokinyuyoshi02BuilderImpl(IIkenshokinyuyoshi02Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link Ikenshokinyuyoshi02ReportSource}
     */
    @Override
    public Ikenshokinyuyoshi02ReportSource build() {
        return ReportEditorJoiner.from(new Ikenshokinyuyoshi02ReportSource()).join(editor).buildSource();
    }
}
