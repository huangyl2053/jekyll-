/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入所施設のエンティティクラスです。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuNyutaishoEntity {

    private RString jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString nyushoShisetsuShurui;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuHaishiYMD;
    private RString jukyushaNo;
    private RString kaigoRyoDairiNofuKubun;
    private FlexibleYearMonth kaigoRyoDairiNofuYM;
    private RString kyugoShisetsuNyuTaishoKubun;
    private FlexibleDate kyugoShisetsuNyutaishoYMD;
    private RString fujoShuruiCode;
    private FlexibleDate jukyuTeishiKaishiYMD;
    private FlexibleDate jukyuTeishiShuryoYMD;
    private AtenaMeisho jigyoshaName;
    private RString shichosonMeisho;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private RString iryoHokenShubetsuCode;
}
