/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912TempEntity;

/**
 * 認定申請連携データ取込のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public interface IDbT5912TempMapper {

    /**
     * 主治医情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5912TempEntity> get主治医情報_電算();

    /**
     * 主治医エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5912ErrorTempEntity> get主治医エラー情報_電算();

    /**
     * 主治医更新対象情報を取得します。
     *
     * @return List<DbT5912RelateEntity>
     */
    List<DbT5912RelateEntity> get主治医更新対象情報_電算();

    /**
     * 主治医情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5912TempEntity> get主治医情報_厚労省();

    /**
     * 主治医エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5912ErrorTempEntity> get主治医エラー情報_厚労省();

    /**
     * 主治医更新対象情報を取得します。
     *
     * @return List<DbT5912RelateEntity>
     */
    List<DbT5912RelateEntity> get主治医更新対象情報_厚労省();

}
