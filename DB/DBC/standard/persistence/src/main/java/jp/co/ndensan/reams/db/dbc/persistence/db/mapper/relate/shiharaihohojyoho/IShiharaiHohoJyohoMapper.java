/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0715KozaEntity;

/**
 * 支払方法情報を取得するマッパーインタフェースです
 */
public interface IShiharaiHohoJyohoMapper {

    /**
     * 識別コード、業務内区分コードで口座IDListを取得します。
     *
     * @param parameter 支払方法情報Parameter
     * @return List<UrT0715KozaEntity>
     */
    List<UrT0715KozaEntity> get口座IDリストByKozaParameter(KozaParameter parameter);

    /**
     * 口座IDで口座情報を取得します。
     *
     * @param parameter 支払方法情報Parameter
     * @return UrT0715KozaEntity
     */
    UrT0715KozaEntity get口座情報ByKey(KozaParameter parameter);
}
