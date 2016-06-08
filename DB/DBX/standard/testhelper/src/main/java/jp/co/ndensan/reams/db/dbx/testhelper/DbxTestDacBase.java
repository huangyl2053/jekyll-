/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * {@link TestDacBase3}のラッパークラスです。<b/>
 * DBXプロジェクトのデータベースに接続するテストはこのクラスを継承してください。
 *
 * @author n9944 趙 春暉
 */
public class DbxTestDacBase extends TestDacBase3 {

    @Override
    public RString getSubGyomuCD() {
        return new RString("DBX");
    }

    /**
     * サブ業務コードがDBXのコントロールデータをセットし、DBセッションを開きます。
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("DBX"));
        openMainSession();
    }

    /**
     * ロールバックします。
     */
    @After
    public void afterTearDown() {
        rollback();
    }

    /**
     * DBセッションを閉じます。
     */
    @AfterClass
    public static void afterTearDownClass() {
        closeSession();
    }
}
