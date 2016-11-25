/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jikofutangakushomeisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeisho.JikoFutangakushomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeisho.KogakuGassanJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeisho.TaisyousyaEntity;

/**
 * 自己負担額証明書作成のMapperクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public interface IJikoFutangakushomeishoMapper {

    /**
     * get高額合算情報1
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return KogakuGassanJoho
     */
    KogakuGassanJohoEntity get高額合算情報1(JikoFutangakushomeishoParameter parameter);

    /**
     * get高額合算情報2
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return KogakuGassanJoho
     */
    KogakuGassanJohoEntity get高額合算情報2(JikoFutangakushomeishoParameter parameter);

    /**
     * get宛名から被保険者の個人情報
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return KogakuGassanJohoEntity
     */
    KogakuGassanJohoEntity get宛名から被保険者の個人情報(JikoFutangakushomeishoParameter parameter);

    /**
     * get対象者データ1
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return TaisyousyaEntity
     */
    List<TaisyousyaEntity> get対象者データ1(JikoFutangakushomeishoParameter parameter);

    /**
     * get対象者データ2
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return TaisyousyaEntity
     */
    List<TaisyousyaEntity> get対象者データ2(JikoFutangakushomeishoParameter parameter);

    /**
     * get再計算区分
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return DbT3068KogakuGassanShinseishoEntity
     */
    DbT3068KogakuGassanShinseishoEntity get再計算区分(JikoFutangakushomeishoParameter parameter);
}
