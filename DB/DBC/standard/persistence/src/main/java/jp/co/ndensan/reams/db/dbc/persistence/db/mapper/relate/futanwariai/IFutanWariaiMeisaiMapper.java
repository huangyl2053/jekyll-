/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariai.FutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariai.FutanWariaiSokujiKouseiRelateEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合情報を取得します。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public interface IFutanWariaiMeisaiMapper {

    /**
     * 利用者負担割合明細情報を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return FutanWariaiSokujiKouseiRelateEntity 利用者負担割合情報
     */
    FutanWariaiSokujiKouseiRelateEntity select利用者負担割合情報(FutanWariaiMybatisParameter parameter);

    /**
     * 利用者負担割合情報を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return DbT3113RiyoshaFutanWariaiEntity 利用者負担割合情報
     */
    List<DbT3113RiyoshaFutanWariaiEntity> select利用者負担割合BY年度と被保険者番号(FutanWariaiMybatisParameter parameter);

    /**
     * 履歴番号を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return List<RString>
     */
    List<RString> select履歴番号BY年度(FutanWariaiMybatisParameter parameter);

}
