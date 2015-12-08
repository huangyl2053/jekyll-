/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.tashichosonjushochitokurei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.jushochitokurei.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 他市町村住所地特例を管理するクラスです。
 */
public class TashichosonJushochiTokurei
        extends ParentModelBase<TashichosonJushochiTokureiIdentifier, DbT1003TashichosonJushochiTokureiEntity, TashichosonJushochiTokurei>
        implements Serializable {

    private final DbT1003TashichosonJushochiTokureiEntity entity;
    private final TashichosonJushochiTokureiIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

    /**
     * コンストラクタです。<br/>
     * 他市町村住所地特例の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public TashichosonJushochiTokurei(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new DbT1003TashichosonJushochiTokureiEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setIdoYMD(異動日);
        this.entity.setEdaNo(枝番);
        this.id = new TashichosonJushochiTokureiIdentifier(
                識別コード,
                異動日,
                枝番
        );
        this.shisetsuNyutaisho = Models.create(new ArrayList<ShisetsuNyutaisho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1003TashichosonJushochiTokureiEntity}より{@link TashichosonJushochiTokurei}を生成します。
     *
     * @param entity DBより取得した{@link DbT1003TashichosonJushochiTokureiEntity}
     */
    public TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity entity) {
        this.entity = requireNonNull(entity.get他市町村住所地特例Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例"));
        this.id = new TashichosonJushochiTokureiIdentifier(
                entity.get他市町村住所地特例Entity().getShikibetsuCode(),
                entity.get他市町村住所地特例Entity().getIdoYMD(),
                entity.get他市町村住所地特例Entity().getEdaNo());
        List<ShisetsuNyutaisho> shisetsuNyutaishoList = new ArrayList<>();
        for (DbT1004ShisetsuNyutaishoEntity niniEntity : entity.get介護保険施設入退所Entity()) {
            shisetsuNyutaishoList.add(new ShisetsuNyutaisho(niniEntity));
        }
        this.shisetsuNyutaisho = Models.create(shisetsuNyutaishoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1003TashichosonJushochiTokureiEntity}
     * @param id {@link TashichosonJushochiTokureiIdentifier}
     */
    TashichosonJushochiTokurei(
            DbT1003TashichosonJushochiTokureiEntity entity,
            TashichosonJushochiTokureiIdentifier id, Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho
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
     * 他市町村住所地特例適用事由コードを返します。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public KaigoTatokuTekiyoJiyu get他市町村住所地特例適用事由コード() {
        return entity.getTekiyoJiyuCode();
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
     * 他市町村住所地特例解除事由コードを返します。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public KaigoTatokuKaijoJiyu get他市町村住所地特例解除事由コード() {
        return entity.getKaijoJiyuCode();
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
     * 措置保険者番号を返します。
     *
     * @return 措置保険者番号
     */
    public ShoKisaiHokenshaNo get措置保険者番号() {
        return entity.getSochiHokenshaNo();
    }

    /**
     * 措置被保険者番号を返します。
     *
     * @return 措置被保険者番号
     */
    public HihokenshaNo get措置被保険者番号() {
        return entity.getSochiHihokenshaNo();
    }

    /**
     * 他特例連絡票発行年月日を返します。
     *
     * @return 他特例連絡票発行年月日
     */
    public FlexibleDate get他特例連絡票発行年月日() {
        return entity.getTatokuRenrakuhyoHakkoYMD();
    }

    /**
     * 施設退所通知発行年月日を返します。
     *
     * @return 施設退所通知発行年月日
     */
    public FlexibleDate get施設退所通知発行年月日() {
        return entity.getShisetsuTaishoTsuchiHakkoYMD();
    }

    /**
     * 施設変更通知発行年月日を返します。
     *
     * @return 施設変更通知発行年月日
     */
    public FlexibleDate get施設変更通知発行年月日() {
        return entity.getShisetsuHenkoTsuchiHakkoYMD();
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
     * {@link DbT1003TashichosonJushochiTokureiEntity}のクローンを返します。
     *
     * @return {@link DbT1003TashichosonJushochiTokureiEntity}のクローン
     */
    @Override
    public DbT1003TashichosonJushochiTokureiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 他市町村住所地特例の識別子{@link TashichosonJushochiTokureiIdentifier}を返します。
     *
     * @return 他市町村住所地特例の識別子{@link TashichosonJushochiTokureiIdentifier}
     */
    @Override
    public TashichosonJushochiTokureiIdentifier identifier() {
        return this.id;
    }

    /**
     * 他市町村住所地特例配下の要素を削除対象とします。<br/>
     * {@link DbT1003TashichosonJushochiTokureiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 他市町村住所地特例配下の要素である介護保険施設入退所の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link TashichosonJushochiTokurei}を返します。
     *
     * @return 削除対象処理実施後の{@link TashichosonJushochiTokurei}
     * @throws IllegalStateException DbT1003TashichosonJushochiTokureiEntityのデータ状態が変更の場合
     */
    @Override
    public TashichosonJushochiTokurei deleted() {
        DbT1003TashichosonJushochiTokureiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TashichosonJushochiTokurei(
                deletedEntity, id, shisetsuNyutaisho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shisetsuNyutaisho.hasAnyChanged();
    }

    /**
     * 他市町村住所地特例のみを変更対象とします。<br/>
     * {@link DbT1003TashichosonJushochiTokureiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TashichosonJushochiTokurei}
     */
    @Override
    public TashichosonJushochiTokurei modifiedModel() {
        DbT1003TashichosonJushochiTokureiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TashichosonJushochiTokurei(
                modifiedEntity, id, shisetsuNyutaisho);
    }

    /**
     * 他市町村住所地特例が保持する介護保険施設入退所に対して、指定の識別子に該当する介護保険施設入退所を返します。
     *
     * @param id 介護保険施設入退所の識別子
     * @return 介護保険施設入退所
     * @throws IllegalStateException 指定の識別子に該当する介護保険施設入退所がない場合
     */
    public ShisetsuNyutaisho getShisetsuNyutaisho(ShisetsuNyutaishoIdentifier id) {
        if (shisetsuNyutaisho.contains(id)) {
            return shisetsuNyutaisho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 他市町村住所地特例が保持する介護保険施設入退所をリストで返します。
     *
     * @return 介護保険施設入退所リスト
     */
    public List<ShisetsuNyutaisho> getShisetsuNyutaishoList() {
        return new ArrayList<>(shisetsuNyutaisho.values());

    }

    /**
     * {@link TashichosonJushochiTokurei}のシリアライズ形式を提供します。
     *
     * @return {@link TashichosonJushochiTokurei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shisetsuNyutaisho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT1003TashichosonJushochiTokureiEntity entity;
        private final TashichosonJushochiTokureiIdentifier id;
        private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;

        private _SerializationProxy(
                DbT1003TashichosonJushochiTokureiEntity entity,
                TashichosonJushochiTokureiIdentifier id,
                Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho
        ) {
            this.entity = entity;
            this.id = id;
            this.shisetsuNyutaisho = shisetsuNyutaisho;
        }

        private Object readResolve() {
            return new TashichosonJushochiTokurei(this.entity, this.id, this.shisetsuNyutaisho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TashichosonJushochiTokureiBuilder#build()}を使用してください。
     *
     * @return {@link TashichosonJushochiTokureiBuilder}
     */
    public TashichosonJushochiTokureiBuilder createBuilderForEdit() {
        return new TashichosonJushochiTokureiBuilder(entity, id, shisetsuNyutaisho);
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
        final TashichosonJushochiTokurei other = (TashichosonJushochiTokurei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
