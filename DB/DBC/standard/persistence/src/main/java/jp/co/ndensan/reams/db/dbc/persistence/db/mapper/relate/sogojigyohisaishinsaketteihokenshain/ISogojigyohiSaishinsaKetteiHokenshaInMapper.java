/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaDoIchiranhyoSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInEntity;

/**
 * 総合事業費再審査決定通知書情報取込（保険者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-4680-030 wangxue
 */
public interface ISogojigyohiSaishinsaKetteiHokenshaInMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return SogojigyohiSaishinsaKetteiHokenshaInEntity
     */
    SogojigyohiSaishinsaKetteiHokenshaInEntity get帳票出力対象データ(SogojigyohiSaishinsaDoIchiranhyoSakuseiMyBatisParameter parameter);

}
