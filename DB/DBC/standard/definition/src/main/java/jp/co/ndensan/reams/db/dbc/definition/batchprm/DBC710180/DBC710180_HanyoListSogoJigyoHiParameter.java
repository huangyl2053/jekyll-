/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710180;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsogojigyohi.HanyoListSogoJigyoHiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_総合事業費情報のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710180_HanyoListSogoJigyoHiParameter extends BatchParameterBase {

    private static final String KEY_REPORTID = "帳票ID";
    private static final String KEY_SHUTSURYOKUJUNID = "出力順ID";
    private static final String KEY_SHUTSURYOKUJUNKOMOKUID = "出力順項目ID";
    private static final String KEY_KOMOUKUMEI = "is項目名付加";
    private static final String KEY_RENBANFUKA = "is連番付加";
    private static final String KEY_ISDATEEDIT = "is日付スラッシュ付加";
    private static final String KEY_JIGYOSYACODE = "事業者コード";
    private static final String KEY_SABISUCODE = "サービス種類コード";
    private static final String KEY_HOKENSYACODE = "保険者コード";
    private static final String KEY_TYUSHUTUHOHO = "抽出方法";
    private static final String KEY_KAISHIYM = "サービス提供年月開始年月";
    private static final String KEY_SYURYOYM = "サービス提供年月終了年月";
    private static final String KEY_SHINSAYMFORM = "審査年月開始年月";
    private static final String KEY_SHINSAYMTO = "審査年月終了年月";
    private static final String KEY_TORIKOMIFROM = "取込年月開始年月";
    private static final String KEY_TORIKOMITO = "取込年月終了年月";
    private static final String KEY_JIGYOSYAMEI = "事業者名";
    private static final String KEY_SABISUMESYU = "サービス名称";

    @BatchParameter(key = KEY_REPORTID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNKOMOKUID, name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = KEY_KOMOUKUMEI, name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = KEY_RENBANFUKA, name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = KEY_ISDATEEDIT, name = "is日付スラッシュ付加")
    private boolean is日付スラッシュ付加;
    @BatchParameter(key = KEY_JIGYOSYACODE, name = "事業者コード")
    private RString 事業者コード;
    @BatchParameter(key = KEY_SABISUCODE, name = "サービス種類コード")
    private RString サービス種類コード;
    @BatchParameter(key = KEY_HOKENSYACODE, name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = KEY_TYUSHUTUHOHO, name = "抽出方法")
    private RString 抽出方法;
    @BatchParameter(key = KEY_KAISHIYM, name = "サービス提供年月開始年月")
    private RString サービス提供年月開始年月;
    @BatchParameter(key = KEY_SYURYOYM, name = "サービス提供年月終了年月")
    private RString サービス提供年月終了年月;
    @BatchParameter(key = KEY_SHINSAYMFORM, name = "審査年月開始年月")
    private RString 審査年月開始年月;
    @BatchParameter(key = KEY_SHINSAYMTO, name = "審査年月終了年月")
    private RString 審査年月終了年月;
    @BatchParameter(key = KEY_TORIKOMIFROM, name = "取込年月開始年月")
    private RString 取込年月開始年月;
    @BatchParameter(key = KEY_TORIKOMITO, name = "取込年月終了年月")
    private RString 取込年月終了年月;
    @BatchParameter(key = KEY_JIGYOSYAMEI, name = "事業者名")
    private RString 事業者名;
    @BatchParameter(key = KEY_SABISUMESYU, name = "サービス名称")
    private RString サービス名称;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public HanyoListSogoJigyoHiProcessParameter toProcessParameter() {
        return new HanyoListSogoJigyoHiProcessParameter(帳票ID,
                出力順ID,
                出力順項目ID,
                is項目名付加,
                is連番付加,
                is日付スラッシュ付加,
                事業者コード,
                サービス種類コード,
                保険者コード,
                抽出方法,
                サービス提供年月開始年月,
                サービス提供年月終了年月,
                審査年月開始年月,
                審査年月終了年月,
                取込年月開始年月,
                取込年月終了年月,
                事業者名,
                サービス名称);
    }

}
