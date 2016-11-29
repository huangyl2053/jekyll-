/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakoshinkekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakoshinkekka.DbT3104KensakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakoshinkekka.JukyushaKoshinKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;

/**
 * 受給者情報更新結果情報取込みのバッチのDB操作です。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
public interface IJukyushaKoshinKekkaMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter JukyushaKoshinKekkaMybatisParameter
     * @return List<JukyushaHihokenshaEntity>
     */
    List<JukyushaHihokenshaEntity> get帳票出力対象データ(JukyushaKoshinKekkaMybatisParameter parameter);

    /**
     * DbT3104KokuhorenInterfaceKanriを取得する。
     *
     * @param parameter DbT3104KensakuMybatisParameter
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    DbT3104KokuhorenInterfaceKanriEntity getDbT3104KokuhorenInterfaceKanri(DbT3104KensakuMybatisParameter parameter);
}
