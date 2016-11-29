package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fukajohotoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajohotoroku.FukaJohoTorokuMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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

    /**
     * 仮算定／本算定の判定用の本算定処理日付を取得します。
     *
     * @param syoriName 処理名
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> getSyoriDate(RString syoriName);

    /**
     * 仮算定／本算定の判定用の本算定処理日付を取得します。
     *
     * @param parameter FukaJohoTorokuMybatisParameter
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> getSyoriDateForManager(FukaJohoTorokuMybatisParameter parameter);

    /**
     * 収納管理マスタの存在をチェックします。
     *
     * @param parameter FukaJohoTorokuMybatisParameter
     * @return UrT0705ChoteiKyotsuEntity
     */
    UrT0705ChoteiKyotsuEntity getChoteiKyotsuByFukaJoho(FukaJohoTorokuMybatisParameter parameter);
}
