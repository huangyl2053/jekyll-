/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックValidationHandlerです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanelValidationHandler {

    private final FuchoKarisanteiFukaMenuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link FuchoKarisanteiFukaMenuPanelDiv}
     */
    public FuchoKarisanteiFukaMenuPanelValidationHandler(FuchoKarisanteiFukaMenuPanelDiv div) {
        this.div = div;
    }

    /**
     * 発行日入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate発行日() {
        IValidationMessages message = new FuchoKarisanteiFukaMenuPanelValidator(div).validate発行日入力();
        return create発行日入力Dictionary().check(message);
    }

    private ValidationDictionary create発行日入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(FuchoKarisanteiFukaMenuPanelValidationMessage.発行日チェック, div.getMainPanelBatchParameter()
                        .getFuchoKarisanteiChohyoHakko2().getFuchoTsuchiKobetsuJoho().getTxtHakkoYMD()).build();
    }

    /**
     * 対象者入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate対象者未選択() {
        IValidationMessages message = new FuchoKarisanteiFukaMenuPanelValidator(div).validate対象者入力();
        return create対象者Dictionary().check(message);
    }

    private ValidationDictionary create対象者Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(FuchoKarisanteiFukaMenuPanelValidationMessage.対象者チェック, div.getMainPanelBatchParameter()
                        .getFuchoKarisanteiChohyoHakko2().getFuchoTsuchiKobetsuJoho().getChkNotsuTaishosha2()).build();
    }

    /**
     * 帳票IDのチェック_型0チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate帳票IDのチェック_型0() {
        IValidationMessages message = new FuchoKarisanteiFukaMenuPanelValidator(div).validate帳票IDのチェック_型0();
        return create帳票IDのチェック_型0().check(message);
    }

    private ValidationDictionary create帳票IDのチェック_型0() {
        return new ValidationDictionaryBuilder()
                .add(FuchoKarisanteiFukaMenuPanelValidationMessage.帳票IDのチェック_型0, div.getMainPanelBatchParameter()
                        .getFuchoKarisanteiChohyoHakko2()).build();
    }

    /**
     * 帳票IDのチェック_型2チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate帳票IDのチェック_型2() {
        IValidationMessages message = new FuchoKarisanteiFukaMenuPanelValidator(div).validate帳票IDのチェック_型2();
        return create帳票IDのチェック_型2().check(message);
    }

    private ValidationDictionary create帳票IDのチェック_型2() {
        return new ValidationDictionaryBuilder()
                .add(FuchoKarisanteiFukaMenuPanelValidationMessage.帳票IDのチェック_型2, div.getMainPanelBatchParameter()
                        .getFuchoKarisanteiChohyoHakko2()).build();
    }
}
