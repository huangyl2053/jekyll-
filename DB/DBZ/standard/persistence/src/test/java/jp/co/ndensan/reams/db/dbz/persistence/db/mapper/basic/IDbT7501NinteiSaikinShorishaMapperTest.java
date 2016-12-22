/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 */
public class IDbT7501NinteiSaikinShorishaMapperTest extends DbzTestDacBase {

    @Test
    public void save_エラーしないこと() {
        sqlSession.getMapper(IDbT7501NinteiSaikinShorishaMapper.class).save(
                new DbT7501NinteiSaikinShorishaEntity(new RString("SEUser"),
                        new ShoKisaiHokenshaNo("000000"), new RString("1234567890"), new RString("hoge")));

    }
}
