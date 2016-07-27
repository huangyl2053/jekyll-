/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd501002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteishinseishohakko.ShinseiShoEntity;
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
        source.ninshoshaYakushokuMei = entity.getNinshoshaYakushokuMei();
        source.birthYMD = entity.getBirthYMD();
        source.hihokenJusho = entity.getHihokenJusho();
        source.hihokenshaName = entity.getHihokenshaName();
        source.hihokenshaNameKana = entity.getHihokenshaNameKana();
        source.hihokenshaNo = entity.getHihokenshaNo();
        source.hihokenshaTelNo = entity.getHihokenshaTelNo();
        source.hihokenshaYubinNo = entity.getHihokenshaYubinNo();
        source.seibetsu = entity.getSeibetsu();
        source.yokaigoKbn = entity.getYokaigoKbn();
        source.yokoKikanEDYMD = entity.getYokoKikanEDYMD();
        source.yokoKikanSTYMD = entity.getYokoKikanSTYMD();
        source.yoshienKbn = entity.getYoshienKbn();
        source.tsuchiBun = entity.getTsuchiBun();

        return source;

    }
}
