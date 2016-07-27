/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120200;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsa.SaishinsaKetteiTsuchishoJohoHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルにデータの編集を行う
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class KouhifutanshaDbUpdateProcess extends SimpleBatchProcessBase {

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

    private SaishinsaKetteiTsuchishoJohoHenshu saishinsaFutanshaSvr;

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<List> fileName;

    @Override
    protected void beforeExecute() {
        saishinsaFutanshaSvr = new SaishinsaKetteiTsuchishoJohoHenshu();
    }

    @Override
    protected void process() {
        saishinsaFutanshaSvr.createSaishinsaKetteiTsuchishoJoho(shoriYM.getValue(), fileName.getValue());
    }

}
