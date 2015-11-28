package jp.co.ndensan.reams.db.dba.persistence.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 市町村遷移のShichosonSentakuMapper作成
 */
public interface ShichosonSentakuMapper {

    List<DbT7051KoseiShichosonMasterEntity> getEntity(FlexibleDate 基準日);

}
