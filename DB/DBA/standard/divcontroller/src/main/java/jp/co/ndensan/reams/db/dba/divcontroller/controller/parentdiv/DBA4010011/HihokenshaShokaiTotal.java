/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA4010011;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011.DBA4010011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011.HihokenshaShokaiTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichosakusei.HihokenshaDaichoSakuseiManager;
import jp.co.ndensan.reams.db.dba.service.report.hihokenshadaicho.HihokenshaDaichoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 被保険者照会のコントローラです。
 *
 * @reamsid_L DBA-0500-030 zuotao
 */
public class HihokenshaShokaiTotal {

    private static final RString 被保履歴 = new RString("tplHihokenshaRireki");
    private static final RString 世帯照会 = new RString("tplSetaiShokai");
    private static final RString 医療保険 = new RString("tplIryoHoken");
    private static final RString 老福年金 = new RString("tplRofukuNenkin");
    private static final RString 施設入退所 = new RString("tplShisetsuNyutaisho");
    private static final RString 証交付回収 = new RString("tplShoKofuKaishu");
    private static final RString 照会 = new RString("照会");

    /**
     * 被保険者照会の初期化を処理します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onLoad(HihokenshaShokaiTotalDiv div) {
        TaishoshaKey tk = new TaishoshaKey(new HihokenshaNo(new RString("0000000001")), new ShikibetsuCode(new RString("000001")), SetaiCode.EMPTY);
        ViewStateHolder.put(ViewStateKey.資格対象者, tk);
        TaishoshaKey key = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();
        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(shikibetsuCode);
        div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(shikibetsuCode);
        div.getHihokenshaShokaiPanel().getCcdShikakuTokusoRireki().initialize(hihokenshaNo, shikibetsuCode);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者台帳を発行します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(HihokenshaShokaiTotalDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        SearchResult<HihokenshaDaichoSakusei> 被保険者情報 = HihokenshaDaichoSakuseiManager.createInstance().getHihokenshaDaichoSakusei(
                HihokenshaDaichoSakuseiParameter.createSelectByKeyParam(key.get識別コード(), key.get被保険者番号()));
        HihokenshaDaichoPrintService printService = new HihokenshaDaichoPrintService();
        return ResponseData.of(printService.print(被保険者情報.records())).respond();
    }

    /**
     * 対象者画面の 検索条件状態へ遷移します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onClick_btnReSearch(HihokenshaShokaiTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBA4010011TransitionEventName.検索条件).respond();
    }

    /**
     * 対象者画面の検索結果一覧状態へ遷移します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onClick_btnReturn(HihokenshaShokaiTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBA4010011TransitionEventName.検索一覧).respond();
    }

    /**
     * タブ変更を処理します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onChange_tabHihokenshaShokai(HihokenshaShokaiTotalDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();
        if (被保履歴.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdShikakuTokusoRireki().initialize(hihokenshaNo, shikibetsuCode);
        } else if (世帯照会.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectedItem().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdSeitaiIchiran().initialize(shikibetsuCode, FlexibleDate.getNowDate(),
                    FlexibleDate.getNowDate().getNendo(), YMDHMS.now());
        } else if (医療保険.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectedItem().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdIryoHokenRireki().initialize(照会, shikibetsuCode.value());
        } else if (老福年金.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectedItem().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdRoreiFukushiNenkinShokai().initialize(shikibetsuCode, hihokenshaNo);
        } else if (施設入退所.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectedItem().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdShisetsuNyutaishoRireki().initialize(shikibetsuCode);
        } else if (証交付回収.equals(div.getHihokenshaShokaiPanel().getTabHihokenshaShokai().getSelectedItem().getSelectControlID())) {
            div.getHihokenshaShokaiPanel().getCcdShoKaishuJokyoList().initialize(照会, hihokenshaNo);
        }
        return ResponseData.of(div).respond();
    }
}
