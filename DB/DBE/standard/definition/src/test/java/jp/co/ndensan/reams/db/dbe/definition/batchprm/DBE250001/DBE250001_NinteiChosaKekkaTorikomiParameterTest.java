/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization._JsonSerializer;
import org.junit.Test;

/**
 *
 * @author N3327 三浦 凌
 */
public class DBE250001_NinteiChosaKekkaTorikomiParameterTest {

    public DBE250001_NinteiChosaKekkaTorikomiParameterTest() {
    }

    @Test
    public void testToOcrDataReadProcessParameter() {
        DBE250002_ImageTorikomiParameter param = _JsonSerializer.deSerialize("{\"共有ファイルエントリ情報文字列\":\"DB|イメージ取込み|2017-02-07T19:40:25.389406\",\"一次判定済み時処理方法\":\"エラーとする\",\"主治医不一致時処理方法\":\"エラーとする\",\"displayJobName\":null}", DBE250002_ImageTorikomiParameter.class);
        System.out.println(param.get一次判定済み時処理方法());
    }

}
