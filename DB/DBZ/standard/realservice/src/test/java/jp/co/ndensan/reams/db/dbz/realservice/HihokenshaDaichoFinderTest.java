/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoFinder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoFinderTest {

    public static class find被保険者台帳 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

    public static class find被保険者台帳List__市町村コード_被保険者番号を引数で受け取る場合 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
        //
        //例：
        //1, 3件のListを返すMockDacを用意。
        //2, MockDacをテスト用コンストラクタに渡して、HihokenshaDaichoFinderのインスタンスを生成。
        //3, get被保険者台帳Listを実行して、3件のListが返るかを確認する。
    }

    public static class find被保険者台帳List__市町村コード_識別コードを引数で受け取る場合 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

    public static class find被保険者台帳List__市町村コード_被保険者番号_資格取得日を引数で受け取る場合 extends DbaTestBase {
        //TODO #52997
        //Dacが想定どおりに呼び出せていることをテストします。
        //テスト用コンストラクタから、処理が通るように作成したMockDacを渡して、想定どおりの戻り値が返るかどうかのテストを作成してください。
    }

}
