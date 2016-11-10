/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011003.DBB011003_TokuchoKarisanteiTsuchishoHakkoParameter;
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
public class DBB011001_TokuchoKarisanteiFukaParameter extends BatchParameterBase {

    private static final int NUM0 = 0;
    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_PARAMETER = "parameter";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<ShuturyokuTyoutuke> 出力帳票一覧;
    @BatchParameter(key = KEY_FLAG, name = "flag")
    private boolean flag;
    @BatchParameter(key = KEY_PARAMETER, name = "parameter")
    private DBB011003_TokuchoKarisanteiTsuchishoHakkoParameter parameter;

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
    public DBB003001_KeisangoJohoSakuseiParameter toKeisangoJohoSakuseiBatchParamter(YMDHMS システム日時) {
        return new DBB003001_KeisangoJohoSakuseiParameter(調定年度.toDateString(), 賦課年度.toDateString(), new RString(システム日時.toString()),
                ShoriName.特徴仮算定賦課.get名称(), RString.EMPTY);
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
