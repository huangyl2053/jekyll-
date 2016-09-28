/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode.SyoriJyoutaiCode;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDivSpec;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgShoriSettei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 非課税年金対象者情報取込画面のHandlerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJohoValidationHandler {

    private final HikazeiNenkinTaishoshaJohoDiv div;

    private static final int INT_3 = 3;
    private static final int INT_9 = 9;
    private static final int INT_13 = 13;
    private static final int INT_15 = 15;
    private static final int INT_17 = 17;

    private final RString 処理_年次 = new RString("年次");
    private final RString 処理_月次 = new RString("月次");

    /**
     * コンストラクタです。
     *
     * @param div HikazeiNenkinTaishoshaJohoDiv
     */
    public HikazeiNenkinTaishoshaJohoValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        this.div = div;
    }

    /**
     * 編集なしチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor編集なし(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.変更無し);
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.編集なしチェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getDgShoriSettei()).build().check(messages));
        return pairs;
    }

    /**
     * 再処理確認チェックチェックを行います。
     *
     * @return バリデーション結果
     */
    public boolean validateFor再処理確認() {

        List<dgShoriSettei_Row> rowList = div.getDgShoriSettei().getDataSource();
        for (dgShoriSettei_Row row : rowList) {
            if (!row.getHdnSyokiShoriJotai().equals(row.getTxtShoriJotai().getSelectedKey())
                    && !SyoriJyoutaiCode.再処理前.getコード().equals(row.getHdnSyokiShoriJotai())
                    && SyoriJyoutaiCode.再処理前.getコード().equals(row.getTxtShoriJotai().getSelectedKey())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 処理状態チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor処理状態単一(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        RString syoriJyotai = div.getDgTanitsuTaishoShoriItchiran().getActiveRow().getTxtShori().isEmpty()
                ? new RString("空白") : div.getDgTanitsuTaishoShoriItchiran().getActiveRow().getTxtShori();

        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.処理状態不正, syoriJyotai.toString());
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.処理状態単一チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getDgTanitsuTaishoShoriItchiran()).build().check(messages));

        return pairs;
    }

    /**
     * 処理状態チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor処理状態広域(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        RString syoriJyotai = div.getTxtShoriJotai().getValue();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.処理状態不正, syoriJyotai.toString());
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.処理状態広域チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getDgTanitsuTaishoShoriItchiran()).build().check(messages));

        return pairs;
    }

    /**
     * アップロード済みファイル名チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForアップロード済みファイル名(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.アップロードファイル無し);
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.アップロード済みファイル名チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage).build().check(messages));

        return pairs;
    }

    /**
     * アップロードファイル未指定チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForアップロードファイル未指定(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.ファイル指定なし);
        messages.add(ValidateChain.validateStart(div).
                ifNot(HikazeiNenkinTaishoshaJohoDivSpec.アップロードファイル未指定チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getFuairuAppurodo().getUplTaishoFuairu()).build().check(messages));
        return pairs;
    }

    /**
     * ファイルチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor年次ファイル通知内容(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.年次ファイル相違);
        messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.年次ファイル通知内容チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getFuairuAppurodo().getUplTaishoFuairu()).build().check(messages));
        return pairs;
    }

    /**
     * ファイルチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor月次ファイル通知内容(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.月次ファイル相違);
        messages.add(ValidateChain.validateStart(div).
                ifNot(HikazeiNenkinTaishoshaJohoDivSpec.月次ファイル通知内容チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getFuairuAppurodo().getUplTaishoFuairu()).build().check(messages));
        return pairs;
    }

    /**
     * ファイルチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor取込チェックボックス(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbdErrorMessages.アップロードファイル無し_広域);
        messages.add(ValidateChain.validateStart(div).
                ifNot(HikazeiNenkinTaishoshaJohoDivSpec.アップロードファイル無し_広域チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getDgKoikiTaishoShoriItiran()).build().check(messages));
        return pairs;
    }

    /**
     * ファイルチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param 取込対象市町村コードリスト List<RString>
     * @return バリデーション結果
     */
    public boolean validateFor取込市町村コードリスト(
            ValidationMessageControlPairs pairs,
            List<RString> 取込対象市町村コードリスト) {

        return 取込対象市町村コードリスト.isEmpty();

    }

    /**
     * ボタンクリック時のバリデーションチェックです
     *
     * @return 作成年月日Message
     */
    public Message validate作成年月日() {

        RString 処理 = div.getDgTanitsuTaishoShoriItchiran().getSelectedItems().get(0).getTxtShori();
        RString 作成年月日 = new FlexibleDate(div.getHdnLine().substring(INT_9, INT_17)).wareki().toDateString();
        RString 作成年月 = div.getHdnLine().substring(INT_9, INT_15);
        RString 処理年度 = div.getDdlShoriNendo().getSelectedKey();

        if (処理.equals(処理_年次)) {
            RString 作成年 = div.getHdnLine().substring(INT_9, INT_13);
            if (!作成年.equals(処理年度)) {
                return DbdWarningMessages.非課税年金年次取込確認.getMessage(ButtonSelectPattern.OKCancel).replace(
                        作成年月日.toString(),
                        new FlexibleYear(作成年).wareki().toDateString().toString());
            }

        } else if (処理.equals(処理_月次)) {
            RString 年度終了月 = DbBusinessConfig.get(ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月,
                    RDate.getNowDate(), SubGyomuCode.DBD介護受給);
            RString 選択月 = div.getDgTanitsuTaishoShoriItchiran().getSelectedItems().get(0).getHdnTukiCode().substring(1, INT_3);
            RString 処理年月;
            if (年度終了月.compareTo(選択月) < 0) {
                処理年月 = 処理年度.concat(選択月);
            } else {
                処理年月 = new FlexibleYear(処理年度).plusYear(1).toDateString().concat(選択月);
            }
            RString 通常作成年月 = new FlexibleYearMonth(処理年月).minusMonth(1).toDateString();

            if (!通常作成年月.equals(作成年月)) {
                return DbdWarningMessages.非課税年金月次取込確認.getMessage(ButtonSelectPattern.OKCancel).replace(
                        作成年月日.toString(),
                        new FlexibleYearMonth(処理年月).wareki().toDateString().toString(),
                        new FlexibleYearMonth(通常作成年月).wareki().toDateString().toString());

            }
        }
        return null;

    }

    private static final class NoInputMessages implements IValidationMessage {

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
