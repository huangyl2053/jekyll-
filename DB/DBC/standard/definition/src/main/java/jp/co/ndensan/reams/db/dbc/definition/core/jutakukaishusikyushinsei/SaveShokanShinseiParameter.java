/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 償還払支給申請MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaveShokanShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final FlexibleDate 受付年月日;
    private final FlexibleDate 申請年月日;
    private final RString 申請理由;
    private final RString 申請者区分;
    private final RString 申請者氏名;
    private final RString 申請者氏名カナ;
    private final YubinNo 申請者郵便番号;
    private final RString 申請者住所;
    private final TelNo 申請者電話番号;
    private final JigyoshaNo 申請事業者番号;
    private final FlexibleDate 理由書作成日;
    private final RString 理由書作成者;
    private final RString 理由書作成者カナ;
    private final JigyoshaNo 理由書作成事業者番号;
    private final Decimal 支払金額合計;
    private final Decimal 保険対象費用額;
    private final int 保険給付額;
    private final int 利用者負担額;
    private final RString 支給申請審査区分;
    private final RString 審査方法区分;
    private final RString 送付区分;
    private final FlexibleYearMonth 送付年月;
    private final boolean 国保連再送付フラグ;
    private final RString 支払方法区分コード;
    private final RString 支払場所;
    private final FlexibleDate 支払期間開始年月日;
    private final FlexibleDate 支払期間終了年月日;
    private final RString 支払窓口開始時間;
    private final RString 支払窓口終了時間;
    private final long 口座ID;
    private final RString 受領委任契約番号;
    private final RString 住宅所有者;
    private final RString 被保険者との関係;
    private final boolean 要介護状態３段階変更;
    private final boolean 住宅住所変更;
    private final FlexibleDate 審査年月日;
    private final RString 審査結果;
    private final FlexibleYearMonth 事前申請サービス提供年月;
    private final RString 事前申請整理番号;
    private final RString 住宅改修申請区分;
    private final RString 住宅改修申請取消事由コード;
    private final FlexibleDate 領収年月日;

    /**
     * コンストラクタです。
     *
     */
    private SaveShokanShinseiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            FlexibleDate 申請年月日,
            RString 申請理由,
            RString 申請者区分,
            RString 申請者氏名,
            RString 申請者氏名カナ,
            YubinNo 申請者郵便番号,
            RString 申請者住所,
            TelNo 申請者電話番号,
            JigyoshaNo 申請事業者番号,
            FlexibleDate 理由書作成日,
            RString 理由書作成者,
            RString 理由書作成者カナ,
            JigyoshaNo 理由書作成事業者番号,
            Decimal 支払金額合計,
            Decimal 保険対象費用額,
            int 保険給付額,
            int 利用者負担額,
            RString 支給申請審査区分,
            RString 審査方法区分,
            RString 送付区分,
            FlexibleYearMonth 送付年月,
            boolean 国保連再送付フラグ,
            RString 支払方法区分コード,
            RString 支払場所,
            FlexibleDate 支払期間開始年月日,
            FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間,
            RString 支払窓口終了時間,
            long 口座ID,
            RString 受領委任契約番号,
            RString 住宅所有者,
            RString 被保険者との関係,
            boolean 要介護状態３段階変更,
            boolean 住宅住所変更,
            FlexibleDate 審査年月日,
            RString 審査結果,
            FlexibleYearMonth 事前申請サービス提供年月,
            RString 事前申請整理番号,
            RString 住宅改修申請区分,
            RString 住宅改修申請取消事由コード,
            FlexibleDate 領収年月日) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.受付年月日 = 受付年月日;
        this.申請年月日 = 申請年月日;
        this.申請理由 = 申請理由;
        this.申請者区分 = 申請者区分;
        this.申請者氏名 = 申請者氏名;
        this.申請者氏名カナ = 申請者氏名カナ;
        this.申請者郵便番号 = 申請者郵便番号;
        this.申請者住所 = 申請者住所;
        this.申請者電話番号 = 申請者電話番号;
        this.申請事業者番号 = 申請事業者番号;
        this.理由書作成日 = 理由書作成日;
        this.理由書作成者 = 理由書作成者;
        this.理由書作成者カナ = 理由書作成者カナ;
        this.理由書作成事業者番号 = 理由書作成事業者番号;
        this.支払金額合計 = 支払金額合計;
        this.保険対象費用額 = 保険対象費用額;
        this.保険給付額 = 保険給付額;
        this.利用者負担額 = 利用者負担額;
        this.支給申請審査区分 = 支給申請審査区分;
        this.審査方法区分 = 審査方法区分;
        this.送付区分 = 送付区分;
        this.送付年月 = 送付年月;
        this.国保連再送付フラグ = 国保連再送付フラグ;
        this.支払方法区分コード = 支払方法区分コード;
        this.支払場所 = 支払場所;
        this.支払期間開始年月日 = 支払期間開始年月日;
        this.支払期間終了年月日 = 支払期間終了年月日;
        this.支払窓口開始時間 = 支払窓口開始時間;
        this.支払窓口終了時間 = 支払窓口終了時間;
        this.口座ID = 口座ID;
        this.受領委任契約番号 = 受領委任契約番号;
        this.住宅所有者 = 住宅所有者;
        this.被保険者との関係 = 被保険者との関係;
        this.要介護状態３段階変更 = 要介護状態３段階変更;
        this.住宅住所変更 = 住宅住所変更;
        this.審査年月日 = 審査年月日;
        this.審査結果 = 審査結果;
        this.事前申請サービス提供年月 = 事前申請サービス提供年月;
        this.事前申請整理番号 = 事前申請整理番号;
        this.住宅改修申請区分 = 住宅改修申請区分;
        this.住宅改修申請取消事由コード = 住宅改修申請取消事由コード;
        this.領収年月日 = 領収年月日;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 証記載保険者番号
     * @param 受付年月日
     * @param 申請年月日
     * @param 申請理由
     * @param 申請者区分
     * @param 申請者氏名
     * @param 申請者氏名カナ
     * @param 申請者郵便番号
     * @param 申請者住所
     * @param 申請者電話番号
     * @param 申請事業者番号
     * @param 理由書作成日
     * @param 理由書作成者
     * @param 理由書作成者カナ
     * @param 理由書作成事業者番号
     * @param 支払金額合計
     * @param 保険対象費用額
     * @param 保険給付額
     * @param 利用者負担額
     * @param 支給申請審査区分
     * @param 審査方法区分
     * @param 送付区分
     * @param 送付年月
     * @param 国保連再送付フラグ
     * @param 支払方法区分コード
     * @param 支払場所
     * @param 支払期間開始年月日
     * @param 支払期間終了年月日
     * @param 支払窓口開始時間
     * @param 支払窓口終了時間
     * @param 口座ID
     * @param 受領委任契約番号
     * @param 住宅所有者
     * @param 被保険者との関係
     * @param 要介護状態３段階変更
     * @param 住宅住所変更
     * @param 審査年月日
     * @param 審査結果
     * @param 事前申請サービス提供年月
     * @param 事前申請整理番号
     * @param 住宅改修申請区分
     * @param 住宅改修申請取消事由コード
     * @param 領収年月日
     * @return
     */
    public static SaveShokanShinseiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            FlexibleDate 申請年月日,
            RString 申請理由,
            RString 申請者区分,
            RString 申請者氏名,
            RString 申請者氏名カナ,
            YubinNo 申請者郵便番号,
            RString 申請者住所,
            TelNo 申請者電話番号,
            JigyoshaNo 申請事業者番号,
            FlexibleDate 理由書作成日,
            RString 理由書作成者,
            RString 理由書作成者カナ,
            JigyoshaNo 理由書作成事業者番号,
            Decimal 支払金額合計,
            Decimal 保険対象費用額,
            int 保険給付額,
            int 利用者負担額,
            RString 支給申請審査区分,
            RString 審査方法区分,
            RString 送付区分,
            FlexibleYearMonth 送付年月,
            boolean 国保連再送付フラグ,
            RString 支払方法区分コード,
            RString 支払場所,
            FlexibleDate 支払期間開始年月日,
            FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間,
            RString 支払窓口終了時間,
            long 口座ID,
            RString 受領委任契約番号,
            RString 住宅所有者,
            RString 被保険者との関係,
            boolean 要介護状態３段階変更,
            boolean 住宅住所変更,
            FlexibleDate 審査年月日,
            RString 審査結果,
            FlexibleYearMonth 事前申請サービス提供年月,
            RString 事前申請整理番号,
            RString 住宅改修申請区分,
            RString 住宅改修申請取消事由コード,
            FlexibleDate 領収年月日) {
        return new SaveShokanShinseiParameter(被保険者番号, サービス提供年月, 整理番号, 証記載保険者番号, 受付年月日,
                申請年月日, 申請理由, 申請者区分, 申請者氏名, 申請者氏名カナ, 申請者郵便番号, 申請者住所,
                申請者電話番号, 申請事業者番号, 理由書作成日, 理由書作成者, 理由書作成者カナ, 理由書作成事業者番号,
                支払金額合計, 保険対象費用額, 保険給付額, 利用者負担額, 支給申請審査区分, 審査方法区分, 送付区分,
                送付年月, 国保連再送付フラグ, 支払方法区分コード, 支払場所, 支払期間開始年月日, 支払期間終了年月日,
                支払窓口開始時間, 支払窓口終了時間, 口座ID, 受領委任契約番号, 住宅所有者, 被保険者との関係,
                要介護状態３段階変更, 住宅住所変更, 審査年月日, 審査結果, 事前申請サービス提供年月, 事前申請整理番号,
                住宅改修申請区分, 住宅改修申請取消事由コード, 領収年月日);
    }
}
