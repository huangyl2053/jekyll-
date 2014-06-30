/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.helper.KaigoMenuType;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.core.mybatis._DbSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.context._WorkFlowSession;
import jp.co.ndensan.reams.uz.uza.workflow.flow.dac._FlowDefinitionDac;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowKey;

/**
 * フローIDを元にタイトルを設定するためのクラスです。
 *
 * @author n8178 城間篤人
 */
public final class RootTitleSetter {

    private RootTitleSetter() {
    }

    public static RString getTitle() {
        try {
            SqlSession session = _DbSession.get(_WorkFlowSession.KEY);
            _FlowDefinitionDac dac = new _FlowDefinitionDac(session);
            FlowKey flowKey = dac.getFlowKey(_ControlDataHolder.getControlData().getFlowContext().getFlowInstanceId());

            return KaigoMenuType.getRootTitle(flowKey.getFlowId().getId());
        } catch (Throwable e) {
            //return (MenuType) ViewStateHolder.get("menuType", MenuType.class);
        }
        return RString.EMPTY;
    }

}
