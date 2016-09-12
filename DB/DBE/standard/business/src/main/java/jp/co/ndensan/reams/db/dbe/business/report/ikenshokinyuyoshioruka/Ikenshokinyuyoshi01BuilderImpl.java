/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書（オルカ）Builderのクラスです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01BuilderImpl implements IIkenshokinyuyoshi01Builder {

    private final IIkenshokinyuyoshi01Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIkenshokinyuyoshi01Editor}
     */
    public Ikenshokinyuyoshi01BuilderImpl(IIkenshokinyuyoshi01Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link Ikenshokinyuyoshi01ReportSource}
     */
    @Override
    public Ikenshokinyuyoshi01ReportSource build() {
        return ReportEditorJoiner.from(new Ikenshokinyuyoshi01ReportSource()).join(editor).buildSource();
    }
}
