/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseishaFinder;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
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
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
//        getHandler(div).clearChk();
        if (RString.isNullOrEmpty(nowPhase)) {
            div.getChkShoriJotai().setDisabled(true);
            div.getChkKoshinTaishoChushutsu().setDisabled(true);
            div.getChkIchijiHantei().setDisabled(true);
            div.getChkShinseiUketsuke().setDisabled(true);
            div.getChkMasking().setDisabled(true);
            div.getChkChosaIrai().setDisabled(true);
            div.getChkShinsakaiToroku().setDisabled(true);
            div.getChkIkenshoIrai().setDisabled(true);
            div.getChkNijiHantei().setDisabled(true);
            div.getChkChosaNyushu().setDisabled(true);
            div.getChkTsuchiShori().setDisabled(true);
            div.getChkIkenshoNyushu().setDisabled(true);
            div.getChkGetsureiShori().setDisabled(true);
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
        div.getChkGetsureiShori().setSelectedItems(new ArrayList());
        div.getChkIkenshoNyushu().setSelectedItems(new ArrayList());
        div.getChkTsuchiShori().setSelectedItems(new ArrayList());
        div.getChkChosaNyushu().setSelectedItems(new ArrayList());
        div.getChkNijiHantei().setSelectedItems(new ArrayList());
        div.getChkIkenshoIrai().setSelectedItems(new ArrayList());
        div.getChkShinsakaiToroku().setSelectedItems(new ArrayList());
        div.getChkChosaIrai().setSelectedItems(new ArrayList());
        div.getChkMasking().setSelectedItems(new ArrayList());
        div.getChkShinseiUketsuke().setSelectedItems(new ArrayList());
        div.getChkIchijiHantei().setSelectedItems(new ArrayList());
        div.getChkKoshinTaishoChushutsu().setSelectedItems(new ArrayList());
        div.getChkShoriJotai().setSelectedItems(new ArrayList());
        return ResponseData.of(div).respond();
    }

    /**
     * 申請受付のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkShinseiUketsuke(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkShinseiUketsuke().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ①フェーズDDLが申請受付の場合
            if (KanryoInfoPhase.申請受付.getコード().equals(nowPhase)
                    && div.getChkShinseiUketsuke().getSelectedKeys().contains(処理状態完了)) {
                div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査依頼のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkChosaIrai(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkChosaIrai().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ②フェーズDDLが調査依頼の場合
            if (KanryoInfoPhase.調査依頼.getコード().equals(nowPhase)) {
                if (div.getChkChosaIrai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書依頼のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkIkenshoIrai(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkIkenshoIrai().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ③フェーズDDLが意見書依頼の場合
            if (KanryoInfoPhase.意見書依頼.getコード().equals(nowPhase)) {
                if (div.getChkIkenshoIrai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査入手のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkChosaNyushu(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkChosaNyushu().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ④フェーズDDLが調査入手の場合
            if (KanryoInfoPhase.調査入手.getコード().equals(nowPhase)) {
                if (div.getChkChosaNyushu().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書入手のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkIkenshoNyushu(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkIkenshoNyushu().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑤フェーズDDLが意見書入手の場合
            if (KanryoInfoPhase.意見書入手.getコード().equals(nowPhase)) {
                if (div.getChkIkenshoNyushu().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkIchijiHantei(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkIchijiHantei().getSelectedKeys().size() != 2) {
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑥フェーズDDLが一次判定の場合
            if (KanryoInfoPhase.一次判定.getコード().equals(nowPhase)) {
                if (div.getChkIchijiHantei().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * マスキングのonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkMasking(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkMasking().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑦フェーズDDLがマスキングの場合
            if (KanryoInfoPhase.マスキング.getコード().equals(nowPhase)) {
                if (div.getChkMasking().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会登録のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkShinsakaiToroku(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkShinsakaiToroku().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑧フェーズDDLが審査会登録の場合
            if (KanryoInfoPhase.審査会登録.getコード().equals(nowPhase)) {
                if (div.getChkShinsakaiToroku().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 二次判定のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkNijiHantei(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkNijiHantei().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑨フェーズDDLが二次判定の場合
            if (KanryoInfoPhase.二次判定.getコード().equals(nowPhase)) {
                if (div.getChkNijiHantei().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 月例処理のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkGetsureiShori(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);  
        if (div.getChkGetsureiShori().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyMikann);
            // ⑩フェーズDDLが月例処理の場合
            if (KanryoInfoPhase.月例処理.getコード().equals(nowPhase)) {
                if (div.getChkGetsureiShori().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShoriJotai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
            }
        }
        return ResponseData.of(div).respond();
    }

     /**
     * 現在のフェーズDDLより、処理状態のonChangeまだonClick場合、各処理状態を制御します。
     *
     * @param div NinteiShinseishaFinderDiv
     * @return ResponseData
     */
    public ResponseData<NinteiShinseishaFinderDiv> onChange_chkShoriJotai(NinteiShinseishaFinderDiv div) {
        RString nowPhase = div.getDdlNowPhase().getSelectedKey();
        RString 処理状態完了 = new RString("key0");
        RString 処理状態未完了 = new RString("key1");
        List<RString> selectedkeyMikann = new ArrayList();
        List<RString> selectedkeyKanryo = new ArrayList();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        if (div.getChkShoriJotai().getSelectedKeys().size() != 2) {
            div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);

            // ①フェーズDDLが申請受付の場合
            if (KanryoInfoPhase.申請受付.getコード().equals(nowPhase)
                    && div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ②フェーズDDLが調査依頼の場合
            if (KanryoInfoPhase.調査依頼.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ③フェーズDDLが意見書依頼の場合
            if (KanryoInfoPhase.意見書依頼.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ④フェーズDDLが調査入手の場合
            if (KanryoInfoPhase.調査入手.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ⑤フェーズDDLが意見書入手の場合
            if (KanryoInfoPhase.意見書入手.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
            }

            // ⑥フェーズDDLが一次判定の場合
            if (KanryoInfoPhase.一次判定.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ⑦フェーズDDLがマスキングの場合
            if (KanryoInfoPhase.マスキング.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ⑧フェーズDDLが審査会登録の場合
            if (KanryoInfoPhase.審査会登録.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ⑨フェーズDDLが二次判定の場合
            if (KanryoInfoPhase.二次判定.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
            }
            // ⑩フェーズDDLが月例処理の場合
            if (KanryoInfoPhase.月例処理.getコード().equals(nowPhase)) {
                if (div.getChkShoriJotai().getSelectedKeys().contains(処理状態完了)) {
                    div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyKanryo);
                }
                div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
                div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
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
        if (!dataPassModel.get市町村コード().equals(div.getHdnShujiiShichosonCode()) || 
                !div.getHdnShujiiIryokikanCode().equals(dataPassModel.get主治医医療機関コード())) {
            div.getTxtShujiiIryokikanName().setValue(dataPassModel.get主治医医療機関名称());
            div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
            div.setHdnShujiiShichosonCode(dataPassModel.get市町村コード());
            div.getTxtShujiiName().setValue(RString.EMPTY);
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
        div.setHdnShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        div.getTxtShujiiName().setValue(dataPassModel.get主治医氏名());
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
        if (!dataPassModel.get市町村コード().equals(div.getHdnChosaShichosonCode()) || 
                !div.getHdnChosaItakusakiCode().equals(dataPassModel.get委託先コード())) {
            div.getTxtNinteiChosaItakusakiName().setValue(dataPassModel.get委託先名());
            div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
            div.setHdnChosaShichosonCode(dataPassModel.get市町村コード());
            div.getTxtNinteiChosainName().setValue(RString.EMPTY);
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
        div.setHdnChosaItakusakiCode(dataPassModel.get委託先コード());
        div.getTxtNinteiChosainName().setValue(dataPassModel.get調査員名());
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
        div.setHdnZenkaiShujiiIryokikanCode(dataPassModel.get主治医医療機関コード());
        return ResponseData.of(div).respond();
    }

    private NinteiShinseishaFinderHandler getHandler(NinteiShinseishaFinderDiv div) {
        return new NinteiShinseishaFinderHandler(div);
    }
}
