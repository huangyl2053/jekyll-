/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5000011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140020.DBC140020_JukyushaKyufujissekiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.DBC5000011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.DBC5000011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoPreservation;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNJ1002_受給者給付実績一覧表発行.xlsx のDivControllerクラスです。
 *
 * @author DBC-3070-010 dangjingjing
 */
public class JukyushaKyufuJissekiDaicho {

    private static final RString 全て = new RString("全て");
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final RString 遷移1 = new RString("1");
    private static final RString 遷移2 = new RString("2");
    private static final RString MENUID_DBCMNJ1001 = new RString("DBCMNJ1001");
    private static final RString MENUID_DBCMNJ1002 = new RString("DBCMNJ1002");
    private static final RString 受給者給付実績台帳 = new RString("受給者給付実績台帳");
    private static final RString 受給者給付実績一覧表 = new RString("受給者給付実績一覧表");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onLond(JukyushaKyufuJissekiDaichoDiv div) {
        RString 被保険者番号_FromOrTO = ViewStateHolder.get(ViewStateKeys.番号, RString.class);
        ResponseData<JukyushaKyufuJissekiDaichoDiv> responseData = new ResponseData<>();
        getHandler(div).onLond();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 != null) {
            HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
            if (遷移1.equals(被保険者番号_FromOrTO)) {
                div.getTabChushutsuJoken().getTxtRangeHihokenshaNoFrom().setValue(被保険者番号.value());
            } else if (遷移2.equals(被保険者番号_FromOrTO)) {
                div.getTabChushutsuJoken().getTxtRangeHihokenshaNoTo().setValue(被保険者番号.value());
            }
        }
        JukyushaKyufuJissekiDaichoPreservation prvt = ViewStateHolder.get(ViewStateKeys.受給者給付,
                JukyushaKyufuJissekiDaichoPreservation.class);
        if (prvt != null) {
            if (遷移1.equals(被保険者番号_FromOrTO)) {
                div.getTxtRangeHihokenshaNoTo().setValue(prvt.getTxtRangeHihokenshaNoTo());
            } else if (遷移2.equals(被保険者番号_FromOrTO)) {
                div.getTxtRangeHihokenshaNoFrom().setValue(prvt.getTxtRangeHihokenshaNoFrom());
            }
            div.getRadKonkaiTaishoYM().setSelectedKey(prvt.getRadKonkaiTaishoYM());
            div.getTxtRangeYM().setFromValue(new RDate(prvt.getTxtRangeYMFrom().toString()));
            div.getTxtRangeYM().setToValue(new RDate(prvt.getTxtRangeYMTo().toString()));
            div.getRadKyufuJissekiKubun().setSelectedKey(prvt.getRadKyufuJissekiKubun());
            div.getChkYokaigodo().setSelectedItemsByKey(prvt.getChkYokaigodo());
            div.getChkShutsuryokuYoshiki1().setSelectedItemsByKey(prvt.getChkShutsuryokuYoshiki1());
            div.getChkShutsuryokuYoshiki2().setSelectedItemsByKey(prvt.getChkShutsuryokuYoshiki2());
            div.getChkShutsuryokuYoshiki3().setSelectedItemsByKey(prvt.getChkShutsuryokuYoshiki3());
            div.getChkShutsuryokuYoshiki4().setSelectedItemsByKey(prvt.getChkShutsuryokuYoshiki4());
            div.getChkShutsuryokuYoshiki5().setSelectedItemsByKey(prvt.getChkShutsuryokuYoshiki5());
        }
        if (MENUID_DBCMNJ1001.equals(menuID)) {
            responseData = ResponseData.of(div).setState(DBC5000011StateName.台帳);
            responseData.setRootTitle(受給者給付実績台帳);
            return responseData;
        } else if (MENUID_DBCMNJ1002.equals(menuID)) {
            responseData = ResponseData.of(div).setState(DBC5000011StateName.一覧表);
            responseData.setRootTitle(受給者給付実績一覧表);
            return responseData;
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 出力様式ボタンのメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnShutsuryokuYoshikiAllCheck(JukyushaKyufuJissekiDaichoDiv div) {
        getHandler(div).set出力様式ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保険者番号 開始検索ボタン」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnHihokenshaNoFromSearch(JukyushaKyufuJissekiDaichoDiv div) {
        ViewStateHolder.put(ViewStateKeys.番号, 遷移1);
        JukyushaKyufuJissekiDaichoPreservation prvt = new JukyushaKyufuJissekiDaichoPreservation();
        prvt.setRadKonkaiTaishoYM(div.getRadKonkaiTaishoYM().getSelectedKey());
        prvt.setTxtRangeYMFrom(new RString(div.getTxtRangeYM().getFromValue().toString()));
        prvt.setTxtRangeYMTo(new RString(div.getTxtRangeYM().getToValue().toString()));
        prvt.setTxtRangeHihokenshaNoTo(div.getTxtRangeHihokenshaNoTo().getValue());
        prvt.setRadKyufuJissekiKubun(div.getRadKyufuJissekiKubun().getSelectedKey());
        prvt.setChkYokaigodo(div.getChkYokaigodo().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki1(div.getChkShutsuryokuYoshiki1().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki2(div.getChkShutsuryokuYoshiki2().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki3(div.getChkShutsuryokuYoshiki3().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki4(div.getChkShutsuryokuYoshiki4().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki5(div.getChkShutsuryokuYoshiki5().getSelectedKeys());
        ViewStateHolder.put(ViewStateKeys.受給者給付, prvt);
        return ResponseData.of(div).forwardWithEventName(DBC5000011TransitionEventName.対象者検索).respond();
    }

    /**
     * 「被保険者番号 終了検索ボタン」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnHihokenshaNoToSearch(JukyushaKyufuJissekiDaichoDiv div) {
        ViewStateHolder.put(ViewStateKeys.番号, 遷移2);
        JukyushaKyufuJissekiDaichoPreservation prvt = new JukyushaKyufuJissekiDaichoPreservation();
        prvt.setRadKonkaiTaishoYM(div.getRadKonkaiTaishoYM().getSelectedKey());
        prvt.setTxtRangeYMFrom(new RString(div.getTxtRangeYM().getFromValue().toString()));
        prvt.setTxtRangeYMTo(new RString(div.getTxtRangeYM().getToValue().toString()));
        prvt.setTxtRangeHihokenshaNoFrom(div.getTxtRangeHihokenshaNoFrom().getValue());
        prvt.setRadKyufuJissekiKubun(div.getRadKyufuJissekiKubun().getSelectedKey());
        prvt.setChkYokaigodo(div.getChkYokaigodo().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki1(div.getChkShutsuryokuYoshiki1().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki2(div.getChkShutsuryokuYoshiki2().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki3(div.getChkShutsuryokuYoshiki3().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki4(div.getChkShutsuryokuYoshiki4().getSelectedKeys());
        prvt.setChkShutsuryokuYoshiki5(div.getChkShutsuryokuYoshiki5().getSelectedKeys());
        ViewStateHolder.put(ViewStateKeys.受給者給付, prvt);
        return ResponseData.of(div).forwardWithEventName(DBC5000011TransitionEventName.対象者検索).respond();
    }

    /**
     * 「事業者番号開始検索」ボタン。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoFrom_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号開始検索」ボタン。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoFrom_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号終了検索」ボタン。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoTo_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号終了検索」ボタン。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoTo_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「計画作成事業者番号」ボタン
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnKeikakuSakuseiJigyoshoNo_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「計画作成事業者番号」ボタン
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnKeikakuSakuseiJigyoshoNo_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」（台帳用）「実行する」（一覧表用）
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<DBC140020_JukyushaKyufujissekiIchiranParameter>
     */
    public ResponseData<DBC140020_JukyushaKyufujissekiIchiranParameter> onClick_btnParameter(JukyushaKyufuJissekiDaichoDiv div) {
        return ResponseData.of(getHandler(div).setバッチパラメータの設定()).respond();
    }

    /**
     * 「老人保健市町村番号有無」ボタン のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onChange_radRojinHokenShikuchosonNoUmu(JukyushaKyufuJissekiDaichoDiv div) {
        RString 老人保健市町村番号有無 = div.getTabChushutsuJoken().getRadRojinHokenShikuchosonNoUmu().getSelectedValue();
        if (老人保健市町村番号有無.equals(全て)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(true);
        } else if (老人保健市町村番号有無.equals(なし)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(true);
        } else if (老人保健市町村番号有無.equals(あり)) {
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeFrom().setReadOnly(false);
            div.getTabChushutsuJoken().getTxtRojinhokenShikuchosonNoRangeTo().setReadOnly(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「老人保健受給者番号有無」ボタン のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onChange_radRojinHokenJukyushaNoUmu(JukyushaKyufuJissekiDaichoDiv div) {
        RString 老人保健受給者番号有無 = div.getTabChushutsuJoken().getRadRojinHokenJukyushaNoUmu().getSelectedValue();
        if (老人保健受給者番号有無.equals(全て)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(true);
        } else if (老人保健受給者番号有無.equals(なし)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(true);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(true);
        } else if (老人保健受給者番号有無.equals(あり)) {
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoFrom().setReadOnly(false);
            div.getTabChushutsuJoken().getTxtRojinHokenJukyushaNoTo().setReadOnly(false);
        }
        return ResponseData.of(div).respond();
    }

    private JukyushaKyufuJissekiDaichoHandler getHandler(JukyushaKyufuJissekiDaichoDiv div) {
        return new JukyushaKyufuJissekiDaichoHandler(div);
    }
}
