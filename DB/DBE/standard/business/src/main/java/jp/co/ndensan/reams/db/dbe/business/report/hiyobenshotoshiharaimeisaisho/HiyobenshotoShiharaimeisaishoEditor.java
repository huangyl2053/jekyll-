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

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private final HiyobenshotoShiharaimeisaisho item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HiyobenshotoShiharaimeisaisho}
     * @param index 番号
     */
    protected HiyobenshotoShiharaimeisaishoEditor(HiyobenshotoShiharaimeisaisho item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public HiyobenshotoShiharaimeisaishoReportSource edit(HiyobenshotoShiharaimeisaishoReportSource source) {
        if (index % INDEX_4 == 1) {
            source.shinsainName1 = item.get審査会委員氏名();
            source.hoshuhi1 = item.get報酬();
            source.hiyobensho1 = item.get費用弁償();
            source.shokeiKingaku1 = item.get小計();
            source.gensenShotokuzei1 = item.get所得税();
            source.sashihikishikyugaku1 = item.get差引支払額();
            source.kinyukikanName1 = item.get金融機関();
            source.shitenName1 = item.get支店();
            source.kozaShubetsu1 = item.get種別();
            source.kozaBango1 = item.get番号();
            source.furikomiyoteiYMD1 = item.get振込予定日();
            source.shinsaKikan1 = item.get対象期間();
            source.shussekiKaisu1 = item.get審査会出席回数();
            source.shichosonName1 = item.get市町村名称();
        } else if (index % INDEX_4 == 2) {
            source.shinsainName2 = item.get審査会委員氏名();
            source.hoshuhi2 = item.get報酬();
            source.hiyobensho2 = item.get費用弁償();
            source.shokeiKingaku2 = item.get小計();
            source.gensenShotokuzei2 = item.get所得税();
            source.sashihikishikyugaku2 = item.get差引支払額();
            source.kinyukikanName2 = item.get金融機関();
            source.shitenName2 = item.get支店();
            source.kozaShubetsu2 = item.get種別();
            source.kozaBango2 = item.get番号();
            source.furikomiyoteiYMD2 = item.get振込予定日();
            source.shinsaKikan2 = item.get対象期間();
            source.shussekiKaisu2 = item.get審査会出席回数();
            source.shichosonName2 = item.get市町村名称();
        } else if (index % INDEX_4 == INDEX_3) {
            source.shinsainName3 = item.get審査会委員氏名();
            source.hoshuhi3 = item.get報酬();
            source.hiyobensho3 = item.get費用弁償();
            source.shokeiKingaku3 = item.get小計();
            source.gensenShotokuzei3 = item.get所得税();
            source.sashihikishikyugaku3 = item.get差引支払額();
            source.kinyukikanName3 = item.get金融機関();
            source.shitenName3 = item.get支店();
            source.kozaShubetsu3 = item.get種別();
            source.kozaBango3 = item.get番号();
            source.furikomiyoteiYMD3 = item.get振込予定日();
            source.shinsaKikan3 = item.get対象期間();
            source.shussekiKaisu3 = item.get審査会出席回数();
            source.shichosonName3 = item.get市町村名称();
        } else {
            source.shinsainName4 = item.get審査会委員氏名();
            source.hoshuhi4 = item.get報酬();
            source.hiyobensho4 = item.get費用弁償();
            source.shokeiKingaku4 = item.get小計();
            source.gensenShotokuzei4 = item.get所得税();
            source.sashihikishikyugaku4 = item.get差引支払額();
            source.kinyukikanName4 = item.get金融機関();
            source.shitenName4 = item.get支店();
            source.kozaShubetsu4 = item.get種別();
            source.kozaBango4 = item.get番号();
            source.furikomiyoteiYMD4 = item.get振込予定日();
            source.shinsaKikan4 = item.get対象期間();
            source.shussekiKaisu4 = item.get審査会出席回数();
            source.shichosonName4 = item.get市町村名称();
        }
        return source;
    }
}
