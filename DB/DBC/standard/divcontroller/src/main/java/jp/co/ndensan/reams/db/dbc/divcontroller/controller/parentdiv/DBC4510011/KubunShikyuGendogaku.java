/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4510011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.DBC4510011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.DBC4510011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.dgServiceShurui_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011.KubunShikyuGendogakuHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kubunshikyugendogaku.KubunShikyuGendogakuManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiHolder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
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
        ViewStateHolder.put(ViewStateKeys.介護サービス種類データ, new KaigoServiceShuruiHolder(businessList));
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
        handler.modify(row);
        div.getDgServiceShurui().getDataSource().remove(row);
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
        KaigoServiceShuruiHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス種類データ, KaigoServiceShuruiHolder.class);
        KubunShikyuGendogakuManager manager = InstanceProvider.create(KubunShikyuGendogakuManager.class);
        RString サービス種類コード = div.getServiceShuruiShousai().getTxtServiceCode().getValue();
        RString 提供開始年月 = div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().getValue().getYearMonth().toDateString();
        KaigoServiceShuruiIdentifier identifier = new KaigoServiceShuruiIdentifier(
                new ServiceShuruiCode(サービス種類コード), new FlexibleYearMonth(提供開始年月));
        KaigoServiceShurui result = holder.getKogakuGassanJikoFutanGaku(identifier);
        if (result == null) {
            result = new KaigoServiceShurui(
                    new ServiceShuruiCode(サービス種類コード), new FlexibleYearMonth(提供開始年月));
            result = result.createBuilderForEdit()
                    .setサービス種類名称(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue())
                    .setサービス分類コード(Code.EMPTY)
                    .setサービス種類略称(div.getServiceShuruiShousai().getTxtServiceRyakusho().getValue())
                    .set提供終了年月(new FlexibleYearMonth(div.getServiceShuruiShousai()
                                    .getTxtTeikyoShuryoYM().getValue().getYearMonth().toDateString()))
                    .set居宅サービス区分(RString.EMPTY)
                    .set基準該当サービス区分(RString.EMPTY)
                    .set限度額区分(RString.EMPTY)
                    .set指定サービス区分(RString.EMPTY)
                    .build();
        } else {
            if (div.getServiceShuruiShousai().getTxtServiceCode().isDisabled()) {
                result = result.deleted();
            } else {
                result = result.createBuilderForEdit()
                        .setサービス種類名称(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue())
                        .setサービス分類コード(Code.EMPTY)
                        .setサービス種類略称(div.getServiceShuruiShousai().getTxtServiceRyakusho().getValue())
                        .set提供終了年月(new FlexibleYearMonth(div.getServiceShuruiShousai()
                                        .getTxtTeikyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            }
        }
        manager.save(result);
        return ResponseData.of(div).setState(DBC4510011StateName.完了状態);
    }

    /**
     * 「サービス種類登録に戻る」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Return(
            KubunShikyuGendogakuDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBC4510011StateName.初期状態);
    }

    /**
     * 「完了する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Compelete(
            KubunShikyuGendogakuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4510011TransitionEventName.処理完了).respond();
    }

    private KubunShikyuGendogakuHandler getHandler(KubunShikyuGendogakuDiv div) {
        return new KubunShikyuGendogakuHandler(div);
    }
}
