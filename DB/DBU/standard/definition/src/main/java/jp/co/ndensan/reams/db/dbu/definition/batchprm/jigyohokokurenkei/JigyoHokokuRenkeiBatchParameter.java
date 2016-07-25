/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.jigyohokokurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式別連携情報作成のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class JigyoHokokuRenkeiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = -4784133600634129238L;
    private static final String 過去集計年月キー = "過去集計年月";
    private static final String 集計年月1_10 = "一般状況1_10集計年月";
    private static final String 現物分_集計年月11_14 = "一般状況11_14現物分_集計年月";
    private static final String 償還分_集計年月11_14 = "一般状況11_14償還分_集計年月";
    private static final String 現物分_集計年月 = "保険給付決定状況現物分_集計年月";
    private static final String 償還分_集計年月 = "保険給付決定状況償還分_集計年月";
    private static final String IS出力_1_10 = "is出力_一般状況1_10";
    private static final String IS出力_11_14現物分 = "is出力_一般状況11_14現物分";
    private static final String IS出力_11_14償還分_審査年月 = "is出力_一般状況11_14償還分_審査年月";
    private static final String IS出力_11_14償還分_決定年月 = "is出力_一般状況11_14償還分_決定年月";
    private static final String IS出力_11_14合算_審査年月 = "is出力_一般状況11_14合算_審査年月";
    private static final String IS出力_11_14合算_決定年月 = "is出力_一般状況11_14合算_決定年月";
    private static final String IS出力_現物分 = "is出力_保険給付決定状況現物分";
    private static final String IS出力_償還分_審査年月 = "is出力_保険給付決定状況償還分_審査年月";
    private static final String IS出力_償還分_決定年月 = "is出力_保険給付決定状況償還分_決定年月";
    private static final String IS出力_合算_審査年月 = "is出力_保険給付決定状況合算_審査年月";
    private static final String IS出力_合算_決定年月 = "is出力_保険給付決定状況合算_決定年月";
    private static final String 市町村コードリストキー = "市町村コードリスト";
    private static final String IS旧保険者分キー = "is旧保険者分";
    private static final String IS構成市町村分キー = "is構成市町村分";

    @BatchParameter(key = 過去集計年月キー, name = "過去集計年月")
    private RString 過去集計年月;
    @BatchParameter(key = 集計年月1_10, name = "一般状況1_10集計年月")
    private RString 一般状況1_10集計年月;
    @BatchParameter(key = 現物分_集計年月11_14, name = "一般状況11_14現物分_集計年月")
    private RString 一般状況11_14現物分_集計年月;
    @BatchParameter(key = 償還分_集計年月11_14, name = "一般状況11_14償還分_集計年月")
    private RString 一般状況11_14償還分_集計年月;
    @BatchParameter(key = 現物分_集計年月, name = "保険給付決定状況現物分_集計年月")
    private RString 保険給付決定状況現物分_集計年月;
    @BatchParameter(key = 償還分_集計年月, name = "保険給付決定状況償還分_集計年月")
    private RString 保険給付決定状況償還分_集計年月;
    @BatchParameter(key = IS出力_1_10, name = "is出力_一般状況1_10")
    private boolean is出力_一般状況1_10;
    @BatchParameter(key = IS出力_11_14現物分, name = "is出力_一般状況11_14現物分")
    private boolean is出力_一般状況11_14現物分;
    @BatchParameter(key = IS出力_11_14償還分_審査年月, name = "is出力_一般状況11_14償還分_審査年月")
    private boolean is出力_一般状況11_14償還分_審査年月;
    @BatchParameter(key = IS出力_11_14償還分_決定年月, name = "is出力_一般状況11_14償還分_決定年月")
    private boolean is出力_一般状況11_14償還分_決定年月;
    @BatchParameter(key = IS出力_11_14合算_審査年月, name = "is出力_一般状況11_14合算_審査年月")
    private boolean is出力_一般状況11_14合算_審査年月;
    @BatchParameter(key = IS出力_11_14合算_決定年月, name = "is出力_一般状況11_14合算_決定年月")
    private boolean is出力_一般状況11_14合算_決定年月;
    @BatchParameter(key = IS出力_現物分, name = "is出力_保険給付決定状況現物分")
    private boolean is出力_保険給付決定状況現物分;
    @BatchParameter(key = IS出力_償還分_審査年月, name = "is出力_保険給付決定状況償還分_審査年月")
    private boolean is出力_保険給付決定状況償還分_審査年月;
    @BatchParameter(key = IS出力_償還分_決定年月, name = "is出力_保険給付決定状況償還分_決定年月")
    private boolean is出力_保険給付決定状況償還分_決定年月;
    @BatchParameter(key = IS出力_合算_審査年月, name = "is出力_保険給付決定状況合算_審査年月")
    private boolean is出力_保険給付決定状況合算_審査年月;
    @BatchParameter(key = IS出力_合算_決定年月, name = "is出力_保険給付決定状況合算_決定年月")
    private boolean is出力_保険給付決定状況合算_決定年月;
    @BatchParameter(key = 市町村コードリストキー, name = "市町村コードリスト")
    private List<RString> 市町村コードリスト;
    @BatchParameter(key = IS旧保険者分キー, name = "is旧保険者分")
    private boolean is旧保険者分;
    @BatchParameter(key = IS構成市町村分キー, name = "is構成市町村分")
    private boolean is構成市町村分;

    /**
     * コンストラクタです。
     *
     * @param 過去集計年月 RString
     * @param 一般状況1_10集計年月 RString
     * @param 一般状況11_14現物分_集計年月 RString
     * @param 一般状況11_14償還分_集計年月 RString
     * @param 保険給付決定状況現物分_集計年月 RString
     * @param 保険給付決定状況償還分_集計年月 RString
     * @param is出力_一般状況1_10 boolean
     * @param is出力_一般状況11_14現物分 boolean
     * @param is出力_一般状況11_14償還分_審査年月 boolean
     * @param is出力_一般状況11_14償還分_決定年月 boolean
     * @param is出力_一般状況11_14合算_審査年月 boolean
     * @param is出力_一般状況11_14合算_決定年月 boolean
     * @param is出力_保険給付決定状況現物分 boolean
     * @param is出力_保険給付決定状況償還分_審査年月 boolean
     * @param is出力_保険給付決定状況償還分_決定年月 boolean
     * @param is出力_保険給付決定状況合算_審査年月 boolean
     * @param is出力_保険給付決定状況合算_決定年月 boolean
     * @param 市町村コードリスト List<RString>
     * @param is旧保険者分 boolean
     * @param is構成市町村分 boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public JigyoHokokuRenkeiBatchParameter(
            RString 過去集計年月,
            RString 一般状況1_10集計年月,
            RString 一般状況11_14現物分_集計年月,
            RString 一般状況11_14償還分_集計年月,
            RString 保険給付決定状況現物分_集計年月,
            RString 保険給付決定状況償還分_集計年月,
            boolean is出力_一般状況1_10,
            boolean is出力_一般状況11_14現物分,
            boolean is出力_一般状況11_14償還分_審査年月,
            boolean is出力_一般状況11_14償還分_決定年月,
            boolean is出力_一般状況11_14合算_審査年月,
            boolean is出力_一般状況11_14合算_決定年月,
            boolean is出力_保険給付決定状況現物分,
            boolean is出力_保険給付決定状況償還分_審査年月,
            boolean is出力_保険給付決定状況償還分_決定年月,
            boolean is出力_保険給付決定状況合算_審査年月,
            boolean is出力_保険給付決定状況合算_決定年月,
            List<RString> 市町村コードリスト,
            boolean is旧保険者分,
            boolean is構成市町村分
    ) {
        this.過去集計年月 = 過去集計年月;
        this.一般状況1_10集計年月 = 一般状況1_10集計年月;
        this.一般状況11_14現物分_集計年月 = 一般状況11_14現物分_集計年月;
        this.一般状況11_14償還分_集計年月 = 一般状況11_14償還分_集計年月;
        this.保険給付決定状況現物分_集計年月 = 保険給付決定状況現物分_集計年月;
        this.保険給付決定状況償還分_集計年月 = 保険給付決定状況償還分_集計年月;
        this.is出力_一般状況1_10 = is出力_一般状況1_10;
        this.is出力_一般状況11_14現物分 = is出力_一般状況11_14現物分;
        this.is出力_一般状況11_14償還分_審査年月 = is出力_一般状況11_14償還分_審査年月;
        this.is出力_一般状況11_14償還分_決定年月 = is出力_一般状況11_14償還分_決定年月;
        this.is出力_一般状況11_14合算_審査年月 = is出力_一般状況11_14合算_審査年月;
        this.is出力_一般状況11_14合算_決定年月 = is出力_一般状況11_14合算_決定年月;
        this.is出力_保険給付決定状況現物分 = is出力_保険給付決定状況現物分;
        this.is出力_保険給付決定状況償還分_審査年月 = is出力_保険給付決定状況償還分_審査年月;
        this.is出力_保険給付決定状況償還分_決定年月 = is出力_保険給付決定状況償還分_決定年月;
        this.is出力_保険給付決定状況合算_審査年月 = is出力_保険給付決定状況合算_審査年月;
        this.is出力_保険給付決定状況合算_決定年月 = is出力_保険給付決定状況合算_決定年月;
        this.市町村コードリスト = 市町村コードリスト;
        this.is旧保険者分 = is旧保険者分;
        this.is構成市町村分 = is構成市町村分;
    }

    /**
     * 様式別連携情報作成のプロセスのパラメータを設定します。
     *
     * @return 様式別連携情報作成のProcessParameter
     */
    public JigyoHokokuRenkeiProcessParameter toJigyoHokokuRenkeiProcessParameter() {
        return new JigyoHokokuRenkeiProcessParameter(
                過去集計年月,
                一般状況1_10集計年月,
                一般状況11_14現物分_集計年月,
                一般状況11_14償還分_集計年月,
                保険給付決定状況現物分_集計年月,
                保険給付決定状況償還分_集計年月,
                is出力_一般状況1_10,
                is出力_一般状況11_14現物分,
                is出力_一般状況11_14償還分_審査年月,
                is出力_一般状況11_14償還分_決定年月,
                is出力_一般状況11_14合算_審査年月,
                is出力_一般状況11_14合算_決定年月,
                is出力_保険給付決定状況現物分,
                is出力_保険給付決定状況償還分_審査年月,
                is出力_保険給付決定状況償還分_決定年月,
                is出力_保険給付決定状況合算_審査年月,
                is出力_保険給付決定状況合算_決定年月,
                市町村コードリスト,
                is旧保険者分,
                is構成市町村分);
    }
}
