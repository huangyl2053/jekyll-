/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1270011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011.DBC1270011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011.KogakuGassanKyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1270011.KogakuGassanKyufuJissekiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1270011.KogakuGassanKyufuJissekiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassankyufujisseki.KogakuGassanKyufuJissekiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額合算給付実績照会のコントローラです。
 *
 * @reamsid_L DBC-3010-010 linghuhang
 */
public class KogakuGassanKyufuJisseki {

    /**
     * 画面初期化処理です。
     *
     * @param div KogakuGassanKyufuJissekiDiv
     * @return ResponseData<KogakuGassanKyufuJissekiDiv>
     */
    public ResponseData<KogakuGassanKyufuJissekiDiv> onLoad(KogakuGassanKyufuJissekiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getDataGrid1().getActiveRow().setSelectButtonState(DataGridButtonState.Disabled);
            return ResponseData.of(div).addMessage(new InformationMessage(
                    DbcInformationMessages.被保険者でないデータ.getMessage().getCode(),
                    DbcInformationMessages.被保険者でないデータ.getMessage().evaluate())).respond();
        }
        setアクセスログ(識別コード, 被保険者番号);
        boolean isデータ存在 = KogakuGassanKyufuJissekiFinder.createInstance().isデータ存在チェック(被保険者番号);
        boolean is高額合算給付実績チェック = KogakuGassanKyufuJissekiFinder.createInstance().is高額合算給付実績チェック(被保険者番号);
        if (isデータ存在) {
            div.getDataGrid1().getActiveRow().setSelectButtonState(DataGridButtonState.Disabled);
            return ResponseData.of(div).addValidationMessages(getValidationHandler().do受給共通チェック()).respond();
        }
        if (is高額合算給付実績チェック) {
            div.getDataGrid1().getActiveRow().setSelectButtonState(DataGridButtonState.Disabled);
            return ResponseData.of(div).addValidationMessages(getValidationHandler().do高額合算給付実績チェック()).respond();
        }
        List<jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki> 高額合算給付実績情報
                = KogakuGassanKyufuJissekiFinder.createInstance().getKogakuGassanKyufuJisseki(被保険者番号).records();
        getHandler(div).onLoad(被保険者番号, 識別コード, 高額合算給付実績情報);
        return ResponseData.of(div).setState(DBC1270011StateName.初期化);
    }

    /**
     * 選択ボタンを押下する場合、画面詳細を表示する。
     *
     * @param div KogakuGassanKyufuJissekiDiv
     * @return ResponseData<KogakuGassanKyufuJissekiDiv>
     */
    public ResponseData<KogakuGassanKyufuJissekiDiv> onclik_selectButton(KogakuGassanKyufuJissekiDiv div) {
        getHandler(div).onclik_selectButton(div.getDataGrid1().getActiveRow());
        return ResponseData.of(div).setState(DBC1270011StateName.詳細);
    }

    /**
     * 「給付実績一覧に戻る」ボタンを押下する場合、画面一覧を表示する。
     *
     * @param div KogakuGassanKyufuJissekiDiv
     * @return ResponseData<KogakuGassanKyufuJissekiDiv>
     */
    public ResponseData<KogakuGassanKyufuJissekiDiv> onclik_itiranBack(KogakuGassanKyufuJissekiDiv div) {
        return ResponseData.of(div).setState(DBC1270011StateName.初期化);
    }

    private KogakuGassanKyufuJissekiHandler getHandler(KogakuGassanKyufuJissekiDiv div) {
        return new KogakuGassanKyufuJissekiHandler(div);
    }

    private KogakuGassanKyufuJissekiValidationHandler getValidationHandler() {
        return new KogakuGassanKyufuJissekiValidationHandler();
    }

    private void setアクセスログ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(new Code("003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
    }
}
