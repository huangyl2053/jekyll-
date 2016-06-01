/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催のお知らせEditorです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
class ShinsakaiKaisaiOshiraseTsuchiEditor implements IShinsakaiKaisaiOshiraseTsuchiEditor {

    private final ShinsakaiKaisaiOshiraseTsuchiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaiKaisaiOshiraseTsuchiItem}
     */
    protected ShinsakaiKaisaiOshiraseTsuchiEditor(ShinsakaiKaisaiOshiraseTsuchiItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 介護認定審査会開催のお知らせReportSourceクラス
     * @return ShinsakaiKaisaiOshiraseTsuchiReportSource 介護認定審査会開催のお知らせReportSourceクラス
     */
    @Override
    public ShinsakaiKaisaiOshiraseTsuchiReportSource edit(ShinsakaiKaisaiOshiraseTsuchiReportSource source) {
        return editHeader(source);
    }

    private ShinsakaiKaisaiOshiraseTsuchiReportSource editHeader(ShinsakaiKaisaiOshiraseTsuchiReportSource source) {
        source.hakkoYMD1 = item.get発行日();
        source.denshiKoin = item.get電子公印();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.get公印省略();
        source.atesaki = item.get宛先();
        source.bunshoNo = item.get文書番号();
        //TODO 86954 対応待ち。2016/06/02
//        source.yubinNo = item.getYubinNo();
//        source.jushoText = item.getJushoText();
//        source.kikanNameText = item.getKikanNameText();
//        source.shimeiText = item.getShimeiText();
//        source.meishoFuyo = item.getMeishoFuyo();
//        source.customerBarCode = item.getCustomerBarCode();
//        source.atenaRenban = item.getAtenaRenban();
        source.title = new RString("介護認定審査会開催のお知らせ");
        source.tsuchibun1 = item.get通知文3();
        source.shinsakaiKaisaiYMD = item.get開催日時();
        source.kaisaiKaijo = item.get開催会場();
        source.gogitaiNo = item.get合議体番号();
        source.tsuchibun2 = item.get通知文3();
        source.listKaisaiJoho_1 = item.get開催番号();
        source.listKaisaiJoho_2 = item.get開催日();
        source.listKaisaiJoho_3 = item.get開催日時();
        source.listKaisaiJoho_4 = item.get合議体();
        source.listKaisaiJoho_5 = item.get会場();
        source.listJusho_1 = item.get住所();
        source.listTelNo_1 = item.get電話番号();
        source.tsuchibun3 = item.get通知文3();
        return source;
    }
}
