/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shichosontokubetukyufuservice;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 決市町村特別給付サービス内容のEntityクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonTokubetuKyufuServiceEntity {

    private RString サービスコード;
    private FlexibleDate 有効期間開始年月日;
    private FlexibleDate 有効期間終了年月日;
    private int 履歴番号;
    private RString 正式名称;
    private RString 略称;
    private RString サービス区分;
    private Decimal 単位;
    private Decimal 支給限度基準額;
    private RString 直近フラグ;
}
