/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteikohifutansha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha.SogoKohifutanshaEntity;

/**
 * 総合事業費過誤決定通知書情報取込一覧表（公費負担者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public interface ISogoKohifutanshaChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<SogoKohifutanshaEntity>
     */
    List<SogoKohifutanshaEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
