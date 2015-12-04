/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaisha extends ParentModelBase<TekiyoJogaishaIdentifier, DbT1002TekiyoJogaishaEntity, TekiyoJogaisha> implements Serializable {

    private final DbT1002TekiyoJogaishaEntity entity;
    private final TekiyoJogaishaIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

    /**
     * コンストラクタです。<br/>
     * 適用除外者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public TekiyoJogaisha(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new DbT1002TekiyoJogaishaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setIdoYMD(異動日);
        this.entity.setEdaNo(枝番);
        this.id = new TekiyoJogaishaIdentifier(
                識別コード,
                異動日,
                枝番
        );
        this.shisetsuNyutaisho = Models.create(new ArrayList<ShisetsuNyutaisho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1002TekiyoJogaishaEntity}より{@link TekiyoJogaisha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1002TekiyoJogaishaEntity}
     */
    public TekiyoJogaisha(TekiyoJogaishaEntity entity) {
        this.entity = requireNonNull(entity.get適用除外者Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者"));
        this.id = new TekiyoJogaishaIdentifier(
                entity.get適用除外者Entity().getShikibetsuCode(),
                entity.get適用除外者Entity().getIdoYMD(),
                entity.get適用除外者Entity().getEdaNo());
        List<ShisetsuNyutaisho> shisetsuNyutaishoList = new ArrayList<>();
        for (DbT1004ShisetsuNyutaishoEntity niniEntity : entity.get介護保険施設入退所Entity()) {
            shisetsuNyutaishoList.add(new ShisetsuNyutaisho(niniEntity));
        }
        this.shisetsuNyutaisho = Models.create(shisetsuNyutaishoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1002TekiyoJogaishaEntity}
     * @param id {@link TekiyoJogaishaIdentifier}
     */
    TekiyoJogaisha(
            DbT1002TekiyoJogaishaEntity entity,
            TekiyoJogaishaIdentifier id,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho
    ) {
        this.entity = entity;
        this.id = id;
        this.shisetsuNyutaisho = shisetsuNyutaisho;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 適用除外適用事由コードを返します。
     *
     * @return 適用除外適用事由コード
     */
    public RString get適用除外適用事由コード() {
        return entity.getTekiyoJogaiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getTekiyoTodokedeYMD();
    }

    /**
     * 適用受付年月日を返します。
     *
     * @return 適用受付年月日
     */
    public FlexibleDate get適用受付年月日() {
        return entity.getTekiyoUketsukeYMD();
    }

    /**
     * 適用除外解除事由コードを返します。
     *
     * @return 適用除外解除事由コード
     */
    public RString get適用除外解除事由コード() {
        return entity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getKaijoTodokedeYMD();
    }

    /**
     * 解除受付年月日を返します。
     *
     * @return 解除受付年月日
     */
    public FlexibleDate get解除受付年月日() {
        return entity.getKaijoUketsukeYMD();
    }

    /**
     * 入所通知発行日を返します。
     *
     * @return 入所通知発行日
     */
    public FlexibleDate get入所通知発行日() {
        return entity.getNyushoTsuchiHakkoYMD();
    }

    /**
     * 退所通知発行日を返します。
     *
     * @return 退所通知発行日
     */
    public FlexibleDate get退所通知発行日() {
        return entity.getTaishoTsuchiHakkoYMD();
    }

    /**
     * 変更通知発行日を返します。
     *
     * @return 変更通知発行日
     */
    public FlexibleDate get変更通知発行日() {
        return entity.getHenkoTsuchiHakkoYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT1002TekiyoJogaishaEntity}のクローンを返します。
     *
     * @return {@link DbT1002TekiyoJogaishaEntity}のクローン
     */
    @Override
    public DbT1002TekiyoJogaishaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 適用除外者の識別子{@link TekiyoJogaishaIdentifier}を返します。
     *
     * @return 適用除外者の識別子{@link TekiyoJogaishaIdentifier}
     */
    @Override
    public TekiyoJogaishaIdentifier identifier() {
        return this.id;
    }

    /**
     * 適用除外者配下の要素を削除対象とします。<br/>
     * {@link DbT1002TekiyoJogaishaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 適用除外者配下の要素である介護保険施設入退所情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link TekiyoJogaisha}を返します。
     *
     * @return 削除対象処理実施後の{@link TekiyoJogaisha}
     * @throws IllegalStateException DbT1002TekiyoJogaishaEntityのデータ状態が変更の場合
     */
    @Override
    public TekiyoJogaisha deleted() {
        DbT1002TekiyoJogaishaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TekiyoJogaisha(
                deletedEntity, id, shisetsuNyutaisho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shisetsuNyutaisho.hasAnyChanged();
    }

    /**
     * 適用除外者のみを変更対象とします。<br/> {@link DbT1002TekiyoJogaishaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TekiyoJogaisha}
     */
    @Override
    public TekiyoJogaisha modifiedModel() {
        DbT1002TekiyoJogaishaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TekiyoJogaisha(
                modifiedEntity, id, shisetsuNyutaisho);
    }

    /**
     * 適用除外者が保持する介護保険施設入退所情報に対して、指定の識別子に該当する介護保険施設入退所情報を返します。
     *
     * @param id 介護保険施設入退所情報の識別子
     * @return 介護保険施設入退所情報
     * @throws IllegalStateException 指定の識別子に該当する介護保険施設入退所情報がない場合
     */
    public ShisetsuNyutaisho getSeishinTechoNini(ShisetsuNyutaishoIdentifier id) {
        if (shisetsuNyutaisho.contains(id)) {
            return shisetsuNyutaisho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 適用除外者が保持する介護保険施設入退所情報をリストで返します。
     *
     * @return 介護保険施設入退所情報リスト
     */
    public List<ShisetsuNyutaisho> getSeishinTechoNiniList() {
        return new ArrayList<>(shisetsuNyutaisho.values());

    }

    /**
     * {@link TekiyoJogaisha}のシリアライズ形式を提供します。
     *
     * @return {@link TekiyoJogaisha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shisetsuNyutaisho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT1002TekiyoJogaishaEntity entity;
        private final TekiyoJogaishaIdentifier id;
        private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

        private _SerializationProxy(
                DbT1002TekiyoJogaishaEntity entity,
                TekiyoJogaishaIdentifier id,
                Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho
        ) {
            this.entity = entity;
            this.id = id;
            this.shisetsuNyutaisho = shisetsuNyutaisho;
        }

        private Object readResolve() {
            return new TekiyoJogaisha(this.entity, this.id, this.shisetsuNyutaisho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TekiyoJogaishaBuilder#build()}を使用してください。
     *
     * @return {@link TekiyoJogaishaBuilder}
     */
    public TekiyoJogaishaBuilder createBuilderForEdit() {
        return new TekiyoJogaishaBuilder(entity, id, shisetsuNyutaisho);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final TekiyoJogaisha other = (TekiyoJogaisha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
