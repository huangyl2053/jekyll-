package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResult;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgJudgementResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * このコードはツールによって生成されました。
 */
public interface IKogakuServicehiJudgementResultDiv {

    DataGrid<dgJudgementResult_Row> getDgJudgementResult();

    void setDgJudgementResult(DataGrid<dgJudgementResult_Row> dgJudgementResult);

    KogakuServicehiJudgementResultDetail1Div getKogakuServicehiJudgementResultDetail1();

    void setKogakuServicehiJudgementResultDetail1(KogakuServicehiJudgementResultDetail1Div KogakuServicehiJudgementResultDetail1);

    KogakuServicehiJudgementResultDetail2Div getKogakuServicehiJudgementResultDetail2();

    void setKogakuServicehiJudgementResultDetail2(KogakuServicehiJudgementResultDetail2Div KogakuServicehiJudgementResultDetail2);

}
