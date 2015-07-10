/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.persistence.mappers.IKyufukanrihyoDataTempTableMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 給付管理票取込の編集用情報取得処理クラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuKanrihyoInBatchRegistGetEditInfoProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        IKyufukanrihyoDataTempTableMapper mapper = getMapper(IKyufukanrihyoDataTempTableMapper.class);
        update被保険者番号変更用市町村コード(mapper);
        update新被保険者番号(mapper);
        update事業所名称(mapper);
        update識別コード(mapper);
        update漢字氏名(mapper);
        update市町村コード(mapper);
    }

    private void update被保険者番号変更用市町村コード(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateHihoNoHenkanShichosonCode1(sqlParam);
        mapper.updateHihoNoHenkanShichosonCode2(sqlParam);
        mapper.updateHihoNoHenkanShichosonCode3(sqlParam);
        mapper.updateHihoNoHenkanShichosonCode4(sqlParam);
    }

    private void update新被保険者番号(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateShinHihokenshaNo1(sqlParam);
        mapper.updateShinHihokenshaNo2(sqlParam);
    }

    private void update事業所名称(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateJigyoshoMeisho1(sqlParam);
        mapper.updateJigyoshoMeisho2(sqlParam);
    }

    private void update識別コード(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateShikibetsuCode1(sqlParam);
        mapper.updateShikibetsuCode2(sqlParam);
    }

    private void update漢字氏名(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateKanjiMeisho(sqlParam);
    }

    private void update市町村コード(IKyufukanrihyoDataTempTableMapper mapper) {
        Map<String, Object> sqlParam = new HashMap<>();
        mapper.updateShichosonCode1(sqlParam);
        mapper.updateShichosonCode2(sqlParam);
    }
}
