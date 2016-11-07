/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoBodyEditor implements IShinsaHanteiJokyoEditor {

    private final ShisahanteiJokyo item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsaHanteiJokyoBodyEditor(ShisahanteiJokyo item) {
        this.item = item;
    }

    @Override
    public ShinsaHanteiJokyoReportSource edit(ShinsaHanteiJokyoReportSource source) {
        return editSource(source);
    }

    private ShinsaHanteiJokyoReportSource editSource(ShinsaHanteiJokyoReportSource source) {
        source.listHanteiHeader_1 = item.getListHanteiHeader_1();
        source.listHanteiHeader_2 = item.getListHanteiHeader_2();
        source.listHanteiHeader_3 = item.getListHanteiHeader_3();
        source.listHanteiHeader_4 = item.getListHanteiHeader_4();
        source.listHanteiHeader_5 = item.getListHanteiHeader_8();
        source.listHanteiHeader_6 = item.getListHanteiHeader_6();
        source.listHanteiHeader_7 = item.getListHanteiHeader_7();
        source.listHanteiHeader_8 = item.getListHanteiHeader_8();
        source.listHanteiHeader_9 = item.getListHanteiHeader_9();
        source.listHantei_1 = item.getListHantei_1();
        source.listHantei_2 = item.getListHantei_1();
        source.listHantei_3 = item.getListHantei_2();
        source.listHantei_4 = item.getListHantei_3();
        source.listHantei_5 = item.getListHantei_4();
        return source;
    }
}
