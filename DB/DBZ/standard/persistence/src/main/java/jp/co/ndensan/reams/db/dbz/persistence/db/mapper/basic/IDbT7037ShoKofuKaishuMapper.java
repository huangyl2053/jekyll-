/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;

/**
 *
 * @author LDNS xuxf
 */
public interface IDbT7037ShoKofuKaishuMapper {

    /**
     * {@link DbT7037ShoKofuKaishuEntity}を取得します。
     *
     * @return {@link DbT7037ShoKofuKaishuEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7037ShoKofuKaishuEntity getEntity();

    /**
     * 更新処理です。
     *
     * @param entity 証交付回収テーブルのエンティティクラス
     * @return 更新件数
     */
    int updateShoKaishuKanri(DbT7037ShoKofuKaishuEntity entity);

    /**
     * 更新処理です。
     *
     * @param entity 証交付回収テーブルのエンティティクラス
     * @return 更新件数
     */
    int updateShokaishuKanriRnlisakuju(DbT7037ShoKofuKaishuEntity entity);

}
