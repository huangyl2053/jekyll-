/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class BodyEditor implements IKaigoHokenryogakuEditor {

    private final KaigoHokenryogakuItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SampleItem}
     */
    protected BodyEditor(KaigoHokenryogakuItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryogakuSource edit(KaigoHokenryogakuSource source) {

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
        editlistLower_1(source);
        editlistLower_2(source);
        editlistLower_3(source);
        editlistLower_4(source);
        editlistLower_5(source);
        editlistLower_6(source);
        editlistLower_7(source);
        return source;
    }

    private void edithokenshaNo(KaigoHokenryogakuSource source) {
        source.hokenshaNo = item.getHokenshaNo();
    }

    private void edithokenshaName(KaigoHokenryogakuSource source) {
        source.hokenshaName = item.getHokenshaName();
    }

    private void editshutsuryokujun1(KaigoHokenryogakuSource source) {
        source.shutsuryokujun1 = item.getShutsuryokujun1();
    }

    private void editshutsuryokujun2(KaigoHokenryogakuSource source) {
        source.shutsuryokujun2 = item.getShutsuryokujun2();
    }

    private void editshutsuryokujun3(KaigoHokenryogakuSource source) {
        source.shutsuryokujun3 = item.getShutsuryokujun3();
    }

    private void editshutsuryokujun4(KaigoHokenryogakuSource source) {
        source.shutsuryokujun4 = item.getShutsuryokujun4();
    }

    private void editshutsuryokujun5(KaigoHokenryogakuSource source) {
        source.shutsuryokujun5 = item.getShutsuryokujun5();
    }

    private void edithyojicodeName1(KaigoHokenryogakuSource source) {
        source.hyojicodeName1 = item.getHyojicodeName1();
    }

    private void edithyojicodeName2(KaigoHokenryogakuSource source) {
        source.hyojicodeName2 = item.getHyojicodeName2();
    }

    private void edithyojicodeName3(KaigoHokenryogakuSource source) {
        source.hyojicodeName3 = item.getHyojicodeName3();
    }

    private void editlistUpper_1(KaigoHokenryogakuSource source) {
        source.listUpper_1 = item.getListUpper_1();
    }

    private void editlistUpper_2(KaigoHokenryogakuSource source) {
        source.listUpper_2 = item.getListUpper_2();
    }

    private void editlistUpper_3(KaigoHokenryogakuSource source) {
        source.listUpper_3 = item.getListUpper_3();
    }

    private void editlistUpper_4(KaigoHokenryogakuSource source) {
        source.listUpper_4 = item.getListUpper_4();
    }

    private void editlistUpper_5(KaigoHokenryogakuSource source) {
        source.listUpper_5 = item.getListUpper_5();
    }

    private void editlistUpper_6(KaigoHokenryogakuSource source) {
        source.listUpper_6 = item.getListUpper_6();
    }

    private void editlistUpper_7(KaigoHokenryogakuSource source) {
        source.listUpper_7 = item.getListUpper_7();
    }

    private void editlistUpper_8(KaigoHokenryogakuSource source) {
        source.listUpper_8 = item.getListUpper_8();
    }

    private void editlistUpper_9(KaigoHokenryogakuSource source) {
        source.listUpper_9 = item.getListUpper_9();
    }

    private void editlistUpper_10(KaigoHokenryogakuSource source) {
        source.listUpper_10 = item.getListUpper_10();
    }

    private void editlistUpper_11(KaigoHokenryogakuSource source) {
        source.listUpper_11 = item.getListUpper_11();
    }

    private void editlistUpper_12(KaigoHokenryogakuSource source) {
        source.listUpper_12 = item.getListUpper_12();
    }

    private void editlistLower_2(KaigoHokenryogakuSource source) {
        source.listLower_2 = item.getListLower_2();
    }

    private void editlistLower_3(KaigoHokenryogakuSource source) {
        source.listLower_3 = item.getListLower_3();
    }

    private void editlistLower_4(KaigoHokenryogakuSource source) {
        source.listLower_4 = item.getListLower_4();
    }

    private void editlistLower_5(KaigoHokenryogakuSource source) {
        source.listLower_5 = item.getListLower_5();
    }

    private void editlistLower_6(KaigoHokenryogakuSource source) {
        source.listLower_6 = item.getListLower_6();
    }

    private void editlistLower_7(KaigoHokenryogakuSource source) {
        source.listLower_7 = item.getListLower_7();
    }

    private void editlistLower_1(KaigoHokenryogakuSource source) {
        source.listLower_1 = item.getListLower_1();
    }

}
