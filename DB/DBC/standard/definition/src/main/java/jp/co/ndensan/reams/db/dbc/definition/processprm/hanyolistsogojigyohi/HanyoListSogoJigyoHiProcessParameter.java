/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsogojigyohi;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_総合事業費情報のProcessParameterクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListSogoJigyoHiProcessParameter implements IBatchProcessParameter {

    private final RString 帳票ID;
    private final long 出力順ID;
    private final RString 出力順項目ID;
    private final boolean is項目名付加;
    private final boolean is連番付加;
    private final boolean is日付スラッシュ付加;
    private final RString 事業者コード;
    private final RString サービス種類コード;
    private final RString 保険者コード;
    private final RString 抽出方法;
    private final RString サービス提供年月開始年月;
    private final RString サービス提供年月終了年月;
    private final RString 審査年月開始年月;
    private final RString 審査年月終了年月;
    private final RString 取込年月開始年月;
    private final RString 取込年月終了年月;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 出力順項目ID 出力順項目ID
     * @param is項目名付加 is項目名付加
     * @param is連番付加 is連番付加
     * @param is日付スラッシュ付加 is日付スラッシュ付加
     * @param 事業者コード 事業者コード
     * @param サービス種類コード サービス種類コード
     * @param 保険者コード 保険者コード
     * @param 抽出方法 抽出方法
     * @param サービス提供年月開始年月 サービス提供年月開始年月
     * @param サービス提供年月終了年月 サービス提供年月終了年月
     * @param 審査年月開始年月 審査年月開始年月
     * @param 審査年月終了年月 審査年月終了年月
     * @param 取込年月開始年月 取込年月開始年月
     * @param 取込年月終了年月 取込年月終了年月
     */
    public HanyoListSogoJigyoHiProcessParameter(RString 帳票ID,
            long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付スラッシュ付加,
            RString 事業者コード,
            RString サービス種類コード,
            RString 保険者コード,
            RString 抽出方法,
            RString サービス提供年月開始年月,
            RString サービス提供年月終了年月,
            RString 審査年月開始年月,
            RString 審査年月終了年月,
            RString 取込年月開始年月,
            RString 取込年月終了年月) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力順項目ID = 出力順項目ID;
        this.is項目名付加 = is項目名付加;
        this.is連番付加 = is連番付加;
        this.is日付スラッシュ付加 = is日付スラッシュ付加;
        this.事業者コード = 事業者コード;
        this.サービス種類コード = サービス種類コード;
        this.保険者コード = 保険者コード;
        this.抽出方法 = 抽出方法;
        this.サービス提供年月開始年月 = サービス提供年月開始年月;
        this.サービス提供年月終了年月 = サービス提供年月終了年月;
        this.審査年月開始年月 = 審査年月開始年月;
        this.審査年月終了年月 = 審査年月終了年月;
        this.取込年月開始年月 = 取込年月開始年月;
        this.取込年月終了年月 = 取込年月終了年月;
    }

}
