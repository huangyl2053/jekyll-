/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

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
 * 被保険者情報検索RelateEntityクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaJyuhouRelateEntity {

    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private RString hihokenshaKubunCode;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private YubinNo yubinNo;
    private TelNo telNo;
    private AtenaJusho jusho;
    private RString shichosonMeisho;
}
