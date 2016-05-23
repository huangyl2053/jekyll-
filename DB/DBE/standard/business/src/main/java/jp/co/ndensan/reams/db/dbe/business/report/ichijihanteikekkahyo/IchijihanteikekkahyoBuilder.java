/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 一次判定結果Builderクラスです。
 *
 * @reamsid_L DBE-0230-060 lizhuoxuan
 */
class IchijihanteikekkahyoBuilder implements IIchijihanteikekkahyoBuilder {

    private final IIchijihanteikekkahyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIchijihanteikekkahyoEditor}
     */
    public IchijihanteikekkahyoBuilder(IIchijihanteikekkahyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IchijihanteikekkahyoReportSource}
     */
    @Override
    public IchijihanteikekkahyoReportSource build() {
        return ReportEditorJoiner.from(new IchijihanteikekkahyoReportSource()).join(editor).buildSource();
    }

}
