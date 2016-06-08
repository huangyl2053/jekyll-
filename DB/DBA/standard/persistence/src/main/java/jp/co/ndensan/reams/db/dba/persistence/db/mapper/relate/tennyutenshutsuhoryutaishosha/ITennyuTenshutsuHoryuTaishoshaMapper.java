/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsuhoryutaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryutaishosha.TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryutaishosha.TenshutsuHoryuTaishoshaEntity;

/**
 * 転入転出保留対象者管理のMapperクラスです。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
public interface ITennyuTenshutsuHoryuTaishoshaMapper {

    /**
     * 転出保留対象者情報の取得する。
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TennyushutsuHoryuTaishoshaEntity> get転出保留対象者情報の取得処理();

    /**
     * 転入 広域保留対象者情報の取得する。
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TenshutsuHoryuTaishoshaEntity> get転入保留対象者情報の取得処理();

    /**
     * 転入 広域保留対象者情報の取得する。
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TenshutsuHoryuTaishoshaEntity> get広域保留対象者情報の取得処理();

}
