/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;

/**
 * 適用除外者管理のbusinessクラスです。
 *
 * @reamsid_L DBA-0210-020 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaishaBusiness {

    private List<TekiyoJogaisha> 適用除外者List;
    private List<ShisetsuNyutaisho> 施設入退所Lsit;
}
