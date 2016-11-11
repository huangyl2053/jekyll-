/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB013001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴8月分）バッチパラメータです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB013001_TokuchoHeinjunka8GatsuParameter extends BatchParameterBase {

    private static final String KEY_CHOTEINENDO = "choteinendo";
    private static final String NAME_CHOTEINENDO = "調定年度";
    private static final String KEY_FUKANENDO = "fukanendo";
    private static final String NAME_FUKANENDO = "賦課年度";
    private static final String KEY_ZOUGAKUHENJUNKAHOHO = "zougakuhenjunkahoho";
    private static final String NAME_ZOUGAKUHENJUNKAHOHO = "増額平準化方法";
    private static final String KEY_GENGAKUHENJUNKAHOHO = "gengakuhenjunkahoho";
    private static final String NAME_GENGAKUHENJUNKAHOHO = "減額平準化方法";
    private static final String KEY_OUTPUTORDER = "出力順ID";
    private static final String NAME_OUTPUTORDER = "出力順ID";

    @BatchParameter(key = KEY_CHOTEINENDO, name = NAME_CHOTEINENDO)
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_FUKANENDO, name = NAME_FUKANENDO)
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_ZOUGAKUHENJUNKAHOHO, name = NAME_ZOUGAKUHENJUNKAHOHO)
    private RString 増額平準化方法;
    @BatchParameter(key = KEY_GENGAKUHENJUNKAHOHO, name = NAME_GENGAKUHENJUNKAHOHO)
    private RString 減額平準化方法;
    @BatchParameter(key = KEY_OUTPUTORDER, name = NAME_OUTPUTORDER)
    private RString 出力順ID;

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public DBB003001_KeisangoJohoSakuseiParameter toKeisangoJohoSakuseiBatchParamter(YMDHMS システム日時) {
        return new DBB003001_KeisangoJohoSakuseiParameter(調定年度.toDateString(), 賦課年度.toDateString(), new RString(システム日時.toString()),
                ShoriName.特徴平準化計算_8月分.get名称(), RString.EMPTY);
    }

    /**
     * processのパラメータを生成します。
     *
     * @return FukaJohoTorokuBatchParameter
     */
    public DBB004001_FukaJohoTorokuParameter toFukaJohoTorokuBatchParameter() {
        return new DBB004001_FukaJohoTorokuParameter();
    }
}
