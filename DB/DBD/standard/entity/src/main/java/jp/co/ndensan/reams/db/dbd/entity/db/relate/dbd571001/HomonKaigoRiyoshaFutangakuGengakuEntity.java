/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class HomonKaigoRiyoshaFutangakuGengakuEntity {

    private RString 訪問介護等減額_証記載保険者番号;
    private HihokenshaNo 訪問介護等減額_被保険者番号;
    private int 訪問介護等減額_履歴番号;
    private FlexibleDate 訪問介護等減額_申請年月日;
    private FlexibleDate 訪問介護等減額_決定年月日;
    private FlexibleDate 訪問介護等減額_適用開始年月日;
    private FlexibleDate 訪問介護等減額_適用終了年月日;
    private HokenKyufuRitsu 訪問介護等減額_給付率;
    private RString 訪問介護等減額_法別区分;
    private RString 訪問介護等減額_公費受給者番号;
}
