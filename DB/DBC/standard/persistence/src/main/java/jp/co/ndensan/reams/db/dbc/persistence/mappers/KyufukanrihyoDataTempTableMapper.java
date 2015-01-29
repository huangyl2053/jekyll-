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
    public void updateHihoNoHenkanShichosonCode1(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateHihoNoHenkanShichosonCode1(param);
    }

    @Override
    public void updateHihoNoHenkanShichosonCode2(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateHihoNoHenkanShichosonCode2(param);
    }

    @Override
    public void updateHihoNoHenkanShichosonCode3(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateHihoNoHenkanShichosonCode3(param);
    }

    @Override
    public void updateHihoNoHenkanShichosonCode4(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateHihoNoHenkanShichosonCode4(param);
    }

    @Override
    public void updateShinHihokenshaNo1(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShinHihokenshaNo1(param);
    }

    @Override
    public void updateShinHihokenshaNo2(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShinHihokenshaNo2(param);
    }

    @Override
    public void updateJigyoshoMeisho1(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateJigyoshoMeisho1(param);
    }

    @Override
    public void updateJigyoshoMeisho2(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateJigyoshoMeisho2(param);
    }

    @Override
    public void updateShikibetsuCode1(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShikibetsuCode1(param);
    }

    @Override
    public void updateShikibetsuCode2(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShikibetsuCode2(param);
    }

    @Override
    public void updateKanjiMeisho(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateKanjiMeisho(param);
    }

    @Override
    public void updateShichosonCode1(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShichosonCode1(param);
    }

    @Override
    public void updateShichosonCode2(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        mapper.updateShichosonCode2(param);
    }

    @Override
    public List<DbTKyufukanrihyoDataTempTableEntity> getTempData(Map<String, Object> param) {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        return mapper.getTempData(param);
    }

    @Override
    public List<DbTKyufukanrihyoDataTempTableEntity> selectAll() {
        IKyufukanrihyoDataTempTableMapper mapper = session.getMapper(IKyufukanrihyoDataTempTableMapper.class);
        return mapper.selectAll();
    }
}
