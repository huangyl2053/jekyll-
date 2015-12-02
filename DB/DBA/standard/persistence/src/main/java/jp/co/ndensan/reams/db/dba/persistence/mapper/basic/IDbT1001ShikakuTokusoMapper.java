/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.shikakutokuso.ShikakuTokusoInputGuideParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.ServiceShikakuJohoRelateEntity;

/**
 *
 * @author soft863
 */
public interface IDbT1001ShikakuTokusoMapper {

    List<ServiceShikakuJohoRelateEntity> getShikakuJoho(ShikakuTokusoInputGuideParameter params);

}
