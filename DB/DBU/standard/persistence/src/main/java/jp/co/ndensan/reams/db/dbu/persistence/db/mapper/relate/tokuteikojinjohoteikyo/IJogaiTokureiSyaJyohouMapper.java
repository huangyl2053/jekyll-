/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;

/**
 * 住所地特例者情報のmapperクラスです。
 *
 * @reamsid_L DBU-4880-040 linghuhang
 */
public interface IJogaiTokureiSyaJyohouMapper {

    /**
     * 当初_版改定_異動分データの取得処理です。
     *
     * @param parameter 住所地特例者情報のMybatisParameterクラス
     * @return List<JogaiTokureiSyaJyohouRelateEntity>
     */
    List<JogaiTokureiSyaJyohouRelateEntity> get当初_版改定_異動分データ(JogaiTokureiSyaJyohouMybatisParameter parameter);

    /**
     * 提供対象者の取得処理です。
     *
     * @return List<TeikyoKihonJohoEntity>
     */
    List<TeikyoKihonJohoNNTempEntity> get提供対象者();
}
