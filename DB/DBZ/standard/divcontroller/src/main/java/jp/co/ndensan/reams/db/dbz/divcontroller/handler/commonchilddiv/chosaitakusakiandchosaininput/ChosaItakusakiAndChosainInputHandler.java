/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.chosaitakusakiandchosaininput.ChosaItakusakiAndChosain;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査委託先/調査員入力共有子DivののHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-030 zhangguopeng
 */
public class ChosaItakusakiAndChosainInputHandler {

    private static final RString 照会状態 = new RString("ShokaiMode");
    private static final RString 単純入力状態 = new RString("SimpleInputMode");
    private static final RString 単純照会状態 = new RString("SimpleShokaiMode");
    private final ChosaItakusakiAndChosainInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public ChosaItakusakiAndChosainInputHandler(ChosaItakusakiAndChosainInputDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化をします。
     *
     * @param モード モード
     */
    public void initialize(RString モード) {
        if (照会状態.equals(モード)) {
            div.getTxtChosaItakusakiCode().setDisabled(true);
            div.getBtnChosaItakusakiGuide().setDisabled(true);
            div.getBtnChosainRenrakuJiko().setDisabled(true);
            div.getBtnZenkaiFukusha().setDisabled(true);
            div.getTxtChosainCode().setDisabled(true);
            div.getBtnChosainGuide().setDisabled(true);
            div.getBtnClear().setDisabled(true);
        }
        if (単純入力状態.equals(モード)) {
            div.getTxtChosaItakusakiCode().setDisabled(false);
            div.getBtnChosaItakusakiGuide().setDisabled(false);
            div.getBtnChosainRenrakuJiko().setVisible(true);
            div.getBtnZenkaiFukusha().setVisible(true);
            div.getTxtChosainCode().setDisabled(false);
            div.getBtnChosainGuide().setDisabled(false);
            div.getBtnClear().setVisible(true);
        }
        if (単純照会状態.equals(モード)) {
            div.getTxtChosaItakusakiCode().setDisabled(true);
            div.getBtnChosaItakusakiGuide().setVisible(true);
            div.getBtnChosainRenrakuJiko().setVisible(true);
            div.getBtnZenkaiFukusha().setVisible(true);
            div.getTxtChosainCode().setDisabled(true);
            div.getBtnChosainGuide().setVisible(true);
            div.getBtnClear().setVisible(true);
        }
    }

    /**
     * 画面の初期化をします。
     *
     * @param モード モード
     * @param 調査委託先コード 調査委託先コード
     * @param 調査委託先名 調査委託先名
     * @param 調査員コード 調査員コード
     * @param 調査員名 調査員名
     */
    public void initialize(RString モード, RString 調査委託先コード, RString 調査委託先名, RString 調査員コード, RString 調査員名) {
        initialize(モード);
        div.getTxtChosaItakusakiCode().setValue(調査委託先コード);
        div.getTxtChosaItakusakiName().setValue(調査委託先名);
        div.getTxtChosainCode().setValue(調査員コード);
        div.getTxtChosainName().setValue(調査員名);
    }

    /**
     * (認定調査委託先コード）引数から受け取った認定調査委託先情報を取得します。
     */
    public void onBlurTxtChosaItakusakiCode() {
        ChosaItakusakiAndChosainInputFinder finder = ChosaItakusakiAndChosainInputFinder.createInstance();
        NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                = finder.onBlurTxtChosaItakusakiCode(new LasdecCode(div.getHdnShichosonCode()), div.getTxtChosaItakusakiCode().getText());
        div.getTxtChosaItakusakiName().setValue(ninteichosaItakusakiJoho == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称() == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称());
    }

    /**
     * (調査員コード）引数から受け取った調査員情報を取得します。
     */
    public void onBlurTxtChosainCode() {
        ChosaItakusakiAndChosainInputFinder finder = ChosaItakusakiAndChosainInputFinder.createInstance();
        ShinsakaiChosainJoho shinsakaiChosainJoho
                = finder.onBlurTxtChosainCode(
                        new LasdecCode(div.getHdnShichosonCode()),
                        new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getText()),
                        new ChosainCode(div.getTxtChosainCode().getText()));
        div.getTxtChosainName().setValue(shinsakaiChosainJoho == null ? RString.EMPTY
                : shinsakaiChosainJoho.get調査員氏名() == null ? RString.EMPTY
                : shinsakaiChosainJoho.get調査員氏名());
    }

    /**
     * 前回申請管理情報を取得します。
     */
    public void onClickBtnZenkaiFukusha() {
        ChosaItakusakiAndChosainInputFinder finder = ChosaItakusakiAndChosainInputFinder.createInstance();
        ChosaItakusakiAndChosain chosaItakusakiAndChosain = finder.onClickBtnZenkaiFukusha(
                new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()),
                new LasdecCode(div.getHdnShichosonCode()),
                new ChosaItakusakiCode(div.getTxtChosaItakusakiCode().getText()),
                new ChosainCode(div.getTxtChosainCode().getText()));
        div.getTxtChosaItakusakiCode().setValue(chosaItakusakiAndChosain.get認定調査委託先コード());
        div.getTxtChosaItakusakiName().setValue(chosaItakusakiAndChosain.get事業者名称());
        div.getTxtChosainCode().setValue(chosaItakusakiAndChosain.get認定調査員コード());
        div.getTxtChosainName().setValue(chosaItakusakiAndChosain.get調査員氏名());

    }

    /**
     * onClick_btnClearボタンを押下した、共有子Div内の項目に設定された値をすべてクリアします。
     */
    public void onClick_BtnClear() {
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainName().clearValue();
    }

}
