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
public class ChoteiboDankaiEditor implements IChoteiboEditor {

    private final ChoteiboDankaiItem item;

    /**
     *
     * @param item ChoteiboDankaiItem
     */
    public ChoteiboDankaiEditor(ChoteiboDankaiItem item) {
        this.item = item;
    }

    @Override
    public ChoteiboSource edit(ChoteiboSource source) {
        editListDankaiBetsu_1(source);
        editListDankaiBetsu_2(source);
        editListDankaiBetsu_3(source);
        editListDankaiBetsu_4(source);
        editListFuchoDankaiBetsu_1(source);
        editListFuchoDankaiBetsu_2(source);
        editListFuchoDankaiBetsu_3(source);
        editListFuchoDankaiBetsu_4(source);
        editListFuchoDankaiBetsu_5(source);
        editListFuchoDankaiBetsu_6(source);
        editListFuchoDankaiBetsu_7(source);
        editListFuchoDankaiBetsu_8(source);
        editListFuchoDankaiBetsu_9(source);
        editListTokuchoDankaiBetsu_1(source);
        editListTokuchoDankaiBetsu_2(source);
        editListTokuchoDankaiBetsu_3(source);
        editListTokuchoDankaiBetsu_4(source);
        editListTokuchoDankaiBetsu_5(source);
        editListTokuchoDankaiBetsu_6(source);
        editListTokuchoDankaiBetsu_7(source);
        editListTokuchoDankaiBetsu_8(source);
        editListTokuchoDankaiBetsu_9(source);
        return source;
    }

    private void editListDankaiBetsu_1(ChoteiboSource source) {
        source.listDankaiBetsu_1 = item.getListDankaiBetsu_1();
    }

    private void editListDankaiBetsu_2(ChoteiboSource source) {
        source.listDankaiBetsu_2 = item.getListDankaiBetsu_2();
    }

    private void editListDankaiBetsu_3(ChoteiboSource source) {
        source.listDankaiBetsu_3 = item.getListDankaiBetsu_3();
    }

    private void editListDankaiBetsu_4(ChoteiboSource source) {
        source.listDankaiBetsu_4 = item.getListDankaiBetsu_4();
    }

    private void editListFuchoDankaiBetsu_1(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_1 = item.getListFuchoDankaiBetsu_1();
    }

    private void editListFuchoDankaiBetsu_2(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_2 = item.getListFuchoDankaiBetsu_2();
    }

    private void editListFuchoDankaiBetsu_3(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_3 = item.getListFuchoDankaiBetsu_3();
    }

    private void editListFuchoDankaiBetsu_4(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_4 = item.getListFuchoDankaiBetsu_4();
    }

    private void editListFuchoDankaiBetsu_5(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_5 = item.getListFuchoDankaiBetsu_5();
    }

    private void editListFuchoDankaiBetsu_6(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_6 = item.getListFuchoDankaiBetsu_6();
    }

    private void editListFuchoDankaiBetsu_7(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_7 = item.getListFuchoDankaiBetsu_7();
    }

    private void editListFuchoDankaiBetsu_8(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_8 = item.getListFuchoDankaiBetsu_8();
    }

    private void editListFuchoDankaiBetsu_9(ChoteiboSource source) {
        source.listFuchoDankaiBetsu_9 = item.getListFuchoDankaiBetsu_9();
    }

    private void editListTokuchoDankaiBetsu_1(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_1 = item.getListTokuchoDankaiBetsu_1();
    }

    private void editListTokuchoDankaiBetsu_2(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_2 = item.getListTokuchoDankaiBetsu_2();
    }

    private void editListTokuchoDankaiBetsu_3(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_3 = item.getListTokuchoDankaiBetsu_3();
    }

    private void editListTokuchoDankaiBetsu_4(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_4 = item.getListTokuchoDankaiBetsu_4();
    }

    private void editListTokuchoDankaiBetsu_5(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_5 = item.getListTokuchoDankaiBetsu_5();
    }

    private void editListTokuchoDankaiBetsu_6(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_6 = item.getListTokuchoDankaiBetsu_6();
    }

    private void editListTokuchoDankaiBetsu_7(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_7 = item.getListTokuchoDankaiBetsu_7();
    }

    private void editListTokuchoDankaiBetsu_8(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_8 = item.getListTokuchoDankaiBetsu_8();
    }

    private void editListTokuchoDankaiBetsu_9(ChoteiboSource source) {
        source.listTokuchoDankaiBetsu_9 = item.getListTokuchoDankaiBetsu_9();
    }

}
