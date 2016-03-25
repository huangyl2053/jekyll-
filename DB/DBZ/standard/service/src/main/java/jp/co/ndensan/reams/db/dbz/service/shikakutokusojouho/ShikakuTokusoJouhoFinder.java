/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.shikakutokusojouho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokusojouho.ShikakuTokusoJouho;
import jp.co.ndensan.reams.db.dbz.definition.shikakutokusojouho.ShikakuTokusoJouhoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutokusojouho.ShikakuTokusouJouhoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.shikakutokusojouho.IShikakuTokusouJouhoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 資格履歴情報のクラスです。
 */
public class ShikakuTokusoJouhoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     *
     *
     */
    ShikakuTokusoJouhoFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShikakuTokusoJouhoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuTokusoJouhoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuTokusoJouhoFinder}のインスタンス
     */
    public static ShikakuTokusoJouhoFinder createInstance() {
        return InstanceProvider.create(ShikakuTokusoJouhoFinder.class);
    }

    /**
     * 資格履歴情報の一覧データ取得リストを取得する。
     *
     * @param params ShikakuTokusoJouhoParameter
     * @return 一覧データ取得取得リスト
     */
    public SearchResult<ShikakuTokusoJouho> getShikakuJoho(ShikakuTokusoJouhoParameter params) {
        if ((params.getHihokenshaNo() == null || params.getHihokenshaNo().isEmpty())
                && (params.getShikibetsuCode() == null || params.getShikibetsuCode().isEmpty())) {
            return SearchResult.of(Collections.<ShikakuTokusoJouho>emptyList(), 0, false);
        }
        IShikakuTokusouJouhoMapper shikakuTokusoMapper = mapperProvider.create(IShikakuTokusouJouhoMapper.class);
        List<ShikakuTokusouJouhoRelateEntity> 一覧データ取得リスト = null;
        if (DonyuKeitaiCode.事務広域.getCode().equals(params.get単一広域区分())) {
            一覧データ取得リスト = shikakuTokusoMapper.getShikakuJoho(params);
        }
        if (DonyuKeitaiCode.事務構成市町村.getCode().equals(params.get単一広域区分())
                || DonyuKeitaiCode.事務単一.getCode().equals(params.get単一広域区分())) {
            一覧データ取得リスト = shikakuTokusoMapper.getShikakuTosoJoho(params);
        }
        List<ShikakuTokusoJouho> serviceShuruiList = new ArrayList<>();
        List<ShikakuTokusouJouhoRelateEntity> 取得日リスト = new ArrayList<>();
        FlexibleDate shikakuShutokuYMDFlag = FlexibleDate.EMPTY;
        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuTokusoJouho>emptyList(), 0, false);
        }
        for (int i = 0; i < 一覧データ取得リスト.size(); i++) {
            if (!shikakuShutokuYMDFlag.equals(一覧データ取得リスト.get(i).getShikakuShutokuYMD())) {
                取得日リスト.add(一覧データ取得リスト.get(i));
                shikakuShutokuYMDFlag = 一覧データ取得リスト.get(i).getShikakuShutokuYMD();
            }
        }
        for (ShikakuTokusouJouhoRelateEntity entity : 取得日リスト) {
            serviceShuruiList.add(new ShikakuTokusoJouho(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }
}
