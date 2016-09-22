/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710020.DBD710020_HanyoListJukyushaDaicho2Parameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001.JukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1300001.JukyushaDaichoPanelHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト 受給者台帳２。
 *
 * @reamsid_L DBD-1810-010 wanghui
 */
public class JukyushaDaichoPanel {

    private static final RString 抽出年月日 = new RString("1");
    private static final RString 医療機関 = new RString("2");
    private static final RString 調査委託先 = new RString("3");
    private static final RString 項目付加 = new RString("6");
    private static final RString 連番付加 = new RString("7");
    private static final RString 日付_編集 = new RString("8");
    private static final RString 申請取消データ抽出 = new RString("4");
    private static final RString 削除データ抽出 = new RString("5");

    /**
     * onLoadの処理を行います。
     *
     * @param div 汎用リスト受給者台帳２
     * @return ResponseData
     */
    public ResponseData<JukyushaDaichoPanelDiv> onLoad(JukyushaDaichoPanelDiv div) {
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
        List<RString> selectKeys = new ArrayList<>();
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出データ区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyusyutsudatakubun"));
        boolean 申請取消データの抽出 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("isShinseikeshidetacyusyutsu"));
        if (申請取消データの抽出) {
            selectKeys.add(申請取消データ抽出);
            div.getChkTorikeshiSakujo().setSelectedItemsByKey(selectKeys);
            List<RString> selectKey = new ArrayList<>();
            selectKey.add(削除データ抽出);
            div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKey);
        }
        boolean 削除データの抽出 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("isSakujyodatacyusyutsu"));
        if (削除データの抽出) {
            selectKeys.add(削除データ抽出);
            div.getChkTorikeshiSakujo().setSelectedItemsByKey(selectKeys);
            List<RString> key = new ArrayList<>();
            key.add(申請取消データ抽出);
            div.getChkTorikeshiSakujo().setDisabledItemsByKey(key);
        }
        RString 喪失区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("soshitsukubun"));
        RString 抽出対象 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyusyutsutaisyo"));
        RString 抽出日種類 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyusyutsunichisyurai"));
        if (抽出年月日.equals(抽出対象)) {
            getHandler(div).set抽出年月日();
        } else if (医療機関.equals(抽出対象)) {
            getHandler(div).set医療機関();
        } else if (調査委託先.equals(抽出対象)) {
            getHandler(div).set調査委託先();
        }
        RString 抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyusyutsunichifrom"));
        if (抽出日From == null) {
            div.getTxtChushutsuYMD().setFromValue(null);
        } else {
            div.getTxtChushutsuYMD().setFromValue(new RDate(抽出日From.toString()));
        }
        RString 抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyusyutsunichito"));
        if (抽出日To == null) {
            div.getTxtChushutsuYMD().setToValue(null);
        } else {
            div.getTxtChushutsuYMD().setToValue(new RDate(抽出日To.toString()));
        }
        RString 医療機関コードFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("iryokikancodefrom"));
        if (医療機関コードFrom == null) {
            div.getTxtIryokikan().setFromValue(null);
        } else {
            div.getTxtIryokikan().setFromValue(new Decimal(医療機関コードFrom.toString()));
        }
        RString 医療機関コードTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("iryokikancodefto"));
        if (医療機関コードTo == null) {
            div.getTxtIryokikan().setToValue(null);
        } else {
            div.getTxtIryokikan().setToValue(new Decimal(医療機関コードTo.toString()));
        }
        RString 調査委託先コードFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyosaitakusakicodefrom"));
        if (調査委託先コードFrom == null) {
            div.getTxtChosaItakusaki().setFromValue(null);
        } else {
            div.getTxtChosaItakusaki().setFromValue(new Decimal(調査委託先コードFrom.toString()));
        }
        RString 調査委託先コードTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("cyosaitakusakicodefto"));
        if (調査委託先コードTo == null) {
            div.getTxtChosaItakusaki().setToValue(null);
        } else {
            div.getTxtChosaItakusaki().setToValue(new Decimal(調査委託先コードTo.toString()));
        }
        // TODO 出力項目ID 改頁出力順ID
//        RString 宛名抽出条件 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("宛名抽出条件"));
//        RString 改頁出力順ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("改頁出力順ID"));
//        RString 出力項目ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力項目ID"));
//        RString 帳票ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("帳票ID"));
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("isCsvkomokumeifuka"));
        if (項目名付加) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(項目付加);
            dataSource.add(source);
            div.getChkCsvHenshuHoho().setSelectedItems(dataSource);
        }
        boolean 連番の付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("isCsvrenbanfuka"));
        if (連番の付加) {

            KeyValueDataSource date = new KeyValueDataSource();
            date.setKey(連番付加);
            dataSource.add(date);
            div.getChkCsvHenshuHoho().setSelectedItems(dataSource);
        }
        boolean 日付スラッシュの編集 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("isCsvhitsukesurasyuhensyu"));
        if (日付スラッシュの編集) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(日付_編集);
            dataSource.add(keyValue);
            div.getChkCsvHenshuHoho().setSelectedItems(dataSource);
        }
        div.getDdlChushutsuData().setSelectedKey(抽出データ区分);
        div.getDdlSoushitsuKubun().setSelectedKey(喪失区分);
        div.getRadChushutsuTaisho().setSelectedKey(抽出対象);
        div.getDdlChushutsuYmd().setSelectedKey(抽出日種類);
        div.getCcdAtenaJoken();
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
        DBD710020_HanyoListJukyushaDaicho2Parameter parameter = getHandler(div).setBatchParameter();
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
    public ResponseData<DBD710020_HanyoListJukyushaDaicho2Parameter> onClick_jiko(JukyushaDaichoPanelDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private JukyushaDaichoPanelHandler getHandler(JukyushaDaichoPanelDiv div) {
        return new JukyushaDaichoPanelHandler(div);
    }

}
