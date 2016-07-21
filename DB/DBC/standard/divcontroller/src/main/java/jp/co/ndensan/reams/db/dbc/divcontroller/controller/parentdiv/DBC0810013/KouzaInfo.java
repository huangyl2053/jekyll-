/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810013;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013.KouzaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_口座情報のクラス
 *
 * @reamsid_L DBC-1010-080 gongliang
 */
public class KouzaInfo {

    private static final RString 照会 = new RString("照会");

    /**
     * 画面初期化onLoad
     *
     * @param div KouzaInfoDiv
     * @return 償還払い状況照会_口座情報画面
     */
    public ResponseData<KouzaInfoDiv> onLoad(KouzaInfoDiv div) {

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.サービス年月, RString.class).toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);

        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        List<ShokanShinsei> shokanShinseiList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (shokanShinseiList == null || shokanShinseiList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).setヘッダ_エリア(new RDate(サービス年月.toString()), 整理番号);
        ShokanShinsei 支給申請情報 = shokanShinseiList.get(0);
        SikyuSinseiJyohoParameter parameter = new SikyuSinseiJyohoParameter();
        parameter.setShikibetsuCode(識別コード);
        parameter.setHihokenshaNo(支給申請情報.get被保険者番号());
        parameter.setShikyushinseiServiceYM(支給申請情報.getサービス提供年月());
        parameter.setShikyushinseiSeiriNo(支給申請情報.get整理番号());
        if (支給申請情報.get支払方法区分コード() != null && !支給申請情報.get支払方法区分コード().isEmpty()) {
            parameter.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(支給申請情報.get支払方法区分コード()));
        }
        parameter.setKeiyakuNo(支給申請情報.get受領委任契約番号());
        if (支給申請情報.get支払期間開始年月日() != null) {
            parameter.setStartYMD(new RDate(支給申請情報.get支払期間開始年月日().toString()));
        }
        if (支給申請情報.get支払期間終了年月日() != null) {
            parameter.setEndYMD(new RDate(支給申請情報.get支払期間終了年月日().toString()));
        }
        RString 支払窓口開始時間 = 支給申請情報.get支払窓口開始時間();
        if (支払窓口開始時間 != null && !支払窓口開始時間.isEmpty()) {
            parameter.setStartHHMM(new RTime(支給申請情報.get支払窓口開始時間()));
        }
        RString 支払窓口終了時間 = 支給申請情報.get支払窓口終了時間();
        if (支払窓口終了時間 != null && !支払窓口終了時間.isEmpty()) {
            parameter.setEndHHMM(new RTime(支給申請情報.get支払窓口終了時間()));
        }
        parameter.setKozaId(支給申請情報.get口座ID());
        parameter.setShiharaiBasho(支給申請情報.get支払場所());
        div.getPanelShinseiNaiyo().getCcdShiharaiHohoJyoho().initialize(parameter, 照会);
        return createResponse(div);
    }

    private KouzaInfoHandler getHandler(KouzaInfoDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoDiv> createResponse(KouzaInfoDiv div) {
        return ResponseData.of(div).respond();
    }
}
