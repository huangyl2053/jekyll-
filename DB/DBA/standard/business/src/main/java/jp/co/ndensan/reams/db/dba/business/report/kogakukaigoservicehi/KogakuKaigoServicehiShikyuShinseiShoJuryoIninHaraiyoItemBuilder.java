/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.db.dba.entity.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のBuilderクラスです。
 */
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemBuilder
        implements IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoBuilder {

    private final IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor
     * {@link IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoEditor}
     */
    public KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemBuilder(IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return
     * {@link KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource}
     */
    @Override
    public KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource build() {
        return ReportEditorJoiner.from(new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource()).join(editor).buildSource();
    }
}
