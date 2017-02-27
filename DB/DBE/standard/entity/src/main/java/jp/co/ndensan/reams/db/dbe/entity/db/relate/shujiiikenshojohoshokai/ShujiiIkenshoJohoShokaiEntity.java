/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshojohoshokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書情報照会Entity
 * 
 * @author n3213
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShujiiIkenshoJohoShokaiEntity {
    
    private RString shujiiIryoKikanCode;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private RString shujiiName;
}
