/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用概況特記Entityクラスです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyotokkiTextA3Entity implements Serializable {

    private RString 概況特記Text;
    private RString 概況特記Img;
}
