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
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyufuSeigenEditorBaseTest {

    //TODO n8178 城間篤人
    //帳票ソースクラスで、分岐のある編集についてテストを行っている。
    //以下のような手順で実装を行う。
    //
    //1, 業務コンフィグのMockを作成し、分岐に必要な条件を設定する。
    //2, 帳票ソースを作成する上で必要になる、テスト用のModel（jp.co.ndensan.reams.db.dba.model.HihokenshashoModel）を作成する。
    //3, 上記1, 2,を用いて、メソッド名に記述されている内容についてテストを実装する。
    //
    public static class 要介護認定の期限切れによる_認定情報の表示非表示切替 extends DbaTestBase {

        //TODO
        //1, DBA業務コンフィグ：被保険者証表示方法_要介護認定期限切れ_表示有無の値を取得する。
        //2, 以下のテストを行う。
        //  2-1, 要介護認定期限切れ_表示有無の値が1の場合
        //      2-1-1, 認定期限が切れている場合
        //             KyufuSeigenEditorで扱う項目について、認定が期限切れであっても全て印字可能とする。
        //      2-1-2, 認定期間中の場合
        //             KyufuSeigenEditorで扱う項目について、全て印字可能とする。
        //  2-2, 要介護認定期限切れ_表示有無の値が0の場合
        //      2-2-1, 認定期限が切れている場合
        //             KyufuSeigenEditorで扱う項目について、全て印字しない。
        //             (Editorで行う処理をスキップする)
        //      2-2-2, 認定期間中の場合
        //             KyufuSeigenEditorで扱う項目について、認定が期限切れであっても全て印字可能とする。
    }

    public static class 居宅支援事業者適用切れによる_居宅支援事業者情報の表示切替 extends DbaTestBase {

        //TODO
        //1, DBA業務コンフィグ：被保険者証表示方法_居宅支援事業者適用切れ_表示有無の値を取得する。
        //2, 以下のテストを行う。
        //  2-1, 居宅支援事業者適用切れ_表示有無の値が1の場合
        //      2-1-1, 適用が切れている場合
        //             居宅介護支援事業者及びその事業者の名称で印字する項目について、適用切れであっても印字可能とする。
        //      2-1-2, 適用中の場合
        //             居宅介護支援事業者及びその事業者の名称で印字する項目について印字可能とする。
        //  2-1, 居宅支援事業者適用切れ_表示有無の値が0の場合
        //      2-2-1, 適用が切れている場合
        //             居宅介護支援事業者及びその事業者の名称で印字する項目について印字しない。
        //             (居宅支援事業者情報を印字するための帳票ソースに対するデータ設定をスキップする)
        //      2-2-2, 適用中の場合
        //             居宅介護支援事業者及びその事業者の名称で印字する項目について印字可能とする。
    }

    public static class 居宅支援事業者情報の表示方法 extends DbaTestBase {
        //TODO
        //
        //1, DBA業務コンフィグ：被保険者証表示方法_居宅支援事業者履歴_表示方法の値を取得する。
        //2, 居宅支援事業者履歴_表示方法が持つ値について、以下のテストを行う。
        //  2-1, 居宅支援事業者履歴_表示方法の値が0の場合
        //       履歴情報をそのまま印字する。
        //  2-2, 居宅支援事業者履歴_表示方法の値が1の場合
        //       履歴情報を印字しない。
        //  2-3, 居宅支援事業者履歴_表示方法の値が2の場合
        //       履歴情報を印字する。
        //       また、印字される履歴情報の2倍の文字数のアスタリスクを、gyoshaXXAsaに対して設定する。
        //  2-4, 居宅支援事業者履歴_表示方法の値が3の場合
        //       履歴情報を、抹消線を引いた状態で印字する。（gyoshaXXMasshoに対して値を設定する）
        //
        //3, 居宅介護支援事業者情報の文字数について、以下のテストを行う。
        //  3-1, 文字数が40以下の場合、gyoshaXXという名称のオブジェクトに対して値が設定される。
        //  3-2, 文字数が41以下の場合、itakuGyoshaXXという名称のオブジェクトに対して値が設定される。
        //
        //
        //
        //1, 2, のテストは、履歴情報を印字するオブジェクトに対してテストする。
        //（3件まで印字可能な居宅支援事業者情報のうちの、最新ではない情報（2,3件目）について）
    }

    public static class 居宅支援事業者_届出日印字切替 extends DbaTestBase {
        //TODO
        //1, DBA業務コンフィグ：被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分の値を取得する。
        //2, 適用開始日切替表示区分が持つ値について、以下のテストを行う。
        //  2-1, 適用開始日切替表示区分の値が0の場合
        //       届出日を印字する情報として設定する。
        //  2-2, 適用開始日切替表示区分の値が1の場合
        //       適用開始日を印字する情報として設定する。
    }

    public static class 給付制限の印字 extends DbaTestBase {
        //TODO
        //以下についてテストする。
        //1, 給付制限について、開始年月日で降順ソートされていることを確認する。
        //2, 給付制限情報が印字上限の3件より多い場合
        //  2-1, 開始年月日で降順ソートを行い、上位3件のみを印字し、残りは印字対象にならない。
    }

    public static class 居宅介護支援事業者情報の印字 extends DbaTestBase {
        //TODO
        //以下についてテストする。
        //1, 居宅支援事業者の適用年月日で降順ソートされていることを確認する。
        //2, 居宅支援事業者情報が印字上限の3件より多い場合
        //  2-1, 適用年月日で降順ソートを行い、上位3件のみを印字し、残りは印字対象にならない。
    }

    public static class 施設情報の印字 extends DbaTestBase {
        //TODO
        //以下についてテストする。
        //1, 施設入所日で降順ソートされていることを確認する。
        //2, 介護保険施設情報が印字上限の2件より多い場合
        //  2-1, 施設入所日で降順ソートを行い、上位2件のみを印字し、残りは印字対象にならない。
    }

}
