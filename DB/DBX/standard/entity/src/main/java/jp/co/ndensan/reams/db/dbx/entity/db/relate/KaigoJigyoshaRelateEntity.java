/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 介護事業者関連エンティティクラスです。
 *
 * @author n3423 樋木 隆真
 * @jpName 介護事業者関連エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaRelateEntity implements Cloneable, Serializable {

    private DbT7060KaigoJigyoshaEntity 事業者エンティティ;
    private DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ;
    private List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティリスト;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaRelateEntity() {
        this.事業者エンティティ = new DbT7060KaigoJigyoshaEntity();
        this.事業者代表者エンティティ = new DbT7062KaigoJigyoshaDaihyoshaEntity();
        this.事業者指定サービスエンティティリスト = new ArrayList<>();
    }

    /**
     * コンストラクタです。
     *
     * @param 事業者エンティティ 事業者エンティティ
     * @param 事業者代表者エンティティ 事業者代表者エンティティ
     * @param 事業者指定サービスエンティティリスト 事業者指定サービスエンティティリスト
     */
    public KaigoJigyoshaRelateEntity(DbT7060KaigoJigyoshaEntity 事業者エンティティ,
            DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ,
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティリスト) {

        this.事業者エンティティ = 事業者エンティティ;
        this.事業者代表者エンティティ = 事業者代表者エンティティ;
        this.事業者指定サービスエンティティリスト = 事業者指定サービスエンティティリスト;
    }

    /**
     * 事業者エンティティを取得します。
     *
     * @return 事業者エンティティ
     */
    public DbT7060KaigoJigyoshaEntity get事業者エンティティ() {
        return this.事業者エンティティ;
    }

    /**
     * 事業者代表者エンティティを取得します。
     *
     * @return 事業者代表者エンティティ
     */
    public DbT7062KaigoJigyoshaDaihyoshaEntity get事業者代表者エンティティ() {
        return this.事業者代表者エンティティ;
    }

    /**
     * 事業者指定サービスエンティティリストを取得します。
     *
     * @return 事業者指定サービスエンティティリスト
     */
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> get事業者指定サービスエンティティリスト() {
        return this.事業者指定サービスエンティティリスト;
    }

    /**
     * 事業者エンティティを設定します。
     *
     * @param 事業者エンティティ 事業者エンティティ
     */
    public void set事業者エンティティ(DbT7060KaigoJigyoshaEntity 事業者エンティティ) {
        this.事業者エンティティ = 事業者エンティティ;
    }

    /**
     * 事業者代表者エンティティを設定します。
     *
     * @param 事業者代表者エンティティ 事業者代表者エンティティ
     */
    public void set事業者代表者エンティティ(DbT7062KaigoJigyoshaDaihyoshaEntity 事業者代表者エンティティ) {
        this.事業者代表者エンティティ = 事業者代表者エンティティ;
    }

    /**
     * 事業者指定サービスエンティティリストを設定します。
     *
     * @param 事業者指定サービスエンティティリスト 事業者指定サービスエンティティリスト
     */
    public void set事業者指定サービスエンティティリスト(List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者指定サービスエンティティリスト) {
        this.事業者指定サービスエンティティリスト = 事業者指定サービスエンティティリスト;
    }

    @Override
    @SuppressWarnings("CloneDeclaresCloneNotSupported")
    public KaigoJigyoshaRelateEntity clone() {
        try {
            KaigoJigyoshaRelateEntity self = (KaigoJigyoshaRelateEntity) super.clone();
            self.事業者エンティティ = (DbT7060KaigoJigyoshaEntity) this.事業者エンティティ.clone();
            self.事業者代表者エンティティ = (DbT7062KaigoJigyoshaDaihyoshaEntity) this.事業者代表者エンティティ.clone();
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> new事業者指定サービスエンティティリスト = new ArrayList<>();
            for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : self.事業者指定サービスエンティティリスト) {
                new事業者指定サービスエンティティリスト.add((DbT7063KaigoJigyoshaShiteiServiceEntity) entity.clone());
            }
            self.事業者指定サービスエンティティリスト = new事業者指定サービスエンティティリスト;
            return self;
        } catch (CloneNotSupportedException ex) {
            throw new SystemException("Cloning failed.");
        }
    }
}
