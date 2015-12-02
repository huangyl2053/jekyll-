/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hokenja;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokenja.HokenjaMapperParameter;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;

/**
 *
 * @author 863
 */
public interface HokenjaMapper {

    List<UrT0507HokenjaEntity> getHokenshaList(HokenjaMapperParameter parameter);

}
