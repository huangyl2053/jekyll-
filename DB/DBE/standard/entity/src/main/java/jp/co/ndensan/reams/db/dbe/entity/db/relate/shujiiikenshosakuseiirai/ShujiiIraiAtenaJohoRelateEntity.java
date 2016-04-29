/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛先情報RelateEntityクラスです
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIraiAtenaJohoRelateEntity {

    private RString atenaKikanMeisho;
    private YubinNo atenaYubinNo;
    private AtenaJusho atenaJusho;
    private AtenaMeisho atenaShimei;
}
