/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.SofuTorikomiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 高額介護サービス費給付対象者-スケジュール設定のハンドラクラスです。
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiPanelHandler {

    private final KyufuTaishoshaScheduleSetteiPanelDiv div;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final RString STR_ZERO = new RString("0");
    private static final RString STR_ONE = new RString("1");
    private static final RString 保存するKEY = new RString("btnUpdate");

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
        int index = NUM_0;
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
                row.setId(index);
                rowList.add(row);
                index = index + NUM_1;
            }
            div.getDgScheduleList().setDataSource(rowList);
        }
        div.setHdnFlag(STR_ZERO);
        set最新処理年月入力エリア状態(true);
        set最新処理年月入力エリア_初期化();
    }

    /**
     * 変更前処理状況取得のメソッドです。
     *
     * @return map 変更前処理状況
     */
    public Map<Integer, RString> get変更前処理状況() {
        Map<Integer, RString> map = new HashMap<>();
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        for (dgScheduleList_Row row : rowList) {
            map.put(row.getId(), row.getDdlShoriJokyo().getSelectedKey());
        }
        return map;
    }

    /**
     * 最新処理年月入力エリア状態設定のメソッドです。
     *
     * @param 操作可否Flag boolean
     */
    public void set最新処理年月入力エリア状態(boolean 操作可否Flag) {
        div.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getBtnTorikeshi().setDisabled(操作可否Flag);
        div.getSaishinShoriNengetsuNyuryoku().getBtnKakutei().setDisabled(操作可否Flag);
        div.getBtnAdd().setDisabled(!操作可否Flag);
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        for (dgScheduleList_Row row : rowList) {
            row.getDdlShoriJokyo().setDisabled(!操作可否Flag);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存するKEY, !操作可否Flag);
    }

    /**
     * 最新処理年月入力エリア初期化のメソッドです。
     */
    public void set最新処理年月入力エリア_初期化() {
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        RDate 処理年月Date;
        RDate 終了日時;
        FlexibleYearMonth 処理年月;
        FlexibleYearMonth 抽出終了日時;
        if (rowList != null && !rowList.isEmpty()) {
            dgScheduleList_Row row = rowList.get(NUM_0);
            処理年月Date = new RDate(row.getShoriNengetsu().toString());
            処理年月 = new FlexibleYearMonth(処理年月Date.getYearMonth().plusMonth(NUM_1).toDateString());
            div.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu().setDomain(処理年月);
            RString 終了Date = row.getShinsaNengetsuTo();
            if (終了Date != null && !終了Date.isEmpty()) {
                終了日時 = new RDate(終了Date.toString());
                抽出終了日時 = new FlexibleYearMonth(終了日時.getYearMonth().plusMonth(NUM_1).toDateString());
                div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom().setDomain(抽出終了日時);
                div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo().setDomain(抽出終了日時);
            }
        }
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setSelectedKey(ShoriJotaiKubun.処理前.getコード());
    }

    /**
     * 最新処理年月入力エリア２回目以降のメソッドです。
     */
    public void set最新処理年月入力エリア_２回目以降() {
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        RDate 処理年月Date;
        RDate 開始日時;
        RDate 終了日時;
        FlexibleYearMonth 処理年月;
        FlexibleYearMonth 抽出開始日時;
        FlexibleYearMonth 抽出終了日時;
        dgScheduleList_Row row = rowList.get(NUM_0);
        処理年月Date = new RDate(row.getShoriNengetsu().toString());
        処理年月 = new FlexibleYearMonth(処理年月Date.getYearMonth().toDateString());
        div.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu().setDomain(処理年月);
        開始日時 = new RDate(row.getShinsaNengetsuFrom().toString());
        抽出開始日時 = new FlexibleYearMonth(開始日時.getYearMonth().toDateString());
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom().setDomain(抽出開始日時);
        終了日時 = new RDate(row.getShinsaNengetsuTo().toString());
        抽出終了日時 = new FlexibleYearMonth(終了日時.getYearMonth().toDateString());
        div.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo().setDomain(抽出終了日時);
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
        div.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo().setSelectedKey(row.getDdlShoriJokyo().getSelectedKey());
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
     *
     * @param 交換情報識別番号 RString
     */
    public void set確定処理(RString 交換情報識別番号) {
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        dgScheduleList_Row row = new dgScheduleList_Row();
        FlexibleYearMonth 処理年月 = div.getTxtShoriNengetsu().getDomain();
        try {
            KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().shoriNenngetsuJuufukuCheck(
                    交換情報識別番号, 処理年月);
        } catch (ApplicationException e) {
            throw new ApplicationException(e.getMessage());
        }
        if (STR_ZERO.equals(div.getHdnFlag())) {
            row.setShoriNengetsu(処理年月.wareki().toDateString());
            row.setShinsaNengetsuFrom(div.getTxtShinsaNengetsuFrom().getDomain().wareki().toDateString());
            row.setShinsaNengetsuTo(div.getTxtShinsaNengetsuTo().getDomain().wareki().toDateString());
            row.getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
            row.getDdlShoriJokyo().setSelectedKey(div.getDdlShoriJokyo().getSelectedKey());
            rowList.add(NUM_0, row);
        } else {
            rowList.get(NUM_0).setShoriNengetsu(処理年月.wareki().toDateString());
            rowList.get(NUM_0).setShinsaNengetsuFrom(div.getTxtShinsaNengetsuFrom().getDomain().wareki().toDateString());
            rowList.get(NUM_0).setShinsaNengetsuTo(div.getTxtShinsaNengetsuTo().getDomain().wareki().toDateString());
            rowList.get(NUM_0).getDdlShoriJokyo().setDataSource(get最新処理年月入力エリアDropDownList());
            rowList.get(NUM_0).getDdlShoriJokyo().setSelectedKey(div.getDdlShoriJokyo().getSelectedKey());
        }
        int index = NUM_0;
        for (dgScheduleList_Row dgRow : rowList) {
            dgRow.setId(index);
            index = index + NUM_1;
        }
        set最新処理年月入力エリア状態(true);
        div.setHdnFlag(STR_ONE);
    }

    /**
     * 保存処理のメソッドです。
     *
     * @param スケジュール履歴情報List List
     * @param 確認Flag boolean
     * @param 交換情報識別番号 RString
     */
    public void save処理(List<KokuhorenInterfaceKanri> スケジュール履歴情報List,
            boolean 確認Flag,
            RString 交換情報識別番号) {
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
                        .set処理状態区分(row.getDdlShoriJokyo().getSelectedKey()).build();
                データ登録リスト.add(データ登録);
            } else {
                データ登録 = new KokuhorenInterfaceKanri(処理年月, 交換情報識別番号);
                データ登録 = データ登録.createBuilderForEdit()
                        .set送付取込区分(SofuTorikomiKubun.それ以外.getコード())
                        .set処理状態区分(row.getDdlShoriJokyo().getSelectedKey())
                        .set再処理可能区分(Boolean.FALSE)
                        .set処理実行回数(Decimal.ZERO)
                        .set再処理設定不可区分(Boolean.FALSE)
                        .build();
                データ登録リスト.add(データ登録);
            }
        }
        KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.createInstance().sukijyuruRirekiJyohoToroku(
                交換情報識別番号, データ登録リスト, 確認Flag);
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

    /**
     * 起動中チェックのメソッドです。
     */
    public void to起動中チェック() {
        List<dgScheduleList_Row> rowList = div.getDgScheduleList().getDataSource();
        for (dgScheduleList_Row row : rowList) {
            if (ShoriJotaiKubun.起動.getコード().equals(row.getDdlShoriJokyo().getSelectedKey())) {
                throw new ApplicationException(DbcErrorMessages.高額対象者抽出処理中.getMessage());
            }
        }
    }

    /**
     * 処理状況変更チェックのメソッドです。
     *
     * @param map 変更前処理状況
     */
    public void to処理状況変更チェック(Map<Integer, RString> map) {
        dgScheduleList_Row row = div.getDgScheduleList().getClickedItem();
        RString 変更前処理状況 = map.get(row.getId());
        RString 変更後処理状況 = row.getDdlShoriJokyo().getSelectedKey();
        if (!((変更前処理状況.equals(ShoriJotaiKubun.処理前.getコード())
                && 変更後処理状況.equals(ShoriJotaiKubun.処理なし.getコード()))
                || (変更前処理状況.equals(ShoriJotaiKubun.処理なし.getコード())
                && 変更後処理状況.equals(ShoriJotaiKubun.処理前.getコード()))
                || (変更前処理状況.equals(ShoriJotaiKubun.再処理前.getコード())
                && 変更後処理状況.equals(ShoriJotaiKubun.終了.getコード()))
                || (変更前処理状況.equals(ShoriJotaiKubun.終了.getコード())
                && 変更後処理状況.equals(ShoriJotaiKubun.再処理前.getコード())))) {
            throw new ApplicationException(DbcErrorMessages.設定不能状態への変更.getMessage());
        }
    }
}
