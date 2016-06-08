/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRankIdentifier;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ランク情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class RankJoho extends ModelBase<RankJohoIdentifier, DbT2011RankJohoEntity, RankJoho> implements Serializable {

    private final DbT2011RankJohoEntity entity;
    private final RankJohoIdentifier id;
    private final Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank;

    /**
     * コンストラクタです。<br/>
     * ランク情報の新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     */
    public RankJoho(FlexibleYear 賦課年度,
            RString ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        this.entity = new DbT2011RankJohoEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setRankKubun(ランク区分);
        this.id = new RankJohoIdentifier(
                賦課年度,
                ランク区分
        );

        this.hokenryoRank = Models.create(new ArrayList<HokenryoRank>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link RankJohoEntity}より{@link RankJoho}を生成します。
     *
     * @param entity DBより取得した{@link RankJohoEntity}
     */
    public RankJoho(RankJohoEntity entity) {
        this.entity = requireNonNull(entity.getランク情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報"));
        this.id = new RankJohoIdentifier(
                entity.getランク情報Entity().getFukaNendo(),
                entity.getランク情報Entity().getRankKubun());
        List<HokenryoRank> hokenryoRankList = new ArrayList<>();
        for (DbT2012HokenryoRankEntity dbT2012Entity : entity.get保険料ランクEntity()) {
            hokenryoRankList.add(new HokenryoRank(dbT2012Entity));
        }
        this.hokenryoRank = Models.create(hokenryoRankList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2011RankJohoEntity}
     * @param id {@link RankJohoIdentifier}
     * @param hokenryoRank {@link Models<HokenryoRankIdentifier, HokenryoRank>}
     */
    RankJoho(
            DbT2011RankJohoEntity entity,
            RankJohoIdentifier id,
            Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank
    ) {
        this.entity = entity;
        this.id = id;
        this.hokenryoRank = hokenryoRank;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankKubun();
    }

    /**
     * ランク名称を返します。
     *
     * @return ランク名称
     */
    public RString getランク名称() {
        return entity.getRankName();
    }

    /**
     * 賦課の情報が保持する保険料ランク情報に対して、指定の識別子に該当する保険料ランク情報を返します。
     *
     * @param id 保険料ランクの識別子
     * @return 保険料ランク情報
     * @throws IllegalStateException 指定の識別子に該当する保険料ランク情報がない場合
     */
    public HokenryoRank getHokenryoRank(HokenryoRankIdentifier id) {
        if (hokenryoRank.contains(id)) {
            return hokenryoRank.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 賦課の情報が保持する保険料ランク情報リストで返します。
     *
     * @return 保険料ランク情報リスト
     */
    public List<HokenryoRank> getHokenryoRankList() {
        return new ArrayList<>(hokenryoRank.values());

    }

    /**
     * {@link DbT2011RankJohoEntity}のクローンを返します。
     *
     * @return {@link DbT2011RankJohoEntity}のクローン
     */
    @Override
    public DbT2011RankJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * ランク情報の識別子{@link RankJohoIdentifier}を返します。
     *
     * @return ランク情報の識別子{@link RankJohoIdentifier}
     */
    @Override
    public RankJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * ランク情報のみを変更対象とします。<br/> {@link DbT2011RankJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RankJoho}
     */
    public RankJoho modifiedModel() {
        DbT2011RankJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RankJoho(
                modifiedEntity, id, hokenryoRank);
    }

    /**
     * 保持するランク情報を削除対象とします。<br/> {@link DbT2011RankJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RankJoho}
     */
    @Override
    public RankJoho deleted() {
        DbT2011RankJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RankJoho(deletedEntity, id, hokenryoRank);
    }

    /**
     * {@link RankJoho}のシリアライズ形式を提供します。
     *
     * @return {@link RankJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, hokenryoRank);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() | hokenryoRank.hasAnyChanged();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2737762328932510432L;
        private final DbT2011RankJohoEntity entity;
        private final RankJohoIdentifier id;
        private final Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank;

        private _SerializationProxy(DbT2011RankJohoEntity entity,
                RankJohoIdentifier id,
                Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank) {
            this.entity = entity;
            this.id = id;
            this.hokenryoRank = hokenryoRank;
        }

        private Object readResolve() {
            return new RankJoho(this.entity, this.id, this.hokenryoRank);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.entity);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.hokenryoRank);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RankJoho other = (RankJoho) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.hokenryoRank, other.hokenryoRank)) {
            return false;
        }
        return true;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RankJohoBuilder createBuilderForEdit() {
        return new RankJohoBuilder(entity, id, hokenryoRank);
    }
}
