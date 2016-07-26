/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.CreateFukaJohoJuneProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.CreateFukaJohoKeizokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.ReflectShikakuToSaishinAprilProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.SelectKarisateiTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.SelectShikakuFuseigoDataProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.SpoolTokuchoKarisanteiKekkaIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT33001_特徴仮算定賦課のparameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKarisanteiFukaBatchParameter extends BatchParameterBase {

    private static final int NUM0 = 0;
    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_flag = "flag";
    private static final String KEY_parameter = "parameter";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<ShuturyokuTyoutuke> 出力帳票一覧;
    @BatchParameter(key = KEY_flag, name = "flag")
    private boolean flag;
    @BatchParameter(key = KEY_parameter, name = "parameter")
    private TokuchoKaishiTsuchishoBatchParameter parameter;

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public SelectKarisateiTaishoProcessParameter toSelectKarisateiTaishoProcessParameter() {
        return new SelectKarisateiTaishoProcessParameter(調定年度);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public SelectShikakuFuseigoDataProcessParameter toSelectShikakuFuseigoDataProcessParameter(YMDHMS システム日時) {
        return new SelectShikakuFuseigoDataProcessParameter(システム日時);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public ReflectShikakuToSaishinAprilProcessParameter toReflectShikakuToSaishinAprilProcessParameter(YMDHMS システム日時) {
        return new ReflectShikakuToSaishinAprilProcessParameter(調定年度, システム日時);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public CreateFukaJohoKeizokuProcessParameter toCreateFukaJohoKeizokuProcessParameter(YMDHMS システム日時) {
        return new CreateFukaJohoKeizokuProcessParameter(調定年度, システム日時);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public CreateFukaJohoJuneProcessParameter toCreateFukaJohoJuneProcessParameter(YMDHMS システム日時) {
        return new CreateFukaJohoJuneProcessParameter(調定年度, システム日時);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public SpoolTokuchoKarisanteiKekkaIchiranProcessParameter toSpoolTokuchoKarisanteiKekkaIchiranProcessParameter(YMDHMS システム日時) {
        return new SpoolTokuchoKarisanteiKekkaIchiranProcessParameter(調定年度, 賦課年度, システム日時,
                new RString(出力帳票一覧.get(NUM0).get出力順ID().toString()));
    }

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public KeisangoJohoSakuseiBatchParamter toKeisangoJohoSakuseiBatchParamter(YMDHMS システム日時) {
        return new KeisangoJohoSakuseiBatchParamter(調定年度.toDateString(), 賦課年度.toDateString(), new RString(システム日時.toString()),
                ShoriName.特徴仮算定賦課.get名称(), RString.EMPTY);
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
