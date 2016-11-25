/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600041;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.sogosyokaifukajyoho.FuKaJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041.DBU0600041TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041.PanelFuKaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600041.PanelFuKaHandler;
import jp.co.ndensan.reams.db.dbu.service.core.sogosyokaifukajyoho.SoGoSyoKaiFuKaJyoHoFinder;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報クラスです。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
public class PanelFuKa {

    private final SoGoSyoKaiFuKaJyoHoFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public PanelFuKa() {
        this.finder = SoGoSyoKaiFuKaJyoHoFinder.createInstance();
    }

    /**
     * 総合照会_住民固有情報の初期処理を表示します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData
     */
    public ResponseData<PanelFuKaDiv> onLoad(PanelFuKaDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        div.getCcdKaigoatenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        List<Fuka> fukaList = get最新の賦課年度と調定年度の取得(被保険者番号);
        if (fukaList != null && !fukaList.isEmpty()) {

            Fuka 賦課年度と調定年度の取得 = fukaList.get(0);
            FlexibleYear 賦課年度 = 賦課年度と調定年度の取得.get賦課年度();
            FlexibleYear 調定年度 = 賦課年度と調定年度の取得.get調定年度();
            List<Fuka> 前年の賦課年度と調定年度の取得 = get前年の賦課年度と調定年度の取得(被保険者番号, 調定年度);
            FlexibleYear 前年の賦課年度 = 前年の賦課年度と調定年度の取得.get(0).get賦課年度();
            FlexibleYear 前年の調定年度 = 前年の賦課年度と調定年度の取得.get(0).get調定年度();
            List<ChoshuHoho> 介護徴収方法 = get介護徴収方法(被保険者番号, 賦課年度);
            List<Fuka> 賦課Newest = get賦課Newest(被保険者番号, 賦課年度, 調定年度);
            List<Fuka> 前年の賦課Newest = get前年の賦課Newest(被保険者番号, 前年の賦課年度, 前年の調定年度);
            ViewStateHolder.put(ViewStateKeys.識別コード, 前年の賦課Newest.get(0).get被保険者番号());
            ViewStateHolder.put(ViewStateKeys.賦課年度, 前年の賦課Newest.get(0).get賦課年度());
            YMDHMS 基準日時 = get本算定賦課の処理日時(賦課年度);
            FuKaJyoHoBusiness business = new FuKaJyoHoBusiness();
            business.set前年の賦課Newest(前年の賦課Newest);
            business.set基準日時(基準日時);
            business.set賦課Newest(賦課Newest);
            business.set介護徴収方法(介護徴収方法.get(0));
            ViewStateHolder.put(ViewStateKeys.賦課情報, business);
            getHandler(div).initializtion(賦課Newest, 介護徴収方法.get(0),
                    賦課Newest, 前年の賦課Newest.get(0), 基準日時);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 通知書番号DDLを選択状態とする。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData
     */
    public ResponseData<PanelFuKaDiv> btn_select(PanelFuKaDiv div) {

        FuKaJyoHoBusiness business = ViewStateHolder.get(ViewStateKeys.賦課情報, FuKaJyoHoBusiness.class);
        YMDHMS 基準日時 = business.get基準日時();
        List<Fuka> 賦課Newest = business.get賦課Newest();
        List<Fuka> 前年の賦課Newest = business.get前年の賦課Newest();
        RString 通知書番号 = div.getDdlTuutishoBango().getSelectedKey();
        getHandler(div).select通知書番号DDL(通知書番号, 賦課Newest, 基準日時,
                前年の賦課Newest.get(0), business.get介護徴収方法());
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_KensakuModoru(PanelFuKaDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600041TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 資格情報を表示するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnShikakuInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 受給情報を表示するボタンを押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnJukyuInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 給付情報を表示するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnKyufuInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課状況を表示するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnFukaInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 住民固有情報を表示するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnJuminInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 所得状況を表示するボタンを押下します。
     *
     * @param div PanelFuKaDiv
     * @return ResponseData<PanelFuKaDiv>
     */
    public ResponseData<PanelFuKaDiv> onClick_btnShotokuInfo(PanelFuKaDiv div) {
        return ResponseData.of(div).respond();
    }

    private List<Fuka> get最新の賦課年度と調定年度の取得(HihokenshaNo 被保険者番号) {

        return finder.get最新の賦課年度と調定年度(被保険者番号).records();
    }

    private YMDHMS get本算定賦課の処理日時(FlexibleYear 賦課年度) {

        return finder.get本算定賦課の処理日時(賦課年度);
    }

    private List<Fuka> get賦課Newest(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度, FlexibleYear 調定年度) {

        return finder.get賦課情報(調定年度, 賦課年度, 被保険者番号).records();
    }

    private List<Fuka> get前年の賦課年度と調定年度の取得(HihokenshaNo 被保険者番号, FlexibleYear 調定年度) {

        return finder.get前年の賦課年度と調定年度(被保険者番号, 調定年度).records();
    }

    private List<Fuka> get前年の賦課Newest(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度, FlexibleYear 調定年度) {

        return finder.get前年の賦課情報(調定年度, 賦課年度, 被保険者番号).records();
    }

    private List<ChoshuHoho> get介護徴収方法(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {

        return finder.get介護徴収方法(賦課年度, 被保険者番号).records();
    }

    private PanelFuKaHandler getHandler(PanelFuKaDiv div) {
        return new PanelFuKaHandler(div);
    }
}
