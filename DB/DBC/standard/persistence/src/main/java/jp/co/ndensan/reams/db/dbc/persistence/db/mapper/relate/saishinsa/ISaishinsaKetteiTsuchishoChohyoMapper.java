/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsa;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaKetteiTsuchishoChohyoEntity;

/**
 * 再審査決定通知書情報取込（公費負担者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public interface ISaishinsaKetteiTsuchishoChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<KagoKetteiKohifutanshaInItem>
     */
    List<SaishinsaKetteiTsuchishoChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter);
}
