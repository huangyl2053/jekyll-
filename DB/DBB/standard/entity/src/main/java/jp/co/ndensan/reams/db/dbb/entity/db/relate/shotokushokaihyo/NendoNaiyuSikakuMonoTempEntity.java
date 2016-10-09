/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 年度内有資格者一時テーブル
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoNaiyuSikakuMonoTempEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(3)
    private RString edaNo;
    @TempTableColumnOrder(4)
    private RString idoJiyuCode;
    @TempTableColumnOrder(5)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(8)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate shikakuShutokuTodokedeYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate ichigoShikakuShutokuYMD;
    @TempTableColumnOrder(11)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(12)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(14)
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    @TempTableColumnOrder(15)
    private RString jushochitokureiTekiyoJiyuCode;
    @TempTableColumnOrder(16)
    private FlexibleDate jushochitokureiTekiyoYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    @TempTableColumnOrder(18)
    private RString jushochitokureiKaijoJiyuCode;
    @TempTableColumnOrder(19)
    private FlexibleDate jushochitokureiKaijoYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    @TempTableColumnOrder(21)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(22)
    private boolean koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(23)
    private RString koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(24)
    private FlexibleDate fukaKijunYMD;

//    private HihokenshaNo 被保険者番号;
//    private FlexibleDate 異動日;
//    private RString 枝番;
//    private RString 異動事由コード;
//    private LasdecCode 市町村コード;
//    private ShikibetsuCode 識別コード;
//    private RString 資格取得事由コード;
//    private FlexibleDate 資格取得年月日;
//    private FlexibleDate 資格取得届出年月日;
//    private FlexibleDate 第１号資格取得年月日;
//    private RString 被保険者区分コード;
//    private RString 資格喪失事由コード;
//    private FlexibleDate 資格喪失年月日;
//    private FlexibleDate 資格喪失届出年月日;
//    private RString 住所地特例適用事由コード;
//    private FlexibleDate 適用年月日;
//    private FlexibleDate 適用届出年月日;
//    private RString 住所地特例解除事由コード;
//    private FlexibleDate 解除年月日;
//    private FlexibleDate 解除届出年月日;
//    private boolean 住所地特例フラグ;
//    private boolean 広域内住所地特例フラグ;
//    private RString 広住特措置元市町村コード;
//    private FlexibleDate 賦課基準年月日;
}
