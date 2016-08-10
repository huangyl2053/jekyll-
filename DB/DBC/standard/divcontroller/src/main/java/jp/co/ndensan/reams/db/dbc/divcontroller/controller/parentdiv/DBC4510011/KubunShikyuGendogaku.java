/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4510011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.DBC4510011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.dgServiceShurui_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011.KubunShikyuGendogakuHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kubunshikyugendogaku.KubunShikyuGendogakuManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * サービス種類登録です。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogaku {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KubunShikyuGendogakuDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onLoad(KubunShikyuGendogakuDiv div) {
        div.getDgServiceShurui().init();
        KubunShikyuGendogakuHandler handler = getHandler(div);
        handler.setServiceShuruiShousaiEnable(true);
        KubunShikyuGendogakuManager manager = InstanceProvider.create(KubunShikyuGendogakuManager.class);
        List<KaigoServiceShurui> businessList = manager.getサービス種類登録();
        if (!businessList.isEmpty()) {
            handler.initializeDgList(businessList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * Dgdの修正ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Modify(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        dgServiceShurui_Row row = div.getDgServiceShurui().getClickedItem();
        handler.setServiceShuruiShousaiEnable(false);
        handler.setDisable();
        handler.modify(row);
        div.getDgServiceShurui().setDataSource(div.getDgServiceShurui().getDataSource());
        return ResponseData.of(div).respond();
    }

    /**
     * 追加するボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Add(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        handler.setServiceShuruiShousaiEnable(false);
        handler.setDisable();
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Delete(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        dgServiceShurui_Row row = div.getDgServiceShurui().getClickedItem();
        div.getDgServiceShurui().getDataSource().remove(row);
        RString サービス種類コード = row.getDefaultDataName1();
        RString 提供開始年月 = row.getDefaultDataName2();
        handler.setServiceShuruiShousaiEnable(true);
        handler.setDisable();
        return ResponseData.of(div).respond();
    }

    /**
     * 入力前の状態に戻る ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Back(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        handler.setEnable();
        handler.clearValue();
        handler.setServiceShuruiShousaiEnable(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 入力前の状態に戻る ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Save(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuManager manager = InstanceProvider.create(KubunShikyuGendogakuManager.class);

        return ResponseData.of(div).setState(DBC4510011StateName.初期状態);
    }

    private KubunShikyuGendogakuHandler getHandler(KubunShikyuGendogakuDiv div) {
        return KubunShikyuGendogakuHandler.of(div);
    }
}
