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
public class ChoteiboKitsukiEditor implements IChoteiboEditor {

    private final ChoteiboKitsukiItem item;

    public ChoteiboKitsukiEditor(ChoteiboKitsukiItem item) {
        this.item = item;
    }

    @Override
    public ChoteiboSource edit(ChoteiboSource source) {
        editNendoTitle(source);
        editFuchichoNofuGokei(source);
        editFuchoSaishutsuKanpuGaku(source);
        editFuchoSaishutsuKanpuSu(source);
        editListFuchoKi_1(source);
        editListFuchoKi_2(source);
        editListFuchoKi_3(source);
        editListFuchoKi_4(source);
        editListFuchoKi_5(source);
        editListFuchoKi_6(source);
        editListFuchoKi_7(source);
        editListFuchoKi_8(source);
        editListFuchoKi_9(source);
        editListFuchoKi_10(source);
        editListFuchoKi_11(source);
        editListFuchoKi_12(source);
        editListFuchoKi_13(source);
        editListFuchoKi_14(source);
        editListFuchoNofugaku_1(source);
        editListFuchoNofugaku_2(source);
        editListFuchoNofugaku_3(source);
        editListFuchoNofugaku_4(source);
        editListFuchoNofugaku_5(source);
        editListFuchoNofugaku_6(source);
        editListFuchoNofugaku_7(source);
        editListFuchoNofugaku_8(source);
        editListFuchoNofugaku_9(source);
        editListFuchoNofugaku_10(source);
        editListFuchoNofugaku_11(source);
        editListFuchoNofugaku_12(source);
        editListFuchoNofugaku_13(source);
        editListFuchoNofugaku_14(source);
        editListFuchoTsuki_1(source);
        editListFuchoTsuki_2(source);
        editListFuchoTsuki_3(source);
        editListFuchoTsuki_4(source);
        editListFuchoTsuki_5(source);
        editListFuchoTsuki_6(source);
        editListFuchoTsuki_7(source);
        editListFuchoTsuki_8(source);
        editListFuchoTsuki_9(source);
        editListFuchoTsuki_10(source);
        editListFuchoTsuki_11(source);
        editListFuchoTsuki_12(source);
        editListFuchoTsuki_13(source);
        editListFuchoTsuki_14(source);
        editListTokuchoKi_1(source);
        editListTokuchoKi_2(source);
        editListTokuchoKi_3(source);
        editListTokuchoKi_4(source);
        editListTokuchoKi_5(source);
        editListTokuchoKi_6(source);
        editListTokuchoNofugaku_1(source);
        editListTokuchoNofugaku_2(source);
        editListTokuchoNofugaku_3(source);
        editListTokuchoNofugaku_4(source);
        editListTokuchoNofugaku_5(source);
        editListTokuchoNofugaku_6(source);
        editListTokuchoTsuki_1(source);
        editListTokuchoTsuki_2(source);
        editListTokuchoTsuki_3(source);
        editListTokuchoTsuki_4(source);
        editListTokuchoTsuki_5(source);
        editListTokuchoTsuki_6(source);
        editListZuiji_1(source);
        editListZuiji_2(source);
        editListZuiji_3(source);
        editListZuiji_4(source);
        editListZuiji_5(source);
        editListZuiji_6(source);
        editListZuiji_7(source);
        editListZuiji_8(source);
        editListZuiji_9(source);
        editListZuiji_10(source);
        editListZuiji_11(source);
        editListZuiji_12(source);
        editListZuiji_13(source);
        editListZuiji_14(source);
        editTokuchoNofuGokei(source);
        editTokuchoSaishutsuKanfuGaku(source);
        editTokuchoSaishutsuKanpuSu(source);
        return source;
    }

    private void editNendoTitle(ChoteiboSource source) {
        source.nendoTitle = item.getNendoTitle();
    }

    private void editFuchichoNofuGokei(ChoteiboSource source) {
        source.fuchichoNofuGokei = item.getFuchichoNofuGokei();
    }

