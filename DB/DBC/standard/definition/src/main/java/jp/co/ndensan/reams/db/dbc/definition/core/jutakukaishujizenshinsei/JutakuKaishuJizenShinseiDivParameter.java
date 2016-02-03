/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class JutakuKaishuJizenShinseiDivParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final FlexibleDate 受付年月日;
    private final FlexibleDate 申請年月日;//
    private final RString 申請理由;
    private final RString 申請者区分;//
    private final RString 申請者氏名;//
    private final RString 申請者氏名カナ;//
    private final YubinNo 申請者郵便番号;//
    private final RString 申請者住所;//
    private final TelNo 申請者電話番号;
    private final JigyoshaNo 申請事業者番号;
    private final FlexibleDate 理由書作成日;
    private final RString 理由書作成者;
    private final RString 理由書作成者カナ;
    private final JigyoshaNo 理由書作成事業者番号;
    private final RString 支払方法区分コード;
    private final RString 支払場所;
    private final FlexibleDate 支払期間開始年月日;
    private final FlexibleDate 支払期間終了年月日;
    private final RString 支払窓口開始時間;
    private final RString 支払窓口終了時間;
    private final long 口座ID;
    private final RString 受領委任契約番号;
    private final ServiceShuruiCode サービス種類コード;
    private final RString 住宅所有者;
    private final RString 被保険者の関係;
    private final boolean 要介護状態３段階変更;
    private final boolean 住宅住所変更;
    private final FlexibleDate 判定決定年月日;
    private final RString 判定区分;
    private final RString 承認条件;
    private final RString 不承認理由;
    private final int 給付額等費用額合計;
    private final int 給付額等保険対象費用額;
    private final int 給付額等利用者自己負担額;
    private final int 給付額等保険給付費額;
    private final FlexibleDate 事前申請決定通知発行日;
 private final RString 住宅改修申請区分;
    private final RString 住宅改修申請取消事由コード;
     private final HokenKyufuRitsu 保険給付率;
     private final  List<JutakuKaishuJizenShinseiChildDivParameter> parameterList;
    public JutakuKaishuJizenShinseiDivParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 住宅改修申請区分, RString 住宅改修申請取消事由コード, ShoKisaiHokenshaNo 証記載保険者番号, FlexibleDate 受付年月日, FlexibleDate 申請年月日, RString 申請理由, RString 申請者区分, RString 申請者氏名, RString 申請者氏名カナ, YubinNo 申請者郵便番号, RString 申請者住所, TelNo 申請者電話番号, JigyoshaNo 申請事業者番号, FlexibleDate 理由書作成日, RString 理由書作成者, RString 理由書作成者カナ, JigyoshaNo 理由書作成事業者番号, RString 支払方法区分コード, RString 支払場所, FlexibleDate 支払期間開始年月日, FlexibleDate 支払期間終了年月日, RString 支払窓口開始時間, RString 支払窓口終了時間, long 口座ID, RString 受領委任契約番号, ServiceShuruiCode サービス種類コード, RString 住宅所有者, RString 被保険者の関係, boolean 要介護状態３段階変更, boolean 住宅住所変更, FlexibleDate 判定決定年月日, RString 判定区分, RString 承認条件, RString 不承認理由, int 給付額等費用額合計, int 給付額等保険対象費用額, int 給付額等利用者自己負担額, int 給付額等保険給付費額, FlexibleDate 事前申請決定通知発行日,HokenKyufuRitsu 保険給付率,List<JutakuKaishuJizenShinseiChildDivParameter> parameterList) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.住宅改修申請区分 = 住宅改修申請区分;
        this.住宅改修申請取消事由コード = 住宅改修申請取消事由コード;
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
        this.支払方法区分コード = 支払方法区分コード;
        this.支払場所 = 支払場所;
        this.支払期間開始年月日 = 支払期間開始年月日;
        this.支払期間終了年月日 = 支払期間終了年月日;
        this.支払窓口開始時間 = 支払窓口開始時間;
        this.支払窓口終了時間 = 支払窓口終了時間;
        this.口座ID = 口座ID;
        this.受領委任契約番号 = 受領委任契約番号;
        this.サービス種類コード = サービス種類コード;
        this.住宅所有者 = 住宅所有者;
        this.被保険者の関係 = 被保険者の関係;
        this.要介護状態３段階変更 = 要介護状態３段階変更;
        this.住宅住所変更 = 住宅住所変更;
        this.判定決定年月日 = 判定決定年月日;
        this.判定区分 = 判定区分;
        this.承認条件 = 承認条件;
        this.不承認理由 = 不承認理由;
        this.給付額等費用額合計 = 給付額等費用額合計;
        this.給付額等保険対象費用額 = 給付額等保険対象費用額;
        this.給付額等利用者自己負担額 = 給付額等利用者自己負担額;
        this.給付額等保険給付費額 = 給付額等保険給付費額;
        this.事前申請決定通知発行日 = 事前申請決定通知発行日;
        this.保険給付率=保険給付率;
        this.parameterList=parameterList;
    }

    

   
    public static JutakuKaishuJizenShinseiDivParameter createParameterForJutakuKaishuJizenShinsei(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 住宅改修申請区分, RString 住宅改修申請取消事由コード, ShoKisaiHokenshaNo 証記載保険者番号, FlexibleDate 受付年月日, FlexibleDate 申請年月日, RString 申請理由, RString 申請者区分, RString 申請者氏名, RString 申請者氏名カナ, YubinNo 申請者郵便番号, RString 申請者住所, TelNo 申請者電話番号, JigyoshaNo 申請事業者番号, FlexibleDate 理由書作成日, RString 理由書作成者, RString 理由書作成者カナ, JigyoshaNo 理由書作成事業者番号, RString 支払方法区分コード, RString 支払場所, FlexibleDate 支払期間開始年月日, FlexibleDate 支払期間終了年月日, RString 支払窓口開始時間, RString 支払窓口終了時間, long 口座ID, RString 受領委任契約番号, ServiceShuruiCode サービス種類コード, RString 住宅所有者, RString 被保険者の関係, boolean 要介護状態３段階変更, boolean 住宅住所変更, FlexibleDate 判定決定年月日, RString 判定区分, RString 承認条件, RString 不承認理由, int 給付額等費用額合計, int 給付額等保険対象費用額, int 給付額等利用者自己負担額, int 給付額等保険給付費額, FlexibleDate 事前申請決定通知発行日,HokenKyufuRitsu 保険給付率,List<JutakuKaishuJizenShinseiChildDivParameter> parameterList) {
        return new JutakuKaishuJizenShinseiDivParameter(被保険者番号, サービス提供年月,  整理番号,住宅改修申請区分, 住宅改修申請取消事由コード, 証記載保険者番号, 受付年月日, 申請年月日,申請理由, 申請者区分,申請者氏名, 申請者氏名カナ, 申請者郵便番号, 申請者住所,申請者電話番号, 申請事業者番号, 理由書作成日, 理由書作成者, 理由書作成者カナ,  理由書作成事業者番号, 支払方法区分コード,  支払場所, 支払期間開始年月日,支払期間終了年月日, 支払窓口開始時間, 支払窓口終了時間, 口座ID, 受領委任契約番号,サービス種類コード, 住宅所有者, 被保険者の関係,  要介護状態３段階変更, 住宅住所変更, 判定決定年月日, 判定区分, 承認条件, 不承認理由,給付額等費用額合計,給付額等保険対象費用額,  給付額等利用者自己負担額,  給付額等保険給付費額, 事前申請決定通知発行日,保険給付率,parameterList);
    }

}
