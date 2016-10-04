/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード一覧表画面で入力されたデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC160020_ServicecodeIchiranParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_KOMOUKUMEI = "is項目名付加";
    private static final String KEY_RENBANFUKA = "is連番付加";
    private static final String KEY_ISDATEEDIT = "is日付編集";
    private static final String KEY_CHUSHUTSUJOKENKUBUN = "抽出条件区分";
    private static final String KEY_KIJUNYM = "基準年月";
    private static final String KEY_SERVICESHURUICODE = "サービス種類コード";
    private static final String KEY_SERVICEKOUMOKUCD = "サービス項目コード";
    private static final String KEY_SERVICEBUNRRUICDLIST = "サービス分類s";
    private static final String KEY_TABLENAME = "表題";
    private static final String KEY_ISTYOUHYOUSHUTURYOKU = "is帳票で出力";
    private static final String KEY_ISCSVFAIRUSHUTURYOKU = "isＣＳＶファイルで出力";

    @BatchParameter(key = KEY_KIJUNYM, name = "基準年月")
    private FlexibleYearMonth 基準年月;
    @BatchParameter(key = KEY_CHUSHUTSUJOKENKUBUN, name = "抽出条件区分")
    private RString 抽出条件区分;
    @BatchParameter(key = KEY_SERVICESHURUICODE, name = "サービス種類コード")
    private RString サービス種類コード;
    @BatchParameter(key = KEY_SERVICEKOUMOKUCD, name = "サービス項目コード")
    private RString サービス項目コード;
    @BatchParameter(key = KEY_SERVICEBUNRRUICDLIST, name = "サービス分類s")
    private List<Code> サービス分類s;
    @BatchParameter(key = KEY_ISTYOUHYOUSHUTURYOKU, name = "is帳票で出力")
    private boolean is帳票で出力;
    @BatchParameter(key = KEY_ISCSVFAIRUSHUTURYOKU, name = "isＣＳＶファイルで出力")
    private boolean isＣＳＶファイルで出力;
    @BatchParameter(key = KEY_TABLENAME, name = "表題")
    private RString 表題;
    @BatchParameter(key = KEY_KOMOUKUMEI, name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = KEY_RENBANFUKA, name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = KEY_ISDATEEDIT, name = "is日付編集")
    private boolean is日付編集;

}
