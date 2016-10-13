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
public class ShiharaiHohoHenkoGengakuEntity {

    private RString 給付額減額情報_証記載保険者番号;
    private HihokenshaNo 給付額減額情報_被保険者番号;
    private RString 給付額減額情報_管理区分;
    private int 給付額減額情報_履歴番号;
    private RString 給付額減額情報_登録区分;
    private FlexibleDate 給付額減額情報_適用開始年月日;
    private FlexibleDate 給付額減額情報_適用終了年月日;
    private HokenKyufuRitsu 給付額減額情報_給付率;
    private Decimal 給付額減額情報_徴収権消滅期間;
    private Decimal 給付額減額情報_納付済期間;
    private Decimal 給付額減額情報_納付済減額期間;
}
