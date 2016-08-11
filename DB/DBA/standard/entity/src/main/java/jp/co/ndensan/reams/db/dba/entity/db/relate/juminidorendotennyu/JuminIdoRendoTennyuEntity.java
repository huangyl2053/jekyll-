/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録_転入Entityクラスです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuminIdoRendoTennyuEntity {

    private List<DbT1001HihokenshaDaichoEntity> 被保険者台帳list;
    private RString 作成事由;
    private RString データ不整合理由;
}
