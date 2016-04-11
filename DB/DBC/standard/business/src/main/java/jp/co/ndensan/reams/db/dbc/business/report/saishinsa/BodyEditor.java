/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票BodyEditor
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class BodyEditor implements ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor {

    private final SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem item;

    /**
     * コンストラクタです
     *
     * @param item SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem
     */
    public BodyEditor(SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem item) {
        this.item = item;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource edit(
            SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {

        source.kohiFutanshaNo = item.getKohiFutanshaNo();
        source.kohiFutanshaName = item.getKohiFutanshaName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        source.listCenter_1 = item.getListCenter_1();
        source.listCenter_2 = item.getListCenter_2();
        source.listCenter_3 = item.getListCenter_3();
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        source.listLower_8 = item.getListLower_8();
        source.midashi1 = item.getMidashi1();
        source.midashi2 = item.getMidashi2();
        source.midashi3 = item.getMidashi3();
        source.midashi4 = item.getMidashi4();
        source.midashi5 = item.getMidashi5();
        source.midashi6 = item.getMidashi6();
        source.midashi7 = item.getMidashi7();
        source.midashi8 = item.getMidashi8();
        source.midashi9 = item.getMidashi9();
        source.midashi10 = item.getMidashi10();
        source.midashi11 = item.getMidashi11();
        source.midashi12 = item.getMidashi12();
        source.midashi13 = item.getMidashi13();
        source.midashi14 = item.getMidashi14();
        source.kensu1 = item.getKensu1();
        source.tanisu1 = item.getTanisu1();
        source.futangaku1 = item.getFutangaku1();
        source.kensu2 = item.getKensu2();
        source.tanisu2 = item.getTanisu2();
        source.futangaku2 = item.getFutangaku2();
        source.kensu3 = item.getKensu3();
        source.tanisu3 = item.getTanisu3();
        source.futangaku3 = item.getFutangaku3();
        source.kensu4 = item.getKensu4();
        source.tanisu4 = item.getTanisu4();
        source.futangaku4 = item.getFutangaku4();
        source.kensu5 = item.getKensu5();
        source.tanisu5 = item.getTanisu5();
        source.futangaku5 = item.getFutangaku5();
        source.kensu6 = item.getKensu6();
        source.tanisu6 = item.getTanisu6();
        source.futangaku6 = item.getFutangaku6();
        return source;
    }

}
