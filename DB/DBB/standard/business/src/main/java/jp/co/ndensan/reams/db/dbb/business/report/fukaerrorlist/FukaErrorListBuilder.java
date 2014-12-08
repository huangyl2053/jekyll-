/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukaerrorlist;

import jp.co.ndensan.reams.ur.urz.business.report.IReportBuilder;

/**
 * 賦課エラー一覧内部帳票のビルダーです。
 *
 * @author N9606 漢那 憲作
 */
public final class FukaErrorListBuilder implements IReportBuilder<FukaErrorListSource> {

    private final IFukaErrorListSourceBuilder editor;

    /**
     * コンストラクタです。
     *
     * @param sourceBuilder 賦課エラー一覧ソースビルダ
     */
    public FukaErrorListBuilder(IFukaErrorListSourceBuilder sourceBuilder) {
        this.editor = sourceBuilder;
    }

    @Override
    public FukaErrorListSource build() {
        return editor.buildSource();
    }
}
