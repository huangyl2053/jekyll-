/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;

/**
 * 過誤決定通知書情報取込一覧表（公費負担者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public interface IKohifutanshaChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<KagoKetteiKohifutanshaInItem>
     */
    List<KagoKetteiKohifutanshaChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter);
}
