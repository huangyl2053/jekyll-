/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaJokyo;

import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo.NinteiChosaJokyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo.NinteiChosaJokyoHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaJokyo.NinteiChosaJokyoValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo.NinteiChosaJokyoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定調査状況のコントローラです。
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public class NinteiChosaJokyo {

    private final NinteiChosaJokyoFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public NinteiChosaJokyo() {
        this.finder = NinteiChosaJokyoFinder.createInstance();
    }

    /**
     * 認定調査状況初期化処理です。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onLoad(NinteiChosaJokyoDiv div) {
        getHandler(div).setLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査Div上の入力内容をクリアする。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnChosainJohoClear(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア認定調査();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問調査Div上の入力内容をクリアする。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnHomonChosaClear(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア訪問調査();
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医Div上の入力内容をクリアする。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnShujiiJohoClear(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア主治医();
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医Div上の入力内容をクリアする。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnAllClear(NinteiChosaJokyoDiv div) {
        getHandler(div).clearAll();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面の入力内容を反映させずにダイアログを閉じる
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnTorikeshi(NinteiChosaJokyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString hdnInput = getHandler(div).get画面項目();
            if (!hdnInput.equals(div.getHdnInput())) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogNGClose();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).dialogNGClose();
    }

    /**
     * 画面の入力内容を反映して、ダイアログを閉じる。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnKakutei(NinteiChosaJokyoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).set画面項目データパッシング();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 訪問調査情報を本人の住所からセットする
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnHonninJushoFukusha(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア訪問調査();
        getHandler(div).set画面項目By本人情報();
        return ResponseData.of(div).respond();
    }

    /**
     * 前回情報から訪問調査情報を複写する。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnZenKaiFukusha(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア訪問調査();
        getHandler(div).set画面項目By前回情報();
        return ResponseData.of(div).respond();
    }

    /**
     * 現在入所施設から訪問情報をセットする。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onClick_btnNyushoShisetsuFukusha(NinteiChosaJokyoDiv div) {
        getHandler(div).クリア訪問調査();
        KaigoJigyosha result = finder.get介護事業者情報(new SubGyomuCode(div.getHdnSubGyomuCd()));
        if (result != null) {
            div.getTxtChosasakiName().setValue(result.get事業者名称().value());
            div.getTxtChosasakiYubinNo().setValue(result.get郵便番号());
            div.getTxtChosasakiJusho().setDomain(result.get事業者住所());
            div.getTxtChosasakiTelNo().setDomain(result.get電話番号());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドを調査員モードでダイアログ表示する。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onBeforeOpenDialog_btnChosainGuide(NinteiChosaJokyoDiv div) {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        if (konkaiDataPass != null) {
            modle.set市町村コード(konkaiDataPass.get市町村コード().value());
        }
        modle.set委託先コード(div.getTxtNinteiChosaItakusakiCode().getValue());
        modle.set委託先名(div.getTxtNinteiChosaItakusakiName().getValue());
        modle.set調査員コード(div.getTxtNinteiChosainCode().getValue());
        modle.set調査員名(div.getTxtNinteiChosainName().getValue());
        modle.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Chosain.toString()));
        div.setHdnChosaDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドを閉じるの場合、画面を設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onOkClose_btnChosainGuide(NinteiChosaJokyoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnChosaDataPass(),
                KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtNinteiChosaItakusakiCode().setValue(modle.get委託先コード());
        div.getTxtNinteiChosaItakusakiName().setValue(modle.get委託先名());
        div.getTxtNinteiChosainCode().setValue(modle.get調査員コード());
        div.getTxtNinteiChosainName().setValue(modle.get調査員名());
        if (modle.get郵便番号() == null) {
            div.getTxtNinteiChosaYubinNo().setValue(YubinNo.EMPTY);
        } else {
            div.getTxtNinteiChosaYubinNo().setValue(new YubinNo(modle.get郵便番号()));
        }
        if (modle.get住所() == null) {
            div.getTxtNinteiChosaJusho().setDomain(AtenaJusho.EMPTY);
        } else {
            div.getTxtNinteiChosaJusho().setDomain(new AtenaJusho(modle.get住所()));
        }
        if (modle.get電話番号() == null) {
            div.getTxtNinteiChosaTelNo().setDomain(TelNo.EMPTY);
        } else {
            div.getTxtNinteiChosaTelNo().setDomain(new TelNo(modle.get電話番号()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドを調査委託先モードでダイアログ表示する。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onBeforeOpenDialog_btnItakusakiGuide(NinteiChosaJokyoDiv div) {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        if (konkaiDataPass != null) {
            modle.set市町村コード(konkaiDataPass.get市町村コード().value());
        }
        modle.set委託先コード(div.getTxtNinteiChosaItakusakiCode().getValue());
        modle.set委託先名(div.getTxtNinteiChosaItakusakiName().getValue());
        modle.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.toString()));
        div.setHdnChosaDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドを閉じるの場合、画面を設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onOKClose_btnItakusakiGuide(NinteiChosaJokyoDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnChosaDataPass(),
                KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtNinteiChosaItakusakiCode().setValue(modle.get委託先コード());
        div.getTxtNinteiChosaItakusakiName().setValue(modle.get委託先名());
        if (modle.get郵便番号() == null) {
            div.getTxtNinteiChosaYubinNo().setValue(YubinNo.EMPTY);
        } else {
            div.getTxtNinteiChosaYubinNo().setValue(new YubinNo(modle.get郵便番号()));
        }
        if (modle.get住所() == null) {
            div.getTxtNinteiChosaJusho().setDomain(AtenaJusho.EMPTY);
        } else {
            div.getTxtNinteiChosaJusho().setDomain(new AtenaJusho(modle.get住所()));
        }
        if (modle.get電話番号() == null) {
            div.getTxtNinteiChosaTelNo().setDomain(TelNo.EMPTY);
        } else {
            div.getTxtNinteiChosaTelNo().setDomain(new TelNo(modle.get電話番号()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onBeforeOpenDialog_btnShujiiGuide(NinteiChosaJokyoDiv div) {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        ShujiiIryokikanandshujiiDataPassModel modle = new ShujiiIryokikanandshujiiDataPassModel();
        if (konkaiDataPass != null) {
            modle.set市町村コード(konkaiDataPass.get市町村コード().value());
        }
        modle.setサブ業務コード(div.getHdnSubGyomuCd());
        modle.set対象モード(new RString(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.ShujiiMode.toString()));
        div.setHdnShujiiDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onBeforeOpenDialog_btnIryoKikanGuide(NinteiChosaJokyoDiv div) {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnSerializedBusiness_Konkai(),
                NinteiChosaJokyoDataPass.class);
        ShujiiIryokikanandshujiiDataPassModel modle = new ShujiiIryokikanandshujiiDataPassModel();
        if (konkaiDataPass != null) {
            modle.set市町村コード(konkaiDataPass.get市町村コード().value());
        }
        modle.setサブ業務コード(div.getHdnSubGyomuCd());
        modle.set対象モード(new RString(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode.toString()));
        div.setHdnShujiiDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドを閉じるの場合、画面を設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onOKClose_btnShujiiGuide(NinteiChosaJokyoDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnShujiiDataPass(),
                ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiCode().setValue(modle.get主治医コード());
        div.getTxtShujiiName().setValue(modle.get主治医氏名());
        div.getTxtShujiiIryoKikanCode().setValue(modle.get主治医医療機関コード());
        div.getTxtShujiiIryoKikanName().setValue(modle.get主治医医療機関名称());
        if (modle.get郵便番号() == null) {
            div.getTxtShujiiIryoKikanYubinNo().setValue(YubinNo.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanYubinNo().setValue(new YubinNo(modle.get郵便番号()));
        }
        if (modle.get住所() == null) {
            div.getTxtShujiiIryoKikanJusho().setDomain(AtenaJusho.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanJusho().setDomain(new AtenaJusho(modle.get住所()));
        }
        if (modle.get電話番号() == null) {
            div.getTxtShujiiIryoKikanTelNo().setDomain(TelNo.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanTelNo().setDomain(new TelNo(modle.get電話番号()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドを閉じるの場合、画面を設定します。
     *
     * @param div 認定調査状況Div
     * @return ResponseData<NinteiChosaJokyoDiv>
     */
    public ResponseData<NinteiChosaJokyoDiv> onOKClose_btnIryoKikanGuide(NinteiChosaJokyoDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnShujiiDataPass(),
                ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiIryoKikanCode().setValue(modle.get主治医医療機関コード());
        div.getTxtShujiiIryoKikanName().setValue(modle.get主治医医療機関名称());
        if (modle.get郵便番号() == null) {
            div.getTxtShujiiIryoKikanYubinNo().setValue(YubinNo.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanYubinNo().setValue(new YubinNo(modle.get郵便番号()));
        }
        if (modle.get住所() == null) {
            div.getTxtShujiiIryoKikanJusho().setDomain(AtenaJusho.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanJusho().setDomain(new AtenaJusho(modle.get住所()));
        }
        if (modle.get電話番号() == null) {
            div.getTxtShujiiIryoKikanTelNo().setDomain(TelNo.EMPTY);
        } else {
            div.getTxtShujiiIryoKikanTelNo().setDomain(new TelNo(modle.get電話番号()));
        }
        return ResponseData.of(div).respond();
    }

    private NinteiChosaJokyoHandler getHandler(NinteiChosaJokyoDiv div) {
        return new NinteiChosaJokyoHandler(div);
    }

    private NinteiChosaJokyoValidationHandler getValidationHandler(NinteiChosaJokyoDiv div) {
        return new NinteiChosaJokyoValidationHandler(div);
    }
}
