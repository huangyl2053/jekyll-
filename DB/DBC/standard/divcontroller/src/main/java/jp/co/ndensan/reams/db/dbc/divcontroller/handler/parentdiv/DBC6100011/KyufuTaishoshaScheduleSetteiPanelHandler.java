/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.SofuTorikomiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.dgScheduleList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiKyufuTaishoshaScheduleSettei;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額介護サービス費給付対象者-スケジュール設定のハンドラクラスです。
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiPanelHandler {

    private final KyufuTaishoshaScheduleSetteiPanelDiv div;
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyufuTaishoshaScheduleSetteiPanelHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param スケジュール履歴情報 List
     */
    public void initialize(List<KokuhorenInterfaceKanri> スケジュール履歴情報) {
        List<dgScheduleList_Row> rowList = new ArrayList<>();
        dgScheduleList_Row row;
        if (スケジュール履歴情報.isEmpty()) {
            div.getDgScheduleList().setDataSource(rowList);
        } else {
            List<KeyValueDataSource> dataSource = getスケジュール設定一覧エリアDropDownList();
            for (KokuhorenInterfaceKanri 履歴情報 : スケジュール履歴情報) {
                row = new dgScheduleList_Row();
                row.setShoriNengetsu(履歴情報.get処理年月().wareki().toDateString());
                YMDHMS 抽出開始日時 = 履歴情報.get抽出開始日時();
                if (抽出開始日時 != null && !抽出開始日時.isEmpty()) {
                    row.setShinsaNengetsuFrom(抽出開始日時.wareki().toDateString());
                }
                YMDHMS 抽出終了日時 = 履歴情報.get抽出終了日時();
                if (抽出終了日時 != null && !抽出終了日時.isEmpty()) {
                    row.setShinsaNengetsuTo(抽出終了日時.wareki().toDateString());
                }
                row.getDdlShoriJokyo().setDataSource(dataSource);
                row.getDdlShoriJokyo().setSelectedKey(履歴情報.get処理状態区分());
                YMDHMS 処理実施日時 = 履歴情報.get処理実施日時();
                if (処理実施日時 != null && !処理実施日時.isEmpty()) {
                    RString 年月日 = 履歴情報.get処理実施日時().getDate().wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
                    RString 時分 = 履歴情報.get処理実施日時().getRDateTime().getTime().toFormattedTimeString(
                            DisplayTimeFormat.HH時mm分);
                    row.setShoriTimestamp(年月日.concat(RString.HALF_SPACE).concat(時分));
                }
                rowList.add(row);
            }
            div.getDgScheduleList().setDataSource(rowList);
        }
        set最新処理年月入力エリア状態(true);
    }

    /**
     * 最新処理年月入力エリア状態設定のメソッドです。
     *
     * @param 操作可否Flag boolean
     */
    public void set最新処理年月入力エリア状態(boolean 操作可否Flag) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        div.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getBtnTorikeshi().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getBtnKakutei().setDisabled(操作可否Flag);

        div.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu().clearDomain();
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom().clearDomain();
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo().clearDomain();
        if (操作可否Flag) {
            div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDataSource(dataSource);
        } else {
            div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
            div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setSelectedIndex(NUM_0);
        }
    }

    private List<KeyValueDataSource> getスケジュール設定一覧エリアDropDownList() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ShoriJotaiKubun 処理状態区分 : ShoriJotaiKubun.values()) {
            dataSource.add(new KeyValueDataSource(処理状態区分.getコード(), 処理状態区分.get名称()));
        }
        return dataSource;
    }

    /**
     * 最新処理年月入力エリア．処理状況設定のメソッドです。
     *
     * @return dataSource DropDownList
     */
    public List<KeyValueDataSource> get最新処理年月入力エリアDropDownList() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理前.getコード(), ShoriJotaiKubun.処理前.get名称()));
        dataSource.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        return dataSource;
    }

    /**
     * 確定するボタンを押下のメソッドです。
     */
    public void set確定処理() {
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        dgScheduleList_Row row = new dgScheduleList_Row();
        FlexibleYearMonth 処理年月 = div.getTxtShoriNengetsu().getDomain();
        try {
            // TODO QA961
//            KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().shoriNenngetsuJuufukuCheck(
//                    ResponseHolder.getMenuID(), 処理年月);
            KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().shoriNenngetsuJuufukuCheck(
                    new RString("999"), 処理年月);
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
        row.setShoriNengetsu(処理年月.wareki().toDateString());
        row.setShinsaNengetsuFrom(div.getTxtShinsaNengetsuFrom().getDomain().wareki().toDateString());
        row.setShinsaNengetsuTo(div.getTxtShinsaNengetsuTo().getDomain().wareki().toDateString());
        row.getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
        row.getDdlShoriJokyo().setSelectedKey(div.getDdlShoriJokyo().getSelectedKey());
        rowList.add(NUM_0, row);
        set最新処理年月入力エリア状態(true);
    }

    /**
     * 保存処理のメソッドです。
     *
     * @param スケジュール履歴情報List List
     * @param 確認Flag boolean
     */
    public void save処理(List<KokuhorenInterfaceKanri> スケジュール履歴情報List, boolean 確認Flag) {
        List<KokuhorenInterfaceKanri> データ登録リスト = new ArrayList<>();
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        KokuhorenInterfaceKanri データ登録;
        FlexibleYearMonth 処理年月;
        RDate 処理年月Date;
        for (dgScheduleList_Row row : rowList) {
            処理年月Date = new RDate(row.getShoriNengetsu().toString());
            処理年月 = new FlexibleYearMonth(処理年月Date.getYearMonth().toDateString());
            データ登録 = get国保連インターフェース管理(スケジュール履歴情報List, 処理年月);
            if (データ登録 != null) {
                データ登録 = データ登録.createBuilderForEdit()
                        .set送付取込区分(SofuTorikomiKubun.それ以外.getコード())
                        .set処理状態区分(row.getDdlShoriJokyo().getSelectedKey())
                        .build();
                データ登録リスト.add(データ登録);
            } else {
                // TODO QA961
//                データ登録 = new KokuhorenInterfaceKanri(処理年月, ResponseHolder.getMenuID());
                データ登録 = new KokuhorenInterfaceKanri(処理年月, new RString("999"));
                RDate 開始日時 = new RDate(row.getShoriNengetsu().toString());
                RDate 終了日時 = new RDate(row.getShoriNengetsu().toString());
                YMDHMS 抽出開始日時 = new YMDHMS(開始日時, RTime.now());
                YMDHMS 抽出終了日時 = new YMDHMS(終了日時, RTime.now());
                データ登録 = データ登録.createBuilderForEdit()
                        .set送付取込区分(SofuTorikomiKubun.それ以外.getコード())
                        .set処理状態区分(row.getDdlShoriJokyo().getSelectedKey())
                        // TODO QA961
                        .set処理実施日時(YMDHMS.now())
                        .set抽出開始日時(抽出開始日時)
                        .set抽出終了日時(抽出終了日時)
                        .set再処理可能区分(Boolean.FALSE)
                        .set処理実行回数(Decimal.ZERO)
                        .set再処理設定不可区分(Boolean.FALSE)
                        .build();
                データ登録リスト.add(データ登録);
            }
        }
        // TODO QA961
//        KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().sukijyuruRirekiJyohoToroku(
//                ResponseHolder.getMenuID(), データ登録リスト, 確認Flag);
        KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().sukijyuruRirekiJyohoToroku(
                new RString("999"), データ登録リスト, 確認Flag);
    }

    private KokuhorenInterfaceKanri get国保連インターフェース管理(
            List<KokuhorenInterfaceKanri> スケジュール履歴情報List,
            FlexibleYearMonth 処理年月) {
        for (KokuhorenInterfaceKanri スケジュール履歴情報 : スケジュール履歴情報List) {
            if (処理年月.equals(スケジュール履歴情報.get処理年月())) {
                return スケジュール履歴情報;
            }
        }
        return null;
    }
}
