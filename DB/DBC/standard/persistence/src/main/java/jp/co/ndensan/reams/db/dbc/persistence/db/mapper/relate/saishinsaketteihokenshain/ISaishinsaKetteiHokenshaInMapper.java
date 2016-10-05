/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiResultEntity;

/**
 *
 * 再審査決定通知書情報取込（保険者分）Mapper
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public interface ISaishinsaKetteiHokenshaInMapper {

    /**
     * 帳票出力対象データ
     *
     * @param mybatisParameter SaishinsaKetteiHokenshaInParameter
     * @return 帳票出力対象データ
     */
    List<SaishinsaKetteiResultEntity> get帳票出力対象データ(SaishinsaKetteiHokenshaInParameter mybatisParameter);
}
