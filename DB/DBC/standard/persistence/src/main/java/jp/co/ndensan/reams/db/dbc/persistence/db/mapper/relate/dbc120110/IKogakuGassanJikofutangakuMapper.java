/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120110;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.KogakuGassanJikoFutanGakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuKakunEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110.KogakuGassanJikofutangakuMasterTorokuEntity;

/**
 * 37J_高額合算自己負担額確認情報取込のMapperです。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public interface IKogakuGassanJikofutangakuMapper {

    /**
     * 再処理準備高額合算自己負担額と明細データを取得する。
     *
     * @param parameter KogakuGassanJikofutangakuDoMasterTorokuParameter
     * @return List<KogakuGassanJikoFutanGakuCsvEntity>
     */
    List<KogakuGassanJikoFutanGakuCsvEntity> select再処理準備高額合算自己負担額と明細データ(
            KogakuGassanJikofutangakuDoMasterTorokuParameter parameter);

    /**
     * 高額合算自己負担額と一時データを取得する。
     *
     * @return List<KogakuGassanJikofutangakuMasterTorokuEntity>
     */
    List<KogakuGassanJikofutangakuMasterTorokuEntity> select高額合算自己負担額と一時データ();

    /**
     * 高額合算自己負担額一時と明細データを取得する。
     *
     * @return List<DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity>
     */
    List<DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity> select高額合算自己負担額一時と明細データ();

    /**
     * 高額合算自己負担額明細と一時データを取得する。
     *
     * @return List<KogakuGassanJikofutangakuMeisaiMasterTorokuEntity>
     */
    List<DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity> select高額合算自己負担額明細と一時データ();

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter IMyBatisParameter
     * @return List<KogakuGassanJikofutangakuKakunEntity>
     */
    List<KogakuGassanJikofutangakuKakunEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);
}
