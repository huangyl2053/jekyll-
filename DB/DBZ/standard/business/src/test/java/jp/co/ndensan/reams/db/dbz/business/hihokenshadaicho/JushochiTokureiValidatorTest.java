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
 * {@link jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JushochiTokureiValidator}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiValidatorTest {

    public static class setJushochiTokureiData extends DbzTestBase {
        //TODO #55852
        //住所地特例情報にnullが渡された場合のテストを行う。
    }

    public static class setJushochiTokureiList extends DbzTestBase {
        //TODO #55852
        //住所地特例Listにnullが渡された場合のテストを行う。
    }

    public static class validate extends DbzTestBase {
        //TODO #55852
        //バリデーション処理のテストを実装する。
        //１）適用日 < 資格得喪情報の取得日 を満たす場合、メッセージを返す。
        //２）資格得喪情報の喪失日 ≦ 適用日 を満たす場合、メッセージを返す。
        //３）解除日≠Empty かつ 解除日 < 適用日 を満たす場合、メッセージを返す。
        //４）解除日≠Empty かつ 資格得喪情報の喪失日 を満たす場合、メッセージを返す。
        //５）登録する情報の適用日・解除日の期間と、住所地特例履歴一覧内の全データの適用日・解除日との比較で重複が有る場合、メッセージを返す。
        //６）上記の条件を満たさない場合、メッセージを保持していない。
    }
}
