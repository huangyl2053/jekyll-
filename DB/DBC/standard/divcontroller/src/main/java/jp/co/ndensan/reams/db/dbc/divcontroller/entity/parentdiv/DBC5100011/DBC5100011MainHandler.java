/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150010.DBC150010_RiyojokyoTokeihyoMeisaiListParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ShutsuryokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_CSVEditKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.core.chiku.ChikuShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * [利用状況統計表（明細リスト）作成]のHandlerクラスです。
 *
 * @reamsid_L DBC-3500-010 jinjue
 */
public class DBC5100011MainHandler {

    private final DBC5100011MainDiv div;
    private static final RString 対象選択_2 = new RString("2");
    private static final RString 対象選択_1 = new RString("1");
    private static final RString 対象選択_0 = new RString("0");
    private static final int ENDINDEX = 10;
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString 被保険者 = new RString("被保険者");
    private static final RString 文字_全て = new RString("全て");
    private static final RString 文字_町域 = new RString("町域");
    private static final RString KEY_全て = new RString("0");
    private static final RString KEY_町域 = new RString("1");
    private static final RString KEY_行政区 = new RString("2");
    private static final RString KEY_地区1 = new RString("3");
    private static final RString KEY_地区2 = new RString("4");
    private static final RString KEY_地区3 = new RString("5");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_2 = new RString("2");
    private static final RString KEY_3 = new RString("3");

