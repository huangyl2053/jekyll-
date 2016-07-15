/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunka6gatsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）のバッチパラメータです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunka6GatsuParameter extends BatchParameterBase {

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_増額平準化方法 = "増額平準化方法";
    private static final String KEY_減額平準化方法 = "減額平準化方法";
    private static final String KEY_出力帳票一覧 = "出力帳票一覧";
    private static final String KEY_出力対象 = "出力対象";
    private static final String KEY_発行日 = "発行日";
    private static final String KEY_文書番号 = "文書番号";
    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private RString 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private RString 賦課年度;
    @BatchParameter(key = KEY_増額平準化方法, name = "増額平準化方法")
    private RString 増額平準化方法;
    @BatchParameter(key = KEY_減額平準化方法, name = "減額平準化方法")
    private RString 減額平準化方法;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<TyouhyouEntity> 出力帳票一覧;
    @BatchParameter(key = KEY_出力対象, name = "出力対象")
    private RString 出力対象;
    @BatchParameter(key = KEY_発行日, name = "発行日")
    private RString 発行日;
    @BatchParameter(key = KEY_文書番号, name = "文書番号")
    private RString 文書番号;
}
