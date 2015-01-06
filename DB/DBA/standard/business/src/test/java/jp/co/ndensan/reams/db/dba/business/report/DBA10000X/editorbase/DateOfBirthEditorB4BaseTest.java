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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.DateOfBirthEditorB4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DateOfBirthEditorB4BaseTest {

    public static class 生年月日の印字切り替え extends DbaTestBase {

        //TODO
        //1, 以下の値を取得する。
        //  1-2, Hihokenshaの個人情報（IKojin）が持つ生年月日
        //  1-2, Hihokenshaの個人情報（IKojin）が持つ住民種別（実際には、IKojinに用意されているis日本人、is外国人を使用する）
        //2, 取得した値を組み合わせて、以下のテストを行う。
        //  2-1, 日本人の場合
        //      2-1-1, 明治生まれの場合、大正・昭和に"*"を設定する。また、生年月日を和暦表示する。
        //      2-1-1, 大正生まれの場合、明治・昭和に"*"を設定する。また、生年月日を和暦表示する。
        //      2-1-1, 昭和生まれの場合、明治・大正に"*"を設定する。また、生年月日を和暦表示する。
        //      2-1-1, 上記以外の元号に生まれた場合、元号に対しては何も印字しない。生年月日は西暦で表示する。
        //  2-2, 外国人の場合
        //      2-1-1, 明治・大正・昭和の全てに"*"を設定する。生年月日は西暦で表示する。
    }

}
