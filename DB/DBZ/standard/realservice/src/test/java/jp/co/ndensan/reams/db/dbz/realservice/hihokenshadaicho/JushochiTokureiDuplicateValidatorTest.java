/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.JushochiTokureiDuplicateValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiDuplicateValidatorTest {

    public static class setHihokenshaDaichoData extends DbzTestBase {
        //TODO #55852
        //１）住所地特例情報にnullが渡された場合のテストを行う。
    }

    public static class validate extends DbzTestBase {
        //TODO #55852
        //バリデーション処理のテストを実装する。
        //１）他市町村住所地特例テーブルに対象者の該当データが存在するとき
        //１－１）入力した適用日と解除日の期間と、他市町村住所地特例該当データの適用日と解除日の期間に重複が有る場合、
        //       メッセージを返す。
        //１－２）入力した適用日と解除日の期間と、他市町村住所地特例該当データの適用日と解除日の期間に重複が無い場合、
        //       メッセージを持たない。
        //２）他市町村住所地特例テーブルに対象者の該当データが存在しないとき
        //    メッセージを持たない。
        //３）適用除外者テーブルに対象者の該当データが存在するとき
        //３－１）入力した適用日と解除日の期間と、適用除外者該当データの適用日と解除日の期間に重複が有る場合、
        //       メッセージを返す。
        //３－２）入力した適用日と解除日の期間と、適用除外者該当データの適用日と解除日の期間に重複が無い場合、
        //       メッセージを持たない。
        //３）適用除外者テーブルに対象者の該当データが存在しない場合
        //    メッセージを持たない。
    }

}
