/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 資格取得者不整合リストBuilderクラスです。
 *
 * @reamsid_L DBU-4020-040 lishengli
 */
public class ShikakushutokushaFuseigoIchiranhyoBuilderImpl implements IShikakushutokushaFuseigoIchiranhyoBuilder {

    private final IShikakushutokushaFuseigoIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShikakushutokushaFuseigoIchiranhyoEditor}
     */
    public ShikakushutokushaFuseigoIchiranhyoBuilderImpl(IShikakushutokushaFuseigoIchiranhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShikakushutokushaFuseigoIchiranhyoReportSource}
     */
    @Override
    public ShikakushutokushaFuseigoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ShikakushutokushaFuseigoIchiranhyoReportSource()).join(editor).buildSource();
    }
}
