/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA9010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA9010011.TennyuHoryuTokuteiJushoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 連動保留特定住所登録の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBA-0480-010 zhangzhiming
 */
public class TennyuHoryuValidationHandler {

    private final TennyuHoryuTokuteiJushoDiv div;
    private static final RString SHICHOSONCODE_VALUE = new RString("11");

    /**
     * コンストラクタです。
     *
     * @param div 地区認定Div
     */
    public TennyuHoryuValidationHandler(TennyuHoryuTokuteiJushoDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        RString strLasdecCode = div.getTennyuHoryuTokuteiJushoNyuryoku().getDdlShichosonCode().getSelectedKey();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(strLasdecCode)) {
            validationMessages.add(new ValidationMessageControlPair(new TennyuHoryuValidationHandler.RRVMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, "市町村コード")));
        }
        if (RString.isNullOrEmpty(div.getTennyuHoryuTokuteiJushoNyuryoku().getCcdBunchiInput().get番地().getColumnValue())) {
            validationMessages.add(new ValidationMessageControlPair(new TennyuHoryuValidationHandler.RRVMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, "番地")));
        }

        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();

        System.out.println("strLasdecCode:" + strLasdecCode);

        if (SHICHOSONCODE_VALUE.equals(導入形態コード.getKey().substring(1))) {

            List<KoseiShichoson> koseiShichosonList = KoikiShichosonJohoFinder.createInstance().getKoseiShichosonList().records();
            List list = new ArrayList();
            for (KoseiShichoson koseiList : koseiShichosonList) {
                list.add(koseiList.get市町村コード().value());
                System.out.println("listMenbers:" + koseiList.get市町村コード().value());
            }

            if (!list.contains(strLasdecCode)) {
                validationMessages.add(new ValidationMessageControlPair(new TennyuHoryuValidationHandler.RRVMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード")));
            }
        } else {

            System.out.println("shichosonSecurity:" + 市町村セキュリティ情報.get市町村情報().get市町村コード());
            if (!strLasdecCode.equals(市町村セキュリティ情報.get市町村情報().get市町村コード().value())) {
                validationMessages.add(new ValidationMessageControlPair(new TennyuHoryuValidationHandler.RRVMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "市町村コード")));
            }
        }
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
