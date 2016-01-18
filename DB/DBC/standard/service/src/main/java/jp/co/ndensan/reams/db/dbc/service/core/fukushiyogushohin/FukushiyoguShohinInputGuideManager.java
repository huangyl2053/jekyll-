/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogushohin;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FukushiyoguShohin;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohinEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3117FukushiyoguShohinDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 福祉用具商品名入力ガイドの取得処理です。
 */
public class FukushiyoguShohinInputGuideManager {

    private final DbT3117FukushiyoguShohinDac dbT3117dac;

    /**
     * コンストラクタ
     */
    FukushiyoguShohinInputGuideManager() {
        this.dbT3117dac = InstanceProvider.create(DbT3117FukushiyoguShohinDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 福祉用具商品名入力ガイドdac 福祉用具商品名入力ガイドdac
     */
    FukushiyoguShohinInputGuideManager(
            DbT3117FukushiyoguShohinDac 福祉用具商品名入力ガイドdac
    ) {
        this.dbT3117dac = 福祉用具商品名入力ガイドdac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukushiyoguShohinInputGuideManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link FukushiyoguShohinInputGuideManager}のインスタンス
     */
    public static FukushiyoguShohinInputGuideManager createInstance() {
        return InstanceProvider.create(FukushiyoguShohinInputGuideManager.class);
    }

    /**
     * 福祉用具商品名入力ガイドデータを返します。
     *
     * @param 基準日
     * @return SearchResult<FukushiyoguShohin>
     */
    @Transaction
    public SearchResult<FukushiyoguShohin> getFukushiyoguShohinList(FlexibleDate 基準日) {
        List<FukushiyoguShohin> businessList = new ArrayList<>();
        List<DbT3117FukushiyoguShohinEntity> dbT3117FukushiyoguShohinEntity = dbT3117dac.selectList(基準日);
        for (DbT3117FukushiyoguShohinEntity shoKofuKaishuEntity : dbT3117FukushiyoguShohinEntity) {
            businessList.add(new FukushiyoguShohin(shoKofuKaishuEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 福祉用具商品名入力ガイド{@link FukushiyoguShohin}を保存します。
     *
     * @param 福祉用具商品名入力ガイド {@link FukushiyoguShohin}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDelete(FukushiyoguShohin 福祉用具商品名入力ガイド) {
        requireNonNull(福祉用具商品名入力ガイド, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名入力ガイド"));
        if (!福祉用具商品名入力ガイド.hasChanged()) {
            return false;
        }
        return 1 == dbT3117dac.saveOrDelete(福祉用具商品名入力ガイド.toEntity());
    }
}
