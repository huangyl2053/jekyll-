/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5100011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150010.DBC150010_RiyojokyoTokeihyoMeisaiListParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ShutsuryokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_CSVEditKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
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
    private static final int BEGININDEX = 0;
    private static final int ENDINDEX = 10;
    private static final RString 被保険者 = new RString("被保険者");

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
     *
     * @param div DBC5100011MainDiv
     * @return ResponseData<DBC5100011MainDiv>
     */
    public void onLoad() {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 被保険者);
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
        if (!div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo().isNullOrEmpty()) {
            tempData.set事業者番号(div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo());
        }
        tempData.set出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
        tempData.set利用実績区分(div.getRadRiyoJisseki().getSelectedKey());
        tempData.set地区指定(div.getCcdChikuShichosonSelect().get選択対象());
        tempData.set市町村コード(div.getCcdChikuShichosonSelect().get市町村コード());
        tempData.set市町村名称(div.getCcdChikuShichosonSelect().get市町村名称());
        tempData.set旧市町村コード(div.getCcdChikuShichosonSelect().get旧市町村コード());
        tempData.set旧市町村名称(div.getCcdChikuShichosonSelect().get旧市町村名称());
        tempData.set選択地区リスト(div.getCcdChikuShichosonSelect().get選択結果().get(Chiku.地区.getコード()));
        tempData.set導入形態コード(DonyuKeitaiCode.toValue(div.getCcdChikuShichosonSelect().get導入形態コード()).getCode());
        tempData.set対象年月(div.getRadTaishoYM().getSelectedKey());
        tempData.set居宅利用率指定(div.getRadKyotakuRiyoritsu().getSelectedValue());
        if (div.getChkShutsuryokuTaisho().getSelectedKeys().get(3).isNullOrEmpty()) {
            tempData.set日付スラッシュ編集(Tokeihyo_CSVEditKubun.しない.getコード());
        } else {
            tempData.set日付スラッシュ編集(Tokeihyo_CSVEditKubun.する.getコード());
        }

        if (div.getChkShutsuryokuTaisho().getSelectedKeys().get(3).isNullOrEmpty()) {
            tempData.set明細CSV出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        } else {
            tempData.set明細CSV出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        }
        if (div.getChkMeisaiCsvEdit().getSelectedKeys().get(2).isNullOrEmpty()) {
            tempData.set連番付加(Tokeihyo_CSVEditKubun.しない.getコード());
        } else {
            tempData.set連番付加(Tokeihyo_CSVEditKubun.する.getコード());
        }
        if (div.getChkShutsuryokuTaisho().getSelectedKeys().get(2).isNullOrEmpty()) {
            tempData.set明細リスト出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        } else {
            tempData.set明細リスト出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        }

        tempData.set終了居宅利用率(new RString(div.getTxtKyotakuRiyoritsuRange().getToValue().toString()));
        tempData.set終了年月(div.getTxtTaishoYmRange().getToValue().wareki().toDateString());
        tempData.set終了訪問居宅利用率(new RString(div.getTxtHomonRiyoritsuRange().getToValue().toString()));
        if (div.getChkShutsuryokuTaisho().getSelectedKeys().get(1).isNullOrEmpty()) {
            tempData.set統計表出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力しない.getコード());
        } else {
            tempData.set統計表出力区分(RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード());
        }
        if (!RString.EMPTY.equals(div.getTxtHihokenshaNo().getValue())) {
            tempData.set被保険者番号(div.getTxtHihokenshaNo().getValue());
        }
        tempData.set訪問利用率指定(div.getRadHomonRiyoritsu().getSelectedValue());
        tempData.set開始居宅利用率(new RString(div.getTxtKyotakuRiyoritsuRange().getFromValue().toString()));
        tempData.set開始年月(div.getTxtTaishoYmRange().getFromValue().wareki().toDateString());
        tempData.set開始訪問居宅利用率(new RString(div.getTxtHomonRiyoritsuRange().getFromValue().toString()));
        if (div.getChkMeisaiCsvEdit().getSelectedKeys().get(1).isNullOrEmpty()) {
            tempData.set項目名付加(Tokeihyo_CSVEditKubun.しない.getコード());
        } else {
            tempData.set項目名付加(Tokeihyo_CSVEditKubun.する.getコード());
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
            div.getTxtHihokenshaNo().setValue(div.getTxtHihokenshaNo().getValue().substring(BEGININDEX, ENDINDEX));
        }
    }

    /**
     * 条件を復元します。
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 対象年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("対象年月"));
        div.getRadTaishoYM().setSelectedKey(対象年月);
        RString 開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始年月"));
        div.getTxtTaishoYmRange().setFromValue(new RDate(開始年月.toString()));
        RString 終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了年月"));
        div.getTxtTaishoYmRange().setToValue(new RDate(終了年月.toString()));
        RString 被保険者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("被保険者番号"));
        div.getTxtHihokenshaNo().setValue(被保険者番号);
        RString 事業者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("事業者番号"));
        div.getCcdJigyoshaNo().setNyuryokuShisetsuKodo(事業者番号);
        RString 利用実績区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("利用実績区分"));
        div.getRadRiyoJisseki().setSelectedKey(利用実績区分);
        RString 居宅利用率指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("居宅利用率指定"));
        div.getRadKyotakuRiyoritsu().setSelectedKey(居宅利用率指定);
        RString 開始居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始居宅利用率"));
        div.getTxtKyotakuRiyoritsuRange().setFromValue(new Decimal(開始居宅利用率.toString()));
        RString 終了居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了居宅利用率"));
        div.getTxtKyotakuRiyoritsuRange().setToValue(new Decimal(終了居宅利用率.toString()));
        RString 訪問利用率指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("訪問利用率指定"));
        div.getRadHomonRiyoritsu().setSelectedKey(訪問利用率指定);
        RString 開始訪問居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("開始訪問居宅利用率"));
        div.getTxtHomonRiyoritsuRange().setFromValue(new Decimal(開始訪問居宅利用率.toString()));
        RString 終了訪問居宅利用率 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("終了訪問居宅利用率"));
        div.getTxtHomonRiyoritsuRange().setToValue(new Decimal(終了訪問居宅利用率.toString()));
        div.getCcdChikuShichosonSelect().initialize();
        List<RString> 明細list = new ArrayList<>();
        RString 統計表出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("統計表出力区分"));
        明細list.add(統計表出力区分);
        RString 明細リスト出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細リスト出力区分"));
        明細list.add(明細リスト出力区分);
        RString 明細CSV出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細CSV出力区分"));
        明細list.add(明細CSV出力区分);
        div.getChkShutsuryokuTaisho().setSelectedItemsByKey(明細list);
        RString 明細合計出力区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("明細合計出力区分"));
        div.getRadMeisaiGokeiOut().setSelectedKey(明細合計出力区分);
        List<RString> 項目名list = new ArrayList<>();
        RString 項目名付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("項目名付加"));
        項目名list.add(項目名付加);
        RString 連番付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("連番付加"));
        項目名list.add(連番付加);
        RString 日付スラッシュ編集 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("日付スラッシュ編集"));
        項目名list.add(日付スラッシュ編集);
        div.getChkMeisaiCsvEdit().setSelectedItemsByKey(項目名list);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200004.getReportId());
    }
}
