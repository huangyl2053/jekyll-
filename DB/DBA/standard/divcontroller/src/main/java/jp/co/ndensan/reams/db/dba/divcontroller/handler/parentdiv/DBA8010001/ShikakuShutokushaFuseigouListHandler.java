/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA8010001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA320010.DBA320010_ShikakuShutokushaFuseigoListParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA8010001.ShikakuShutokushaFuseigouListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得者不整合リストHandlerクラスです。
 *
 * @reamsid_L DBU-4020-010 linghuhang
 */
public class ShikakuShutokushaFuseigouListHandler {

    private final ShikakuShutokushaFuseigouListDiv div;
    private static final RString すべて対象 = new RString("1");
    private static final RString 資格重複者 = new RString("2");
    private static final RString 重複者以外 = new RString("3");
    private static final RString KEY = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public ShikakuShutokushaFuseigouListHandler(ShikakuShutokushaFuseigouListDiv div) {
        this.div = div;
    }

    /**
     * 抽出条件の設定する。
     *
     * @param 選択項目 選択項目
     */
    public void onClick_onChange(RString 選択項目) {
        if (すべて対象.equals(選択項目)) {
            div.getShikakuTyofukusha().clearSelectedItem();
            div.getFuseigou().clearSelectedItem();
            div.getAllTaishou().setSelectedKey(KEY);
        } else if (資格重複者.equals(選択項目)) {
            div.getAllTaishou().clearSelectedItem();
            div.getFuseigou().clearSelectedItem();
            div.getShikakuTyofukusha().setSelectedKey(KEY);
        } else {
            div.getAllTaishou().clearSelectedItem();
            div.getShikakuTyofukusha().clearSelectedItem();
            div.getFuseigou().setSelectedKey(KEY);
        }
    }

    /**
     * バッチパラメータを設定します。
     *
     * @return DBA320010_ShikakuShutokushaFuseigoListParameter
     */
    public DBA320010_ShikakuShutokushaFuseigoListParameter onClick_btnKogakuParamSave() {
        DBA320010_ShikakuShutokushaFuseigoListParameter parameter = new DBA320010_ShikakuShutokushaFuseigoListParameter();
        if (!RString.isNullOrEmpty(div.getAllTaishou().getSelectedKey())) {
            parameter.setShuturyokuTaishouKubun(すべて対象);
        } else if (!RString.isNullOrEmpty(div.getShikakuTyofukusha().getSelectedKey())) {
            parameter.setShuturyokuTaishouKubun(資格重複者);
        } else {
            parameter.setShuturyokuTaishouKubun(重複者以外);
        }
        return parameter;
    }
}
