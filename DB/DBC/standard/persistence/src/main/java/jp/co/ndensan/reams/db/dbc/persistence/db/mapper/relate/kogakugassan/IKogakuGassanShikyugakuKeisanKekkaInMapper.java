/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWTKogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInfoEntity;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public interface IKogakuGassanShikyugakuKeisanKekkaInMapper {

    /**
     * 高額合算支給額計算結果情報取得するメソッドです。
     *
     * @return List<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> 高額合算支給額計算結果情報
     */
    List<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> select高額合算支給額計算結果();

    /**
     * 高額合算支給額計算結果情報取得するメソッドです。
     *
     * @return List<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> 高額合算支給額計算結果情報
     */
    List<DbWTKogakuGassanShikyugakuKeisanKekkaEntity> select高額合算支給額計算結果_マスタ();

    /**
     * 高額合算支給額計算結果明細情報取得するメソッドです。
     *
     * @return List<DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 高額合算支給額計算結果明細情報
     */
    List<DbWTKogakuGassanShikyugakuKeisanKekkaMeisaiEntity> select高額合算支給額計算結果明細_マスタ();

    /**
     * 高額合算支給額計算結果連絡票確認リスト情報取得するメソッドです。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KogakuGassanShikyugakuKeisanKekkaInfoEntity> 高額合算支給額計算結果連絡票確認リスト情報
     */
    List<KogakuGassanShikyugakuKeisanKekkaInfoEntity> select計算結果連絡票確認リスト情報(KokuhorenIchiranhyoMybatisParameter parameter);

    /**
     * 高額合算支給額計算結果連絡票取込情報取得するメソッドです。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<KogakuGassanShikyugakuKeisanKekkaInfoEntity> 高額合算支給額計算結果連絡票取込情報
     */
    List<KogakuGassanShikyugakuKeisanKekkaInfoEntity> select計算結果連絡票情報取込情報(KokuhorenIchiranhyoMybatisParameter parameter);

    /**
     * 高額合算支給額計算結果情報取得するメソッドです。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> 高額合算支給額計算結果情報
     */
    List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> select高額合算支給額計算結果情報(KokuhorenIchiranhyoMybatisParameter parameter);

    /**
     * 高額合算支給額計算結果明細取得するメソッドです。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 高額合算支給額計算結果明細情報
     */
    List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> select高額合算支給額計算結果明細情報(KokuhorenIchiranhyoMybatisParameter parameter);

}
