/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.renkeidatatorikomi.RenkeiDataTorikomiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101RelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempEntity;

/**
 * 要介護認定申請情報一時テーブルのマッパーインタフェースです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public interface IDbT5101TempMapper {

    /**
     * 要介護認定申請情報中間一時テーブル情報を取得します。
     *
     * @param parameter RenkeiDataTorikomiMybitisParamter
     * @return List<DbT5101NinteiShinseiJohoTempEntity>
     */
    List<DbT5101TempEntity> get申請中間一時テーブル(RenkeiDataTorikomiMybitisParamter parameter);

    /**
     * 要介護認定申請情報一時テーブル電算_東芝情報を取得します。
     *
     * @return List<DbT5101NinteiShinseiJohoTempEntity>
     */
    List<DbT5101TempEntity> get申請一時電算_東芝情報();

    /**
     * 要介護認定申請情報一時テーブル厚労省情報を取得します。
     *
     * @return List<DbT5101NinteiShinseiJohoTempEntity>
     */
    List<DbT5101TempEntity> get申請一時厚労省情報();

    /**
     * 要介護認定申請情報エラー一時テーブル厚労省情報を取得します。
     *
     * @return List<DbT5101NinteiShinseiJohoTempEntity>
     */
    List<DbT5101TempEntity> get申請エラー一時テーブル();

    /**
     * 要介護認定申請電算東芝版情報一時テーブルキー項目ある情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5101RelateEntity> get更新対象情報_電算東芝版();

    /**
     * 要介護認定申請厚労省情報一時テーブルキー項目ある情報を取得します。
     *
     * @return List<DbT5101RelateEntity>
     */
    List<DbT5101RelateEntity> get更新対象情報_厚労省();

}
