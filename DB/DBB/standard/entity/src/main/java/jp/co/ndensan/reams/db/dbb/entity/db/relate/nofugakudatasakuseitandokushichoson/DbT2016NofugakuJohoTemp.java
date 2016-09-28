/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 納付額情報一時TBL Entity
 *
 * @reamsid_L DBB-1890-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT2016NofugakuJohoTemp extends
        DbTableEntityBase<DbT2016NofugakuJohoTemp> implements IDbAccessable {

    private static final long serialVersionUID = 1L;

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private LasdecCode 賦課市町村コード;
    private Decimal 特徴歳出還付額;
    private Decimal 普徴歳出還付額;
    private Decimal 特徴調定額01;
    private Decimal 特徴調定額02;
    private Decimal 特徴調定額03;
    private Decimal 特徴調定額04;
    private Decimal 特徴調定額05;
    private Decimal 特徴調定額06;
    private Decimal 普徴調定額01;
    private Decimal 普徴調定額02;
    private Decimal 普徴調定額03;
    private Decimal 普徴調定額04;
    private Decimal 普徴調定額05;
    private Decimal 普徴調定額06;
    private Decimal 普徴調定額07;
    private Decimal 普徴調定額08;
    private Decimal 普徴調定額09;
    private Decimal 普徴調定額10;
    private Decimal 普徴調定額11;
    private Decimal 普徴調定額12;
    private Decimal 普徴調定額13;
    private Decimal 普徴調定額14;
    private Decimal 特徴収入額01;
    private Decimal 特徴収入額02;
    private Decimal 特徴収入額03;
    private Decimal 特徴収入額04;
    private Decimal 特徴収入額05;
    private Decimal 特徴収入額06;
    private Decimal 普徴収入額01;
    private Decimal 普徴収入額02;
    private Decimal 普徴収入額03;
    private Decimal 普徴収入額04;
    private Decimal 普徴収入額05;
    private Decimal 普徴収入額06;
    private Decimal 普徴収入額07;
    private Decimal 普徴収入額08;
    private Decimal 普徴収入額09;
    private Decimal 普徴収入額10;
    private Decimal 普徴収入額11;
    private Decimal 普徴収入額12;
    private Decimal 普徴収入額13;
    private Decimal 普徴収入額14;
    private FlexibleDate 特徴領収日01;
    private FlexibleDate 特徴領収日02;
    private FlexibleDate 特徴領収日03;
    private FlexibleDate 特徴領収日04;
    private FlexibleDate 特徴領収日05;
    private FlexibleDate 特徴領収日06;
    private FlexibleDate 普徴領収日01;
    private FlexibleDate 普徴領収日02;
    private FlexibleDate 普徴領収日03;
    private FlexibleDate 普徴領収日04;
    private FlexibleDate 普徴領収日05;
    private FlexibleDate 普徴領収日06;
    private FlexibleDate 普徴領収日07;
    private FlexibleDate 普徴領収日08;
    private FlexibleDate 普徴領収日09;
    private FlexibleDate 普徴領収日10;
    private FlexibleDate 普徴領収日11;
    private FlexibleDate 普徴領収日12;
    private FlexibleDate 普徴領収日13;
    private FlexibleDate 普徴領収日14;
    private FlexibleDate 特徴収入日01;
    private FlexibleDate 特徴収入日02;
    private FlexibleDate 特徴収入日03;
    private FlexibleDate 特徴収入日04;
    private FlexibleDate 特徴収入日05;
    private FlexibleDate 特徴収入日06;
    private FlexibleDate 普徴収入日01;
    private FlexibleDate 普徴収入日02;
    private FlexibleDate 普徴収入日03;
    private FlexibleDate 普徴収入日04;
    private FlexibleDate 普徴収入日05;
    private FlexibleDate 普徴収入日06;
    private FlexibleDate 普徴収入日07;
    private FlexibleDate 普徴収入日08;
    private FlexibleDate 普徴収入日09;
    private FlexibleDate 普徴収入日10;
    private FlexibleDate 普徴収入日11;
    private FlexibleDate 普徴収入日12;
    private FlexibleDate 普徴収入日13;
    private FlexibleDate 普徴収入日14;
}
