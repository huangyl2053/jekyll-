/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kenkoukaruterenkeidatakoiki;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki.KenkoKaruteRenkeiKoikiTempTableEntity;

/**
 * 健康かるて連携データ作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public interface IKenkouKaruteRenkeiDataKoikiMapper {

    /**
     * 健康かるて連携データを取得します。
     *
     * @param parameter 健康かるて連携データ作成のパラメータ
     * @return List<KenkouKaruteRenkeiDataEntity>
     */
    List<KenkouKaruteRenkeiDataEntity> createKenkouKaruteRenkeiData(KenkouKaruteRenkeiDataMybatisParameter parameter);

    /**
     * 健康かるて連携データ取得。
     *
     * @return List<KenkoKaruteRenkeiKoikiTempTableEntity>
     */
    List<KenkoKaruteRenkeiKoikiTempTableEntity> getKenkouKaruteRenkeiDataKoiki();
}
