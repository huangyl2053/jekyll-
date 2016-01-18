/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 福祉用具商品名入力ガイドを管理するクラスです。
 */
public class FukushiyoguShohin
        extends ModelBase<FukushiyoguShohinIdentifier, DbT3117FukushiyoguShohinEntity, FukushiyoguShohin>
        implements Serializable {

    private static final long serialVersionUID = 5467221538797532336L;
    private final DbT3117FukushiyoguShohinEntity entity;
    private final FukushiyoguShohinIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 福祉用具商品名入力ガイドの新規作成時に使用します。
     *
     * @param 商品番号
     * @param 管理開始年月日
     */
    public FukushiyoguShohin(
            RString 商品番号,
            FlexibleDate 管理開始年月日) {
        requireNonNull(商品番号, UrSystemErrorMessages.値がnull.getReplacedMessage("商品番号"));
        requireNonNull(管理開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("管理開始年月日"));
        this.entity = new DbT3117FukushiyoguShohinEntity();
        this.entity.setShohinNo(商品番号);
        this.entity.setKanriKaishiYMD(管理開始年月日);
        this.id = new FukushiyoguShohinIdentifier(
                商品番号,
                管理開始年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3117FukushiyoguShohinEntity}より{@link FukushiyoguShohin}を生成します。
     *
     * @param entity DBより取得した{@link DbT3117FukushiyoguShohinEntity}
     */
    public FukushiyoguShohin(DbT3117FukushiyoguShohinEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名入力ガイド"));
        this.id = new FukushiyoguShohinIdentifier(
                entity.getShohinNo(),
                entity.getKanriKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3117FukushiyoguShohinEntity}
     * @param id {@link FukushiyoguShohinIdentifier}
     */
    FukushiyoguShohin(
            DbT3117FukushiyoguShohinEntity entity,
            FukushiyoguShohinIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 商品番号のgetメソッドです。
     *
     * @return 商品番号
     */
    public RString get商品番号() {
        return entity.getShohinNo();
    }

    /**
     * 管理開始年月日のgetメソッドです。
     *
     * @return 管理開始年月日
     */
    public FlexibleDate get管理開始年月日() {
        return entity.getKanriKaishiYMD();
    }

    /**
     * 管理終了年月日のgetメソッドです。
     *
     * @return 管理終了年月日
     */
    public FlexibleDate get管理終了年月日() {
        return entity.getKanriShuryoYMD();
    }

    /**
     * 商品名のgetメソッドです。
     *
     * @return 商品名
     */
    public RString get商品名() {
        return entity.getShohinmei();
    }

    /**
     * 製造事業者名のgetメソッドです。
     *
     * @return 製造事業者名
     */
    public RString get製造事業者名() {
        return entity.getSeizoJigyoshamei();
    }

    /**
     * 品目コードのgetメソッドです。
     *
     * @return 品目コード
     */
    public RString get品目コード() {
        return entity.getHinmokuCode();
    }

    /**
     * {@link DbT3117FukushiyoguShohinEntity}のクローンを返します。
     *
     * @return {@link DbT3117FukushiyoguShohinEntity}のクローン
     */
    @Override
    public DbT3117FukushiyoguShohinEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 福祉用具商品名入力ガイドの識別子{@link FukushiyoguShohinIdentifier}を返します。
     *
     * @return 福祉用具商品名入力ガイドの識別子{@link FukushiyoguShohinIdentifier}
     */
    @Override
    public FukushiyoguShohinIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する福祉用具商品名入力ガイドを削除対象とします。<br/>
     * {@link DbT3117FukushiyoguShohinEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChiikiMitchakuServiceCode}
     */
    @Override
    public FukushiyoguShohin deleted() {
        DbT3117FukushiyoguShohinEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FukushiyoguShohin(deletedEntity, id);
    }

    /**
     * {@link FukushiyoguShohin}のシリアライズ形式を提供します。
     *
     * @return {@link FukushiyoguShohin}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3117FukushiyoguShohinEntity entity;
        private final FukushiyoguShohinIdentifier id;

        private _SerializationProxy(DbT3117FukushiyoguShohinEntity entity, FukushiyoguShohinIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FukushiyoguShohin(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FukushiyoguShohinBuilder createBuilderForEdit() {
        return new FukushiyoguShohinBuilder(entity, id);
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
        final FukushiyoguShohin other = (FukushiyoguShohin) obj;
        return Objects.equals(this.id, other.id);
    }

}
