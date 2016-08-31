/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.SystemKanriNinteiShienTotalDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public class SystemKanriNinteiShienTotalValidationHandler {

    private final SystemKanriNinteiShienTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriNinteiShienTotalDiv
     */
    public SystemKanriNinteiShienTotalValidationHandler(SystemKanriNinteiShienTotalDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SystemKanriNinteiShienTotalValidator(div).validate();
        validateResult.add(更新対象のデータがない().check(messages));
        validateResult.add(必須入力チェック().check(messages));

        return validateResult;
    }

    private ValidationDictionary 更新対象のデータがない() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get認定結果ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get指定事業出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get調査員出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get医療機関出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get主治医出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get申請情報出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get認定結果ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get指定事業出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get調査員出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get医療機関出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get主治医出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない, get申請情報出力ファイル_新())
                .build();
    }

    private ValidationDictionary 必須入力チェック() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriNinteiShienTotalValidationMessage.認定ＩＦ改定日が未入力, get認定ＩＦ改定日())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_認定結果ファイルが未入力, get認定結果ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_指定事業出力ファイルが未入力, get指定事業出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_調査員出力ファイルが未入力, get調査員出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_医療機関出力ファイルが未入力, get医療機関出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_主治医出力ファイルが未入力, get主治医出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.旧様式_申請情報出力ファイルが未入力, get申請情報出力ファイル())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_認定結果ファイルが未入力, get認定結果ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_指定事業出力ファイルが未入力, get指定事業出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_調査員出力ファイルが未入力, get調査員出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_医療機関出力ファイルが未入力, get医療機関出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_主治医出力ファイルが未入力, get主治医出力ファイル_新())
                .add(SystemKanriNinteiShienTotalValidationMessage.新様式_申請情報出力ファイルが未入力, get申請情報出力ファイル_新())
                .build();
    }

    private List<ViewControl> get認定ＩＦ改定日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiIfKaiteiYMD());
        return viewControls;
    }

    private List<ViewControl> get認定結果ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileOld());
        return viewControls;
    }

    private List<ViewControl> get指定事業出力ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileOld());
        return viewControls;
    }

    private List<ViewControl> get調査員出力ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileOld());
        return viewControls;
    }

    private List<ViewControl> get医療機関出力ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileOld());
        return viewControls;
    }

    private List<ViewControl> get主治医出力ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileOld());
        return viewControls;
    }

    private List<ViewControl> get申請情報出力ファイル() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileOld());
        return viewControls;
    }

    private List<ViewControl> get認定結果ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileNew());
        return viewControls;
    }

    private List<ViewControl> get指定事業出力ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileNew());
        return viewControls;
    }

    private List<ViewControl> get調査員出力ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileNew());
        return viewControls;
    }

    private List<ViewControl> get医療機関出力ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileNew());
        return viewControls;
    }

    private List<ViewControl> get主治医出力ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileNew());
        return viewControls;
    }

    private List<ViewControl> get申請情報出力ファイル_新() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileNew());
        return viewControls;
    }
}
