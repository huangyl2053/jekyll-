/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report;

import jp.co.ndensan.reams.db.dbb.business.report.parts.IFukaErrorListEditor;
import jp.co.ndensan.reams.db.dbb.business.report.parts.FukaErrorListSource;
import jp.co.ndensan.reams.ur.urz.business.report.IReportSourceBuilder;

/**
 * 賦課エラー一覧内部帳票のビルダーです。
 *
 * @author N9606 漢那 憲作
 */
public final class FukaErrorListBuilder implements IReportSourceBuilder<FukaErrorListSource> {

    private final IFukaErrorListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor 賦課エラー一覧エディタ
     */
    public FukaErrorListBuilder(IFukaErrorListEditor editor) {
        this.editor = editor;
    }

    @Override
    public FukaErrorListSource buildSource() {
        return editor.buildSource();
    }
}
