/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録（制御処理）のEntityクラスです。
 *
 * @reamsid_L DBA-1410-011 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuminIdoRendoShikakuTorokuEntity {

    private RString 不整合コード;
    private RString 転入保留作成事由コード;
    private RString 転出保留作成事由コード;
    private RString 処理区分;
    private RString 結果区分;
    private List<DbT1001HihokenshaDaichoEntity> 被保険者台帳EntityList;
    private List<DbT1002TekiyoJogaishaEntity> 適用除外者台帳EntityList;
    private List<DbT1003TashichosonJushochiTokureiEntity> 他市町村住所地特例EntityList;
    private List<DbT1004ShisetsuNyutaishoEntity> 介護保険施設入退所EntityList;
}
