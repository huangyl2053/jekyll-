/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 介護事業者施設オブジェクトの項目定義クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceJigyoshaInputGuideRelateEntity implements IDbAccessable {

    private KaigoJigyoshaNo jigyoshaNo;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaMeisho jigyoshaMeisho;
    private AtenaKanaMeisho jigyoshaNameKana;
    private RString jigyoshaKanaAddress;
    private TelNo telNo;
    private RString serviceShuruiCode;
    private RString serviceShuruiRyakusho;
    private boolean isDeleted;
    private AtenaKanaMeisho jigyoshaKanaMeisho;
    private RString jigyoshaKanaJusho;
    private RString kannaiKangaiKubun;
    private RString jigyoshaShubetsu;
    private RString jigyoshaJusho;
    private FlexibleDate yukoKaishiYMDFrom;
    private FlexibleDate yukoKaishiYMDTo;
}
