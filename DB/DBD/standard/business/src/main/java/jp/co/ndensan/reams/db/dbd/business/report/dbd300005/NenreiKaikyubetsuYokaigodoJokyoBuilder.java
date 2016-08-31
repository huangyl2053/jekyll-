/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300005;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 年齢階級別要介護度状況（統計表）Builderクラスです。
 *
 * @reamsid_L DBD-1790-040 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoBuilder implements INenreiKaikyubetsuYokaigodoJokyoBuilder {

    private final INenreiKaikyubetsuYokaigodoJokyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INenreiKaikyubetsuYokaigodoJokyoEditor}
     */
    NenreiKaikyubetsuYokaigodoJokyoBuilder(INenreiKaikyubetsuYokaigodoJokyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NenreiKaikyubetsuYokaigodoJokyoReportSource}
     */
    @Override
    public NenreiKaikyubetsuYokaigodoJokyoReportSource build() {
        return ReportEditorJoiner.from(new NenreiKaikyubetsuYokaigodoJokyoReportSource()).join(editor).buildSource();
    }

}
