/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushatotsugoiraiout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushatotsugoiraiout.JukyushaTotsugoIraiOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;

/**
 * バッチ設計_DBCMNF1003_536_受給者突合依頼情報作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
public interface IJukyushaTotsugoIraiOutMapper {

    /**
     * 検索条件より、適当な条件を連結して、認定期間内の最新情報を検索する。
     *
     * @param parameter 検索条件
     * @return DbT3001JukyushaIdoRenrakuhyoEntity 検索結果の{@link DbT3001JukyushaIdoRenrakuhyoEntity}
     */
    List<DbT3001JukyushaIdoRenrakuhyoEntity> get最新情報(JukyushaTotsugoIraiOutMybatisParameter parameter);

    /**
     * 検索条件より、適当な条件を連結して、認定期間内の全情報を検索する。
     *
     * @param parameter 検索条件
     * @return DbT3001JukyushaIdoRenrakuhyoEntity 検索結果の{@link DbT3001JukyushaIdoRenrakuhyoEntity}
     */
    List<DbT3001JukyushaIdoRenrakuhyoEntity> get全情報(JukyushaTotsugoIraiOutMybatisParameter parameter);

    /**
     * 検索条件より、適当な条件を連結して、一定期間内の最新情報を検索する。
     *
     * @param parameter 検索条件
     * @return DbT3001JukyushaIdoRenrakuhyoEntity 検索結果の{@link DbT3001JukyushaIdoRenrakuhyoEntity}
     */
    List<DbT3001JukyushaIdoRenrakuhyoEntity> get一定期間内最新情報(JukyushaTotsugoIraiOutMybatisParameter parameter);

    /**
     * 検索条件より、適当な条件を連結して、一定期間内の全情報を検索する。
     *
     * @param parameter 検索条件
     * @return DbT3001JukyushaIdoRenrakuhyoEntity 検索結果の{@link DbT3001JukyushaIdoRenrakuhyoEntity}
     */
    List<DbT3001JukyushaIdoRenrakuhyoEntity> get一定期間内全情報(JukyushaTotsugoIraiOutMybatisParameter parameter);
}
