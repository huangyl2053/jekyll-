/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護対象者抽出（遡及分）
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaNoFukaEntity {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private RString 世帯コード;
    private FlexibleYear 賦課年度;
    private FlexibleYearMonth 年月;
    private FlexibleDate 年月日;
    private RString 抽出_マスタ;
    private RString 抽出_事由;
    private RString 抽出_識別コード;
    private RString 抽出_マスタ1;
    private RString 抽出_マスタ2;
    private RString 抽出_マスタ3;
    private RString 抽出_マスタ4;
    private RString 抽出_マスタ5;
    private RString 抽出_マスタ6;
    private RString 抽出_マスタ7;
    private RString 抽出_マスタ8;
    private RString 抽出_マスタ9;
    private RString 抽出_マスタ10;
    private RString 抽出_事由1;
    private RString 抽出_事由2;
    private RString 抽出_事由3;
    private RString 抽出_事由4;
    private RString 抽出_事由5;
    private RString 抽出_事由6;
    private RString 抽出_事由7;
    private RString 抽出_事由8;
    private RString 抽出_事由9;
    private RString 抽出_事由10;
    private RString 抽出_識別コード1;
    private RString 抽出_識別コード2;
    private RString 抽出_識別コード3;
    private RString 抽出_識別コード4;
    private RString 抽出_識別コード5;
    private RString 抽出_識別コード6;
    private RString 抽出_識別コード7;
    private RString 抽出_識別コード8;
    private RString 抽出_識別コード9;
    private RString 抽出_識別コード10;
    private HihokenshaNo 被保険者台帳_被保険者番号;
}
