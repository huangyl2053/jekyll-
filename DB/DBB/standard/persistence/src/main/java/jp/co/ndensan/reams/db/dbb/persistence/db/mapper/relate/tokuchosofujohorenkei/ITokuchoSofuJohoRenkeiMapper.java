/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosofujohorenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiMybitisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiEntity;

/**
 * 特徴送付情報連携（バッチ）のMapperクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public interface ITokuchoSofuJohoRenkeiMapper {

    /**
     * 仮算定のデータを抽出
     *
     * @param parameter TokuchoSofuJohoRenkeiMybitisParameter
     * @return TokuchoSofuJohoRenkeiEntity
     */
    List<TokuchoSofuJohoRenkeiEntity> select特徴送付情報連携のデータ(TokuchoSofuJohoRenkeiMybitisParameter parameter);

}
