/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い費支給申請決定_口座情報のHandlerです。
 *
 * @author きょう亮
 */
public class KouzaInfoHandler {

    private final KouzaInfoPanelDiv div;
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");
    private static final RString 参照 = new RString("参照");
    private static final RString 入力 = new RString("入力");
    private static final RString 申請を保存する = new RString("Element3");

    public KouzaInfoHandler(KouzaInfoPanelDiv div) {
        this.div = div;
    }
    
    public void loadヘッダエリア(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
    }
    
    public void load申請共通エリア(FlexibleYearMonth サービス年月, RString 整理番号, RString 処理モード) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        div.getPanelTwo().getTxtShoriMode().setValue(処理モード);
    }
    
    public ShokanShinsei get償還払支給申請(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RString 整理番号) {
       List<ShokanShinsei> 支給申請一覧情報リスト = InstanceProvider.create(ShokanbaraiJyokyoShokai.class)
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
       if (0 == 支給申請一覧情報リスト.size()) {
//            return new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        }
       return 支給申請一覧情報リスト.get(0);
    }

    /**
     * 申請情報
     */
    public void onClick_btnShinseiInfo() {
        // TODO QA   口座情報へ遷移前の申請情報画面のモード?? 親画面の被保険者番号?? 等很多
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        RString 画面モード = new RString("");
        if(登録.equals(状態)) {
            画面モード  = 修正;
        }else {
            画面モード  = 状態;
        }
        setViewState(処理モード, 画面モード);
    }

    /**
     * 口座情報
     */
    public void onClick_btnKouzaInfo() {
        // TODO QA
    }

    /**
     * サービス提供証明書
     */
    public void onClick_btnServiceTeikyoShomeisyo() {
        // TODO QA   親画面の被保険者番号?? 等很多
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        setViewState(処理モード, 画面モード);
    }

    /**
     * 償還払決定情報
     */
    public void onClick_btnShokanbaraiKeiteInfo() {
        // TODO QA  親画面の被保険者番号?? 等很多
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        setViewState(処理モード, 画面モード);
    }
    
     /**
      * 申請既存チェック
      */
    public void 申請既存チェック() {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        List<ShokanShinsei> entity = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("償還払支給申請"));
        }
    }
    
    public Boolean 変更有無チェック() {
       // TODO 共有子div変化がありますか?
       return true;
    }
    
    public void setViewState(RString 処理モード, RString 画面モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getDomain().toString());
        RString 整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(
                ViewStateKeys.償還払費申請検索キー, SyokanbaraihishikyushinseiketteParameter.class);
//        paramter.setHiHokenshaNo(被保険者番号);
//        paramter.setServiceTeikyoYM(サービス年月);
//        paramter.setSeiriNp(整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
    }

    public void 保存_修正() {
         // TODO 业务entity
//         SyokanbaraihiShikyuShinseiKetteManager.createInstance().updDbT3034ShokanShinsei(div);
    }

    public void 保存_削除() {
         // TODO 业务entity
//         SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(div);
    }
}
