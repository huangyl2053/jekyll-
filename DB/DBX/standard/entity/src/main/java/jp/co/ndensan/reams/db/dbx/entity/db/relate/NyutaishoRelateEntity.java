/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 * 入退所(関連)のエンティティクラスです。
 *
 * @author n3331 山邉 大貴
 * @jpName 入退所関連エンティティ
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class NyutaishoRelateEntity {

    private DbT7060KaigoJigyoshaEntity 事業者エンティティ;
    private DbV1004HihokenshaShisetsuNyutaishoEntity 入所者エンティティ;
    private List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティ;
    private DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ;

    /**
     * インスタンスを生成します。
     *
     * @param 事業者エンティティ 事業者エンティティ
     * @param 入所者エンティティ 入所者エンティティ
     * @param 事業者指定サービスエンティティ 事業者指定サービスエンティティ
     * @param 事業者代表者エンティティ 事業者代表者エンティティ
     */
    public NyutaishoRelateEntity(DbT7060KaigoJigyoshaEntity 事業者エンティティ,
            DbV1004HihokenshaShisetsuNyutaishoEntity 入所者エンティティ,
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティ,
            DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ) {

        this.事業者エンティティ = 事業者エンティティ;
        this.入所者エンティティ = 入所者エンティティ;
        this.事業者指定サービスエンティティ = 事業者指定サービスエンティティ;
        this.事業者代表者エンティティ = 事業者代表者エンティティ;
    }

    /**
     * 入所者エンティティを取得する。
     *
     * @return 施設入所者エンティティ
     */
    public DbV1004HihokenshaShisetsuNyutaishoEntity get入所者エンティティ() {
        return this.入所者エンティティ;
    }

    /**
     * 事業者エンティティを取得する。
     *
     * @return 事業者エンティティ
     */
    public DbT7060KaigoJigyoshaEntity get事業者エンティティ() {
        return this.事業者エンティティ;
    }

    /**
     * 事業者指定サービスエンティティを取得する。
     *
     * @return 事業者指定サービスエンティティ
     */
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> get事業者指定サービスエンティティ() {
        return this.事業者指定サービスエンティティ;
    }

    /**
     * 事業者代表者エンティティを取得する。
     *
     * @return 事業者代表者エンティティ
     */
    public DbT7062KaigoJigyoshaDaihyoshaEntity get事業者代表者エンティティ() {
        return this.事業者代表者エンティティ;
    }

    /**
     * 入所者エンティティを設定する。
     *
     * @param 入所者エンティティ 入所者エンティティ
     */
    public void set入所者エンティティ(DbV1004HihokenshaShisetsuNyutaishoEntity 入所者エンティティ) {
        this.入所者エンティティ = 入所者エンティティ;
    }

    /**
     * 事業者エンティティを設定する。
     *
     * @param 事業者エンティティ 事業者エンティティ
     */
    public void set事業者エンティティ(DbT7060KaigoJigyoshaEntity 事業者エンティティ) {
        this.事業者エンティティ = 事業者エンティティ;
    }

    /**
     * 事業者指定サービスエンティティを設定する。
     *
     * @param 事業者指定サービスエンティティ 事業者指定サービスエンティティ
     */
    public void set事業者指定サービスエンティティ(List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティ) {
        this.事業者指定サービスエンティティ = 事業者指定サービスエンティティ;
    }

    /**
     * 事業者代表者エンティティを設定する。
     *
     * @param 事業者代表者エンティティ 事業者代表者エンティティ
     */
    public void set事業者代表者エンティティ(DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ) {
        this.事業者代表者エンティティ = 事業者代表者エンティティ;
    }
}
