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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoB4Builder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoB4BuilderTest {

    public static class constructor extends DbaTestBase {
        //TODO
        //引数それぞれについてnullチェックのテストを行う。
    }

    public static class build extends DbaTestBase {
        //TODO
        //1, HihokenshashoB4SourceBuilder, IAtesakiSourceBuilder のMockを作成する。
        //  1-1, HihokenshashoB4SourceBuilderについて、以下の2通りの値を設定する。
        //      印字位置が上部・印字位置が下部
        //2, 上記を元にHihokenshashoB4Builderを生成する。
        //3, 以下の場合についてテストを行う。
        //  3-1, 印字位置が上部の場合、返却された帳票ソースのatesakiSource1に値が入っている（nullでは無い)
        //  3-2, 印字位置が上部以外の場合、返却された帳票ソースのatesakiSource2に値が入っている（nullでは無い)
    }

}
