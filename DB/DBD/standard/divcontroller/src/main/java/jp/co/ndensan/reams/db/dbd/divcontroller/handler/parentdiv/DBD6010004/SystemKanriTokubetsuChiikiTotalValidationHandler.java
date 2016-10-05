/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010004.SystemKanriTokubetsuChiikiTotalDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（特別地域加算減免確認番号）画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3763-010 tz_chengpeng
 */
public class SystemKanriTokubetsuChiikiTotalValidationHandler {

    private final SystemKanriTokubetsuChiikiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriTokubetsuChiikiTotalDiv
     */
    public SystemKanriTokubetsuChiikiTotalValidationHandler(SystemKanriTokubetsuChiikiTotalDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SystemKanriTokubetsuChiikiTotalValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.有効桁数が未入力, get有効桁数())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分子が未入力, get減額率_分子())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分母が未入力, get減額率_分母())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.更新対象のデータがない, get更新対象())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.有効桁数入力値が不正, get有効桁数())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率入力値が不正, get減額率())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分子入力値が不正, get減額率_分子())
                .add(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分母入力値が不正, get減額率_分母())
                .build();
    }

    private List<ViewControl> get更新対象() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadKakuninNo());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadSaiban());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadNoHikitsugi());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2());
        return viewControls;
    }

    private List<ViewControl> get有効桁数() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu());
        return viewControls;
    }

    private List<ViewControl> get減額率_分子() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1());
        return viewControls;
    }

    private List<ViewControl> get減額率_分母() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2());
        return viewControls;
    }

    private List<ViewControl> get減額率() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1());
        viewControls.add(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2());
        return viewControls;
    }
}
