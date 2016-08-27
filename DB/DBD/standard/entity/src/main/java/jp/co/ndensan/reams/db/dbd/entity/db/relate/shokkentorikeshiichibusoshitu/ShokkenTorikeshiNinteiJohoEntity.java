/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面の前回情報Entityクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokkenTorikeshiNinteiJohoEntity implements Serializable {

    private Code koroshoIfShikibetsuCode;
    private RString shienShinseiKubun;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code hihokenshaKubunCode;
    private Code nigoTokuteiShippeiCode;
    private RString shishoCode;
    private RString ninteiShinseiRiyu;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private boolean shiteiiFlag;
    private RString shujiiCode;
    private RString shujiiName;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private RString jigyoshaMeisho;
    private ChosainCode ninteiChosainCode;
    private RString chosainShimei;
    private Code jukyuShinseiJiyu;
    private RString shinseiJokyoKubun;
    private boolean kyuSochishaFlag;
    private boolean shikakuShutokuMaeShinseiFlag;
    private FlexibleDate soshitsuYMD;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private ServiceShuruiCode shiteiServiceShurui01;
    private ServiceShuruiCode shiteiServiceShurui02;
    private ServiceShuruiCode shiteiServiceShurui03;
    private ServiceShuruiCode shiteiServiceShurui04;
    private ServiceShuruiCode shiteiServiceShurui05;
    private ServiceShuruiCode shiteiServiceShurui06;
    private ServiceShuruiCode shiteiServiceShurui07;
    private ServiceShuruiCode shiteiServiceShurui08;
    private ServiceShuruiCode shiteiServiceShurui09;
    private ServiceShuruiCode shiteiServiceShurui10;
    private ServiceShuruiCode shiteiServiceShurui11;
    private ServiceShuruiCode shiteiServiceShurui12;
    private ServiceShuruiCode shiteiServiceShurui13;
    private ServiceShuruiCode shiteiServiceShurui14;
    private ServiceShuruiCode shiteiServiceShurui15;
    private ServiceShuruiCode shiteiServiceShurui16;
    private ServiceShuruiCode shiteiServiceShurui17;
    private ServiceShuruiCode shiteiServiceShurui18;
    private ServiceShuruiCode shiteiServiceShurui19;
    private ServiceShuruiCode shiteiServiceShurui20;
    private ServiceShuruiCode shiteiServiceShurui21;
    private ServiceShuruiCode shiteiServiceShurui22;
    private ServiceShuruiCode shiteiServiceShurui23;
    private ServiceShuruiCode shiteiServiceShurui24;
    private ServiceShuruiCode shiteiServiceShurui25;
    private ServiceShuruiCode shiteiServiceShurui26;
    private ServiceShuruiCode shiteiServiceShurui27;
    private ServiceShuruiCode shiteiServiceShurui28;
    private ServiceShuruiCode shiteiServiceShurui29;
    private ServiceShuruiCode shiteiServiceShurui30;
    private RString shinsakaiIken;
    private LasdecCode shichosonCode;
}
