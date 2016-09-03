/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010005.SystemKanriKoikiDataTotalDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（広域データ交換）画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3764-010 tz_chengpeng
 */
public class SystemKanriKoikiDataTotalValidationHandler {

    private final SystemKanriKoikiDataTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriKoikiDataTotalDiv
     */
    public SystemKanriKoikiDataTotalValidationHandler(SystemKanriKoikiDataTotalDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SystemKanriKoikiDataTotalValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriKoikiDataTotalValidationMessage.一次判定ファイル名が未入力, get一次判定ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.訪問調査ファイル名が未入力, get訪問調査ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.特記事項ファイル名が未入力, get特記事項ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.意見書ファイル名が未入力, get意見書ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.日医意見書ファイル名が未入力, get日医意見書ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.死亡情報ファイル名が未入力, get死亡情報ファイル名())
                .add(SystemKanriKoikiDataTotalValidationMessage.更新対象のデータがない, get画面項目())
                .build();
    }

    private List<ViewControl> get画面項目() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getRadNinteiYukoShuryobi());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getDdlChosainSchedule());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getDdlHomonChosa());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getRadIkenshoShinsei());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtIchijiHanteiFileName());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtHomonChosaFileName());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtTokkiJikoFileName());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtIkenshoFile());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtNichiiIkenshoFile());
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtShiboJohoFile());
        return viewControls;
    }

    private List<ViewControl> get一次判定ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtIchijiHanteiFileName());
        return viewControls;
    }

    private List<ViewControl> get訪問調査ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtHomonChosaFileName());
        return viewControls;
    }

    private List<ViewControl> get特記事項ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtTokkiJikoFileName());
        return viewControls;
    }

    private List<ViewControl> get意見書ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtIkenshoFile());
        return viewControls;
    }

    private List<ViewControl> get日医意見書ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtNichiiIkenshoFile());
        return viewControls;
    }

    private List<ViewControl> get死亡情報ファイル名() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriKoikiData().getTxtShiboJohoFile());
        return viewControls;
    }
}
