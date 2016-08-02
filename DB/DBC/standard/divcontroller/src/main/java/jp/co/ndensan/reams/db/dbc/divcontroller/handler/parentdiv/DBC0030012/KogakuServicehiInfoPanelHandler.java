/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030012.KogakuServicehiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のHandlerです。
 *
 * @reamsid_L DBC-3000-030 gongliang
 */
public class KogakuServicehiInfoPanelHandler {

    private final KogakuServicehiInfoPanelDiv div;
    private static final int INT_ゼロ = 0;
    private static final RString 無 = new RString("無し");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 個人番号_利用有無 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無 = new RString("法人番号 利用有無");
    private static final RString 照会モード = new RString("照会モード");

    /**
     * 画面設計_DBCMN11004_高額介護サービス費照会のコンストラクタです。
     *
     * @param div KogakuServicehiInfoPanelDiv
     */
    public KogakuServicehiInfoPanelHandler(KogakuServicehiInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KogakuServiceData
     */
    public void load共有子Div(KogakuServiceData 引き継ぎ情報) {
        RString メニューID = ResponseHolder.getMenuID();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
        int 履歴番号 = 引き継ぎ情報.get履歴番号() != null ? 引き継ぎ情報.get履歴番号().intValue() : INT_ゼロ;
        HokenshaNo 証記載保険者番号 = 引き継ぎ情報.get証記載保険者番号();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getCcdKogakuServiceDetail().initialize(照会モード, メニューID, 被保険者番号, サービス提供年月, 証記載保険者番号, 履歴番号, 識別コード);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code("0001"), 個人番号_利用有無, 無);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code("0002"), 法人番号_利用有無, 無);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code("0003"), 被保険者番号R, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3);
    }
}
