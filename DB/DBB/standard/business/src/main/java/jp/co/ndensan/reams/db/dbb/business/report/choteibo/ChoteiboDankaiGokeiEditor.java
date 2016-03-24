/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;

/**
 * 調定簿帳票段階合計編集
 */
public class ChoteiboDankaiGokeiEditor implements IChoteiboEditor {

    private final ChoteiboDankaiGokeiItem item;

    /**
     * コンストラクタです
     *
     * @param item item
     */
    public ChoteiboDankaiGokeiEditor(ChoteiboDankaiGokeiItem item) {
        this.item = item;
    }

    /**
     * 調定簿帳票構造体編集
     *
     * @param source 調定簿帳票構造体
     * @return ChoteiboSource
     */
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
        source.heichoShaSuKome = item.getHeichoShaSuKome();
    }

    private void editFuchoShaSuKome(ChoteiboSource source) {
        source.fuchoShaSuKome = item.getFuchoShaSuKome();
    }

    private void editFuchoTogetsuGakuKome(ChoteiboSource source) {
        source.fuchoTogetsuGakuKome = item.getDankaiGokeiFuchoItem().getFuchoTogetsuGakuKome();
    }

    private void editFuchoTogetsuSuKome(ChoteiboSource source) {
        source.fuchoTogetsuSuKome = item.getDankaiGokeiFuchoItem().getFuchoTogetsuSuKome();
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
        source.listFuchoGokei_1 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_1();
    }

    private void editListFuchoGokei_2(ChoteiboSource source) {
        source.listFuchoGokei_2 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_2();
    }

    private void editListFuchoGokei_3(ChoteiboSource source) {
        source.listFuchoGokei_3 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_3();
    }

    private void editListFuchoGokei_4(ChoteiboSource source) {
        source.listFuchoGokei_4 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_4();
    }

    private void editListFuchoGokei_5(ChoteiboSource source) {
        source.listFuchoGokei_5 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_5();
    }

    private void editListFuchoGokei_6(ChoteiboSource source) {
        source.listFuchoGokei_6 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_6();
    }

    private void editListFuchoGokei_7(ChoteiboSource source) {
        source.listFuchoGokei_7 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_7();
    }

    private void editListFuchoGokei_8(ChoteiboSource source) {
        source.listFuchoGokei_8 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_8();
    }

    private void editListFuchoGokei_9(ChoteiboSource source) {
        source.listFuchoGokei_9 = item.getDankaiGokeiFuchoItem().getListFuchoGokei_9();
    }

    private void editListTokuchoGokei_1(ChoteiboSource source) {
        source.listTokuchoGokei_1 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_1();
    }

    private void editListTokuchoGokei_2(ChoteiboSource source) {
        source.listTokuchoGokei_2 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_2();
    }

    private void editListTokuchoGokei_3(ChoteiboSource source) {
        source.listTokuchoGokei_3 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_3();
    }

    private void editListTokuchoGokei_4(ChoteiboSource source) {
        source.listTokuchoGokei_4 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_4();
    }

    private void editListTokuchoGokei_5(ChoteiboSource source) {
        source.listTokuchoGokei_5 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_5();
    }

    private void editListTokuchoGokei_6(ChoteiboSource source) {
        source.listTokuchoGokei_6 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_6();
    }

    private void editListTokuchoGokei_7(ChoteiboSource source) {
        source.listTokuchoGokei_7 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_7();
    }

    private void editListTokuchoGokei_8(ChoteiboSource source) {
        source.listTokuchoGokei_8 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_8();
    }

    private void editListTokuchoGokei_9(ChoteiboSource source) {
        source.listTokuchoGokei_9 = item.getDankaiGokeiTokuchoItem().getListTokuchoGokei_9();
    }

    private void editTokuchoTogetsuGakuKome(ChoteiboSource source) {
        source.tokuchoTogetsuGakuKome = item.getDankaiGokeiTokuchoItem().getTokuchoTogetsuGakuKome();
    }

    private void editTokuchoTogetsuSuKome(ChoteiboSource source) {
        source.tokuchoTogetsuSuKome = item.getDankaiGokeiTokuchoItem().getTokuchoTogetsuSuKome();
    }

    private void editTokuchoshaShaSuKome(ChoteiboSource source) {
        source.tokuchoshaShaSuKome = item.getTokuchoshaShaSuKome();
    }

}
