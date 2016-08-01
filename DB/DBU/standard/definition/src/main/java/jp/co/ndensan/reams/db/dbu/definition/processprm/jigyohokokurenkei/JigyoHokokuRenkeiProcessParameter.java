/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokurenkei.JigyoHokokuRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 様式別連携情報作成のプロセス用パラメータクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JigyoHokokuRenkeiProcessParameter implements IBatchProcessParameter {

    private RString spoolWorkPath;
    private static final int 桁数_４ = 4;
    private RString 過去集計年月;
    private RString 一般状況1_10集計年月;
    private RString 一般状況11_14現物分_集計年月;
    private RString 一般状況11_14償還分_集計年月;
    private RString 保険給付決定状況現物分_集計年月;
    private RString 保険給付決定状況償還分_集計年月;
    private boolean is出力_一般状況1_10;
    private boolean is出力_一般状況11_14現物分;
    private boolean is出力_一般状況11_14償還分_審査年月;
    private boolean is出力_一般状況11_14償還分_決定年月;
    private boolean is出力_一般状況11_14合算_審査年月;
    private boolean is出力_一般状況11_14合算_決定年月;
    private boolean is出力_保険給付決定状況現物分;
    private boolean is出力_保険給付決定状況償還分_審査年月;
    private boolean is出力_保険給付決定状況償還分_決定年月;
    private boolean is出力_保険給付決定状況合算_審査年月;
    private boolean is出力_保険給付決定状況合算_決定年月;
    private List<RString> 市町村コードリスト;
    private boolean is旧保険者分;
    private boolean is構成市町村分;

    /**
     * コンストラクタです。
     *
     * @param spoolWorkPath RString
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
     */
    public JigyoHokokuRenkeiProcessParameter(
            RString spoolWorkPath,
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
        this.spoolWorkPath = spoolWorkPath;
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
     * 様式別連携情報作成のMyBatisパラメータ作成です。
     *
     * @return 様式別連携情報作成のMyBatisパラメータ
     */
    public JigyoHokokuRenkeiParameter toMybatisParamter() {
        RString 過去集計年月_年 = RString.EMPTY;
        RString 過去集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(過去集計年月)) {
            過去集計年月_年 = 過去集計年月.substring(0, 桁数_４);
            過去集計年月_月 = 過去集計年月.substring(桁数_４);
        }
        RString 一般状況1_10集計年月_年 = RString.EMPTY;
        RString 一般状況1_10集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(一般状況1_10集計年月)) {
            一般状況1_10集計年月_年 = 一般状況1_10集計年月.substring(0, 桁数_４);
            一般状況1_10集計年月_月 = 一般状況1_10集計年月.substring(桁数_４);
        }
        RString 一般状況11_14現物分_集計年月_年 = RString.EMPTY;
        RString 一般状況11_14現物分_集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(一般状況11_14現物分_集計年月)) {
            一般状況11_14現物分_集計年月_年 = 一般状況11_14現物分_集計年月.substring(0, 桁数_４);
            一般状況11_14現物分_集計年月_月 = 一般状況11_14現物分_集計年月.substring(桁数_４);
        }
        RString 一般状況11_14償還分_集計年月_年 = RString.EMPTY;
        RString 一般状況11_14償還分_集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(一般状況11_14償還分_集計年月)) {
            一般状況11_14償還分_集計年月_年 = 一般状況11_14償還分_集計年月.substring(0, 桁数_４);
            一般状況11_14償還分_集計年月_月 = 一般状況11_14償還分_集計年月.substring(桁数_４);
        }
        RString 保険給付決定状況現物分_集計年月_年 = RString.EMPTY;
        RString 保険給付決定状況現物分_集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(保険給付決定状況現物分_集計年月)) {
            保険給付決定状況現物分_集計年月_年 = 保険給付決定状況現物分_集計年月.substring(0, 桁数_４);
            保険給付決定状況現物分_集計年月_月 = 保険給付決定状況現物分_集計年月.substring(桁数_４);
        }
        RString 保険給付決定状況償還分_集計年月_年 = RString.EMPTY;
        RString 保険給付決定状況償還分_集計年月_月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(保険給付決定状況償還分_集計年月)) {
            保険給付決定状況償還分_集計年月_年 = 保険給付決定状況償還分_集計年月.substring(0, 桁数_４);
            保険給付決定状況償還分_集計年月_月 = 保険給付決定状況償還分_集計年月.substring(桁数_４);
        }
        RString 統計対象区分 = RString.EMPTY;
        if (is旧保険者分 || is構成市町村分) {
            統計対象区分 = new RString("1");
        } else {
            統計対象区分 = new RString("0");
        }
        RString 表番号 = RString.EMPTY;
        if (is旧保険者分) {
            表番号 = new RString("11");
        } else {
            表番号 = new RString("01");
        }
        RString 審査_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            審査_表番号 = new RString("13");
        } else {
            審査_表番号 = new RString("03");
        }
        RString 決定_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            決定_表番号 = new RString("15");
        } else {
            決定_表番号 = new RString("05");
        }
        RString 保険給付決定_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            保険給付決定_表番号 = new RString("12");
        } else {
            保険給付決定_表番号 = new RString("02");
        }
        RString 保険給付決定_審査_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            保険給付決定_審査_表番号 = new RString("14");
        } else {
            保険給付決定_審査_表番号 = new RString("04");
        }
        RString 保険給付決定_決定_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            保険給付決定_決定_表番号 = new RString("16");
        } else {
            保険給付決定_決定_表番号 = new RString("06");
        }
        RString 保険給付決定_決定2_表番号 = RString.EMPTY;
        if (is旧保険者分) {
            保険給付決定_決定2_表番号 = new RString("17");
        } else {
            保険給付決定_決定2_表番号 = new RString("07");
        }

        return new JigyoHokokuRenkeiParameter(
                市町村コードリスト,
                過去集計年月_年,
                過去集計年月_月,
                一般状況1_10集計年月_年,
                一般状況1_10集計年月_月,
                一般状況11_14現物分_集計年月_年,
                一般状況11_14現物分_集計年月_月,
                一般状況11_14償還分_集計年月_年,
                一般状況11_14償還分_集計年月_月,
                保険給付決定状況現物分_集計年月_年,
                保険給付決定状況現物分_集計年月_月,
                保険給付決定状況償還分_集計年月_年,
                保険給付決定状況償還分_集計年月_月,
                統計対象区分,
                表番号,
                審査_表番号,
                決定_表番号,
                保険給付決定_表番号,
                保険給付決定_審査_表番号,
                保険給付決定_決定_表番号,
                保険給付決定_決定2_表番号
        );
    }
}
