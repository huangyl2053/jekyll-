/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shuruishikyugendogakumain;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shuruishikyugendogakumain.ShuruiShikyuGendogakuMainListParameter;

/**
 * DBC4210011_種類支給限度額登録のMapperです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public interface IShuruiShikyuGendogakuMainMapper {

    /**
     * @param parameter ShuruiShikyuGendogakuMainListParameter
     */
    void deletEntity(ShuruiShikyuGendogakuMainListParameter parameter);
}
