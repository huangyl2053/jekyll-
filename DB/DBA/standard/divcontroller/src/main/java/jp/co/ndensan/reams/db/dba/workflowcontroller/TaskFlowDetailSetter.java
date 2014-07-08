/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.workflowcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.ITaskDetailManageable;

/**
 *
 * @author n8178 城間篤人
 */
public class TaskFlowDetailSetter implements ITaskDetailManageable {

    private static final RString demoKojin = new RString("demoKojin.yml");

    @Override
    public RString getDetailString() {

        List<HashMap> yamlDataList = YamlLoader.DBA.loadAsList(demoKojin);
        ControlGenerator generator = new ControlGenerator(yamlDataList.get(0));

        return generator.getAsRString("識別コード").concat("<br/>").concat(generator.getAsRString("氏名"));
    }

}
