/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）バッチパラメータです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB012001_TokuchoHeinjunka6GatsuParameter extends BatchParameterBase {

    private static final String KEY_CHOTEINENDO = "choteinendo";
    private static final String NAME_CHOTEINENDO = "調定年度";
    private static final String KEY_FUKANENDO = "fukanendo";
    private static final String NAME_FUKANENDO = "賦課年度";
    private static final String KEY_ZOUGAKUHENJUNKAHOHO = "zougakuhenjunkahoho";
    private static final String NAME_ZOUGAKUHENJUNKAHOHO = "増額平準化方法";
    private static final String KEY_GENGAKUHENJUNKAHOHO = "gengakuhenjunkahoho";
    private static final String NAME_GENGAKUHENJUNKAHOHO = "減額平準化方法";
    private static final String KEY_SHUTSURYOCHOHYO = "shutsuryokuchohyo";
    private static final String NAME_SHUTSURYOCHOHYO = "出力帳票entity";
    private static final String KEY_SHUTSURYOTAISHO = "shutsuryokutaisho";
    private static final String NAME_SHUTSURYOTAISHO = "出力対象";
    private static final String KEY_HAKOKI = "hakoki";
    private static final String NAME_HAKOKI = "発行日";
    private static final String KEY_BUNSHUBANGO = "bunshubango";
    private static final String NAME_BUNSHUBANGO = "文書番号";
    private static final String KEY_CHOHYOGROUP = "chohyogroup";
    private static final String NAME_CHOHYOGROUP = "帳票グループ";
    private static final String KEY_SHUTSURYOFLAG = "shutsuryoflag";
    private static final String NAME_SHUTSURYOFLAG = "出力対象指示フラグ";
    private static final String KEY_IKATSUFLAG = "ikatsuflag";
    private static final String NAME_IKATSUFLAG = "一括発行フラグ";

    @BatchParameter(key = KEY_CHOTEINENDO, name = NAME_CHOTEINENDO)
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_FUKANENDO, name = NAME_FUKANENDO)
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_ZOUGAKUHENJUNKAHOHO, name = NAME_ZOUGAKUHENJUNKAHOHO)
    private RString 増額平準化方法;
    @BatchParameter(key = KEY_GENGAKUHENJUNKAHOHO, name = NAME_GENGAKUHENJUNKAHOHO)
    private RString 減額平準化方法;
    @BatchParameter(key = KEY_SHUTSURYOCHOHYO, name = NAME_SHUTSURYOCHOHYO)
    private ArrayList<OutputChohyoIchiran> 出力帳票entity;
    @BatchParameter(key = KEY_SHUTSURYOTAISHO, name = NAME_SHUTSURYOTAISHO)
    private RString 出力対象;
    @BatchParameter(key = KEY_HAKOKI, name = NAME_HAKOKI)
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_BUNSHUBANGO, name = NAME_BUNSHUBANGO)
    private RString 文書番号;
    @BatchParameter(key = KEY_CHOHYOGROUP, name = NAME_CHOHYOGROUP)
    private RString 帳票グループ;
    @BatchParameter(key = KEY_SHUTSURYOFLAG, name = NAME_SHUTSURYOFLAG)
    private RString 出力対象指示フラグ;
    @BatchParameter(key = KEY_IKATSUFLAG, name = NAME_IKATSUFLAG)
    private boolean 一括発行フラグ;

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public KeisangoJohoSakuseiBatchParamter toKeisangoJohoSakuseiBatchParamter(YMDHMS システム日時) {
        return new KeisangoJohoSakuseiBatchParamter(調定年度.toDateString(), 賦課年度.toDateString(), new RString(システム日時.toString()),
                ShoriName.特徴平準化計算_6月分.get名称(), RString.EMPTY);
    }

    /**
     * processのパラメータを生成します。
     *
     * @return FukaJohoTorokuBatchParameter
     */
    public FukaJohoTorokuBatchParameter toFukaJohoTorokuBatchParameter() {
        return new FukaJohoTorokuBatchParameter(true);
    }
}
