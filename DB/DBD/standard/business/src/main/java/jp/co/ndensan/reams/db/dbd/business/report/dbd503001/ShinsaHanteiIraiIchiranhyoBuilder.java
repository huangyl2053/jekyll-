/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd503001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査判定依頼一覧表Builderクラスです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
public class ShinsaHanteiIraiIchiranhyoBuilder implements IShinsaHanteiIraiIchiranhyoBuilder {

    private final IShinsaHanteiIraiIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShinsaHanteiIraiIchiranhyoEditor}
     */
    ShinsaHanteiIraiIchiranhyoBuilder(IShinsaHanteiIraiIchiranhyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaHanteiIraiIchiranhyoReportSource}
     */
    @Override
    public ShinsaHanteiIraiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ShinsaHanteiIraiIchiranhyoReportSource()).join(bodyEditor).buildSource();
    }
}
