/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainjikan.NinteiChosainBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.NinteiChosainJikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.dgTimeScheduleList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosainjikan.NinteiChosainJikanMasterManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputModel;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査スケジュール登録6のクラス。
 *
 * @reamsid_L DBE-0022-010 linghuhang
 */
public class NinteiChosainJikanMasterHandler {

    private static final int 時間枠_1 = 1;
    private static final int 時間枠_2 = 2;
    private static final int 時間枠_3 = 3;
    private static final int 時間枠_4 = 4;
    private static final int 時間枠_5 = 5;
    private static final int 時間枠_6 = 6;
    private static final int 時間枠_7 = 7;
    private static final int 時間枠_8 = 8;
    private static final int 時間枠_9 = 9;
    private static final int 時間枠_10 = 10;
    private static final int 予定時間_始 = 2;
    private static final int 予定時間_終 = 4;
    private static final int 時間_終 = 5;
    private final RString 編集状態_既存 = new RString("2");
    private final RString 処理区分_未処理 = new RString("0");
    private final RString 処理区分_削除 = new RString("3");
    private final RString 処理区分_新規 = new RString("1");
    private final RString 処理区分_更新 = new RString("2");
    private final RString 予約フラグ_可 = new RString("key0");
    private final RString 予約フラグ_不可 = new RString("key1");
    private final RString 予約状況_未定 = new RString("0");
    private final RString ボタン_登録 = new RString("登録");
    private final RString ボタン_削除 = new RString("削除");
    private final NinteiChosainJikanMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public NinteiChosainJikanMasterHandler(NinteiChosainJikanMasterDiv div) {
        this.div = div;
    }

    /**
     * 認定調査スケジュール登録6の初期化を設定します。
     *
     * @param 設定年月 設定年月
     */
    public void onLoad(FlexibleDate 設定年月) {
        div.getDdlTaishoChiku().setDataSource(get調査地区ドロップダウンリスト());
        div.getTxtSettingMonth().setValue(設定年月);
        初期化一覧(設定年月);
        初期化状態の設定();
        時間枠設定閉じている();
    }

    /**
     * 「設定年月の時間枠を検索する」ボタンを押下する、時間枠設定一覧情報を設定します。
     *
     * @param 認定調査情報 認定調査情報
     */
    public void btnSearch(List<NinteiChosainBusiness> 認定調査情報) {
        FlexibleDate 予定年月日;
        List<dgTimeScheduleList_Row> rowList = new ArrayList<>();
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        for (int i = 1; i < (div.getTxtSettingMonth().getValue().getLastDay() + 1); i++) {
            dgTimeScheduleList_Row row = new dgTimeScheduleList_Row();
            予定年月日
                    = new FlexibleDate(Integer.parseInt(date2.getYear().toString()), Integer.parseInt(date2.getMonth().toString()), i);
            row.setDate(new RString(Integer.toString(i)));
            row.setDay(new RString(予定年月日.getDayOfWeek().getMiddleTerm().substring(0, 1)));
            set認定調査データ(予定年月日, 認定調査情報, row);
            set背景色の編集(予定年月日, row);
            rowList.add(row);
        }
        div.getDgTimeScheduleList().setDataSource(rowList);
    }

    /**
     * 編集ボタンを押下する、時間枠を設定します。
     *
     * @param 編集元 編集元
     * @param 時間枠 時間枠
     * @param row row
     */
    public void btnHennsyu(NinteiChosainBusiness 編集元, RString 時間枠, dgTimeScheduleList_Row row) {
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        FlexibleDate 認定調査予定日 = new FlexibleDate(
                Integer.parseInt(date2.getYear().toString()),
                Integer.parseInt(date2.getMonth().toString()),
                Integer.parseInt(row.getDate().toString()));
        div.getTxtSetteiYMD().setValue(new RDate(認定調査予定日.toString()));
        div.getTxtJikanWaku().setValue(時間枠);

        編集時間枠一と時間枠二(row, 時間枠);
        編集時間枠三と時間枠四(row, 時間枠);
        編集時間枠五と時間枠六(row, 時間枠);
        編集時間枠七と時間枠八(row, 時間枠);
        編集時間枠九と時間枠十(row, 時間枠);

        if (編集元.is予約可能フラグ()) {
            div.getRadYoyaku().setSelectedKey(予約フラグ_可);
        } else {
            div.getRadYoyaku().setSelectedKey(予約フラグ_不可);
        }
        div.getTxtBiko().setValue(編集元.get備考());
        set編集の状態();
    }

