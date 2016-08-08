/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.RegistShoriDateKanriParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.ShotokuJohoIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * ビジネス設計_DBBBZ51003_1_所得情報一覧表作成（バッチ）のMapper
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
public interface IShotokuJohoIchiranhyoSakuseiMapper {

    /**
     * select介護保険所得情報一覧データ
     *
     * @param par ShotokuJohoIchiranhyoSakuseiParameter
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> select介護保険所得情報一覧データ(ShotokuJohoIchiranhyoSakuseiParameter par);

    /**
     * 介護保険所得のcreat
     */
    void creat介護保険所得();

    /**
     * creat介護所得一時
     */
    void creat介護所得一時();

    /**
     * select対象データ
     *
     * @param par ShotokuJohoIchiranhyoSakuseiParameter
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> select対象データ(ShotokuJohoIchiranhyoSakuseiParameter par);

    /**
     * select所得情報一覧データ
     *
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> select所得情報一覧データ();

    /**
     * 処理日付管理マスタ(単一市町村)を取得します。
     *
     * @param param RegistShoriDateKanriParameter
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity select処理日付管理マスタ_単一市町村(RegistShoriDateKanriParameter param);

    /**
     * 処理日付管理マスタ(広域市町村)を取得します。
     *
     * @param param RegistShoriDateKanriParameter
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity select処理日付管理マスタ_広域市町村(RegistShoriDateKanriParameter param);

    /**
     * 処理日付管理マスタを保存します。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    void add処理日付管理マスタ(DbT7022ShoriDateKanriEntity entity);

    /**
     * 処理日付管理マスタを更新します。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    void update処理日付管理マスタ(DbT7022ShoriDateKanriEntity entity);

    /**
     * Tempを取得します。
     *
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> selectTempAll();
}
