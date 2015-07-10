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
 * 対象者のモデルのテストクラスです。（賦課系）
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaTaishoshaModelTest extends DbzTestBase {

    public static class コンストラクタ {

        FukaTaishoshaModel sut;

        @Test(expected = NullPointerException.class)
        public void 対象者エンティティがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new FukaTaishoshaModel(null);
        }
    }
}
