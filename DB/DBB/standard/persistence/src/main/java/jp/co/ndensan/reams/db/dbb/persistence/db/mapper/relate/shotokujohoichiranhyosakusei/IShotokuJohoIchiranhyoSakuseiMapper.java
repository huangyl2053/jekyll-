/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokujohoichiranhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.KaigoHokenShotokuItijiParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei.ShotokuJohoIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuItijiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * 介護保険所得のinsert
     *
     * @param entity KaigoHokenShotokuTempEntity
     */
    void insert介護保険所得(KaigoHokenShotokuTempEntity entity);

    /**
     * select介護所得一時データ
     *
     * @param ラジオボタン RString
     * @return List<KaigoHokenShotokuItijiTempEntity>
     */
    List<KaigoHokenShotokuItijiTempEntity> select介護所得一時データ(RString ラジオボタン);

    /**
     * creat介護所得一時
     */
    void creat介護所得一時();

    /**
     * insert介護所得一時
     *
     * @param entity KaigoHokenShotokuItijiTempEntity
     */
    void insert介護所得一時(KaigoHokenShotokuItijiTempEntity entity);

    /**
     * select対象データ
     *
     * @param par KaigoHokenShotokuItijiParameter
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> select対象データ(KaigoHokenShotokuItijiParameter par);

    /**
     * select所得情報一覧データ
     *
     * @return List<KaigoHokenShotokuTempEntity>
     */
    List<KaigoHokenShotokuTempEntity> select所得情報一覧データ();

}
