/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.seikatsuhogo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.seikatsuHogoJoho.SeikatsuHogoJohoTorokuMyBatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.seikatsuHogoJoho.SeikatsuHogoJohoTorokuEntity;

/**
 *
 * 生活保護情報登録のマッパーインターフェースです。
 * 
 * @author n8407
 */
public interface ISeikatsuHogoJohoTorokuMapper {
     /**
     * 生活保護情報登録リストを取得します。
     *
     * @param parameter SeikatsuHogoJohoTorokuMyBatisParameter
     * @return List<SeikatsuHogoJohoTorukuEntity>
     */
    List<SeikatsuHogoJohoTorokuEntity> get生活保護情報登録リスト(SeikatsuHogoJohoTorokuMyBatisParameter parameter);
    
}
