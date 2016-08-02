/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.gemmenshokai.GemmenShokai;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmenshokai.GemmenShokai.GemmenShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.DBD1050001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.HyojunFutanGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.dgShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050001.HyojunFutangakuGemmenSinseiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SetaiShotokuIchiran;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 標準負担額減免申請のDivControllerです。
 *
 * @reamsid_L DBD-3700-010 liuwei2
 */
public class HyojunFutanGemmen {

    private static final Code CODE_0003 = new Code("0003");
    private static final RString NAME_被保険者番号 = new RString("被保険者番号");

    /**
     * 画面初期化
     *
     * @param div HyojunFutanGemmenDiv 標準負担額減免申請画面Div
     * @return ResponseData<HyojunFutanGemmenDiv>
     */
    public ResponseData<HyojunFutanGemmenDiv> onLoad(HyojunFutanGemmenDiv div) {

        // TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        // TODO テストデータ
        TaishoshaKey 資格対象者 = new TaishoshaKey(
                new HihokenshaNo(new RString("0000000001")),
                new ShikibetsuCode(new RString("000000000000010")),
                new SetaiCode(new RString("000000000000100")));

        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        div.getCcdKaigoKihon().initialize(被保険者番号);
        div.getCcdAtenaInfo().initialize(識別コード);
        List<HyojunFutangakuGemmen> 標準負担額減免情報データ = getHandler().get標準負担額減免申請情報(被保険者番号);
        if (標準負担額減免情報データ.isEmpty()) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
        } else {
            div.getShinseiDetail().setIsOpen(false);
            div.getBtnOutputSetaiInfo().setDisabled(false);
            div.getBtnOutputGenmenInfo().setDisabled(false);
            div.getShinseiList().getDgShinseiIchiran().setDataSource(getHandler().setDgShinseiIchiran_Row(標準負担額減免情報データ));
            ViewStateHolder.put(ViewStateKeys.申請一覧情報, new ArrayList<>(標準負担額減免情報データ));
        }
        getHandler().onload(div);
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, NAME_被保険者番号, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).respond();
    }

    /**
     * 標準負担額減免申請画面を「世帯情報を表示する」ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnSetaiShotokuIchiran(HyojunFutanGemmenDiv div) {
        SetaiShotokuIchiran 世帯情報表示 = new SetaiShotokuIchiran();
        世帯情報表示.onLoad(new SetaiShotokuIchiranDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 標準負担額減免申請画面を「減免情報を表示する」ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnGemmenShokai(HyojunFutanGemmenDiv div) {
        GemmenShokai 減免情報表示 = new GemmenShokai();
        // HihokenshaNo 被保険者番号 =  ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        // div.setHihokenshaNo(被保険者番号.getColumnValue());
        減免情報表示.onLoad(new GemmenShokaiDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 標準負担額減免申請画面を 申請情報の詳細ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnSelectJoho(HyojunFutanGemmenDiv div) {

        dgShinseiIchiran_Row row = div.getShinseiList().getDgShinseiIchiran().getActiveRow();
        List<HyojunFutangakuGemmen> dbDatalist = ViewStateHolder.get(ViewStateKeys.申請一覧情報, ArrayList.class);
        HyojunFutangakuGemmen selectedRowJoho = getHandler().get該当Joho(row, dbDatalist);

        div.getShinseiDetail().getTxtShinseibi().setValue(selectedRowJoho.get申請年月日());

        div.getShinseiDetail().getTxtKetteibi().setValue(selectedRowJoho.get決定年月日());
        div.getShinseiDetail().getTxtTekiyobi().setValue(selectedRowJoho.get適用開始年月日());
        div.getShinseiDetail().getTxtYukoKigen().setValue(selectedRowJoho.get適用終了年月日());
        div.getShinseiDetail().getTxtHyojunFutangaku().setValue(selectedRowJoho.get減額後金額());
        if (selectedRowJoho.get非承認理由() == null) {
            div.getShinseiDetail().getTxtShoninShinaiRiyu().setValue(RString.EMPTY);
        } else {
            div.getShinseiDetail().getTxtShoninShinaiRiyu().setValue(selectedRowJoho.get非承認理由());
        }

        if (selectedRowJoho.get決定区分().equals(new RString("0"))) {
            div.getShinseiDetail().getRadKetteiKubun().setSelectedKey(new RString("key0"));
        } else {
            div.getShinseiDetail().getRadKetteiKubun().setSelectedKey(new RString("key1"));
        }

        if (selectedRowJoho.get申請事由().equals(new RString("世帯非課税８０万以下"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key0"));
        } else if (selectedRowJoho.get申請事由().equals(new RString("世帯非課税８０万超"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key1"));
        } else if (selectedRowJoho.get申請事由().equals(new RString("生保"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key2"));
        } else if (selectedRowJoho.get申請事由().equals(new RString("世帯非課税"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key3"));
        } else if (selectedRowJoho.get申請事由().equals(new RString("老齢"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key4"));
        } else if (selectedRowJoho.get申請事由().equals(new RString("特例減額措置"))) {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key5"));
        } else {
            div.getShinseiDetail().getDdlShinseiRiyu().setSelectedKey(new RString("key6"));
        }

        if (selectedRowJoho.get減額区分().equals(new RString("市町"))) {
            div.getShinseiDetail().getDdlGengakuKubun().setSelectedKey(new RString("key0"));
        } else if (selectedRowJoho.get減額区分().equals(new RString("老齢"))) {
            div.getShinseiDetail().getDdlGengakuKubun().setSelectedKey(new RString("key1"));
        } else {
            div.getShinseiDetail().getDdlGengakuKubun().setSelectedKey(new RString("key2"));
        }

        div.getShinseiDetail().getTxtShinseibi().setDisabled(true);
        div.getShinseiDetail().getDdlShinseiRiyu().setDisabled(true);
        div.getShinseiDetail().getRadKetteiKubun().setDisabled(true);
        div.getShinseiDetail().getTxtKetteibi().setDisabled(true);
        div.getShinseiDetail().getTxtTekiyobi().setDisabled(true);
        div.getShinseiDetail().getTxtYukoKigen().setDisabled(true);
        div.getShinseiDetail().getTxtHyojunFutangaku().setDisabled(true);
        div.getShinseiDetail().getTxtShoninShinaiRiyu().setDisabled(true);
        div.getShinseiDetail().getDdlGengakuKubun().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * 標準負担額減免申請画面を 「申請一覧に戻る」ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnReturn(HyojunFutanGemmenDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD1050001TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * 標準負担額減免申請画面を 「再検索する」ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnReSearchResult(HyojunFutanGemmenDiv div) {
        ViewStateHolder.put(ViewStateKeys.申請一覧情報, null);
        return ResponseData.of(div).forwardWithEventName(DBD1050001TransitionEventName.再検索処理へ).respond();
    }

    /**
     * 標準負担額減免申請画面を 「検索結果一覧へ」ボタンを押下する。<br/>
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return 標準負担額減免申請画面Divを持つResponseData
     */
    public ResponseData<HyojunFutanGemmenDiv> onClick_btnToSearchResult(HyojunFutanGemmenDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD1050001TransitionEventName.再検索処理へ).respond();
    }

    private HyojunFutangakuGemmenSinseiHandler getHandler() {
        return new HyojunFutangakuGemmenSinseiHandler();
    }
}
