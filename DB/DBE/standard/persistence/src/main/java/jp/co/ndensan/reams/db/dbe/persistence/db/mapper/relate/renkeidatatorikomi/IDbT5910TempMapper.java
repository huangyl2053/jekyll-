/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910TempEntity;

/**
 * 要介護認定申請情報一時テーブルのマッパーインタフェースです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public interface IDbT5910TempMapper {

    /**
     * 認定調査委託先情報_電算を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5910TempEntity> get委託先一時情報_電算();

    /**
     * 認定調査委託先情報_厚労省を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5910TempEntity> get委託先情報_厚労省();

    /**
     * 認定調査委託先エラー情報_電算を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5910ErrorTempEntity> get委託先一時エラー情報_電算();

    /**
     * 認定調査委託先エラー情報_厚労省を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5910ErrorTempEntity> get委託先エラー情報_厚労省();

    /**
     * 委託先更新対象情報を取得します。
     *
     * @return List<DbT5910RelateEntity>
     */
    List<DbT5910RelateEntity> get委託先更新対象情報_電算();

    /**
     * 委託先更新対象情報を取得します。
     *
     * @return List<DbT5910RelateEntity>
     */
    List<DbT5910RelateEntity> get委託先更新対象情報_厚労省();

}
