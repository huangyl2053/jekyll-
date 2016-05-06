/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyorisutojyukyusyadaicho.HanyoRisutoJyukyusyaDaichoBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001.JukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1300001.JukyushaDaichoPanelHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト 受給者台帳２
 *
 * @reamsid_L DBD-1810-010 wanghui
 */
public class JukyushaDaichoPanel {

    private static final RString 抽出年月日 = new RString("0");
    private static final RString 医療機関 = new RString("1");
    private static final RString 調査委託先 = new RString("2");
    private static final RString BATCHID = new RString("HanyoRisutoJyukyusyaDaichoFlow");

    /**
     * onLoadの処理を行います。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<JukyushaDaichoPanelDiv> onLoad(JukyushaDaichoPanelDiv div) {
        //TODO 画面設計_DBZ_HanyoListAtenaSelect_【共有子Div】 汎用リスト宛名抽出条件実装しません。
        div.getCcdAtenaJoken().initialize();
        getHandler(div).initialize();
        return ResponseData.of(div).respond();

    }

    /**
     * 「抽出年月日」を選択した時、コントロールの制御。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<JukyushaDaichoPanelDiv> onChange_radChushutsuTaisho(JukyushaDaichoPanelDiv div) {
        if (抽出年月日.equals(div.getRadChushutsuTaisho().getSelectedKey())) {
            getHandler(div).set抽出年月日();
        } else if (医療機関.equals(div.getRadChushutsuTaisho().getSelectedKey())) {
            getHandler(div).set医療機関();
        } else if (調査委託先.equals(div.getRadChushutsuTaisho().getSelectedKey())) {
            getHandler(div).set調査委託先();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「抽出年月日」を選択した時、コントロールの制御。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<JukyushaDaichoPanelDiv> onChange_chkTorikeshiSakujo(JukyushaDaichoPanelDiv div) {
        getHandler(div).set抽出区分();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件を復元する」ボタンを押下時、バッチパラメータを復元します。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData onClick_btnBatchParameterRestore
     */
    public ResponseData<JukyushaDaichoPanelDiv> onClick_btnBatchParameterRestore(JukyushaDaichoPanelDiv div) {
        //TODO 技術点NO.65
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出データ区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出データ区分"));
        RString 申請取消データ抽出 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("申請取消データ抽出"));
        RString 削除データ抽出 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("削除データ抽出"));
        RString 喪失区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("喪失区分"));
        RString 抽出対象 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出対象"));
        RString 抽出日種類 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出日種類"));
        RString 抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出日From"));
        RString 抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出日To"));
        RString 医療機関コードFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("医療機関コードFrom"));
        RString 医療機関コードTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("医療機関コードTo"));
        RString 調査委託先コードFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("調査委託先コードFrom"));
        RString 調査委託先コードTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("調査委託先コードTo"));
        // TODO 宛名抽出条件DIVに項目設定無し、技術点NO.65
//        RString 宛名抽出条件 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("宛名抽出条件"));
//        RString 改頁出力順ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("改頁出力順ID"));
//        RString 出力項目ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力項目ID"));
//        RString 帳票ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("帳票ID"));
        RString 項目名付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("CSV項目名付加"));
        RString 連番付加 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("改頁出力順ID"));
        RString 日付スラッシュ編集 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("CSV日付スラッシュ編集"));
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(申請取消データ抽出);
        List<RString> selectKeys1 = new ArrayList<>();
        selectKeys1.add(削除データ抽出);
        div.getDdlChushutsuData().setSelectedValue(抽出データ区分);
        div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKeys);
        div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKeys1);
        div.getDdlSoushitsuKubun().setSelectedValue(喪失区分);
        div.getRadChushutsuTaisho().setSelectedValue(抽出対象);
        div.getDdlChushutsuYmd().setSelectedValue(抽出日種類);
        div.getTxtChushutsuYMD().setFromValue(new RDate(抽出日From.toString()));
        div.getTxtChushutsuYMD().setToValue(new RDate(抽出日To.toString()));
        div.getTxtIryokikan().setFromValue(new Decimal(医療機関コードFrom.toString()));
        div.getTxtIryokikan().setToValue(new Decimal(医療機関コードTo.toString()));
        div.getTxtChosaItakusaki().setFromValue(new Decimal(調査委託先コードFrom.toString()));
        div.getTxtChosaItakusaki().setToValue(new Decimal(調査委託先コードTo.toString()));
        div.getCcdAtenaJoken();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource source = new KeyValueDataSource();
        source.setKey(項目名付加);
        dataSource.add(source);
        KeyValueDataSource date = new KeyValueDataSource();
        date.setKey(連番付加);
        dataSource.add(date);
        KeyValueDataSource keyValue = new KeyValueDataSource();
        keyValue.setKey(日付スラッシュ編集);
        dataSource.add(date);
        div.getChkCsvHenshuHoho().setSelectedItems(dataSource);
        ResponseData<JukyushaDaichoPanelDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 「条件を保存する」ボタンを押下時、バッチパラメータを保存します。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(JukyushaDaichoPanelDiv div) {
        HanyoRisutoJyukyusyaDaichoBatchParameter parameter = new HanyoRisutoJyukyusyaDaichoBatchParameter();
        RString xx = new RString(SubGyomuCode.DBD介護受給.toString());
        div.getBatchParameterPanel().getBtnBatchParameterSave().setBatchId(BATCHID);
        div.getBtnBatchParameterSave().setSubGyomuCode(xx);
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(parameter);
        return responseData;
    }

    /**
     * 「実行する」を押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<HanyoRisutoJyukyusyaDaichoBatchParameter> onClick_jiko(JukyushaDaichoPanelDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private JukyushaDaichoPanelHandler getHandler(JukyushaDaichoPanelDiv div) {
        return new JukyushaDaichoPanelHandler(div);
    }

}
