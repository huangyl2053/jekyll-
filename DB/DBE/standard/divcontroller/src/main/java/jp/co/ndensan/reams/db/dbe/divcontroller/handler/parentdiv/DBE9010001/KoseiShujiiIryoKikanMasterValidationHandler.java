/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.ShujiiIryoKikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001.dgShujiiIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;

/**
 * 主治医医療機関マスタ画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
public class KoseiShujiiIryoKikanMasterValidationHandler {

    private final ShujiiIryoKikanMasterDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div 主治医医療機関情報Div
     */
    public KoseiShujiiIryoKikanMasterValidationHandler(ShujiiIryoKikanMasterDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForOutputCsv() {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            throw new ApplicationException(InfoMesssages.該当データなし.getMessage());
        }
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                throw new ApplicationException(InfoMesssages.編集後更新指示.getMessage());
            }
        }
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count 主治医医療機関情報件数
     */
    public void validateForKakutei(RString 状態, int count) {
        if ((状態_追加.equals(状態) || 状態_修正.equals(状態))
                && (状態_修正.equals(状態) && !isUpdate())) {
            throw new ApplicationException(InfoMesssages.編集なしで更新不可.getMessage());
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichoson().getValue())
                    && RString.isNullOrEmpty(div.getShujiiJohoInput().getTxtShichosonmei().getValue())) {
                throw new ApplicationException(InfoMesssages.市町村コードが存在しない.getMessage());
            }
            if (0 < count) {
                throw new ApplicationException(InfoMesssages.主治医医療機関コードは既に登録済.getMessage());
            }
        }
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(RString 状態) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
            if (!is口座情報あり_必須項目入力あり(div)) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "口座情報"), div.getShujiiJohoInput().getKozaJoho()));
            }
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForUpdate() {
        List<dgShujiiIchiran_Row> ichiranList = div.getShujiiIchiran().getDgShujiiIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgShujiiIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            throw new ApplicationException(InfoMesssages.編集なしで更新不可.getMessage());
        }
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param shujiiJohoCount 主治医情報件数
     */
    public void validateForDelete(int shujiiJohoCount) {
        if (0 < shujiiJohoCount) {
            throw new ApplicationException(InfoMesssages.他の情報で使用している為削除不可.getMessage());
        }
    }

    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        KoseiShujiiIryoKikanMasterHandler handler = new KoseiShujiiIryoKikanMasterHandler(div);
        if (!handler.getInputDiv().equals(div.getShujiiJohoInput().getHiddenInputDiv())) {
            return true;
        }
        return false;
    }

    private boolean is口座情報あり_必須項目入力あり(ShujiiIryoKikanMasterDiv div) {
        if (div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() == null) {
            return true;
        }
        if (div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
            if (!div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtTenBan().getValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue().isEmpty()) {
                return !div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtTenBan().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtTenMei().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue().isEmpty();
            }
        } else {
            if (!div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty()
                    || !div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue().isEmpty()) {
                return !div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty()
                        && !div.getShujiiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue().isEmpty();
            }
        }
        return true;

    }

    private enum InfoMesssages implements IMessageGettable {

        該当データなし(1, "該当データが存在しません。"),
        編集後更新指示(2, "編集されています。更新処理を行ってください。"),
        地区コードが存在しない(3, "地区コードに該当するデータが存在しません。"),
        市町村コードが存在しない(4, "市町村コードに該当するデータが存在しません。"),
        主治医医療機関コードが存在しない(5, "主治医医療機関コードに該当するデータが存在しません。"),
        編集なしで更新不可(6, "編集されていないため、更新できません。"),
        主治医医療機関コードは既に登録済(7, "主治医医療機関コードは既に登録されているため使用できません。"),
        他の情報で使用している為削除不可(8, "他の情報で使用している為削除できません。");

        private final int no;
        private final RString message;

        private InfoMesssages(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new InformationMessage(toCode("I", no), message.toString());
        }
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
