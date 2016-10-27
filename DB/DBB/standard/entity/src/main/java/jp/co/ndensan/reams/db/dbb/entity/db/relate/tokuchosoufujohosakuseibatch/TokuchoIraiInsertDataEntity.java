/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の介護保険年金特徴対象者情報追加用データのクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokuchoIraiInsertDataEntity {

    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理Newest;
}
