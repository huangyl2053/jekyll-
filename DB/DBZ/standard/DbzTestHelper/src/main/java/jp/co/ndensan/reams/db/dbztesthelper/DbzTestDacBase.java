/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbztesthelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;

/**
 * {@link TestDacBase}のラッパークラスです。<br />
 * DBZプロジェクトのデータベースに接続するテストはこのクラスを継承してください。
 *
 * @author N1013 松本直樹
 */
public class DbzTestDacBase extends TestBase {

    /**
     * サブ業務コードを指定します
     *
     * @return サブ業務コード
     */
    public RString getSubGyomuCD() {
        return new RString("DBZ");
    }
}
