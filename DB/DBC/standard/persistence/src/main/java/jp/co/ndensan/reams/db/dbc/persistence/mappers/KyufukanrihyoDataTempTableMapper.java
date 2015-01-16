/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 給付管理票取込一時データエンティティのマッパークラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufukanrihyoDataTempTableMapper implements IKyufukanrihyoDataTempTableMapper {

    @InjectSession
    SqlSession session;

    @Override
    public List<DbTKyufukanrihyoDataTempTableEntity> getTempData(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        return mapper.getTempData(param);
    }
}
