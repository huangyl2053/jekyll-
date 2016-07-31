/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.core.shokanfushikyuketteiin.ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルより、DBの更新を行う
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuDbUpdateProcess extends SimpleBatchProcessBase {

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

    private ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu henshuService;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<List> fileName;

    @Override
    protected void beforeExecute() {
        henshuService = new ShokanbaraiFusikyuKetteiJohoTorikomiDataHenshu();
    }

    @Override
    protected void process() {
        henshuService.updateShokanbaraiFusikyuKetteiJoho(shoriYM.getValue(), fileName.getValue());
    }
}
