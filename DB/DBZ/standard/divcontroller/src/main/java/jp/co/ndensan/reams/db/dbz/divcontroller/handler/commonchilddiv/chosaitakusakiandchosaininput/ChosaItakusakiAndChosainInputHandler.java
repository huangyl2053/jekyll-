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
            div.getTxtChosainCode().setDisabled(true);
            div.getBtnChosainRenrakuJiko().setDisabled(true);
            div.getBtnZenkaiFukusha().setDisabled(true);
            div.getBtnClear().setDisabled(true);
        }
        if (単純入力状態.equals(モード)) {
            div.getTxtChosaItakusakiCode().setDisabled(false);
            div.getTxtChosainCode().setDisabled(false);
            div.getBtnChosainRenrakuJiko().setVisible(false);
            div.getBtnZenkaiFukusha().setVisible(false);
            div.getBtnClear().setVisible(false);
        }
        if (単純照会状態.equals(モード)) {
            div.getTxtChosaItakusakiCode().setDisabled(true);
            div.getTxtChosainCode().setDisabled(true);
            div.getBtnChosaItakusakiGuide().setVisible(false);
            div.getBtnChosainGuide().setVisible(false);
            div.getBtnChosainRenrakuJiko().setVisible(false);
            div.getBtnZenkaiFukusha().setVisible(false);
            div.getBtnClear().setVisible(false);
        }

    }

    /**
     * (認定調査委託先コード）引数から受け取った認定調査委託先情報を取得します。
     */
    public void onBlurTxtChosaItakusakiCode() {
        ChosaItakusakiAndChosainInputFinder finder = ChosaItakusakiAndChosainInputFinder.createInstance();
        NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                = finder.onBlurTxtChosaItakusakiCode(new LasdecCode(div.getHdnShichosonCode()), div.getTxtChosaItakusakiCode().getText());
        // TODO 調査委託先名称設定待ち　QA:839回答待ち　　2016/03/07
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
}
