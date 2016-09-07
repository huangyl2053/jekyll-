/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhoreninterfacekanri.IKokuhorenInterfaceKanriMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenIFUpdateCtrlRecordProcess extends SimpleBatchProcessBase {

    //パラメータ名
    /**
     * shoriYM
     */
    public static final RString PARAMETER_SHORIYM;
    /**
     * kokanShikibetsuNo
     */
    public static final RString PARAMETER_KOKANSHIKIBETSUNO;
    /**
     * fileName
     */
    public static final RString PARAMETER_FILENAME;
    /**
     * shoriNichiji
     */
    public static final RString PARAMETER_SHORINICHIJI;

    static {
        PARAMETER_SHORIYM = new RString("shoriYM");
        PARAMETER_KOKANSHIKIBETSUNO = new RString("kokanShikibetsuNo");
        PARAMETER_FILENAME = new RString("fileName");
        PARAMETER_SHORINICHIJI = new RString("shoriNichiji");
    }

    //パラメータ受取変数
    InputParameter<RString> shoriYM;
    InputParameter<RString> kokanShikibetsuNo;
    InputParameter<RString> fileName;
    InputParameter<RString> shoriNichiji;

    private OutputParameter<Integer> recordNum;

    @Override
    protected void process() {
        Map<String, Object> sqlParam = new HashMap<>();

        sqlParam.put(PARAMETER_SHORIYM.toString(), shoriYM.getValue());
        sqlParam.put(PARAMETER_KOKANSHIKIBETSUNO.toString(), kokanShikibetsuNo.getValue());
        sqlParam.put(PARAMETER_FILENAME.toString(), fileName.getValue());
        sqlParam.put(PARAMETER_SHORINICHIJI.toString(), shoriNichiji.getValue());

        IKokuhorenInterfaceKanriMapper mapper = getMapper(IKokuhorenInterfaceKanriMapper.class);

        recordNum = new OutputParameter<>();
        recordNum.setValue(mapper.torikomiShoriUpdater(sqlParam));
    }

}
