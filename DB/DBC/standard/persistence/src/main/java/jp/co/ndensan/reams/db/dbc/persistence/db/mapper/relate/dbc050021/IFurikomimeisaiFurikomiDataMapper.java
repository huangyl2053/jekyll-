/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.HihokenshaAtenaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KozaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050021.FurikomimeisaiFurikomiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.EraTourokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomiDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataJukyushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataKozaJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataShikyugakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiFurikomiDataJigyoKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiFurikomiDataJigyoKogakuGassanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.HihokenshaToAtenaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 振込明細・振込みデータ作成のMapperです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public interface IFurikomimeisaiFurikomiDataMapper {

    /**
     * 高額合算データを取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 高額合算データ
     */
    List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> get高額合算データ(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 事業高額データを取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 事業高額データ
     */
    List<FurikomimeisaiFurikomiDataJigyoKogakuEntity> get事業高額データ(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 事業高額合算データを取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 事業高額合算データ
     */
    List<FurikomimeisaiFurikomiDataJigyoKogakuGassanEntity> get事業高額合算データ(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 被保険者台帳と宛名情報を取得する。
     *
     * @param param HihokenshaAtenaMybatisParameter
     * @return 被保険者台帳と宛名情報
     */
    List<HihokenshaToAtenaResultEntity> get被保険者台帳と宛名情報(HihokenshaAtenaMybatisParameter param);

    /**
     * エラー登録を取得する。
     *
     * @return エラー登録
     */
    List<EraTourokuEntity> エラー登録();

    /**
     * 口座情報を取得する。
     *
     * @param param KozaJohoMybatisParameter
     * @return 口座情報
     */
    List<FurikomimeisaiDataKozaJohoEntity> get口座情報(KozaJohoMybatisParameter param);

    /**
     * 振込対象データを取得する。
     *
     * @return 振込対象データ
     */
    List<FurikomiDataSakuseiEntity> get振込対象データ();

    /**
     * 依頼済の登録_高額合算を取得する。
     *
     * @return 依頼済の登録_高額合算
     */
    List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> get依頼済の登録_高額合算();

    /**
     * 依頼済の登録_事業高額を取得する。
     *
     * @return 依頼済の登録_事業高額
     */
    List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> get依頼済の登録_事業高額();

    /**
     * 依頼済の登録_事業高額合算を取得する。
     *
     * @return 依頼済の登録_事業高額合算
     */
    List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> get依頼済の登録_事業高額合算();

    /**
     * 依頼済の取消_高額合算を取得する。
     *
     * @return 依頼済の取消_高額合算
     */
    List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> get依頼済の取消_高額合算();

    /**
     * 依頼済の取消_事業高額を取得する。
     *
     * @return 依頼済の取消_事業高額
     */
    List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> get依頼済の取消_事業高額();

    /**
     * 依頼済の取消_事業高額合算を取得する。
     *
     * @return 依頼済の取消_事業高額合算
     */
    List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> get依頼済の取消_事業高額合算();

    /**
     * 受給取得状況情報_高額合算と事業高額合算を取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 受給取得状況情報_高額合算と事業高額合算
     */
    List<FurikomimeisaiDataJukyushaEntity> select受給取得状況情報_高額合算と事業高額合算(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 受給取得状況情報_事業高額を取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 受給取得状況情報_事業高額
     */
    List<FurikomimeisaiDataJukyushaEntity> select受給取得状況情報_事業高額(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 申請データ有無確認情報を取得する。
     *
     * @return 申請データ有無確認情報
     */
    List<DbWT0510FurikomiMeisaiTempEntity> select申請データ有無確認情報();

    /**
     * 出力対象データを取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 出力対象データ
     */
    List<FurikomimeisaiDataShikyugakuEntity> select出力対象データ(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 振込エラーリスト情報を取得する。
     *
     * @return 振込エラーリスト情報
     */
    List<DbWT0510FurikomiMeisaiTempEntity> select振込エラーリスト情報();

    /**
     * 処理結果確認リスト情報を取得する。
     *
     * @return 処理結果確認リスト情報
     */
    List<ShoriKekkaKakuninListTempTableEntity> select処理結果確認リスト情報();

    /**
     * 処理日付管理マスタを取得する。
     *
     * @param param FurikomimeisaiFurikomiDataMybatisParameter
     * @return 処理日付管理マスタ
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ(FurikomimeisaiFurikomiDataMybatisParameter param);

    /**
     * 処理日付管理マスタなしを取得する。
     *
     * @return 処理日付管理マスタなし
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタなし();
}
