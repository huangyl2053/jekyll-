/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate.shafukukeigengaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.shafukukeigengaku.ShafukuKeigenGakuRealtEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払請求社会福祉法人軽減額クラスです。
 *
 * @author ZHANGGP
 */
public class ShafukuKeigenGakuFinder {

    private final DbT3051ShokanShakaiFukushiHojinKeigengakuDac dbT3051Dac;

    /**
     * コンストラクタです。
     */
    ShafukuKeigenGakuFinder() {
        this.dbT3051Dac = InstanceProvider.create(DbT3051ShokanShakaiFukushiHojinKeigengakuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT3051Dac dbT3051Dac
     */
    ShafukuKeigenGakuFinder(
            DbT3051ShokanShakaiFukushiHojinKeigengakuDac dbT3051Dac
    ) {
        this.dbT3051Dac = dbT3051Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShafukuKeigenGakuFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShafukuKeigenGakuFinder}のインスタンス
     */
    public static ShafukuKeigenGakuFinder createInstance() {
        return InstanceProvider.create(ShafukuKeigenGakuFinder.class);
    }

    /**
     * 社福軽減額データの取得します。
     *
     * @return List<ShafukuKeigenGaku>
     */
    public List<ShafukuKeigenGakuRealtEntity> getAll() {
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> entityList = dbT3051Dac.selectAll();
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShafukuKeigenGakuRealtEntity> shaList = new ArrayList<>();
        for (DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity : entityList) {
            shaList.add(new ShafukuKeigenGakuRealtEntity(entity));
        }
        return shaList;
    }

    /**
     * 社福軽減額データの取得します。
     *
     * @return ShafukuKeigenGaku
     */
    public ShafukuKeigenGakuRealtEntity getSeikyuShakaifukushiHoujinKeigengaku() {
        // ShafukuKeigenGakuParameter parameter  = ShafukuKeigenGakuParameter.
        // 被保険者番号 = 引き継ぎデータEntity．被保険者番号
        // サービス年月 = 引き継ぎデータEntity．サービス年月
        // 整理番号 = 引き継ぎデータEntity．整理番号
        // 事業者番号 = 引き継ぎデータEntity．事業者番号
        // 明細番号 = 引き継ぎデータEntity．明細番号
        // 様式番号 = 申請書検索ViewSate．様式番号
        // 入力．連番
        // DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity = dbT3051Dac.getPanelShakaiFukushiShokai(parameter.getxxx);
        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity(); // TODO QA:78
        return new ShafukuKeigenGakuRealtEntity(entity);
    }
}
