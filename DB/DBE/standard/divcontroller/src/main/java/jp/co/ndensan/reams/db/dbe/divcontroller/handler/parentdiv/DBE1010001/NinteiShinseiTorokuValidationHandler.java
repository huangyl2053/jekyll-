/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.NinteiShinseiTorokuResult;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査依頼受付／みなし２号審査受付の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiTorokuValidationHandler {

    private final NinteiShinseiTorokuDiv div;

    private static final RString MENUID_DBEMN21003 = new RString("DBEMN21003");
    private static final RString 認定申請有効 = new RString("認定申請有効");

    /**
     * コンストラクタです。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     */
    public NinteiShinseiTorokuValidationHandler(NinteiShinseiTorokuDiv div) {
        this.div = div;

    }

    /**
     *
     * 編集なしチェック
     *
     * @param flag フラグ
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 編集なしチェック(boolean flag) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (flag) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.編集なしで更新不可));
            return validationMessages;
        }
        return validationMessages;
    }

    /**
     *
     * 被保険者区分チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 被保険者区分チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RString menuID = ResponseHolder.getMenuID();
        if (MENUID_DBEMN21003.equals(menuID)
                && !HihokenshaKubunCode.生活保護.getコード().equals(div.getCcdKaigoNinteiShinseiKihon().
                        getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey())) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.項目に対する制約));
            return validationMessages;
        }
        return validationMessages;
    }

    /**
     * 有効期間チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効期間チェック() {
        RDate kaishiYMD = div.getCcdNinteiInput().getNinteiJoho().getTxtYukoKaishiYMD().getValue();
        RDate shuryoYMD = div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD().getValue();

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (kaishiYMD != null && shuryoYMD != null && shuryoYMD.isBefore(kaishiYMD)) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.終了日が開始日以前, div.getCcdNinteiInput().getNinteiJoho().getTxtYukoShuryoYMD()));
        }
        return validationMessages;
    }

    /**
     * 区分変更申請時取下日理由入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 区分変更申請時取下日理由入力チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(
                div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey())
                && (!TorisageKubunCode.認定申請有効.getコード().equals(div.getDdlTorisageJiyu().getSelectedKey())
                || (div.getDdlTorisageJiyu().getSelectedValue().isEmpty() || div.getTxtTorisageJiyu().getValue().isEmpty()))) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.区分変更申請時取下日理由入力不可,
                    div.getSinseiTorisage()));
        }
        return validationMessages;
    }

    /**
     * センタ送信データ出力完了チェック
     *
     * @param センター送信年月日 FlexibleDate
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs センタ送信データ出力完了更新不可チェック(FlexibleDate センター送信年月日) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (センター送信年月日 != null && !センター送信年月日.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.センタ送信データ出力完了更新不可));
        }
        return validationMessages;
    }

    /**
     * 認定審査会割当完了チェック
     *
     * @param 送付年月日 FlexibleDate
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定審査会割当完了更新不可チェック(FlexibleDate 送付年月日) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (送付年月日 != null && !送付年月日.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.認定審査会割当完了更新不可));
        }
        return validationMessages;
    }

    /**
     * 特定疾病入力必須チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 特定疾病入力必須チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtMinasiFlag().getValue().isEmpty()
                && div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedValue().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.特定疾病入力必須,
                    div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei()));
        }
        return validationMessages;
    }

    /**
     * 申請取下時は取下日理由必須チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 取下日理由必須チェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!TorisageKubunCode.認定申請有効.getコード().equals(div.getDdlTorisageJiyu().getSelectedKey())
                && !div.getDdlTorisageJiyu().getSelectedValue().isEmpty()
                && (div.getTxtTorisageJiyu().getValue().isEmpty()
                || div.getTxtTorisageDate().getValue() == null
                || div.getTxtTorisageDate().getValue().toDateString().isEmpty())) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.申請取下時は取下日理由必須));
        }
        return validationMessages;
    }

    /**
     * 申請サービス削除と取下理由は同時存在チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請サービス削除と取下理由存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().getValue().isEmpty()
                && (!div.getTxtTorisageJiyu().getValue().isNullOrEmpty()
                || !div.getTxtTorisageDate().getValue().toDateString().isNullOrEmpty()
                || !div.getDdlTorisageJiyu().getSelectedValue().isNullOrEmpty())) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.申請サービス削除と取下理由は同時存在));
        }
        return validationMessages;
    }

    /**
     * 審査会割付データ存在チェック
     *
     * @param result NinteiShinseiTorokuResult
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会割付データ存在チェック(NinteiShinseiTorokuResult result) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if ((result.get判定結果コード() == null || result.get判定結果コード().isEmpty() || result.get認定審査会割当完了年月日() != null)
                && result.get介護認定審査会割当年月日() != null) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.審査会割当済のため処理不可));
        }
        return validationMessages;
    }

    /**
     * 依頼完了チェック
     *
     * @param result NinteiShinseiTorokuResult
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 依頼完了チェック(NinteiShinseiTorokuResult result) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        boolean 認定調査依頼完了フラグ = result.get認定調査依頼完了年月日() != null && !result.get認定調査依頼完了年月日().isEmpty();
        boolean 主治医意見書作成依頼完了フラグ = result.get主治医意見書作成依頼完了年月日() != null && !result.get主治医意見書作成依頼完了年月日().isEmpty();
        if (認定調査依頼完了フラグ && 主治医意見書作成依頼完了フラグ) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.認定調査と主治医意見書作成依頼済のため処理不可));
            return validationMessages;
        }
        if (認定調査依頼完了フラグ) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.認定調査依頼済のため処理不可));
        }
        if (主治医意見書作成依頼完了フラグ) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.主治医意見書作成依頼済のため処理不可));
        }
        return validationMessages;
    }

    private static enum NinteiShinseiTorokuMessages implements IValidationMessage {

        編集なしで更新不可(UrErrorMessages.編集なしで更新不可),
        項目に対する制約(UrErrorMessages.項目に対する制約, "みなし２号審査受付場合、被保険者区分", "\"8\" (生活保護)"),
        特定疾病入力必須(UrErrorMessages.未入力, "第２号被保険者の場合、特定疾病"),
        申請取下時は取下日理由必須(UrErrorMessages.未入力, "申請取下時は、取下日・理由"),
        申請サービス削除と取下理由は同時存在(UrErrorMessages.両方の指定は不可, "申請サービス削除", "取下理由"),
        区分変更申請時取下日理由入力不可(UrErrorMessages.設定不可, "取下日、理由は申請区分（申請時）が区分変更申請の"),
        センタ送信データ出力完了更新不可(UrErrorMessages.更新不可, "センタ送信データ出力が完了している"),
        認定審査会割当完了更新不可(UrErrorMessages.更新不可, "認定審査会割当が完了している"),
        終了日が開始日以前(UrErrorMessages.終了日が開始日以前),
        審査会割当済のため処理不可(DbeErrorMessages.審査会割当済のため処理不可),
        認定調査依頼済のため処理不可(DbeErrorMessages.依頼済のため処理不可, "認定調査依頼"),
        主治医意見書作成依頼済のため処理不可(DbeErrorMessages.依頼済のため処理不可, "主治医意見書作成依頼"),
        認定調査と主治医意見書作成依頼済のため処理不可(DbeErrorMessages.依頼済のため処理不可, "認定調査依頼・主治医意見書作成依頼");

        private final Message message;

        private NinteiShinseiTorokuMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
