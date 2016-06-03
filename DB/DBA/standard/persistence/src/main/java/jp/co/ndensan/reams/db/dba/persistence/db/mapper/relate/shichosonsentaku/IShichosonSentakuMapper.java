package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shichosonsentaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 市町村遷移のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0100-020 xuyannan
 */
public interface IShichosonSentakuMapper {

    /**
     * {@link DbT7051KoseiShichosonMasterEntity}を取得します。
     *
     * @param 基準日 基準日
     * @return {@link DbT7051KoseiShichosonMasterEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    List<DbT7051KoseiShichosonMasterEntity> getEntity(FlexibleDate 基準日);

}