    private void editFuchoSaishutsuKanpuGaku(ChoteiboSource source) {
        source.fuchoSaishutsuKanpuGaku = item.getFuchoSaishutsuKanpuGaku();
    }

    private void editFuchoSaishutsuKanpuSu(ChoteiboSource source) {
        source.fuchoSaishutsuKanpuSu = item.getFuchoSaishutsuKanpuSu();
    }

    private void editListFuchoKi_1(ChoteiboSource source) {
        source.listFuchoKi_1 = item.getListFuchoKi_1();
    }

    private void editListFuchoKi_2(ChoteiboSource source) {
        source.listFuchoKi_2 = item.getListFuchoKi_2();
    }

    private void editListFuchoKi_3(ChoteiboSource source) {
        source.listFuchoKi_3 = item.getListFuchoKi_3();
    }

    private void editListFuchoKi_4(ChoteiboSource source) {
        source.listFuchoKi_4 = item.getListFuchoKi_4();
    }

    private void editListFuchoKi_5(ChoteiboSource source) {
        source.listFuchoKi_5 = item.getListFuchoKi_5();
    }

    private void editListFuchoKi_6(ChoteiboSource source) {
        source.listFuchoKi_6 = item.getListFuchoKi_6();
    }

    private void editListFuchoKi_7(ChoteiboSource source) {
        source.listFuchoKi_7 = item.getListFuchoKi_7();
    }

    private void editListFuchoKi_8(ChoteiboSource source) {
        source.listFuchoKi_8 = item.getListFuchoKi_8();
    }

    private void editListFuchoKi_9(ChoteiboSource source) {
        source.listFuchoKi_9 = item.getListFuchoKi_9();
    }

    private void editListFuchoKi_10(ChoteiboSource source) {
        source.listFuchoKi_10 = item.getListFuchoKi_10();
    }

    private void editListFuchoKi_11(ChoteiboSource source) {
        source.listFuchoKi_11 = item.getListFuchoKi_11();
    }

    private void editListFuchoKi_12(ChoteiboSource source) {
        source.listFuchoKi_12 = item.getListFuchoKi_12();
    }

    private void editListFuchoKi_13(ChoteiboSource source) {
        source.listFuchoKi_13 = item.getListFuchoKi_13();
    }

    private void editListFuchoKi_14(ChoteiboSource source) {
        source.listFuchoKi_14 = item.getListFuchoKi_14();
    }

    private void editListFuchoNofugaku_1(ChoteiboSource source) {
        source.listFuchoNofugaku_1 = item.getListFuchoNofugaku_1();
    }

    private void editListFuchoNofugaku_2(ChoteiboSource source) {
        source.listFuchoNofugaku_2 = item.getListFuchoNofugaku_2();
    }

    private void editListFuchoNofugaku_3(ChoteiboSource source) {
        source.listFuchoNofugaku_3 = item.getListFuchoNofugaku_3();
    }

    private void editListFuchoNofugaku_4(ChoteiboSource source) {
        source.listFuchoNofugaku_4 = item.getListFuchoNofugaku_4();
    }

    private void editListFuchoNofugaku_5(ChoteiboSource source) {
        source.listFuchoNofugaku_5 = item.getListFuchoNofugaku_5();
    }

    private void editListFuchoNofugaku_6(ChoteiboSource source) {
        source.listFuchoNofugaku_6 = item.getListFuchoNofugaku_6();
    }

    private void editListFuchoNofugaku_7(ChoteiboSource source) {
        source.listFuchoNofugaku_7 = item.getListFuchoNofugaku_7();
    }

    private void editListFuchoNofugaku_8(ChoteiboSource source) {
        source.listFuchoNofugaku_8 = item.getListFuchoNofugaku_8();
    }

    private void editListFuchoNofugaku_9(ChoteiboSource source) {
        source.listFuchoNofugaku_9 = item.getListFuchoNofugaku_9();
    }

    private void editListFuchoNofugaku_10(ChoteiboSource source) {
        source.listFuchoNofugaku_10 = item.getListFuchoNofugaku_10();
    }

