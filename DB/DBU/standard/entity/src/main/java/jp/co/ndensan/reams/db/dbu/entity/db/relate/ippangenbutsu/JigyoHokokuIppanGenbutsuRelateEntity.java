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

/**
 * 事業状況報告統計情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoHokokuIppanGenbutsuRelateEntity {

    private int rowNumber;
    private HihokenshaNo hihokenshaNo;
    private RString yoKaigoJotaiKubunCode;
    private RString serviceSyuruiCode;
    private RString inputShikibetsuNo;
    private RString serviceTeikyoYM;
    private RString teikyoKaishiYM;
    private RString teikyoShuryoYM;
    private RString kyufuJissekiKubunCode;
    private JigyoshaNo jigyoshoNo;
    private RString seiriNo;
    private FlexibleDate birthDate;
    private Code serviceBunruiCode;
    private LasdecCode shichosonCode;
    private LasdecCode kyuShichosonCode;
    private RString hihokenshaKubunCode;
    private RString errorCode;
    private boolean errorFlag;
}
