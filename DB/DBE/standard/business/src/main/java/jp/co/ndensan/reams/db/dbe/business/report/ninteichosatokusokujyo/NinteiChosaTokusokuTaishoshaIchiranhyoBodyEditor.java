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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査督促対象者一覧表ボディEditorです。
 *
 * @reamsid_L DBE-0030-030 xuyue
 */
class NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor implements INinteiChosaTokusokuTaishoshaIchiranhyoEditor {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokuTaishoshaIchiranhyoItem}
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoBodyEditor(NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity) {
        this.entity = entity;
    }

    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource edit(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        editNo(source);
        edit保険者名(source);
        edit被保険者氏名カナ(source);
        edit申請日(source);
        edit督促状発行日(source);
        edit事業者名称(source);
        edit事業者住所(source);
        edit被保険者番号(source);
        edit被保険者氏名(source);
        edit調査員名(source);
        edit事業者電話番号(source);
        return source;
    }

    private void editNo(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listNo_1 = new RString(String.valueOf(entity.get行番号()));
    }

    private void edit保険者名(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listUpper1_1 = entity.getTemp_市町村名称() == null ? RString.EMPTY : entity.getTemp_市町村名称();
    }

    private void edit被保険者氏名カナ(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listUpper1_2 = entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue();
    }

    private void edit申請日(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listShinseiYMD_1 = entity.getTemp_申請日() == null ? RString.EMPTY : entity.getTemp_申請日().
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private void edit督促状発行日(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listTokusokujoHakkoYMD_1 = entity.getTemp_督促状発行日() == null ? RString.EMPTY : entity.getTemp_督促状発行日().
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private void edit事業者名称(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listUpper2_1 = entity.getTemp_事業者名称() == null ? RString.EMPTY : entity.getTemp_事業者名称();
    }

    private void edit事業者住所(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listUpper2_2 = entity.getTemp_事業者住所() == null ? RString.EMPTY : entity.getTemp_事業者住所();
    }

    private void edit被保険者番号(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listLower1_1 = entity.getTemp_被保険者番号() == null ? RString.EMPTY : entity.getTemp_被保険者番号();
    }

    private void edit被保険者氏名(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listLower1_2 = entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue();
    }

    private void edit調査員名(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listLower2_1 = entity.getTemp_調査員氏名() == null ? RString.EMPTY : entity.getTemp_調査員氏名();
    }

    private void edit事業者電話番号(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        source.listLower2_2 = entity.getTemp_事業者電話番号() == null ? RString.EMPTY : entity.getTemp_事業者電話番号().getColumnValue();
    }
}
