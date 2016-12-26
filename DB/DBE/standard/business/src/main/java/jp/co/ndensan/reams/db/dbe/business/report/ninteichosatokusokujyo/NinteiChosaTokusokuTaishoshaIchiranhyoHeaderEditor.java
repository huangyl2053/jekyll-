/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査督促対象者一覧表ヘッダEditorです。
 *
 * @reamsid_L DBE-0030-030 xuyue
 */
class NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor implements INinteiChosaTokusokuTaishoshaIchiranhyoEditor {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity;
    private static final RString タイトル = new RString("認定調査督促対象者一覧表");
    private static final RString 事業者名称タイトル = new RString("調査機関名称");
    private static final RString 事業者住所タイトル = new RString("調査機関住所");
    private static final RString 氏名タイトル = new RString("調査員氏名");
    private static final RString 事業者電話番号タイトル = new RString("調査機関TEL");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokuTaishoshaIchiranhyoItem}
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor(
            NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity) {
        this.entity = entity;
    }

    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource edit(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        editタイトル(source);
        edit発行年月日時分秒(source);
        edit市町村コード(source);
        edit市町村名称(source);
        edit事業者名称タイトル(source);
        edit事業者住所タイトル(source);
        edit氏名タイトル(source);
        edit事業者電話番号タイトル(source);
        return source;
    }

    private void editタイトル(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.title = タイトル;
    }

    private void edit発行年月日時分秒(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");

        source.printTimeStamp = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + RString.HALF_SPACE + timeFormat);
    }

    private void edit市町村コード(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.cityCode = entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード().getColumnValue();
    }

    private void edit市町村名称(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.cityName = entity.getTemp_市町村名称();
    }

    private void edit事業者名称タイトル(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.kikanNameTitle = 事業者名称タイトル;
    }

    private void edit事業者住所タイトル(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.kikanJushoTitle = 事業者住所タイトル;
    }

    private void edit氏名タイトル(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.nameTitle = 氏名タイトル;
    }

    private void edit事業者電話番号タイトル(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.kikanTelTitle = 事業者電話番号タイトル;
    }
}
