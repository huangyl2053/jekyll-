/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 同定情報一時Entity
 *
 * @reamsid_L DBB-1850-050 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DoteiIchijiEntity {

    private RString shikibetsuCode;
    private RString dtTokubetsuChoshuGimushaCode;
    private RString dtKisoNenkinNo;
    private RString dtNenkinCode;
    private RString hosokuTsuki;
}
