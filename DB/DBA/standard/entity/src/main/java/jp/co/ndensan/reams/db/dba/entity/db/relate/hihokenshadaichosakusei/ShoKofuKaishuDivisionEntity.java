/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 分割した証交付回収のエンティティクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoKofuKaishuDivisionEntity {

    private List<RString> 証履歴No;
    private List<RString> 証履歴発行日;
    private List<RString> 証履歴事由名称;
    private List<RString> 証履歴回収日;
}
