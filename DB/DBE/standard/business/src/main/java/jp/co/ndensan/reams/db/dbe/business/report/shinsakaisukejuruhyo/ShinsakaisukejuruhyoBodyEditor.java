/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護認定審査会スケジュール表ディEditorです。
 */
class ShinsakaisukejuruhyoBodyEditor implements IShinsakaisukejuruhyoEditor {

    private static final int INDEX_2 = 2;
    private static final int INDEX_8 = 8;
    private static final RString FUNN = new RString(":");
    private final ShinsakaisukejuruhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaisukejuruhyoItem}
     */
    protected ShinsakaisukejuruhyoBodyEditor(ShinsakaisukejuruhyoBodyItem item) {
        this.item = item;
    }

    @Override
    public ShinsakaisukejuruhyoReportSource edit(ShinsakaisukejuruhyoReportSource source) {
        return editBody(source);
    }

    private ShinsakaisukejuruhyoReportSource editBody(ShinsakaisukejuruhyoReportSource source) {
        source.listShinsakaiSukejuru_1 = new RString(String.valueOf(item.get項番()));
        source.listShinsakaiSukejuru_2 = item.get審査会番号();
        source.listShinsakaiSukejuru_3 = new FlexibleDate(item.get開催日()).wareki().toDateString();
        RStringBuilder 開催時間 = new RStringBuilder(item.get開催時間());
        開催時間.insert(INDEX_2, FUNN);
        開催時間.insert(INDEX_8, FUNN);
        source.listShinsakaiSukejuru_4 = 開催時間.toRString();
        source.listShinsakaiSukejuru_5 = item.get合議体();
        source.listShinsakaiSukejuru_6 = item.get会場();
        source.listShinsakaiSukejuru_7 = item.get住所();
        source.listShinsakaiSukejuru_8 = item.get電話番号();
        return source;
    }
}
