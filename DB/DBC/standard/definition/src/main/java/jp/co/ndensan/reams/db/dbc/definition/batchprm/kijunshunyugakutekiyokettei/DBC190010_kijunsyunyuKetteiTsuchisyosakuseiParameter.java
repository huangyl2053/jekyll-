/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyokettei;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額決定通知書発行バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC190010_kijunsyunyuKetteiTsuchisyosakuseiParameter extends BatchParameterBase {

    private static final String KEY_抽出期間 = "抽出期間";
    private static final String KEY_市町村コード = "市町村コード";
    private static final String KEY_市町村名 = "市町村名";
    private static final String KEY_開始日 = "開始日";
    private static final String KEY_終了日 = "終了日";
    private static final String KEY_印書 = "印書";
    private static final String KEY_作成日 = "作成日";
    private static final String KEY_文書番号 = "文書番号";
    private static final String KEY_帳票出力順ID = "帳票出力順ID";

    @BatchParameter(key = KEY_抽出期間, name = "抽出期間")
    private RString 抽出期間;
    @BatchParameter(key = KEY_市町村コード, name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = KEY_市町村名, name = "市町村名")
    private RString 市町村名;
    @BatchParameter(key = KEY_開始日, name = "開始日")
    private FlexibleDate 開始日;
    @BatchParameter(key = KEY_終了日, name = "終了日")
    private FlexibleDate 終了日;
    @BatchParameter(key = KEY_印書, name = "印書")
    private RString 印書;
    @BatchParameter(key = KEY_作成日, name = "作成日")
    private FlexibleDate 作成日;
    @BatchParameter(key = KEY_文書番号, name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = KEY_帳票出力順ID, name = "帳票出力順ID")
    private RString 帳票出力順ID;
}
