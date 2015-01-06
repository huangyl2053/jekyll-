/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoB4Editor}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoB4EditorTest {

    public static class constructor extends DbaTestBase {
        //TODO
        //1, 引数がnullである場合、NullPointerExceptionが投げられることをテストする。
        //2, 印字位置が指定無しである場合、IllegalArgumentExceptionが投げられることをテストする。
    }

    public static class edit extends DbaTestBase {
        //TODO
        //1, HihokenshashoModelのMockを作成し、被保険者番号を印字位置を設定する。
        //2, editを実行する。
        //3, 印字位置が上部である場合、帳票ソースの上部のデータに値が入っていることをテストする
        //  3-1, HihokenshashoModelのMockに設定した被保険者番号がhihokenshanno1が同値であることを確認する。
        //4, 印字位置が下部である場合、帳票ソースの下部のデータに値が入っていることをテストする
        //  4-1, HihokenshashoModelのMockに設定した被保険者番号とhihokenshanno2が同値であることを確認する。
    }

}
