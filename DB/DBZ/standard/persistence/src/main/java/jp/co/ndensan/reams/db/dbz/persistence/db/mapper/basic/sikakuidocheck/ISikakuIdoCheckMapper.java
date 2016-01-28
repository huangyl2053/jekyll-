/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.sikakuidocheck;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 資格異動チェックの処理します。
 *
 */
public interface ISikakuIdoCheckMapper {

    /**
     * 被保険者台帳管理の取得します。
     *
     * @param 識別コード 識別コード
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> getDbT1001HihokenshaDaicho(ShikibetsuCode 識別コード);

    /**
     * 被保険者台帳管理の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity getDbT1001Hihokensha(HihokenshaNo 被保険者番号);

    /**
     * 適用除外者の取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT1002TekiyoJogaishaEntity
     */
    DbT1002TekiyoJogaishaEntity getDbT1002TekiyoJogaisha(ShikibetsuCode 識別コード);

    /**
     * 他市町村住所地特例の取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT1003TashichosonJushochiTokureiEntity
     */
    DbT1003TashichosonJushochiTokureiEntity getDbT1003TashichosonJushochiTokurei(ShikibetsuCode 識別コード);
}
