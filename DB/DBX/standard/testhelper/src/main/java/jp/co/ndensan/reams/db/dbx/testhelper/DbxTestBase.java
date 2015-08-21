/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase3}のラッパークラスです。<br/>
 ** DBXプロジェクトのデータベースに接続しないテストはこのクラスを継承してください。
 *
 * @author n9944 趙 春暉
 */
public class DbxTestBase extends TestBase3 {

    @Override
    public RString getSubGyomuCD() {
        return new RString("DBX");
    }

    /**
     * サブ業務コードがDBXのコントロールデータをセットします。
     */
    @BeforeClass
    public static void beforeSetUpClass() {
        setDummyControlData(new RString("DBX"));
    }
}
