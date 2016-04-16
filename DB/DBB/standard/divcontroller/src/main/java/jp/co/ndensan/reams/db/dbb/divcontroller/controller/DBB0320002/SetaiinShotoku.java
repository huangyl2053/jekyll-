/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.DBB0320002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.DbbViewStateKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.DBB0320005.input.FukaHikakuInput;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName.比較;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.SetaiinShotokuDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の世帯員所得Divのコントローラです。
 *
 * @author n3317 塚田萌
 */
public class SetaiinShotoku {
//TODO n3317塚田　時期が来たら対応する。共有子Divを呼ぶ。

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinShotokuDiv> onload(SetaiinShotokuDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinShotokuDiv> onActive(SetaiinShotokuDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 世帯員所得Div
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinShotokuDiv> initialize(SetaiinShotokuDiv div) {
        Fuka fuka = FukaShokaiController.getFukaModelByFukaShokaiKey();
        div.getCcdSetaiShotokuIchiran().initialize(
                fuka.get識別コード(), fuka.get賦課期日(), fuka.get賦課年度(), new YMDHMS(fuka.get調定日時().getRDateTime()));
        return createResponseData(div);
    }

    /**
     * 共有子Div世帯所得一覧の比較ボタン押下時の処理です。
     *
     * @param div 世帯員所得Div
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinShotokuDiv> onClick_Hikaku(SetaiinShotokuDiv div) {
        List<jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku> list = div.getCcdSetaiShotokuIchiran().get世帯員所得Selected();
        FukaShokaiKey orgKey = ViewStateHolder.get(DbbViewStateKey.FukaShokaiKey, FukaShokaiKey.class);
        if (!list.isEmpty() && list.size() >= 2) {
            FukaShokaiKey key1 = new FukaShokaiKey(
                    orgKey.get調定年度(), orgKey.get賦課年度(), orgKey.get通知書番号(), 0,
                    list.get(0).get被保険者番号(), FlexibleDate.EMPTY, RString.EMPTY, orgKey.get更正日時(),
                    orgKey.get算定状態(), false, false, new AtenaMeisho(list.get(0).get氏名())
            );
            FukaShokaiKey key2 = new FukaShokaiKey(
                    orgKey.get調定年度(), orgKey.get賦課年度(), orgKey.get通知書番号(), 0,
                    list.get(1).get被保険者番号(), FlexibleDate.EMPTY, RString.EMPTY, orgKey.get更正日時(),
                    orgKey.get算定状態(), false, false, new AtenaMeisho(list.get(1).get氏名())
            );

            ViewStateHolder.put(DbbViewStateKey.FukaHikakuInput, FukaHikakuInput.createFor任意対象比較(key1, key2));
        }

        return ResponseData.of(div).forwardWithEventName(比較).respond();
    }

    private ResponseData<SetaiinShotokuDiv> createResponseData(SetaiinShotokuDiv div) {
        return ResponseData.of(div).respond();
    }
}
