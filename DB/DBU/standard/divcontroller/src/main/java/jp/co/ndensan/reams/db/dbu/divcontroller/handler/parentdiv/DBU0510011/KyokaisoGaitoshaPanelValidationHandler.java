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
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
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
            validPairs.add(new ValidationMessageControlPair(DbzErrorMessages.終了日が開始日以前));
        }
//        TODO 凌護行 「保存する」ボタンを押下するとき、チェック実施のデータを更新前データ、処理誤り、QA回答まち、　2016/1/18
//        Models<KyokaisoGaitoshaIdentifier, KyokaisoGaitosha> gaitoshaModels
//                = ViewStateHolder.get(ViewStateKeys.境界層該当者情報, Models.class);
//        Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> sochiShinseiModels
//                = ViewStateHolder.get(ViewStateKeys.境界層措置申請情報, Models.class);
//        Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> 境界層保険料段階情報
//                = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);
//
//        List<KyokaisoGaitosha> kyokaisoGaitoshaList = new ArrayList<>();
//        List<KyokaisoSochiShinsei> kyokaisoSochiShinseiList = new ArrayList<>();
//        List<KyokaisoHokenryoDankai> hokenryoDankaiList = new ArrayList<>();
//        for (KyokaisoGaitosha gaitosha : gaitoshaModels) {
//            kyokaisoGaitoshaList.add(gaitosha);
//        }
//        for (KyokaisoSochiShinsei shinsei : sochiShinseiModels) {
//            kyokaisoSochiShinseiList.add(shinsei);
//        }
//        for (KyokaisoHokenryoDankai dankai : 境界層保険料段階情報) {
//            hokenryoDankaiList.add(dankai);
//        }
//        Collections.sort(entityList, new DateComparator());
//
//        int 終了日未設定件数 = 0;
//        for (KyokaisoGaitoshaEntity entity : entityList) {
//            if (状態_削除.equals(entity.get一覧情報_状態())) {
//                continue;
//            }
//            if (entity.get終了日() == null || entity.get終了日().isEmpty()) {
//                終了日未設定件数 = 終了日未設定件数 + 1;
//                if (終了日未設定件数 >= 2) {
//                    return エラーコード;
//                }
//            }
//        }
//        for (int i = 0; i < entityList.size() - 1; i++) {
//            if (状態_削除.equals(entityList.get(i).get一覧情報_状態())) {
//                continue;
//            }
//            if (entityList.get(i).get終了日() == null
//                    || entityList.get(i).get終了日().isEmpty()) {
//                return エラーコード;
//            }
//            if (!entityList.get(i).get終了日()
//                    .isBefore(entityList.get(i + 1).get開始日())) {
//                return エラーコード;
//            }
//        }

        List<dghokenryoNofu_Row> 境界層保険料段階情報 = div.getDghokenryoNofu().getDataSource();
        Collections.sort(境界層保険料段階情報, new KyokaisoGaitoshaPanelValidationHandler.KyokaisoHokenryoDateComparator());

        for (dghokenryoNofu_Row nofu_Row : 境界層保険料段階情報) {
            int 終了日未設定件数 = 0;
            if (状態_削除.equals(nofu_Row.getDefaultDataName0())) {
                continue;
            }
            if (nofu_Row.getDefaultDataName2().isEmpty()) {
                終了日未設定件数 = 1 + 終了日未設定件数;
                if (終了日未設定件数 > 2) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
                }
            }
        }
        for (int i = 0; i < 境界層保険料段階情報.size() - 1; i++) {
            if (状態_削除.equals(境界層保険料段階情報.get(i).getDefaultDataName0())) {
                continue;
            }
            if (境界層保険料段階情報.get(i).getDefaultDataName2() == null
                    || 境界層保険料段階情報.get(i).getDefaultDataName2().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
            if (!new RYearMonth(new RDate(境界層保険料段階情報.get(i).getDefaultDataName2().toString()).getYearMonth().toDateString())
                    .isBefore(new RYearMonth(new RDate(境界層保険料段階情報.get(i + 1).getDefaultDataName1().toString()).getYearMonth().toDateString()))) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複チェック));
            }
        }
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

        if (該当フラグ.equals(標準負担額)
                && !開始日.isBeforeOrEquals(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.標準負担額該当の開始日チェック));
        }

        if (該当フラグ.equals(居住費等負担額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.居住費等負担額減額該当の開始日チェック));
        }
        if (該当フラグ.equals(居住費等負担額減額)
                && div.getDdlKyoshituShurui().getSelectedValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.居住費軽減後居室種類チェック));
        }
        if (該当フラグ.equals(食費負担額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.食費負担額減額該当の開始日チェック));
        }
        // TODO 凌護行 仕様記述「読替後高額介護世帯上限額該当の開始日チェック」です、認識：「高額ｻｰﾋﾞｽ費上限額減額該当の開始日チェック」、 QA回答まち、　2016/1/18
        if (該当フラグ.equals(高額ｻｰﾋﾞｽ費上限額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.読替後高額介護世帯上限額該当の開始日チェック));
        }