    private void editListFuchoNofugaku_11(ChoteiboSource source) {
        source.listFuchoNofugaku_11 = item.getListFuchoNofugaku_11();
    }

    private void editListFuchoNofugaku_12(ChoteiboSource source) {
        source.listFuchoNofugaku_12 = item.getListFuchoNofugaku_12();
    }

    private void editListFuchoNofugaku_13(ChoteiboSource source) {
        source.listFuchoNofugaku_13 = item.getListFuchoNofugaku_13();
    }

    private void editListFuchoNofugaku_14(ChoteiboSource source) {
        source.listFuchoNofugaku_14 = item.getListFuchoNofugaku_14();
    }

    private void editListFuchoTsuki_1(ChoteiboSource source) {
        source.listFuchoTsuki_1 = item.getListFuchoTsuki_1();
    }

    private void editListFuchoTsuki_2(ChoteiboSource source) {
        source.listFuchoTsuki_2 = item.getListFuchoTsuki_2();
    }

    private void editListFuchoTsuki_3(ChoteiboSource source) {
        source.listFuchoTsuki_3 = item.getListFuchoTsuki_3();
    }

    private void editListFuchoTsuki_4(ChoteiboSource source) {
        source.listFuchoTsuki_4 = item.getListFuchoTsuki_4();
    }

    private void editListFuchoTsuki_5(ChoteiboSource source) {
        source.listFuchoTsuki_5 = item.getListFuchoTsuki_5();
    }

    private void editListFuchoTsuki_6(ChoteiboSource source) {
        source.listFuchoTsuki_6 = item.getListFuchoTsuki_6();
    }

    private void editListFuchoTsuki_7(ChoteiboSource source) {
        source.listFuchoTsuki_7 = item.getListFuchoTsuki_7();
    }

    private void editListFuchoTsuki_8(ChoteiboSource source) {
        source.listFuchoTsuki_8 = item.getListFuchoTsuki_8();
    }

    private void editListFuchoTsuki_9(ChoteiboSource source) {
        source.listFuchoTsuki_9 = item.getListFuchoTsuki_9();
    }

    private void editListFuchoTsuki_10(ChoteiboSource source) {
        source.listFuchoTsuki_10 = item.getListFuchoTsuki_10();
    }

    private void editListFuchoTsuki_11(ChoteiboSource source) {
        source.listFuchoTsuki_11 = item.getListFuchoTsuki_11();
    }

    private void editListFuchoTsuki_12(ChoteiboSource source) {
        source.listFuchoTsuki_12 = item.getListFuchoTsuki_12();
    }

    private void editListFuchoTsuki_13(ChoteiboSource source) {
        source.listFuchoTsuki_13 = item.getListFuchoTsuki_13();
    }

    private void editListFuchoTsuki_14(ChoteiboSource source) {
        source.listFuchoTsuki_14 = item.getListFuchoTsuki_14();
    }

    private void editListTokuchoKi_1(ChoteiboSource source) {
        source.listTokuchoKi_1 = item.getListTokuchoKi_1();
    }

    private void editListTokuchoKi_2(ChoteiboSource source) {
        source.listTokuchoKi_2 = item.getListTokuchoKi_2();
    }

    private void editListTokuchoKi_3(ChoteiboSource source) {
        source.listTokuchoKi_3 = item.getListTokuchoKi_3();
    }

    private void editListTokuchoKi_4(ChoteiboSource source) {
        source.listTokuchoKi_4 = item.getListTokuchoKi_4();
    }

    private void editListTokuchoKi_5(ChoteiboSource source) {
        source.listTokuchoKi_5 = item.getListTokuchoKi_5();
    }

    private void editListTokuchoKi_6(ChoteiboSource source) {
        source.listTokuchoKi_6 = item.getListTokuchoKi_6();
    }

    private void editListTokuchoNofugaku_1(ChoteiboSource source) {
        source.listTokuchoNofugaku_1 = item.getListTokuchoNofugaku_1();
    }

    private void editListTokuchoNofugaku_2(ChoteiboSource source) {
        source.listTokuchoNofugaku_2 = item.getListTokuchoNofugaku_2();
    }

