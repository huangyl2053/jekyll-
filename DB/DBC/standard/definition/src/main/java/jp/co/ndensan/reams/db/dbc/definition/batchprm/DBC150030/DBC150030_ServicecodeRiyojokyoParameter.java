/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード別利用状況作成BatchParamterクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC150030_ServicecodeRiyojokyoParameter extends BatchParameterBase {

    private static final String KEY_対象年月指定 = "対象年月指定";
    private static final String KEY_年月範囲開始 = "年月範囲開始";
    private static final String KEY_年月範囲終了 = "年月範囲終了";
    private static final String KEY_対象サービス種類 = "対象サービス種類";
    private static final String KEY_サービス項目コードのまとめ方 = "サービス項目コードのまとめ方";
    private static final String KEY_選択対象 = "選択対象";
    private static final String KEY_対象コードリスト = "対象コードリスト";
    private static final String KEY_市町村情報 = "市町村情報";
    private static final String KEY_旧市町村情報 = "旧市町村情報";

    @BatchParameter(key = KEY_対象年月指定, name = "対象年月指定")
    private RString 対象年月指定;
    @BatchParameter(key = KEY_年月範囲開始, name = "年月範囲開始")
    private FlexibleYearMonth 年月範囲開始;
    @BatchParameter(key = KEY_年月範囲終了, name = "年月範囲終了")
    private FlexibleYearMonth 年月範囲終了;
    @BatchParameter(key = KEY_対象サービス種類, name = "対象サービス種類")
    private RString 対象サービス種類;
    @BatchParameter(key = KEY_サービス項目コードのまとめ方, name = "サービス項目コードのまとめ方")
    private RString サービス項目コードのまとめ方;
    @BatchParameter(key = KEY_選択対象, name = "選択対象")
    private RString 選択対象;
    @BatchParameter(key = KEY_対象コードリスト, name = "対象コードリスト")
    private List<RString> 対象コードリスト;
    @BatchParameter(key = KEY_市町村情報, name = "市町村情報")
    private KoseiShichosonInfo 市町村情報;
    @BatchParameter(key = KEY_旧市町村情報, name = "旧市町村情報")
    private KoseiShichosonInfo 旧市町村情報;

}
