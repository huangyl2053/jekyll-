/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;

/**
 * 広域内住所地特例者一覧表ボディEditorです。
 */
class KoikinaiJushochitokureishaIchiranhyoBodyEditor implements KoikinaiJushochitokureishaIchiranhyoEditor {

    private final KoikinaiJushochitokureishaIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KoikinaiJushochitokureishaIchiranhyoItem}
     */
    protected KoikinaiJushochitokureishaIchiranhyoBodyEditor(KoikinaiJushochitokureishaIchiranhyoBodyItem item) {
        this.item = item;
    }

    /**
     * 広域内住所地特例者一覧表ボディEditorです。
     *
     * @param source 広域内住所地特例者一覧表Source
     * @return 広域内住所地特例者一覧表Source
     */
    @Override
    public KoikinaiJushochitokureishaIchiranhyoReportSource edit(KoikinaiJushochitokureishaIchiranhyoReportSource source) {
        return editBody(source);
    }

    private KoikinaiJushochitokureishaIchiranhyoReportSource editBody(KoikinaiJushochitokureishaIchiranhyoReportSource source) {
        source.listUpper_1 = item.get被保険者番号();
        source.listUpper_2 = item.get氏名カナ();
        source.listUpper_3 = item.get生年月日();
        source.listUpper_4 = item.get住所コード();
        source.listUpper_5 = item.get行政区CD();
        source.listUpper_6 = item.get行政区();
        source.listUpper_7 = item.get取得日();
        source.listUpper_8 = item.get取得届出日();
        source.listUpper_9 = item.get喪失日();
        source.listUpper_10 = item.get喪失届出日();
        source.listUpper_11 = item.get資格区分();
        source.listUpper_12 = item.get住特();
        source.listLower_1 = item.get識別コード();
        source.listLower_2 = item.get氏名();
        source.listLower_3 = item.get性別();
        source.listLower_4 = item.get世帯コード();
        source.listLower_5 = item.get住所();
        source.listLower_6 = item.get広住取得日();
        source.listLower_7 = item.get広住取得届出日();
        source.listLower_8 = item.get広住喪失日();
        source.listLower_9 = item.get広住喪失届出日();
        source.listLower_10 = item.get措置市町村コード();
        source.listLower_11 = item.get措置市町村名称();
        return source;
    }
}
