/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 前回結果情報RelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ZenkaiNinteiKekkaJohoRelateEntity {
    
    private RString koroshoIfShikibetsuCode;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString nijiHanteiYMD;
    private RString nijiHanteiNinteiYukoKaishiYMD;
    private RString nijiHanteiNinteiYukoShuryoYMD;
}
