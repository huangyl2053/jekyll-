/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiEntity {

    private HihokenshaNo 負担限度額_被保険者番号;
    private FlexibleDate 負担限度額_申請年月日;
    private RString 負担限度額_申請理由区分;
    private FlexibleDate 負担限度額_決定年月日;
    private FlexibleDate 負担限度額_適用開始年月日;
    private FlexibleDate 負担限度額_適用終了年月日;
    private RString 負担限度額_利用者負担段階;
    private RString 負担限度額_旧措置者区分;
    private RString 負担限度額_居室種別;
    private Decimal 負担限度額_食費負担限度額;
    private Decimal 負担限度額_ユニット型個室;
    private Decimal 負担限度額_ユニット型準個室;
    private Decimal 負担限度額_従来型個室特養等;
    private Decimal 負担限度額_従来型個室老健療養等;
    private Decimal 負担限度額_多床室;
    private boolean 負担限度額_境界層該当者区分;
    private boolean 負担限度額_激変緩和措置対象者区分;
}
