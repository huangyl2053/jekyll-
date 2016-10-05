/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb0120002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012002.DBB012002_TokuchoHeinjunkaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunkakakutei.TokuchoHeijunkaKakuteiBatch;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT35004_特徴平準化確定
 *
 * @reamsid_L DBB-0830-030 xuhao
 */
public class TokuchoHeinjunkaKakuteiDbUpdateProcess extends SimpleBatchProcessBase {

    /**
     * parameter
     */
    public static final RString PARAMETER;

    static {
        PARAMETER = new RString("parameter");
    }
    private TokuchoHeijunkaKakuteiBatch batchService;
    private final RString 遷移区分_0 = new RString("0");
    private final RString 遷移区分_1 = new RString("1");
    private final RString 枝番 = new RString("0001");

    InputParameter<DBB012002_TokuchoHeinjunkaKakuteiParameter> parameter;

    @Override
    protected void beforeExecute() {
        batchService = new TokuchoHeijunkaKakuteiBatch();
    }

    @Override
    protected void process() {
        YMDHMS システム日時 = YMDHMS.now();
        batchService.selectTokuchoHeijunkaFuka(parameter.getValue().get賦課年度(), parameter.getValue().get調定年度(),
                parameter.getValue().get調定日時());
        batchService.selectTaishoJoho(parameter.getValue().get遷移区分(), parameter.getValue().get差額Map());
        batchService.confirmTokuchoHeijunka();
        batchService.spoolTokuchoHeijunkaKakutei(parameter.getValue().get賦課年度(), parameter.getValue().get調定年度(),
                parameter.getValue().get調定日時(), システム日時);
        RString 処理枝番 = 枝番;
        FlexibleYear 年度 = parameter.getValue().get賦課年度();
        RString 年度内連番 = 枝番;
        if (遷移区分_0.equals(parameter.getValue().get遷移区分())) {
            RString 処理名 = new RString(ShoriName.特徴平準化_6月分_確定.toString());
            batchService.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
        }
        if (遷移区分_1.equals(parameter.getValue().get遷移区分())) {
            RString 処理名 = new RString(ShoriName.特徴平準化_8月分_確定.toString());
            batchService.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
        }
    }

}
