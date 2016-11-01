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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 納付額情報Entity項目定義クラスです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@SuppressWarnings ("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NofugakuJohoResultEntity {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private LasdecCode 賦課市町村コード;
    private Decimal 特徴歳出還付額;
    private Decimal 普徴歳出還付額;
    private int 期;
    private RString 徴収方法;
    private Decimal 調定額;
    private Decimal 収入額;
    private FlexibleDate 領収日;
    private FlexibleDate 収入日;

}
