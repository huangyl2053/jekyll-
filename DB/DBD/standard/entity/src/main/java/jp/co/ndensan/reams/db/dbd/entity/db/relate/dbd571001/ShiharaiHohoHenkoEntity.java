/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
public class ShiharaiHohoHenkoEntity {

    private ShoKisaiHokenshaNo 支払方法変更_証記載保険者番号;
    private HihokenshaNo 支払方法変更_被保険者番号;
    private RString 支払方法変更_管理区分;
    private RString 支払方法変更_登録区分;
    private FlexibleDate 支払方法変更_適用開始年月日;
    private FlexibleDate 支払方法変更_適用終了年月日;
    private RString 支払方法変更_終了区分;
    private FlexibleYearMonth 支払方法変更_差止サービス提供年月;
    private RString 支払方法変更_差止償還整理番号;
    private FlexibleDate 支払方法変更_差止解除年月日;
}
