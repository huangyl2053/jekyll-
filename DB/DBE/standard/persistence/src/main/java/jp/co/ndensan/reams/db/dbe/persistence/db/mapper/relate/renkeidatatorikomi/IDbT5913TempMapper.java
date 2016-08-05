/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913TempEntity;

/**
 * 要介護認定申請情報一時テーブルのマッパーインタフェースです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public interface IDbT5913TempMapper {

    /**
     * 認定調査員情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5913TempEntity> get調査員情報_電算();

    /**
     * 認定調査員エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5913ErrorTempEntity> get調査員エラー情報_電算();

    /**
     * 認定調査員情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5913TempEntity> get調査員情報_厚労省();

    /**
     * 認定調査員エラー情報一時テーブル情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5913ErrorTempEntity> get調査員エラー情報_厚労省();

    /**
     * 認定調査員更新対象情報を取得します。
     *
     * @return List<DbT5913RelateEntity>
     */
    List<DbT5913RelateEntity> get調査員更新対象情報_電算();

    /**
     * 認定調査員更新対象情報を取得します。
     *
     * @return List<DbT5913RelateEntity>
     */
    List<DbT5913RelateEntity> get調査員更新対象情報_厚労省();

}
