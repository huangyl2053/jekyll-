/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共同処理用受給者異動連絡票共有子Divのバリデーション
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoDivValidationHandler {

    private final KyodoJukyushaIdoRenrakuhyoDiv div;
    private static final RString MSG_一時差止開始日 = new RString("一時差止開始日");
    private static final RString MSG_既存の異動日 = new RString("既存の異動日");
    private static final RString MSG_履歴番号 = new RString("履歴番号");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final int NUM_ZERO = 0;
    private static final RString チェックボックス_KEY = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div KyodoJukyushaIdoRenrakuhyoDiv
     */
    public KyodoJukyushaIdoRenrakuhyoDivValidationHandler(KyodoJukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KyodoJukyushaIdoRenrakuhyoDivValidationHandler
     */
    public static KyodoJukyushaIdoRenrakuhyoDivValidationHandler of(KyodoJukyushaIdoRenrakuhyoDiv div) {
        return new KyodoJukyushaIdoRenrakuhyoDivValidationHandler(div);
    }

    /**
     * 一時差止開始日＞一時差止終了日、エラーとする
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getFromValue() == null
                && div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getToValue() != null) {
            validPairs.add(new ValidationMessageControlPair(ValidationMessages.一時差止日のチェック));
        }
        return validPairs;
    }

    /**
     * 「一時差止開始日」が未入力で「一時差止終了日」が入力済み、エラーとする
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の関連チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RDate 一時差止開始日 = div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getFromValue();
        RDate 一時差止終了日 = div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getToValue();
        if (一時差止開始日 != null && 一時差止終了日 != null && 一時差止終了日.isBefore(一時差止開始日)) {
            validPairs.add(new ValidationMessageControlPair(ValidationMessages.一時差止日の関連チェック));
        }
        return validPairs;
    }

    /**
     * 基本送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 基本送付情報の異動日チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 基本送付情報チェックボックス = div.getChkKihonSofuAdd().getSelectedKeys();
        if (!基本送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().基本送付情報の異動日チェック(被保険者番号, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動日チェック));
            }
        }
        return validPairs;
    }

    /**
     * 償還送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 償還送付情報の異動日チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 償還送付情報チェックボックス = div.getChkShokanSofuAdd().getSelectedKeys();
        if (!償還送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().償還送付情報の異動日チェック(被保険者番号, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動日チェック));
            }
        }
        return validPairs;
    }

    /**
     * 高額送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額送付情報の異動日チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 高額送付情報チェックボックス = div.getChkKogakuSofuAdd().getSelectedKeys();
        if (!高額送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().高額送付情報の異動日チェック(被保険者番号, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動日チェック));
            }
        }
        return validPairs;
    }

    /**
     * 基本送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 基本送付情報の異動区分チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 基本送付情報チェックボックス = div.getChkKihonSofuAdd().getSelectedKeys();
        if (!基本送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            RString 異動区分コード = JukyushaIF_IdoKubunCode.新規.getコード();
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().基本送付情報の異動区分チェック(被保険者番号, 異動区分コード, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動区分チェック));
            }
        }
        return validPairs;
    }

    /**
     * 償還送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 償還送付情報の異動区分チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 償還送付情報チェックボックス = div.getChkShokanSofuAdd().getSelectedKeys();
        if (!償還送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            RString 異動区分コード = JukyushaIF_IdoKubunCode.新規.getコード();
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().償還送付情報の異動区分チェック(被保険者番号, 異動区分コード, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動区分チェック));
            }
        }
        return validPairs;
    }

    /**
     * 高額送付情報を追加するチェックボックスがチェックONの場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額送付情報の異動区分チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 高額送付情報チェックボックス = div.getChkKogakuSofuAdd().getSelectedKeys();
        if (!高額送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付情報チェックボックス.get(NUM_ZERO))) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            RString 異動区分コード = JukyushaIF_IdoKubunCode.新規.getコード();
            int count = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().高額送付情報の異動区分チェック(被保険者番号, 異動区分コード, 異動日);
            if (count > 0) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.異動区分チェック));
            }
        }
        return validPairs;
    }

    /**
     * 基本送付情報を追加するチェックボックスがチェックONの場合で、画面．基本送付情報エリア．異動日と同一日のデータが共同処理用受給者異動基本送付テーブルにないこと
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 基本送付情報の履歴番号チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 基本送付情報修正チェックボックス = div.getChkKihonSofuAdd().getSelectedKeys();
        boolean 基本送付情報修正チェック = (!基本送付情報修正チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付情報修正チェックボックス.get(NUM_ZERO)));
        List<RString> 基本送付情報削除チェックボックス = div.getChkKihonSofuDelete().getSelectedKeys();
        boolean 基本送付情報削除チェック = (!基本送付情報削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付情報削除チェックボックス.get(NUM_ZERO)));
        if ((KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 修正.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 基本送付情報修正チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 削除.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 基本送付情報削除チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.sakujyo.equals(div.getMode_DisplayMode())
                && 基本送付情報修正チェック)) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int rirekiNoMax = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().基本送付情報の履歴番号チェック(被保険者番号, 異動日);
            int 画面履歴番号 = div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtRirekiNo().getValue().intValue();
            if (rirekiNoMax != 画面履歴番号) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.履歴番号チェック));
            }
        }
        return validPairs;
    }

    /**
     * 償還送付情報を追加するチェックボックスがチェックONの場合で、画面．基本送付情報エリア．異動日と同一日のデータが共同処理用受給者異動基本送付テーブルにないこと
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 償還送付情報の履歴番号チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 償還送付情報修正チェックボックス = div.getChkShokanSofuAdd().getSelectedKeys();
        boolean 償還送付情報修正チェック = (!償還送付情報修正チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付情報修正チェックボックス.get(NUM_ZERO)));
        List<RString> 償還送付情報削除チェックボックス = div.getChkShokanSofuDelete().getSelectedKeys();
        boolean 償還送付情報削除チェック = (!償還送付情報削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付情報削除チェックボックス.get(NUM_ZERO)));
        if ((KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 修正.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 償還送付情報修正チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 削除.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 償還送付情報削除チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.sakujyo.equals(div.getMode_DisplayMode())
                && 償還送付情報修正チェック)) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int rirekiNoMax = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().償還送付情報の履歴番号チェック(被保険者番号, 異動日);
            int 画面履歴番号 = div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanRirekiNo().getValue().intValue();
            if (rirekiNoMax != 画面履歴番号) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.履歴番号チェック));
            }
        }
        return validPairs;
    }

    /**
     * 高額送付情報を追加するチェックボックスがチェックONの場合で、画面．基本送付情報エリア．異動日と同一日のデータが共同処理用受給者異動基本送付テーブルにないこと
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額送付情報の履歴番号チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 高額送付情報修正チェックボックス = div.getChkKogakuSofuAdd().getSelectedKeys();
        boolean 高額送付情報修正チェック = (!高額送付情報修正チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付情報修正チェックボックス.get(NUM_ZERO)));
        List<RString> 高額送付情報削除チェックボックス = div.getChkShokanSofuDelete().getSelectedKeys();
        boolean 高額送付情報削除チェック = (!高額送付情報削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付情報削除チェックボックス.get(NUM_ZERO)));
        if ((KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 修正.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 高額送付情報修正チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 削除.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())
                && 高額送付情報削除チェック)
                || (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.sakujyo.equals(div.getMode_DisplayMode())
                && 高額送付情報修正チェック)) {
            FlexibleDate 異動日 = new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().getValue().toDateString().toString());
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiHokenshaNo().getValue().toString());
            int rirekiNoMax = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().高額送付情報の履歴番号チェック(被保険者番号, 異動日);
            int 画面履歴番号 = div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuRirekiNo().getValue().intValue();
            if (rirekiNoMax != 画面履歴番号) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.履歴番号チェック));
            }
        }
        return validPairs;
    }

    /**
     * 修正有無チェック
     *
     * @param 初期化異動情報Entity
     * @param 画面項目異動情報Entity
     * @param 基本送付情報Flag
     * @param 償還送付情報変Flag
     * @param 高額送付情報Flag
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 修正有無チェック(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化異動情報Entity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 画面項目異動情報Entity, boolean 基本送付情報Flag,
            boolean 償還送付情報変Flag, boolean 高額送付情報Flag) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei.equals(div.getMode_DisplayMode())
                && 修正.equals(div.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode().getSelectedValue())) {
            KyodoJukyushaIdoRenrakuhyoHandler hander = new KyodoJukyushaIdoRenrakuhyoHandler();
            if (!((hander.is高額送付情報変更あり(初期化異動情報Entity, 画面項目異動情報Entity, 高額送付情報Flag))
                    || (hander.is基本送付情報変更あり(初期化異動情報Entity, 画面項目異動情報Entity, 基本送付情報Flag))
                    || (hander.is償還送付情報変更あり(初期化異動情報Entity, 画面項目異動情報Entity, 償還送付情報変Flag)))) {
                validPairs.add(new ValidationMessageControlPair(ValidationMessages.修正有無チェック));
            }
        }
        return validPairs;
    }

    private static enum ValidationMessages implements IValidationMessage {

        一時差止日の関連チェック(UrErrorMessages.終了日が開始日以前),
        一時差止日のチェック(UrErrorMessages.未入力, MSG_一時差止開始日.toString()),
        異動日チェック(DbzErrorMessages.理由付き登録不可, MSG_既存の異動日.toString()),
        異動区分チェック(DbcWarningMessages.異動連絡票_新規登録確認),
        履歴番号チェック(UrErrorMessages.不正, MSG_履歴番号.toString()),
        修正有無チェック(UrErrorMessages.編集なしで更新不可);

        private final Message message;

        ValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
