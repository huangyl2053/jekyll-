/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得照会候補者Temp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiKouhoshaTempEntity implements IDbAccessable, Serializable {

    @TempTableColumnOrder(1)
    private RString kouhoshakubun;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(4)
    private AtenaMeisho atenaShimei;
    @TempTableColumnOrder(5)
    private AtenaKanaMeisho atenaKanaShimei;
    @TempTableColumnOrder(6)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(7)
    private YubinNo yubinNo;
    @TempTableColumnOrder(8)
    private RString choikiCode;
    @TempTableColumnOrder(9)
    private RString zenkokuJushoCode;
    @TempTableColumnOrder(10)
    private RString jusho;
    @TempTableColumnOrder(11)
    private RString banchi;
    @TempTableColumnOrder(12)
    private RString katagaki;
    @TempTableColumnOrder(13)
    private RString gyoseikuCode;
    @TempTableColumnOrder(14)
    private RString chikuCode1;
    @TempTableColumnOrder(15)
    private RString chikuCode2;
    @TempTableColumnOrder(16)
    private RString chikuCode3;
    @TempTableColumnOrder(17)
    private RString juminJotaiCode;
    @TempTableColumnOrder(18)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(19)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate torokuIdoYMD;
    @TempTableColumnOrder(21)
    private RString tenyuzenzenkokuJushoCode;
    @TempTableColumnOrder(22)
    private RString tenyuzenjusho;
    @TempTableColumnOrder(23)
    private RString tenyuzenbanchi;
    @TempTableColumnOrder(24)
    private RString tenyuzenkatagaki;

//    @TempTableColumnOrder(1)
//    private RString 候補者区分;
//    @TempTableColumnOrder(2)
//    private ShikibetsuCode 識別コード;
//    @TempTableColumnOrder(3)
//    private RString 住民種別コード;
//    @TempTableColumnOrder(4)
//    private AtenaMeisho 名称;
//    @TempTableColumnOrder(5)
//    private AtenaKanaMeisho カナ名称;
//    @TempTableColumnOrder(6)
//    private RString 管内管外区分;
//    @TempTableColumnOrder(7)
//    private YubinNo 郵便番号;
//    @TempTableColumnOrder(8)
//    private RString 町域コード;
//    @TempTableColumnOrder(9)
//    private RString 全国住所コード;
//    @TempTableColumnOrder(10)
//    private RString 住所;
//    @TempTableColumnOrder(11)
//    private RString 番地;
//    @TempTableColumnOrder(12)
//    private RString 方書;
//    @TempTableColumnOrder(13)
//    private RString 行政区コード;
//    @TempTableColumnOrder(14)
//    private RString 地区コード１;
//    @TempTableColumnOrder(15)
//    private RString 地区コード２;
//    @TempTableColumnOrder(16)
//    private RString 地区コード３;
//    @TempTableColumnOrder(17)
//    private RString 住民状態コード;
//    @TempTableColumnOrder(18)
//    private SetaiCode 世帯コード;
//    @TempTableColumnOrder(19)
//    private FlexibleDate 生年月日;
//    @TempTableColumnOrder(20)
//    private FlexibleDate 登録異動年月日;
//    @TempTableColumnOrder(21)
//    private RString 転入前全国住所コード;
//    @TempTableColumnOrder(22)
//    private RString 転入前住所;
//    @TempTableColumnOrder(23)
//    private RString 転入前番地;
//    @TempTableColumnOrder(24)
//    private RString 転入前方書;
}