    private void editListTokuchoNofugaku_3(ChoteiboSource source) {
        source.listTokuchoNofugaku_3 = item.getListTokuchoNofugaku_3();
    }

    private void editListTokuchoNofugaku_4(ChoteiboSource source) {
        source.listTokuchoNofugaku_4 = item.getListTokuchoNofugaku_4();
    }

    private void editListTokuchoNofugaku_5(ChoteiboSource source) {
        source.listTokuchoNofugaku_5 = item.getListTokuchoNofugaku_5();
    }

    private void editListTokuchoNofugaku_6(ChoteiboSource source) {
        source.listTokuchoNofugaku_6 = item.getListTokuchoNofugaku_6();
    }

    private void editListTokuchoTsuki_1(ChoteiboSource source) {
        source.listTokuchoTsuki_1 = item.getListTokuchoTsuki_1();
    }

    private void editListTokuchoTsuki_2(ChoteiboSource source) {
        source.listTokuchoTsuki_2 = item.getListTokuchoTsuki_2();
    }

    private void editListTokuchoTsuki_3(ChoteiboSource source) {
        source.listTokuchoTsuki_3 = item.getListTokuchoTsuki_3();
    }

    private void editListTokuchoTsuki_4(ChoteiboSource source) {
        source.listTokuchoTsuki_4 = item.getListTokuchoTsuki_4();
    }

    private void editListTokuchoTsuki_5(ChoteiboSource source) {
        source.listTokuchoTsuki_5 = item.getListTokuchoTsuki_5();
    }

    private void editListTokuchoTsuki_6(ChoteiboSource source) {
        source.listTokuchoTsuki_6 = item.getListTokuchoTsuki_6();
    }

    private void editListZuiji_1(ChoteiboSource source) {
        source.listZuiji_1 = item.getListZuiji_1();
    }

    private void editListZuiji_2(ChoteiboSource source) {
        source.listZuiji_2 = item.getListZuiji_2();
    }

    private void editListZuiji_3(ChoteiboSource source) {
        source.listZuiji_3 = item.getListZuiji_3();
    }

    private void editListZuiji_4(ChoteiboSource source) {
        source.listZuiji_4 = item.getListZuiji_4();
    }

    private void editListZuiji_5(ChoteiboSource source) {
        source.listZuiji_5 = item.getListZuiji_5();
    }

    private void editListZuiji_6(ChoteiboSource source) {
        source.listZuiji_6 = item.getListZuiji_6();
    }

    private void editListZuiji_7(ChoteiboSource source) {
        source.listZuiji_7 = item.getListZuiji_7();
    }

    private void editListZuiji_8(ChoteiboSource source) {
        source.listZuiji_8 = item.getListZuiji_8();
    }

    private void editListZuiji_9(ChoteiboSource source) {
        source.listZuiji_9 = item.getListZuiji_9();
    }

    private void editListZuiji_10(ChoteiboSource source) {
        source.listZuiji_10 = item.getListZuiji_10();
    }

    private void editListZuiji_11(ChoteiboSource source) {
        source.listZuiji_11 = item.getListZuiji_11();
    }

    private void editListZuiji_12(ChoteiboSource source) {
        source.listZuiji_12 = item.getListZuiji_12();
    }

    private void editListZuiji_13(ChoteiboSource source) {
        source.listZuiji_13 = item.getListZuiji_13();
    }

    private void editListZuiji_14(ChoteiboSource source) {
        source.listZuiji_14 = item.getListZuiji_14();
    }

    private void editTokuchoNofuGokei(ChoteiboSource source) {
        source.tokuchoNofuGokei = item.getTokuchoNofuGokei();
    }

    private void editTokuchoSaishutsuKanfuGaku(ChoteiboSource source) {
        source.tokuchoSaishutsuKanfuGaku = item.getTokuchoSaishutsuKanfuGaku();
    }

    private void editTokuchoSaishutsuKanpuSu(ChoteiboSource source) {
        source.tokuchoSaishutsuKanpuSu = item.getTokuchoSaishutsuKanpuSu();
    }
}
