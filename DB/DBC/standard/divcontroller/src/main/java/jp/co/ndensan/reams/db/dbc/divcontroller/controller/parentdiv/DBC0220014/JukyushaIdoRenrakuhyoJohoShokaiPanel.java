/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0220014;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220014.DBC0220014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220014.JukyushaIdoRenrakuhyoJohoShokaiPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受給者異動連絡票情報照会です
 *
 * @reamsid_L DBC-3060-010 lihang
 */
public class JukyushaIdoRenrakuhyoJohoShokaiPanel {

    private static final RString 被保険者番号_なし = new RString("被保険者番号なし");
    private static final RString 処理モード = new RString("照会モード");
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString CODE_ミ = new RString("0003");

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_ミ), 被保番号, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * onLoadです
     *
     * @param div JukyushaIdoRenrakuhyoJohoShokaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoJohoShokaiPanelDiv> onLoad(
            JukyushaIdoRenrakuhyoJohoShokaiPanelDiv div) {
        KyodoJukyushaTaishoshaEntity entity = ViewStateHolder.get(
                ViewStateKeys.一覧検索キー, KyodoJukyushaTaishoshaEntity.class);
        int 履歴番号 = entity.get履歴番号();
        boolean 論理削除フラグ = entity.is論理削除フラグ();
        FlexibleDate 異動日 = entity.get異動日();
        HihokenshaNo 被保険者番号 = entity.get被保番号();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        if ((被保険者番号 == null || 被保険者番号.isEmpty())) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(
                    被保険者番号_なし.toString()));
        }
        div.getCcdJukyushaIdoRenrakuhyo().initialize(処理モード, ShikibetsuCode.EMPTY, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        return ResponseData.of(div).respond();

    }

    /**
     * 検索画面に戻るを処理します。
     *
     * @param div JukyushaIdoRenrakuhyoJohoShokaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoJohoShokaiPanelDiv> onClick_btnCancel(
            JukyushaIdoRenrakuhyoJohoShokaiPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0220014TransitionEventName.対象者検索へ).respond();

    }
}
