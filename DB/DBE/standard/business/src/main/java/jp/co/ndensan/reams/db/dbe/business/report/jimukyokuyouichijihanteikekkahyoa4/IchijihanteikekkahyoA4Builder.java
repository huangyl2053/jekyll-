/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用一次判定結果票A4Builderクラスです。
 *
 * @reamsid_L DBE-0150-400 lishengli
 */
class IchijihanteikekkahyoA4Builder implements IIchijihanteikekkahyoA4Builder {

    private final IIchijihanteikekkahyoA4Editor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IIchijihanteikekkahyoA4Editor}
     * @param bodyEditor {@link IIchijihanteikekkahyoA4Editor}
     */
    public IchijihanteikekkahyoA4Builder(IIchijihanteikekkahyoA4Editor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IchijihanteikekkahyoA4ReportSource}
     */
    @Override
    public IchijihanteikekkahyoA4ReportSource build() {
        return ReportEditorJoiner.from(new IchijihanteikekkahyoA4ReportSource()).join(headerEditor).buildSource();
    }

}
