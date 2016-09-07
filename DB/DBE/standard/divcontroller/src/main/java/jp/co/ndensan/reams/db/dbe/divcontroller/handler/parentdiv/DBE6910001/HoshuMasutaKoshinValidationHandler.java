/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.HoshuMasutaKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgChosainhoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgHomonChosahoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgIkenShohoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgShinsakaiIinBetuTanka_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 報酬マスタメンテナンス画面のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshinValidationHandler {

    private final HoshuMasutaKoshinDiv div;
    private final RString 追加モード = new RString("追加");

    /**
     * コンストラクタです。
     *
     * @param div 報酬マスタメンテナンスDiv
     */
    public HoshuMasutaKoshinValidationHandler(HoshuMasutaKoshinDiv div) {
        this.div = div;
    }

    /**
     * 審査員報酬単価マスタの入力明細エリア入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check審査員報酬単価マスタ() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getTxtChoKaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getTxtChoShuryoYM();
        validationMessages.add(check開始年月が必須(開始年月));
        validationMessages.add(check終了年月が必須(終了年月));
        if (追加モード.equals(div.getChosainhoshuTankaState())
                && 開始年月 != null && 開始年月.getDomain() != null && !開始年月.getDomain().isEmpty()
                && 終了年月 != null && 終了年月.getDomain() != null && !終了年月.getDomain().isEmpty()) {
            validationMessages.add(check期間が不正(開始年月, 終了年月));
            List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
            for (dgChosainhoshuTankaIchiran_Row row : 審査員報酬単価一覧情報) {
                if (row.getKaigoNinteiShinsaIinShubetsuCode().equals(
                        div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(開始年月.getDomain()) == 0
                        && row.getShuryoYM().getValue().getYearMonth().compareTo(終了年月.getDomain()) == 0) {
                    validationMessages.add(checkデータが既に存在());
                }
                if (div.getHoshuMasutaTab().getDdlKaigoNinteiShinsaIinShubetsu().getSelectedKey().equals(
                        row.getKaigoNinteiShinsaIinShubetsuCode())
                        && is期間重複(開始年月.getDomain(), row.getShuryoYM().getValue().getYearMonth())) {
                    validationMessages.add(check期間が重複());
                }
            }
        }
        return validationMessages;
    }

    /**
     * 意見書報酬単価マスタの入力明細エリア入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check意見書報酬単価マスタ() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenKaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtIkenShuryoYM();
        validationMessages.add(check開始年月が必須(開始年月));
        validationMessages.add(check終了年月が必須(終了年月));
        validationMessages.add(check単価が必須(div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getTxtTanka()));
        if (追加モード.equals(div.getIkenShohoshuTankaState())
                && 開始年月 != null && 開始年月.getDomain() != null && !開始年月.getDomain().isEmpty()
                && 終了年月 != null && 終了年月.getDomain() != null && !終了年月.getDomain().isEmpty()) {
            validationMessages.add(check期間が不正(開始年月, 終了年月));
            List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
            for (dgIkenShohoshuTankaIchiran_Row row : 意見書報酬単価一覧情報) {
                if (row.getZaitakuShisetsuKubunCode().equals(
                        div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedKey())
                        && row.getIkenshoSakuseiKaisuKubunCode().equals(div.getHoshuMasutaTab().
                                getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(開始年月.getDomain()) == 0) {
                    validationMessages.add(checkデータが既に存在());
                }
                if (div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlZaitakuShisetsuKubun().getSelectedKey().equals(
                        row.getZaitakuShisetsuKubunCode())
                        && div.getHoshuMasutaTab().getIkenShohoshuTankaNyuryoku().getDdlIkenshoSakuseiKaisuKubun().getSelectedKey().equals(
                                row.getIkenshoSakuseiKaisuKubunCode())
                        && is期間重複(開始年月.getDomain(), row.getShuryoYM().getValue().getYearMonth())) {
                    validationMessages.add(check期間が重複());
                }
            }
        }
        return validationMessages;
    }

    /**
     * 訪問調査報酬単価マスタの入力明細エリア入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check訪問調査報酬単価マスタ() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomkaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomshuryoYM();
        validationMessages.add(check開始年月が必須(開始年月));
        validationMessages.add(check終了年月が必須(終了年月));
        validationMessages.add(check単価が必須(div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getTxtHomtanka()));
        if (追加モード.equals(div.getHomonChosahoshuTankaState())
                && 開始年月 != null && 開始年月.getDomain() != null && !開始年月.getDomain().isEmpty()
                && 終了年月 != null && 終了年月.getDomain() != null && !終了年月.getDomain().isEmpty()) {
            validationMessages.add(check期間が不正(開始年月, 終了年月));
            List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報
                    = div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getDataSource();
            for (dgHomonChosahoshuTankaIchiran_Row row : 訪問調査報酬単価一覧情報) {
                if (row.getChosaKubunCode().equals(
                        div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey())
                        && row.getHomonShubetsuCode().equals(div.getHoshuMasutaTab().
                                getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(開始年月.getDomain()) == 0
                        && row.getShuryoYM().getValue().getYearMonth().compareTo(終了年月.getDomain()) == 0) {
                    validationMessages.add(checkデータが既に存在());
                }
                if (div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlChosaKubun().getSelectedKey().equals(
                        row.getChosaKubunCode())
                        && div.getHoshuMasutaTab().getHomonChosahoshuTankaNyuryoku().getDdlHomonShubetsu().getSelectedKey().equals(
                                row.getHomonShubetsuCode())
                        && is期間重複(開始年月.getDomain(), row.getShuryoYM().getValue().getYearMonth())) {
                    validationMessages.add(check期間が重複());
                }
            }
        }
        return validationMessages;
    }

    /**
     * 審査会委員別単価マスタの入力明細エリア入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check審査会委員別単価マスタ() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        TextBoxFlexibleYearMonth 開始年月 = div.getHoshuMasutaTab().getTxtBetuKaishiYM();
        TextBoxFlexibleYearMonth 終了年月 = div.getHoshuMasutaTab().getTxtBetuShuryoYM();
        validationMessages.add(check開始年月が必須(開始年月));
        validationMessages.add(check終了年月が必須(終了年月));
        validationMessages.add(check審査委員コードが必須(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue()));
        if (追加モード.equals(div.getShinsakaiIinBetuTankaState())
                && 開始年月 != null && 開始年月.getDomain() != null && !開始年月.getDomain().isEmpty()
                && 終了年月 != null && 終了年月.getDomain() != null && !終了年月.getDomain().isEmpty()) {
            validationMessages.add(check期間が不正(開始年月, 終了年月));
            List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価一覧情報
                    = div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getDataSource();
            for (dgShinsakaiIinBetuTanka_Row row : 審査会委員別単価一覧情報) {
                if (row.getShinsakaiIinCode().equals(
                        div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue())
                        && row.getKaishiYM().getValue().getYearMonth().compareTo(開始年月.getDomain()) == 0
                        && row.getShuryoYM().getValue().getYearMonth().compareTo(終了年月.getDomain()) == 0) {
                    validationMessages.add(checkデータが既に存在());
                }
                if (div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue().equals(row.getShinsakaiIinCode())
                        && is期間重複(開始年月.getDomain(), row.getShuryoYM().getValue().getYearMonth())) {
                    validationMessages.add(check期間が重複());
                }
            }
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check開始年月が必須(TextBoxFlexibleYearMonth 開始年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (開始年月 == null || 開始年月.getDomain() == null || 開始年月.getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.開始年月が必須));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check終了年月が必須(TextBoxFlexibleYearMonth 終了年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (終了年月 == null || 終了年月.getDomain() == null || 終了年月.getDomain().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.終了年月が必須));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check単価が必須(TextBoxNum 単価) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (単価 == null || 単価.getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.単価が必須));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs check期間が不正(TextBoxFlexibleYearMonth 開始年月, TextBoxFlexibleYearMonth 終了年月) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (終了年月.getDomain().isBefore(開始年月.getDomain())) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.期間が不正));
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs checkデータが既に存在() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.既に存在));
        return validationMessages;
    }

    private ValidationMessageControlPairs check審査委員コードが必須(RString 審査委員コード) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(審査委員コード)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.審査委員コードが必須));
        }
        return validationMessages;
    }

    /**
     * 期間チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check期間が重複() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
        return validationMessages;
    }

    private boolean is期間重複(FlexibleYearMonth 新規作成開始年月, FlexibleYearMonth 既に存在終了年月) {
        return 新規作成開始年月.isBeforeOrEquals(既に存在終了年月);
    }

    private static enum RRVMessages implements IValidationMessage {

        開始年月が必須(UrErrorMessages.必須, "開始年月"),
        終了年月が必須(UrErrorMessages.必須, "終了年月"),
        単価が必須(UrErrorMessages.必須, "単価"),
        期間が不正(UrErrorMessages.期間が不正_追加メッセージあり２, "開始年月", "終了年月"),
        既に存在(UrErrorMessages.既に存在, "データ"),
        審査委員コードが必須(UrErrorMessages.必須, "審査委員コード"),
        期間が重複(UrErrorMessages.期間が重複);

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