    /**
     * 編集ボタンを押下する、時間枠を設定します。
     *
     * @param row 編集データ
     * @param 時間枠 時間枠
     */
    public void btnHennsyu(dgTimeScheduleList_Row row, RString 時間枠) {
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        FlexibleDate 認定調査予定日 = new FlexibleDate(
                Integer.parseInt(date2.getYear().toString()),
                Integer.parseInt(date2.getMonth().toString()),
                Integer.parseInt(row.getDate().toString()));
        div.getTxtSetteiYMD().setValue(new RDate(認定調査予定日.toString()));
        div.getTxtJikanWaku().setValue(時間枠);
        div.getTxtKaishiJikan().setValue(RTime.of(
                Integer.parseInt(開始_終了時間の取得(時間枠).split("-").get(0).split(":").get(0).toString()),
                Integer.parseInt(開始_終了時間の取得(時間枠).split("-").get(0).split(":").get(1).toString())));
        div.getTxtShuryoJikan().setValue(RTime.of(
                Integer.parseInt(開始_終了時間の取得(時間枠).split("-").get(1).split(":").get(0).toString()),
                Integer.parseInt(開始_終了時間の取得(時間枠).split("-").get(1).split(":").get(1).toString())));
        div.getRadYoyaku().setSelectedKey(予約フラグ_可);
        div.getTxtBiko().setValue(RString.EMPTY);
        set編集の状態();
    }

    /**
     * 「登録する」ボタンを押下する、画面上該当時間枠情報を登録する。
     *
     * @param 予定年月日 予定年月日
     * @param 時間枠 時間枠
     */
    public void btnCreate(FlexibleDate 予定年月日, RString 時間枠) {
        List<dgTimeScheduleList_Row> rowList = div.getDgTimeScheduleList().getDataSource();
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        for (int i = 1; i < (div.getTxtSettingMonth().getValue().getLastDay() + 1); i++) {
            FlexibleDate 予定日 = new FlexibleDate(
                    Integer.parseInt(date2.getYear().toString()),
                    Integer.parseInt(date2.getMonth().toString()), i);
            if (予定日.compareTo(予定年月日) == 0) {
                rowList.set(i - 1, 登録データの設定(予定日, 予定年月日, 時間枠, rowList.get(i - 1), ボタン_登録));
            }
        }
        div.getDgTimeScheduleList().setDataSource(rowList);
        div.getDgTimeScheduleList().setReadOnly(false);
        div.getMainPanel().getSettingDetail().getTxtBiko().clearValue();
        div.getMainPanel().getSettingDetail().setDisplayNone(true);
    }

    /**
     * 「削除する」ボタンを押下する、画面上該当時間枠情報を削除する。
     *
     * @param 予定年月日 予定年月日
     * @param 時間枠 時間枠
     */
    public void btnDelete(FlexibleDate 予定年月日, RString 時間枠) {
        List<dgTimeScheduleList_Row> rowList = div.getDgTimeScheduleList().getDataSource();
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        for (int i = 1; i < (div.getTxtSettingMonth().getValue().getLastDay() + 1); i++) {
            FlexibleDate 予定日 = new FlexibleDate(
                    Integer.parseInt(date2.getYear().toString()),
                    Integer.parseInt(date2.getMonth().toString()), i);
            if (予定日.compareTo(予定年月日) == 0) {
                rowList.set(i - 1, 登録データの設定(予定日, 予定年月日, 時間枠, rowList.get(i - 1), ボタン_削除));
            }
        }
        div.getDgTimeScheduleList().setDataSource(rowList);
        div.getDgTimeScheduleList().setReadOnly(false);
        div.getMainPanel().getSettingDetail().getTxtBiko().clearValue();
        div.getMainPanel().getSettingDetail().setDisplayNone(true);
    }

    /**
     * 「一括設定する」ボタンを押下する、画面上該当時間枠情報を登録する。
     *
     */
    public void btnNinteiChosaIkkatsuInput() {
        NinteiChosaIkkatsuInputModel models = DataPassingConverter.deserialize(div.getNinteiChosaIkkatsuInputModel(), NinteiChosaIkkatsuInputModel.class);
        if (models != null) {
            List<NinteiChosaIkkatsuInputModel> データ = models.getModelList();
            if (データ != null) {
                for (NinteiChosaIkkatsuInputModel model : データ) {
                    FlexibleDate 設定予定日 = model.get認定調査予定年月日();
                    boolean is上書きするフラグ = model.is既に設定済みの場合上書きするフラグ();
                    RString 時間枠 = model.get認定調査時間枠().getColumnValue();
                    RString 認定調査予定開始時間 = model.get認定調査予定開始時間();
                    RString 認定調査予定終了時間 = model.get認定調査予定終了時間();
                    データ編集(設定予定日, is上書きするフラグ, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間);
                }
            }
        }
    }

    private void データ編集(
            FlexibleDate 設定予定日,
            boolean is上書きするフラグ,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        List<dgTimeScheduleList_Row> rowList = div.getDgTimeScheduleList().getDataSource();
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        for (int i = 1; i < (div.getTxtSettingMonth().getValue().getLastDay() + 1); i++) {
            FlexibleDate 予定日 = new FlexibleDate(
                    Integer.parseInt(date2.getYear().toString()),
                    Integer.parseInt(date2.getMonth().toString()), i);
            if (設定予定日.compareTo(予定日) == 0) {
                rowList.set(i - 1, 一括設定データ(is上書きするフラグ, 時間枠, rowList.get(i - 1), 認定調査予定開始時間, 認定調査予定終了時間));
            }
        }
        div.getDgTimeScheduleList().setDataSource(rowList);
    }

