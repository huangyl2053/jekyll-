/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReportSource;

/**
 * 要介護認定区分変更申請書ボディEditorです。
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
public class YokaigoNinteikbnHenkoShinseishoBodyEditor implements IYokaigoNinteikbnHenkoShinseishoEditor {

    private final ShinseiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定区分変更申請書の一覧Entity
     */
    public YokaigoNinteikbnHenkoShinseishoBodyEditor(ShinseiShoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定区分変更申請書ボディEditorです。
     *
     * @param source 要介護認定区分変更申請書Source
     * @return 要介護認定区分変更申請書Source
     */
    @Override
    public YokaigoNinteikbnHenkoShinseishoReportSource edit(YokaigoNinteikbnHenkoShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private YokaigoNinteikbnHenkoShinseishoReportSource bodyEdit(YokaigoNinteikbnHenkoShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = entity.get市町村名称();
        source.birthYMD = entity.get生年月日();
        source.hihokenJusho = entity.get住所();
        source.hihokenshaName = entity.get被保険者名称();
        source.hihokenshaNameKana = entity.get被保険者名称カナ();
        source.hihokenshaNo = entity.get被保険者番号();
        source.hihokenshaTelNo = entity.get電話番号();
        source.hihokenshaYubinNo = entity.get郵便番号();
        source.seibetsu = entity.get性別();
        source.yokaigoKbn = entity.get要介護状態区分();
        source.yokoKikanSTYMD = entity.get有効期間開始年月日();
        source.yokoKikanEDYMD = entity.get有効期間終了年月日();
        source.yoshienKbn = entity.get要支援状態区分();
        source.tsuchiBun = entity.get通知文();

        return source;

    }
}
