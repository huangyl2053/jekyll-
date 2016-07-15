/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得照会票データTemp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiDataTempEntity implements IDbAccessable, Serializable {

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private LasdecCode genLasdecCode;
    @TempTableColumnOrder(3)
    private ZenkokuJushoCode shokaisakiLasdecCode;
    @TempTableColumnOrder(4)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(5)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(6)
    private AtenaMeisho hihokenshaName;
    @TempTableColumnOrder(7)
    private AtenaJusho hihokenshajusho;
    @TempTableColumnOrder(8)
    private RString zenjusho;
    @TempTableColumnOrder(9)
    private RString genjusho;
    @TempTableColumnOrder(10)
    private AtenaKanaMeisho atenaKanaShimei;
    @TempTableColumnOrder(11)
    private AtenaMeisho atenaShimei;
    @TempTableColumnOrder(12)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(14)
    private RString kouhoshakubun;
    @TempTableColumnOrder(15)
    private RString honninKubun;
    @TempTableColumnOrder(16)
    private RString choikiCode;
    @TempTableColumnOrder(17)
    private RString gyoseikuCode;
    @TempTableColumnOrder(18)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(19)
    private RString zenjushoCode;
    @TempTableColumnOrder(20)
    private YubinNo yubinNo;
    @TempTableColumnOrder(21)
    private RString chikuCode1;
    @TempTableColumnOrder(22)
    private RString chikuCode2;
    @TempTableColumnOrder(23)
    private RString chikuCode3;
    @TempTableColumnOrder(24)
    private RString juminJotaiCode;
    @TempTableColumnOrder(25)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(26)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(27)
    private RString seibetsuCode;
    @TempTableColumnOrder(28)
    private RString juminShubetsuCode;
}
//    private ShikibetsuCode 識別コード;
//    private LasdecCode 現全国地方公共団体コード;
//    private ZenkokuJushoCode 送付先全国住所コード;
//    private SetaiCode 世帯コード;
//    private HihokenshaNo 被保険者番号;
//    private AtenaMeisho 被保険者氏名;
//    private AtenaJusho 被保険者住所;
//    private RString 前住所;
//    private RString 現住所;
//    private AtenaKanaMeisho カナ氏名;
//    private AtenaMeisho 名称;
//    private FlexibleDate 生年月日;
//    private FlexibleDate 異動年月日;
//    private RString 候補者区分;
//    private RString 本人区分;
//    private RString 町域コード;
//    private RString 行政区コード;
//    private LasdecCode 市町村コード;
//    private RString 前住所コード;
//    private YubinNo 郵便番号;
//    private RString 地区コード１;
//    private RString 地区コード２;
//    private RString 地区コード３;
//    private RString 住民状態コード;
//    private RString 管内管外区分;
//    private RString 被保険者区分コード;
//    private RString 性別コード;
//    private RString 住民種別コード;

