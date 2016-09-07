/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifukakakutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;

/**
 *
 * 特徴仮算定賦課確定のmapperクラスです。
 *
 * @reamsid_L DBB-0800-020 wanghui
 */
public interface ITokuchokarisanteiMapper {

    /**
     * 賦課処理状況の更新処理します。
     *
     * @param params TokuchoKarisanteiFukaKakutei
     * @return List<UrT0705ChoteiKyotsuEntity>
     */
    List<UrT0705ChoteiKyotsuEntity> updShoKofuKaishuJoho(TokuchoKarisanteiFukaKakuteiMapperParameter params);
}
