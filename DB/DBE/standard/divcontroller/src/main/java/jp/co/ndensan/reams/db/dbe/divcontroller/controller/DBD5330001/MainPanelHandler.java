package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.dgDoctorSelection_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.dgResultList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果通知（主治医）画面でのバリデーションを管理するハンドラークラスです。
 *
 */
public class MainPanelHandler {

    /**
     * 未出力のみ
     */
    public static final RString 未出力のみ = new RString("key0");
    /**
     * 未出力のみフラグ
     */
    public static final RString 未出力のみフラグ = new RString("1");
    /**
     * 未出力のみ以外
     */
    public static final RString 未出力のみ以外 = new RString("2");
    /**
     * 希望のみ
     */
    public static final RString 希望のみ = new RString("key0");
    /**
     * レ点
     */
    public static final RString レ点 = new RString("✔");
    /**
     * 対象申請者一覧
     */
    public static final RString 対象申請者一覧 = new RString("対象申請者一覧");
    /**
     * 申請者
     */
    public static final RString 申請者 =  new RString("申請者");
    private final MainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MainPanel のクラスファイル
     */
    public MainPanelHandler(MainPanelDiv div) {
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
        div.getDgDoctorSelection().setDataSource(rowList);
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
            dgResultList_Row row = new dgResultList_Row(
                    new RString(String.valueOf(youKaiGoNinTeiKekTesuChi.get連番())),
                    youKaiGoNinTeiKekTesuChi.get被保険者番号(),
                    youKaiGoNinTeiKekTesuChi.get被保険者氏名(),
                    youKaiGoNinTeiKekTesuChi.get性別(),
                    youKaiGoNinTeiKekTesuChi.get生年月日(),
                    new RString(String.valueOf(youKaiGoNinTeiKekTesuChi.get年齢())),
                    youKaiGoNinTeiKekTesuChi.get申請日(),
                    youKaiGoNinTeiKekTesuChi.get申請区分_申請時(),
                    youKaiGoNinTeiKekTesuChi.get申請区分_法令(),
                    youKaiGoNinTeiKekTesuChi.get二次判定結果(),
                    youKaiGoNinTeiKekTesuChi.get有効期間(),
                    youKaiGoNinTeiKekTesuChi.get有効期間開始(),
                    youKaiGoNinTeiKekTesuChi.get有効期間終了(),
                    youKaiGoNinTeiKekTesuChi.get二次判定日(),
                    認定状況提供日);
            // ,youKaiGoNinTeiKekTesuChi.get申請書管理番号()

            rowList.add(row);
        }
        div.getDgResultList().setDataSource(rowList);
    }

    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     */
    public void 二次判定期間の前後順チェック() {
        if (div.getTxtNijiHanteiKikan().getToValue() != null && div.getTxtNijiHanteiKikan().getFromValue() != null) {
            if (div.getTxtNijiHanteiKikan().getToValue().isBefore(div.getTxtNijiHanteiKikan().getFromValue())) {
                throw new ApplicationException(UrErrorMessages.終了日が開始日以前.toString());
            }
        }
    }
}
