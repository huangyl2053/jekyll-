/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0110011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 居宅サービス計画作成依頼届出情報登録画面入力のチェックHandler。
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationHandler {

    private final KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div;
    private static final RString メニューID_自己作成 = new RString("DBCMN21002");
    private static final RString 計画修正モード = new RString("modify");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     */
    public KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationHandler(KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate(KyotakuKeikakuTodokede 居宅給付計画届出) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        編集なしで更新不可チェックValidate(validPairs, 居宅給付計画届出);
        居宅適用開始日終了日不整合チェックValidate(validPairs);
        事業者サービス種類チェックチェックValidate(validPairs);
        計画適用開始日チェックValidate(validPairs);
        return validPairs;
    }

    private void 編集なしで更新不可チェックValidate(ValidationMessageControlPairs validPairs, KyotakuKeikakuTodokede 居宅給付計画届出) {
        if (!居宅給付計画届出.hasChanged()) {
            validPairs.add(new ValidationMessageControlPair(
                    new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages(UrErrorMessages.編集なしで更新不可)));
        }
    }

    private void 居宅適用開始日終了日不整合チェックValidate(ValidationMessageControlPairs validPairs) {
        if (div.getTxtKeikakuTekiyoEndYMD() != null
                && div.getTxtKeikakuTekiyoStartYMD().getValue().compareTo(div.getTxtKeikakuTekiyoEndYMD().getValue()) > 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages(DbcErrorMessages.居宅適用開始日終了日不整合)));
        }

    }

    private void 事業者サービス種類チェックチェックValidate(ValidationMessageControlPairs validPairs) {
        if (is自己作成の場合()) {
            return;
        }
        JigyoshaNo 事業者番号 = new JigyoshaNo(div.getTxtJigyoshaNo().getValue());
        KaigoJigyoshaShiteiServiceManager manager = new KaigoJigyoshaShiteiServiceManager();
        List<KaigoJigyoshaShiteiService> 介護事業者指定サービスリスト = manager.get介護事業者指定サービス(事業者番号);
        for (KaigoJigyoshaShiteiService 介護事業者指定サービス : 介護事業者指定サービスリスト) {
            if (ServiceCategoryShurui.居宅支援.getコード().equals(介護事業者指定サービス.getサービス種類コード().value())
                    && ServiceCategoryShurui.居宅支援.getコード().equals(div.getRadServiceShurui().getSelectedKey())) {
                return;
            }
            if (ServiceCategoryShurui.予防支援.getコード().equals(介護事業者指定サービス.getサービス種類コード().value())
                    && ServiceCategoryShurui.予防支援.getコード().equals(div.getRadServiceShurui().getSelectedKey())) {
                return;
            }
            if (ServiceCategoryShurui.地小短外.getコード().equals(介護事業者指定サービス.getサービス種類コード().value())
                    && ServiceCategoryShurui.地小短外.getコード().equals(div.getRadServiceShurui().getSelectedKey())) {
                return;
            }
            if (ServiceCategoryShurui.地予小外.getコード().equals(介護事業者指定サービス.getサービス種類コード().value())
                    && ServiceCategoryShurui.地予小外.getコード().equals(div.getRadServiceShurui().getSelectedKey())) {
                return;
            }
            if (ServiceCategoryShurui.予防ケア.getコード().equals(介護事業者指定サービス.getサービス種類コード().value())
                    && ServiceCategoryShurui.予防ケア.getコード().equals(div.getRadServiceShurui().getSelectedKey())) {
                return;
            }
        }
        validPairs.add(new ValidationMessageControlPair(
                new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages(DbcErrorMessages.事業者サービス種類)));
    }

    private void 計画適用開始日チェックValidate(ValidationMessageControlPairs validPairs) {
        if (!計画修正モード.equals(div.getMode())) {
            return;
        }
        if (!div.getTxtKeikakuTekiyoStartYMD().getValue().getYearMonth().toDateString().equals(div.getKeikakuTekiyoStartYM())) {
            validPairs.add(new ValidationMessageControlPair(
                    new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages(DbcErrorMessages.適用開始日_年月_変更,
                            div.getTxtKeikakuTekiyoStartYMD().getValue().getYearMonth().toString())));
        }
    }

    private boolean is自己作成の場合() {
        return メニューID_自己作成.equals(ResponseHolder.getMenuID());
    }

    private static class KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages implements IValidationMessage {

        private final Message message;

        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
