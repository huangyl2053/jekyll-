/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 介護事業者施設オブジェクトの項目定義クラスです。
 *
 * @reamsid_L DBA-0140-030 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceJigyoshaInputGuideRelateEntity implements IDbAccessable, Serializable {

    private KaigoJigyoshaNo jigyoshaNo;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaMeisho jigyoshaMeisho;
    private AtenaKanaMeisho jigyoshaNameKana;
    private RString jigyoshaKanaAddress;
    private AtenaJusho jigyoshaAddress;
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
    private YubinNo yubinNo;
}
