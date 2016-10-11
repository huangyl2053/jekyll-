/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin.IKyufuJissekiInMasterTorokuMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 給付更新結果情報取込・通し番号の採番取得を実行する。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInGetToosibangoProcess extends SimpleBatchProcessBase {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_BANGO;

    static {
        PARAMETER_OUT_BANGO = new RString("通し番号");
    }

    private OutputParameter<Long> 通し番号;

    @Override
    protected void process() {
        Integer 最大連番 = getMapper(IKyufuJissekiInMasterTorokuMapper.class).select給付実績一時の最大連番();
        if (null == 最大連番) {
            最大連番 = 0;
        }
        CountedItem ci = Saiban.get(SubGyomuCode.DBZ介護共通,
                SaibanHanyokeyName.実績管理番号.getコード(), FlexibleYear.MIN, 最大連番);
        long 番号 = 1;
        if (ci.hasNext()) {
            番号 = ci.next();
        }
        通し番号 = new OutputParameter();
        通し番号.setValue(番号);
    }

}