// TODO 凌護行 仕様記述「読替後高額介護世帯上限額該当の開始日チェック」です、認識：「高額ｻｰﾋﾞｽ費上限額減額該当の開始日チェック」、 QA回答まち、　2016/1/18
        if (該当フラグ.equals(標準負担額) && 該当フラグ.equals(居住費等負担額減額) && 該当フラグ.equals(食費負担額減額)
                && 該当フラグ.equals(高額ｻｰﾋﾞｽ費上限額減額)
                && 開始日.isBefore(new RDate(該当日.toString()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.組合せチェック));
        }
        List<dghokenryoNofu_Row> nofu_RowList = div.getDghokenryoNofu().getDataSource();
        if (保険料納付減.equals(保険料納付減額) && nofu_RowList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.保険料納付減額存在チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        // TODO 凌護行 ソースにエラーコードが無し、QA745回答まち、2016/1/18
        境界層措置決定情報チェック(DbaErrorMessages.QA745),
        期間が重複チェック(UrErrorMessages.期間が重複),
        標準負担額該当の開始日チェック(DbaErrorMessages.QA745),
        居住費等負担額減額該当の開始日チェック(DbaErrorMessages.QA745),
        居住費軽減後居室種類チェック(DbaErrorMessages.QA745),
        食費負担額減額該当の開始日チェック(DbaErrorMessages.QA745),
        読替後高額介護世帯上限額該当の開始日チェック(DbaErrorMessages.QA745),
        組合せチェック(DbaErrorMessages.QA745),
        保険料納付減額存在チェック(DbaErrorMessages.QA745);

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    //        TODO 凌護行 「保存する」ボタンを押下するとき、チェック実施のデータを更新前データ、処理誤り、QA回答まち、　2016/1/18
//    private static class DateComparator implements Comparator<dghokenryoNofu_Row>, Serializable {
//
//        private static final long serialVersionUID = -2908295330582757718L;
//
//        @Override
//        public int compare(dghokenryoNofu_Row o1, dghokenryoNofu_Row o2) {
//            int 境界層該当一覧情報 = o1.get開始日().compareTo(o2.get開始日());
//            if (境界層該当一覧情報 == 0) {
//                return o1.get終了日().compareTo(o2.get終了日());
//            }
//            return 境界層該当一覧情報;
//        }
//    }
    private static class KyokaisoHokenryoDateComparator implements Comparator<dghokenryoNofu_Row>, Serializable {

        private static final long serialVersionUID = -5836270759887778883L;

        @Override
        public int compare(dghokenryoNofu_Row o1, dghokenryoNofu_Row o2) {

            int 境保険料段階情報 = new RDate(o1.getDefaultDataName1().toString()).compareTo(new RDate(o2.getDefaultDataName1().toString()));
            if (境保険料段階情報 == 0) {
                return new RDate(o1.getDefaultDataName2().toString()).compareTo(new RDate(o2.getDefaultDataName2().toString()));
            }
            return 境保険料段階情報;
        }
    }
}
