/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core;

import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import org.apache.ibatis.session.ResultHandler;

/**
 * カーソルオープンするための、MapperProviderです。<br/>
 * リアル処理でカーソルを利用したい、特殊な状況において使います。
 */
public class CursorMapperProvider {

    @InjectSession
    private SqlSession session;

    /**
     * Mapperを呼び出し、カーソルオープンします。
     *
     * @param statement 呼び出したいMapperのsqlタグのid。通常はMapper.javaのメソッド名
     * @param parameter Mapperに引き渡す引数
     * @param handler カーソルループの処理本体
     */
    @Transaction
    public void select(RString statement, Object parameter, ResultHandler handler) {
        this.session.select(statement.toString(), parameter, handler);
    }
}
