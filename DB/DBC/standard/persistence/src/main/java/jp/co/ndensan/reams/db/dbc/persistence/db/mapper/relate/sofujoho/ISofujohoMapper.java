/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sofujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sofujoho.SofujohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sofujoho.SofujohoRelateEntity;

/**
 * 過誤申立送付情報照会のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
public interface ISofujohoMapper {

    /**
     * 過誤申立送付情報照会を取得します。
     *
     * @param 送付情報照会検索条件 送付情報照会検索条件
     * @return 過誤申立送付情報照会
     */
    List<SofujohoRelateEntity> select過誤申立送付情報照会(SofujohoMybatisParameter 送付情報照会検索条件);
}
