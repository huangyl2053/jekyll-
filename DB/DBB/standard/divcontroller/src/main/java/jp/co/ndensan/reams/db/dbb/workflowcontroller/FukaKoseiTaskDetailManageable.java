/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.ITaskDetailManageable;

/**
 *
 * @author N8211 田辺 紘一
 */
public class FukaKoseiTaskDetailManageable implements ITaskDetailManageable {

    @Override
    public RString getDetailString() {
        return new RString("test");
    }

}
