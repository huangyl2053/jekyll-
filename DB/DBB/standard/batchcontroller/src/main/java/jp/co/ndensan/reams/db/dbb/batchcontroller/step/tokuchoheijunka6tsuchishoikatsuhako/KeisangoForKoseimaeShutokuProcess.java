/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「「更正前」計算後情報を取得する」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class KeisangoForKoseimaeShutokuProcess extends BatchProcessBase<DbTKeisangoJohoTempTableEntity> {

    /**
     * OutputParameter用キー keisangoList
     */
    public static final RString KEISANGO;

    private OutputParameter<List<DbTKeisangoJohoTempTableEntity>> keisangoList;
    List<DbTKeisangoJohoTempTableEntity> 計算後List;

    FukaJohoShutokuProcessParameter parameter;

    static {
        KEISANGO = new RString("keisangoList");
    }

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako."
            + "ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select計算後情報For計算後情報更正前");

    @Override
    protected void beforeExecute() {
        計算後List = new ArrayList<>();
        keisangoList = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        RString 作成処理名 = ShoriName.特徴平準化計算_6月分.get名称();
        return new BatchDbReader(MYBATIS_SELECT_ID, new TokuchoHeijunka6gatsuMyBatisParameter(
                parameter.is一括発行フラグ(), null, null, null, 作成処理名, null, null, null, null));
    }

    @Override
    protected void process(DbTKeisangoJohoTempTableEntity entity) {
        計算後List.add(entity);
    }

    @Override
    protected void afterExecute() {
        keisangoList.setValue(計算後List);
    }

}
