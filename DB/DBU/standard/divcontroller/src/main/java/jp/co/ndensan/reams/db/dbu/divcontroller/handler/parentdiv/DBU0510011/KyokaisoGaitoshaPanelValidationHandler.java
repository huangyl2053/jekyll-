/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.KyokaisoGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dgKyokaisouGaitouItran_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 境界層該当者台帳管理画面のバリデーションハンドラークラスです。
 */
public class KyokaisoGaitoshaPanelValidationHandler {

    private final KyokaisoGaitoshaPanelDiv div;
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 該当フラグ = new RString("1");
    private static final RString 非該当フラグ = new RString("2");
    private static final RString 該当日 = new RString("平17.10.1");
    private static final RString 保険料納付減 = new RString("適用する");

    /**
     * コンストラクタです。
     *
     * @param div 境界層該当者台帳管理情報Div
     */
    public KyokaisoGaitoshaPanelValidationHandler(KyokaisoGaitoshaPanelDiv div) {
        this.div = div;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        RDate 開始日 = div.getTxtKaishibi().getValue();
        RDate 終了日 = div.getTxtShuryobi().getValue();
        if (!開始日.isBefore(終了日)) {
            validPairs.add(new ValidationMessageControlPair(new KyokaisoGaitoshaErrorMessage(UrErrorMessages.終了日が開始日以前)));
        }
        境界層該当一覧情報チェック(validPairs);
        境界層保険料段階情報チェック(validPairs);
        RString 給付額減額記載解除 = div.getRadKyufukakuGengakuKisaiKaijyo().getSelectedKey();
        RString 標準負担額 = div.getRadHyojunFutanGaku().getSelectedKey();
        RString 居住費等負担額減額 = div.getRadKyojuhiFutanGakuGengaku().getSelectedKey();
        RString 食費負担額減額 = div.getRadShokuhiFutangakuGengaku().getSelectedKey();
        RString 高額ｻｰﾋﾞｽ費上限額減額 = div.getRadGogakuServiceJokengaku().getSelectedKey();
        RString 保険料納付減額 = div.getRadHokenryoNofuGengaku().getSelectedKey();
        if (非該当フラグ.equals(給付額減額記載解除)
                && 非該当フラグ.equals(標準負担額)
                && 非該当フラグ.equals(居住費等負担額減額)
                && 非該当フラグ.equals(食費負担額減額)
                && 非該当フラグ.equals(高額ｻｰﾋﾞｽ費上限額減額)
                && 非該当フラグ.equals(保険料納付減額)) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.境界層措置決定情報チェック));
        }

        標準負担額該当の開始日チェック(validPairs);
        居住費等負担額減額該当の開始日チェック(validPairs);
        居住費軽減後居室種類チェック(validPairs);
        食費負担額減額該当の開始日チェック(validPairs);
        読替後高額介護世帯上限額該当の開始日チェック(validPairs);
        組合せチェック(validPairs);
        保険料納付減額存在チェック(validPairs);
        return validPairs;
    }

    private void 標準負担額該当の開始日チェック(ValidationMessageControlPairs validPairs) {
        RDate 開始日 = div.getTxtKaishibi().getValue();
        RString 標準負担額 = div.getRadHyojunFutanGaku().getSelectedKey();
        if (該当フラグ.equals(標準負担額)
                && !開始日.isBeforeOrEquals(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.標準負担額該当の開始日チェック));
        }
    }

    private void 居住費等負担額減額該当の開始日チェック(ValidationMessageControlPairs validPairs) {
        RDate 開始日 = div.getTxtKaishibi().getValue();
        RString 居住費等負担額減額 = div.getRadKyojuhiFutanGakuGengaku().getSelectedKey();
        if (該当フラグ.equals(居住費等負担額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.居住費等負担額減額該当の開始日チェック));
        }
    }

    private void 居住費軽減後居室種類チェック(ValidationMessageControlPairs validPairs) {
        RString 居住費等負担額減額 = div.getRadKyojuhiFutanGakuGengaku().getSelectedKey();
        if (該当フラグ.equals(居住費等負担額減額)
                && div.getDdlKyoshituShurui().getSelectedValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.居住費軽減後居室種類チェック));
        }
    }

    private void 食費負担額減額該当の開始日チェック(ValidationMessageControlPairs validPairs) {
        RDate 開始日 = div.getTxtKaishibi().getValue();
        RString 食費負担額減額 = div.getRadShokuhiFutangakuGengaku().getSelectedKey();
        if (該当フラグ.equals(食費負担額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.食費負担額減額該当の開始日チェック));
        }
    }

    private void 読替後高額介護世帯上限額該当の開始日チェック(ValidationMessageControlPairs validPairs) {
        RDate 開始日 = div.getTxtKaishibi().getValue();
        RString 高額ｻｰﾋﾞｽ費上限額減額 = div.getRadGogakuServiceJokengaku().getSelectedKey();
        if (該当フラグ.equals(高額ｻｰﾋﾞｽ費上限額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.読替後高額介護世帯上限額該当の開始日チェック));
        }
    }

    private void 組合せチェック(ValidationMessageControlPairs validPairs) {
        RDate 開始日 = div.getTxtKaishibi().getValue();
        RString 標準負担額 = div.getRadHyojunFutanGaku().getSelectedKey();
        RString 居住費等負担額減額 = div.getRadKyojuhiFutanGakuGengaku().getSelectedKey();
        RString 食費負担額減額 = div.getRadShokuhiFutangakuGengaku().getSelectedKey();
        RString 高額ｻｰﾋﾞｽ費上限額減額 = div.getRadGogakuServiceJokengaku().getSelectedKey();
        if (該当フラグ.equals(標準負担額) && 該当フラグ.equals(居住費等負担額減額) && 該当フラグ.equals(食費負担額減額)
                && 該当フラグ.equals(高額ｻｰﾋﾞｽ費上限額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.組合せチェック));
        }
    }

    private void 保険料納付減額存在チェック(ValidationMessageControlPairs validPairs) {
        RString 保険料納付減額 = div.getRadHokenryoNofuGengaku().getSelectedKey();
        List<dghokenryoNofu_Row> nofu_RowList = div.getDghokenryoNofu().getDataSource();
        if (保険料納付減.equals(保険料納付減額) && nofu_RowList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.保険料納付減額存在チェック));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        境界層措置決定情報チェック(DbaErrorMessages.記載解除_減額_低減適用のいずれか1つ以上選択),
        期間が重複チェック(UrErrorMessages.期間が重複),
        標準負担額該当の開始日チェック(DbaErrorMessages.開始日が制度改正後のため減額措置登録不可, "開始日"),
        居住費等負担額減額該当の開始日チェック(DbaErrorMessages.開始日が制度改正前のため減額措置登録不可, "開始日"),
        居住費軽減後居室種類チェック(DbaErrorMessages.適用する項目を設定, "所得段階"),
        食費負担額減額該当の開始日チェック(DbaErrorMessages.開始日が制度改正前のため減額措置登録不可, "開始日"),
        読替後高額介護世帯上限額該当の開始日チェック(DbaErrorMessages.開始日が制度改正前のため減額措置登録不可, "開始日"),
        組合せチェック(DbaErrorMessages.開始日が制度改正前のため減額措置登録不可, "開始日"),
        保険料納付減額存在チェック(DbaErrorMessages.適用する項目を設定, "所得段階");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static class DateComparator implements Comparator<dgKyokaisouGaitouItran_Row>, Serializable {

        private static final long serialVersionUID = -2908295330582757718L;

        @Override
        public int compare(dgKyokaisouGaitouItran_Row o1, dgKyokaisouGaitouItran_Row o2) {
            int 境界層該当一覧情報 = o1.getKaishiDate().compareTo(o2.getKaishiDate());
            if (境界層該当一覧情報 == 0) {
                return o1.getShuryoDate().compareTo(o2.getShuryoDate());
            }
            return 境界層該当一覧情報;
        }
    }

    private static class KyokaisoHokenryoDateComparator implements Comparator<dghokenryoNofu_Row>, Serializable {

        private static final long serialVersionUID = -5836270759887778883L;

        @Override
        public int compare(dghokenryoNofu_Row o1, dghokenryoNofu_Row o2) {

            int 境保険料段階情報 = new RDate(o1.getTekiyoKaishiDate().toString()).compareTo(new RDate(o2.getTekiyoKaishiDate().toString()));
            if (境保険料段階情報 == 0) {
                return new RDate(o1.getTekiyoShuryoDate().toString()).compareTo(new RDate(o2.getTekiyoShuryoDate().toString()));
            }
            return 境保険料段階情報;
        }
    }

    private static class KyokaisoGaitoshaErrorMessage implements IMessageGettable, IValidationMessage {

        private final Message message;

        public KyokaisoGaitoshaErrorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private void 境界層該当一覧情報チェック(ValidationMessageControlPairs validPairs) {
        List<dgKyokaisouGaitouItran_Row> 境界層該当一覧情報 = div.getDgKyokaisouGaitouItran().getDataSource();
        Collections.sort(境界層該当一覧情報, new KyokaisoGaitoshaPanelValidationHandler.DateComparator());
        int 一覧終了日未設定件数 = 0;
        for (int i = 0; i < 境界層該当一覧情報.size() - 1; i++) {
            if (状態_削除.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                continue;
            }
            if (境界層該当一覧情報.get(i).getShuryoDate() == null || 境界層該当一覧情報.get(i).getShuryoDate().isEmpty()) {
                一覧終了日未設定件数 = 一覧終了日未設定件数 + 1;
                期間が重複チェック(validPairs, 一覧終了日未設定件数);
            }
            if (境界層該当一覧情報.get(i).getShuryoDate() == null
                    || 境界層該当一覧情報.get(i).getShuryoDate().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
            if (!new RDate(境界層該当一覧情報.get(i).getShuryoDate().toString())
                    .isBefore(new RDate(境界層該当一覧情報.get(i + 1).getKaishiDate().toString()))) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
        }
    }

    private void 境界層保険料段階情報チェック(ValidationMessageControlPairs validPairs) {
        List<dghokenryoNofu_Row> 境界層保険料段階情報 = div.getDghokenryoNofu().getDataSource();
        Collections.sort(境界層保険料段階情報, new KyokaisoGaitoshaPanelValidationHandler.KyokaisoHokenryoDateComparator());
        int 終了日未設定件数 = 0;
        for (int i = 0; i < 境界層保険料段階情報.size() - 1; i++) {
            if (状態_削除.equals(境界層保険料段階情報.get(i).getState())) {
                continue;
            }
            if (境界層保険料段階情報.get(i).getTekiyoShuryoDate().isEmpty()) {
                終了日未設定件数 = 1 + 終了日未設定件数;
                期間が重複チェック(validPairs, 終了日未設定件数);
            }
            if (境界層保険料段階情報.get(i).getTekiyoShuryoDate() == null
                    || 境界層保険料段階情報.get(i).getTekiyoShuryoDate().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
            if (!new RYearMonth(new RDate(境界層保険料段階情報.get(i).getTekiyoShuryoDate().toString()).getYearMonth().toDateString())
                    .isBefore(new RYearMonth(new RDate(境界層保険料段階情報.get(i + 1).getTekiyoKaishiDate().toString()).getYearMonth().toDateString()))) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
        }
    }

    private void 期間が重複チェック(ValidationMessageControlPairs validPairs, int 終了日未設定件数) {
        if (終了日未設定件数 >= 2) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
        }
    }
}
