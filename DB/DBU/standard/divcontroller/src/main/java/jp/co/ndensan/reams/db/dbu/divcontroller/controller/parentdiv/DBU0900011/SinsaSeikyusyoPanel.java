/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0900011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.DBU0900011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900011.SinsaSeikyusyoPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900011.SinsaSeikyusyoJohoHandler;
import jp.co.ndensan.reams.db.dbu.service.core.benmeisyo.BenmeisyoFinder;
import jp.co.ndensan.reams.db.dbu.service.core.sinsasei.SinsaSeikyusyoJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import static jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査請求書登録_一覧情報の取得処理。
 *
 * @reamsid_L DBU-1080-050 lizhuoxuan
 */
public class SinsaSeikyusyoPanel {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_更新 = new RString("更新");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * 審査請求書登録_一覧情報。
     *
     * @param div 審査請求書登録_一覧情報Div
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onLoad(SinsaSeikyusyoPanelDiv div) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();
        div.getAtenainfoCommonChildDiv1().initialize(shikibetsuCode);
        div.getShikakuKihonCommonChildDiv1().initialize(hihokenshaNo);
        ViewStateHolder.put(ViewStateKeys.状態, 状態_更新);
        List<FufukuMoshitate> sinsaSeikyusyoJohoList
                = SinsaSeikyusyoJohoFinder.createInstance().getSinsaSeikyusyoJohoList(
                        shikibetsuCode,
                        hihokenshaNo).records();
        getHandler(div).onLoad(sinsaSeikyusyoJohoList);
        return createResponse(div);
    }

    /**
     * 追加ボタン。<br/>
     *
     * @param div SinsaSeikyusyoPanelDiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnTuika(SinsaSeikyusyoPanelDiv div) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_追加);
        // TODO QA72883
        return ResponseData.of(div).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_追加);
    }

    // TODO 弁明書発行実装しない、「選択ボタン」利用しない。
    /**
     * 選択ボタン。<br/>
     *
     * @param div SinsaSeikyusyoPanelDiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_BtnSenTaKu(SinsaSeikyusyoPanelDiv div) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
                new FlexibleDate(div.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue().toDateString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param sindiv SinsaSeikyusyoPanelDiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnShuuSei(SinsaSeikyusyoPanelDiv sindiv) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_更新);
        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
                new FlexibleDate(sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue().toDateString()));
        ViewStateHolder.put(ViewStateKeys.弁明書作成日,
                new FlexibleDate(sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtBenmeishoSakuseiYMD().getValue().toDateString()));
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_更新);
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param sindiv SinsaSeikyusyoPanelDiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnSakuzyo(SinsaSeikyusyoPanelDiv sindiv) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態_削除);
        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
                new FlexibleDate(sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue().toDateString()));
        ViewStateHolder.put(ViewStateKeys.弁明書作成日,
                new FlexibleDate(sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtBenmeishoSakuseiYMD().getValue().toDateString()));
        return ResponseData.of(sindiv).forwardWithEventName(DBU0900011TransitionEventName.登録画面に遷移).parameter(状態_削除);
    }
    // TODO 弁明書の発行処理 該当機能実装しない。
    /**
     * 弁明書発行。<br/>
     *
     * @param sindiv SinsaSeikyusyoPanelDiv
     * @return ResponseData<SinsaSeikyusyoPanelDiv>
     */
    public ResponseData<SinsaSeikyusyoPanelDiv> onClick_btnbennsho(SinsaSeikyusyoPanelDiv sindiv) {
        BenmeisyoFinder.createInstance().setBenmeisyoTyohyoData(ShikibetsuCode.EMPTY, HihokenshaNo.EMPTY, FlexibleDate.MAX, null);
//        ViewStateHolder.put(ViewStateKeys.識別コード, ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
//        ViewStateHolder.put(ViewStateKeys.被保険者番号, ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
//        ViewStateHolder.put(ViewStateKeys.審査請求届出日,
//                new FlexibleDate(sindiv.getGrdSinsaSeikyusyoJoho().getActiveRow().getTxtShinsaSeikyuTodokeYMD().getValue().toDateString()));
        return ResponseData.of(sindiv).respond();
    }

    private SinsaSeikyusyoJohoHandler getHandler(SinsaSeikyusyoPanelDiv panel) {
        return new SinsaSeikyusyoJohoHandler(panel);
    }

    private ResponseData<SinsaSeikyusyoPanelDiv> createResponse(SinsaSeikyusyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
