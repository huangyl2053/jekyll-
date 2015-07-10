/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuShutokuKanrenJohoDac}のテストです。
 *
 * @author n8178 城間篤人
 */
//@RunWith(Enclosed.class)
public class ShikakuShutokuKanrenJohoDacTest {

    public static class insertOrUpdateOrDelete extends DbaTestDacBase {

        //TODO #52997
        //1つのトランザクションで全ての要素が保存されることをテストしてください。
        //1, Modelに含まれる要素が保存されているか
        //      各テーブルの要素について、保存されているかどうかを最低1つ確認してください。
        //2, 登録処理に失敗した場合にロールバックが実行されるか
        //      例：合計10件のデータを保存しようとして、6件目の登録に失敗して処理が終了した場合
        //          1～5件目の要素が、ロールバックによって登録する前の状態に戻っていることを確認する。
    }

}
