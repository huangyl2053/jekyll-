/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuservicehihanteikekkaout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.DbWT3411KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiGetSoufuDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiKanrenDataKoushinEntity;

/**
 * 高額サービス費給付判定結果情報作成のMapperです。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public interface IKogakuServicehiHanteikekkaOutJohoMapper {

    /**
     * 高額介護サービス費支給申請TBLと高額介護サービス費支給判定結果TBLからデータを取ります。
     *
     * @param parameter KogakuServicehiHanteiMybatisParameter
     * @return List<KogakuServicehiHanteiGetSoufuDataEntity>
     */
    List<KogakuServicehiHanteiGetSoufuDataEntity> select送付対象データリスト(KogakuServicehiHanteiMybatisParameter parameter);

    /**
     * 被保険者一時TBLと高額介護サービス費支給一時TBLからデータを取ります。
     *
     * @return List<KogakuServicehiHanteiKanrenDataKoushinEntity>
     */
    List<KogakuServicehiHanteiKanrenDataKoushinEntity> select保険者番号取込関連リスト();

    /**
     * 被保険者一時TBLと高額介護サービス費支給一時TBLからデータを取ります。
     *
     * @return List<KogakuServicehiHanteiGetSoufuDataEntity>
     */
    List<KogakuServicehiHanteiGetSoufuDataEntity> select送付除外区分関連リスト();

    /**
     * 高額介護サービス費支給一時TBLからデータを取ります。
     *
     * @return List<DbWT3411KogakuShikyuShinseiEntity>
     */
    List<DbWT3411KogakuShikyuShinseiEntity> select保険者番号取得関連リスト();

    /**
     * 高額介護サービス費支給一時TBLからデータを取ります。
     *
     * @param parameter KogakuServicehiHanteiMybatisParameter
     * @return List<KogakuServicehiHanteiKanrenDataKoushinEntity>
     */
    List<KogakuServicehiHanteiKanrenDataKoushinEntity> select送付対象データ関連リスト(KogakuServicehiHanteiMybatisParameter parameter);

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KogakuServicehiHanteiIchiranhyoTaisyoEntity>
     */
    List<KogakuServicehiHanteiIchiranhyoTaisyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

    /**
     * DB更新データを取ります。
     *
     * @return List<KogakuServicehiHanteiKanrenDataKoushinEntity>
     */
    List<KogakuServicehiHanteiKanrenDataKoushinEntity> selectDB更新データ関連リスト();

}
