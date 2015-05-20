/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput;

/**
 * 調査委託先/調査員入力共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ChosaItakusakiAndChosainInputHandler {

    private final ChosaItakusakiAndChosainInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param chosaItakusakiAndChosainInputDiv 調査委託先/調査員入力共有子のエンティティ
     */
    public ChosaItakusakiAndChosainInputHandler(ChosaItakusakiAndChosainInputDiv chosaItakusakiAndChosainInputDiv) {
        this.div = chosaItakusakiAndChosainInputDiv;
    }

    public void onBlurTxtChosaItakusakiCode() {
    }

}
