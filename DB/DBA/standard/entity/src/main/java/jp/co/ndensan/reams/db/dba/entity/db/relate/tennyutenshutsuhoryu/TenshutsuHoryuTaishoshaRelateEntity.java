/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;

/**
 * 転出保留対象者管理クラスです。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TenshutsuHoryuTaishoshaRelateEntity {

    private DbT1001HihokenshaDaichoEntity hihokenshaDaicho;
    private DbT1011TenshutsuHoryuTaishoshaEntity tenshutsuHoryuTaishosha;
}
