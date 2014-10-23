/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoList}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoListTest {

    public static class constructor extends DbaTestBase {
        //TODO #52997
        //コンストラクタのテストを実装します。
        //1, nullCheckについてテストします。
    }

    public static class to資格得喪List extends DbaTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
        //
        //例：9件のテストデータを用意してto資格得喪Listを実行 →　9件のテストデータの1番目と3番目と5番目を持つListが戻り値となる場合
        //1, to資格得喪Listのsizeは3となるか。
        //2, テスト用の被保険者台帳Listの1番目の要素が持つキー項目と、戻り値のListの1番目の要素が持つキー項目は一致するか。
        //3, テスト用の被保険者台帳Listの3番目の要素が持つキー項目と、戻り値のListの2番目の要素が持つキー項目は一致するか。
        //4, テスト用の被保険者台帳Listの5番目の要素が持つキー項目と、戻り値のListの3番目の要素が持つキー項目は一致するか。
    }

    public static class to住所地特例List extends DbaTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
    }

    public static class to資格関連異動List extends DbaTestBase {
        //TODO #52997
        //テスト用の被保険者台帳Listを用意し、to資格得喪Listを実行します。
        //実行した結果の戻り値が、想定した結果になっているかをテストしてください。
    }

    public static class toModelList extends DbaTestBase {
        //TODO #52997
        //引数から受け取るModelListと、toModelListを実行して受け取るModelListを大きさを比較してテストします。
        //1, コンストラクタの引数から受け取るModelListと、toModeListの戻り値は、sizeが一致するか。
        //2, 空のModelListからインスタンスを生成した場合、toModelListの戻り値はemptyとなるか。
    }

}
