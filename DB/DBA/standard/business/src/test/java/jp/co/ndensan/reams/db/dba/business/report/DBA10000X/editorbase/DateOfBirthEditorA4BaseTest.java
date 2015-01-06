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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.DateOfBirthEditorA4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class DateOfBirthEditorA4BaseTest {

    public static class 生年月日の印字切り替え extends DbaTestBase {

        //TODO
        //1, 以下の値を取得する。
        //  1-2, Hihokenshaの個人情報（IKojin）が持つ生年月日
        //  1-2, Hihokenshaの個人情報（IKojin）が持つ住民種別（実際には、IKojinに用意されているis日本人、is外国人を使用する）
        //2, 取得した値を組み合わせて、以下のテストを行う。
        //1, 被保険者が日本人の場合
        //  1-1, 以下の項目に生年月日の元号を設定する。
        //      source.umareG
        //  1-2, 以下の項目に生年月日の年を、和暦で設定する。
        //      source.umareYy
        //
        //2, 被保険者が外国人の場合
        //  2-1, 以下の項目に生年月日の年を、西暦で設定する。
        //      source.umareYyyy1
        //
        //3, 以下の項目に、生年月日の月日を設定する。
        //source.umareMm
        //source.umareDd
    }

}
