/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動保留特定住所マスタを管理するクラスです。
 */
public class RendoHoryuTokuteiJusho extends
        ModelBase<RendoHoryuTokuteiJushoIdentifier, DbT7023RendoHoryuTokuteiJushoEntity, RendoHoryuTokuteiJusho> implements Serializable {

    private final DbT7023RendoHoryuTokuteiJushoEntity entity;
    private final RendoHoryuTokuteiJushoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 連動保留特定住所マスタの新規作成時に使用します。
     *
     * @param 管理番号 管理番号
     * @param 市町村コード 市町村コード
     */
    public RendoHoryuTokuteiJusho(RString 管理番号,
            LasdecCode 市町村コード) {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT7023RendoHoryuTokuteiJushoEntity();
        this.entity.setKanriNo(管理番号);
        this.entity.setShichosonCode(市町村コード);
        this.id = new RendoHoryuTokuteiJushoIdentifier(
                管理番号,
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7023RendoHoryuTokuteiJushoEntity}より{@link RendoHoryuTokuteiJusho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7023RendoHoryuTokuteiJushoEntity}
     */
    public RendoHoryuTokuteiJusho(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連動保留特定住所マスタ"));
        this.id = new RendoHoryuTokuteiJushoIdentifier(
                entity.getKanriNo(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7023RendoHoryuTokuteiJushoEntity}
     * @param id {@link RendoHoryuTokuteiJushoIdentifier}
     */
    RendoHoryuTokuteiJusho(
            DbT7023RendoHoryuTokuteiJushoEntity entity,
            RendoHoryuTokuteiJushoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        return entity.getKanriNo();
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
     * 住所コードを返します。
     *
     * @return 住所コード
     */
    public ChoikiCode get住所コード() {
        return entity.getJushoCode();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 番地コード１を返します。
     *
     * @return 番地コード１
     */
    public BanchiCode get番地コード１() {
        return entity.getBanchiCode1();
    }

    /**
     * 番地コード２を返します。
     *
     * @return 番地コード２
     */
    public BanchiCode get番地コード２() {
        return entity.getBanchiCode2();
    }

    /**
     * 番地コード３を返します。
     *
     * @return 番地コード３
     */
    public BanchiCode get番地コード３() {
        return entity.getBanchiCode3();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return entity.getBanchi();
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public RString get施設種類() {
        return entity.getShisetsuShurui();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return entity.getShisetsuCode();
    }

    /**
     * {@link DbT7023RendoHoryuTokuteiJushoEntity}のクローンを返します。
     *
     * @return {@link DbT7023RendoHoryuTokuteiJushoEntity}のクローン
     */
    @Override
    public DbT7023RendoHoryuTokuteiJushoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 連動保留特定住所マスタの識別子{@link RendoHoryuTokuteiJushoIdentifier}を返します。
     *
     * @return 連動保留特定住所マスタの識別子{@link RendoHoryuTokuteiJushoIdentifier}
     */
    @Override
    public RendoHoryuTokuteiJushoIdentifier identifier() {
        return this.id;
    }

    /**
     * 連動保留特定住所マスタのみを変更対象とします。<br/> {@link DbT7023RendoHoryuTokuteiJushoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RendoHoryuTokuteiJusho}
     */
    public RendoHoryuTokuteiJusho modifiedModel() {
        DbT7023RendoHoryuTokuteiJushoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RendoHoryuTokuteiJusho(
                modifiedEntity, id);
    }

    /**
     * 保持する連動保留特定住所マスタを削除対象とします。<br/> {@link DbT7023RendoHoryuTokuteiJushoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RendoHoryuTokuteiJusho}
     */
    @Override
    public RendoHoryuTokuteiJusho deleted() {
        DbT7023RendoHoryuTokuteiJushoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RendoHoryuTokuteiJusho(deletedEntity, id);
    }

    /**
     * {@link RendoHoryuTokuteiJusho}のシリアライズ形式を提供します。
     *
     * @return {@link RendoHoryuTokuteiJusho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -266828360977929608L;
        private final DbT7023RendoHoryuTokuteiJushoEntity entity;
        private final RendoHoryuTokuteiJushoIdentifier id;

        private _SerializationProxy(DbT7023RendoHoryuTokuteiJushoEntity entity, RendoHoryuTokuteiJushoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RendoHoryuTokuteiJusho(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RendoHoryuTokuteiJushoBuilder createBuilderForEdit() {
        return new RendoHoryuTokuteiJushoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final RendoHoryuTokuteiJusho other = (RendoHoryuTokuteiJusho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
