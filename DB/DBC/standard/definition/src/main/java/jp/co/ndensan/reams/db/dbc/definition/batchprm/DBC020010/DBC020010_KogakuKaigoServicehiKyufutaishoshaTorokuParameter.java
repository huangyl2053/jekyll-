/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者登録のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter extends BatchParameterBase {

    private static final String KEY_MENUID = "menuId";
    private static final String KEY_SHUTURYOKUJUNN = "shuturyokuJunn";
    private static final String KEY_SHORIYM = "shoriYM";
    private static final String KEY_SHORISTATEKUBUN = "shoriStateKubun";
    private static final String KEY_SHUTURYOKUFLG = "shuturyokuFlg";

    @BatchParameter(key = KEY_MENUID, name = "メニューID")
    private RString menuId;
    @BatchParameter(key = KEY_SHUTURYOKUJUNN, name = "出力順ID")
    private long shuturyokuJunn;
    @BatchParameter(key = KEY_SHORIYM, name = "処理年月")
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SHORISTATEKUBUN, name = "処理状態区分")
    private RString shoriStateKubun;
    @BatchParameter(key = KEY_SHUTURYOKUFLG, name = "出力フラグ")
    private boolean shuturyokuFlg;
}
