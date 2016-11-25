/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryodankaijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho.RankJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.HokenryoDankaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.RankJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 保険料ランクの情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoDankaiJoho extends ParentModelBase<HokenryoDankaiJohoIdentifier, DbT2013HokenryoDankaiEntity, HokenryoDankaiJoho>
        implements Serializable {

    private final DbT2013HokenryoDankaiEntity entity;
    private final HokenryoDankaiJohoIdentifier id;
    private final Models<RankJohoIdentifier, RankJoho> rankJoho;

    /**
     * コンストラクタです。<br/>
     * 保険料ランクの情報の新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     */
    public HokenryoDankaiJoho(FlexibleYear 賦課年度,
            RString 段階インデックス,
            RString ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        this.entity = new DbT2013HokenryoDankaiEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setDankaiIndex(段階インデックス);
        this.entity.setRankuKubun(ランク区分);
        this.id = new HokenryoDankaiJohoIdentifier(
                賦課年度,
                段階インデックス,
                ランク区分
        );
        this.rankJoho = Models.create(new ArrayList<RankJoho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link HokenryoDankaiJohoRelateEntity}より{@link HokenryoDankaiJoho}を生成します。
     *
     * @param entity DBより取得した{@link HokenryoDankaiJohoRelateEntity}
     */
    public HokenryoDankaiJoho(HokenryoDankaiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get保険料段階Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("保険料ランクの情報"));
        this.id = new HokenryoDankaiJohoIdentifier(
                entity.get保険料段階Entity().getFukaNendo(),
                entity.get保険料段階Entity().getDankaiIndex(),
                entity.get保険料段階Entity().getRankuKubun());
        List<RankJoho> rankJohoList = new ArrayList<>();
        for (RankJohoEntity rankJohoEntity : entity.getランク情報Entity()) {
            rankJohoList.add(new RankJoho(rankJohoEntity));
        }
        this.rankJoho = Models.create(rankJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2013HokenryoDankaiEntity}
     * @param id {@link HokenryoDankaiJohoIdentifier}
     */
    HokenryoDankaiJoho(
            DbT2013HokenryoDankaiEntity entity,
            HokenryoDankaiJohoIdentifier id,
            Models<RankJohoIdentifier, RankJoho> rankJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.rankJoho = rankJoho;
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
     * 段階インデックスを返します。
     *
     * @return 段階インデックス
     */
    public RString get段階インデックス() {
        return entity.getDankaiIndex();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankuKubun();
    }

    /**
     * 段階区分を返します。
     *
     * @return 段階区分
     */
    public RString get段階区分() {
        return entity.getDankaiKubun();
    }

    /**
     * 保険料率を返します。
     *
     * @return 保険料率
     */
    public Decimal get保険料率() {
        return entity.getHokenryoRitsu();
    }

    /**
     * 特例表記を返します。
     *
     * @return 特例表記
     */
    public RString get特例表記() {
        return entity.getTokureiHyoki();
    }

    /**
     * {@link DbT2013HokenryoDankaiEntity}のクローンを返します。
     *
     * @return {@link DbT2013HokenryoDankaiEntity}のクローン
     */
    @Override
    public DbT2013HokenryoDankaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 保険料ランクの情報の識別子{@link HokenryoDankaiJohoIdentifier}を返します。
     *
     * @return 保険料ランクの情報の識別子{@link HokenryoDankaiJohoIdentifier}
     */
    @Override
    public HokenryoDankaiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保険料ランクの情報配下の要素を削除対象とします。<br/> {@link HokenryoDankaiJohoRelateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 保険料ランクの情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link HokenryoDankaiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link HokenryoDankaiJoho}
     * @throws IllegalStateException DbT2013HokenryoDankaiEntityのデータ状態が変更の場合
     */
    @Override
    public HokenryoDankaiJoho deleted() {
        DbT2013HokenryoDankaiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HokenryoDankaiJoho(
                deletedEntity, id, rankJoho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || rankJoho.hasAnyChanged();
    }

    /**
     * 保険料ランクの情報のみを変更対象とします。<br/> {@link HokenryoDankaiJohoRelateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HokenryoDankaiJoho}
     */
    @Override
    public HokenryoDankaiJoho modifiedModel() {
        DbT2013HokenryoDankaiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HokenryoDankaiJoho(
                modifiedEntity, id, rankJoho);
    }

    /**
     * 保険料ランクの情報が保持するランク情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id ランク情報の識別子
     * @return ランク情報
     * @throws IllegalStateException 指定の識別子に該当するランク情報がない場合
     */
    public RankJoho getRankJoho(RankJohoIdentifier id) {
        if (rankJoho.contains(id)) {
            return rankJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 保険料ランクの情報が保持するランク情報をリストで返します。
     *
     * @return ランク情報リスト
     */
    public List<RankJoho> getRankJohoList() {
        return new ArrayList<>(rankJoho.values());

    }

    /**
     * {@link HokenryoDankaiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link HokenryoDankaiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, rankJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT2013HokenryoDankaiEntity entity;
        private final HokenryoDankaiJohoIdentifier id;
        private final Models<RankJohoIdentifier, RankJoho> rankJoho;

        private _SerializationProxy(
                DbT2013HokenryoDankaiEntity entity,
                HokenryoDankaiJohoIdentifier id,
                Models<RankJohoIdentifier, RankJoho> rankJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.rankJoho = rankJoho;
        }

        private Object readResolve() {
            return new HokenryoDankaiJoho(this.entity, this.id, this.rankJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link HokenryoDankaiJohoBuilder#build()}を使用してください。
     *
     * @return {@link HokenryoDankaiJohoBuilder}
     */
    public HokenryoDankaiJohoBuilder createBuilderForEdit() {
        return new HokenryoDankaiJohoBuilder(entity, id, rankJoho);
    }
}
