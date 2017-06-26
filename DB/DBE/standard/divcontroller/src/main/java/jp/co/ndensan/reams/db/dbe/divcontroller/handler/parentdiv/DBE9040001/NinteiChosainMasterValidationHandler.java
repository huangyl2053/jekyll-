/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9040001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.NinteiChosainMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001.dgChosainIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査員マスタ画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
public class NinteiChosainMasterValidationHandler {

    private final NinteiChosainMasterDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString CODE_MAN = new RString("1");
    private static final RString CODE_WOMAN = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public NinteiChosainMasterValidationHandler(NinteiChosainMasterDiv div) {
        this.div = div;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForOutputCsv() {
        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            throw new ApplicationException(InfoMesssages.該当データなし.getMessage());
        }
        for (dgChosainIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                throw new ApplicationException(InfoMesssages.編集後更新指示.getMessage());
            }
        }
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count 調査員情報件数
     */
    public void validateForKakutei(RString 状態, int count) {
        if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
            if (状態_修正.equals(状態) && !isUpdate()) {
                throw new ApplicationException(InfoMesssages.編集なしで更新不可.getMessage());
            }
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getCcdChiku().getCode().value())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getCcdChiku().getCodeMeisho())) {
                throw new ApplicationException(InfoMesssages.地区コードが存在しない.getMessage());
            }
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getTxtShichoson().getValue())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getTxtShichosonmei().getValue())) {
                throw new ApplicationException(InfoMesssages.市町村コードが存在しない.getMessage());
            }
            if (!RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChosaItakusaki().getValue())
                    && RString.isNullOrEmpty(div.getChosainJohoInput().getTxtChosaItakusakiMeisho().getValue())) {
                throw new ApplicationException(InfoMesssages.調査委託先コードが存在しない.getMessage());
            }
            if (0 < count) {
                throw new ApplicationException(InfoMesssages.調査員コードは既に登録済.getMessage());

            }
        }
    }

    /**
     * 確定するボタンを押下するとき、入力された調査員情報のチェックを行う。
     *
     * ※2017/6/19 時点では検査項目なし。
     *
     * @param 状態　状態
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateInputChosainInfo(RString 状態) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (状態_追加.equals(状態) || 状態_修正.equals(状態)) {
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     */
    public void validateForUpdate() {
        List<dgChosainIchiran_Row> ichiranList = div.getChosainIchiran().getDgChosainIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgChosainIchiran_Row row : ichiranList) {
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
     * @param ninteiShinseiJohoCount 要介護認定申請情報件数
     * @param ninteichosaIraiJohoCount 認定調査依頼情報件数
     */
    public void validateForUpdate(int ninteiShinseiJohoCount, int ninteichosaIraiJohoCount) {
        if (0 < ninteiShinseiJohoCount) {
            throw new ApplicationException(InfoMesssages.排他_他のユーザが更新済で更新処理を中止.getMessage());
        }
        if (0 < ninteichosaIraiJohoCount) {
            throw new ApplicationException(InfoMesssages.排他_他のユーザが更新済で更新処理を中止.getMessage());
        }
    }

    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        NinteiChosainMasterHandler handler = new NinteiChosainMasterHandler(div);
        if (!handler.getInputDiv().equals(div.getChosainJohoInput().getHiddenInputDiv())) {
            return true;
        }
        return false;
    }

    private enum InfoMesssages implements IMessageGettable {

        該当データなし(1, "該当データが存在しません。"),
        編集後更新指示(2, "編集されています。更新処理を行ってください。"),
        地区コードが存在しない(3, "地区コードに該当するデータが存在しません。"),
        市町村コードが存在しない(4, "市町村コードに該当するデータが存在しません。"),
        調査委託先コードが存在しない(5, "調査委託先コードに該当するデータが存在しません。"),
        編集なしで更新不可(6, "編集されていないため、更新できません。"),
        調査員コードは既に登録済(7, "調査員コードは既に登録されているため使用できません。"),
        排他_他のユーザが更新済で更新処理を中止(8, "他の端末で対象のデータが変更されているため、更新処理を中止します。");

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
