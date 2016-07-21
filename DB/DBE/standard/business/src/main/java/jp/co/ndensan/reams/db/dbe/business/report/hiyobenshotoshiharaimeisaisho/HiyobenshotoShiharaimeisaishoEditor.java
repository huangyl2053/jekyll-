/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReportSource;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書Editorです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
public class HiyobenshotoShiharaimeisaishoEditor implements IHiyobenshotoShiharaimeisaishoEditor {

    private final HiyobenshotoShiharaimeisaisho item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HiyobenshotoShiharaimeisaisho}
     */
    protected HiyobenshotoShiharaimeisaishoEditor(HiyobenshotoShiharaimeisaisho item) {
        this.item = item;
    }

    @Override
    public HiyobenshotoShiharaimeisaishoReportSource edit(HiyobenshotoShiharaimeisaishoReportSource source) {
        source.shinsainName1 = item.get審査会委員氏名1();
        source.hoshuhi1 = item.get報酬1();
        source.hiyobensho1 = item.get費用弁償1();
        source.shokeiKingaku1 = item.get小計1();
        source.gensenShotokuzei1 = item.get所得税1();
        source.sashihikishikyugaku1 = item.get差引支払額1();
        source.kinyukikanName1 = item.get金融機関1();
        source.shitenName1 = item.get支店1();
        source.kozaShubetsu1 = item.get種別1();
        source.kozaBango1 = item.get番号1();
        source.furikomiyoteiYMD1 = item.get振込予定日1();
        source.shinsaKikan1 = item.get対象期間1();
        source.shussekiKaisu1 = item.get審査会出席回数1();
        source.shichosonName1 = item.get市町村名称1();
        source.shinsainName2 = item.get審査会委員氏名2();
        source.hoshuhi2 = item.get報酬2();
        source.hiyobensho2 = item.get費用弁償2();
        source.shokeiKingaku2 = item.get小計2();
        source.gensenShotokuzei2 = item.get所得税2();
        source.sashihikishikyugaku2 = item.get差引支払額2();
        source.kinyukikanName2 = item.get金融機関2();
        source.shitenName2 = item.get支店2();
        source.kozaShubetsu2 = item.get種別2();
        source.kozaBango2 = item.get番号2();
        source.furikomiyoteiYMD2 = item.get振込予定日2();
        source.shinsaKikan2 = item.get対象期間2();
        source.shussekiKaisu2 = item.get審査会出席回数2();
        source.shichosonName2 = item.get市町村名称2();
        source.shinsainName3 = item.get審査会委員氏名3();
        source.hoshuhi3 = item.get報酬3();
        source.hiyobensho3 = item.get費用弁償3();
        source.shokeiKingaku3 = item.get小計3();
        source.gensenShotokuzei3 = item.get所得税3();
        source.sashihikishikyugaku3 = item.get差引支払額3();
        source.kinyukikanName3 = item.get金融機関3();
        source.shitenName3 = item.get支店3();
        source.kozaShubetsu3 = item.get種別3();
        source.kozaBango3 = item.get番号3();
        source.furikomiyoteiYMD3 = item.get振込予定日3();
        source.shinsaKikan3 = item.get対象期間3();
        source.shussekiKaisu3 = item.get審査会出席回数3();
        source.shichosonName3 = item.get市町村名称3();
        source.shinsainName4 = item.get審査会委員氏名4();
        source.hoshuhi4 = item.get報酬4();
        source.hiyobensho4 = item.get費用弁償4();
        source.shokeiKingaku4 = item.get小計4();
        source.gensenShotokuzei4 = item.get所得税4();
        source.sashihikishikyugaku4 = item.get差引支払額4();
        source.kinyukikanName4 = item.get金融機関4();
        source.shitenName4 = item.get支店4();
        source.kozaShubetsu4 = item.get種別4();
        source.kozaBango4 = item.get番号4();
        source.furikomiyoteiYMD4 = item.get振込予定日4();
        source.shinsaKikan4 = item.get対象期間4();
        source.shussekiKaisu4 = item.get審査会出席回数4();
        source.shichosonName4 = item.get市町村名称4();
        return source;
    }
}
