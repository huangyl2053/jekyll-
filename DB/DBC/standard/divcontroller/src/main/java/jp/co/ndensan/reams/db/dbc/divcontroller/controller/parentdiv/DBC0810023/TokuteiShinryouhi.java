/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.TokuteiShinryouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810023.TokuteiShinryohiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_特定診療費画面のクラスです。
 *
 * @reamsid_L DBC-1010-150 wangkanglei
 */
public class TokuteiShinryouhi {

    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiShinryouhiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryouhiDiv> onLoad(TokuteiShinryouhiDiv div) {

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RDate 申請日 = new RDate(ViewStateHolder.get(ViewStateKeys.申請日, RString.class).toString());

        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelThree().getDgdTokuteiShinryohi().setVisible(false);
            div.getPanelThree().getDgdTokuteiShinryohi().setDisplayNone(true);
            div.getPanelThree().getDdgToteishinryoTokubetushinryo().setVisible(true);
            div.getPanelThree().getPanelFour().setVisible(false);
            div.getPanelThree().getPanelFive().setVisible(false);
            div.getPanelThree().getPanelFive().setDisplayNone(true);
            List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (!(shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty())) {
            getHandler(div).set特定診療費一覧グリッド(shokanTokuteiShinryohiList);
            }
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelThree().getDgdTokuteiShinryohi().setVisible(true);
            div.getPanelThree().getDdgToteishinryoTokubetushinryo().setVisible(false);
            div.getPanelThree().getDdgToteishinryoTokubetushinryo().setDisplayNone(true);
            div.getPanelThree().getPanelFour().setVisible(false);
            div.getPanelThree().getPanelFour().setDisplayNone(true);
            div.getPanelThree().getPanelFive().setVisible(false);
            List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ShokanbaraiJyokyoShokai
                    .createInstance().getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号, null);
            
           if (!(shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty())) {
            getHandler(div).set特定診療費_特別診療費一覧グリッド(shokanTokuteiShinryoTokubetsuRyoyoList);
           }
        }
        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity.getEntity(), サービス年月);

        return createResponse(div);
    }

    /**
     * 特定診療費一覧グリッドの「選択」ボタンのメソッドます。
     *
     * @param div TokuteiShinryouhiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryouhiDiv> onClick_dgdTokuteiShinryohi(TokuteiShinryouhiDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        dgdTokuteiShinryohi_Row row = div.getPanelThree().getDgdTokuteiShinryohi().getClickedItem();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ShokanbaraiJyokyoShokai
                .createInstance().getTokuteyiShinnryouhiTokubeturyoyohi(
                        parameter.getHiHokenshaNo(),
                        parameter.getServiceTeikyoYM(),
                        parameter.getSeiriNp(),
                        parameter.getJigyoshaNo(),
                        様式番号,
                        parameter.getMeisaiNo(),
                        row.getRemban());
        if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定診療費_特別診療費パネル(shokanTokuteiShinryoTokubetsuRyoyoList,
                parameter.getServiceTeikyoYM(),
                様式番号);
        div.getPanelThree().getPanelFour().setVisible(false);
        div.getPanelThree().getPanelFive().setVisible(true);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費一覧グリッドの「選択」ボタンのメソッドます。
     *
     * @param div TokuteiShinryouhiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryouhiDiv> onClick_ddgToteishinryoTokubetushinryo(TokuteiShinryouhiDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        ddgToteishinryoTokubetushinryo_Row row = div.getPanelThree().getDdgToteishinryoTokubetushinryo().getClickedItem();
        List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryohiData(
                        parameter.getHiHokenshaNo(),
                        parameter.getServiceTeikyoYM(),
                        parameter.getSeiriNp(),
                        parameter.getJigyoshaNo(),
                        ViewStateHolder.get(ViewStateKeys.様式番号, RString.class),
                        parameter.getMeisaiNo(),
                        row.getRemban());
        if (shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定診療費パネル(shokanTokuteiShinryohiList);
        div.getPanelThree().getPanelFour().setVisible(true);
        div.getPanelThree().getPanelFive().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「閉じる」ボタン上のメソッドます。
     *
     * @param div TokuteiShinryouhiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryouhiDiv> onClick_btnCloseUp(TokuteiShinryouhiDiv div) {
        div.getPanelThree().getPanelFour().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「閉じる」ボタン下のメソッドます。
     *
     * @param div TokuteiShinryouhiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryouhiDiv> onClick_btnCloseDown(TokuteiShinryouhiDiv div) {
        div.getPanelThree().getPanelFive().setVisible(false);
        return createResponse(div);
    }

    private TokuteiShinryohiHandler getHandler(TokuteiShinryouhiDiv div) {
        return new TokuteiShinryohiHandler(div);
    }

    private ResponseData<TokuteiShinryouhiDiv> createResponse(TokuteiShinryouhiDiv div) {
        return ResponseData.of(div).respond();
    }
}
