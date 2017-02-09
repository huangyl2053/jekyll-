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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * 保険者DDLを変更した時の処理です。<br/>
     * 最近処理者が使用可能である場合に最近処理者の一覧を更新します。
     *
     * @param div
     * @return
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_Hokenja(NinteiShinseishaFinderDiv div) {
        if (div.getCcdSaikinShorisha().isDisplayNone() || !div.getCcdSaikinShorisha().isVisible()) {
            div.getCcdSaikinShorisha().initialize(div.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号());
        }
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
     * 厚労省IFコードDDLの変更時処理です。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_ddlKoroshoShikibetsuCode(NinteiShinseishaFinderDiv div) {
        getHandler(div).set二次判定結果DDL();
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
     * 現在のフェーズDDLのonChange場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_ddlNowPhase(NinteiShinseishaFinderDiv div) {
        getHandler(div).init完了情報();
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        if (RString.isNullOrEmpty(nowPhase)) {
            getHandler(div).set完了情報未選択();
        } else {
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
            if (KanryoInfoPhase.申請受付.getコード().equals(nowPhase)) {
                getHandler(div).set申請受付完了情報();
            }
            if (KanryoInfoPhase.調査依頼.getコード().equals(nowPhase)) {
                getHandler(div).set調査依頼完了情報();
            }
            if (KanryoInfoPhase.意見書依頼.getコード().equals(nowPhase)) {
                getHandler(div).set意見書依頼完了情報();
            }
            if (KanryoInfoPhase.調査入手.getコード().equals(nowPhase)) {
               getHandler(div).set調査入手完了情報();
            }
            if (KanryoInfoPhase.意見書入手.getコード().equals(nowPhase)) {
                getHandler(div).set意見書入手完了情報();
            }
            if (KanryoInfoPhase.一次判定.getコード().equals(nowPhase)) {
                getHandler(div).set一次判定完了情報();
            }
            if (KanryoInfoPhase.マスキング.getコード().equals(nowPhase)) {
                getHandler(div).setマスキング完了情報();
            }
            if (KanryoInfoPhase.審査会登録.getコード().equals(nowPhase)) {
                getHandler(div).set審査会登録完了情報();
            }
            if (KanryoInfoPhase.二次判定.getコード().equals(nowPhase)) {
                getHandler(div).set二次判定完了情報();
            }
            if (KanryoInfoPhase.月例処理.getコード().equals(nowPhase)) {
                getHandler(div).set月例処理完了情報();
            }
        }
        getHandler(div).setKanryoJoho();
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
        if (!dataPassModel.get市町村コード().equals(div.getHdnShujiiShichosonCode())
                || !div.getHdnShujiiIryokikanCode().equals(dataPassModel.get主治医医療機関コード())) {
            div.getTxtShujiiIryokikanName().setValue(dataPassModel.get主治医医療機関名称());
            div.getTxtShujiiIryokikan().setDomain(new Code(dataPassModel.get主治医医療機関コード()));
            div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
            div.setHdnShujiiShichosonCode(dataPassModel.get市町村コード());
            div.getTxtShujiiName().setValue(RString.EMPTY);
            div.getTxtShujiiShimei().setDomain(Code.EMPTY);
            div.setHdnShujiiCode(RString.EMPTY);
        }
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
        dataPassModel.set主治医医療機関コード(div.getHdnShujiiIryokikanCode());
        if (RString.isNullOrEmpty(div.getHdnShujiiShichosonCode())) {
            dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        } else {
            dataPassModel.set市町村コード(div.getHdnShujiiShichosonCode());
        }
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
        div.getTxtShujiiIryokikan().setDomain(new Code(dataPassModel.get主治医医療機関コード()));
        div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        div.getTxtShujiiName().setValue(dataPassModel.get主治医氏名());
        div.getTxtShujiiShimei().setDomain(new Code(dataPassModel.get主治医コード()));
        div.setHdnShujiiCode(dataPassModel.get主治医コード());
        div.setHdnShujiiShichosonCode(dataPassModel.get市町村コード());
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
        if (!dataPassModel.get市町村コード().equals(div.getHdnChosaShichosonCode())
                || !div.getHdnChosaItakusakiCode().equals(dataPassModel.get委託先コード())) {
            div.getTxtNinteiChosaItakusakiName().setValue(dataPassModel.get委託先名());
            div.getTxtNinteiChosaIinItakuSaki().setDomain(new Code(dataPassModel.get委託先コード()));
            div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
            div.setHdnChosaShichosonCode(dataPassModel.get市町村コード());
            div.getTxtNinteiChosainName().setValue(RString.EMPTY);
            div.getTxtNinteiChosaInShimei().setDomain(Code.EMPTY);
            div.setHdnChosainCode(RString.EMPTY);
        }
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
        dataPassModel.set委託先コード(div.getHdnChosaItakusakiCode());
        if (RString.isNullOrEmpty(div.getHdnChosaShichosonCode())) {
            dataPassModel.set市町村コード(div.getDdlHokenshaNumber().getSelectedItem().get市町村コード().value());
        } else {
            dataPassModel.set市町村コード(div.getHdnChosaShichosonCode());
        }
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
        div.getTxtNinteiChosaIinItakuSaki().setDomain(new Code(dataPassModel.get委託先コード()));
        div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
        div.getTxtNinteiChosainName().setValue(dataPassModel.get調査員名());
        div.getTxtNinteiChosaInShimei().setDomain(new Code(dataPassModel.get調査員コード()));
        div.setHdnChosainCode(dataPassModel.get調査員コード());
        div.setHdnChosaShichosonCode(dataPassModel.get市町村コード());
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
        dataPassModel.set対象モード(new RString(ChosaItakusakiAndChosainGuideDiv.TaishoMode.Itakusaki.toString()));
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
        div.getTxtZenkaiChosaItakusaki().setDomain(new Code(dataPassModel.get委託先コード()));
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
        dataPassModel.set対象モード(new RString(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode.toString()));
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
        div.getTxtZenkaiShujiiIryokikan().setDomain(new Code(dataPassModel.get主治医医療機関コード()));
        div.setHdnZenkaiShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        return ResponseData.of(div).respond();
    }

    private NinteiShinseishaFinderHandler getHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderHandler(div);
    }
    
    /**
     * 入力された認定調査委託先からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtNinteiChosaIinItakuSaki(NinteiShinseishaFinderDiv div) {      
        getHandler(div).onBlur_txtNinteiChosaIinItakuSaki();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された認定調査員氏名からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtNinteiChosaInShimei(NinteiShinseishaFinderDiv div) {
        getHandler(div).onBlur_txtNinteiChosaInShimei();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された主治医医療機関からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtShujiiIryokikan(NinteiShinseishaFinderDiv div) {
        getHandler(div).onBlur_txtShujiiIryokikan();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された主治医氏名からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtShujiiShimei(NinteiShinseishaFinderDiv div) {
        getHandler(div).onBlur_txtShujiiShimei();
        return ResponseData.of(div).respond();
    }

    /**
     * 前回情報に入力された認定調査委託先からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtZenkaiChosaItakusaki(NinteiShinseishaFinderDiv div) {
        getHandler(div).onBlur_txtZenkaiChosaItakusaki();
        return ResponseData.of(div).respond();
    }

    /**
     * 前回情報に入力された主治医医療機関からコード名称を取得します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onBlur_txtZenkaiShujiiIryokikan(NinteiShinseishaFinderDiv div) {
        getHandler(div).onBlur_txtZenkaiShujiiIryokikan();
        return ResponseData.of(div).respond();
    }
}
