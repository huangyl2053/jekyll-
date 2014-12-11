/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoValidator} のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuValidatorTest {

    public static class constructor extends DbaTestBase {
        //TODO #52997
        //引数のいずれかにnullが渡された場合のNullCheckについてテストを作成してください。
    }

    public static class validate extends DbaTestBase {
        //TODO #52997
        //バリデーション処理のテストを実装します。
        //
        //HihokenshaDaichoValidatorに用意している、テスト用コンストラクタに対して、DacのMockインスタンスを渡し、
        //それを利用して想定どおりに処理が動いているかのテストを行います。
        //
        //1, 被保険者番号が登録済み ならメッセージを返す。
        //2, 取得日 < 前の履歴データの喪失日 ならメッセージを返す。
        //3, 資格取得対象者の年齢が、資格取得可能 ならメッセージを返す。
        //4, 他市町村住所地特例テーブルに対象者の該当データが存在する時
        //      入力した取得日が、他市町村住所地特例該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
        //5, 適用除外者テーブルに対象者の該当データが存在する時
        //      入力した取得日が、適用除外者該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
        //6, 上記の条件を満たさない場合、メッセージを保持していない。

    }

}
