/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼(手動)一覧_介護保険指定医依頼兼主治医意見書提出意見書のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoTeishutsuIraishoEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private RString hihokenshaNo;
    private RString age;
    private AtenaJusho jusho;
    private AtenaJusho iryoKikanJusho;
    private FlexibleDate seinengappiYMD;
    private Code seibetsu;
    private YubinNo yubinNo;
    private FlexibleDate ninteiShinseiYMD;
    private TelNo telNo;
    private TelNo iryoKikanTelNo;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private TelNo iryoKikanFaxNo;
    private YubinNo iryoKikanYubinNo;
    private RString iryoKikanMeisho;
    private RString daihyoshaName;
    private RString ikenshoIraiKubun;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private RString zaitakuShisetsuKubun;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ikenshoSakuseiKaisuKubun;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate ikenshoReadYMD;
    private RString shujiiName;
    private RString hokenshaName;
    private int ikenshoBettoShinryohi;
    private FlexibleDate hoshuShiharaiYMD;
}
