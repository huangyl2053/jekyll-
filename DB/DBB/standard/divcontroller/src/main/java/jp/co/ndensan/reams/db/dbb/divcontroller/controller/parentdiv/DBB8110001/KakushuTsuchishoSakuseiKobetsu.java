/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.FukaInfo;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuHandler;
import jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei.KakushuTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM12001_3_各種通知書作成（個別）のクラスです。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsu {

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
        // TODO 仮データ
        ArrayList<FukaInfo> 賦課の情報List = new ArrayList<>();
        FukaInfo info = new FukaInfo().getFukaInfo();
        info.get介護賦課().setFukaYMD(new FlexibleDate("20150626"));
        info.get介護賦課().setKakuteiHokenryo(new Decimal("2015062"));
        賦課の情報List.add(info);
        FukaInfo info2 = new FukaInfo().getFukaInfo();
        info2.get介護賦課().setChoteiNichiji(new YMDHMS("20170416161234"));
        info2.get介護賦課().setFukaYMD(new FlexibleDate("20160425"));
        info2.get介護賦課().setChoteiJiyu1(new RString("調定事由1"));
        info2.get介護賦課().setChoteiJiyu2(new RString("調定事由2"));
        info2.get介護賦課().setChoteiJiyu3(new RString("調定事由3"));
        info2.get介護賦課().setChoteiJiyu4(new RString("調定事由4"));
        info2.set特徴期別金額01(new Decimal("50"));
        info2.set普徴期別金額01(new Decimal("60"));
        賦課の情報List.add(info2);
        FukaInfo info3 = new FukaInfo().getFukaInfo();
        info3.get介護賦課().setChoteiNichiji(new YMDHMS("20180416161235"));
        info3.get介護賦課().setFukaYMD(new FlexibleDate("20170425"));
        info3.get介護賦課().setChoteiJiyu1(new RString("事由1"));
        info3.get介護賦課().setChoteiJiyu2(new RString("事由2"));
        info3.get介護賦課().setChoteiJiyu3(new RString("事由3"));
        info3.get介護賦課().setChoteiJiyu4(new RString("事由4"));
        賦課の情報List.add(info3);

        getHandler(div).set調定パネル(賦課の情報List);

        // TODO 通知書作成パネル
        List<RString> 発行する帳票リスト = KakushuTsuchishoSakusei.createInstance().get帳票リスト(null);
//        List<RString> 発行する帳票リスト = new ArrayList<>();
//        発行する帳票リスト.add(new RString("郵便振替納付書"));
        if (発行する帳票リスト != null && !発行する帳票リスト.isEmpty()) {
            getHandler(div).set通知書作成パネル(発行する帳票リスト);
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
     * 通知書を選択のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_Publish(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().isIsPublish();
        div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setIsPublish(true);
        return ResponseData.of(div).respond();
    }

    private KakushuTsuchishoSakuseiKobetsuHandler getHandler(KakushuTsuchishoSakuseiKobetsuDiv div) {
        return new KakushuTsuchishoSakuseiKobetsuHandler(div);
    }
}
