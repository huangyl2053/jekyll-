/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.kagoketteitsuchishojohotorikomiichiranhyohokenshabun.KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBの更新
 */
public class KagoKetteiHokenshaInUpdataDBProcess extends SimpleBatchProcessBase {

    /**
     * 処理年月
     */
    public static final RString PARAMETER_SHORIYM;
    /**
     * CSVFILENAME
     */
    public static final RString PARAMETER_CSVFILENAME;

    static {
        PARAMETER_SHORIYM = new RString("shoriYM");
        PARAMETER_CSVFILENAME = new RString("csvFileName");
    }

    private KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun hokenshabun;
    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<List<RString>> csvFileName;

    @Override
    protected void beforeExecute() {
        hokenshabun = KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun.createInstance();
    }

    @Override
    protected void process() {
        hokenshabun.updateKagoKeteiTsuchishoHokenshabun(shoriYM.getValue(), csvFileName.getValue());
    }

}
