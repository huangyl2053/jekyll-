/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120090;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteikohifutanshain.KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時TBLより、DBの更新を実行する。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class TempTableUpdateProcess extends SimpleBatchProcessBase {

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

    private KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun kohiFutanshaSvr;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<List> fileName;

    @Override
    protected void beforeExecute() {
        kohiFutanshaSvr = new KagoKetteiTsuchishoJohoTorikomiKohiFutanshabun();
    }

    @Override
    protected void process() {
        kohiFutanshaSvr.updateKagoKetteiTsuchishoJohoFutanshabun(shoriYM.getValue(), fileName.getValue());
    }

}
