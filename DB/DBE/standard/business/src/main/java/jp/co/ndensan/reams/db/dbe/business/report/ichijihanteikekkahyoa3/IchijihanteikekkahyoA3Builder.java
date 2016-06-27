/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員用一次判定結果票A3Builderクラスです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
class IchijihanteikekkahyoA3Builder implements IIchijihanteikekkahyoA3Builder {

    private final IIchijihanteikekkahyoA3Editor headerEditor;
    private final IIchijihanteikekkahyoA3Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IIchijihanteikekkahyoA3Editor}
     * @param bodyEditor {@link IIchijihanteikekkahyoA3Editor}
     */
    public IchijihanteikekkahyoA3Builder(IIchijihanteikekkahyoA3Editor headerEditor,
            IIchijihanteikekkahyoA3Editor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IchijihanteikekkahyoA3ReportSource}
     */
    @Override
    public IchijihanteikekkahyoA3ReportSource build() {
        return ReportEditorJoiner.from(new IchijihanteikekkahyoA3ReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
