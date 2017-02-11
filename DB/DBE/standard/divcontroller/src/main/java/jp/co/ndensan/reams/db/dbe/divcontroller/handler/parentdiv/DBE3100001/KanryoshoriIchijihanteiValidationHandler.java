/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.KanryoshoriIchijihanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001.dgHanteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・一次判定のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
public class KanryoshoriIchijihanteiValidationHandler {

    private static final RString STATUS_KANRYO_MI = new RString("未");
    private final KanryoshoriIchijihanteiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KanryoshoriIchijihanteiDiv
     */
    public KanryoshoriIchijihanteiValidationHandler(KanryoshoriIchijihanteiDiv div) {
        this.div = div;
    }

    /**
     * 一次判定完了対象者一覧データの存在チェックを行います。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧データの存在チェック() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        List<dgHanteiTaishosha_Row> list = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getDataSource();
        if (list == null || list.isEmpty()) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧データの存在チェック));
        }
        return pairs;
    }

    /**
     * 一次判定完了対象者一覧データの行選択チェックを行います。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧データの行選択チェック() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        List<dgHanteiTaishosha_Row> list = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();
        if (list == null || list.isEmpty()) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧データの行選択チェック));
        }
        return pairs;
    }

    /**
     * 一次判定DLLに渡す引数が正しく作成されたかをチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate一次判定引数() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getIchijiHanteiArgument())) {
            pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定引数チェック));
        }
        return pairs;
    }

    /**
     * 一次判定完了対象者一覧選択行の完了処理チェックを行います。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 一次判定完了対象者一覧選択行の完了処理チェック() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        List<dgHanteiTaishosha_Row> list = div.getIchijiHanteiShoriTaishoshaIchiran().getDgHanteiTaishosha().getSelectedItems();
        for (dgHanteiTaishosha_Row row : list) {
            if (STATUS_KANRYO_MI.equals(row.getColumnState())) {
                pairs.add(new ValidationMessageControlPair(KanryoshoriIchijihanteiMessages.一次判定完了対象者一覧選択行の完了処理チェック));
                return pairs;
            }
        }
        return pairs;
    }

    private static enum KanryoshoriIchijihanteiMessages implements IValidationMessage {

        一次判定完了対象者一覧データの存在チェック(UrErrorMessages.該当データなし),
        一次判定完了対象者一覧データの行選択チェック(UrErrorMessages.対象行を選択),
        一次判定完了対象者一覧選択行の完了処理チェック(DbzErrorMessages.理由付き完了不可, "一次判定未処理データが含まれている"),
        一次判定引数チェック(DbeErrorMessages.一次判定実行不可_申請日);
        private final Message message;

        private KanryoshoriIchijihanteiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
