/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * バッチ出力帳票一覧Entityクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoSoufuJohoSakuseiEntity {

    private UeT0511NenkinTokuchoKaifuJohoEntity uet0511entity;
    private DbT2001ChoshuHohoEntity dbt2001entity;
    private DbT1001HihokenshaDaichoEntity dbt1001entity;
    private DbT2002FukaEntity dbt2002entity;
    private List<DbT2003FukaJohoEntity> dbt2003entities;
}
