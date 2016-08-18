/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakoshinkekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 受給者情報更新結果情報取込みのバッチのDB操作です。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
public interface IJukyushaKoshinKekkaMapper {

    /**
     * 受給者情報一時TBLに登録する。
     *
     * @param entity DbWT5331JukyushaJohoTempEntity
     * @return int 登録成功の件数
     */
    int 受給者情報明細一時TBLに登録(DbWT5331JukyushaJohoTempEntity entity);

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<JukyushaHihokenshaEntity>
     */
    List<JukyushaHihokenshaEntity> get帳票出力対象データ(IMyBatisParameter parameter);
}
