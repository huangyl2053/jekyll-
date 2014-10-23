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
 * {@link HihokenshaDaicho HihokenshaDaicho}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoTest {

    public static class constructor extends DbaTestBase {
        //TODO #52997
        //コンストラクタのテストを実装します。
        //1, 引数にnullが渡されたとき_NullPointerExceptionが返ることを確認してください。
    }

    public static class 各種getterのテスト extends DbaTestBase {
        //TODO #52997
        //各種getterのテストを実装します。
        //1, コンストラクタに渡すModelのgetXX()と、Modelを受け取ってインスタンスを生成したHihokenshaDaichoのgetXX()が、同じ値を返すことをテストします。
        //2, 1のテストを、HihokenshaDaichoが持つ全てのgetXX()について行ってください。
    }

}
