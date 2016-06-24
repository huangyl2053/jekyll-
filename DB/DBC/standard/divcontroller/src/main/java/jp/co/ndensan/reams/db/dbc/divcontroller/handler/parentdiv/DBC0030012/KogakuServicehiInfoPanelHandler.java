/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030012.KogakuServicehiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のHandlerです。
 *
 * @reamsid_L DBC-3000-030 gongliang
 */
public class KogakuServicehiInfoPanelHandler {

    private final KogakuServicehiInfoPanelDiv div;
//    private static final RString 照会モード = new RString("'照会");

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
//        RString メニューID = ResponseHolder.getMenuID();
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
//        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
//        RString 履歴番号 = 引き継ぎ情報.get履歴番号();
//        HokenshaNo 証記載保険者番号 = 引き継ぎ情報.get証記載保険者番号();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        // TODO この「高額サービス費詳細内容入力」共有子Divは実装しない。
//        div.getCcdKogakuServiceDetail().onLoad(照会モード, メニューID, 被保険者番号, サービス提供年月, 証記載保険者番号, 履歴番号);

    }
}
