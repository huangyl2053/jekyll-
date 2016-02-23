/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;

/**
 *
 */
public class ChoteiboDankaiGokeiEditor implements IChoteiboEditor {

    private final ChoteiboDankaiGokeiItem item;

    /**
     *
     * @param item ChoteiboDankaiGokeiItem
     */
    public ChoteiboDankaiGokeiEditor(ChoteiboDankaiGokeiItem item) {
        this.item = item;
    }

    @Override
    public ChoteiboSource edit(ChoteiboSource source) {
        editHeichoShaSuKome(source);
        editFuchoShaSuKome(source);
        editFuchoTogetsuGakuKome(source);
        editFuchoTogetsuSuKome(source);
        editListDankaiBetsuGokei_1(source);
        editListDankaiBetsuGokei_2(source);
        editListDankaiBetsuGokei_3(source);
        editListDankaiBetsuGokei_4(source);
        editListFuchoGokei_1(source);
        editListFuchoGokei_2(source);
        editListFuchoGokei_3(source);
        editListFuchoGokei_4(source);
        editListFuchoGokei_5(source);
        editListFuchoGokei_6(source);
        editListFuchoGokei_7(source);
        editListFuchoGokei_8(source);
        editListFuchoGokei_9(source);
        editListTokuchoGokei_1(source);
        editListTokuchoGokei_2(source);
        editListTokuchoGokei_3(source);
        editListTokuchoGokei_4(source);
        editListTokuchoGokei_5(source);
        editListTokuchoGokei_6(source);
        editListTokuchoGokei_7(source);
        editListTokuchoGokei_8(source);
        editListTokuchoGokei_9(source);
        editTokuchoTogetsuGakuKome(source);
        editTokuchoTogetsuSuKome(source);
        editTokuchoshaShaSuKome(source);
        return source;
    }

    private void editHeichoShaSuKome(ChoteiboSource source) {
        source.HeichoShaSuKome = item.getHeichoShaSuKome();
    }

    private void editFuchoShaSuKome(ChoteiboSource source) {
        source.fuchoShaSuKome = item.getFuchoShaSuKome();
    }

    private void editFuchoTogetsuGakuKome(ChoteiboSource source) {
        source.fuchoTogetsuGakuKome = item.getFuchoTogetsuGakuKome();
    }

    private void editFuchoTogetsuSuKome(ChoteiboSource source) {
        source.fuchoTogetsuSuKome = item.getFuchoTogetsuSuKome();
    }

    private void editListDankaiBetsuGokei_1(ChoteiboSource source) {
        source.listDankaiBetsuGokei_1 = item.getListDankaiBetsuGokei_1();
    }

    private void editListDankaiBetsuGokei_2(ChoteiboSource source) {
        source.listDankaiBetsuGokei_2 = item.getListDankaiBetsuGokei_2();
    }

    private void editListDankaiBetsuGokei_3(ChoteiboSource source) {
        source.listDankaiBetsuGokei_3 = item.getListDankaiBetsuGokei_3();
    }

    private void editListDankaiBetsuGokei_4(ChoteiboSource source) {
        source.listDankaiBetsuGokei_4 = item.getListDankaiBetsuGokei_4();
    }

    private void editListFuchoGokei_1(ChoteiboSource source) {
        source.listFuchoGokei_1 = item.getListFuchoGokei_1();
    }

    private void editListFuchoGokei_2(ChoteiboSource source) {
        source.listFuchoGokei_2 = item.getListFuchoGokei_2();
    }

    private void editListFuchoGokei_3(ChoteiboSource source) {
        source.listFuchoGokei_3 = item.getListFuchoGokei_3();
    }

    private void editListFuchoGokei_4(ChoteiboSource source) {
        source.listFuchoGokei_4 = item.getListFuchoGokei_4();
    }

    private void editListFuchoGokei_5(ChoteiboSource source) {
        source.listFuchoGokei_5 = item.getListFuchoGokei_5();
    }

    private void editListFuchoGokei_6(ChoteiboSource source) {
        source.listFuchoGokei_6 = item.getListFuchoGokei_6();
    }

    private void editListFuchoGokei_7(ChoteiboSource source) {
        source.listFuchoGokei_7 = item.getListFuchoGokei_7();
    }

    private void editListFuchoGokei_8(ChoteiboSource source) {
        source.listFuchoGokei_8 = item.getListFuchoGokei_8();
    }

    private void editListFuchoGokei_9(ChoteiboSource source) {
        source.listFuchoGokei_9 = item.getListFuchoGokei_9();
    }

    private void editListTokuchoGokei_1(ChoteiboSource source) {
        source.listTokuchoGokei_1 = item.getListTokuchoGokei_1();
    }

    private void editListTokuchoGokei_2(ChoteiboSource source) {
        source.listTokuchoGokei_2 = item.getListTokuchoGokei_2();
    }

    private void editListTokuchoGokei_3(ChoteiboSource source) {
        source.listTokuchoGokei_3 = item.getListTokuchoGokei_3();
    }

    private void editListTokuchoGokei_4(ChoteiboSource source) {
        source.listTokuchoGokei_4 = item.getListTokuchoGokei_4();
    }

    private void editListTokuchoGokei_5(ChoteiboSource source) {
        source.listTokuchoGokei_5 = item.getListTokuchoGokei_5();
    }

    private void editListTokuchoGokei_6(ChoteiboSource source) {
        source.listTokuchoGokei_6 = item.getListTokuchoGokei_6();
    }

    private void editListTokuchoGokei_7(ChoteiboSource source) {
        source.listTokuchoGokei_7 = item.getListTokuchoGokei_7();
    }

    private void editListTokuchoGokei_8(ChoteiboSource source) {
        source.listTokuchoGokei_8 = item.getListTokuchoGokei_8();
    }

    private void editListTokuchoGokei_9(ChoteiboSource source) {
        source.listTokuchoGokei_9 = item.getListTokuchoGokei_9();
    }

    private void editTokuchoTogetsuGakuKome(ChoteiboSource source) {
        source.tokuchoTogetsuGakuKome = item.getTokuchoTogetsuGakuKome();
    }

    private void editTokuchoTogetsuSuKome(ChoteiboSource source) {
        source.tokuchoTogetsuSuKome = item.getTokuchoTogetsuSuKome();
    }

    private void editTokuchoshaShaSuKome(ChoteiboSource source) {
        source.tokuchoshaShaSuKome = item.getTokuchoshaShaSuKome();
    }

}
