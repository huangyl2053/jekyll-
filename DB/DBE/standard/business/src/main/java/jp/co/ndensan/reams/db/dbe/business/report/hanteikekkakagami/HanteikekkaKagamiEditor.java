/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.business.core.shucho.Shuchos;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査判定結果（鑑）Editorです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiEditor implements IHanteikekkaKagamiEditor {

    private final HanteikekkaKagamiEntity item;
    private final Shuchos shuchos;
    private final RString 名称付与 = new RString("様");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteikekkaKagamiEntity}
     * @param shuchos 構成市町村の全首長
     */
    protected HanteikekkaKagamiEditor(HanteikekkaKagamiEntity item, Shuchos shuchos) {
        this.item = item;
        this.shuchos = shuchos;
    }

    @Override
    public HanteikekkaKagamiReportSource edit(HanteikekkaKagamiReportSource source) {
        if (item != null) {
            editCompNinshosha(source);
            source.title = DbBusinessConfig
                    .get(ConfigNameDBE.介護認定審査判定結果_鑑, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            source.shinsakaiKaisaiYMD = item.getShinsakaiKaisaiYMD().wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            source.shimeiText = this.shuchos.getNameBy証記載保険者番号(item.getShoKisaiHokenshaNo().value());
            source.meishoFuyo = 名称付与;
            source.shinsakaiKaisaiNo = item.getShinsakaiKaisaiNo();
            source.tsuchibun1 = item.getTsuchibun1();
            source.tsuchibun2 = item.getTsuchibun2();
        }
        return source;
    }

    private void editCompNinshosha(HanteikekkaKagamiReportSource source) {
        if (item.getNinshoshaSource() != null) {
            source.hakkoYMD1 = new RDate(item.getNinshoshaSource().hakkoYMD.toString()).wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
            source.denshiKoin = item.getNinshoshaSource().denshiKoin;
            source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
            source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
            source.ninshoshaYakushokuMei = item.getNinshoshaSource().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        }
    }

}
