/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kenkoukaruterenkeidata;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEntity;

/**
 * 健康かるて連携データ作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5020-040 zhaoyao
 */
public interface IKenkouKaruteRenkeiDataMapper {

    /**
     * 健康かるて連携データ取得。
     *
     * @param parameter 健康かるて連携データ作成のパラメータ
     * @return List<KenkouKaruteRenkeiDataEntity>
     */
    List<KenkouKaruteRenkeiDataEntity> createKenkouKaruteRenkeiData(KenkouKaruteRenkeiDataMybatisParameter parameter);
}
