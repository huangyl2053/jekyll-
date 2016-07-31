/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiHaakuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;

/**
 * 世帯所得・課税判定のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0640-020 chenaoqi
 */
public interface ISetaiShotokuKazeiHanteiMapper {

    /**
     * 世帯員所得情報一時テーブルを作成
     */
    void createTmpSetaiShotoku();

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
    List<SetaiHaakuEntity> get世帯員把握入力Temp();

    /**
     * 世帯員所得情報一時を作成します
     *
     * @param 世帯員所得情報Entity SetaiShotokuEntity
     */
    void insert世帯員所得情報一時(SetaiShotokuEntity 世帯員所得情報Entity);

    /**
     * 介護所得のデータの取得
     *
     * @return 介護所得
     */
    List<DbV2502KaigoShotokuEntity> select介護所得();

    /**
     * 世帯員所得情報を更新します
     *
     * @param entity DbT2008ShotokuKanriEntity
     */
    void update世帯員所得情報(DbV2502KaigoShotokuEntity entity);

    /**
     * 世帯員把握入力Tempのデータの取得
     *
     * @return 世帯員把握入力Temp
     */
    List<SetaiHaakuEntity> selectNotNull();

    /**
     * 世帯員把握入力Tempを更新します
     *
     * @param entity SetaiHaakuEntity
     */
    void update世帯員把握入力Temp(SetaiHaakuEntity entity);

}
