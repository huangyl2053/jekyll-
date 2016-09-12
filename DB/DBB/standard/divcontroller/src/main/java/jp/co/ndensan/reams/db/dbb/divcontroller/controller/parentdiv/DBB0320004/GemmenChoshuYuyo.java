/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320004;

import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.ChoshuYuyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.GemmenChoshuYuyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.GemmenDiv;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuYuyoManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.GemmenManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * 減免・徴収猶予Divです。
 *
 * @author N3317 塚田 萌
 */
public class GemmenChoshuYuyo {

//    private final GemmenChoshuYuyoStateKubun 状態区分 = GemmenChoshuYuyoStateKubun.決定_承認;
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

        Optional<Gemmen> modeloid = Optional.ofNullable(new GemmenManager().get介護賦課減免(
                key.get調定年度(), key.get賦課年度(),
                key.get通知書番号(), new Decimal(key.get履歴番号())));
//                key.get調定年度(), key.get賦課年度(),
//                key.get通知書番号(), key.get処理日時(), 状態区分);

        if (modeloid.isPresent()) {
            Gemmen model = modeloid.get();
            // TODO modelのCheckstyle対応
//            model.get取消減免額();
            div.getTxtGemmenShinseiYMD().setValue(new RDate(model.get減免申請日().toString()));
            div.getTxtGemmenShinseiGaku().setValue(model.get申請減免額());
            div.getTxtGemmenShinseiRiyu().setValue(model.get申請事由());
            div.getTxtGemmenKetteiYMD().setValue(new RDate(model.get減免決定日().toString()));
            div.getTxtGemmenShurui().setValue(CodeMasterNoOption.getCodeMeisho(
                    DBBCodeShubetsu.保険料減免種類.getコード(), new Code(model.get減免種類コード().value())));
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
        // TODO keyのCheckstyle対応
        key.get履歴番号();
        Optional<ChoshuYuyo> modeloid = Optional.ofNullable(new ChoshuYuyoManager().get介護賦課徴収猶予(
                key.get調定年度(),
                key.get賦課年度(),
                key.get通知書番号(),
                key.get履歴番号()));
//        Optional<ChoshuYuyoRelateModel> modeloid = new ChoshuYuyoFinder().find徴収猶予(
//                key.get調定年度(), key.get賦課年度(),
//                key.get通知書番号(), key.get処理日時(), 状態区分);
//
        if (!modeloid.isPresent()) {
            div.getChoshuYuyoKikan().setDisplayNone(true);
        } else {
            ChoshuYuyo model = modeloid.get();

            div.getTxtChoshuYuyoShinseiYMD().setValue(new RDate(model.get徴収猶予申請年月日().toString()));
            div.getTxtChoshuYuyoShinseiRiyu().setValue(model.get申請事由());
            div.getTxtChoshuYuyoKeitteiYMD().setValue(new RDate((model.get徴収猶予決定年月日().toString())));
            div.getTxtChoshuYuyoShurui().setValue(model.get徴収猶予種類().getRyakusho());
            div.getTxtChoshuYuyoShouninRiyu().setValue(model.get徴収猶予事由());
            div.getChoshuYuyoKikan().setDisplayNone(false);

            new KibetsuChoshuYuyoHandler(div.getChoshuYuyoKikan(), ItemList.of(model.getKibetsuChoshuYuyoList())).load();
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
