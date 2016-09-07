/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA8010001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA320010.DBA320010_ShikakuShutokushaFuseigoListParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA8010001.ShikakuShutokushaFuseigouListDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA8010001.ShikakuShutokushaFuseigouListHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得者不整合リストHandlerクラスです。
 *
 * @reamsid_L DBU-4020-010 linghuhang
 */
public class ShikakuShutokushaFuseigouList {

    private static final RString すべて対象 = new RString("1");
    private static final RString 資格重複者 = new RString("2");
    private static final RString 重複者以外 = new RString("3");
    private static final RString KEY = new RString("key0");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ShikakuShutokushaFuseigouListDiv>
     */
    public ResponseData<ShikakuShutokushaFuseigouListDiv> onLoad(ShikakuShutokushaFuseigouListDiv div) {
        div.getAllTaishou().setSelectedKey(KEY);
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件の設定する。
     *
     * @param div 画面情報
     * @return ResponseData<ShikakuShutokushaFuseigouListDiv>
     */
    public ResponseData<ShikakuShutokushaFuseigouListDiv> onClick_onChangeAllTaishou(ShikakuShutokushaFuseigouListDiv div) {
        getHandler(div).onClick_onChange(すべて対象);
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件の設定する。
     *
     * @param div 画面情報
     * @return ResponseData<ShikakuShutokushaFuseigouListDiv>
     */
    public ResponseData<ShikakuShutokushaFuseigouListDiv> onClick_onChangeShikakuTyofukusha(ShikakuShutokushaFuseigouListDiv div) {
        getHandler(div).onClick_onChange(資格重複者);
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件の設定する。
     *
     * @param div 画面情報
     * @return ResponseData<ShikakuShutokushaFuseigouListDiv>
     */
    public ResponseData<ShikakuShutokushaFuseigouListDiv> onClick_onChangeFuseigou(ShikakuShutokushaFuseigouListDiv div) {
        getHandler(div).onClick_onChange(重複者以外);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div ShikakuShutokushaFuseigouListDiv
     * @return ResponseData<DBA320010_ShikakuShutokushaFuseigoListParameter>
     */
    public ResponseData<DBA320010_ShikakuShutokushaFuseigoListParameter> onClick_btnExecute(ShikakuShutokushaFuseigouListDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnKogakuParamSave()).respond();
    }

    private ShikakuShutokushaFuseigouListHandler getHandler(ShikakuShutokushaFuseigouListDiv div) {
        return new ShikakuShutokushaFuseigouListHandler(div);
    }
}
