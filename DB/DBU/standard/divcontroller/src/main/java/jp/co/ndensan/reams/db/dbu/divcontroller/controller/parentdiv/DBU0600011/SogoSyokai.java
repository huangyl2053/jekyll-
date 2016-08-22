/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.DBU0600011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.SogoSyokaiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600011.SogoSyokaiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 総合照会_資格得喪情報のDivControllerです。
 *
 * @reamsid_L DBU-4100-010 wanghuafeng
 */
public class SogoSyokai {

    private TaishoshaKey key;

    /**
     * インスタンスです。
     */
    public SogoSyokai() {
        key = new TaishoshaKey(new HihokenshaNo("1000000000"), new ShikibetsuCode("000000000000010"), new SetaiCode("1"));
        ViewStateHolder.put(ViewStateKeys.資格対象者, key);
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

    /**
     * 画面の初期化
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onLoad(SogoSyokaiDiv div) {
        getHandler(div).onLoad(key);
        return ResponseData.of(div).respond();
    }

    /**
     * 受給者情報を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_Jyukyusyajoho(SogoSyokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    /**
     * 給付情報を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_KyufuJoho(SogoSyokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600011TransitionEventName.一覧表示).respond();
    }

    /**
     * 賦課情報を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_Fukasyajoho(SogoSyokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600011TransitionEventName.一覧表示).respond();
    }

    /**
     * 住民情報を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_Jyuminsyajoho(SogoSyokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600011TransitionEventName.一覧表示).respond();
    }

    /**
     * 被保険者情報を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_Hihokensyajoho(SogoSyokaiDiv div) {
        //TODO 王華鳳　QA１５６９　UIContainerが漏れる　
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    /**
     * 他住所地特例者を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_HokaJyusyotokurei(SogoSyokaiDiv div) {
        //TODO 王華鳳　QA１５６９　UIContainerが漏れる
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    /**
     * 適用除外者を表示するボタン押下
     *
     * @param div SogoSyokaiDiv
     * @return ResponseData<SogoSyokaiDiv>
     */
    public ResponseData<SogoSyokaiDiv> onClick_Shiyojyogaisya(SogoSyokaiDiv div) {
        //TODO 王華鳳　QA１５６９　UIContainerが漏れる
        return ResponseData.of(div).forwardWithEventName(null).respond();
    }

    private SogoSyokaiHandler getHandler(SogoSyokaiDiv div) {
        return new SogoSyokaiHandler(div);
    }

}
