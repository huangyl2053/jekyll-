/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseishaFinder;

import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div 条件検索画面「NinteiShinseishaFinder」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiShinseishaFinder {

    private static final int SIZE = 10;

    /**
     * 条件検索画面の初期化処理ください。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> initialize(NinteiShinseishaFinderDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_ShosaiJoken(NinteiShinseishaFinderDiv div) {
        getHandler(div).openShosaiJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の認定調査パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_NinteiChosa(NinteiShinseishaFinderDiv div) {
        getHandler(div).openNinteiChosa();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の主治医情報パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_ShujiiJoho(NinteiShinseishaFinderDiv div) {
        getHandler(div).openShujiiJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の一次判定パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_IchijiHantei(NinteiShinseishaFinderDiv div) {
        getHandler(div).openIchijiHantei();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の1.5次判定パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_IchiGoHantei(NinteiShinseishaFinderDiv div) {
        getHandler(div).openIchiGoHantei();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の介護認定審査会パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_KaigoNinteiShinsakaiJoho(NinteiShinseishaFinderDiv div) {
        getHandler(div).openKaigoNinteiShinsakaiJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の前回情報パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_ZenkaiJoho(NinteiShinseishaFinderDiv div) {
        getHandler(div).openZenkaiJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件のその他情報パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_SonotaJoho(NinteiShinseishaFinderDiv div) {
        getHandler(div).openSonotaJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細条件の完了情報パネルの初期化処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_KanryoJoho(NinteiShinseishaFinderDiv div) {
        getHandler(div).openKanryoJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された番号を桁数10になるよう左側に0(ゼロ)を埋める。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtHihokenshaNumber(NinteiShinseishaFinderDiv div) {
        RString txtHihokenshaNumber = div.getTxtHihokenshaNumber().getValue();
        if (!RString.isNullOrEmpty(txtHihokenshaNumber)) {
            div.getTxtHihokenshaNumber().setValue(txtHihokenshaNumber.padZeroToLeft(SIZE));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された番号を桁数10になるよう左側に0(ゼロ)を埋める。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtShinseishaName(NinteiShinseishaFinderDiv div) {
        RString txtShinseishaName = div.getTxtHihokenshaName().getValue();
        if (!RString.isNullOrEmpty(txtShinseishaName)) {
            txtShinseishaName = RStringUtil.convertひらがなtoカタカナ(txtShinseishaName);
            if (RStringUtil.isカタカナOnly(txtShinseishaName)) {
                div.getTxtHihokenshaName().setValue(txtShinseishaName);
            } else {
                throw new ApplicationException(UrErrorMessages.使用不可文字.getMessage());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 現在のフェーズDDLのonChange場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_ddlNowPhase(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        getHandler(div).clearChk();
        if (RString.isNullOrEmpty(nowPhase)) {
            div.getChkShoriJotai().setDisabled(true);
            div.getChkKoshinTaishoChushutsu().setDisabled(true);
            div.getChkIchijiHantei().setDisabled(false);
            div.getChkShinseiUketsuke().setDisabled(false);
            div.getChkMasking().setDisabled(false);
            div.getChkChosaIrai().setDisabled(false);
            div.getChkShinsakaiToroku().setDisabled(false);
            div.getChkIkenshoIrai().setDisabled(false);
            div.getChkNijiHantei().setDisabled(false);
            div.getChkChosaNyushu().setDisabled(false);
            div.getChkTsuchiShori().setDisabled(true);
            div.getChkIkenshoNyushu().setDisabled(false);
            div.getChkGetsureiShori().setDisabled(false);
        } else {
            div.getChkShoriJotai().setDisabled(false);

            div.getChkIchijiHantei().setDisabled(true);
            div.getChkShinseiUketsuke().setDisabled(true);
            div.getChkMasking().setDisabled(true);
            div.getChkChosaIrai().setDisabled(true);
            div.getChkShinsakaiToroku().setDisabled(true);
            div.getChkIkenshoIrai().setDisabled(true);
            div.getChkNijiHantei().setDisabled(true);
            div.getChkChosaNyushu().setDisabled(true);
            div.getChkIkenshoNyushu().setDisabled(true);
            div.getChkGetsureiShori().setDisabled(true);

            div.getChkKoshinTaishoChushutsu().setDisabled(false);
            if (KanryoInfoPhase.一次判定.getコード().equals(nowPhase)) {
                div.getChkIchijiHantei().setDisabled(false);
            }
            if (KanryoInfoPhase.申請受付.getコード().equals(nowPhase)) {
                div.getChkShinseiUketsuke().setDisabled(false);
            }
            if (KanryoInfoPhase.マスキング.getコード().equals(nowPhase)) {
                div.getChkMasking().setDisabled(false);
            }
            if (KanryoInfoPhase.調査依頼.getコード().equals(nowPhase)) {
                div.getChkChosaIrai().setDisabled(false);
            }
            if (KanryoInfoPhase.審査会登録.getコード().equals(nowPhase)) {
                div.getChkShinsakaiToroku().setDisabled(false);
            }
            if (KanryoInfoPhase.意見書依頼.getコード().equals(nowPhase)) {
                div.getChkIkenshoIrai().setDisabled(false);
            }
            if (KanryoInfoPhase.二次判定.getコード().equals(nowPhase)) {
                div.getChkNijiHantei().setDisabled(false);
            }
            if (KanryoInfoPhase.調査入手.getコード().equals(nowPhase)) {
                div.getChkChosaNyushu().setDisabled(false);
            }
            div.getChkTsuchiShori().setDisabled(false);
            if (KanryoInfoPhase.意見書入手.getコード().equals(nowPhase)) {
                div.getChkIkenshoNyushu().setDisabled(false);
            }
            if (KanryoInfoPhase.月例処理.getコード().equals(nowPhase)) {
                div.getChkGetsureiShori().setDisabled(false);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnShujiiIryokikanGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        dataPassModel.set対象モード(new RString(TaishoMode.IryoKikanMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnShujiiIryokikanGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiIryokikanName().setValue(dataPassModel.get主治医医療機関名称());
        div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医氏名の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnShujiiGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        dataPassModel.set対象モード(new RString(TaishoMode.ShujiiMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医氏名の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnShujiiGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiIryokikanName().setValue(dataPassModel.get主治医医療機関名称());
        div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        div.getTxtShujiiName().setValue(dataPassModel.get主治医氏名());
        div.setHdnShujiiCode(dataPassModel.get主治医コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnNinteiChosaItakusakiGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = new KijuntsukiShichosonjohoiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        dataPassModel.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnNinteiChosaItakusakiGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtNinteiChosaItakusakiName().setValue(dataPassModel.get委託先名());
        div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員氏名の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnNinteiChosainGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = new KijuntsukiShichosonjohoiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        dataPassModel.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Chosain.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員氏名の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnNinteiChosainGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtNinteiChosaItakusakiName().setValue(dataPassModel.get委託先名());
        div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
        div.getTxtNinteiChosainName().setValue(dataPassModel.get調査員名());
        div.setHdnChosainCode(dataPassModel.get調査員コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 前回認定調査委託先の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnZenkaiChosaItakusakiGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = new KijuntsukiShichosonjohoiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 前回認定調査委託先の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnZenkaiChosaItakusakiGuide(NinteiShinseishaFinderDiv div) {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtZenkaiNinteiChosaItakusakiName().setValue(dataPassModel.get委託先名());
        div.setHdnZenkaiChosaItakusakiCode(dataPassModel.get委託先コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 前回主治医医療機関の検索処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onClick_btnZenkaiShujiiIryokikanGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        dataPassModel.setサブ業務コード(SubGyomuCode.DBE認定支援.value());
        dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
        return ResponseData.of(div).respond();
    }

    /**
     * 前回主治医医療機関の設定処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onOkClose_btnZenkaiShujiiIryokikanGuide(NinteiShinseishaFinderDiv div) {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtZenkaiShujiiIryokikanName().setValue(dataPassModel.get主治医医療機関名称());
        div.setHdnZenkaiShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        return ResponseData.of(div).respond();
    }

    private NinteiShinseishaFinderHandler getHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderHandler(div);
    }
}
