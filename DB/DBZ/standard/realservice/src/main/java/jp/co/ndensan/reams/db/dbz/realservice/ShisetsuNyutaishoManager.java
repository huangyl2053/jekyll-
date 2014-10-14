/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaishoList;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.business.mapper.ShisetsuNyutaishoMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設入退所を管理するクラスです
 *
 * @author N3317 塚田 萌
 */
public class ShisetsuNyutaishoManager {

    private final ShisetsuNyutaishoDac dac;
    private final NyushoShisetsuBuilder builder;

    /**
     * デフォルトコンストラクタです。
     */
    public ShisetsuNyutaishoManager() {
        dac = InstanceProvider.create(ShisetsuNyutaishoDac.class);
        builder = new NyushoShisetsuBuilder();
    }

    /**
     * テスト用パッケージプライベートコンストラクタです。
     *
     * @param dac テスト用dac
     * @param builder テスト用builder
     */
    ShisetsuNyutaishoManager(ShisetsuNyutaishoDac dac, NyushoShisetsuBuilder builder) {
        this.dac = dac;
        this.builder = builder;
    }

    /**
     * 引数の施設入退所情報を追加します。
     *
     * @param 施設入退所 追加する施設入退所
     * @return 更新に成功した場合はtrue、失敗した場合はfalseを返します。
     */
    public boolean save(ShisetsuNyutaisho 施設入退所) {
        DbT1004ShisetsuNyutaishoEntity entity
                = ShisetsuNyutaishoMapper.to施設入退所Entity(施設入退所);
        return is更新成功(dac.insert(entity));
    }

    /**
     * 引数の施設入退所情報を論理削除します。
     *
     * @param 施設入退所 削除する施設入退所
     * @return 更新に成功した場合はtrue、失敗した場合はfalseを返します。
     */
    public boolean remove(ShisetsuNyutaisho 施設入退所) {
        DbT1004ShisetsuNyutaishoEntity entity
                = ShisetsuNyutaishoMapper.to施設入退所Entity(施設入退所);
        return is更新成功(dac.delete(entity));
    }

    /**
     * 個人識別コードと基準日を指定して、指定日に対象者が入所していた施設入退所情報を取得します。
     *
     * @param 個人識別コード 個人識別コード
     * @param 基準日 基準日
     * @return 指定日に対象者が入所していた施設入退所情報
     */
    public ShisetsuNyutaisho get施設入退所(ShikibetsuCode 個人識別コード, FlexibleDate 基準日) {
        DbT1004ShisetsuNyutaishoEntity entity = dac.select(個人識別コード, 基準日);

        if (entity == null) {
            return null;
        }
        return ShisetsuNyutaishoMapper.to施設入退所(entity, create入所施設(entity));
    }

    /**
     * 個人識別コードを指定して、対象者の施設入退所履歴を取得します。
     *
     * @param 個人識別コード 個人識別コード
     * @return 対象者の施設入退所履歴
     */
    public ShisetsuNyutaishoList get個人施設入退所履歴(ShikibetsuCode 個人識別コード) {
        List<DbT1004ShisetsuNyutaishoEntity> entities = dac.select(個人識別コード);
        return create施設入退所List(entities);
    }

    /**
     * 個人識別コードと台帳種別を指定して、対象者の台帳別の施設入退所履歴を取得します。
     *
     * @param 個人識別コード 個人識別コード
     * @param 台帳種別 台帳種別
     * @return 対象者の台帳別の施設入退所履歴
     */
    public ShisetsuNyutaishoList get個人台帳別施設入退所履歴(ShikibetsuCode 個人識別コード, DaichoType 台帳種別) {
        List<DbT1004ShisetsuNyutaishoEntity> entities = dac.select(個人識別コード, 台帳種別);
        return create施設入退所List(entities);
    }

    private boolean is更新成功(int 更新件数) {
        return 更新件数 != 0;
    }

    private NyushoShisetsu create入所施設(DbT1004ShisetsuNyutaishoEntity entity) {
        return builder.build入所施設(
                ShisetsuType.toValue(entity.getNyushoShisetsuShurui()),
                new ShisetsuCode(entity.getNyushoShisetsuCode()),
                entity.getNyushoYMD());
    }

    private ShisetsuNyutaishoList create施設入退所List(List<DbT1004ShisetsuNyutaishoEntity> entities) {
        List<NyushoShisetsu> nyushoShisetsuList = new ArrayList<>();

        for (DbT1004ShisetsuNyutaishoEntity entity : entities) {
            nyushoShisetsuList.add(create入所施設(entity));
        }
        return ShisetsuNyutaishoMapper.to施設入退所List(entities, nyushoShisetsuList);
    }
}
