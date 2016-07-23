/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinhoshushiharai;

import jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai.Iinhoshushiharai;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai.IinhoshushiharaiReportSource;

/**
 * 介護認定審査会委員報酬支払通知書のEditorです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
public class IinhoshushiharaiEditor implements IIinhoshushiharaiEditor {

    private final Iinhoshushiharai item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link Iinhoshushiharai}
     */
    protected IinhoshushiharaiEditor(Iinhoshushiharai item) {
        this.item = item;
    }

    @Override
    public IinhoshushiharaiReportSource edit(IinhoshushiharaiReportSource source) {
        return editSource(source);
    }

    private IinhoshushiharaiReportSource editSource(IinhoshushiharaiReportSource source) {
        source.denshiKoin = item.get電子公印();
        source.hakkoYMD1 = item.get発行日();
        source.ninshoshaYakushokuMei = item.get認証者役職名();
        source.ninshoshaYakushokuMei1 = item.get認証者役職名1();
        source.koinMojiretsu = item.get公印文字列();
        source.ninshoshaYakushokuMei2 = item.get認証者役職名2();
        source.ninshoshaShimeiKakenai = item.get認証者氏名カナ();
        source.ninshoshaShimeiKakeru = item.get認証者氏名掛ける();
        source.koinShoryaku = item.get公印省略();
        source.yubinNo = item.get郵便番号();
        source.jushoText = item.get住所();
        source.kikanNameText = item.get審査機関();
        source.shimeiText = item.get代表者名();
        source.meishoFuyo = item.get名称付与();
        source.customerBarCode = item.getバーコード();
        source.sonota = item.getその他();
        source.title = item.getタイトル();
        source.tsuchibun1 = item.get通知文1();
        source.ishiName = item.get審査会委員氏名();
        source.furikomiyoteiYMD = item.get振込予定日();
        source.shubetsu = item.get種別();
        source.bango = item.get番号();
        source.kinyukikan = item.get金融機関();
        source.meiginin = item.get名議人();
        source.taishoKikan = item.get対象期間();
        source.shinsakaiShussekiCount = item.get審査会出席回数();
        source.tsuchibun2 = item.get通知文2();
        return source;
    }
}
