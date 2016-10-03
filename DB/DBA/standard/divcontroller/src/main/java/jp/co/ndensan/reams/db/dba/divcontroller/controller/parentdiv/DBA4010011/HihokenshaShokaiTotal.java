/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA4010011;

import java.util.List;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaichosakusei.HihokenshaDaichoSakuseiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011.DBA4010011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011.HihokenshaShokaiTotalDiv;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichosakusei.HihokenshaDaichoSakuseiManager;
import jp.co.ndensan.reams.db.dba.service.report.hihokenshadaicho.HihokenshaDaichoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import static jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuState;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
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
    private static final RString COMMON_BTN_PUBLISH = new RString("btnPublish");
    private static final RString COMMON_BTN_KAKUTEI = new RString("btnKakutei");
    private static final RString 照会 = new RString("照会");
    private static final RString LOAD済み = new RString("1");

    /**
     * 被保険者照会の初期化を処理します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onLoad(HihokenshaShokaiTotalDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();
        if (validateShikibetsuCode(shikibetsuCode)) {
            div.setDisabled(true);
            div.getHihokenshaShokaiPanel().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BTN_PUBLISH, true);
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        } else if (validateHihokenshaNo(hihokenshaNo)) {
            div.setDisabled(true);
            div.getHihokenshaShokaiPanel().setDisplayNone(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BTN_PUBLISH, true);
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }

        //旧初期化処理
        //div.getHihokenshaShokaiPanel().getCcdShisetsuTokusoRireki().initialize(hihokenshaNo, shikibetsuCode);
        //新初期化処理
        HihokenshaDaichoManager manager = HihokenshaDaichoManager.createInstance();
        List<HihokenshaDaicho> hihoDaichoList = manager.get最新被保険者台帳(hihokenshaNo);
        HihokenshaDaichoList sortedHihoDaichoList = new HihokenshaDaichoList(ItemList.of(hihoDaichoList));
        IItemList<HihokenshaDaicho> tokusoList = sortedHihoDaichoList.to資格得喪List();
        div.getHihokenshaShokaiPanel().getCcdShisetsuTokusoRireki().initialize(tokusoList);

        ArrayList<HihokenshaDaicho> serialHihoDaicho = new ArrayList<>();
        serialHihoDaicho.addAll(hihoDaichoList);
        ViewStateHolder.put(ViewStateKeys.対象者_被保険者台帳情報, serialHihoDaicho);

        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(shikibetsuCode);
        div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(shikibetsuCode);
        div.getHihokenshaShokaiPanel().getCcdIryoHokenButton().initialize(hihokenshaNo, shikibetsuCode, IryoHokenRirekiState.照会);
        div.getHihokenshaShokaiPanel().getCcdRofukuNenkinButton().initialize(hihokenshaNo, shikibetsuCode, RofukuNenkinState.照会);
        div.getHihokenshaShokaiPanel().getCcdShisetsuNyutaishoButton().initialize(
                shikibetsuCode, DaichoType.被保険者.getコード(), ShisetsuNyutaishoState.照会);
        div.getHihokenshaShokaiPanel().getCcdShoKofuKaishuButton().initialize(hihokenshaNo, ShoKaishuKirokuState.照会);
        div.getHihokenshaShokaiPanel().getCcdSetaiShotokuButton().initialize(shikibetsuCode);

        return ResponseData.of(div).respond();
    }

    private boolean validateShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        return (shikibetsuCode == null || shikibetsuCode.isEmpty());
    }

    private boolean validateHihokenshaNo(HihokenshaNo hihokenshaNo) {
        return ((hihokenshaNo == null || hihokenshaNo.getColumnValue() == null || hihokenshaNo.isEmpty()));
    }

    /**
     * 被保険者台帳を発行します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onClick_btnChkPublish(HihokenshaShokaiTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者台帳を発行します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(HihokenshaShokaiTotalDiv div) {
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
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
     * 被保険者資格詳細異動画面へ遷移します。
     *
     * @param div 被保険者照会DIV
     * @return ResponseData<HihokenshaShokaiTotalDiv>
     */
    public ResponseData<HihokenshaShokaiTotalDiv> onClick_btnShosai(HihokenshaShokaiTotalDiv div) {

        dgShikakuShutokuRireki_Row row = div.getHihokenshaShokaiPanel().getCcdShisetsuTokusoRireki().getDataGridSelectItem();
        ShikakuRirekiJoho 資格得喪情報 = new ShikakuRirekiJoho();
        資格得喪情報.setState(row.getState());
        資格得喪情報.setShutokuDate(row.getShutokuDate().getValue());
        資格得喪情報.setShutokuTodokedeDate(row.getShutokuTodokedeDate().getValue());
        資格得喪情報.setShutokuJiyuKey(row.getShutokuJiyuKey());
        資格得喪情報.setShutokuJiyu(row.getShutokuJiyu());
        資格得喪情報.setHihokenshaKubun(row.getHihokenshaKubun());
        資格得喪情報.setHihokenshaKubunKey(row.getHihokenshaKubunKey());
        資格得喪情報.setSoshitsuDate(row.getSoshitsuDate().getValue());
        資格得喪情報.setSoshitsuTodokedeDate(row.getSoshitsuTodokedeDate().getValue());
        資格得喪情報.setSoshitsuJiyuKey(row.getSoshitsuJiyuKey());
        資格得喪情報.setSoshitsuJiyu(row.getSoshitsuJiyu());
        資格得喪情報.setJutokuKubun(row.getJutokuKubun());
        資格得喪情報.setShikibetsuCode(row.getShikibetsuCode());
        資格得喪情報.setShoriDateTime(row.getShoriDateTime());
        資格得喪情報.setHihokenshaNo(row.getHihokenshaNo());
        資格得喪情報.setDaNo(row.getDaNo());
        資格得喪情報.setShikakuShutokuJiyuCode(row.getShikakuShutokuJiyuCode());
        資格得喪情報.setShozaiHokensha(row.getShozaiHokenshaCode());
        資格得喪情報.setSochimotoHokensha(row.getSochimotoHokenshaCode());
        資格得喪情報.setKyuHokensha(row.getKyuHokenshaCode());
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, 資格得喪情報);
        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.状態, 照会);

        //選択した行の資格取得日を保持する。
        ViewStateHolder.put(ViewStateKeys.対象者_資格取得日, row.getShutokuDate().getValue());

        return ResponseData.of(div).forwardWithEventName(DBA4010011TransitionEventName.被保険者詳細).respond();
    }
}
