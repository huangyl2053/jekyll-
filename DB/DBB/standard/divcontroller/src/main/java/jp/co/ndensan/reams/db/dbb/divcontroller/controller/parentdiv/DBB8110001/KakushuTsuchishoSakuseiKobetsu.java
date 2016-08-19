/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8110001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.DBB8110001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranparameter.IdoTaishoshaIchiranparameter;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei.KakushuTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM12001_3_各種通知書作成（個別）のクラスです。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsu {

    private static final RString 賦課年度KEY = new RString("fukaNendo");
    private static final RString 通知書番号KEY = new RString("tsuchishoNo");
    private static final RString 調定年度_KEY = new RString("調定年度");
    private static final RString 賦課年度_KEY = new RString("賦課年度");
    private static final RString 変更通知書帳票_略称 = new RString("変更通知書帳票略称");
    private static final RString 減免通知書帳票_略称 = new RString("減免通知書帳票略称");
    private static final RString 徴収猶予通知書帳票_略称 = new RString("徴収猶予通知書帳票略称");
    private static final RString 即時賦課更正 = new RString("DBBMN13001");
    private static final RString 通知書発行後異動把握_仮算定 = new RString("DBBMN42001");
    private static final RString 通知書発行後異動把握_本算定 = new RString("DBBMN32001");
    private static final RString 戻る = new RString("btnBack");
    private static final RString 再検索する = new RString("btnToResearch");
    private static final RString 検索結果一覧へ = new RString("btnToSearchResult");
    private static final RString フラグ_1 = new RString("1");
    private static final RString 戻るフラグ = new RString("Direct");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onLoad(KakushuTsuchishoSakuseiKobetsuDiv div) {
        TsuchishoNo 通知書番号;
        FlexibleYear 賦課年度;
        LasdecCode 市町村コード;
        ShikibetsuCode 識別コード;
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        if (即時賦課更正.equals(ResponseHolder.getMenuID())) {
            通知書番号 = ViewStateHolder.get(ViewStateKeys.通知書番号, TsuchishoNo.class);
            賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
            市町村コード = ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class);
            識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索する, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, true);
        } else if (通知書発行後異動把握_仮算定.equals(ResponseHolder.getMenuID())
                || 通知書発行後異動把握_本算定.equals(ResponseHolder.getMenuID())) {
            RString parameter = ViewStateHolder.get(ViewStateKeys.各種通知書作成戻るフラグ, RString.class);
            if (戻るフラグ.equals(parameter)) {
                // TODO
                List<IdoTaishoshaIchiranparameter> listPar = ViewStateHolder.get(ViewStateKeys.異動者一覧Par, List.class);
                通知書番号 = listPar.get(0).getTsuchishoNo();
                賦課年度 = listPar.get(0).getFukaNendo();
                市町村コード = null;
                識別コード = listPar.get(0).getShikibetsuCode();
            } else {
                // TODO この画面が実装できない。
                通知書番号 = null;
                賦課年度 = null;
                市町村コード = null;
                識別コード = null;
            }
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(再検索する, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, true);
        } else {
            FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            通知書番号 = key.get通知書番号();
            賦課年度 = key.get賦課年度();
            市町村コード = key.get市町村コード();
            識別コード = key.get識別コード();
            if (フラグ_1.equals(ViewStateHolder.get(ViewStateKeys.各種通知書作成フラグ, RString.class))) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ, true);
            }
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(戻る, true);
        }

        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                通知書番号, 賦課年度, 市町村コード, 識別コード).build();

        getHandler(div).setヘッダパネル(識別コード, searchKey, 被保険者番号);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(賦課年度KEY.toString(), 賦課年度);
        parameter.put(通知書番号KEY.toString(), 通知書番号);
        ArrayList<FukaJoho> 賦課の情報List = (ArrayList<FukaJoho>) FukaJohoManager.createInstance().get賦課の情報(parameter);
        if (賦課の情報List != null && !賦課の情報List.isEmpty()) {
            Map<RString, FukaJoho> map = getHandler(div).put賦課の情報(賦課の情報List);
            ViewStateHolder.put(ViewStateKeys.賦課の情報リスト, (Serializable) map);
            ArrayList<YMDHMS> 調定日時List = getHandler(div).put調定日時(賦課の情報List);
            ViewStateHolder.put(ViewStateKeys.調定日時リスト, 調定日時List);
            Map<RString, FlexibleYear> 年度Map = getHandler(div).set調定パネル(賦課の情報List, 調定日時List);
            FukaJoho 賦課の情報 = 賦課の情報List.get(0);
            set発行する帳票(賦課の情報, div, 年度Map.get(調定年度_KEY), 年度Map.get(賦課年度_KEY), 調定日時List);
        } else {
            getHandler(div).set初期化();
        }
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        return ResponseData.of(div).respond();
    }

    private void set発行する帳票(FukaJoho 賦課の情報,
            KakushuTsuchishoSakuseiKobetsuDiv div,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            List<YMDHMS> 調定日時List) {
        List<RString> 発行する帳票リスト = KakushuTsuchishoSakusei.createInstance().get帳票リスト(賦課の情報);
        if (発行する帳票リスト != null && !発行する帳票リスト.isEmpty()) {
            Map<RString, RString> 帳票略称Map = getHandler(div).put発行する帳票リスト(
                    賦課の情報, 調定年度, 賦課年度, 発行する帳票リスト, 調定日時List);
            ViewStateHolder.put(ViewStateKeys.変更通知書帳票略称, 帳票略称Map.get(変更通知書帳票_略称));
            ViewStateHolder.put(ViewStateKeys.減免通知書帳票略称, 帳票略称Map.get(減免通知書帳票_略称));
            ViewStateHolder.put(ViewStateKeys.徴収猶予通知書帳票略称, 帳票略称Map.get(徴収猶予通知書帳票_略称));
            Map<RString, RString> 発行する帳票 = getHandler(div).get発行する帳票(発行する帳票リスト);
            ViewStateHolder.put(ViewStateKeys.発行する帳票リスト, (Serializable) 発行する帳票);
        }
    }

    /**
     * 調定事由印字方法を変更のメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_radKobetsuHakkoChoteiJiyu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).onChange調定事由印字方法(RString.EMPTY, map);
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
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).onChange更正前(map);
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
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        List<YMDHMS> 調定日時List = ViewStateHolder.get(ViewStateKeys.調定日時リスト, List.class);
        FukaJoho 賦課の情報 = getHandler(div).onChange更正後(map, 調定日時List);
        set発行する帳票(賦課の情報, div, 賦課の情報.get調定年度(), 賦課の情報.get賦課年度(), 調定日時List);
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
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        Map<RString, RString> 帳票Map = ViewStateHolder.get(ViewStateKeys.発行する帳票リスト, Map.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        SourceDataCollection dataCollection = getHandler(div).to発行処理(map, 帳票Map, 被保険者番号, 識別コード);
        return ResponseData.of(dataCollection).respond();
    }

    /**
     * 特徴開始通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapTokuKaishiTsuchiKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).check特徴開始通知書(map);
        return ResponseData.of(div).respond();
    }

    /**
     * 決定通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapKetteiTsuchiKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).check決定通知書(map);
        return ResponseData.of(div).respond();
    }

    /**
     * 納入通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapNotsuKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).check納入通知書(map);
        return ResponseData.of(div).respond();
    }

    /**
     * 変更通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapHenkoTsuchiKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        RString 変更通知書略称 = ViewStateHolder.get(ViewStateKeys.変更通知書帳票略称, RString.class);
        getHandler(div).check変更通知書(map, 変更通知書略称);
        return ResponseData.of(div).respond();
    }

    /**
     * 郵便納付書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapYufuriKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).check郵便納付書(map);
        return ResponseData.of(div).respond();
    }

    /**
     * 減免通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapGemmenTsuchiKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        RString 減免通知書略称 = ViewStateHolder.get(ViewStateKeys.減免通知書帳票略称, RString.class);
        getHandler(div).check減免通知書(map, 減免通知書略称);
        return ResponseData.of(div).respond();
    }

    /**
     * 徴収猶予通知書をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapChoshuYuyoTsuchiKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        RString 徴収猶予通知書略称 = ViewStateHolder.get(ViewStateKeys.徴収猶予通知書帳票略称, RString.class);
        getHandler(div).check徴収猶予通知書(map, 徴収猶予通知書略称);
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課台帳をチェックのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onChange_WrapFukadaichoKobetsu(
            KakushuTsuchishoSakuseiKobetsuDiv div) {
        Map<RString, FukaJoho> map = ViewStateHolder.get(ViewStateKeys.賦課の情報リスト, Map.class);
        getHandler(div).check賦課台帳(map);
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンのメソッドます。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     * @return ResponseData
     */
    public ResponseData<KakushuTsuchishoSakuseiKobetsuDiv> onClick_btnBack(KakushuTsuchishoSakuseiKobetsuDiv div) {
        if (通知書発行後異動把握_仮算定.equals(ResponseHolder.getMenuID())
                || 通知書発行後異動把握_本算定.equals(ResponseHolder.getMenuID())) {
            RString parameter = ViewStateHolder.get(ViewStateKeys.各種通知書作成戻るフラグ, RString.class);
            return ResponseData.of(div).forwardWithEventName(DBB8110001TransitionEventName.戻る).parameter(parameter);
        }
        return ResponseData.of(div).forwardWithEventName(DBB8110001TransitionEventName.戻る).respond();
    }

    private KakushuTsuchishoSakuseiKobetsuHandler getHandler(KakushuTsuchishoSakuseiKobetsuDiv div) {
        return new KakushuTsuchishoSakuseiKobetsuHandler(div);
    }
}
