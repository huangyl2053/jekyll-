/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.iknijuntsukishichosonjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.definition.param.ikninteichosaitakusakijoho.INinteichosaItakusakiJohoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.iknijuntsukishichosonjoho.IKijuntsukiShichosonjohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.ininteichosaitakusakijohomapeer.IKijuntsukiShichosonjohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 調査委託先＆調査員ガイドのクラスです。
 */
public class KijuntsukiShichosonjohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KijuntsukiShichosonjohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    KijuntsukiShichosonjohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KijuntsukiShichosonjohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KijuntsukiShichosonjohoFinder}のインスタンス
     */
    public static KijuntsukiShichosonjohoFinder createInstance() {
        return InstanceProvider.create(KijuntsukiShichosonjohoFinder.class);
    }

    /**
     * 画面の検索条件より、適当な条件を連結して、調査委託先・調査員情報を検索する。
     *
     * @param parametere INinteichosaItakusakiJohoParameter
     * @return 調査委託先調査員情報
     */
    @Transaction
    public SearchResult<KijuntsukiShichosonjoho> getKojinJokyoShokai(INinteichosaItakusakiJohoParameter parametere) {
        requireNonNull(parametere, UrSystemErrorMessages.値がnull.getReplacedMessage("パラメーター"));
        IKijuntsukiShichosonjohoMapper mapper = mapperProvider.create(IKijuntsukiShichosonjohoMapper.class);
        List<IKijuntsukiShichosonjohoRelateEntity> juntsukiShichosonjohoList;
        if (parametere.isSubGyomuCodeFlag()) {
            juntsukiShichosonjohoList = mapper.getKijuntsukiShichoson(parametere);
        } else {
            juntsukiShichosonjohoList = mapper.getKijuntsukiShichosonjoho(parametere);
        }
        List<KijuntsukiShichosonjoho> kojinJokyoShokaiList = new ArrayList();
        for (IKijuntsukiShichosonjohoRelateEntity entity : juntsukiShichosonjohoList) {
            kojinJokyoShokaiList.add(new KijuntsukiShichosonjoho(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }
}
