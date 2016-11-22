/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 過年度異動賦課確定情報のクラスです。
 *
 * @reamsid_L DBB-0680-020 wangkanglei
 */
@lombok.Getter
@lombok.Setter
public class KanendoIdoFukaKakuteiEntity implements IDbAccessable {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private int 履歴番号;
    private ShikibetsuCode 識別コード;
    private RString 保険料算定段階１;
    private Decimal 算定年額保険料１;
    private RString 保険料算定段階２;
    private Decimal 算定年額保険料２;
    private Decimal 減免額;
    private Decimal 確定介護保険料;
    private RString 更正月;
    private Decimal 調定額;
    private RDate 納期限;
    private FlexibleYear 更正前調定年度;
    private FlexibleYear 更正前賦課年度;
    private RString 更正前保険料算定段階１;
    private Decimal 更正前算定年額保険料１;
    private RString 更正前保険料算定段階２;
    private Decimal 更正前算定年額保険料２;
    private Decimal 更正前減免額;
    private Decimal 更正前確定介護保険料;
    private int 更正前履歴番号;
    private HihokenshaNo 被保険者番号;
    private TsuchishoNo 更正前通知書番号;
    private HihokenshaNo 更正前被保険者番号;
    private RString 更正前更正月;
    private YMDHMS 調定日時;
    private YMDHMS 更正前調定日時;
    private FlexibleDate 賦課期日;
    private FlexibleDate 更正前賦課期日;
}
