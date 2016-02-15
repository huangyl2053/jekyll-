/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.TokuteiShinryohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810023.TokuteiShinryohiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_特定診療費画面のクラスです。
 *
 * @author wangkanglei
 */
public class TokuteiShinryohi {

    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");

    public ResponseData<TokuteiShinryohiDiv> onLoad(TokuteiShinryohiDiv div) {
        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000033"), new FlexibleYearMonth(new RString("200305")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("2155"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RString("20151124"));

//        div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelThree().getDgdTokuteiShinryohi().setVisible(false);
            div.getPanelThree().getDgdTokuteiShinryohi().setDisplayNone(true);
            div.getPanelThree().getDdgToteishinryoTokubetushinryo().setVisible(true);
            div.getPanelThree().getPanelFour().setVisible(false);
            div.getPanelThree().getPanelFive().setVisible(false);
            div.getPanelThree().getPanelFive().setDisplayNone(true);
            List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set特定診療費一覧グリッド(shokanTokuteiShinryohiList);
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
            if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set特定診療費_特別診療費一覧グリッド(shokanTokuteiShinryoTokubetsuRyoyoList);
        }
        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);

        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_dgdTokuteiShinryohi(TokuteiShinryohiDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        dgdTokuteiShinryohi_Row row = div.getPanelThree().getDgdTokuteiShinryohi().getClickedItem();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ShokanbaraiJyokyoShokai
                .createInstance().getTokuteyiShinnryouhiTokubeturyoyohi(
                        parameter.getHiHokenshaNo(),
                        parameter.getServiceTeikyoYM(),
                        parameter.getSeiriNp(),
                        parameter.getJigyoshaNo(),
                        ViewStateHolder.get(ViewStateKeys.様式番号, RString.class),
                        parameter.getMeisaiNo(),
                        row.getRemban());
        if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定診療費_特別診療費パネル(shokanTokuteiShinryoTokubetsuRyoyoList,
                parameter.getServiceTeikyoYM());
        div.getPanelThree().getPanelFour().setVisible(false);
        div.getPanelThree().getPanelFive().setVisible(true);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_ddgToteishinryoTokubetushinryo(TokuteiShinryohiDiv div) {
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

    public ResponseData<TokuteiShinryohiDiv> onClick_btnCloseUp(TokuteiShinryohiDiv div) {
        div.getPanelThree().getPanelFour().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnCloseDown(TokuteiShinryohiDiv div) {
        div.getPanelThree().getPanelFive().setVisible(false);
        return createResponse(div);
    }

    private TokuteiShinryohiHandler getHandler(TokuteiShinryohiDiv div) {
        return new TokuteiShinryohiHandler(div);
    }

    private ResponseData<TokuteiShinryohiDiv> createResponse(TokuteiShinryohiDiv div) {
        return ResponseData.of(div).respond();
    }
}
