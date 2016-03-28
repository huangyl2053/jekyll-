package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0330001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.YouKaiGoNinTeiKekTesuChiMainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.dgDoctorSelection_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001.dgResultList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定結果通知（主治医）画面でのバリデーションを管理するハンドラークラスです。
 *
 */
public class MainPanelHandler {

    private static final RString レ点 = new RString("✔");
    private static final RString 対象申請者一覧 = new RString("対象申請者一覧");
    private static final RString 申請者 = new RString("申請者");
    private final YouKaiGoNinTeiKekTesuChiMainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MainPanel のクラスファイル
     */
    public MainPanelHandler(YouKaiGoNinTeiKekTesuChiMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 主治医選択一覧情報を設定します。。
     *
     * @param businessList 要介護認定結果通知情報ビジネスクラスですリスト。
     */
    public void edit主治医選択一覧情報(List<YouKaiGoNinTeiKekTesuChi> businessList) {
        List<dgDoctorSelection_Row> rowList = new ArrayList();
        for (YouKaiGoNinTeiKekTesuChi youKaiGoNinTeiKekTesuChi : businessList) {
            dgDoctorSelection_Row row = new dgDoctorSelection_Row(
                    youKaiGoNinTeiKekTesuChi.get主治医医療機関コード(),
                    youKaiGoNinTeiKekTesuChi.get医療機関名称(),
                    youKaiGoNinTeiKekTesuChi.get郵便番号(),
                    youKaiGoNinTeiKekTesuChi.get電話番号(),
                    youKaiGoNinTeiKekTesuChi.get住所(),
                    youKaiGoNinTeiKekTesuChi.get主治医コード(),
                    youKaiGoNinTeiKekTesuChi.get主治医氏名(),
                    new RString(String.valueOf(youKaiGoNinTeiKekTesuChi.get対象件数())),
                    youKaiGoNinTeiKekTesuChi.get申請書管理番号());
            rowList.add(row);
        }
        div.getDoctorSelectionPanel().getDgDoctorSelection().setDataSource(rowList);
    }

    /**
     * 結果通知出力対象申請者一覧情報を設定します。。
     *
     * @param businessList 要介護認定結果通知情報ビジネスクラスですリスト。
     */
    public void edit結果通知出力対象申請者一覧情報(List<YouKaiGoNinTeiKekTesuChi> businessList) {
        List<dgResultList_Row> rowList = new ArrayList();
        RString 認定状況提供日;
        for (YouKaiGoNinTeiKekTesuChi youKaiGoNinTeiKekTesuChi : businessList) {
            if (youKaiGoNinTeiKekTesuChi.get認定状況提供日() == null || youKaiGoNinTeiKekTesuChi.get認定状況提供日().isEmpty()) {
                認定状況提供日 = レ点;
            } else {
                認定状況提供日 = youKaiGoNinTeiKekTesuChi.get認定状況提供日();
            }
            TextBoxDate txt生年月日 = new TextBoxDate();
            TextBoxDate txt申請日 = new TextBoxDate();
            TextBoxDate txt二次判定結果 = new TextBoxDate();
            TextBoxDate txt有効期間終了 = new TextBoxDate();
            TextBoxDate txt二次判定日 = new TextBoxDate();
            TextBoxDate txt認定状況提供日 = new TextBoxDate();
            txt生年月日.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get生年月日().toString()));
            txt申請日.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get申請日().toString()));
            txt二次判定結果.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get二次判定結果().toString()));
            txt有効期間終了.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get有効期間終了().toString()));
            txt二次判定日.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get二次判定日().toString()));
            txt認定状況提供日.setValue(new RDate(youKaiGoNinTeiKekTesuChi.get二次判定日().toString()));
            dgResultList_Row row = new dgResultList_Row(
                    new RString(String.valueOf(youKaiGoNinTeiKekTesuChi.get連番())),
                    youKaiGoNinTeiKekTesuChi.get被保険者番号(),
                    youKaiGoNinTeiKekTesuChi.get被保険者氏名(),
                    youKaiGoNinTeiKekTesuChi.get性別(),
                    //                    youKaiGoNinTeiKekTesuChi.get生年月日(),
                    txt生年月日,
                    new RString(String.valueOf(youKaiGoNinTeiKekTesuChi.get年齢())),
                    //                    youKaiGoNinTeiKekTesuChi.get申請日(),
                    txt申請日,
                    youKaiGoNinTeiKekTesuChi.get申請区分_申請時(),
                    youKaiGoNinTeiKekTesuChi.get申請区分_法令(),
                    //                    youKaiGoNinTeiKekTesuChi.get二次判定結果(),
                    txt二次判定結果,
                    youKaiGoNinTeiKekTesuChi.get有効期間(),
                    youKaiGoNinTeiKekTesuChi.get有効期間開始(),
                    //                    youKaiGoNinTeiKekTesuChi.get有効期間終了(),
                    txt有効期間終了,
                    //                    youKaiGoNinTeiKekTesuChi.get二次判定日(),
                    txt二次判定日,
                    //                    認定状況提供日,
                    txt認定状況提供日,
                    youKaiGoNinTeiKekTesuChi.get申請書管理番号()
            );
            rowList.add(row);
        }
        div.getDgResultList().setDataSource(rowList);
    }

    /**
     * 「対象データなし」メッセジーの取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getメッセジー_対象データなし() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象データなし_追加メッセージあり, 対象申請者一覧.toString())));
        return validPairs;
    }

    /**
     * 「選択されていない」メッセジーの取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getメッセジー_選択されていない() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.選択されていない, 申請者.toString())));
        return validPairs;
    }

    /**
     * 二次判定期間の前後順チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 二次判定期間の前後順チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtNijiHanteiKikan().getToValue() != null && div.getTxtNijiHanteiKikan().getFromValue() != null
                && div.getTxtNijiHanteiKikan().getToValue().isBefore(div.getTxtNijiHanteiKikan().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.終了日が開始日以前, RString.EMPTY.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
