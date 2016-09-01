/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 更新申請のお知らせ通知書発行一覧表Builderクラスです。
 *
 * @reamsid_L DBD-2030-040 donghj
 */
public class KoshinShinseiTsuchishoHakkoIchiranhyoBuilder implements IKoshinShinseiTsuchishoHakkoIchiranhyoBuilder {

    private final IKoshinShinseiTsuchishoHakkoIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKoshinShinseiTsuchishoHakkoIchiranhyoEditor}
     */
    KoshinShinseiTsuchishoHakkoIchiranhyoBuilder(IKoshinShinseiTsuchishoHakkoIchiranhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KoshinShinseiTsuchishoHakkoIchiranhyoReportSource}
     */
    @Override
    public KoshinShinseiTsuchishoHakkoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new KoshinShinseiTsuchishoHakkoIchiranhyoReportSource()).join(editor).buildSource();
    }

}
