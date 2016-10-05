/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikohijukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaEntity;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込のバッチのDB操作です。
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
public interface ISogojigyohiKohiJukyushaMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter IMyBatisParameter
     * @return List<SogojigyohiKohiJukyushaEntity>
     */
    List<SogojigyohiKohiJukyushaEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
