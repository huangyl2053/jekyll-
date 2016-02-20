/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hiroshimadomain;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hiroshimadomain.HiroshimaDomainMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hiroshimadomain.HiroshimaDomainRelateEntity;

/**
 *
 * @author chenaoqi
 */
public interface IHiroshimaDomainMapper {

    List<HiroshimaDomainRelateEntity> get転入転出異動情報(HiroshimaDomainMybatisParameter 検索条件);
}
