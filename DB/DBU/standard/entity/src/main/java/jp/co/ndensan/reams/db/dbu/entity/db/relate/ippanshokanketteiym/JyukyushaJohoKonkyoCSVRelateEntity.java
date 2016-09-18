/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 根拠CSV作成のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JyukyushaJohoKonkyoCSVRelateEntity {

    private RString dataTypeKubun;
    private RString shukeiKubun;
    private RString hyouNo;
    private RString shukeiNo;
    private RString shukeiTani;
    private Decimal tateNo;
    private Decimal yokoNo;
    private RString inputShikibetsuNo;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString kyufuJissekiKubunCode;
    private JigyoshaNo jigyoshoNo;
    private RString seiriNo;
    private FlexibleDate umareYMD;
    private Code yoKaigoJotaiKubunCode;
    private RString serviceShuruiCode;
    private Code serviceBunrruicode;
    private RString shikakuKubun;
    private LasdecCode shichosonCode;
    private LasdecCode kyuShichosonCode;
}
