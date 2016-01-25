/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支給申請登録MyBatisパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 提供購入年月;
    private final RString 取得された整理番号;
    private final HokenshaNo 証記載保険者番号;
    private final FlexibleDate 受付年月日;
    private final FlexibleDate 申請日;
    private final RString 申請理由;
    private final RString 申請者区分;
    private final RString 氏名;
    private final RString 氏名カナ;
    private final Decimal 支払金額合計;
    private final int 保険給付額;
    private final int 利用者給付額;
    private final RString DBC介護給付;
    private final RString DBC介護給付コンフィグ;
    private final boolean FALSE;
    private final RString 選択された支払方法コード;
    private final RString 支払場所;
    private final FlexibleDate 支払期間開始年月日;
    private final FlexibleDate 支払期間終了年月日;
    private final RString 支払窓口開始時間;
    private final RString 支払窓口終了時間;
    private final long 口座ID;
    private final RString 受領委任契約番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 取得された整理番号
     * @param 証記載保険者番号
     * @param 受付年月日
     * @param 申請日
     * @param 申請理由
     * @param 申請者区分
     * @param 氏名
     * @param 氏名カナ
     * @param 支払金額合計
     * @param 保険給付額
     * @param 利用者給付額
     * @param DBC介護給付
     * @param DBC介護給付コンフィグ
     * @param FALSE
     * @param 選択された支払方法コード
     * @param 支払場所
     * @param 支払期間開始年月日
     * @param 支払期間終了年月日
     * @param 支払窓口開始時間
     * @param 支払窓口終了時間
     * @param 口座ID
     * @param 受領委任契約番号
     */
    private ShokanShinseiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 提供購入年月,
            RString 取得された整理番号,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            FlexibleDate 申請日,
            RString 申請理由,
            RString 申請者区分,
            RString 氏名,
            RString 氏名カナ,
            Decimal 支払金額合計,
            int 保険給付額,
            int 利用者給付額,
            RString DBC介護給付,
            RString DBC介護給付コンフィグ,
            boolean FALSE,
            RString 選択された支払方法コード,
            RString 支払場所,
            FlexibleDate 支払期間開始年月日,
            FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間,
            RString 支払窓口終了時間,
            long 口座ID,
            RString 受領委任契約番号) {
        this.被保険者番号 = 被保険者番号;
        this.提供購入年月 = 提供購入年月;
        this.取得された整理番号 = 取得された整理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.受付年月日 = 受付年月日;
        this.申請日 = 申請日;
        this.申請理由 = 申請理由;
        this.申請者区分 = 申請者区分;
        this.氏名 = 氏名;
        this.氏名カナ = 氏名カナ;
        this.支払金額合計 = 支払金額合計;
        this.保険給付額 = 保険給付額;
        this.利用者給付額 = 利用者給付額;
        this.DBC介護給付 = DBC介護給付;
        this.DBC介護給付コンフィグ = DBC介護給付コンフィグ;
        this.FALSE = FALSE;
        this.選択された支払方法コード = 選択された支払方法コード;
        this.支払場所 = 支払場所;
        this.支払期間開始年月日 = 支払期間開始年月日;
        this.支払期間終了年月日 = 支払期間終了年月日;
        this.支払窓口開始時間 = 支払窓口開始時間;
        this.支払窓口終了時間 = 支払窓口終了時間;
        this.口座ID = 口座ID;
        this.受領委任契約番号 = 受領委任契約番号;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 取得された整理番号
     * @param 証記載保険者番号
     * @param 受付年月日
     * @param 申請日
     * @param 申請理由
     * @param 申請者区分
     * @param 氏名
     * @param 氏名カナ
     * @param 支払金額合計
     * @param 保険給付額
     * @param 利用者給付額
     * @param DBC介護給付
     * @param DBC介護給付コンフィグ
     * @param FALSE
     * @param 選択された支払方法コード
     * @param 支払場所
     * @param 支払期間開始年月日
     * @param 支払期間終了年月日
     * @param 支払窓口開始時間
     * @param 支払窓口終了時間
     * @param 口座ID
     * @param 受領委任契約番号
     * @return
     */
    public static ShokanShinseiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 提供購入年月,
            RString 取得された整理番号,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            FlexibleDate 申請日,
            RString 申請理由,
            RString 申請者区分,
            RString 氏名,
            RString 氏名カナ,
            Decimal 支払金額合計,
            int 保険給付額,
            int 利用者給付額,
            RString DBC介護給付,
            RString DBC介護給付コンフィグ,
            boolean FALSE,
            RString 選択された支払方法コード,
            RString 支払場所,
            FlexibleDate 支払期間開始年月日,
            FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間,
            RString 支払窓口終了時間,
            long 口座ID,
            RString 受領委任契約番号) {
        return new ShokanShinseiParameter(被保険者番号, 提供購入年月, 取得された整理番号, 証記載保険者番号,
                受付年月日, 申請日, 申請理由, 申請者区分, 氏名, 氏名カナ, 支払金額合計, 保険給付額, 利用者給付額,
                DBC介護給付, DBC介護給付コンフィグ, FALSE, 選択された支払方法コード, 支払場所, 支払期間開始年月日,
                支払期間終了年月日, 支払窓口開始時間, 支払窓口終了時間, 口座ID, 受領委任契約番号);
    }

}
