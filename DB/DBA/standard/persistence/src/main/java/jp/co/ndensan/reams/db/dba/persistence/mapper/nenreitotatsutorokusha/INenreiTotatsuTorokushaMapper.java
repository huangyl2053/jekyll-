/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.nenreitotatsutorokusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 年齢到達登録者のマッパーインタフェースです。
 */
public interface INenreiTotatsuTorokushaMapper {

    /**
     * 被保険者台帳リストを取得します。
     *
     * @param parameter 年齢到達登録者リストのMyBatisパラメータ
     * @return List<NenreiTotatsushaJouhouEntity>
     */
    List<NenreiTotatsushaJouhouEntity> getHiHokenshaDaichoList(NenreiTotatsuTorokushaListMybatisParameter parameter);

    /**
     * 処理日付管理マスタに更新します。
     *
     * @param entity 処理日付管理マスタEntity
     * @return 更新件数
     */
    int updateShoriDateKanri(DbT7022ShoriDateKanriEntity entity);

    /**
     * 宛名識別対象を取得します。
     *
     * @param parameter 宛名識別対象PSM用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getPsmShikibetsuTaisho(NenreiTotatsuTorokushaListMybatisParameter parameter);
}
