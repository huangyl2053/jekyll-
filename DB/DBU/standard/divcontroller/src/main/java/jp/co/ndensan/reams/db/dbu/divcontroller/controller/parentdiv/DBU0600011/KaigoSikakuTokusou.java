/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.DBU0600011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011.KaigoSikakuTokusouDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600011.KaigoSikakuTokusouHandler;
import jp.co.ndensan.reams.db.dbu.service.core.sogosyokai.SoyoSyokaiService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 総合照会_資格得喪情報のDivControllerです。
 *
 * @reamsid_L DBU-4100-010 wanghuafeng
 */
public class KaigoSikakuTokusou {

    private final TaishoshaKey key;
    private final SoyoSyokaiService soyosyokaiservice;

    /**
     * インスタンスです。
     */
    public KaigoSikakuTokusou() {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        this.soyosyokaiservice = SoyoSyokaiService.createInstance();
    }

    /**
     * 画面の初期化です。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onLoad(KaigoSikakuTokusouDiv div) {
        getHandler(div).onLoad(key);
        getHandler(div).set被保険者(soyosyokaiservice.get被保険者台帳(key.get被保険者番号()));
        getHandler(div).set施設入退所(soyosyokaiservice.get施設入退所(key.get識別コード()));
        getHandler(div).set他市町村住所地特例情報(soyosyokaiservice.get他市町村住所地特例情報(key.get識別コード()),
                key.get識別コード());
        getHandler(div).set適用除外者情報(soyosyokaiservice.get適用除外者情報(key.get識別コード()), key.get識別コード());
        return ResponseData.of(div).respond();
    }

    /**
     * 受給者情報を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_Jyukyusyajoho(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 給付情報を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_KyufuJoho(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課情報を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_Fukasyajoho(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 住民情報を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_Jyuminsyajoho(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者情報を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_Hihokensyajoho(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 他住所地特例者を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_HokaJyusyotokurei(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 適用除外者を表示するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_Shiyojyogaisya(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタン押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<KaigoSikakuTokusouDiv> onClick_KensakuModoru(KaigoSikakuTokusouDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600011TransitionEventName.対象者検索に戻る).respond();
    }

    private KaigoSikakuTokusouHandler getHandler(KaigoSikakuTokusouDiv div) {
        return new KaigoSikakuTokusouHandler(div);
    }

}
