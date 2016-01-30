/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;

/**
 * 広域内転居結果一覧表ボディEditorです。
 */
class KoikinaiTenkyoKekkaIchiranhyoBodyEditor implements IKoikinaiTenkyoKekkaIchiranhyoEditor {

    private final KoikinaiTenkyoKekkaIchiranhyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KoikinaiTenkyoKekkaIchiranhyoBodyItem}
     */
    protected KoikinaiTenkyoKekkaIchiranhyoBodyEditor(KoikinaiTenkyoKekkaIchiranhyoBodyItem item) {
        this.item = item;
    }

    /**
     * 広域内転居結果一覧表ボディEditorです。
     *
     * @param source 広域内転居結果一覧表Source
     * @return 広域内転居結果一覧表Source
     */
    @Override
    public KoikinaiTenkyoKekkaIchiranhyoReportSource edit(KoikinaiTenkyoKekkaIchiranhyoReportSource source) {
        return editBody(source);
    }

    private KoikinaiTenkyoKekkaIchiranhyoReportSource editBody(KoikinaiTenkyoKekkaIchiranhyoReportSource source) {
        source.listHihokenshaNo_1 = item.get被保険者番号();
        source.listUpper_1 = item.get氏名カナ();
        source.listUpper_2 = item.get旧住民コード();
        source.listUpper_3 = item.get前住所();
        source.listUpper_4 = item.get転出予定日();
        source.listUpper_5 = item.get転出確定日();
        source.listUpper_6 = item.get転出確定通知日();
        source.listUpper_7 = item.get処理日();
        source.listLower_1 = item.get氏名();
        source.listLower_2 = item.get新住民コード();
        source.listLower_3 = item.get現住所();
        source.listLower_4 = item.get登録異動日();
        source.listLower_5 = item.get登録届出日();
        source.listLower_6 = item.get異動情報();
        return source;
    }
}
