/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public class ShichosonTokubetuKyufuServiceTourokuValidationHandler {

    private final ShichosonTokubetuKyufuServiceTourokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShichosonTokubetuKyufuServiceFinderTourokuDiv
     */
    public ShichosonTokubetuKyufuServiceTourokuValidationHandler(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ShichosonTokubetuKyufuServiceTourokuValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.更新不可, new ArrayList<ViewControl>())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.削除不可, new ArrayList<ViewControl>())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.有効開始日と有効終了日の前後関係が不正, get有効開始日と有効終了日())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.前回の有効開始日以降の入力不正, get有効開始日())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.前回の有効終了日以前の入力不正, get有効開始日())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.名称入力内容が不正, get名称())
                .add(ShichosonTokubetuKyufuServiceTourokuValidationMessage.略称入力内容が不正, get略称())
                .build();
    }

    private List<ViewControl> get有効開始日と有効終了日() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM());
        viewControls.add(div.getKubunShikyuGendogakuShosai().getTxtYukoShuryoYM());
        return viewControls;
    }

    private List<ViewControl> get有効開始日() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getKubunShikyuGendogakuShosai().getTxtYukoKaishiYM());
        return viewControls;
    }

    private List<ViewControl> get名称() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getKubunShikyuGendogakuShosai().getTxtServiceMeisho());
        return viewControls;
    }

    private List<ViewControl> get略称() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getKubunShikyuGendogakuShosai().getTxtServiceRyakusho());
        return viewControls;
    }

}
