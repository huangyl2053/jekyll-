/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 計画届出状況チェックリストBuilderクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaBuilder
        implements IKyotakuServiceKeikakuSaBuilder {

    private final IKyotakuServiceKeikakuSaEditor headerEditor;
    private final IKyotakuServiceKeikakuSaEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKyotakuServiceKeikakuSaEditor
     * @param bodyEditor IKyotakuServiceKeikakuSaEditor
     */
    public KyotakuServiceKeikakuSaBuilder(IKyotakuServiceKeikakuSaEditor headerEditor,
            IKyotakuServiceKeikakuSaEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.headerEditor = headerEditor;
    }

    @Override
    public KyotakuServiceKeikakuSakuseiSource build() {
        return ReportEditorJoiner.from(new KyotakuServiceKeikakuSakuseiSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
