/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の追加用データ作成のクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShikakuSoshitsuDataEntity {

    private int 期;
    private Decimal 調定額;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者情報;
    private DbT1001HihokenshaDaichoEntity 資格情報;
    private DbT2002FukaEntity 賦課情報;
    private DbT2001ChoshuHohoEntity 徴収方法情報;
}
