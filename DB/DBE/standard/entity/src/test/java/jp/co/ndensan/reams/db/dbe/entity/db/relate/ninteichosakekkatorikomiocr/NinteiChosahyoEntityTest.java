/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.util.json.ObjectMapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 * @author N3327 三浦 凌
 */
public class NinteiChosahyoEntityTest {

    public NinteiChosahyoEntityTest() {
    }

    @Test
    public void testGetサービスの状況s() throws Exception {
        RString joson = new RString("{\"insertDantaiCd\":\"209007\",\"insertTimestamp\":\"2017-01-06T20:15:39.488536\",\"insertReamsLoginId\":\"nakano\",\"insertContextId\":\"0a73a9c4-96ba-bda9-28f7-94c52c65eb16\",\"isDeleted\":false,\"updateCount\":0,\"lastUpdateTimestamp\":\"2017-01-06T20:15:39.488536\",\"lastUpdateReamsLoginId\":\"nakano\",\"shinseishoKanriNo\":\"20211920150500097\",\"ninteichosaRirekiNo\":1,\"remban\":15,\"koroshoIfShikibetsuCode\":\"09B\",\"serviceJokyo\":0}");

        ObjectMapper mapper = new ObjectMapperProvider().get();
        DbT5207NinteichosahyoServiceJokyoEntity entity = mapper.readValue(joson.toString(), DbT5207NinteichosahyoServiceJokyoEntity.class);
        System.out.println(entity);
    }

}
