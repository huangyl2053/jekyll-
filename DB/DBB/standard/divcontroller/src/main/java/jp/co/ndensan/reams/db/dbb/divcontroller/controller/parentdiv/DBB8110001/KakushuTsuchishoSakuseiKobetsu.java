/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8110001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuHandler;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM12001_3_各種通知書作成（個別）のクラスです。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsu {

    private static final RString 賦課年度KEY = new RString("fukaNendo");
    private static final RString 通知書番号KEY = new RString("tsuchishoNo");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onLoad(KakushuTsuchishoSakuseiKobetsuDiv div) {

        FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKey.賦課対象者, FukaTaishoshaKey.class);
        TsuchishoNo 通知書番号 = key.get通知書番号();
        FlexibleYear 賦課年度 = key.get賦課年度();
        LasdecCode 市町村コード = key.get市町村コード();
        ShikibetsuCode 識別コード = key.get識別コード();
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                通知書番号, 賦課年度, 市町村コード, 識別コード).build();

        div.getJuminFukaShokai().getCcdKaigoatena().onLoad(識別コード);
        div.getJuminFukaShokai().getCcdFukaKihon().load(searchKey);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(賦課年度KEY.toString(), 賦課年度);
        parameter.put(通知書番号KEY.toString(), 通知書番号);
        ArrayList<FukaJoho> 賦課の情報List = (ArrayList<FukaJoho>) FukaJohoManager.createInstance().get賦課の情報(parameter);
        if (賦課の情報List != null && !賦課の情報List.isEmpty()) {
            getHandler(div).set調定パネル(賦課の情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調定事由印字方法を変更のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_radKobetsuHakkoChoteiJiyu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        getHandler(div).onChange調定事由印字方法();
        return ResponseData.of(div).respond();
    }

    /**
     * 更正前選択を変更のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_ddlInjiKouseiMae(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        getHandler(div).onChange更正前();
        return ResponseData.of(div).respond();
    }

    /**
     * 更正後選択を変更のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_ddlInjiKouseiAto(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        getHandler(div).onChange更正後();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        SourceDataCollection dataCollection = getHandler(div).to発行処理();
        return ResponseData.of(dataCollection).respond();
    }

    /**
     * 通知書をOpenのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onOpen_Publish(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setIsPublish(true);
        div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
        getHandler(div).check通知書(true, div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().getTitle());
        return ResponseData.of(div).respond();
    }

    /**
     * 通知書をCloseのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onClose_Publish(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setIsPublish(false);
        div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
        getHandler(div).check通知書(false, div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().getTitle());
        return ResponseData.of(div).respond();
    }

    private KakushuTsuchishoSakuseiKobetsuHandler getHandler(KakushuTsuchishoSakuseiKobetsuDiv div) {
        return new KakushuTsuchishoSakuseiKobetsuHandler(div);
    }
}
