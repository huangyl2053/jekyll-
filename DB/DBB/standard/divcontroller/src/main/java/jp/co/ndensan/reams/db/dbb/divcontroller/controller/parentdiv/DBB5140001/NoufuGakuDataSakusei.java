/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB5140001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.DBB514001_NofugakuDataSakuseiTandokuShichosonParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.DBB5140001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.NoufuGakuDataSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB5140001.NoufuGakuDataSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB5140001.NoufuGakuDataSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM91003_納付額データ作成のクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuGakuDataSakusei {

    private static final RString 単一 = new RString("単一");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div NoufuGakuDataSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<NoufuGakuDataSakuseiDiv> onLoad(NoufuGakuDataSakuseiDiv div) {
        NoufuGakuDataSakuseiHandler handler = getHandler(div);
        RString 画面の状態 = handler.initialize();
        ViewStateHolder.put(ViewStateKeys.画面ステート, 画面の状態);
        if (単一.equals(画面の状態)) {
            return ResponseData.of(div).setState(DBB5140001StateName.バッチ起動_単一);
        } else {
            return ResponseData.of(div).setState(DBB5140001StateName.バッチ起動_広域);
        }
    }

    private NoufuGakuDataSakuseiHandler getHandler(NoufuGakuDataSakuseiDiv div) {
        return new NoufuGakuDataSakuseiHandler(div);
    }

    /**
     * 「実行する」ボタンを押下のチックです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<NoufuGakuDataSakuseiDiv> onClick_check(NoufuGakuDataSakuseiDiv div) {
        NoufuGakuDataSakuseiValidationHandler handler = new NoufuGakuDataSakuseiValidationHandler(div);
        RString 画面の状態 = ViewStateHolder.get(ViewStateKeys.画面ステート, RString.class);
        ValidationMessageControlPairs pairs;
        if (単一.equals(画面の状態)) {
            pairs = handler.validate単一チェック();
        } else {
            pairs = handler.validate広域チェック();
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下のメソッドです。
     *
     * @param div NoufuGakuDataSakuseiDiv
     * @return
     * ResponseData<DBB514001_NofugakuDataSakuseiTandokuShichosonParameter>
     */
    public ResponseData<DBB514001_NofugakuDataSakuseiTandokuShichosonParameter>
            onClick_batch(NoufuGakuDataSakuseiDiv div) {
        RString 画面の状態 = ViewStateHolder.get(ViewStateKeys.画面ステート, RString.class);
        NoufuGakuDataSakuseiHandler handler = getHandler(div);
        if (単一.equals(画面の状態)) {
            handler.単一コンフィグ保存();
            DBB514001_NofugakuDataSakuseiTandokuShichosonParameter parameter = handler.get単一用バッチパラメータ();
            return ResponseData.of(parameter).respond();
        } else {
            handler.広域コンフィグ保存();
            DBB514001_NofugakuDataSakuseiTandokuShichosonParameter parameter = handler.get広域用バッチパラメータ();
            return ResponseData.of(parameter).respond();
        }
    }
}
