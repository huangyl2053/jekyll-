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
        source.bunshoNo = item.get文書番号();
        source.hakkoYMD1 = item.get発行日();
        source.denshiKoin = item.get電子公印();
        source.yubinNo = item.get宛名郵便番号();
        source.jushoText = item.get宛名住所();
        source.kikanNameText = item.get宛名機関名();
        source.shimeiText = item.get宛名氏名();
        source.meishoFuyo = item.get宛名名称付与();
//        source.atesaki = item.get宛先();
        source.title = new RString("介護認定審査会開催のお知らせ");
        source.denshiKoin = item.get電子公印();
        source.koinMojiretsu = item.get電子公印文字列();
        source.koinShoryaku = item.get電子公印省略();
        source.customerBarCode = item.getカスタマーバーコード();
        source.pageCount = item.getページ番号();
        source.ninshoshaShimeiKakenai = item.get認証者氏名公印掛けない();
        source.ninshoshaShimeiKakeru = item.get認証者氏名公印掛ける();
        source.ninshoshaYakushokuMei = item.get認証者役職名();
        source.ninshoshaYakushokuMei1 = item.get認証者役職名1行目();
        source.ninshoshaYakushokuMei2 = item.get認証者役職名2行目();
        source.tsuchibun1 = item.get通知文1();
        source.tsuchibun2 = item.get通知文2();
        source.shinsakaiKaisaiYMD = item.get開催日時();
        source.kaisaiKaijo = item.get開催会場();
        source.gogitaiNo = item.get合議体番号();
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
