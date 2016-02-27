/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.tokuchokarisanteifukakakutei;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiMapperParameter;

/**
 *
 * 特徴仮算定賦課確定のmapperクラスです。
 */
public interface ItokuchokarisanteiMapper {

    /**
     * 賦課処理状況の更新処理します。
     *
     * @param params　TokuchoKarisanteiFukaKakutei
     * @return boolean
     */
    boolean updShoKofuKaishuJoho(TokuchoKarisanteiFukaKakuteiMapperParameter params);
}
