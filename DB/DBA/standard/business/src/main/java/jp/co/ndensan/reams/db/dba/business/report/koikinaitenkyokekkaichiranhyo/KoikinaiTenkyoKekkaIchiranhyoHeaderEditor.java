/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;

/**
 * 広域内転居結果一覧表ヘッダEditorです。
 */
class KoikinaiTenkyoKekkaIchiranhyoHeaderEditor implements IKoikinaiTenkyoKekkaIchiranhyoEditor {

    private final KoikinaiTenkyoKekkaIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KoikinaiTenkyoKekkaIchiranhyoHeadItem}
     */
    protected KoikinaiTenkyoKekkaIchiranhyoHeaderEditor(KoikinaiTenkyoKekkaIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public KoikinaiTenkyoKekkaIchiranhyoReportSource edit(KoikinaiTenkyoKekkaIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private KoikinaiTenkyoKekkaIchiranhyoReportSource editHeader(KoikinaiTenkyoKekkaIchiranhyoReportSource source) {

        source.printTimeStamp = item.get印刷日時();
//        source.pageCount = item.getページ数();
        source.shichosonCode = item.get市町村コード();
        source.shichosonName = item.get市町村名();
        return source;
    }
}
