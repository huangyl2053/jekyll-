/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoteishitaisyosyadoutei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ81002_1_特徴対象者同定（一括）BatchParameter
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTeishiTaisyosyaDouteiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_処理年度 = "処理年度";
    private static final String NAME_処理年度 = "処理年度";
    private static final String KEY_捕捉月 = "捕捉月";
    private static final String NAME_捕捉月 = "捕捉月";
    private static final String KEY_開始月 = "開始月";
    private static final String NAME_開始月 = "開始月";
    private static final String KEY_処理区分 = "処理区分";
    private static final String NAME_処理区分 = "処理区分";
    private static final String KEY_処理日時 = "処理日時";
    private static final String NAME_処理日時 = "処理日時";

    @BatchParameter(key = KEY_処理年度, name = NAME_処理年度)
    private RString 処理年度;
    @BatchParameter(key = KEY_捕捉月, name = NAME_捕捉月)
    private List<RString> 捕捉月;
    @BatchParameter(key = KEY_開始月, name = NAME_開始月)
    private RString 開始月;
    @BatchParameter(key = KEY_処理区分, name = NAME_処理区分)
    private RString 処理区分;
    @BatchParameter(key = KEY_処理日時, name = NAME_処理日時)
    private RDateTime 処理日時;
}
