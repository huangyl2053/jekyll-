/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC300002_サービスコード別利用状況 のBuilderクラスです。
 *
 * @reamsid_L DBC-3340-040 qinzhen
 */
public class ServiceCodeBetsuRiyoJokyoBuilder implements IServiceCodeBetsuRiyoJokyoBuilder {

    private final IServiceCodeBetsuRiyoJokyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IServiceCodeBetsuRiyoJokyoEditor
     */
    public ServiceCodeBetsuRiyoJokyoBuilder(IServiceCodeBetsuRiyoJokyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public ServiceCodeBetsuRiyoJokyoSource build() {
        return ReportEditorJoiner.from(new ServiceCodeBetsuRiyoJokyoSource())
                .join(editor).buildSource();
    }
}
