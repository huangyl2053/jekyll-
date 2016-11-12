/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.SelRiyoushaHutanwariaitorigaDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.InsFutanwariaiJohoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseitaishoKyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoSakuseiYoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.SelKyuhuzissekiKihonTorigaDataResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.SelRiyoushaHutanwariaitorigaDataResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.TorigaDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.UpdRiyoshaFutangengakuTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.UpdShiharaihohoHenkoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.DbWT1801ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(データ取得mapperクラスです)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public interface IKoseiTaishoKyufuJissekiIchiranMapper {

    /**
     * 利用者負担割合情報取得。
     *
     * @param parameter SelRiyoushaHutanwariaitorigaDataMybatisParameter
     * @return List<SelRiyoushaHutanwariaitorigaDataResultEntity>
     */
    List<SelRiyoushaHutanwariaitorigaDataResultEntity> get利用者負担割合情報(SelRiyoushaHutanwariaitorigaDataMybatisParameter parameter);

    /**
     * 給付実績基本データ取得。
     *
     * @param parameter SelRiyoushaHutanwariaitorigaDataMybatisParameter
     * @return List<SelKyuhuzissekiKihonTorigaDataResultEntity>
     */
    List<SelKyuhuzissekiKihonTorigaDataResultEntity> get給付実績基本(SelRiyoushaHutanwariaitorigaDataMybatisParameter parameter);

    /**
     * トリガデータTemp取得。
     *
     * @return List<TorigaDataTempEntity>
     */
    List<TorigaDataTempEntity> getトリガデータTemp();

    /**
     * 同じTempデータ取得。
     *
     * @param parameter SelRiyoushaHutanwariaitorigaDataMybatisParameter
     * @return TorigaDataTempEntity
     */
    TorigaDataTempEntity has同じTemp(SelRiyoushaHutanwariaitorigaDataMybatisParameter parameter);

    /**
     * 利用者負担割合明細Newest取得。
     *
     * @return List<InsFutanwariaiJohoTempResultEntity>
     */
    List<InsFutanwariaiJohoTempResultEntity> get利用者負担割合明細Newest();

    /**
     * 利用者負担減額情報の取得。
     *
     * @return List<UpdRiyoshaFutangengakuTempResultEntity>
     */
    List<UpdRiyoshaFutangengakuTempResultEntity> 利用者負担減額情報の取得();

    /**
     * 支払方法変更データ取得。
     *
     * @return List<UpdShiharaihohoHenkoTempResultEntity>
     */
    List<UpdShiharaihohoHenkoTempResultEntity> get支払方法変更();

    /**
     * 給付実績情報作成用データ取得。
     *
     * @return List<KyuhuzissekiJohoSakuseiYoResultEntity>
     */
    List<KyuhuzissekiJohoSakuseiYoResultEntity> get給付実績情報作成用データ();

    /**
     * 給付実績情報作成データ取得。
     *
     * @return List<KyuhuzissekiJohoSakuseiResultEntity>
     */
    List<KyuhuzissekiJohoSakuseiResultEntity> get給付実績情報作成データ();

    /**
     * 一時表：負担割合情報を取得する。
     *
     * @return List<FutanWariaiTempEntity>
     */
    List<FutanWariaiTempEntity> get負担割合情報Temp();

    /**
     * 更正対象給付実績情報作成データ取得。
     *
     * @return List<KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity>
     */
    List<KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity> get更正対象給付実績情報作成データ();

    /**
     * 更正対象給付実績情報取得。
     *
     * @param parameter KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter
     * @return List<KoseitaishoKyuhuzissekiJohoTempEntity>
     */
    List<KoseitaishoKyuhuzissekiJohoTempEntity> get更正対象給付実績情報(KoseiTaishoKyuhuzissekiItiranhyoShuturyokuMybatisParameter parameter);

    /**
     * 処理日付管理マスタの取得。
     *
     * @param 処理名 RString
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ(RString 処理名);

    /**
     * 処理結果確認リストの取得。
     *
     * @return List<DbWT1801ShoriKekkaKakuninListEntity>
     */
    List<DbWT1801ShoriKekkaKakuninListEntity> get処理結果確認リスト();
}
