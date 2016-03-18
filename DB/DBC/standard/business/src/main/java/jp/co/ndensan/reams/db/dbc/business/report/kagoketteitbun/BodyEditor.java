/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;

/**
 *
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票BodyEditor
 */
public class BodyEditor implements IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor {

    private final KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item;

    /**
     * コンストラクタです
     *
     * @param item KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem
     */
    protected BodyEditor(KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item) {
        this.item = item;
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource t) {
        t.futanGaku1 = item.getFutanGaku1();
        t.futanGaku2 = item.getFutanGaku2();
        t.futanGaku3 = item.getFutanGaku3();
        t.futanGakuTitle = item.getFutanGakuTitle();
        t.hokenshaName = item.getHokenshaName();
        t.hokenshaNo = item.getHokenshaNo();
        t.kaipage1 = item.getKaipage1();
        t.kaipage2 = item.getKaipage2();
        t.kaipage3 = item.getKaipage3();
        t.kaipage4 = item.getKaipage4();
        t.kaipage5 = item.getKaipage5();
        t.kensu1 = item.getKensu1();
        t.kensu2 = item.getKensu2();
        t.kensu3 = item.getKensu3();
        t.kensuTitle = item.getKensuTitle();
        t.kyufuhiTitle = item.getKyufuhiTitle();
        t.listLower1_1 = item.getListLower_1();
        t.listLower1_2 = item.getListLower_2();
        t.listLower1_3 = item.getListLower_3();
        t.listLower1_4 = item.getListLower_4();
        t.listUpper_1 = item.getListUpper_1();
        t.listUpper_2 = item.getListUpper_2();
        t.listUpper_3 = item.getListUpper_3();
        t.listUpper_4 = item.getListUpper_4();
        t.listUpper_5 = item.getListUpper_5();
        t.listUpper_6 = item.getListUpper_6();
        t.listUpper_7 = item.getListUpper_7();
        t.listUpper_8 = item.getListUpper_8();
        t.listUpper_9 = item.getListUpper_9();
        t.servicehiTitle = item.getServicehiTitle();
        t.shoHokenshaName = item.getShoHokenshaName();
        t.shoHokenshaNameTitle = item.getShoHokenshaNameTitle();
        t.shoHokenshaNo = item.getShoHokenshaNo();
        t.shoHokenshaNoTitle = item.getShoHokenshaNoTitle();
        t.shokujihiTitle = item.getShokujihiTitle();
        t.shutsuryokujun1 = item.getShutsuryokujun1();
        t.shutsuryokujun2 = item.getShutsuryokujun2();
        t.shutsuryokujun3 = item.getShutsuryokujun3();
        t.shutsuryokujun4 = item.getShutsuryokujun4();
        t.shutsuryokujun5 = item.getShutsuryokujun5();
        t.tanisu1 = item.getTanisu1();
        t.tanisu2 = item.getTanisu2();
        t.tanisu3 = item.getTanisu3();
        t.tanisuTitle = item.getTanisuTitle();
        t.torikomiYM = item.getTorikomiYM();
        return t;
    }
}
