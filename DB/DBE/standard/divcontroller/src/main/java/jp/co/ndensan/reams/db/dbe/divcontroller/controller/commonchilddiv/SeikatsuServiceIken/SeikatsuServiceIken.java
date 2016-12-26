/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.SeikatsuServiceIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken.SeikatsuServiceIkenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken.SeikatsuServiceIkenHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 生活サービス意見入力のクラスです。
 *
 * @reamsid_L DBE-3000-110 wangkun
 */
public class SeikatsuServiceIken {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");

    /**
     * コンストラクタです。
     *
     */
    public SeikatsuServiceIken() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div SeikatsuServiceIkenDiv
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onLoad(SeikatsuServiceIkenDiv div) {
        getHandler(div).onLoad();
        getHandler(div).初期化状態定義();
        div.setHiddenData(getAllData(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 現在の栄養状況ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radGenzaiEiyoJotai(SeikatsuServiceIkenDiv div) {
        if (KEY0.equals(div.getRadGenzaiEiyoJotai().getSelectedKey())) {
            div.getTxtEiyoShokuseikatsuRyuiten().setReadOnly(true);
            div.getTxtEiyoShokuseikatsuRyuiten().clearValue();
        } else if (KEY1.equals(div.getRadGenzaiEiyoJotai().getSelectedKey())) {
            div.getTxtEiyoShokuseikatsuRyuiten().setReadOnly(false);
            div.getTxtEiyoShokuseikatsuRyuiten().setValue(div.getHiddenTxtEiyoShokuseikatsuRyuiten());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 発生状態対処方針その他チェックボックスのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_chkJotaiSonota(SeikatsuServiceIkenDiv div) {
        if (div.getChkJotaiSonota().getSelectedKeys().isEmpty()) {
            div.getTxtSonotaJotaiShosai().setReadOnly(true);
            div.getTxtSonotaJotaiShosai().clearValue();
            div.getTxtTaishoHoushin().setDisplayNone(true);
        } else {
            div.getTxtSonotaJotaiShosai().setReadOnly(false);
            div.getTxtSonotaJotaiShosai().setValue(div.getHiddenTxtSonotaJotaiShosai());
            div.getTxtTaishoHoushin().setDisplayNone(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * その他医療系サービスチェックボックスのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_chkSonotaIryoService(SeikatsuServiceIkenDiv div) {
        if (div.getChkSonotaIryoService().getSelectedKeys().isEmpty()) {
            div.getTxtShonotaIryoServiceShosai().setReadOnly(true);
            div.getTxtShonotaIryoServiceShosai().clearValue();
        } else {
            div.getTxtShonotaIryoServiceShosai().setReadOnly(false);
            div.getTxtShonotaIryoServiceShosai().setValue(div.getHiddenTxtShonotaIryoServiceShosai());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 血圧ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radKetsuatsu(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadKetsuatsu().getSelectedKey())) {
            div.getTxtKetsuatsu().setReadOnly(false);
            div.getTxtKetsuatsu().setValue(div.getHiddenTxtKetsuatsu());
        } else {
            div.getTxtKetsuatsu().setReadOnly(true);
            div.getTxtKetsuatsu().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 移動ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radIdo(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadIdo().getSelectedKey())) {
            div.getTxtIdo().setReadOnly(false);
            div.getTxtIdo().setValue(div.getHiddenTxtIdo());
        } else {
            div.getTxtIdo().setReadOnly(true);
            div.getTxtIdo().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 摂食ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radSesshoku(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadSesshoku().getSelectedKey())) {
            div.getTxtSesshoku().setReadOnly(false);
            div.getTxtSesshoku().setValue(div.getHiddenTxtSesshoku());
        } else {
            div.getTxtSesshoku().setReadOnly(true);
            div.getTxtSesshoku().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 運動ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radUndo(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadUndo().getSelectedKey())) {
            div.getTxtUndo().setReadOnly(false);
            div.getTxtUndo().setValue(div.getHiddenTxtUndo());
        } else {
            div.getTxtUndo().setReadOnly(true);
            div.getTxtUndo().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 嚥下ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radEnka(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadEnka().getSelectedKey())) {
            div.getTxtEnka().setReadOnly(false);
            div.getTxtEnka().setValue(div.getHiddenTxtEnka());
        } else {
            div.getTxtEnka().setReadOnly(true);
            div.getTxtEnka().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 感染症の有無ラジオボタンのonChange処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SeikatsuServiceIkenDiv>
     */
    public ResponseData<SeikatsuServiceIkenDiv> onChange_radKansenshoUmu(SeikatsuServiceIkenDiv div) {
        if (KEY1.equals(div.getRadKansenshoUmu().getSelectedKey())) {
            div.getTxtKansenshoShosai().setReadOnly(false);
            div.getTxtKansenshoShosai().setValue(div.getHiddenTxtKansenshoShosai());
        } else {
            div.getTxtKansenshoShosai().setReadOnly(true);
            div.getTxtKansenshoShosai().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 生活サービス意見入力の「確定」ボタンが押下します。
     *
     * @param div SeikatsuServiceIkenDiv
     * @return ResponseData
     */
    public ResponseData<SeikatsuServiceIkenDiv> onClick_btnKakutei(SeikatsuServiceIkenDiv div) {
        if (hasChange(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                        UrQuestionMessages.確定の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).editShujiiIkenshoJoho();
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 生活サービス意見入力の「取消」ボタンが押下します。
     *
     * @param div SeikatsuServiceIkenDiv
     * @return ResponseData
     */
    public ResponseData<SeikatsuServiceIkenDiv> onClick_btnCancel(SeikatsuServiceIkenDiv div) {
        if (hasChange(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private boolean hasChange(SeikatsuServiceIkenDiv div) {
        return !getAllData(div).equals(div.getHiddenData());
    }

    private RString getAllData(SeikatsuServiceIkenDiv div) {
        RStringBuilder build = new RStringBuilder();
        return build.append(div.getRadOkugaiHokou().getSelectedKey())
                .append(div.getRadKurumaisuShiyo().getSelectedKey())
                .append(div.getRadShokujiKoi().getSelectedKey())
                .append(div.getRadGenzaiEiyoJotai().getSelectedKey())
                .append(div.getTxtEiyoShokuseikatsuRyuiten().getValue())
                .append(div.getChkJotaiSonota().getSelectedKeys())
                .append(div.getTxtSonotaJotaiShosai().getValue())
                .append(div.getTxtTaishoHoushin().getValue())
                .append(div.getRadSeikatsuKinoMitoshi().getSelectedKey())
                .append(div.getChkSonotaIryoService().getSelectedKeys())
                .append(div.getTxtShonotaIryoServiceShosai().getValue())
                .append(div.getChkSonotaIryoServiceHitsuyoSei().getSelectedKeys())
                .append(div.getRadKetsuatsu().getSelectedKey())
                .append(div.getTxtKetsuatsu().getValue())
                .append(div.getRadIdo().getSelectedKey())
                .append(div.getTxtIdo().getValue())
                .append(div.getRadSesshoku().getSelectedKey())
                .append(div.getTxtSesshoku().getValue())
                .append(div.getRadUndo().getSelectedKey())
                .append(div.getTxtUndo().getValue())
                .append(div.getRadEnka().getSelectedKey())
                .append(div.getTxtEnka().getValue())
                .append(div.getTxtSonotaRyuiJiko().getValue())
                .append(div.getRadKansenshoUmu().getSelectedKey())
                .append(div.getTxtKansenshoShosai().getValue())
                .append(div.getChkHokohojoShiyo().getSelectedKeys())
                .append(div.getChkHasseiShojo().getSelectedKeys())
                .append(div.getChkIgakutekiKanri().getSelectedKeys())
                .toRString();
    }

    private SeikatsuServiceIkenHandler getHandler(SeikatsuServiceIkenDiv div) {
        return new SeikatsuServiceIkenHandler(div);
    }

}
