/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hokensha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenshaMapperParameter;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;

/**
 *
 * 保険者入力補助のMapperクラスです。
 */
public interface HokenshaMapper {

    /**
     * 保険者情報を取得します。
     *
     * @param 保険者情報検索条件 保険者情報検索条件
     * @return UrT0507HokenjaEntity
     */
    List<UrT0507HokenjaEntity> getHokenshaList(HokenshaMapperParameter 保険者情報検索条件);

}
