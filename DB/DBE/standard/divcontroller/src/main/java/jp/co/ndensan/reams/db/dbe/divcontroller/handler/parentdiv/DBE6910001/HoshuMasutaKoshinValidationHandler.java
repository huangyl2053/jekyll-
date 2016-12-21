/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.HoshuMasutaKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgChosainhoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgHomonChosahoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgIkenShohoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgShinsakaiIinBetuTanka_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
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
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        List<dgIkenShohoshuTankaIchiran_Row> ikenShohoshuTankaIchiranList = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgIkenShohoshuTankaIchiran().getDataSource();
        List<dgChosainhoshuTankaIchiran_Row> chosainhoshuTankaIchiranList = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgChosainhoshuTankaIchiran().getDataSource();
        List<dgHomonChosahoshuTankaIchiran_Row> homonChosahoshuTankaIchiranList = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgHomonChosahoshuTankaIchiran().getDataSource();
        List<dgShinsakaiIinBetuTanka_Row> shinsakaiIinBetuTankaList = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getDgShinsakaiIinBetuTanka().getDataSource();
        boolean ikenShohoshuTankaIchirannotUpdate = true;
        boolean chosainhoshuTankaIchirannotUpdate = true;
        boolean homonChosahoshuTankaIchirannotUpdate = true;
        boolean shinsakaiIinBetuTankanotUpdate = true;

        for (dgIkenShohoshuTankaIchiran_Row row : ikenShohoshuTankaIchiranList) {
            if (!RString.EMPTY.equals(row.getColumnState())) {
                ikenShohoshuTankaIchirannotUpdate = false;
                break;
            }
        }
        for (dgChosainhoshuTankaIchiran_Row row : chosainhoshuTankaIchiranList) {
            if (!RString.EMPTY.equals(row.getColumnState())) {
                chosainhoshuTankaIchirannotUpdate = false;
                break;
            }
        }
        for (dgHomonChosahoshuTankaIchiran_Row row : homonChosahoshuTankaIchiranList) {
            if (!RString.EMPTY.equals(row.getColumnState())) {
                homonChosahoshuTankaIchirannotUpdate = false;
                break;
            }
        }
        for (dgShinsakaiIinBetuTanka_Row row : shinsakaiIinBetuTankaList) {
            if (!RString.EMPTY.equals(row.getColumnState())) {
                shinsakaiIinBetuTankanotUpdate = false;
                break;
            }
        }
        if (ikenShohoshuTankaIchirannotUpdate && chosainhoshuTankaIchirannotUpdate && homonChosahoshuTankaIchirannotUpdate && shinsakaiIinBetuTankanotUpdate) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.編集なしで更新不可),
                    div.getHoshuMasutaTab()));
        }
        return validPairs;
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
                        && is期間重複(開始年月.getDomain(), 終了年月.getDomain(),
                                row.getKaishiYM().getValue().getYearMonth(), row.getShuryoYM().getValue().getYearMonth())) {
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
                        && is期間重複(開始年月.getDomain(), 終了年月.getDomain(),
                                row.getKaishiYM().getValue().getYearMonth(), row.getShuryoYM().getValue().getYearMonth())) {
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
                        && is期間重複(開始年月.getDomain(), 終了年月.getDomain(),
                                row.getKaishiYM().getValue().getYearMonth(), row.getShuryoYM().getValue().getYearMonth())) {
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

        if (追加モード.equals(div.getShinsakaiIinBetuTankaState())) {
            validationMessages.add(check開始年月が必須(開始年月));
            validationMessages.add(check審査委員コードが必須(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue()));
            validationMessages.add(check審査委員コードが登録済み(div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue()));
            validationMessages.add(check期間が不正(開始年月, 終了年月));
            List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価一覧情報
                    = div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getDataSource();
            for (dgShinsakaiIinBetuTanka_Row row : 審査会委員別単価一覧情報) {
                FlexibleYearMonth row開始年月 = row.getKaishiYM().getValue().isEmpty() ? FlexibleYearMonth.MIN : row.getKaishiYM().getValue().getYearMonth();
                FlexibleYearMonth row終了年月 = row.getShuryoYM().getValue().isEmpty() ? FlexibleYearMonth.MAX : row.getShuryoYM().getValue().getYearMonth();
                FlexibleYearMonth textbox開始年月 = 開始年月.getDomain().isEmpty() ? FlexibleYearMonth.MIN : 開始年月.getDomain();
                FlexibleYearMonth textbox終了年月 = 終了年月.getDomain().isEmpty() ? FlexibleYearMonth.MAX : 終了年月.getDomain();
                if (row.getShinsakaiIinCode().equals(
                        div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue())
                        && row開始年月.compareTo(textbox開始年月) == 0
                        && row終了年月.compareTo(textbox終了年月) == 0) {
                    validationMessages.add(checkデータが既に存在());
                }
                if (div.getHoshuMasutaTab().getTxtShinsaIinKodo().getValue().equals(row.getShinsakaiIinCode())
                        && is期間重複(textbox開始年月, textbox終了年月, row開始年月, row終了年月)) {
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
        if (終了年月.getDomain().isEmpty()) {
            return validationMessages;
        }
        if (終了年月.getDomain().isBefore(開始年月.getDomain())) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.期間が不正, 開始年月, 終了年月));
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

    private ValidationMessageControlPairs check審査委員コードが登録済み(RString 審査委員コード) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (審査委員コード.isNull()
                || 審査委員コード.isEmpty()) {
            return validationMessages;
        }
        ShinsakaiIinJohoMapperParameter param = ShinsakaiIinJohoMapperParameter.createParamByShinsakaiIinCode(審査委員コード);
        ShinsakaiIinJoho 審査会委員情報 = ShinsakaiIinJohoManager.createInstance().get介護認定審査会委員情報(param);
        if (null == 審査会委員情報) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.審査委員コードエラー,
                    div.getHoshuMasutaTab().getTxtShinsaIinKodo()));
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

    private boolean is期間重複(FlexibleYearMonth 新規作成開始年月, FlexibleYearMonth 新規作成終了年月, FlexibleYearMonth 既に存在開始年月, FlexibleYearMonth 既に存在終了年月) {

        return 新規作成開始年月.isBeforeOrEquals(既に存在終了年月) && 既に存在開始年月.isBeforeOrEquals(新規作成開始年月)
                || 新規作成終了年月.isBeforeOrEquals(既に存在終了年月) && 既に存在開始年月.isBeforeOrEquals(新規作成終了年月);
    }

    private static enum RRVMessages implements IValidationMessage {

        開始年月が必須(UrErrorMessages.必須, "開始年月"),
        終了年月が必須(UrErrorMessages.必須, "終了年月"),
        単価が必須(UrErrorMessages.必須, "単価"),
        期間が不正(UrErrorMessages.期間が不正_追加メッセージあり２, "開始年月", "終了年月"),
        既に存在(UrErrorMessages.既に存在, "データ"),
        審査委員コードが必須(UrErrorMessages.必須, "審査委員コード"),
        期間が重複(UrErrorMessages.期間が重複),
        審査委員コードエラー(DbeErrorMessages.審査委員コードエラー);

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
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
