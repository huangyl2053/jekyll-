/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5000011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140010.DBC140010_JukyushaKyufujissekiDaichoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140020.DBC140020_JukyushaKyufujissekiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.DBC5000011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.DBC5000011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoPreservation;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.servicechushutsukbn.ServiceChushutsuKbn;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 受給者給付実績一覧表発行 のDivControllerクラスです。
 *
 * @reamsid_L DBC-3070-010 dangjingjing
 */
public class JukyushaKyufuJissekiDaicho {

    private static final RString 全て = new RString("全て");
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final RString 遷移1 = new RString("1");
    private static final RString 遷移2 = new RString("2");
    private static final int 月１３以上 = 12;
    private static final Decimal いち = new Decimal("1");
    private static final Decimal いちゼロ = new Decimal("100");
    private static final RString MENUID_DBCMNJ1001 = new RString("DBCMNJ1001");
    private static final RString MENUID_DBCMNJ1002 = new RString("DBCMNJ1002");
    private static final RString 受給者給付実績台帳 = new RString("受給者給付実績台帳");
    private static final RString 受給者給付実績一覧表 = new RString("受給者給付実績一覧表");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onLond(JukyushaKyufuJissekiDaichoDiv div) {
        RString 被保険者番号_FromOrTO = ViewStateHolder.get(ViewStateKeys.番号, RString.class);
        ResponseData<JukyushaKyufuJissekiDaichoDiv> responseData;
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
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnShutsuryokuYoshikiAllCheck(JukyushaKyufuJissekiDaichoDiv div) {
        getHandler(div).set出力様式ボタン();
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保険者番号 開始検索ボタン」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
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
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
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
     * 「事業者番号開始検索」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoFrom_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setサービス種類抽出区分(ServiceChushutsuKbn.保険給付.getコード());
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号開始検索」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDivgg
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoFrom_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        if (!RString.isNullOrEmpty(mode.getJigyoshaNo().value()) && mode.getJigyoshaNo().value() != null) {
            div.getTxtJigyoshaNoFrom().setValue(mode.getJigyoshaNo().value());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号終了検索」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoTo_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setサービス種類抽出区分(ServiceChushutsuKbn.保険給付.getコード());
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者番号終了検索」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnJigyoshaNoTo_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        if (!RString.isNullOrEmpty(mode.getJigyoshaNo().value()) && mode.getJigyoshaNo().value() != null) {
            div.getTxtJigyoshaNoTo().setValue(mode.getJigyoshaNo().value());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「計画作成事業者番号」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnKeikakuSakuseiJigyoshoNo_onBeforeOpen(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setサービス種類抽出区分(ServiceChushutsuKbn.保険給付.getコード());
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「計画作成事業者番号」のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onClick_btnKeikakuSakuseiJigyoshoNo_onOkClose(JukyushaKyufuJissekiDaichoDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        if (!RString.isNullOrEmpty(mode.getJigyoshaNo().value()) && mode.getJigyoshaNo().value() != null) {
            div.getTxtKeikakuSakuseiJigyoshoNo().setValue(mode.getJigyoshaNo().value());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」（一覧表用）のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<DBC140020_JukyushaKyufujissekiIchiranParameter>
     */
    public ResponseData<DBC140020_JukyushaKyufujissekiIchiranParameter> onClick_btnParameter(JukyushaKyufuJissekiDaichoDiv div) {
        return ResponseData.of(getHandler(div).setバッチパラメータの設定()).respond();
    }

    /**
     * 「実行する」（台帳用）のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<DBC140010_JukyushaKyufujissekiDaichoParameter>
     */
    public ResponseData<DBC140010_JukyushaKyufujissekiDaichoParameter> onClick_btnParameterDBC140010(JukyushaKyufuJissekiDaichoDiv div) {
        return ResponseData.of(getHandler(div).setバッチパラメータの設定1()).respond();
    }

    /**
     * 「老人保健市町村番号有無」ボタン のメソッドます。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
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
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
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

    private JukyushaKyufuJissekiDaichoValidationHandler getValidation(JukyushaKyufuJissekiDaichoDiv div) {
        return new JukyushaKyufuJissekiDaichoValidationHandler(div);
    }

    /**
     * 入力チェックを実行します。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     * @return ResponseData<JukyushaKyufuJissekiDaichoDiv>
     */
    public ResponseData<JukyushaKyufuJissekiDaichoDiv> onBefore_btnParameter(JukyushaKyufuJissekiDaichoDiv div) {
        boolean flag = true;
        ValidationMessageControlPairs message = new ValidationMessageControlPairs();
        if (div.getTxtRangeYM().getFromValue() == null) {
            flag = false;
            message.add(getValidation(div).check開始終了年月が必須(new RString("開始年月を")));
        }
        if (div.getTxtRangeYM().getToValue() == null) {
            flag = false;
            message.add(getValidation(div).check開始終了年月が必須(new RString("終了年月を")));
        }
        if (flag && div.getTxtRangeYM().getToValue().isBefore(div.getTxtRangeYM().getFromValue())) {
            message.add(getValidation(div).check大小関係不正(new RString("年月")));
        }
        if (flag && div.getTxtRangeYM().getToValue().getYearValue() - div.getTxtRangeYM().getFromValue().getYearValue() != 0
                && div.getTxtRangeYM().getToValue().getMonthValue() - div.getTxtRangeYM().getFromValue().getMonthValue() >= 0) {
            message.add(getValidation(div).check年月範囲不正());
        }
        if (!RString.isNullOrEmpty(div.getTxtRangeHihokenshaNoFrom().getValue())
                && !RString.isNullOrEmpty(div.getTxtRangeHihokenshaNoTo().getValue())
                && div.getTxtRangeHihokenshaNoFrom().getValue().compareTo(div.getTxtRangeHihokenshaNoTo().getValue()) > 0) {
            message.add(getValidation(div).check大小関係不正(new RString("被保険者番号")));
        }
        if (div.getTxtRojinhokenShikuchosonNoRangeFrom().getValue().compareTo(div.getTxtRojinhokenShikuchosonNoRangeTo().getValue()) > 0) {
            message.add(getValidation(div).check大小関係不正(new RString("老人保健市町村番号")));
        }
        onBefore_btnParameter1(message, div);
        if (message.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void onBefore_btnParameter1(ValidationMessageControlPairs message, JukyushaKyufuJissekiDaichoDiv div) {
        List<RString> 要介護を = div.getChkYokaigodo().getSelectedKeys();
        List<RString> 出力様式を1 = div.getChkShutsuryokuYoshiki1().getSelectedKeys();
        List<RString> 出力様式を2 = div.getChkShutsuryokuYoshiki2().getSelectedKeys();
        List<RString> 出力様式を3 = div.getChkShutsuryokuYoshiki3().getSelectedKeys();
        List<RString> 出力様式を4 = div.getChkShutsuryokuYoshiki4().getSelectedKeys();
        List<RString> 出力様式を5 = div.getChkShutsuryokuYoshiki5().getSelectedKeys();
        if (div.getTxtRojinHokenJukyushaNoFrom().getValue().compareTo(div.getTxtRojinHokenJukyushaNoTo().getValue()) > 0) {
            message.add(getValidation(div).check大小関係不正(new RString("老人保健受給者番号")));
        }
        if (div.getTxtJigyoshaNoFrom().getValue().compareTo(div.getTxtJigyoshaNoTo().getValue()) > 0) {
            message.add(getValidation(div).check大小関係不正(new RString("事業者番号")));
        }
        if (要介護を == null || 要介護を.isEmpty()) {
            message.add(getValidation(div).check未指定(new RString("要介護を")));
        }
        if (出力様式を1.isEmpty() && 出力様式を2.isEmpty() && 出力様式を3.isEmpty() && 出力様式を4.isEmpty() && 出力様式を5.isEmpty()) {
            message.add(getValidation(div).check未指定(new RString("出力様式を")));
        }
        if (div.getTabChushutsuJoken().getTxtKyufuritsu().getValue() != null
                && div.getTabChushutsuJoken().getTxtKyufuritsu().getValue().compareTo(いち) > 0
                && div.getTabChushutsuJoken().getTxtKyufuritsu().getValue().compareTo(いちゼロ) > 0) {
            message.add(getValidation(div).check必須項目を入力(new RString("１～100")));
        }
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null) {
            message.add(getValidation(div).check出力順序を指定());
        }
    }
}
