/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHaakuResultEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;

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
     * 世帯員把握入力住所地特例該当が１
     *
     * @return List<SetaiHaakuEntity>
     */
    List<SetaiHakuEntity> select世帯員把握入力_1();

    /**
     * select世帯員把握入力
     *
     * @param parameter SetaiShotokuKazeiHanteiMybatisParameter
     * @return List<SetaiHaakuResultEntity>
     */
    List<SetaiHaakuResultEntity> select世帯員把握入力(SetaiShotokuKazeiHanteiMybatisParameter parameter);

    /**
     * 世帯員把握入力Tempのデータの取得
     *
     * @return 世帯員把握入力Tempのデータ
     */
    List<SetaiHakuEntity> get世帯員把握入力Temp();

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
    List<SetaiHakuEntity> selectNotNull();

    /**
     * 世帯員把握入力Tempを更新します
     *
     * @param entity SetaiHaakuEntity
     */
    void update世帯員把握入力Temp(SetaiHakuEntity entity);

}
