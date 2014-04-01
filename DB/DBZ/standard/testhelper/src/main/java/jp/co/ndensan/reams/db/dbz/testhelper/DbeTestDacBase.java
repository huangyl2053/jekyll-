package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * {@link TestDacBase}のラッパークラスです。
 *
 * @author N1013 松本直樹
 */
public class DbeTestDacBase extends TestDacBase3 {

    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    @Override
    public RString getSubGyomuCD() {
        return new RString("DBE");
    }

    /**
     * ダミーのControlDataを作成します。<br/>
     * DBセッションを開き、sqlSessionオブジェクトにDBセッションを代入します。
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("DBE"));
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
