/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 事業状況報告統計情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
@OnNextSchema("rgdb")
public class JigyoHokokuIppanGenbutsuRelateEntity extends DbTableEntityBase<JigyoHokokuIppanGenbutsuRelateEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int rowNumber;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(4)
    private RString serviceSyuruiCode;
    @TempTableColumnOrder(5)
    private RString inputShikibetsuNo;
    @TempTableColumnOrder(6)
    private RString serviceTeikyoYM;
    @TempTableColumnOrder(7)
    private RString teikyoKaishiYM;
    @TempTableColumnOrder(8)
    private RString teikyoShuryoYM;
    @TempTableColumnOrder(9)
    private RString kyufuJissekiKubunCode;
    @TempTableColumnOrder(10)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(11)
    private RString seiriNo;
    @TempTableColumnOrder(12)
    private FlexibleDate birthDate;
    @TempTableColumnOrder(13)
    private Code serviceBunruiCode;
    @TempTableColumnOrder(14)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(15)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(16)
    private RString hihokenshaKubunCode;
    @TempTableColumnOrder(17)
    private RString errorCode;
    @TempTableColumnOrder(18)
    private boolean errorFlag;
}
