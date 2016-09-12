/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohisaishinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;

/**
 * 再審査決定通知書情報取込（公費負担者分）帳票出力対象データ取得
 *
 * @reamsid_L DBC-4730-030 liuxiaoyu
 */
public interface ISogojigyohiSaishinsaKetteiTsuchishoChohyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter Map<String, Object>
     * @return List<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity>
     */
    List<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
