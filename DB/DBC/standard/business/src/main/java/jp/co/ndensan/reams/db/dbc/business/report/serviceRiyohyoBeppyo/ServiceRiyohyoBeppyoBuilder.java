/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表Builderのインターフェースクラスです。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
public class ServiceRiyohyoBeppyoBuilder implements IServiceRiyohyoBeppyoBuilder {

    private final IServiceRiyohyoBeppyoHeaderEditor headerEditor;
    private final IServiceRiyohyoBeppyoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IServiceRiyohyoBeppyoHeaderEditor}
     * @param bodyEditor {@link IServiceRiyohyoBeppyoBodyEditor}
     */
    public ServiceRiyohyoBeppyoBuilder(IServiceRiyohyoBeppyoHeaderEditor headerEditor,
            IServiceRiyohyoBeppyoBodyEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ServiceRiyohyoBeppyoSource}
     */
    @Override
    public ServiceRiyohyoBeppyoSource build() {
        return ReportEditorJoiner.from(new ServiceRiyohyoBeppyoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
