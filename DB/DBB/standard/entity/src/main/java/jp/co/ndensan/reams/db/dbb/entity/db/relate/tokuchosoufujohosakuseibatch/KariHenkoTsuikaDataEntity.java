/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の（仮徴収額変更）追加用データ作成のクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KariHenkoTsuikaDataEntity {

    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報;
    private DbT1001HihokenshaDaichoEntity 資格情報;
    private DbT2002FukaJohoTempTableEntity 賦課情報;
    private DbT2001ChoshuHohoEntity 徴収方法情報;
}
