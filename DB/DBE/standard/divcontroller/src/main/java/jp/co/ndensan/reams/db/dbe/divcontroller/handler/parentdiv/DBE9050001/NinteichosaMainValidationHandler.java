/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9050001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.NinteichosaItakusakiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.dgSonotaKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * その他機関マスタ画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaMainValidationHandler {

    private final NinteichosaItakusakiMainDiv div;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");

    /**
     * コンストラクタです。
     *
     * @param div その他機関マスタDiv
     */
    public NinteichosaMainValidationHandler(NinteichosaItakusakiMainDiv div) {
        this.div = div;
    }

    /**
     * 検索するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param その他機関コードFrom その他機関コードFrom
     * @param その他機関コードTo その他機関コードTo
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForSearchShujii(RString その他機関コードFrom, RString その他機関コードTo) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString sonotaKikanCode = div.getChosainSearch().getTxtSearchSonotaKikanCodeFrom().getValue();
        if (その他機関コードTo.compareTo(その他機関コードFrom) < 0) {
            validPairs.add(new ValidationMessageControlPair(new NinteichosaMainValidationHandler.IdocheckMessages(
                    UrErrorMessages.大小関係が不正, String.valueOf(sonotaKikanCode)),
                    div.getChosainSearch().getTxtSearchSonotaKikanCodeFrom()));
        }
        return validPairs;
    }

    /**
     * ＣＳＶを出力するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForOutputCsv() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgSonotaKikanIchiran_Row> ichiranList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
        if (ichiranList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象データなし)));
        }
        for (dgSonotaKikanIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(DbzErrorMessages.編集後更新指示)));
                break;
            }
        }
        return validPairs;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 状態 状態
     * @param count その他機関情報件数
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForKakutei(RString 状態, int count) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if ((状態_追加.equals(状態) || 状態_修正.equals(状態)) && (状態_修正.equals(状態) && !isUpdate())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.編集なしで更新不可)));
        }
        if (状態_追加.equals(状態)) {
            if (!RString.isNullOrEmpty(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo())
                    && RString.isNullOrEmpty(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaName())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "証記載保険者番号"),
                        div.getChosaitakusakiJohoInput()));
            }
            RString sonotaKikanCode = div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue();
            if (0 < count) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, String.valueOf(sonotaKikanCode)),
                        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode()));
            }
        }
        return validPairs;
    }

    /**
     * その他機関一覧に既に存在するレコードが二回目で登録する場合とき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForInsert() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new NinteichosaMainValidationHandler.IdocheckMessages(
                UrErrorMessages.既に存在, "保険者とその他機関コード")));
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param chosaChikuGroupCount 調査地区グループ調査地区情報
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForDelete(int chosaChikuGroupCount) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (0 < chosaChikuGroupCount) {
            validPairs.add(new ValidationMessageControlPair(new NinteichosaMainValidationHandler.IdocheckMessages(
                    UrErrorMessages.削除不可, "その他機関コードが他のDBにて使用されている")));
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return validPairs バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgSonotaKikanIchiran_Row> ichiranList = div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource();
        boolean notUpdate = true;
        for (dgSonotaKikanIchiran_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                notUpdate = false;
                break;
            }
        }
        if (notUpdate) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.編集なしで更新不可),
                    div.getSonotaKikanichiran().getDgSonotaKikanIchiran()));
        }
        return validPairs;
    }

    /**
     * その他機関情報登録エリアの編集チェック処理です。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        NinteichosaItakusakiMainHandler handler = new NinteichosaItakusakiMainHandler(div);
        return !handler.getInputDiv().equals(div.getChosaitakusakiJohoInput().getHiddenInputDiv());
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
