/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120840;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120840.SogojigyohiKagoKetteiHokenshaChohyoEntity;

/**
 * 総合事業費過誤決定通知書情報取込（保険者分)帳票出力対象データ取得
 *
 * @reamsid_L DBC-2550-011 jiangxiaolong
 */
public interface ISogojigyohiKagoKetteiHokenshaChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<KagoKetteiKohifutanshaInItem>
     */
    List<SogojigyohiKagoKetteiHokenshaChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter);
}
