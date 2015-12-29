/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 適用除外者RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaishaRelateEntity {

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private RString tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private RString tekiyoJogaikaijokaijoJiyuCode;
    private Decimal rirekiNo;
    private RString daichoShubetsu;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private JigyoshaNo nyushoShisetsuCode;
    private AtenaMeisho jigyoshaMeisho;
}
