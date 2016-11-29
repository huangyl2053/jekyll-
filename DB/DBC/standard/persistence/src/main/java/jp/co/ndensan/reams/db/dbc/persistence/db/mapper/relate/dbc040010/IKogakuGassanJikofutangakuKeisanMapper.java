/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.DBC040010MyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.InsShiharaihohoHenkoTempBeforeMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.SetFutangakuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.TaishoshaChushuJigyobunMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.TaishoshaChushuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040010.UpdshafukuKeigenTempMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.CalcKogakuShikyugakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010TaishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DbT3017MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DbT3170MatchingEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.RiyoshaFutanMatchingEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のDB検索用のインターフェースクラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public interface IKogakuGassanJikofutangakuKeisanMapper {

    /**
     * get対象者抽出データのメソッドです。
     *
     * @param parameter TaishoshaChushuMyBatisParameter
     * @return List< DBC020080TaishoDataEntity>
     */
    List<DBC040010TaishoDataEntity> get対象者抽出データ(TaishoshaChushuMyBatisParameter parameter);

    /**
     * get対象者抽出事業分データのメソッドです。
     *
     * @param parameter TaishoshaChushuJigyobunMyBatisParameter
     * @return List< DBC020080TaishoDataEntity>
     */
    List<DBC040010TaishoDataEntity> get対象者抽出事業分データ(TaishoshaChushuJigyobunMyBatisParameter parameter);

    /**
     * get処理結果のメソッドです。
     *
     * @return List<DBC020080ShoriKekkaTempEntity>
     */
    List<DBC040010ShoriKekkaTempEntity> get処理結果();

    /**
     * get実績負担額データのメソッドです。
     *
     * @return List<JissekiFutangakuDataTempEntity>
     */
    List<JissekiFutangakuDataTempEntity> get実績負担額データ();

    /**
     * get実績負担額データの件数のメソッドです。
     *
     * @return Integer
     */
    Integer get実績負担額データの件数();

    /**
     * get処理日付管理のメソッドです。
     *
     * @param parameter DBC020080MyBatisParameter
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理(DBC040010MyBatisParameter parameter);

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
     * @return List<DbT3017MatchingEntity>
     */
    List<DbT3017MatchingEntity> getShiharaihohoHenkoHosoku();

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
    List<JissekiFutangakuDataTempEntity> get帳票データ(DBC040010MyBatisParameter parameter);

    /**
     * getUpd高額合算申請書のメソッドです。
     *
     * @return List<DbT3068KogakuGassanShinseishoEntity>
     */
    List<DbT3068KogakuGassanShinseishoEntity> getUpd高額合算申請書();

    /**
     * テスト用のメソッドです。
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本一時();

    /**
     * get自己負担額のメソッドです。
     *
     * @param parameter SetFutangakuMyBatisParameter
     * @return List<DbT3170MatchingEntity>
     */
    List<DbT3170MatchingEntity> get自己負担額(SetFutangakuMyBatisParameter parameter);

    /**
     * get高額支給額集計のメソッドです。
     *
     * @return List<CalcKogakuShikyugakuRelateEntity>
     */
    List<CalcKogakuShikyugakuRelateEntity> get高額支給額集計();
}
