/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用一次判定結果票A3Builderクラスです。
 *
 * @reamsid_L DBE-0150-320 lishengli
 */
class IchijihanteikekkahyoA3Builder implements IIchijihanteikekkahyoA3Builder {

    private final IIchijihanteikekkahyoA3Editor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IIchijihanteikekkahyoA3Editor}
     */
    public IchijihanteikekkahyoA3Builder(IIchijihanteikekkahyoA3Editor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IchijihanteikekkahyoA3ReportSource}
     */
    @Override
    public IchijihanteikekkahyoA3ReportSource build() {
        return ReportEditorJoiner.from(new IchijihanteikekkahyoA3ReportSource()).join(headerEditor).buildSource();
    }

}
