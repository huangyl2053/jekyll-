/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（社会福祉法人確認番号）画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3762-010 tz_chengpeng
 */
public class SystemKanriShakaiFukushiTotalValidationHandler {

    private final SystemKanriShakaiFukushiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriShakaiFukushiTotalDiv
     */
    public SystemKanriShakaiFukushiTotalValidationHandler(SystemKanriShakaiFukushiTotalDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SystemKanriShakaiFukushiTotalValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriShakaiFukushiTotalValidationMessage.有効桁数が未入力, get有効桁数())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.減免率の分子が未入力, get減免率_分子())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.減免率の分母が未入力, get減免率_分母())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分子が未入力, get軽減率_分子())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分母が未入力, get軽減率_分母())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.更新対象のデータがない, get更新対象())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.有効桁数入力値が不正, get有効桁数())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.減免率入力値が不正, get減免率())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分子入力値が不正, get軽減率_分子())
                .add(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分母入力値が不正, get軽減率_分母())
                .build();
    }

    private List<ViewControl> get更新対象() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getRadKakuninNo());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getRadSaiban());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getRadNoHikitsugi());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2());
        return viewControls;
    }

    private List<ViewControl> get有効桁数() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu());
        return viewControls;
    }

    private List<ViewControl> get減免率_分子() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1());
        return viewControls;
    }

    private List<ViewControl> get減免率_分母() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2());
        return viewControls;
    }

    private List<ViewControl> get減免率() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1());
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2());
        return viewControls;
    }

    private List<ViewControl> get軽減率_分子() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1());
        return viewControls;
    }

    private List<ViewControl> get軽減率_分母() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2());
        return viewControls;
    }
}