    /**
     * コンストラクタです。
     *
     * @param div DBC5100011MainDiv
     */
    public DBC5100011MainHandler(DBC5100011MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        ViewStateHolder.put(ViewStateKeys.被保険者, 被保険者);
        div.getCcdJigyoshaNo().initialize();
        div.getCcdChikuShichosonSelect().initialize();
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200004.getReportId());
        div.getTxtHihokenshaNo().setValue(RString.EMPTY);
        div.getTxtTaishoYmRange().setMaxDateString(RString.EMPTY);
        div.getTxtTaishoYmRange().setMinDateString(RString.EMPTY);
        div.getTxtKyotakuRiyoritsuRange().setDisabled(true);
        div.getTxtHomonRiyoritsuRange().setDisabled(true);
    }

    /**
     * バッチパラメータの設定です。
     *
     * @return バッチパラメータ
     */
    public DBC150010_RiyojokyoTokeihyoMeisaiListParameter getTempData() {
        DBC150010_RiyojokyoTokeihyoMeisaiListParameter tempData = new DBC150010_RiyojokyoTokeihyoMeisaiListParameter();

        if (div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo() != null) {
            tempData.set事業者番号(div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo());
            tempData.set事業者名称(div.getCcdJigyoshaNo().getNyuryokuShisetsuMeisho());
        }
        tempData.set利用実績区分(div.getRadRiyoJisseki().getSelectedKey());
        RString 地区指定 = RString.EMPTY;
        if (文字_全て.equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_全て;
        } else if (文字_町域.equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_町域;
        } else if (ChikuShubetsu.行政区.getShubetsu().equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_行政区;
        } else if (ChikuShubetsu.地区1.getShubetsu().equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_地区1;
        } else if (ChikuShubetsu.地区2.getShubetsu().equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_地区2;
        } else if (ChikuShubetsu.地区3.getShubetsu().equals(div.getCcdChikuShichosonSelect().get選択対象())) {
            地区指定 = KEY_地区3;
        }
        tempData.set地区指定(地区指定);
        tempData.set市町村コード(div.getCcdChikuShichosonSelect().get市町村コード());
        tempData.set市町村名称(div.getCcdChikuShichosonSelect().get市町村名称());
        tempData.set旧市町村コード(div.getCcdChikuShichosonSelect().get旧市町村コード());
        tempData.set旧市町村名称(div.getCcdChikuShichosonSelect().get旧市町村名称());
        if (div.getCcdChikuShichosonSelect().get選択結果() != null) {
            tempData.set選択地区リスト(div.getCcdChikuShichosonSelect().get選択結果());
        }
        tempData.set導入形態コード(DonyuKeitaiCode.toValue(div.getCcdChikuShichosonSelect().get導入形態コード()).getCode());
        tempData.set対象年月(div.getRadTaishoYM().getSelectedKey());
        tempData.set居宅利用率指定(div.getRadKyotakuRiyoritsu().getSelectedKey());
        if (div.getChkMeisaiCsvEdit().getSelectedKeys() != null && div.getChkMeisaiCsvEdit().getSelectedKeys().contains(KEY_3)) {
            tempData.set日付スラッシュ編集(Tokeihyo_CSVEditKubun.する.getコード());
        } else {
            tempData.set日付スラッシュ編集(Tokeihyo_CSVEditKubun.しない.getコード());
        }
        if (div.getChkShutsuryokuTaisho().getSelectedKeys() != null && div.getChkShutsuryokuTaisho().getSelectedKeys().contains(KEY_3)) {
            tempData.set明細CSV出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        } else {
            tempData.set明細CSV出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        }
        if (div.getChkMeisaiCsvEdit().getSelectedKeys() != null && div.getChkMeisaiCsvEdit().getSelectedKeys().contains(KEY_2)) {
            tempData.set連番付加(Tokeihyo_CSVEditKubun.する.getコード());
        } else {
            tempData.set連番付加(Tokeihyo_CSVEditKubun.しない.getコード());
        }
        if (div.getChkShutsuryokuTaisho().getSelectedKeys() != null && div.getChkShutsuryokuTaisho().getSelectedKeys().contains(KEY_2)) {
            tempData.set明細リスト出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        } else {
            tempData.set明細リスト出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        }
        if (div.getTxtKyotakuRiyoritsuRange().getToValue() != null) {
            tempData.set終了居宅利用率(new RString(div.getTxtKyotakuRiyoritsuRange().getToValue().toString()));
        }
        if (div.getTxtTaishoYmRange().getToValue() != null) {
            tempData.set終了年月(div.getTxtTaishoYmRange().getToValue().getYearMonth().toDateString());
        }
        if (div.getTxtHomonRiyoritsuRange().getToValue() != null) {
            tempData.set終了訪問居宅利用率(new RString(div.getTxtHomonRiyoritsuRange().getToValue().toString()));
        }
        if (div.getChkShutsuryokuTaisho().getSelectedKeys() != null && div.getChkShutsuryokuTaisho().getSelectedKeys().contains(KEY_1)) {
            tempData.set統計表出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        } else {
            tempData.set統計表出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        }
        if (!RString.EMPTY.equals(div.getTxtHihokenshaNo().getValue())) {
            tempData.set被保険者番号(div.getTxtHihokenshaNo().getValue());
        }
        tempData.set訪問利用率指定(div.getRadHomonRiyoritsu().getSelectedKey());
        if (div.getTxtKyotakuRiyoritsuRange().getFromValue() != null) {
            tempData.set開始居宅利用率(new RString(div.getTxtKyotakuRiyoritsuRange().getFromValue().toString()));
        }
        if (div.getTxtTaishoYmRange().getFromValue() != null) {
            tempData.set開始年月(div.getTxtTaishoYmRange().getFromValue().getYearMonth().toDateString());
        }
        if (div.getTxtHomonRiyoritsuRange().getFromValue() != null) {
            tempData.set開始訪問居宅利用率(new RString(div.getTxtHomonRiyoritsuRange().getFromValue().toString()));
        }
        if (div.getChkMeisaiCsvEdit().getSelectedKeys() != null && div.getChkMeisaiCsvEdit().getSelectedKeys().contains(KEY_1)) {
            tempData.set項目名付加(Tokeihyo_CSVEditKubun.する.getコード());
        } else {
            tempData.set項目名付加(Tokeihyo_CSVEditKubun.しない.getコード());
        }
        if (div.getCcdChohyoShutsuryokujun().getSelected出力順() != null) {
            tempData.set出力順ID(div.getCcdChohyoShutsuryokujun().getSelected出力順().get出力順ID());
        } else {
            tempData.set出力順ID(null);
        }
        tempData.set明細合計出力区分(div.getRadMeisaiGokeiOut().getSelectedKey());
        return tempData;
    }

    /**
     * 対象年月入力項目制御です。
     */
    public void onChange_radTaishoYM() {
        if (div.getRadTaishoYM().getSelectedKey().equals(対象選択_2)) {
            div.getRiyojokyoJoken().setDisabled(true);
            div.getRadRiyoJisseki().setSelectedKey(対象選択_1);
            div.getRadKyotakuRiyoritsu().setSelectedKey(対象選択_0);
            div.getTxtKyotakuRiyoritsuRange().clearFromValue();
            div.getTxtKyotakuRiyoritsuRange().clearToValue();
            div.getRadHomonRiyoritsu().setSelectedKey(対象選択_0);
            div.getTxtHomonRiyoritsuRange().clearFromValue();
            div.getTxtHomonRiyoritsuRange().clearToValue();
        } else {
            div.getRiyojokyoJoken().setDisabled(false);
            if (対象選択_0.equals(div.getRadKyotakuRiyoritsu().getSelectedKey())) {
                div.getTxtKyotakuRiyoritsuRange().setDisabled(true);
            }
            if (対象選択_0.equals(div.getRadHomonRiyoritsu().getSelectedKey())) {
                div.getTxtHomonRiyoritsuRange().setDisabled(true);
            }
        }
    }

    /**
     * 居宅利用率入力項目制御です。
     */
    public void onChange_txtKyotakuRiyoritsuRange() {
        if (対象選択_0.equals(div.getRadKyotakuRiyoritsu().getSelectedKey())) {
            div.getTxtKyotakuRiyoritsuRange().clearFromValue();
            div.getTxtKyotakuRiyoritsuRange().clearToValue();
            div.getTxtKyotakuRiyoritsuRange().setDisabled(true);
        } else {
            div.getTxtKyotakuRiyoritsuRange().setDisabled(false);
        }
    }

    /**
     * 訪問利用率入力項目制御です。
     */
    public void onChange_txtHomonRiyoritsuRange() {
        if (対象選択_0.equals(div.getRadHomonRiyoritsu().getSelectedKey())) {
            div.getTxtHomonRiyoritsuRange().clearFromValue();
            div.getTxtHomonRiyoritsuRange().clearToValue();
            div.getTxtHomonRiyoritsuRange().setDisabled(true);
        } else {
            div.getTxtHomonRiyoritsuRange().setDisabled(false);
        }
    }

    /**
     * 被保険者番号入力項目制御です。
     */
    public void onBlur_txtHihokenshaNo() {
        if (!RString.EMPTY.equals(div.getTxtHihokenshaNo().getValue())) {
            RString 被保険者番号 = div.getTxtHihokenshaNo().getValue();
            div.getTxtHihokenshaNo().setValue(被保険者番号.padZeroToLeft(ENDINDEX));
        }
    }

    /**
     * 条件を復元します。
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 対象年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("対象年月"));
        div.getRadTaishoYM().setSelectedKey(対象年月);
        if (div.getRadTaishoYM().getSelectedKey().equals(対象選択_2)) {
            div.getRiyojokyoJoken().setDisabled(true);
        } else {
            div.getRiyojokyoJoken().setDisabled(false);
        }
        RString 開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始年月"));
        div.getTxtTaishoYmRange().setFromValue(RString.isNullOrEmpty(開始年月) ? null : new RDate(開始年月.toString()));
        RString 終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了年月"));
        div.getTxtTaishoYmRange().setToValue(RString.isNullOrEmpty(終了年月) ? null : new RDate(終了年月.toString()));
        RString 被保険者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("被保険者番号"));
        div.getTxtHihokenshaNo().setValue(被保険者番号);
        RString 事業者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("事業者番号"));
        div.getCcdJigyoshaNo().setNyuryokuShisetsuKodo(事業者番号);
        div.getCcdJigyoshaNo().get入所施設名称(new JigyoshaNo(事業者番号));
        RString 事業者名称 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("事業者名称"));
        div.getCcdJigyoshaNo().setShisetsuMeisho(事業者名称);
        RString 利用実績区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("利用実績区分"));
        div.getRadRiyoJisseki().setSelectedKey(利用実績区分);
        RString 居宅利用率指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("居宅利用率指定"));
        div.getRadKyotakuRiyoritsu().setSelectedKey(居宅利用率指定);
        if (対象選択_0.equals(居宅利用率指定)) {
            div.getTxtKyotakuRiyoritsuRange().setDisabled(true);
            div.getTxtKyotakuRiyoritsuRange().clearFromValue();
            div.getTxtKyotakuRiyoritsuRange().clearToValue();
        } else {
            RString 開始居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始居宅利用率"));
            div.getTxtKyotakuRiyoritsuRange().setDisabled(false);
            if (開始居宅利用率 != null && !RString.EMPTY.equals(開始居宅利用率)) {
                div.getTxtKyotakuRiyoritsuRange().setFromValue(new Decimal(開始居宅利用率.toString()));
            }
            RString 終了居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了居宅利用率"));
            if (終了居宅利用率 != null && !RString.EMPTY.equals(終了居宅利用率)) {
                div.getTxtKyotakuRiyoritsuRange().setToValue(new Decimal(終了居宅利用率.toString()));
            }
        }

        RString 訪問利用率指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("訪問利用率指定"));
        if (訪問利用率指定 != null && !RString.EMPTY.equals(訪問利用率指定)) {
            div.getRadHomonRiyoritsu().setSelectedKey(訪問利用率指定);
        }
        if (対象選択_0.equals(訪問利用率指定)) {
            div.getTxtHomonRiyoritsuRange().setDisabled(true);
            div.getTxtHomonRiyoritsuRange().clearFromValue();
            div.getTxtHomonRiyoritsuRange().clearToValue();
        } else {
            RString 開始訪問居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始訪問居宅利用率"));
            div.getTxtHomonRiyoritsuRange().setDisabled(false);
            if (開始訪問居宅利用率 != null && !RString.EMPTY.equals(開始訪問居宅利用率)) {
                div.getTxtHomonRiyoritsuRange().setFromValue(new Decimal(開始訪問居宅利用率.toString()));
            }
            RString 終了訪問居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了訪問居宅利用率"));
            if (終了訪問居宅利用率 != null && !RString.EMPTY.equals(終了訪問居宅利用率)) {
                div.getTxtHomonRiyoritsuRange().setToValue(new Decimal(終了訪問居宅利用率.toString()));
            }
        }

        RString 地区指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("地区指定"));
        Map<RString, RString> 選択地区リスト = restoreBatchParameterMap.getParameterValue(Map.class, new RString("選択地区リスト"));
        div.getCcdChikuShichosonSelect().initialize();
        RString 選択対象SelectKey = RString.EMPTY;
        if (!RString.isNullOrEmpty(地区指定)) {
            if (KEY_全て.equals(地区指定)) {
                選択対象SelectKey = 文字_全て;
            } else if (KEY_町域.equals(地区指定)) {
                選択対象SelectKey = 文字_町域;
            } else if (KEY_行政区.equals(地区指定)) {
                選択対象SelectKey = ChikuShubetsu.行政区.getShubetsu();
            } else if (KEY_地区1.equals(地区指定)) {
                選択対象SelectKey = ChikuShubetsu.地区1.getShubetsu();
            } else if (KEY_地区2.equals(地区指定)) {
                選択対象SelectKey = ChikuShubetsu.地区2.getShubetsu();
            } else if (KEY_地区3.equals(地区指定)) {
                選択対象SelectKey = ChikuShubetsu.地区3.getShubetsu();
            }
        }
        div.getCcdChikuShichosonSelect().initialize();
        div.getCcdChikuShichosonSelect().set選択対象(選択対象SelectKey);
        div.getCcdChikuShichosonSelect().onChange_選択対象DDL();
        div.getCcdChikuShichosonSelect().set選択結果(選択地区リスト);

        List<RString> 出力対象SelectedKeys = new ArrayList<>();
        RString 統計表出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("統計表出力区分"));
        RString 明細リスト出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細リスト出力区分"));
        RString 明細CSV出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細CSV出力区分"));
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(統計表出力区分)) {
            出力対象SelectedKeys.add(KEY_1);
        }
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(明細リスト出力区分)) {
            出力対象SelectedKeys.add(KEY_2);
        }
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(明細CSV出力区分)) {
            出力対象SelectedKeys.add(KEY_3);
        }
        div.getChkShutsuryokuTaisho().setSelectedItemsByKey(出力対象SelectedKeys);
        RString 明細合計出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細合計出力区分"));
        div.getRadMeisaiGokeiOut().setSelectedKey(明細合計出力区分);
        List<RString> 明細CSV編集SelectedKeys = new ArrayList<>();
        RString 項目名付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("項目名付加"));
        RString 連番付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("連番付加"));
        RString 日付スラッシュ編集 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("日付スラッシュ編集"));
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(項目名付加)) {
            明細CSV編集SelectedKeys.add(KEY_1);
        }
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(連番付加)) {
            明細CSV編集SelectedKeys.add(KEY_2);
        }
        if (Tokeihyo_CSVEditKubun.する.getコード().equals(日付スラッシュ編集)) {
            明細CSV編集SelectedKeys.add(KEY_3);
        }
        div.getChkMeisaiCsvEdit().setSelectedItemsByKey(明細CSV編集SelectedKeys);
        Long 出力順ID = restoreBatchParameterMap.getParameterValue(Long.class, new RString("出力順ID"));
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200004.getReportId(), 出力順ID);
    }
}
