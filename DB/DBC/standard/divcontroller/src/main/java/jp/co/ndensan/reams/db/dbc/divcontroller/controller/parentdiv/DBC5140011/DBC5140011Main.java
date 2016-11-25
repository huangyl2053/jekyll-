/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5140011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150050.DBC150050_ServicecodeTaniMeisaiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011.DBC5140011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011.dgServiceShuruiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5140011.DBC5140011MainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービスコード単位明細リストのクラスです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class DBC5140011Main {

    private static final int 十 = 10;
    private static final RString 十個ゼロ = new RString("0000000000");
    private static final RString 台帳種別表示有り = new RString("台帳種別表示有り");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5140011MainDiv> onLoad(DBC5140011MainDiv div) {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示有り);
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(DBC5140011MainDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).pamaHozon());
        return responseData;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5140011MainDiv> onClick_btnBatchParameterRestore(DBC5140011MainDiv div) {
        getHandler(div).pamaRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号のメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5140011MainDiv> onBlur_txtHihokenshaNo(DBC5140011MainDiv div) {
        RString hihokenshaNo = div.getChushutsuJoken1().getTxtHihokenshaNo().getValue();
        if (hihokenshaNo != null) {
            hihokenshaNo = hihokenshaNo.padZeroToLeft(十);
        } else {
            hihokenshaNo = 十個ゼロ;
        }
        div.getChushutsuJoken1().getTxtHihokenshaNo().setValue(hihokenshaNo);
        return ResponseData.of(div).respond();
    }

    /**
     * 「居宅を全てチェック」ボタンのメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5140011MainDiv> onClick_chkSelectKyotaku(DBC5140011MainDiv div) {
        List<dgServiceShuruiList_Row> rselectList = new ArrayList();
        List<dgServiceShuruiList_Row> alreadySelectedRows = div.getChushutsuJoken2().getDgServiceShuruiList().getSelectedItems();
        for (dgServiceShuruiList_Row row : alreadySelectedRows) {
            row.setSelected(Boolean.FALSE);
        }
        List<dgServiceShuruiList_Row> rowList = div.getChushutsuJoken2().getDgServiceShuruiList().getDataSource();
        for (dgServiceShuruiList_Row row : rowList) {
            if (row.getHdnServiceBunruiCode().equals(ServiceBunrui.居宅サービス.getコード().padZeroToLeft(2))
                    || row.getHdnServiceBunruiCode().equals(ServiceBunrui.介護予防サービス.getコード().padZeroToLeft(2))) {
                rselectList.add(row);
            }
        }
        div.getChushutsuJoken2().getDgServiceShuruiList().setSelectedItems(rselectList);
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設を全てチェック」ボタンのメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC5140011MainDiv> onClick_btnSelectShisetsu(DBC5140011MainDiv div) {
        List<dgServiceShuruiList_Row> rselectList = new ArrayList();
        List<dgServiceShuruiList_Row> alreadySelectedRows = div.getChushutsuJoken2().getDgServiceShuruiList().getSelectedItems();
        for (dgServiceShuruiList_Row row : alreadySelectedRows) {
            row.setSelected(Boolean.FALSE);
        }
        List<dgServiceShuruiList_Row> rowList = div.getChushutsuJoken2().getDgServiceShuruiList().getDataSource();
        for (dgServiceShuruiList_Row row : rowList) {
            if (row.getHdnServiceBunruiCode().equals(ServiceBunrui.施設サービス.getコード().padZeroToLeft(2))
                    || row.getHdnServiceBunruiCode().equals(ServiceBunrui.地域密着型サービス.getコード().padZeroToLeft(2))) {
                rselectList.add(row);
            }
        }
        div.getChushutsuJoken2().getDgServiceShuruiList().setSelectedItems(rselectList);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div DBC5140011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC150050_ServicecodeTaniMeisaiIchiranParameter> onClick_btnBatchRegister(DBC5140011MainDiv div) {

        IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
        manager.save前回出力順(div.getCcdChohyoShutsuryokujun().getSelected出力順());

        return ResponseData.of(getHandler(div).pamaHozon()).respond();
    }

    private DBC5140011MainHandler getHandler(DBC5140011MainDiv div) {
        return new DBC5140011MainHandler(div);
    }
}
