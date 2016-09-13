/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200031;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表のEntityクラスです
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakuHoseiIchiranEntity {

    private HokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 申請書整理番号;
    private FlexibleYear 申請対象年度;
    private FlexibleDate 介護加入期間開始;
    private FlexibleDate 介護加入期間終了;
    private Decimal 補正前_自己負担額;
    private Decimal 補正前_70_74自己負担額;
    private Decimal 補正前_高額支給額;
    private Decimal 補正後_自己負担額;
    private Decimal 補正後_70_74自己負担額;
    private Decimal 補正後_高額支給額;
    private RString 負担額補正有無;
    private RString 支給額補正有無;
    private RString 警告;
    private RString 警告2;
    private RString 宛名ﾃﾞｰﾀ種別;

}
