/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.AtenaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.JigyobunShikyugakuKeisanMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.KozaJohoForMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 事業分支給額計算 DB操作です。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public interface IJigyobunShikyugakuKeisanMapper {

    /**
     * 高額合算支給額計算結果情報を取得します。
     *
     * @param param パラメータ
     * @return 結果
     */
    List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> get高額合算の支給額計算結果(JigyobunShikyugakuKeisanMybatisParameter param);

    /**
     * 事業高額合算自己負担額証明書情報を取得します。
     *
     * @return 結果
     */
    List<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> get事業高額合算自己負担額証明書();

    /**
     * 事業高額合算自己負担額を取得します。
     *
     * @return 結果
     */
    List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> get事業高額合算自己負担額();

    /**
     * 削除するデータを取得します。
     *
     * @return 結果
     */
    List<ShikyugakuCalcTempEntity> get削除するデータ();

    /**
     * 高額合算支給額計算結果の明細データを取得します。
     *
     * @return 結果
     */
    List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> get高額合算支給額計算結果明細();

    /**
     * 事業高額合算自己負担額明細データを取得します。
     *
     * @return 結果
     */
    List<ShikyugakuCalcTempRelateEntity> get事業高額合算自己負担額明細();

    /**
     * 事業高額合算自己負担額証明書明細データを取得します。
     *
     * @return 結果
     */
    List<ShikyugakuCalcTempRelateEntity> get事業高額合算自己負担額証明書明細();

    /**
     * 支給額の計算を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuCalcTempEntity> get支給額の計算();

    /**
     * 事業高額合算支給額計算結果データに既に履歴が存在する場合に、更新用一時を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempEntity> get更新用一時最新の履歴番号();

    /**
     * 更新用データの支払情報を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempEntity> get更新用データの支払情報の更新();

    /**
     * 更新用データの事業高額合算支給不支給決定情報を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempRelateEntity> 事業高額合算支給不支給決定のデータFor更新用データ();

    /**
     * 更新用データの高額合算支給不支給決定情報を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempRelateEntity> 高額合算支給不支給決定のデータFor更新用データ();

    /**
     * 更新用データの宛名情報を取得します。
     *
     * @param parameter parameter
     * @return 結果
     */
    List<ShikyugakuUpdateTempRelateEntity> get宛名情報(AtenaJohoMybatisParameter parameter);

    /**
     * 更新用データの口座情報を取得します。
     *
     * @param parameter parameter
     * @return 結果
     */
    List<ShikyugakuUpdateTempRelateEntity> get口座情報(KozaJohoForMybatisParameter parameter);

    /**
     * 出力情報を取得します。
     *
     * @param param param
     * @return 結果
     */
    List<ShikyugakuUpdateTempEntity> get出力情報(JigyobunShikyugakuKeisanMybatisParameter param);

    /**
     * 処理結果確認リスト情報を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempEntity> get処理結果確認リスト情報();

    /**
     * 更新用一時の情報を取得します。
     *
     * @return 結果
     */
    List<ShikyugakuUpdateTempEntity> get更新用一時の情報();

    /**
     * 処理日付管理マスタの情報を取得します。
     *
     * @return 結果
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタ();
}
