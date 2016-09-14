/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD560001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd560001.DBD560001ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定データ一括更新のバッチパラメタークラスです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD560001Parameter extends BatchParameterBase {

    private static final String NINTEIRI = "ninteiri";
    @BatchParameter(key = NINTEIRI, name = "認定日")
    private FlexibleDate 認定日;

    /**
     *
     * @return DBD560001ProcessParameter
     */
    public DBD560001ProcessParameter toDBD560001Parameter() {
        return new DBD560001ProcessParameter(認定日);
    }

}
