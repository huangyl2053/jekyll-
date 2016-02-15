/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 住宅改修MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;
    private final RString 連番;
    private final ServiceCode サービスコード;
    private final FlexibleDate 住宅改修着工年月日;
    private final RString 住宅改修内容;
    private final RString 住宅改修事業者名;
    private final RString 住宅改修住宅住所;
    private final int 改修金額;
    private final FlexibleDate 住宅改修完成年月日;
    private final int 差額金額;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     */
    private JutakuKaishuParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceCode サービスコード,
            FlexibleDate 住宅改修着工年月日,
            RString 住宅改修内容,
            RString 住宅改修事業者名,
            RString 住宅改修住宅住所,
            int 改修金額,
            FlexibleDate 住宅改修完成年月日,
            int 差額金額,
            RString 状態) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.サービスコード = サービスコード;
        this.住宅改修着工年月日 = 住宅改修着工年月日;
        this.住宅改修内容 = 住宅改修内容;
        this.住宅改修事業者名 = 住宅改修事業者名;
        this.住宅改修住宅住所 = 住宅改修住宅住所;
        this.改修金額 = 改修金額;
        this.住宅改修完成年月日 = 住宅改修完成年月日;
        this.差額金額 = 差額金額;
        this.状態 = 状態;

    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @param サービスコード
     * @param 住宅改修着工年月日
     * @param 住宅改修内容
     * @param 住宅改修事業者名
     * @param 住宅改修住宅住所
     * @param 改修金額
     * @param 住宅改修完成年月日
     * @param 差額金額
     * @param 状態
     * @return
     */
    public static JutakuKaishuParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceCode サービスコード,
            FlexibleDate 住宅改修着工年月日,
            RString 住宅改修内容,
            RString 住宅改修事業者名,
            RString 住宅改修住宅住所,
            int 改修金額,
            FlexibleDate 住宅改修完成年月日,
            int 差額金額,
            RString 状態) {
        return new JutakuKaishuParameter(
                被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番, サービスコード,
                住宅改修着工年月日, 住宅改修内容, 住宅改修事業者名, 住宅改修住宅住所, 改修金額,
                住宅改修完成年月日, 差額金額, 状態);
    }
}
