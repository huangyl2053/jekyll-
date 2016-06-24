/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 旧市町村コード情報のクラスです。
 *
 * @reamsid_L DBU-0040-010 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuShichosonCodeJoho {

    private boolean 合併市町村有無フラグ;
    private List<KyuShichosonCode> 旧市町村コード情報List;
}
