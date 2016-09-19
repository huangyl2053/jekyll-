/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1230011;

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
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
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

    private KogakuGassanShikyuKetteiHoseiPanelHandler getHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelHandler(div);
    }

    private KogakuGassanShikyuKetteiHoseiPanelValidationHandler getCheckHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        return new KogakuGassanShikyuKetteiHoseiPanelValidationHandler(div);
    }

}
