/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040040.JikofutanShomeishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.KogakuGassanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;

/**
 * 自己負担証明書作成（括）のマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public interface IJikofutanShomeishoMapper {

    /**
     * 高額合算情報データを取得する。
     *
     * @param param param
     * @return {@link List<KogakuGassanJohoEntity>}
     */
    List<KogakuGassanJohoEntity> select高額合算情報(JikofutanShomeishoMybatisParameter param);

    /**
     * 問合せ先情報データを取得する。
     *
     * @return {@link DbT7069KaigoToiawasesakiEntity}
     */
    DbT7069KaigoToiawasesakiEntity select問合せ先();

}
