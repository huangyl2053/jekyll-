/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0020011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.DBC0020011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0020011.KyotakuServiceKeikakuShokaiMainHander;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBC0020011_居宅サービス計画照会のクラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
public class KyotakuServiceKeikakuShokaiMain {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onLoad(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.getHander(div).initialize();
        return ResponseData.of(div).setState(DBC0020011StateName.初期表示);
    }

    /**
     * 対象情報一覧を取得のメソッドます。
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_dgKyotakuServiceRirekiIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.getHander(div).get対象情報一覧();
        return ResponseData.of(div).setState(DBC0020011StateName.届出表示);
    }

    /**
     * サービス利用票を取得
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_dgRiyoNentstsuIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.getHander(div).getサービス利用票();
        return ResponseData.of(div).setState(DBC0020011StateName.明細表示);
    }

    /**
     * 「履歴一覧戻る」ボタン
     *
     * @param div KyotakuServiceKeikakuShokaiMainDiv
     * @return ResponseData
     */
    public ResponseData<KyotakuServiceKeikakuShokaiMainDiv> onClick_btnBackRirekiIchiran(KyotakuServiceKeikakuShokaiMainDiv div) {
        this.getHander(div).initialize();
        return ResponseData.of(div).setState(DBC0020011StateName.初期表示);
    }

    private KyotakuServiceKeikakuShokaiMainHander getHander(KyotakuServiceKeikakuShokaiMainDiv div) {
        return new KyotakuServiceKeikakuShokaiMainHander(div);
    }
}
