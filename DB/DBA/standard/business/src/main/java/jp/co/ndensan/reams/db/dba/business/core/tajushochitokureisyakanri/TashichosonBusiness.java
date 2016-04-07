/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;

/**
 * 他住所地特例者管理のbusinessクラスです。
 *
 * @reamsid_L DBA-0200-020 linghuhang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonBusiness {

    private List<TashichosonJushochiTokurei> 住所地特例List;
    private List<ShisetsuNyutaisho> 施設入退所Lsit;
}
