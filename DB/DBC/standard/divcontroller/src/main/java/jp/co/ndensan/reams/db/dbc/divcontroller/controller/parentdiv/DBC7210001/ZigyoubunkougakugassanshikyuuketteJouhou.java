/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710210.DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7210001.ZigyoubunkougakugassanshikyuuketteJouhouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7210001.HanyoListBachParamHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCGM23021_汎用リスト_事業分高額合算支給決定情報。
 *
 * @reamsid_L DBC-5060-010 wanghui
 */
public class ZigyoubunkougakugassanshikyuuketteJouhou {

    private static final RString 項目付加 = new RString("6");
    private static final RString 連番付加 = new RString("7");
    private static final RString 日付_編集 = new RString("8");
    private static final RString すべて = new RString("0");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト(事業分高額合算支給決定情報)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<ZigyoubunkougakugassanshikyuuketteJouhouDiv> onLoad(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件を保存する」ボタンを押下時、バッチパラメータを保存します。
     *
     * @param div div 汎用リスト(事業分高額合算支給決定情報)画面のdiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter parameter = getHandler(div).setBatchParameter();
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(parameter);
        return responseData;
    }

    /**
     * 「条件を復元する」ボタンを押下時、バッチパラメータを復元します。
     *
     * @param div 汎用リスト(事業分高額合算支給決定情報)画面のdiv
     * @return ResponseData
     */
    public ResponseData<ZigyoubunkougakugassanshikyuuketteJouhouDiv> onClick_btnBatchParameterRestore(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        // TODO 出力項目ID 改頁出力順ID
//        RString 帳票ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("帳票ID"));
//        if (!RString.isNullOrEmpty(帳票ID)) {
//
//        }
//        RString 出力順ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力順ID"));
//        if (!RString.isNullOrEmpty(出力順ID)) {
//
//        }
//        RString 出力順項目ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力順項目ID"));
//        if (!RString.isNullOrEmpty(出力順項目ID)) {
//
//        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("is項目名付加"));
        if (is項目名付加) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(項目付加);
            dataSource.add(source);
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("is連番付加"));
        if (is連番付加) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(連番付加);
            dataSource.add(keyValue);
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("is日付編集"));
        if (is日付編集) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(日付_編集);
            dataSource.add(keyValue);
        }
        div.getChkCsvHenshuHoho().setSelectedItems(dataSource);
        RString 保険者コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("保険者コード"));
        if (保険者コード.equals(new RString("000000"))) {
            div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        } else {
            div.getCcdHokenshaList().setSelectedShichosonIfExist(new LasdecCode(保険者コード));
        }
        List<Object> 支給区分List = restoreBatchParameterMap.getParameterValue(List.class, new RString("支給区分List"));
        if (支給区分List.size() < 2) {
            div.getRadShikyuKubun().setSelectedKey(new RString(支給区分List.get(0).toString()));
        } else {
            div.getRadShikyuKubun().setSelectedKey(すべて);
        }
        List<Object> 支払方法区分 = restoreBatchParameterMap.getParameterValue(List.class, new RString("支払方法区分List"));
        if (支払方法区分.size() < 2) {
            div.getRadSiharaiHohoKubun().setSelectedKey(new RString(支払方法区分.get(0).toString()));
        } else {
            div.getRadSiharaiHohoKubun().setSelectedKey(すべて);
        }
        //TODO QA1619提出する。
//        RString 金融機関コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("金融機関コード"));
//        div.getCcdKinyuKikan().set金融機関(金融機関コード)
//        RString 金融機関名 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("金融機関名"));
//        div.getCcdKinyuKikan().set金融機関TextLeftラベル(金融機関名);
        RString 対象年度 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("対象年度"));
        if (!RString.isNullOrEmpty(対象年度)) {
            div.getDdlTaishoNendo().setSelectedKey(対象年度);
        }
        ResponseData<ZigyoubunkougakugassanshikyuuketteJouhouDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 「実行する」を押下時、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param div 汎用リスト(事業分高額合算支給決定情報)画面のdiv
     * @return respond
     */
    public ResponseData<DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter> onClick_jiko(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private HanyoListBachParamHandler getHandler(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        return new HanyoListBachParamHandler(div);
    }
}
