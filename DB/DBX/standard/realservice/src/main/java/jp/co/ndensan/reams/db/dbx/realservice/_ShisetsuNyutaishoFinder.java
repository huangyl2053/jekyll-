/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.NyushoJyokyo;
import jp.co.ndensan.reams.db.dbx.entity.relate.NyutaishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.NyutaishoRelateDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設入退所の情報を取得するクラスです。
 *
 * @author n8156 宮本 康
 * @jpName 施設入退所管理
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class _ShisetsuNyutaishoFinder implements IShisetsuNyutaishoFinder {

    private final NyutaishoRelateDac dac;

    /**
     * InstanceProviderを用いてNyutaishoRelateDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public _ShisetsuNyutaishoFinder() {
        dac = InstanceProvider.create(NyutaishoRelateDac.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac モック入退所関連Dac
     */
    _ShisetsuNyutaishoFinder(NyutaishoRelateDac dac) {
        this.dac = dac;
    }

    @Override
    public List<NyushoJyokyo> get施設入退所ALL(ShikibetsuCode shikibetsuCd) {

        List<NyutaishoRelateEntity> entityList = dac.select(shikibetsuCd);
        List<NyushoJyokyo> list = new ArrayList<>();

        for (NyutaishoRelateEntity relateEntity : entityList) {
            list.add(new NyushoJyokyo(relateEntity.get事業者エンティティ(), relateEntity.get入所者エンティティ()));
        }

        return list;
    }
}
