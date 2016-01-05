/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.tennyutenshutsuhoryutaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuEntity;

/**
 *
 * 転入転出保留対象者管理のMapperクラスです。
 */
public interface TennyuTenshutsuHoryuTaishoshaMapper {

    /**
     * 転出保留対象者情報の取得する
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TennyuTenshutsuHoryuEntity> get転出保留対象者情報の取得処理();

    /**
     * 転入保留対象者情報の取得する
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TennyuTenshutsuHoryuEntity> get転入保留対象者情報の取得処理();

    /**
     * 広域保留対象者情報の取得する
     *
     * @return List<TennyuTenshutsuHoryuEntity>
     */
    List<TennyuTenshutsuHoryuEntity> get広域保留対象者情報の取得処理();

}
