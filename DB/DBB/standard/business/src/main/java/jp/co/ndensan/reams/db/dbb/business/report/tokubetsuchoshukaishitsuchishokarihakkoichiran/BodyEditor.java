
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）BodyEditor
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class BodyEditor implements ITokubetsuChoshuKaishiEditor {

    private final TokubetsuChoshuKaishiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected BodyEditor(TokubetsuChoshuKaishiItem item) {
        this.item = item;
    }

    @Override
    public TokubetsuChoshuKaishiSource edit(TokubetsuChoshuKaishiSource source) {
        edithokenshaNo(source);
        edithokenshaName(source);
        editshutsuryokujun1(source);
        editshutsuryokujun2(source);
        editshutsuryokujun3(source);
        editshutsuryokujun4(source);
        editshutsuryokujun5(source);
        editkaipage1(source);
        editkaipage2(source);
        editkaipage3(source);
        editkaipage4(source);
        editkaipage5(source);
        edittitleChoshugaku(source);
        editlistUpper_1(source);
        editlistUpper_2(source);
        editlistUpper_3(source);
        editlistUpper_4(source);
        editlistUpper_5(source);
        editlistUpper_6(source);
        editlistUpper_7(source);
        editlistLower_1(source);
        editlistLower_2(source);
        editlistLower_3(source);
        editlistLower_4(source);
        editlistLower_5(source);
        editlistLower_6(source);
        editlistLower_7(source);
        editlistLower_8(source);
        editlistLower_9(source);
        editlistLower_10(source);
        editlistLower_11(source);
        return source;
    }

    private void edithokenshaNo(TokubetsuChoshuKaishiSource source) {
        source.hokenshaNo = item.getHokenshaNo();
    }

    private void edithokenshaName(TokubetsuChoshuKaishiSource source) {
        source.hokenshaName = item.getHokenshaName();
    }

    private void editshutsuryokujun1(TokubetsuChoshuKaishiSource source) {
        source.shutsuryokujun1 = item.getShutsuryokujun1();
    }

    private void editshutsuryokujun3(TokubetsuChoshuKaishiSource source) {
        source.shutsuryokujun3 = item.getShutsuryokujun3();
    }

    private void editshutsuryokujun2(TokubetsuChoshuKaishiSource source) {
        source.shutsuryokujun2 = item.getShutsuryokujun2();
    }

    private void editshutsuryokujun4(TokubetsuChoshuKaishiSource source) {
        source.shutsuryokujun4 = item.getShutsuryokujun4();
    }

    private void editkaipage1(TokubetsuChoshuKaishiSource source) {
        source.kaipage1 = item.getKaipage1();
    }

    private void editshutsuryokujun5(TokubetsuChoshuKaishiSource source) {
        source.shutsuryokujun5 = item.getShutsuryokujun5();
    }

    private void editkaipage2(TokubetsuChoshuKaishiSource source) {
        source.kaipage2 = item.getKaipage2();
    }

    private void editkaipage3(TokubetsuChoshuKaishiSource source) {
        source.kaipage3 = item.getKaipage3();
    }

    private void editkaipage4(TokubetsuChoshuKaishiSource source) {
        source.kaipage4 = item.getKaipage4();
    }

    private void editkaipage5(TokubetsuChoshuKaishiSource source) {
        source.kaipage5 = item.getKaipage5();
    }

    private void edittitleChoshugaku(TokubetsuChoshuKaishiSource source) {
        source.titleChoshugaku = item.getTitleChoshugaku();
    }

    private void editlistUpper_1(TokubetsuChoshuKaishiSource source) {
        source.listUpper_1 = item.getListUpper_1();
    }

    private void editlistUpper_2(TokubetsuChoshuKaishiSource source) {
        source.listUpper_2 = item.getListUpper_2();
    }

    private void editlistUpper_3(TokubetsuChoshuKaishiSource source) {
        source.listUpper_3 = item.getListUpper_3();
    }

    private void editlistUpper_4(TokubetsuChoshuKaishiSource source) {
        source.listUpper_4 = item.getListUpper_4();
    }

    private void editlistUpper_5(TokubetsuChoshuKaishiSource source) {
        source.listUpper_5 = item.getListUpper_5();
    }

    private void editlistUpper_6(TokubetsuChoshuKaishiSource source) {
        source.listUpper_6 = item.getListUpper_6();
    }

    private void editlistUpper_7(TokubetsuChoshuKaishiSource source) {
        source.listUpper_7 = item.getListUpper_7();
    }

    private void editlistLower_1(TokubetsuChoshuKaishiSource source) {
        source.listLower_1 = item.getListLower_1();
    }

    private void editlistLower_2(TokubetsuChoshuKaishiSource source) {
        source.listLower_2 = item.getListLower_2();
    }

    private void editlistLower_3(TokubetsuChoshuKaishiSource source) {
        source.listLower_3 = item.getListLower_3();
    }

    private void editlistLower_4(TokubetsuChoshuKaishiSource source) {
        source.listLower_4 = item.getListLower_4();
    }

    private void editlistLower_5(TokubetsuChoshuKaishiSource source) {
        source.listLower_5 = item.getListLower_5();
    }

    private void editlistLower_6(TokubetsuChoshuKaishiSource source) {
        source.listLower_6 = item.getListLower_6();
    }

    private void editlistLower_7(TokubetsuChoshuKaishiSource source) {
        source.listLower_7 = item.getListLower_7();
    }

    private void editlistLower_8(TokubetsuChoshuKaishiSource source) {
        source.listLower_8 = item.getListLower_8();
    }

    private void editlistLower_9(TokubetsuChoshuKaishiSource source) {
        source.listLower_9 = item.getListLower_9();
    }

    private void editlistLower_10(TokubetsuChoshuKaishiSource source) {
        source.listLower_10 = item.getListLower_10();
    }

    private void editlistLower_11(TokubetsuChoshuKaishiSource source) {
        source.listLower_11 = item.getListLower_11();
    }
}
