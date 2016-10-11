/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.DBC020080MyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.InsShiharaihohoHenkoTempBeforeMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.TaishoshaChushuJigyobunMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.TaishoshaChushuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.UpdshafukuKeigenTempMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.CalcKogakuShikyugakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080TaishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DbT3070MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DbT3170MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.RiyoshaFutanMatchingEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のDB検索用のインターフェースクラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public interface IJigyobunKogakuGassanJikofutangakuKeisanMapper {

    /**
     * get対象者抽出データのメソッドです。
     *
     * @param parameter TaishoshaChushuMyBatisParameter
     * @return List< DBC020080TaishoDataEntity>
     */
    List<DBC020080TaishoDataEntity> get対象者抽出データ(TaishoshaChushuMyBatisParameter parameter);

    /**
     * get対象者抽出事業分データのメソッドです。
     *
     * @param parameter TaishoshaChushuJigyobunMyBatisParameter
     * @return List< DBC020080TaishoDataEntity>
     */
    List<DBC020080TaishoDataEntity> get対象者抽出事業分データ(TaishoshaChushuJigyobunMyBatisParameter parameter);

    /**
     * getFutangakuのメソッドです。
     *
     * @return List<DbT3070MatchingEntity>
     */
    List<DbT3070MatchingEntity> getFutangaku();

    /**
     * getFutangakuJigyobunのメソッドです。
     *
     * @return List<DbT3170MatchingEntity>
     */
    List<DbT3170MatchingEntity> getFutangakuJigyobun();

    /**
     * getCalcKogakuShikyugakuのメソッドです。<br/>
     *
     * @return List<CalcKogakuShikyugakuEntity>
     */
    List<CalcKogakuShikyugakuEntity> getCalcKogakuShikyugaku();

    /**
     * get処理結果のメソッドです。
     *
     * @return List<DBC020080ShoriKekkaTempEntity>
     */
    List<DBC020080ShoriKekkaTempEntity> get処理結果();

    /**
     * get実績負担額データのメソッドです。
     *
     * @return List<JissekiFutangakuDataTempEntity>
     */
    List<JissekiFutangakuDataTempEntity> get実績負担額データ();

    /**
     * get処理日付管理のメソッドです。
     *
     * @param parameter DBC020080MyBatisParameter
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理(DBC020080MyBatisParameter parameter);

    /**
     * get給付実績基本一時のメソッドです。
     *
     * @param parameter InsShiharaihohoHenkoTempBeforeMyBatisParameter
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本一時(InsShiharaihohoHenkoTempBeforeMyBatisParameter parameter);

    /**
     * getShiharaihohoHenkoHosokuのメソッドです。
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> getShiharaihohoHenkoHosoku();

    /**
     * getShafukuKeigenTempHenkoのメソッドです。
     *
     * @param parameter UpdshafukuKeigenTempMyBatisParameter
     * @return List<RiyoshaFutanMatchingEntity>
     */
    List<RiyoshaFutanMatchingEntity> getShafukuKeigenTempHenko(UpdshafukuKeigenTempMyBatisParameter parameter);

    /**
     * get実績負担額データ2のメソッドです。
     *
     * @return List<JissekiFutangakuDataTempEntity>
     */
    List<JissekiFutangakuDataTempEntity> get実績負担額データ2();

    /**
     * get帳票データのメソッドです。
     *
     * @param parameter DBC020080MyBatisParameter
     * @return List<JissekiFutangakuDataTempEntity>
     */
    List<JissekiFutangakuDataTempEntity> get帳票データ(DBC020080MyBatisParameter parameter);
}
