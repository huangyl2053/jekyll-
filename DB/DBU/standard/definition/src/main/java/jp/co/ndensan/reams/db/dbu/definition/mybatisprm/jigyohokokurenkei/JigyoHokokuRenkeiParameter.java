/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokurenkei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 様式別連携情報作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuRenkeiParameter implements IMyBatisParameter {

    private final List<RString> 市町村コードリスト;
    private final RString 過去集計年月_年;
    private final RString 過去集計年月_月;
    private final RString 一般状況1_10集計年月_年;
    private final RString 一般状況1_10集計年月_月;
    private final RString 一般状況11_14現物分_集計年月_年;
    private final RString 一般状況11_14現物分_集計年月_月;
    private final RString 一般状況11_14償還分_集計年月_年;
    private final RString 一般状況11_14償還分_集計年月_月;
    private final RString 保険給付決定状況現物分_集計年月_年;
    private final RString 保険給付決定状況現物分_集計年月_月;
    private final RString 保険給付決定状況償還分_集計年月_年;
    private final RString 保険給付決定状況償還分_集計年月_月;
    private final RString 統計対象区分;
    private final RString 表番号;
    private final RString 審査_表番号;
    private final RString 決定_表番号;
    private final RString 保険給付決定_表番号;
    private final RString 保険給付決定_審査_表番号;
    private final RString 保険給付決定_決定_表番号;
    private final RString 保険給付決定_決定2_表番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コードリスト List<RString>
     * @param 過去集計年月_年 RString
     * @param 過去集計年月_月 RString
     * @param 一般状況1_10集計年月_年 RString
     * @param 一般状況1_10集計年月_月 RString
     * @param 一般状況11_14現物分_集計年月_年 RString
     * @param 一般状況11_14現物分_集計年月_月 RString
     * @param 一般状況11_14償還分_集計年月_年 RString
     * @param 一般状況11_14償還分_集計年月_月 RString
     * @param 保険給付決定状況現物分_集計年月_年 RString
     * @param 保険給付決定状況現物分_集計年月_月 RString
     * @param 保険給付決定状況償還分_集計年月_年 RString
     * @param 保険給付決定状況償還分_集計年月_月 RString
     * @param 統計対象区分 RString
     * @param 表番号 RString
     * @param 審査_表番号 RString
     * @param 決定_表番号 RString
     * @param 保険給付決定_表番号 RString
     * @param 保険給付決定_審査_表番号 RString
     * @param 保険給付決定_決定_表番号 RString
     * @param 保険給付決定_決定2_表番号 RString
     */
    public JigyoHokokuRenkeiParameter(
            List<RString> 市町村コードリスト,
            RString 過去集計年月_年,
            RString 過去集計年月_月,
            RString 一般状況1_10集計年月_年,
            RString 一般状況1_10集計年月_月,
            RString 一般状況11_14現物分_集計年月_年,
            RString 一般状況11_14現物分_集計年月_月,
            RString 一般状況11_14償還分_集計年月_年,
            RString 一般状況11_14償還分_集計年月_月,
            RString 保険給付決定状況現物分_集計年月_年,
            RString 保険給付決定状況現物分_集計年月_月,
            RString 保険給付決定状況償還分_集計年月_年,
            RString 保険給付決定状況償還分_集計年月_月,
            RString 統計対象区分,
            RString 表番号,
            RString 審査_表番号,
            RString 決定_表番号,
            RString 保険給付決定_表番号,
            RString 保険給付決定_審査_表番号,
            RString 保険給付決定_決定_表番号,
            RString 保険給付決定_決定2_表番号
    ) {
        this.市町村コードリスト = 市町村コードリスト;
        this.過去集計年月_年 = 過去集計年月_年;
        this.過去集計年月_月 = 過去集計年月_月;
        this.一般状況1_10集計年月_年 = 一般状況1_10集計年月_年;
        this.一般状況1_10集計年月_月 = 一般状況1_10集計年月_月;
        this.一般状況11_14現物分_集計年月_年 = 一般状況11_14現物分_集計年月_年;
        this.一般状況11_14現物分_集計年月_月 = 一般状況11_14現物分_集計年月_月;
        this.一般状況11_14償還分_集計年月_年 = 一般状況11_14償還分_集計年月_年;
        this.一般状況11_14償還分_集計年月_月 = 一般状況11_14償還分_集計年月_月;
        this.保険給付決定状況現物分_集計年月_年 = 保険給付決定状況現物分_集計年月_年;
        this.保険給付決定状況現物分_集計年月_月 = 保険給付決定状況現物分_集計年月_月;
        this.保険給付決定状況償還分_集計年月_年 = 保険給付決定状況償還分_集計年月_年;
        this.保険給付決定状況償還分_集計年月_月 = 保険給付決定状況償還分_集計年月_月;
        this.統計対象区分 = 統計対象区分;
        this.表番号 = 表番号;
        this.審査_表番号 = 審査_表番号;
        this.決定_表番号 = 決定_表番号;
        this.保険給付決定_表番号 = 保険給付決定_表番号;
        this.保険給付決定_審査_表番号 = 保険給付決定_審査_表番号;
        this.保険給付決定_決定_表番号 = 保険給付決定_決定_表番号;
        this.保険給付決定_決定2_表番号 = 保険給付決定_決定2_表番号;
    }
}
