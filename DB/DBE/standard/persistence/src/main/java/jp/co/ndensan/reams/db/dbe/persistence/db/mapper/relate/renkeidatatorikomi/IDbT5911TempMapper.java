/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911TempEntity;

/**
 * 認定申請連携データ取込のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public interface IDbT5911TempMapper {

    /**
     * 主治医医療機関情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5911TempEntity> get医療機関情報_電算();

    /**
     * 主治医医療機関エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5911ErrorTempEntity> get医療機関エラー情報_電算();

    /**
     * 主治医医療機関情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5911TempEntity> get医療機関情報_厚労省();

    /**
     * 主治医医療機関エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5911ErrorTempEntity> get医療機関エラー情報_厚労省();

    /**
     * 主治医医療機関更新対象情報を取得します。
     *
     * @return List<DbT5911RelateEntity>
     */
    List<DbT5911RelateEntity> get医療機関更新対象情報_電算();

    /**
     * 主治医医療機関更新対象情報を取得します。
     *
     * @return List<DbT5911RelateEntity>
     */
    List<DbT5911RelateEntity> get医療機関更新対象情報_厚労省();

}
