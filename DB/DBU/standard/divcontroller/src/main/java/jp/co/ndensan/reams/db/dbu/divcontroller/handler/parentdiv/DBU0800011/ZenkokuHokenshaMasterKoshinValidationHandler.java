/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0800011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.message.DbuErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.ZenkokuHokenshaMasterKoshinDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.dgHokenshas_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author ChenXiangyu
 */
public class ZenkokuHokenshaMasterKoshinValidationHandler {

    private final ZenkokuHokenshaMasterKoshinDiv div;
    private static final RString 保険者名 = new RString("保険者名");
    private static final RString 保険者番号 = new RString("保険者番号");

    /**
     * コンストラクタです。
     *
     * @param div ZenkokuHokenshaMasterKoshinDiv
     */
    public ZenkokuHokenshaMasterKoshinValidationHandler(ZenkokuHokenshaMasterKoshinDiv div) {
        this.div = div;
    }

    /**
     * 「追加」の場合入力された保険者番号が重複のチェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPair validate重複() {
        RString 保険者番号値 = div.getHokenshaJoho().getTxtHokenshaNo().getValue();
        if (!保険者番号値.isNullOrEmpty()) {
            List<dgHokenshas_Row> rowList = div.getDgHokenshas().getDataSource();
            boolean 重複フラグ = false;
            for (dgHokenshas_Row row : rowList) {
                if (row.getHokenshaNo().equals(保険者番号値)) {
                    重複フラグ = true;
                    break;
                }
            }
            if (重複フラグ) {
                return new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.既に登録済, 保険者番号値.toString()));
            }
        }
        return null;
    }

    /**
     * 保険者名と保険者番号の必須チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate必須入力項() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getHokenshaJoho().getTxtHokenshaNo().getValue().isNullOrEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 保険者番号.toString())));
        }
        if (div.getHokenshaJoho().getTxtHokenshaName().getValue().isNullOrEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 保険者名.toString())));
        }
        return validPairs;
    }

    /**
     * 「追加」の場合入力された保険者番号チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPair validate保険者番号() {
        RString 保険者番号値 = div.getHokenshaJoho().getTxtHokenshaNo().getValue();
        if (保険者番号値.isNullOrEmpty() || !div.getDdlTodofuken().getSelectedKey().equals(保険者番号値.substring(0, 2))) {
            return new ValidationMessageControlPair(new IdocheckMessages(DbuErrorMessages.保険者番号都道府県エラー));
        }
        return null;
    }

    /**
     * 保険者一覧Gridの状態列が編集されのチェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate変更内容() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgHokenshas_Row> rowList = div.getDgHokenshas().getDataSource();
        boolean emptyFlag = true;
        for (dgHokenshas_Row row : rowList) {
            if (!row.getJotai().isNullOrEmpty()) {
                emptyFlag = false;
                break;
            }
        }
        if (emptyFlag) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.編集なしで更新不可)));
        }
        return validPairs;
    }

    /**
     * 保険者情報パネル上の項目に編集有りのチェックを実施します。
     *
     * @return boolean 編集がどうか
     */
    public boolean check保険者情報の編集() {
        HokenshaJohoDiv 保険者情報 = div.getHokenshaJoho();
        if (!保険者情報.getTxtHokenshaNo().getValue().isNullOrEmpty()) {
            return true;
        }
        if (!保険者情報.getTxtHokenshaName().getValue().isNullOrEmpty()) {
            return true;
        }
        if (!保険者情報.getTxtHokenshaTelNo().getDomain().value().isNullOrEmpty()) {
            return true;
        }
        if (!保険者情報.getTxtHokenshaYubinNo().getValue().value().isNullOrEmpty()) {
            return true;
        }
        return (!保険者情報.getTxtHokenshaJusho().getDomain().value().isNullOrEmpty());
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
