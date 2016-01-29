/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;

/**
 * 広域内住所地特例者一覧表ヘッダEditorです。
 */
class KoikinaiJushochitokureishaIchiranhyoHeaderEditor implements KoikinaiJushochitokureishaIchiranhyoEditor {

    private final KoikinaiJushochitokureishaIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KoikinaiJushochitokureishaIchiranhyoItem}
     */
    protected KoikinaiJushochitokureishaIchiranhyoHeaderEditor(KoikinaiJushochitokureishaIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public KoikinaiJushochitokureishaIchiranhyoReportSource edit(KoikinaiJushochitokureishaIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private KoikinaiJushochitokureishaIchiranhyoReportSource editHeader(KoikinaiJushochitokureishaIchiranhyoReportSource source) {

        source.printTimeStamp = item.get印刷日時();
        // TODO 袁献輝 rseファイルにninshoshaShimeiを存在しない　2016/02/26。
//        source.pageCount = item.getページ数();
        source.shichosonCode = item.get市町村コード();
        source.shichosonName = item.get市町村名();
        source.shutsuryokujun1 = item.get並び順１();
        source.shutsuryokujun2 = item.get並び順２();
        source.shutsuryokujun3 = item.get並び順３();
        source.shutsuryokujun4 = item.get並び順４();
        source.shutsuryokujun5 = item.get並び順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage2 = item.get改頁２();
        source.kaipage3 = item.get改頁３();
        source.kaipage4 = item.get改頁４();
        source.kaipage5 = item.get改頁５();
        return source;
    }
}
