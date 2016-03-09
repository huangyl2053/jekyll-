/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2005SetaiHaakuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019SetaiSudeTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;

/**
 * 世帯所得・課税判定のマッパーインタフェースです。
 *
 */
public interface ISetaiShotokuKazeiHanteiMapper {

    /**
     * 世帯員所得情報一時が1を作成します
     */
    void insert世帯員所得情報一時が1();

    /**
     * insert世帯員所得情報一時が1以外を作成します
     *
     * @param parameter SetaiShotokuKazeiHanteiMybatisParameter
     */
    void insert世帯員所得情報一時が1以外(SetaiShotokuKazeiHanteiMybatisParameter parameter);

    /**
     * 世帯員把握入力Tempのデータの取得
     *
     * @return 世帯員把握入力Tempのデータ
     */
    List<DbT2005SetaiHaakuTempEntity> get世帯員把握入力Temp();

    /**
     * 世帯員所得情報一時を作成します
     *
     * @param 世帯員所得情報Entity DbT2019SetaiSudeTempEntity
     */
    void insert世帯員所得情報一時(DbT2019SetaiSudeTempEntity 世帯員所得情報Entity);

    /**
     * 介護所得のデータの取得
     *
     * @return 介護所得
     */
    List<DbT2008ShotokuKanriEntity> select介護所得();

    /**
     * 世帯員所得情報を更新します
     *
     * @param entity DbT2008ShotokuKanriEntity
     */
    void update世帯員所得情報(DbT2008ShotokuKanriEntity entity);

    /**
     * 世帯員把握入力Tempのデータの取得
     *
     * @return 世帯員把握入力Temp
     */
    List<DbT2005SetaiHaakuTempEntity> selectNotNull();

    /**
     * 世帯員把握入力Tempを更新します
     *
     * @param entity DbT2005SetaiHaakuTempEntity
     */
    void update世帯員把握入力Temp(DbT2005SetaiHaakuTempEntity entity);

}
