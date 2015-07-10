/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaShokaiControlDiv;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 根拠・期割画面の賦課照会コントロールdivです。
 *
 * @author N3317 塚田 萌
 */
public class FukaShokaiControl {

    /**
     * コントロールdivの初期処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> initialize(FukaShokaiControlDiv div) {

        FukaTaishoshaKey fukaTaishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        final FukaManager fukaFinder = new FukaManager();

        // TODO 賦課根拠かこっちかでDBアクセスを一回にしたい
        FukaModel model = fukaFinder.find賦課直近(
                new ChoteiNendo(fukaTaishoshaKey.get調定年度()),
                new FukaNendo(fukaTaishoshaKey.get賦課年度()),
                fukaTaishoshaKey.get通知書番号()).findFirst().get();

        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);

        return createResponseData(setDisplay(div, key));
//        return createResponseData(div);
    }

    /**
     * コントロールdivの初期処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> reLoad(FukaShokaiControlDiv div) {
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

        return createResponseData(setDisplay(div, key));
    }

    private FukaShokaiControlDiv setDisplay(FukaShokaiControlDiv div, FukaShokaiKey key) {
        div.getTxtChoteiNendo().setDomain(key.get調定年度().value());
        div.getTxtKoseiM().setValue(key.get更正月());
        div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
        div.getTxtKoseiTime().setValue(key.get更正日時().getTime());

        return div;
    }

    private ResponseData<FukaShokaiControlDiv> createResponseData(FukaShokaiControlDiv div) {
        ResponseData<FukaShokaiControlDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
