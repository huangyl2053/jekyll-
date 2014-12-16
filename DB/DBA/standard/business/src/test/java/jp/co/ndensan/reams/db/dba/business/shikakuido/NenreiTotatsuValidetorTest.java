/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.shikakuido;

import jp.co.ndensan.reams.db.dbz.business.config.NenreiTotatsuKijunConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link NenreiTotatsuValidetor}のテストです。
 *
 * @author n8178 城間篤人
 */
//@RunWith(Enclosed.class)
public class NenreiTotatsuValidetorTest {

    public static class validate extends DbaTestBase {
        //TODO #52997
        //バリデーション処理のテストを実装します。
        //1, 取得事由 == 年齢到達 の場合に
        //      年齢が65歳に到達していると、メッセージを保持していない。
        //2, 取得事由 == 年齢到達 の場合に
        //      年齢が65歳に達していない場合、メッセージを返す。
        //3, 取得事由 != 年齢到達 の場合に
        //      年齢が40歳に到達していると、メッセージを保持していない。
        //4, 取得事由 != 年齢到達 の場合に
        //      年齢が40歳に達していない場合、メッセージを返す。
    }

    private static NenreiTotatsuKijunConfig createMockConfig() {
        NenreiTotatsuKijunConfig mock = mock(NenreiTotatsuKijunConfig.class);
        when(mock.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢))
                .thenReturn(65);
        when(mock.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢))
                .thenReturn(40);
        return mock;

    }
}
