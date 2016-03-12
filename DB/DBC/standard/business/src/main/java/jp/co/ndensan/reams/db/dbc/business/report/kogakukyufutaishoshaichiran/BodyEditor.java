/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;

/**
 * 高額介護サービス費給付対象者一覧表帳票BodyEditor
 */
public class BodyEditor implements IKogakuKyufuTaishoshaIchiranEditor {

    private final KogakuKyufuTaishoshaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuKyufuTaishoshaIchiranItem
     */
    public BodyEditor(KogakuKyufuTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource edit(KogakuKyufuTaishoshaIchiranSource source) {
        source.kokuhorenName = item.getKokuhorenName();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
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
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listUpper_9 = item.getListUpper_9();
        source.listUpper_10 = item.getListUpper_10();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        return source;
    }

}
