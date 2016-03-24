/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0540001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0540001.ChoshuInfoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0540001.ChoshuInfoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 徴収方法変更_世帯所得情報一覧エリアのクラスです。
 */
public class ChoshuInfo {

    /**
     * 画面初期化
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<ChoshuInfoDiv> onLoad(ChoshuInfoDiv div) {

        // TODO 該当者検索画面ViewState．被保険者番号
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(new RString("88888888")));
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        // TODO 該当者検索画面ViewState．賦課年度
        ViewStateHolder.put(ViewStateKeys.賦課年度, new FlexibleYear(new RString("2016")));
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);

        ChoshuInfoHandler handler = new ChoshuInfoHandler(div);
        handler.set世帯所得情報一覧エリア(賦課年度, 被保険者番号);

        return ResponseData.of(div).respond();

    }

    /**
     * 普通徴収に切り替える月DDLはonChange
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<ChoshuInfoDiv> onChange(ChoshuInfoDiv div) {

        ChoshuInfoHandler handler = new ChoshuInfoHandler(div);
        handler.change普通徴収に切り替える月DDL();

        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下
     *
     * @param div ChoshuInfoDiv
     * @return ResponseData
     */
    public ResponseData<ChoshuInfoDiv> onClick_btnUpdate(ChoshuInfoDiv div) {

        ChoshuInfoHandler handler = new ChoshuInfoHandler(div);
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.saveボタンを押下(賦課年度, 被保険者番号);

        return ResponseData.of(div).respond();
    }

}
