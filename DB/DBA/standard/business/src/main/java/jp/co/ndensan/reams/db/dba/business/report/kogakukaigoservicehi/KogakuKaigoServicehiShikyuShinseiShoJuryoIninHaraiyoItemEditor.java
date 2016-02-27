/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakukaigoservicehi;

import jp.co.ndensan.reams.db.dba.entity.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource;

/**
 *
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のEditorです。
 */
public class KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemEditor
        implements IKogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoEditor {

    private final KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item
     * {@link KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem}
     */
    protected KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItemEditor(KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item) {
        this.item = item;
    }

    @Override
    public KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource edit(
            KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource source) {
        return editSource(source);
    }

    private KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource editSource(
            KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource source) {
        source.serviceYM = item.getServiceYM();
        source.hassobiYMD = item.getHassobiYMD();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.telNo = item.getTelNo();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.remban = item.getRemban();
        return source;
    }
}
