/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0320001;

import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiControlDiv;
//import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
//import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
//import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
//import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠・期割画面の賦課照会コントロールdivです。
 *
 * @author N3317 塚田 萌
 */
public class FukaShokaiControl {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> onLoad(FukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> onActive(FukaShokaiControlDiv div) {
        return reLoad(div);
    }

    /**
     * コントロールdivの初期処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> initialize(FukaShokaiControlDiv div) {

        // TODO n8187久保田 画面遷移の確認のために一時的にコメントアウト。
        // ここから
//        FukaTaishoshaKey fukaTaishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
//        final FukaManager fukaFinder = new FukaManager();
        // ここまで
        // TODO n8187久保田 画面遷移の確認のために仮データで賦課情報を作成。
        // ここから
        FukaShokaiKey key = new FukaShokaiKey(FlexibleYear.EMPTY, FlexibleYear.EMPTY, TsuchishoNo.EMPTY,
                0, HihokenshaNo.EMPTY, FlexibleDate.MAX,
                RString.EMPTY, YMDHMS.now(), SanteiState.仮算定,
                true, true, AtenaMeisho.EMPTY);
//       // TODO 賦課根拠かこっちかでDBアクセスを一回にしたい
//        FukaModel model = fukaFinder.find賦課直近(
//                new ChoteiNendo(fukaTaishoshaKey.get調定年度()),
//                new FukaNendo(fukaTaishoshaKey.get賦課年度()),
//                fukaTaishoshaKey.get通知書番号()).findFirst().get();
//
//        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);
        // ここまで

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
        // TODO n8187久保田 画面遷移の確認のために仮データで賦課照会キーを作成。
        // ここから
        FukaShokaiKey key = new FukaShokaiKey(FlexibleYear.EMPTY, FlexibleYear.EMPTY, TsuchishoNo.EMPTY,
                0, HihokenshaNo.EMPTY, FlexibleDate.MAX,
                RString.EMPTY, YMDHMS.now(), SanteiState.仮算定,
                true, true, AtenaMeisho.EMPTY);
//        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        // ここまで

        return createResponseData(setDisplay(div, key));
    }

    private FukaShokaiControlDiv setDisplay(FukaShokaiControlDiv div, FukaShokaiKey key) {
        // TODO n8187久保田 画面遷移の確認のために一時的にコメントアウト。
        // ここから
//        div.getTxtChoteiNendo().setDomain(key.get調定年度().value());
//        div.getTxtKoseiM().setValue(key.get更正月());
//        div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
//        div.getTxtKoseiTime().setValue(key.get更正日時().getTime());
        // ここまで

        return div;
    }

    private ResponseData<FukaShokaiControlDiv> createResponseData(FukaShokaiControlDiv div) {
        return ResponseData.of(div).respond();
    }
}
