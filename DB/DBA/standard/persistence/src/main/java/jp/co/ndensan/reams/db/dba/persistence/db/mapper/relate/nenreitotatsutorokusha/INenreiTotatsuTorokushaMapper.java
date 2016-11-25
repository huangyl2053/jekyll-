/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 年齢到達登録者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0570-020 xuyannan
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
}
