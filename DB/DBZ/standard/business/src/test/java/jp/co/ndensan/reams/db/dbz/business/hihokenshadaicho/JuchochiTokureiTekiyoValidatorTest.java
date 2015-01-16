/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JuchochiTokureiTekiyoValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JuchochiTokureiTekiyoValidatorTest {

    public static class setTekiyoDate extends DbzTestBase {

        //TODO #55852
        //適用日にnullが渡された場合のテストを行う。
        @Test
        public void dummy() {

        }
    }

    public static class setNewestHihokenshaDaicho extends DbzTestBase {

        //TODO #55852
        //被保険者DaichoModelにnullが渡された場合のテストを行う。
        @Test
        public void dummy() {

        }
    }

    public static class validate extends DbzTestBase {

        //TODO #55852
        //バリデーション処理のテストを実装する。
        //１）適用日 ＜ 最新履歴データの資格取得日 を満たす場合、メッセージを返す。
        //２）適用日 ＜ 最新履歴データの資格変更日 を満たす場合、メッセージを返す。
        //３）適用日 ＜ 最新履歴データの住所地特例解除日 を満たす場合、メッセージを返す。
        //４）上記の条件を満たさない場合、メッセージを保持していない。
        @Test
        public void dummy() {

        }
    }

}
