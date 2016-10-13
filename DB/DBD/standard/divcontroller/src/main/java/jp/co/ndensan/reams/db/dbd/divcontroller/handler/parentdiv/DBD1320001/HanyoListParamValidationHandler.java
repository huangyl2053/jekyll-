/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(介護受給共通)のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public class HanyoListParamValidationHandler {

    private final HanyoListParamDiv div;

    /**
     * コンストラクタです
     *
     * @param div ドメインオブジェクトを取り出したい{@link HanyoListParamDiv}
     */
    public HanyoListParamValidationHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンクリックのバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate実行するボタンクリック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(createDictionary実行するボタンクリック().check(validator.validate()));
        return validateResult;

    }

    /**
     * 帳票出力項目チェックのバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate帳票出力項目チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(createDictionary帳票出力項目チェック().check(validator.validate帳票出力項目チェック()));
        validateResult.add(createDictionary実行するボタンクリック().check(validator.validate()));
        return validateResult;

    }

    /**
     * 表題のバリデーション
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate表題() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _HanyoListParamValidator validator = new _HanyoListParamValidator(div);
        validateResult.add(new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.帳票出力項目チェック１, div.getTxtHyodaiMeisho()).build().check(validator.validate表題()));
        return validateResult;

    }

    private ValidationMessageControlDictionary createDictionary実行するボタンクリック() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.実行するボタンクリック1, div.getDdlKijunNendo())
                .add(HanyoListParamValidationMessage.実行するボタンクリック2, div.getTxtKijunDateA())
                .add(HanyoListParamValidationMessage.実行するボタンクリック3, div.getTxtKijunDateB())
                .add(HanyoListParamValidationMessage.実行するボタンクリック5, div.getTxtChushutsuHani())
                .add(HanyoListParamValidationMessage.実行するボタンクリック7, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getTxtNenrei())
                .add(HanyoListParamValidationMessage.実行するボタンクリック10, div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div().getTxtSeinengappi())
                .build();
    }

    private ValidationMessageControlDictionary createDictionary帳票出力項目チェック() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(HanyoListParamValidationMessage.帳票出力項目チェック２, div)
                .add(HanyoListParamValidationMessage.帳票出力項目チェック３, div)
                .build();
    }
}
