/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.GyomubetsuPrimaryKeyMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KozaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還口座払の口座情報取得
 *
 * @reamsid_L DBC-2180-030 donghj
 */
public interface IKozaJohoMapper {

    /**
     * 償還口座払の口座情報取得
     *
     * @param parameter KozaJohoMybatisParameter
     * @return List<KozaJohoEntity>
     */
    List<KozaJohoEntity> get償還口座払の口座情報(KozaJohoMybatisParameter parameter);

    /**
     * 高額の口座情報取得
     *
     * @param parameter KozaJohoMybatisParameter
     * @return List<KozaJohoEntity>
     */
    List<KozaJohoEntity> get高額の口座情報(KozaJohoMybatisParameter parameter);

    /**
     * 業務別主キーが業務別主キーTBLから取得する。
     *
     * @param parameter GyomubetsuPrimaryKeyMybatisParameter
     * @return RString
     */
    RString get業務別主キー(GyomubetsuPrimaryKeyMybatisParameter parameter);

}
