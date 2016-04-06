/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプレイヤ１Editor
 */
public class ReiyaB5Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item;

    /**
     * コンストラクタです
     *
     * @param item KaigoHokenryoChoshuyuyoKetteiTsuchishoItem
     */
    public ReiyaB5Editor(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource source) {

        source.bunshoNo = item.getBunshoNo();
        source.choteiNendo = item.getChoteiNendo();
        source.fukaNendo = item.getFukaNendo();
        source.ketteiKekka = item.getKetteiKekka();
        source.hyojicodeName1 = item.getHyojicodeName1();
        source.hyojicodeName2 = item.getHyojicodeName2();
        source.hyojicodeName3 = item.getHyojicodeName3();
        source.hyojicode1 = item.getHyojicode1();
        source.hyojicode2 = item.getHyojicode2();
        source.hyojicode3 = item.getHyojicode3();
        source.tsuchishoNo = item.getTsuchishoNo();
        source.setaiCode = item.getSetaiCode();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.shikibetsucode = item.getShikibetsucode();
        source.ketteiRiyu1 = item.getKetteiRiyu1();
        source.ketteiRiyu2 = item.getKetteiRiyu2();
        source.listKibetsu_1 = item.getListKibetsu_1();
        source.listKibetsu_2 = item.getListKibetsu_2();
        source.listKibetsu_3 = item.getListKibetsu_3();
        source.listKibetsu_4 = item.getListKibetsu_4();
        source.listKibetsu_5 = item.getListKibetsu_5();
        source.listKibetsu_6 = item.getListKibetsu_6();
        source.listKibetsu_7 = item.getListKibetsu_7();
        source.listZuiji_1 = item.getListZuiji_1();
        source.bikoTitle = item.getBikoTitle();
        source.biko = item.getBiko();
        return source;
    }

}
