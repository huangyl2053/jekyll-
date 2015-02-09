/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320004;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.ChoshuYuyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.GemmenChoshuYuyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.GemmenDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.fuka.GemmenModel;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelateModel;
import jp.co.ndensan.reams.db.dbz.realservice.ChoshuYuyoFinder;
import jp.co.ndensan.reams.db.dbz.realservice.GemmenFinder;

/**
 * 減免・徴収猶予Divです。
 *
 * @author N3317 塚田 萌
 */
public class GemmenChoshuYuyo {

    private final GemmenChoshuYuyoStateKubun 状態区分 = GemmenChoshuYuyoStateKubun.決定_承認;

    /**
     * 減免・徴収猶予データをセットします。
     *
     * @param div 徴収猶予div
     * @return レスポンスデータ
     */
    public ResponseData<GemmenChoshuYuyoDiv> initialize(GemmenChoshuYuyoDiv div) {

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

        setGemmenDiv(div.getGemmen(), key);
        setChoshuYuyoDiv(div.getChoshuYuyo(), key);

        return createResponseData(div);
    }

    /**
     * 減免データをセットします。<br/>
     * データがない場合は空白で表示します。
     *
     * @param div 徴収猶予div
     * @param key 賦課照会key
     */
    private void setGemmenDiv(GemmenDiv div, FukaShokaiKey key) {
        clearGemmenDiv(div);

        Optional<GemmenModel> modeloid = new GemmenFinder().find減免(
                key.get調定年度(), key.get賦課年度(),
                key.get通知書番号(), key.get処理日時(), 状態区分);

        if (modeloid.isPresent()) {
            GemmenModel model = modeloid.get();

            div.getTxtGemmenShinseiYMD().setValue(FukaMapper.toRDate(model.get減免申請年月日()));
            div.getTxtGemmenShinseiGaku().setValue(model.get申請減免額());
            div.getTxtGemmenShinseiRiyu().setValue(model.get申請事由());
            div.getTxtGemmenKetteiYMD().setValue(FukaMapper.toRDate(model.get減免決定年月日()));
            div.getTxtGemmenShurui().setValue(model.get減免種類().getRyakusho());
            div.getTxtGemmenShouninRiyu().setValue(model.get減免事由());
        }
    }

    private void clearGemmenDiv(GemmenDiv div) {
        div.getTxtGemmenShinseiYMD().clearValue();
        div.getTxtGemmenShinseiGaku().clearValue();
        div.getTxtGemmenShinseiRiyu().clearValue();
        div.getTxtGemmenKetteiYMD().clearValue();
        div.getTxtGemmenShurui().clearValue();
        div.getTxtGemmenShouninRiyu().clearValue();
    }

    /**
     * 徴収猶予データをセットします。<br/>
     * データがない場合は徴収猶予期間を非表示にし、それ以外は空白で表示します。
     *
     * @param div 徴収猶予div
     * @param key 賦課照会key
     */
    private void setChoshuYuyoDiv(ChoshuYuyoDiv div, FukaShokaiKey key) {
        clearChoshuYuyoDiv(div);

        Optional<ChoshuYuyoRelateModel> modeloid = new ChoshuYuyoFinder().find徴収猶予(
                key.get調定年度(), key.get賦課年度(),
                key.get通知書番号(), key.get処理日時(), 状態区分);

        if (!modeloid.isPresent()) {
            div.getChoshuYuyoKikan().setDisplayNone(true);
        } else {
            ChoshuYuyoModel model = modeloid.get().get徴収猶予モデル();

            div.getTxtChoshuYuyoShinseiYMD().setValue(FukaMapper.toRDate(model.get徴収猶予申請年月日()));
            div.getTxtChoshuYuyoShinseiRiyu().setValue(model.get申請事由());
            div.getTxtChoshuYuyoKeitteiYMD().setValue(FukaMapper.toRDate(model.get徴収猶予決定年月日()));
            div.getTxtChoshuYuyoShurui().setValue(model.get徴収猶予種類().getRyakusho());
            div.getTxtChoshuYuyoShouninRiyu().setValue(model.get徴収猶予事由());
            div.getChoshuYuyoKikan().setDisplayNone(false);

            new KibetsuChoshuYuyo(div.getChoshuYuyoKikan(), modeloid.get().get期別徴収猶予モデルリスト()).load();
        }
    }

    private void clearChoshuYuyoDiv(ChoshuYuyoDiv div) {
        div.getTxtChoshuYuyoShinseiYMD().clearValue();
        div.getTxtChoshuYuyoShinseiRiyu().clearValue();
        div.getTxtChoshuYuyoKeitteiYMD().clearValue();
        div.getTxtChoshuYuyoShurui().clearValue();
        div.getTxtChoshuYuyoShouninRiyu().clearValue();
    }

    private ResponseData<GemmenChoshuYuyoDiv> createResponseData(GemmenChoshuYuyoDiv div) {
        ResponseData<GemmenChoshuYuyoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