    private dgTimeScheduleList_Row 一括設定データ(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        一括設定時間枠一と一括設定時間枠二(is上書きするフラグ, 時間枠, row, 認定調査予定開始時間, 認定調査予定終了時間);
        一括設定時間枠三と一括設定時間枠四(is上書きするフラグ, 時間枠, row, 認定調査予定開始時間, 認定調査予定終了時間);
        一括設定時間枠五と一括設定時間枠六(is上書きするフラグ, 時間枠, row, 認定調査予定開始時間, 認定調査予定終了時間);
        一括設定時間枠七と一括設定時間枠八(is上書きするフラグ, 時間枠, row, 認定調査予定開始時間, 認定調査予定終了時間);
        一括設定時間枠九と一括設定時間枠十(is上書きするフラグ, 時間枠, row, 認定調査予定開始時間, 認定調査予定終了時間);
        return row;
    }

    private void 一括設定時間枠一と一括設定時間枠二(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku01())) {
                    row.setYoyakuJokyo01(予約状況_未定);
                    row.setSyoriKben01(処理区分_新規);
                } else {
                    row.setSyoriKben01(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben01(処理区分_更新);
                    }
                }
                一括設定時間枠一と一括設定時間枠二(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben01());
                break;
            case 時間枠_2:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku02())) {
                    row.setYoyakuJokyo02(予約状況_未定);
                    row.setSyoriKben02(処理区分_新規);
                } else {
                    row.setSyoriKben02(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben02(処理区分_更新);
                    }
                }
                一括設定時間枠一と一括設定時間枠二(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben02());
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠三と一括設定時間枠四(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku03())) {
                    row.setYoyakuJokyo03(予約状況_未定);
                    row.setSyoriKben03(処理区分_新規);
                } else {
                    row.setSyoriKben03(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben03(処理区分_更新);
                    }
                }
                一括設定時間枠三と一括設定時間枠四(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben03());
                break;
            case 時間枠_4:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku04())) {
                    row.setYoyakuJokyo04(予約状況_未定);
                    row.setSyoriKben04(処理区分_新規);
                } else {
                    row.setSyoriKben04(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben04(処理区分_更新);
                    }
                }
                一括設定時間枠三と一括設定時間枠四(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben04());
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠五と一括設定時間枠六(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku05())) {
                    row.setYoyakuJokyo05(予約状況_未定);
                    row.setSyoriKben05(処理区分_新規);
                } else {
                    row.setSyoriKben05(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben05(処理区分_更新);
                    }
                }
                一括設定時間枠五と一括設定時間枠六(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben05());
                break;
            case 時間枠_6:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku06())) {
                    row.setYoyakuJokyo06(予約状況_未定);
                    row.setSyoriKben06(処理区分_新規);
                } else {
                    row.setSyoriKben06(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben06(処理区分_更新);
                    }
                }
                一括設定時間枠五と一括設定時間枠六(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben06());
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠七と一括設定時間枠八(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku07())) {
                    row.setYoyakuJokyo07(予約状況_未定);
                    row.setSyoriKben07(処理区分_新規);
                } else {
                    row.setSyoriKben07(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben07(処理区分_更新);
                    }
                }
                一括設定時間枠七と一括設定時間枠八(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben07());
                break;
            case 時間枠_8:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku08())) {
                    row.setYoyakuJokyo08(予約状況_未定);
                    row.setSyoriKben08(処理区分_新規);
                } else {
                    row.setSyoriKben08(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben08(処理区分_更新);
                    }
                }
                一括設定時間枠七と一括設定時間枠八(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben08());
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠九と一括設定時間枠十(
            boolean is上書きするフラグ,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku09())) {
                    row.setYoyakuJokyo09(予約状況_未定);
                    row.setSyoriKben09(処理区分_新規);
                } else {
                    row.setSyoriKben09(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben09(処理区分_更新);
                    }
                }
                一括設定時間枠九と一括設定時間枠十(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben09());
                break;
            case 時間枠_10:
                if (RString.isNullOrEmpty(row.getChosaJikanwaku10())) {
                    row.setYoyakuJokyo10(予約状況_未定);
                    row.setSyoriKben10(処理区分_新規);
                } else {
                    row.setSyoriKben10(処理区分_未処理);
                    if (is上書きするフラグ) {
                        row.setSyoriKben10(処理区分_更新);
                    }
                }
                一括設定時間枠九と一括設定時間枠十(row, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, row.getSyoriKben10());
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠一と一括設定時間枠二(
            dgTimeScheduleList_Row row,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku01(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku01(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku01(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            case 時間枠_2:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku02(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku02(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku02(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠三と一括設定時間枠四(
            dgTimeScheduleList_Row row,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku03(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku03(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku03(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            case 時間枠_4:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku04(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku04(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku04(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠五と一括設定時間枠六(
            dgTimeScheduleList_Row row,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku05(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku05(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku05(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            case 時間枠_6:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku06(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku06(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku06(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠七と一括設定時間枠八(
            dgTimeScheduleList_Row row,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku07(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku07(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku07(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            case 時間枠_8:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku08(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku08(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku08(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠九と一括設定時間枠十(
            dgTimeScheduleList_Row row,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {

            case 時間枠_9:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku09(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku09(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku09(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            case 時間枠_10:
                if (処理区分_新規.equals(処理区分)) {
                    row.setChosaJikanwaku10(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                    row.setHiddenChosaJikanwaku10(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                } else if (処理区分_更新.equals(処理区分)) {
                    row.setChosaJikanwaku10(予定開始時間と予定終了時間(認定調査予定開始時間, 認定調査予定終了時間));
                }
                break;
            default:
                break;
        }
    }

    /**
     * 認定調査スケジュール情報を編集します。
     *
     * @param 情報PK 情報PK
     * @return 認定調査スケジュール情報
     */
    public NinteichosaSchedule editNinteichosaSchedule(NinteichosaSchedule 情報PK) {
        return 情報PK.createBuilderForEdit().
                set予約可能フラグ(is予約可能フラグ(div.getRadYoyaku().getSelectedKey()))
                .set備考(div.getTxtBiko().getValue())
                .set予約状況(new Code(予約状況_未定))
                .build();
    }

    private dgTimeScheduleList_Row 登録データの設定(
            FlexibleDate 予定日,
            FlexibleDate 予定年月日,
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        if (予定日.compareTo(予定年月日) == 0 && ボタン_登録.equals(ボタン)) {
            登録時間枠一と登録時間枠二(時間枠, row, ボタン);
            登録時間枠三と登録時間枠四(時間枠, row, ボタン);
            登録時間枠五と登録時間枠六(時間枠, row, ボタン);
            登録時間枠七と登録時間枠八(時間枠, row, ボタン);
            登録時間枠九と登録時間枠十(時間枠, row, ボタン);
        } else if (予定日.compareTo(予定年月日) == 0 && ボタン_削除.equals(ボタン)) {
            削除時間枠一と削除時間枠二(時間枠, row, ボタン);
            削除時間枠三と削除時間枠四(時間枠, row, ボタン);
            削除時間枠五と削除時間枠六(時間枠, row, ボタン);
            削除時間枠七と削除時間枠八(時間枠, row, ボタン);
            削除時間枠九と削除時間枠十(時間枠, row, ボタン);
        }
        return row;
    }

    private void 登録時間枠一と登録時間枠二(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                row.setChosaJikanwaku01(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku01Edit().setVisible(true);
                row.setYoyakuJokyo01(予約状況_未定);
                row.setYoyakuKaoFlag01(div.getRadYoyaku().getSelectedKey());
                row.setBiko01(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben01(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_2:
                row.setChosaJikanwaku02(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku02Edit().setVisible(true);
                row.setYoyakuJokyo02(予約状況_未定);
                row.setYoyakuKaoFlag02(div.getRadYoyaku().getSelectedKey());
                row.setBiko02(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben02(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 登録時間枠三と登録時間枠四(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                row.setChosaJikanwaku03(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku03Edit().setVisible(true);
                row.setYoyakuJokyo03(予約状況_未定);
                row.setYoyakuKaoFlag03(div.getRadYoyaku().getSelectedKey());
                row.setBiko03(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben03(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_4:
                row.setChosaJikanwaku04(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku04Edit().setVisible(true);
                row.setYoyakuJokyo04(予約状況_未定);
                row.setYoyakuKaoFlag04(div.getRadYoyaku().getSelectedKey());
                row.setBiko04(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben04(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 登録時間枠五と登録時間枠六(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                row.setChosaJikanwaku05(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku05Edit().setVisible(true);
                row.setYoyakuJokyo05(予約状況_未定);
                row.setYoyakuKaoFlag05(div.getRadYoyaku().getSelectedKey());
                row.setBiko05(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben05(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_6:
                row.setChosaJikanwaku06(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku06Edit().setVisible(true);
                row.setYoyakuJokyo06(予約状況_未定);
                row.setYoyakuKaoFlag06(div.getRadYoyaku().getSelectedKey());
                row.setBiko06(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben06(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 登録時間枠七と登録時間枠八(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                row.setChosaJikanwaku07(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku07Edit().setVisible(true);
                row.setYoyakuJokyo07(予約状況_未定);
                row.setYoyakuKaoFlag07(div.getRadYoyaku().getSelectedKey());
                row.setBiko07(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben07(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_8:
                row.setChosaJikanwaku08(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku08Edit().setVisible(true);
                row.setYoyakuJokyo08(予約状況_未定);
                row.setYoyakuKaoFlag08(div.getRadYoyaku().getSelectedKey());
                row.setBiko08(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben08(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 登録時間枠九と登録時間枠十(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                row.setChosaJikanwaku09(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku09Edit().setVisible(true);
                row.setYoyakuJokyo09(予約状況_未定);
                row.setYoyakuKaoFlag09(div.getRadYoyaku().getSelectedKey());
                row.setBiko09(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben09(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_10:
                row.setChosaJikanwaku10(予定時間(
                        new RString(div.getTxtKaishiJikan().getValue().toString()),
                        new RString(div.getTxtShuryoJikan().getValue().toString())));
                row.getChosaJikanwaku10Edit().setVisible(true);
                row.setYoyakuJokyo10(予約状況_未定);
                row.setYoyakuKaoFlag10(div.getRadYoyaku().getSelectedKey());
                row.setBiko10(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben10(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                登録(時間枠, row, get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 登録(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        登録時間枠一と二(時間枠, row, 処理区分);
        登録時間枠三と四(時間枠, row, 処理区分);
        登録時間枠五と六(時間枠, row, 処理区分);
        登録時間枠七と八(時間枠, row, 処理区分);
        登録時間枠九と十(時間枠, row, 処理区分);
    }

    private void 登録時間枠一と二(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku01(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            case 時間枠_2:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku02(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            default:
                break;
        }
    }

    private void 登録時間枠三と四(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku03(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            case 時間枠_4:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku04(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            default:
                break;
        }
    }

    private void 登録時間枠五と六(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku05(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            case 時間枠_6:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku06(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            default:
                break;
        }
    }

    private void 登録時間枠七と八(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku07(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            case 時間枠_8:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku08(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            default:
                break;
        }
    }

    private void 登録時間枠九と十(RString 時間枠,
            dgTimeScheduleList_Row row,
            RString 処理区分) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku09(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            case 時間枠_10:
                if (!処理区分_更新.equals(処理区分)) {
                    row.setHiddenChosaJikanwaku10(予定時間(new RString(div.getTxtKaishiJikan().getValue().toString()),
                            new RString(div.getTxtShuryoJikan().getValue().toString())));
                }
                break;
            default:
                break;
        }
    }

    private void 削除時間枠一と削除時間枠二(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                row.setChosaJikanwaku01(RString.EMPTY);
                row.getChosaJikanwaku01Edit().setVisible(true);
                row.setYoyakuJokyo01(予約状況_未定);
                row.setYoyakuKaoFlag01(RString.EMPTY);
                row.setBiko01(RString.EMPTY);
                row.setSyoriKben01(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_2:
                row.setChosaJikanwaku02(RString.EMPTY);
                row.getChosaJikanwaku02Edit().setVisible(true);
                row.setYoyakuJokyo02(予約状況_未定);
                row.setYoyakuKaoFlag02(RString.EMPTY);
                row.setBiko02(RString.EMPTY);
                row.setSyoriKben02(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 削除時間枠三と削除時間枠四(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                row.setChosaJikanwaku03(RString.EMPTY);
                row.getChosaJikanwaku03Edit().setVisible(true);
                row.setYoyakuJokyo03(予約状況_未定);
                row.setYoyakuKaoFlag03(RString.EMPTY);
                row.setBiko03(RString.EMPTY);
                row.setSyoriKben03(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_4:
                row.setChosaJikanwaku04(RString.EMPTY);
                row.getChosaJikanwaku04Edit().setVisible(true);
                row.setYoyakuJokyo04(予約状況_未定);
                row.setYoyakuKaoFlag04(RString.EMPTY);
                row.setBiko04(RString.EMPTY);
                row.setSyoriKben04(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 削除時間枠五と削除時間枠六(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                row.setChosaJikanwaku05(RString.EMPTY);
                row.getChosaJikanwaku05Edit().setVisible(true);
                row.setYoyakuJokyo05(予約状況_未定);
                row.setYoyakuKaoFlag05(div.getRadYoyaku().getSelectedKey());
                row.setBiko05(nullToEmpty(div.getTxtBiko().getValue()));
                row.setSyoriKben05(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_6:
                row.setChosaJikanwaku06(RString.EMPTY);
                row.getChosaJikanwaku06Edit().setVisible(true);
                row.setYoyakuJokyo06(予約状況_未定);
                row.setYoyakuKaoFlag06(RString.EMPTY);
                row.setBiko06(RString.EMPTY);
                row.setSyoriKben06(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 削除時間枠七と削除時間枠八(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                row.setChosaJikanwaku07(RString.EMPTY);
                row.getChosaJikanwaku07Edit().setVisible(true);
                row.setYoyakuJokyo07(予約状況_未定);
                row.setYoyakuKaoFlag07(RString.EMPTY);
                row.setBiko07(RString.EMPTY);
                row.setSyoriKben07(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_8:
                row.setChosaJikanwaku08(RString.EMPTY);
                row.getChosaJikanwaku08Edit().setVisible(true);
                row.setYoyakuJokyo08(予約状況_未定);
                row.setYoyakuKaoFlag08(RString.EMPTY);
                row.setBiko08(RString.EMPTY);
                row.setSyoriKben08(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void 削除時間枠九と削除時間枠十(
            RString 時間枠,
            dgTimeScheduleList_Row row,
            RString ボタン) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                row.setChosaJikanwaku09(RString.EMPTY);
                row.getChosaJikanwaku09Edit().setVisible(true);
                row.setYoyakuJokyo09(予約状況_未定);
                row.setYoyakuKaoFlag09(RString.EMPTY);
                row.setBiko09(RString.EMPTY);
                row.setSyoriKben09(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            case 時間枠_10:
                row.setChosaJikanwaku10(RString.EMPTY);
                row.getChosaJikanwaku10Edit().setVisible(true);
                row.setYoyakuJokyo10(予約状況_未定);
                row.setYoyakuKaoFlag10(RString.EMPTY);
                row.setBiko10(RString.EMPTY);
                row.setSyoriKben10(get処理区分(div.getMainPanel().getSettingDetail().getHensyuTajyo(), ボタン));
                break;
            default:
                break;
        }
    }

    private void set認定調査データ(
            FlexibleDate 予定年月日,
            List<NinteiChosainBusiness> 認定調査情報,
            dgTimeScheduleList_Row row) {
        for (NinteiChosainBusiness 認定調査データ : 認定調査情報) {
            if (認定調査データ.get認定調査予定年月日().compareTo(予定年月日) == 0) {
                switch (Integer.parseInt(認定調査データ.get認定調査時間枠().getColumnValue().toString())) {
                    case 時間枠_1:
                        row.setChosaJikanwaku01(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku01Edit().setVisible(true);
                        row.setYoyakuJokyo01(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag01(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko01(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku01(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_2:
                        row.setChosaJikanwaku02(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku02Edit().setVisible(true);
                        row.setYoyakuJokyo02(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag02(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko02(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku02(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_3:
                        row.setChosaJikanwaku03(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku03Edit().setVisible(true);
                        row.setYoyakuJokyo03(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag03(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko03(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku03(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_4:
                        row.setChosaJikanwaku04(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku04Edit().setVisible(true);
                        row.setYoyakuJokyo04(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag04(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko04(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku04(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_5:
                        row.setChosaJikanwaku05(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku05Edit().setVisible(true);
                        row.setYoyakuJokyo05(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag05(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko05(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku05(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_6:
                        row.setChosaJikanwaku06(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku06Edit().setVisible(true);
                        row.setYoyakuJokyo06(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag06(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko06(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku06(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_7:
                        row.setChosaJikanwaku07(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku07Edit().setVisible(true);
                        row.setYoyakuJokyo07(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag07(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko07(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku07(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_8:
                        row.setChosaJikanwaku08(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku08Edit().setVisible(true);
                        row.setYoyakuJokyo08(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag08(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko08(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku08(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_9:
                        row.setChosaJikanwaku09(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku09Edit().setVisible(true);
                        row.setYoyakuJokyo09(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag09(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko09(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku09(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    case 時間枠_10:
                        row.setChosaJikanwaku10(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        row.getChosaJikanwaku10Edit().setVisible(true);
                        row.setYoyakuJokyo10(認定調査データ.get予約状況().getColumnValue());
                        row.setYoyakuKaoFlag10(get予約可能フラグ(認定調査データ.is予約可能フラグ()));
                        row.setBiko10(nullToEmpty(認定調査データ.get備考()));
                        row.setHiddenChosaJikanwaku10(予定開始時間と予定終了時間(
                                認定調査データ.get認定調査予定開始時間(),
                                認定調査データ.get認定調査予定終了時間()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void 初期化一覧(FlexibleDate システム年月) {
        List<dgTimeScheduleList_Row> rowList = new ArrayList<>();
        Seireki date2 = システム年月.seireki();
        for (int i = 1; i < (システム年月.getLastDay() + 1); i++) {
            システム年月 = new FlexibleDate(
                    Integer.parseInt(date2.getYear().toString()),
                    Integer.parseInt(date2.getMonth().toString()), i);
            dgTimeScheduleList_Row row = new dgTimeScheduleList_Row();
            row.setDate(new RString(Integer.toString(i)));
            row.setDay(new RString(システム年月.getDayOfWeek().getMiddleTerm().substring(0, 1)));
            row.setChosaJikanwaku01(RString.EMPTY);
            row.getChosaJikanwaku01Edit().setVisible(false);
            row.setChosaJikanwaku02(RString.EMPTY);
            row.getChosaJikanwaku02Edit().setVisible(false);
            row.setChosaJikanwaku03(RString.EMPTY);
            row.getChosaJikanwaku03Edit().setVisible(false);
            row.setChosaJikanwaku04(RString.EMPTY);
            row.getChosaJikanwaku04Edit().setVisible(false);
            row.setChosaJikanwaku05(RString.EMPTY);
            row.getChosaJikanwaku05Edit().setVisible(false);
            row.setChosaJikanwaku06(RString.EMPTY);
            row.getChosaJikanwaku06Edit().setVisible(false);
            row.setChosaJikanwaku07(RString.EMPTY);
            row.getChosaJikanwaku07Edit().setVisible(false);
            row.setChosaJikanwaku08(RString.EMPTY);
            row.getChosaJikanwaku08Edit().setVisible(false);
            row.setChosaJikanwaku09(RString.EMPTY);
            row.getChosaJikanwaku09Edit().setVisible(false);
            row.setChosaJikanwaku10(RString.EMPTY);
            row.getChosaJikanwaku10Edit().setVisible(false);
            row.setYoyakuJokyo01(RString.EMPTY);
            row.setYoyakuJokyo02(RString.EMPTY);
            row.setYoyakuJokyo03(RString.EMPTY);
            row.setYoyakuJokyo04(RString.EMPTY);
            row.setYoyakuJokyo05(RString.EMPTY);
            row.setYoyakuJokyo06(RString.EMPTY);
            row.setYoyakuJokyo07(RString.EMPTY);
            row.setYoyakuJokyo08(RString.EMPTY);
            row.setYoyakuJokyo09(RString.EMPTY);
            row.setYoyakuJokyo10(RString.EMPTY);
            row.setYoyakuKaoFlag01(RString.EMPTY);
            row.setYoyakuKaoFlag02(RString.EMPTY);
            row.setYoyakuKaoFlag03(RString.EMPTY);
            row.setYoyakuKaoFlag04(RString.EMPTY);
            row.setYoyakuKaoFlag05(RString.EMPTY);
            row.setYoyakuKaoFlag06(RString.EMPTY);
            row.setYoyakuKaoFlag07(RString.EMPTY);
            row.setYoyakuKaoFlag08(RString.EMPTY);
            row.setYoyakuKaoFlag09(RString.EMPTY);
            row.setYoyakuKaoFlag10(RString.EMPTY);
            row.setBiko01(RString.EMPTY);
            row.setBiko02(RString.EMPTY);
            row.setBiko03(RString.EMPTY);
            row.setBiko04(RString.EMPTY);
            row.setBiko05(RString.EMPTY);
            row.setBiko06(RString.EMPTY);
            row.setBiko07(RString.EMPTY);
            row.setBiko08(RString.EMPTY);
            row.setBiko09(RString.EMPTY);
            row.setBiko10(RString.EMPTY);
            row.setHiddenChosaJikanwaku01(RString.EMPTY);
            row.setHiddenChosaJikanwaku02(RString.EMPTY);
            row.setHiddenChosaJikanwaku03(RString.EMPTY);
            row.setHiddenChosaJikanwaku04(RString.EMPTY);
            row.setHiddenChosaJikanwaku05(RString.EMPTY);
            row.setHiddenChosaJikanwaku06(RString.EMPTY);
            row.setHiddenChosaJikanwaku07(RString.EMPTY);
            row.setHiddenChosaJikanwaku08(RString.EMPTY);
            row.setHiddenChosaJikanwaku09(RString.EMPTY);
            row.setHiddenChosaJikanwaku10(RString.EMPTY);
            set背景色の編集(システム年月, row);
            rowList.add(row);
        }
        div.getDgTimeScheduleList().setDataSource(rowList);
        div.getMainPanel().getBtnNinteiChosaIkkatsuInput().setDisabled(true);
    }

    private void 初期化状態の設定() {
        div.getTxtSettingMonth().setDisabled(true);
        div.getBtnPrevious().setVisible(true);
        div.getBtnNext().setVisible(true);
        div.getBtnSearch().setVisible(true);
    }

    private void 時間枠設定閉じている() {
        div.getMainPanel().getSettingDetail().getTxtBiko().clearValue();
        div.getMainPanel().getSettingDetail().setDisplayNone(true);
    }

    private RString 予定開始時間と予定終了時間(RString 認定調査予定開始時間, RString 認定調査予定終了時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(認定調査予定開始時間.substring(0, 予定時間_始))
                .append(":")
                .append(認定調査予定開始時間.substring(予定時間_始, 予定時間_終))
                .append("-")
                .append(認定調査予定終了時間.substring(0, 予定時間_始))
                .append(":")
                .append(認定調査予定終了時間.substring(予定時間_始, 予定時間_終)).toRString();
    }

    private RString 予定時間(RString 認定調査予定開始時間, RString 認定調査予定終了時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(認定調査予定開始時間.substring(0, 時間_終))
                .append("-")
                .append(認定調査予定終了時間.substring(0, 時間_終)).toRString();
    }

    private void set背景色の編集(FlexibleDate システム年月, dgTimeScheduleList_Row row) {
        if (システム年月.getDayOfWeek() == DayOfWeek.SATURDAY) {
            row.setRowBgColor(DataGridCellBgColor.bgColorLightGreen);
        }
        if (システム年月.getDayOfWeek() == DayOfWeek.SUNDAY) {
            row.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
        }
        if (new RDate(システム年月.toString()).isNationalHoliday()) {
            row.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
        }
    }

    private RString 開始_終了時間の取得(RString 時間枠) {
        RString 開始_終了時間 = RString.EMPTY;
        RDate 適用基準日 = RDate.getNowDate();
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠1, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_2:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠2, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_3:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠3, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_4:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠4, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_5:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠5, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_6:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠6, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_7:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠7, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_8:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠8, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_9:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠9, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            case 時間枠_10:
                開始_終了時間 = DbBusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠10, 適用基準日, SubGyomuCode.DBE認定支援);
                break;
            default:
                break;
        }
        return 開始_終了時間;
    }

    private void set編集の状態() {
        div.getDdlTaishoChiku().setDisabled(true);
        div.getTxtSettingMonth().setDisabled(true);
        div.getBtnPrevious().setDisabled(true);
        div.getBtnNext().setDisabled(true);
        div.getBtnSearch().setDisabled(true);
        div.getDgTimeScheduleList().setReadOnly(true);
        div.getMainPanel().getBtnNinteiChosaIkkatsuInput().setDisabled(true);
        div.getMainPanel().getSettingDetail().setDisplayNone(false);
    }

    private boolean is予約可能フラグ(RString 予約可能フラグ) {
        return 予約フラグ_可.equals(予約可能フラグ);
    }

    private RString get予約可能フラグ(boolean 予約可能フラグ) {
        if (予約可能フラグ) {
            return 予約フラグ_可;
        }
        return 予約フラグ_不可;
    }

    private RString nullToEmpty(RString データ) {
        if (データ == null || データ.isEmpty()) {
            return RString.EMPTY;
        }
        return データ;
    }

    private RString get処理区分(RString 編集状態, RString ボタン) {
        if (ボタン_登録.equals(ボタン)) {
            if (編集状態_既存.equals(編集状態)) {
                return 処理区分_更新;
            } else {
                return 処理区分_新規;
            }
        } else {
            if (編集状態_既存.equals(編集状態)) {
                return 処理区分_削除;
            }
        }
        return 処理区分_未処理;
    }

    private List<KeyValueDataSource> get調査地区ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList();
        List<ChikuShichoson> chikuShichosonList = NinteiChosainJikanMasterManager.createInstance().
                getChikuShichosonList().records();
        for (ChikuShichoson chikuShichoson : chikuShichosonList) {
            dataSource.add(調査地区ドロップダウンリスト(chikuShichoson.get調査地区コード()));
        }
        return dataSource;
    }

    private KeyValueDataSource 調査地区ドロップダウンリスト(Code 調査地区コード) {
        FlexibleDate 基准日 = new FlexibleDate(RDate.getNowDate().toDateString());
        UzT0007CodeEntity 指定調査地区 = CodeMaster.getCode(SubGyomuCode.DBE認定支援,
                DBECodeShubetsu.調査地区コード.getコード(), 調査地区コード, 基准日);
        KeyValueDataSource keyValue = new KeyValueDataSource();
        keyValue.setKey(指定調査地区.getコード().value());
        keyValue.setValue(指定調査地区.getコード名称());
        return keyValue;
    }

    private void 編集時間枠一と時間枠二(dgTimeScheduleList_Row row, RString 時間枠) {
        RString 編集時間開始時間;
        RString 編集時間終了時間;
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                編集時間開始時間 = row.getChosaJikanwaku01().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku01().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));
                break;
            case 時間枠_2:
                編集時間開始時間 = row.getChosaJikanwaku02().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku02().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));

                break;
            default:
                break;
        }
    }

    private void 編集時間枠三と時間枠四(dgTimeScheduleList_Row row, RString 時間枠) {
        RString 編集時間開始時間;
        RString 編集時間終了時間;
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                編集時間開始時間 = row.getChosaJikanwaku03().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku03().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));
                break;
            case 時間枠_4:
                編集時間開始時間 = row.getChosaJikanwaku04().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku04().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));

                break;
            default:
                break;
        }
    }

    private void 編集時間枠五と時間枠六(dgTimeScheduleList_Row row, RString 時間枠) {
        RString 編集時間開始時間;
        RString 編集時間終了時間;
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                編集時間開始時間 = row.getChosaJikanwaku05().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku05().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));
                break;
            case 時間枠_6:
                編集時間開始時間 = row.getChosaJikanwaku06().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku06().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));

                break;
            default:
                break;
        }
    }

    private void 編集時間枠七と時間枠八(dgTimeScheduleList_Row row, RString 時間枠) {
        RString 編集時間開始時間;
        RString 編集時間終了時間;
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                編集時間開始時間 = row.getChosaJikanwaku07().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku07().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));
                break;
            case 時間枠_8:
                編集時間開始時間 = row.getChosaJikanwaku08().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku08().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));

                break;
            default:
                break;
        }
    }

    private void 編集時間枠九と時間枠十(dgTimeScheduleList_Row row, RString 時間枠) {
        RString 編集時間開始時間;
        RString 編集時間終了時間;
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                編集時間開始時間 = row.getChosaJikanwaku09().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku09().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));
                break;
            case 時間枠_10:
                編集時間開始時間 = row.getChosaJikanwaku10().split("-").get(0);
                編集時間終了時間 = row.getChosaJikanwaku10().split("-").get(1);
                div.getTxtKaishiJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間開始時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間開始時間.split(":").get(1).toString())));
                div.getTxtShuryoJikan().setValue(RTime.of(
                        Integer.parseInt(編集時間終了時間.split(":").get(0).toString()),
                        Integer.parseInt(編集時間終了時間.split(":").get(1).toString())));

                break;
            default:
                break;
        }
    }
}
