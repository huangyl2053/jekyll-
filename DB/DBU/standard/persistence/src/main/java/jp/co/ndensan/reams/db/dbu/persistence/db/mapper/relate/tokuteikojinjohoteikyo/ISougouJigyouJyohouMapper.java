/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.SougouJigyouJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.SougouJigyouJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;

/**
 * 総合事業情報のMapperクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
public interface ISougouJigyouJyohouMapper {

    /**
     * 当初_版改定_異動分データの取得処理です。
     *
     * @param parameter 総合事業情報のMybatisParameterクラス
     * @return List<SougouJigyouJyohouRelateEntity>
     */
    List<SougouJigyouJyohouRelateEntity> get当初_版改定_異動分データ(SougouJigyouJyohouMybatisParameter parameter);

    /**
     * 提供対象者の取得処理です。
     *
     * @param parameter 総合事業情報のMybatisParameterクラス
     * @return List<TeikyoKihonJohoNNTempEntity>
     */
    List<TeikyoKihonJohoNNTempEntity> get提供対象者(SougouJigyouJyohouMybatisParameter parameter);
}
