/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic.kijuntsukishichosonjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 基準月市町村情報の取得します
 */
public interface IKijuntsukiShichosonjohoMapper {

    /**
     * 新合併市町村の取得します。
     *
     * @param 基準年月 FlexibleDate
     * @return List <DbT7055GappeiJohoEntity>
     */
    List<DbT7055GappeiJohoEntity> get新合併市町村の取得(FlexibleDate 基準年月);

    /**
     * 旧市町村情報を取得します。
     *
     * @param 基準年月 FlexibleDate
     * @return List<GappeiShichosonEntity>
     */
    List<GappeiShichosonEntity> get旧市町村情報を取得(FlexibleDate 基準年月);

    /**
     * 広域の旧合併市町村情報の取得します。
     *
     * @param 基準年月 FlexibleDate
     * @return List<KoseiShichosonMasterEntity>
     */
    List<KoseiShichosonMasterEntity> get広域の旧合併市町村情報を取得(FlexibleDate 基準年月);

    /**
     * 最新の広域構成市町村の取得します。
     *
     * @param 基準年月 FlexibleDate
     * @return List<KoseiShichosonMasterEntity>
     */
    List<KoseiShichosonMasterEntity> get最新の広域構成市町村の取得(FlexibleDate 基準年月);
}
