/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.DBD1040001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
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
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBDGM21005_1_特別地域加算減免申請のDivControllerです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokuteiNyushoServiceHiShinsei {

    private final RString 保存する = new RString("btnUpdate");

    /**
     * 画面初期化
     *
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return ResponseData<TokuteiNyushoServiceHiShinseiDiv>
     */
    public ResponseData<TokuteiNyushoServiceHiShinseiDiv> onLoad(TokuteiNyushoServiceHiShinseiDiv div) {
        //TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        TaishoshaKey 資格対象者 = new TaishoshaKey(
                new HihokenshaNo(new RString("0000000001")),
                new ShikibetsuCode(new RString("000000000000010")),
                new SetaiCode(new RString("000000000000100")));
        getHandler(div).initialize(資格対象者);
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (!ResponseHolder.isReRequest()
                && (被保険者番号 == null || 被保険者番号.getColumnValue().isEmpty())) {
            div.getShinsei().getBtnDispGemmenJoho().setDisabled(true);
            div.getShinsei().getShinseiList().getBtnAddShinsei().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            div.getShinsei().getShinseiList().getDgShinseiList().setDisabled(true);
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = TokubetsuChiikiKasanGemmenService.createIntance()
                .get特別地域加算減免申請の情報(被保険者番号);
        if (特別地域加算減免申請の情報List != null) {
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請の情報List, new ArrayList<>(特別地域加算減免申請の情報List));
            ArrayList<TokubetsuChiikiKasanGemmenViewState> viewStateList = new ArrayList<>();
            getHandler(div).申請一覧エリアの初期設定(特別地域加算減免申請の情報List, viewStateList);
            ViewStateHolder.put(ViewStateKeys.特別地域加算減免申請情報ListのViewState, viewStateList);
        }
        PersonalData personalData = PersonalData.of(識別コード, new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
        getHandler(div).前排他の設定(被保険者番号);
        return ResponseData.of(div).setState(DBD1040001StateName.一覧);
    }

    private TokuteiNyushoServiceHiShinseiHandler getHandler(TokuteiNyushoServiceHiShinseiDiv div) {
        return new TokuteiNyushoServiceHiShinseiHandler(div);
    }
}
