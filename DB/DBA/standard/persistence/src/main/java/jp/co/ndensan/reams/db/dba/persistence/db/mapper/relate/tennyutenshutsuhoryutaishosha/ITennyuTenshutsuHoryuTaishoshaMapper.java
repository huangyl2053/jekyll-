/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsuhoryutaishosha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu.TennyushutsuHoryuTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu.TenshutsuHoryuTaishoshaRelateEntity;

/**
 * 転入転出保留対象者管理のMapperクラスです。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
public interface ITennyuTenshutsuHoryuTaishoshaMapper {

    /**
     * 転出保留対象者情報の取得する。
     *
     * @return List<TenshutsuHoryuTaishoshaRelateEntity>
     */
    List<TenshutsuHoryuTaishoshaRelateEntity> get転出保留対象者情報の取得処理();

    /**
     * 転入保留対象者情報の取得する。
     *
     * @return List<TennyushutsuHoryuTaishoshaRelateEntity>
     */
    List<TennyushutsuHoryuTaishoshaRelateEntity> get転入保留対象者情報の取得処理();

    /**
     * 広域保留対象者情報の取得する。
     *
     * @return List<TennyushutsuHoryuTaishoshaRelateEntity>
     */
    List<TennyushutsuHoryuTaishoshaRelateEntity> get広域保留対象者情報の取得処理();

}
