/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医情報のEntityです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiJohoRelateEntity {

    private RString shichosonCode;
    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString shujiiName;
    private RString shujiiKana;
    private RString shujiiCode;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString shinryokaName;
    private boolean shiteiiFlag;
    private boolean jokyoFlag;
}
