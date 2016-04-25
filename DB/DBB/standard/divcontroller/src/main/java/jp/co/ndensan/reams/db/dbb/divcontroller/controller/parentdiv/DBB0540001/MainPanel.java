/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.MainPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0540001.MainPanelHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 徴収方法変更のクラスです。
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
public class MainPanel {

    /**
     * 画面初期化
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {

        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKey.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = 賦課対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();

        MainPanelHandler handler = new MainPanelHandler(div);
        handler.setヘッダエリア(識別コード, 被保険者番号);
        handler.set世帯所得情報一覧エリア(賦課年度, 被保険者番号);

        return ResponseData.of(div).respond();
    }

    /**
     * 普通徴収に切り替える月DDLはonChange
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onChange(MainPanelDiv div) {

        MainPanelHandler handler = new MainPanelHandler(div);
        handler.change普通徴収に切り替える月DDL();

        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnUpdate(MainPanelDiv div) {

        MainPanelHandler handler = new MainPanelHandler(div);
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.saveボタンを押下(賦課年度, 被保険者番号);

        return ResponseData.of(div).respond();
    }

}
