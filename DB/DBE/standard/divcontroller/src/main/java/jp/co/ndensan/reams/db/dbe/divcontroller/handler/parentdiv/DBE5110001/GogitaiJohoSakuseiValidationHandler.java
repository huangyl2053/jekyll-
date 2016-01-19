/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5110001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.GogitaiJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgGogitaiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001.dgShinsainList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijohosakusei.GogitaiJohoSakuseiFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 合議体情報作成の抽象ValidationHandlerクラスです。
 *
 */
public class GogitaiJohoSakuseiValidationHandler {

    private static final int SHINSAIN_COUNT_3 = 3;
    private final GogitaiJohoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 合議体情報作成Div
     */
    public GogitaiJohoSakuseiValidationHandler(GogitaiJohoSakuseiDiv div) {
        this.div = div;

    }

    /**
     *
     * 合議体Noの桁数をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs gogitaiNoKetaiCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtGogitaiNumber().getValue().length() != 2) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.桁数が不正));
        }

        return validationMessages;
    }

    /**
     *
     * 合議体Noの重複をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs gogitaiNoJuuhukuCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        GogitaiJohoSakuseiFinder service = GogitaiJohoSakuseiFinder.createInstance();
        if (0 < service.getGogitaiNoJuuhuku(Integer.parseInt(div.getTxtGogitaiNumber().getValue().toString()))) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.既に登録済));
            return validationMessages;
        }
        List<dgGogitaiIchiran_Row> rowList = div.getDgGogitaiIchiran().getDataSource();
        for (dgGogitaiIchiran_Row row : rowList) {
            if (row.getGogitaiNumber().equals(div.getTxtGogitaiNumber().getValue())) {
                validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.既に登録済));
                return validationMessages;
            }
        }

        return validationMessages;
    }

    /**
     *
     * 開催場所コードの存在性をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs kaisaiBashoCodeCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        // TODO QA210 Redmine#72702「開催場所コードの存在性チェック」は実装なしとしてください。
//        GogitaiJohoSakuseiFinder service = GogitaiJohoSakuseiFinder.createInstance();
//        if (!service.getKaisaiBashoCode(div.getDdlkaisaibasho().getSelectedKey())) {
//            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.コードマスタなし));
//            return validationMessages;
//        }

        return validationMessages;
    }

    /**
     *
     * 有効開始日と有効終了日の前後順をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs kaishiToShuryoYMDCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!div.getTxtYukoKaishiYMD().getValue().isBeforeOrEquals(div.getTxtYukoShuryoYMD().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.終了日が開始日以前));
            return validationMessages;
        }

        return validationMessages;
    }

    /**
     *
     * 開始予定時刻と終了予定時刻の前後順をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs kaishiYoteiToShuryoYoteiTimeCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtKaishiYoteiTime().getValue().isAfter(div.getTxtShuryoYoteiTime().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.期間が不正_追加メッセージあり２));
            return validationMessages;
        }

        return validationMessages;
    }

    /**
     *
     * 割当審査員一覧の必須をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs shinsainListRequiredCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgShinsainList().getDataSource().size() < SHINSAIN_COUNT_3) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.割当審査員は少なくとも5人));
            return validationMessages;
        }

        return validationMessages;
    }

    /**
     *
     * 「合議体長」と「副合議体長」すべて選択をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs gogitaichoToFukuGogitaichoCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgShinsainList_Row> rowList = div.getDgShinsainList().getDataSource();
        for (dgShinsainList_Row row : rowList) {
            if (row.getGogitaicho() && row.getFukuGogitaicho()) {
                validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.合議体長副合議体長は一人づつ));
                return validationMessages;
            }
        }
        return validationMessages;
    }

    /**
     *
     * 審査会委員人数をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs shinsainPersonNumCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RString personNum = BusinessConfig.get(ConfigNameDBE.合議体最大委員数, SubGyomuCode.DBE認定支援);
        List<dgShinsainList_Row> rowList = div.getDgShinsainList().getDataSource();
        if (Integer.parseInt(personNum.toString()) < rowList.size()) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.合議体委員数が最大値を超過));
            return validationMessages;
        }
        return validationMessages;
    }

    /**
     *
     * 合議体長人数をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs gogitaichoPersonNumCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgShinsainList_Row> rowList = div.getDgShinsainList().getDataSource();
        boolean flag = false;
        for (dgShinsainList_Row row : rowList) {
            if (row.getGogitaicho() && !flag) {
                flag = true;
                continue;
            }
            if (row.getGogitaicho() && flag) {
                validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.合議体委員数が最大値を超過));
                return validationMessages;
            }
        }

        return validationMessages;
    }

    /**
     *
     * 審査会委員定員をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs iinTeiinCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgShinsainList_Row> rowList = div.getDgShinsainList().getDataSource();
        if (div.getTxtIinTeiin().getValue().intValue() < rowList.size()) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.審査会開催最大数を超過));
            return validationMessages;
        }

        return validationMessages;
    }

    /**
     *
     * 合議体一覧データの存在をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs gogitaiIchiranCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgGogitaiIchiran_Row> rowList = div.getDgGogitaiIchiran().getDataSource();
        if (rowList.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(GogitaiJohoSakuseiMessages.対象データなし_追加メッセージあり));
            return validationMessages;
        }

        return validationMessages;
    }

    private static enum GogitaiJohoSakuseiMessages implements IValidationMessage {

        桁数が不正(UrErrorMessages.桁数が不正, "合議体No", "2"),
        既に登録済(UrErrorMessages.既に登録済, "合議体No"),
        コードマスタなし(UrErrorMessages.コードマスタなし),
        終了日が開始日以前(UrErrorMessages.終了日が開始日以前),
        期間が不正_追加メッセージあり２(UrErrorMessages.期間が不正_追加メッセージあり２, "開始予定時刻", "終了予定時刻"),
        割当審査員は少なくとも5人(DbeErrorMessages.割当審査員は少なくとも5人),
        合議体長副合議体長は一人づつ(DbeErrorMessages.合議体長副合議体長は一人づつ),
        合議体委員数が最大値を超過(DbeErrorMessages.合議体委員数が最大値を超過),
        審査会の合議体長は必ず１人(DbeErrorMessages.審査会の合議体長は必ず１人),
        // TODO QA399
        審査会開催最大数を超過(DbeErrorMessages.審査会開催最大数を超過),
        対象データなし_追加メッセージあり(UrErrorMessages.対象データなし_追加メッセージあり, "合議体一覧");

        private final Message message;

        private GogitaiJohoSakuseiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
