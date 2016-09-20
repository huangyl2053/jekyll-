/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険施設入退所を管理するクラスです。
 */
public class ShisetsuNyutaisho extends
        ModelBase<ShisetsuNyutaishoIdentifier, DbT1004ShisetsuNyutaishoEntity, ShisetsuNyutaisho>
        implements Serializable {

    private final DbT1004ShisetsuNyutaishoEntity entity;
    private final ShisetsuNyutaishoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護保険施設入退所の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public ShisetsuNyutaisho(ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT1004ShisetsuNyutaishoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShisetsuNyutaishoIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1004ShisetsuNyutaishoEntity}より{@link ShisetsuNyutaisho}を生成します。
     *
     * @param entity DBより取得した{@link DbT1004ShisetsuNyutaishoEntity}
     */
    public ShisetsuNyutaisho(DbT1004ShisetsuNyutaishoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所"));
        this.id = new ShisetsuNyutaishoIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1004ShisetsuNyutaishoEntity}
     * @param id {@link ShisetsuNyutaishoIdentifier}
     */
    ShisetsuNyutaisho(
            DbT1004ShisetsuNyutaishoEntity entity,
            ShisetsuNyutaishoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
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
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類を返します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 入所処理年月日を返します。
     *
     * @return 入所処理年月日
     */
    public FlexibleDate get入所処理年月日() {
        return entity.getNyushoShoriYMD();
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所処理年月日を返します。
     *
     * @return 退所処理年月日
     */
    public FlexibleDate get退所処理年月日() {
        return entity.getTaishoShoriYMD();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 部屋記号番号を返します。
     *
     * @return 部屋記号番号
     */
    public RString get部屋記号番号() {
        return entity.getRoomKigoNo();
    }

    /**
     * {@link DbT1004ShisetsuNyutaishoEntity}のクローンを返します。
     *
     * @return {@link DbT1004ShisetsuNyutaishoEntity}のクローン
     */
    @Override
    public DbT1004ShisetsuNyutaishoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護保険施設入退所の識別子{@link ShisetsuNyutaishoIdentifier}を返します。
     *
     * @return 介護保険施設入退所の識別子{@link ShisetsuNyutaishoIdentifier}
     */
    @Override
    public ShisetsuNyutaishoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護保険施設入退所を削除対象とします。<br/>
     * {@link DbT1004ShisetsuNyutaishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShisetsuNyutaisho}
     */
    @Override
    public ShisetsuNyutaisho deleted() {
        DbT1004ShisetsuNyutaishoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShisetsuNyutaisho(deletedEntity, id);
    }

    /**
     * {@link ShisetsuNyutaisho}のシリアライズ形式を提供します。
     *
     * @return {@link ShisetsuNyutaisho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 他市町村住所地特例のみを変更対象とします。<br/>
     * {@link DbT1004ShisetsuNyutaishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyokaisoGaitosha}
     */
    public ShisetsuNyutaisho modifiedModel() {
        DbT1004ShisetsuNyutaishoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShisetsuNyutaisho(
                modifiedEntity, id);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT1004ShisetsuNyutaishoEntity entity;
        private final ShisetsuNyutaishoIdentifier id;

        private _SerializationProxy(DbT1004ShisetsuNyutaishoEntity entity, ShisetsuNyutaishoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShisetsuNyutaisho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShisetsuNyutaishoBuilder createBuilderForEdit() {
        return new ShisetsuNyutaishoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
