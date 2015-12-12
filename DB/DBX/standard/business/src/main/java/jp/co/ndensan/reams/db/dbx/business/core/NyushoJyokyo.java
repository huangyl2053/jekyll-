/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 施設入退所の情報を保持するクラスです。
 *
 * @author n3331 山邉 大貴
 * @jpName 入所住居
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class NyushoJyokyo {

    private final DbT7060KaigoJigyoshaEntity jigyoshaEntity;
    private final DbV1004HihokenshaShisetsuNyutaishoEntity nyutaishoEntity;

    private NyushoJyokyo() {
        this.jigyoshaEntity = new DbT7060KaigoJigyoshaEntity();
        this.nyutaishoEntity = new DbV1004HihokenshaShisetsuNyutaishoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param jigyoshaEntity 介護事業者エンティティ
     * @param nyutaishoEntity 施設入退所エンティティ
     */
    public NyushoJyokyo(DbT7060KaigoJigyoshaEntity jigyoshaEntity, DbV1004HihokenshaShisetsuNyutaishoEntity nyutaishoEntity) {
        this.jigyoshaEntity = requireNonNull(jigyoshaEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        this.nyutaishoEntity = requireNonNull(nyutaishoEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("施設入退所"));
    }

    /**
     * 入所期間を取得します。
     *
     * @return 入所期間
     */
    public Range<FlexibleDate> get入所期間() {
        return new Range<>(this.nyutaishoEntity.getNyushoYMD(), this.nyutaishoEntity.getTaishoYMD());
    }

    /**
     * 事業者を取得します。
     *
     * @return 事業者
     */
    public IKaigoJigyosha get事業者() {
        //TODO n3317塚田萌　介護事業者の新ビジネス対応が完了したらentityを引数にkaigoJigyoshaクラスを生成して返す
//        return this.jigyoshaEntity;
        return null;
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.nyutaishoEntity.getShikibetsuCode();
    }

    /**
     * DbT7060KaigoJigyoshaEntity。
     *
     * @return jigyoshaEntity
     */
    public DbT7060KaigoJigyoshaEntity getJigyoshaEntity() {
        return jigyoshaEntity;
    }
}
