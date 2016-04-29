/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査地区DDL戻るのEntity。
 *
 * @reamsid_L DBE-0020-050 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChikuShichosonRelateEntity {

    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
}
