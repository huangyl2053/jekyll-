/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021.DBU0600021TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600021.SogoSyokaiJyukyusyaJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600021.SogoSyokaiJyukyusyaJohoHandler;
import jp.co.ndensan.reams.db.dbu.service.core.jyukyusyajoho.SogoSyokaiJyukyusyaJohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 総合照会_受給者情報クラスです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public class SogoSyokaiJyukyusyaJoho {

    private final TaishoshaKey key;

    /**
     * コンストラクタです。
     */
    public SogoSyokaiJyukyusyaJoho() {
        key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

    /**
     * 受給者情報の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onLoad(SogoSyokaiJyukyusyaJohoDiv div) {
        div.getKaigoAtenaInfoChildDiv().initialize(key.get識別コード());
        div.getKaigoShikakuKihonChildDiv().initialize(key.get被保険者番号());
        div.getJyukyusyaJoho().getSikakuJoho().getJyukyusyaJohoButton().setDisabled(true);
        RString 被保険者番号 = div.getKaigoShikakuKihonChildDiv().get被保険者番号();
        List<RString> list = new ArrayList<>();
        list.add(ShiharaiHenkoKanriKubun._２号差止.getコード());
        list.add(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        getHandler(div).set要介護認定情報エリア(SogoSyokaiJyukyusyaJohoFinder.createInstance().get受給認定情報(new HihokenshaNo(被保険者番号)));
        getHandler(div).set申請情報エリア(SogoSyokaiJyukyusyaJohoFinder.createInstance().get受給申請情報(new HihokenshaNo(被保険者番号)));
        getHandler(div).set各種減免情報(
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get負担限度額認定(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get利用者負担額減額(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get訪問介護利用者負担額減額(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get社会福祉法人等利用者負担軽減(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get特別地域加算減免(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get標準負担減免(new HihokenshaNo(被保険者番号)));
        getHandler(div).set給付制限情報エリア(
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get支払方法変更(new HihokenshaNo(被保険者番号), list),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get給付額減額情報(
                        new HihokenshaNo(被保険者番号), ShiharaiHenkoKanriKubun._１号給付額減額.getコード()));
        getHandler(div).set総合事業対象者情報エリア(
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get総合事業_経過措置_対象者情報(new HihokenshaNo(被保険者番号)),
                SogoSyokaiJyukyusyaJohoFinder.createInstance().get総合事業対象者(new HihokenshaNo(被保険者番号)));
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンを押下します。
     *
     * @param div SogoSyokaiJyukyusyaJohoDiv
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_KensakuModoru(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0600021TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 資格情報を表示するボタンを押下します。
     *
     * @param div SogoSyokaiJyukyusyaJohoDiv
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_btnShikakuInfo(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 給付情報を表示するボタンを押下します。
     *
     * @param div SogoSyokaiJyukyusyaJohoDiv
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_btnKyufuInfo(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課情報を表示するボタンを押下します。
     *
     * @param div SogoSyokaiJyukyusyaJohoDiv
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_btnFukaInfo(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 住民固有情報を表示するボタンを押下します。
     *
     * @param div SogoSyokaiJyukyusyaJohoDiv
     * @return ResponseData<SogoSyokaiJyukyusyaJohoDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_btnJuminInfo(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 受給情報を表示するボタンを押下します。
     *
     * @param div KaigoSikakuTokusouDiv
     * @return ResponseData<KaigoSikakuTokusouDiv>
     */
    public ResponseData<SogoSyokaiJyukyusyaJohoDiv> onClick_btnJukyuInfo(SogoSyokaiJyukyusyaJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    private SogoSyokaiJyukyusyaJohoHandler getHandler(SogoSyokaiJyukyusyaJohoDiv div) {
        return new SogoSyokaiJyukyusyaJohoHandler(div);
    }
}
