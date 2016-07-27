/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishoshatorikomidatahenshu.KogakuKyufuTaishoshaTorikomiDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者取込のDB登録・更新
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInUpdateProcess extends SimpleBatchProcessBase {

    /**
     * 処理年月
     */
    public static final RString PARAMETER_処理年月;
    /**
     * 再処理区分
     */
    public static final RString PARAMETER_再処理区分;
    /**
     * ファイル
     */
    public static final RString PARAMETER_FILENAME;

    static {
        PARAMETER_処理年月 = new RString("処理年月");
        PARAMETER_再処理区分 = new RString("再処理区分");
        PARAMETER_FILENAME = new RString("fileName");
    }

    private KogakuKyufuTaishoshaTorikomiDataHenshu sut;
    InputParameter<List> fileName;
    InputParameter<FlexibleYearMonth> 処理年月;
    InputParameter<RString> 再処理区分;

    @Override
    protected void beforeExecute() {
        sut = new KogakuKyufuTaishoshaTorikomiDataHenshu();
    }

    @Override
    protected void process() {
        sut.updateDataIntoDb(処理年月.getValue(), fileName.getValue(), 再処理区分.getValue());
    }

}
