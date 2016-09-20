/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * おむつ使用証明書Entityクラスです。
 *
 * @reamsid_L DBD-5770-030 tz_chengpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class OmutsusiyoSyomeishoEntity implements Serializable {

    private RString 住所;
    private RString 住所１;
    private RString 住所２;
    private RString 氏名;
    private RString 氏名１;
    private RString 氏名２;
    private RString 生年月日;
    private RString 性別男;
    private RString 性別女;
}
