/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120080;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.core.kogakuserviceketteijohotorikomidatahenshu.KogakuServiceKetteiJohoTorikomiDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBの更新
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiDbUpdateProcess extends SimpleBatchProcessBase {

    /**
     * 処理年月
     */
    public static final RString PARAMETER_SHORIYM;
    /**
     * CSVファイルパス
     */
    public static final RString PARAMETER_FILENAME;

    static {
        PARAMETER_SHORIYM = new RString("shoriYM");
        PARAMETER_FILENAME = new RString("fileName");
    }

    private KogakuServiceKetteiJohoTorikomiDataHenshu dataHenshu;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<List> fileName;

    @Override
    protected void beforeExecute() {
        dataHenshu = new KogakuServiceKetteiJohoTorikomiDataHenshu();
    }

    @Override
    protected void process() {
        dataHenshu.getDbShoriDataList(shoriYM.getValue(), fileName.getValue());
    }

}
