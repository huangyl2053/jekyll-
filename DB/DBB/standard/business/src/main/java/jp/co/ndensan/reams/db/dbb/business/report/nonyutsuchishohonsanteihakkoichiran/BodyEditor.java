/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class BodyEditor implements INonyuTsuchIchiranEditor {

    private final NonyuTsuchIchiranItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected BodyEditor(NonyuTsuchIchiranItem item) {
        this.item = item;
    }

    @Override
    public NonyuTsuchIchiranSource edit(NonyuTsuchIchiranSource source) {

        edithokenshaNo(source);
        edithokenshaName(source);
        editshutsuryokujun1(source);
        editshutsuryokujun2(source);
        editshutsuryokujun3(source);
        editshutsuryokujun4(source);
        editshutsuryokujun5(source);
        edithyojicodeName1(source);
        edithyojicodeName2(source);
        edithyojicodeName3(source);
        editshotokuDankaiTitle(source);
        editlistUpper_1(source);
        editlistUpper_2(source);
        editlistUpper_3(source);
        editlistUpper_4(source);
        editlistUpper_5(source);
        editlistUpper_6(source);
        editlistUpper_7(source);
        editlistUpper_8(source);
        editlistUpper_9(source);
        editlistUpper_10(source);
        editlistUpper_11(source);
        editlistUpper_12(source);
        editlistUpper_13(source);
        editlistUpper_14(source);
        editlistToki_1(source);
        editlistLower_1(source);
        editlistLower_2(source);
        editlistLower_3(source);
        editlistLower_4(source);
        editlistLower_5(source);
        editlistLower_6(source);
        editlistLower_7(source);
        editlistLower_8(source);
        editlistJiki_1(source);
        return source;
    }

    private void edithokenshaNo(NonyuTsuchIchiranSource source) {
        source.hokenshaNo = item.getHokenshaNo();
    }

    private void edithokenshaName(NonyuTsuchIchiranSource source) {
        source.hokenshaName = item.getHokenshaName();
    }

    private void editshutsuryokujun1(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun1 = item.getShutsuryokujun1();
    }

    private void editshutsuryokujun2(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun2 = item.getShutsuryokujun2();
    }

    private void editshutsuryokujun3(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun3 = item.getShutsuryokujun3();
    }

    private void editshutsuryokujun4(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun4 = item.getShutsuryokujun4();
    }

    private void editshutsuryokujun5(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun5 = item.getShutsuryokujun5();
    }

    private void edithyojicodeName1(NonyuTsuchIchiranSource source) {
        source.hyojicodeName1 = item.getHyojicodeName1();
    }

    private void editshotokuDankaiTitle(NonyuTsuchIchiranSource source) {
        source.shotokuDankaiTitle = item.getShotokuDankaiTitle();
    }

    private void edithyojicodeName2(NonyuTsuchIchiranSource source) {
        source.hyojicodeName2 = item.getHyojicodeName2();
    }

    private void edithyojicodeName3(NonyuTsuchIchiranSource source) {
        source.hyojicodeName3 = item.getHyojicodeName3();
    }

    private void editlistUpper_1(NonyuTsuchIchiranSource source) {
        source.listUpper_1 = item.getListUpper_1();
    }

    private void editlistUpper_2(NonyuTsuchIchiranSource source) {
        source.listUpper_2 = item.getListUpper_2();
    }

    private void editlistUpper_3(NonyuTsuchIchiranSource source) {
        source.listUpper_3 = item.getListUpper_3();
    }

    private void editlistUpper_4(NonyuTsuchIchiranSource source) {
        source.listUpper_4 = item.getListUpper_4();
    }

    private void editlistUpper_5(NonyuTsuchIchiranSource source) {
        source.listUpper_5 = item.getListUpper_5();
    }

    private void editlistUpper_6(NonyuTsuchIchiranSource source) {
        source.listUpper_6 = item.getListUpper_6();
    }

    private void editlistUpper_7(NonyuTsuchIchiranSource source) {
        source.listUpper_7 = item.getListUpper_7();
    }

    private void editlistUpper_8(NonyuTsuchIchiranSource source) {
        source.listUpper_8 = item.getListUpper_8();
    }

    private void editlistUpper_9(NonyuTsuchIchiranSource source) {
        source.listUpper_9 = item.getListUpper_9();
    }

    private void editlistUpper_10(NonyuTsuchIchiranSource source) {
        source.listUpper_10 = item.getListUpper_10();
    }

    private void editlistUpper_11(NonyuTsuchIchiranSource source) {
        source.listUpper_11 = item.getListUpper_11();
    }

    private void editlistUpper_13(NonyuTsuchIchiranSource source) {
        source.listUpper_13 = item.getListUpper_13();
    }

    private void editlistUpper_12(NonyuTsuchIchiranSource source) {
        source.listUpper_12 = item.getListUpper_12();
    }

    private void editlistUpper_14(NonyuTsuchIchiranSource source) {
        source.listUpper_14 = item.getListUpper_14();
    }

    private void editlistLower_1(NonyuTsuchIchiranSource source) {
        source.listLower_1 = item.getListLower_1();
    }

    private void editlistToki_1(NonyuTsuchIchiranSource source) {
        source.listToki_1 = item.getListToki_1();
    }

    private void editlistLower_2(NonyuTsuchIchiranSource source) {
        source.listLower_2 = item.getListLower_2();
    }

    private void editlistLower_3(NonyuTsuchIchiranSource source) {
        source.listLower_3 = item.getListLower_3();
    }

    private void editlistLower_4(NonyuTsuchIchiranSource source) {
        source.listLower_4 = item.getListLower_4();
    }

    private void editlistLower_5(NonyuTsuchIchiranSource source) {
        source.listLower_5 = item.getListLower_5();
    }

    private void editlistLower_6(NonyuTsuchIchiranSource source) {
        source.listLower_6 = item.getListLower_6();
    }

    private void editlistLower_7(NonyuTsuchIchiranSource source) {
        source.listLower_7 = item.getListLower_7();
    }

    private void editlistLower_8(NonyuTsuchIchiranSource source) {
        source.listLower_8 = item.getListLower_8();
    }

    private void editlistJiki_1(NonyuTsuchIchiranSource source) {
        source.listJiki_1 = item.getListJiki_1();
    }

}
