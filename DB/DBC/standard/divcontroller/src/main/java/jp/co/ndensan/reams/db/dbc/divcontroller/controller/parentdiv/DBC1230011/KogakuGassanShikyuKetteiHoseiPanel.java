/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1230011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.DBC1230011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHosei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanel {

    private static final RString 高額合算支給決定情報補正 = new RString("高額合算支給決定情報補正（単）");
    private static final RString 事業高額合算支給決定情報補正 = new RString("事業分高額合算支給決定情報補正（単）");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 削除照会モード = new RString("削除照会モード");
    private static final RString 照会 = new RString("照会");
    private static final RString 処理不可 = new RString("処理不可");
    private static final int NUM_FOUR = 4;
    private static final int NUM_SIX = 6;
    private static final int NUM_ELEVEN = 11;

    /**
     * 画面初期化です。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onLoad(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        getHandler(div).set事業分フラグ();
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(DbcInformationMessages.被保険者でないデータ.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        if (識別コード != null && !識別コード.isEmpty()) {
            div.getCcdKaigoAtenaInfo().initialize(識別コード);
        }
        getHandler(div).getデータ存在チェック(被保険者番号);
        if (!getHandler(div).is前排他キーのセット(被保険者番号)) {
            throw new PessimisticLockingException();
        }
        AccessLogger.log(AccessLogType.照会,
                getHandler(div).toPersonalData(識別コード,
                        被保険者番号.getColumnValue()));
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        getHandler(div).set新規と検索条件登録パネル();
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBC1230011StateName.支給決定情報一覧).data).rootTitle(高額合算支給決定情報補正).respond();
        } else {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBC1230011StateName.支給決定情報一覧).data).rootTitle(事業高額合算支給決定情報補正).respond();
        }
    }

    /**
     * 「検索する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnKensaku(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        boolean 事業分フラグ = false;
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            事業分フラグ = true;
        }
        List<KogakuGassanShikyuKetteiHoseiResult> result = KogakuGassanShikyuKetteiHosei.createInstance().
                selectShikyuKetteiHoseiList(
                        new FlexibleYear(div.getSearchPanel().getTxtKensakuTaishoNendo().getValue().toDateString()),
                        new HokenshaNo(div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue()),
                        div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue(), 事業分フラグ);
        if (result == null || result.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.支給決定情報補正, (Serializable) result);
        getHandler(div).set決定情報一覧グリッド(result);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報一覧);
    }

    /**
     * 「新規登録_対象年度」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiTaishoNendo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check新規登録_対象年度();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規登録_証記載保険者番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiHihokenshaNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check新規登録_証記載保険者番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規登録_連絡票整理番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtShinkiShikyuSeiriNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check新規登録_連絡票整理番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() == null
                && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()) {
            //TODO
            div.getShinkiPanel().getTxtShinkiTaishoNendo().setValue(new RDate(div.getShinkiPanel().
                    getTxtShinkiShikyuSeiriNo().getValue().substring(0, NUM_FOUR).toString()));
        }
        if ((div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() == null
                || div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty())
                && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()) {
            div.getShinkiPanel().getTxtShinkiHihokenshaNo().setValue(div.getShinkiPanel().
                    getTxtShinkiShikyuSeiriNo().getValue().substring(NUM_SIX, NUM_ELEVEN));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_対象年度」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuTaishoNendo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check検索条件_対象年度();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_証記載保険者番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuHihokenshaNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check検索条件_証記載保険者番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件_連絡票整理番号」イベントです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onChange_txtKensakuShikyuSeiriNo(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check検索条件_連絡票整理番号();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「決定情報を追加する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_btnKetteiJohoAdd(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).check決定情報を追加する();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 新規);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set新規決定情報初期値(被保険者番号, 識別コード);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を修正する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_modify(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 修正);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set新規以外の決定情報(修正, 識別コード);

        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を選択する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_select(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).set新規以外の決定情報(照会, 識別コード);
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    /**
     * 「決定情報を削除する」ボタンです。
     *
     * @param div KogakuGassanShikyuKetteiHoseiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KogakuGassanShikyuKetteiHoseiPanelDiv> onClick_delete(
            KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 処理モー = getHandler(div).get処理モード(被保険者番号, 削除);
        if (処理不可.equals(処理モー)) {
            return ResponseData.of(div).respond();
        }
        if (削除照会モード.equals(処理モー)) {
            getHandler(div).set新規以外の決定情報(照会, 識別コード);
        } else {
            getHandler(div).set新規以外の決定情報(削除, 識別コード);
        }
        return ResponseData.of(div).setState(DBC1230011StateName.支給決定情報補正);
    }

    private KogakuGassanShikyuKetteiHoseiPanelHandler getHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelHandler(div);
    }

    private KogakuGassanShikyuKetteiHoseiPanelValidationHandler getCheckHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelValidationHandler(div);
    }

}
