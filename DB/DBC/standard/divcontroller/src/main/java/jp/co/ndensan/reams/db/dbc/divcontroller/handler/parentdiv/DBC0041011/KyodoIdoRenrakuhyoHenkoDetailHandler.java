/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0041011;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0041011.KyodoIdoRenrakuhyoHenkoDetailDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 共同処理用受給者異動連絡票情報照会のHandlerです。
 *
 * @reamsid_L DBC-2990-010 chenaoqi
 */
public class KyodoIdoRenrakuhyoHenkoDetailHandler {

    private final KyodoIdoRenrakuhyoHenkoDetailDiv div;
    private static final RString 照会モード = new RString("照会");
    private static final Code 業務固有コード = new Code("0003");
    private static final RString 名称 = new RString("被保険者番号");

    /**
     * 共同処理用受給者異動連絡票情報照会表示のHandlerです。
     *
     * @param div SetaiPanelDiv
     */
    public KyodoIdoRenrakuhyoHenkoDetailHandler(KyodoIdoRenrakuhyoHenkoDetailDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 対象者一覧 KyodoJukyushaTaishoshaEntity
     */
    public void load共有子Div(KyodoJukyushaTaishoshaEntity 対象者一覧) {
        div.getKyodoIdoRenrakuhyoHenkoDetailInfo().initialize(照会モード, 対象者一覧.get被保番号(), 対象者一覧.get異動日(),
                false, 対象者一覧.get対象年月());
        ShikibetsuCode 識別コード = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().get識別コード(対象者一覧.get被保番号());
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 対象者一覧.get被保番号().getColumnValue()));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(業務固有コード, 名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }
}
