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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.NinteiEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiEditorBaseTest {

    //TODO n8178 城間篤人
    //帳票ソースクラスで、分岐のある編集についてテストを行っている。
    //以下のような手順で実装を行う。
    //
    //1, 業務コンフィグのMockを作成し、分岐に必要な条件を設定する。
    //2, 帳票ソースを作成する上で必要になる、テスト用のModel（jp.co.ndensan.reams.db.dba.model.HihokenshashoModel）を作成する。
    //3, 上記1, 2,を用いて、メソッド名に記述されている内容についてテストを実装する。
    //
    public static class 要介護認定の期限切れによる_認定情報の表示非表示切り替え extends DbaTestBase {

        //TODO
        //1, DBA業務コンフィグ：被保険者証表示方法_要介護認定期限切れ_表示有無の値を取得する。
        //2, 以下のテストを行う。
        //  2-1, 要介護認定期限切れ_表示有無の値が1の場合
        //      2-1-1, 認定期限が切れている場合
        //             NinteiEditorで扱う項目について、認定が期限切れであっても全て印字可能とする。
        //      2-1-2, 認定期間中の場合
        //             NinteiEditorで扱う項目について、全て印字可能とする。
        //  2-2, 要介護認定期限切れ_表示有無の値が0の場合
        //      2-2-1, 認定期限が切れている場合
        //             NinteiEditorで扱う項目について、全て印字しない。
        //             (Editorで行う処理をスキップする)
        //      2-2-2, 認定期間中の場合
        //             NinteiEditorで扱う項目について、認定が期限切れであっても全て印字可能とする。
    }

    public static class 居宅サービス_うち種類支給限度基準額の印字 extends DbaTestBase {
        //TODO
        //以下についてテストする。
        //1, サービス金額の降順でソートされていることを確認する。
        //2, 居宅サービス情報が印字上限の6件より多い場合
        //  2-1, サービス金額で降順ソートを行い、上位6件のみを印字し、残りは印字対象にならない。
    }

}
