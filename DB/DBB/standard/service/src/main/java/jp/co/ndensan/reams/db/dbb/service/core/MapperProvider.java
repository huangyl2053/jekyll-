/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core;

import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * sessionからMapperを取得するクラスです。
 */
public class MapperProvider {
    //DBZのビルドが通るまで、他サブ業務がMapperProviderを見れないので仮に配置。DBZのエラー解消後に削除予定

    @InjectSession
    private SqlSession session;

    /**
     * sessionからMapperを取得して返します。
     *
     * @param <T> Mapper
     * @param clazz Mapperインタフェース
     * @return Mapper
     */
    @Transaction
    public <T> T create(Class<T> clazz) {
        return this.session.getMapper(clazz);
    }
}
