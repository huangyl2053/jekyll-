package jp.co.ndensan.reams.db.dba.persistence.mapper.basic.shichosonsentaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 市町村遷移のマッパーインタフェースです。
 */
public interface IShichosonSentakuMapper {

    /**
     * {@link DbT7051KoseiShichosonMasterEntity}を取得します。
     *
     * @param 基準日 基準日
     * @return {@link DbT7051KoseiShichosonMasterEntity}
     */
    List<DbT7051KoseiShichosonMasterEntity> getEntity(FlexibleDate 基準日);

}
