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
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenIFUpdataProcess extends SimpleBatchProcessBase {

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
     * shoriJotaiKubun
     */
    public static final RString PARAMETER_SHORIJOTAIKUBUN;

    static {
        PARAMETER_SHORIYM = new RString("shoriYM");
        PARAMETER_KOKANSHIKIBETSUNO = new RString("kokanShikibetsuNo");
        PARAMETER_SHORIJOTAIKUBUN = new RString("shoriJotaiKubun");
    }

    //パラメータ受取変数
    InputParameter<RString> shoriYM;
    InputParameter<RString> kokanShikibetsuNo;
    InputParameter<RString> shoriJotaiKubun;

    @Override
    protected void process() {

        IKokuhorenInterfaceKanriMapper mapper = getMapper(IKokuhorenInterfaceKanriMapper.class);
        mapper.shoriJotaiKubunUpdater(createParameter());
    }

    private Map<String, Object> createParameter() {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIYM.toString(), shoriYM.getValue());
        parameter.put(KokuhorenIFUpdataProcess.PARAMETER_KOKANSHIKIBETSUNO.toString(), kokanShikibetsuNo.getValue());
        parameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIJOTAIKUBUN.toString(), shoriJotaiKubun.getValue());
        return parameter;
    }
}
