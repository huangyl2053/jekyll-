/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;

/**
 * 対象者のモデルのテストクラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class TaishoshaModelTest extends DbzTestBase {

    public static class コンストラクタ {

        TaishoshaModel sut;

        @Test(expected = NullPointerException.class)
        public void 対象者エンティティがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new TaishoshaModel(null);
        }
    }
}
