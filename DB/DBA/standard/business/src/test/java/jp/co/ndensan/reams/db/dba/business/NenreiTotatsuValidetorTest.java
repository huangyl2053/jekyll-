/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NenreiTotatsuValidetorTest {

    public static class validate extends DbaTestBase {
        //TODO #52997
        //バリデーション処理のテストを実装します。
        //1, 取得事由 == 年齢到達 の場合に
        //      (資格取得日 - 生年月日) < 65 のとき、メッセージを返す
        //2, 取得事由 != 年齢到達の場合に
        //      (資格取得日 - 生年月日) < 40 ならメッセージを返す。
        //3, 上記の条件を満たさない場合、メッセージを保持していない。
    }

}
