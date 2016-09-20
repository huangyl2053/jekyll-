/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.fukajoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.fukajoho.FukaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 賦課根拠照会のマッパーインタフェースです。
 *
 * @reamsid_L DBB-5723-020 xuxin
 */
public interface IFukaJohoMapper {

    /**
     * 全ての賦課の情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoEntity> get賦課情報(ShikibetsuCode 識別コード);

}
