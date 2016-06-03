package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajohotoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;

/**
 * 賦課の情報登録のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
public interface IFukaJohoTorokuMapper {

    /**
     * 賦課情報一時テーブルで全件を取得します。
     *
     * @return List<DbTFukaJohoTorokuTempTableEntity>
     */
    List<DbT2002FukaJohoTempTableEntity> selectAll();

//    /**
//     * 賦課情報一時テーブルで全件を取得します。
//     *
//     * @return List<DbTFukaJohoTorokuTempTableEntity>
//     */
//    List<DbT2002FukaJohoTempTableEntity> selectFukaJohoForToroku();
}
