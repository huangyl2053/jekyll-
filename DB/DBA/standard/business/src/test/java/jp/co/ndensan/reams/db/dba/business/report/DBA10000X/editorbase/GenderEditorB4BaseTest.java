/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.GenderEditorB4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GenderEditorB4BaseTest {

    public static class 性別の印字切り替え extends DbaTestBase {

        //TODO
        //1, 以下の値を取得する。
        //  1-1, HihokenshaShikakuHakkoModel.is性同一性障害用()
        //  1-2, Hihokenshaの個人情報（IKojin）が持つ性別
        //2, 取得した値を組み合わせて、以下のテストを行う。
        //  2-1, 性別が男
        //      2-1-1, 性同一障害の考慮がある場合、性別欄にはEMPTYを設定する。
        //      2-1-2, 性同一障害の考慮が無い場合、seibetsuWoman1に"*"を設定する。
        //  2-2, 性別が女
        //      2-2-1, 性同一障害の考慮がある場合、性別欄にはEMPTYを設定する。
        //      2-2-2, 性同一障害の考慮が無い場合、seibetsuMan1に"*"を設定する。
    }

}
