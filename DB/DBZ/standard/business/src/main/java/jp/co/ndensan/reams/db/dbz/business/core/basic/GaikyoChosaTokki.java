/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5213GaikyoChosaTokkiMaskEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * @author n3509
 */
public class GaikyoChosaTokki extends
        ModelBase<GaikyoChosaTokkiIdentifier, DbT5213GaikyoChosaTokkiMaskEntity, GaikyoChosaTokki>
        implements Serializable {

    private final DbT5213GaikyoChosaTokkiMaskEntity entity;
    private final GaikyoChosaTokkiIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキストイメージ区分 概況調査テキストイメージ区分
     */
    public GaikyoChosaTokki(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));
        this.entity = new DbT5213GaikyoChosaTokkiMaskEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.entity.setGaikyoChosaTextImageKubun(概況調査テキストイメージ区分);
        this.id = new GaikyoChosaTokkiIdentifier(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分);

    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5213GaikyoChosaTokkiMaskEntity}より{@link GaikyoChosaTokki}を生成します。
     *
     * @param entity
     */
    public GaikyoChosaTokki(DbT5213GaikyoChosaTokkiMaskEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査特記"));
        this.id = new GaikyoChosaTokkiIdentifier(entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getGaikyoChosaTextImageKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5213GaikyoChosaTokkiMaskEntity}
     * @param id {@link GaikyoChosaTokkiIdentifier}
     */
    GaikyoChosaTokki(
            DbT5213GaikyoChosaTokkiMaskEntity entity,
            GaikyoChosaTokkiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 概況調査テキストイメージ区分を返します。
     *
     * @return 概況調査テキストイメージ区分
     */
    public RString get概況調査テキストイメージ区分() {
        return entity.getGaikyoChosaTextImageKubun();
    }

    /**
     * 特記を返します。
     *
     * @return 特記
     */
    public RString get特記() {
        return entity.getTokki();
    }

    @Override
    public DbT5213GaikyoChosaTokkiMaskEntity toEntity() {
        return this.entity.clone();
    }

    @Override
    public GaikyoChosaTokki deleted() {
        DbT5213GaikyoChosaTokkiMaskEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GaikyoChosaTokki(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    @Override
    public GaikyoChosaTokkiIdentifier identifier() {
        return this.id;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GaikyoChosaTokki.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GaikyoChosaTokkiBuilder createBuilderForEdit() {
        return new GaikyoChosaTokkiBuilder(entity, id);
    }

    /**
     * 概況調査特記のみを変更対象とします。<br/>
     * {@link DbT5213GaikyoChosaTokkiMaskEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GaikyoChosaTokki}
     */
    public GaikyoChosaTokki modifiedModel() {
        DbT5213GaikyoChosaTokkiMaskEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GaikyoChosaTokki(modifiedEntity, id);
    }

    /**
     * {@link GaikyoChosaTokki}のシリアライズ形式を提供します。
     *
     * @return {@link GaikyoChosaTokki}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5213GaikyoChosaTokkiMaskEntity entity;
        private final GaikyoChosaTokkiIdentifier id;

        private _SerializationProxy(DbT5213GaikyoChosaTokkiMaskEntity entity, GaikyoChosaTokkiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GaikyoChosaTokki(this.entity, this.id);
        }
    }
}
