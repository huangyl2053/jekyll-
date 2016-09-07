/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710100;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(過誤結果情報)バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3094-010 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710100_HanyoListKagoKekkaParameter extends BatchParameterBase {

    private static final String KEY_国保連取扱年月FROM = "国保連取扱年月From";
    private static final String KEY_国保連取扱年月TO = "国保連取扱年月To";
    private static final String KEY_保険者区分 = "保険者区分";
    private static final String KEY_サービス提供年月FROM = "サービス提供年月From";
    private static final String KEY_サービス提供年月TO = "サービス提供年月To";
    private static final String KEY_事業者コード = "事業者コード";
    private static final String KEY_事業者名 = "事業者名";
    private static final String KEY_項目名付加 = "項目名付加";
    private static final String KEY_連番付加 = "連番付加";
    private static final String KEY_日付スラッシュ付加 = "日付スラッシュ付加";
    private static final String KEY_保険者コード = "保険者コード";
    private static final String KEY_出力順 = "出力順";
    private static final String KEY_出力項目 = "出力項目";

    @BatchParameter(key = KEY_国保連取扱年月FROM, name = "国保連取扱年月From")
    private FlexibleYearMonth 国保連取扱年月From;
    @BatchParameter(key = KEY_国保連取扱年月TO, name = "国保連取扱年月To")
    private FlexibleYearMonth 国保連取扱年月To;
    @BatchParameter(key = KEY_保険者区分, name = "保険者区分")
    private RString 保険者区分;
    @BatchParameter(key = KEY_サービス提供年月FROM, name = "サービス提供年月From")
    private FlexibleYearMonth サービス提供年月From;
    @BatchParameter(key = KEY_サービス提供年月TO, name = "サービス提供年月To")
    private FlexibleYearMonth サービス提供年月To;
    @BatchParameter(key = KEY_事業者コード, name = "事業者コード")
    private RString 事業者コード;
    @BatchParameter(key = KEY_事業者名, name = "事業者名")
    private RString 事業者名;
    @BatchParameter(key = KEY_項目名付加, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = KEY_連番付加, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = KEY_日付スラッシュ付加, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;
    @BatchParameter(key = KEY_保険者コード, name = "保険者コード")
    private LasdecCode 保険者コード;
    @BatchParameter(key = KEY_出力順, name = "出力順")
    private RString 出力順;
    @BatchParameter(key = KEY_出力項目, name = "出力項目")
    private RString 出力項目;
}
