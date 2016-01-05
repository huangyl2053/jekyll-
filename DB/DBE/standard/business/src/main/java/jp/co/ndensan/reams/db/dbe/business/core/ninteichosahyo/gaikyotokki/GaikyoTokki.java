/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（概況特記）を管理するクラスです。
 */
public class GaikyoTokki extends ModelBase<GaikyoTokkiIdentifier, DbT5206GaikyoTokkiEntity, GaikyoTokki> implements Serializable {

    private final DbT5206GaikyoTokkiEntity entity;
    private final GaikyoTokkiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（概況特記）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public GaikyoTokki(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        this.entity = new DbT5206GaikyoTokkiEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.id = new GaikyoTokkiIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5206GaikyoTokkiEntity}より{@link GaikyoTokki}を生成します。
     *
     * @param entity DBより取得した{@link DbT5206GaikyoTokkiEntity}
     */
    public GaikyoTokki(DbT5206GaikyoTokkiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況特記）"));
        this.id = new GaikyoTokkiIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5206GaikyoTokkiEntity}
     * @param id {@link GaikyoTokkiIdentifier}
     */
    GaikyoTokki(
            DbT5206GaikyoTokkiEntity entity,
            GaikyoTokkiIdentifier id
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
     * 概況特記事項（主訴）を返します。
     *
     * @return 概況特記事項（主訴）
     */
    public RString get概況特記事項_主訴() {
        return entity.getShuso();
    }

    /**
     * 概況特記（主訴）イメージ共有ファイルIDを返します。
     *
     * @return 概況特記（主訴）イメージ共有ファイルID
     */
    public RDateTime get概況特記_主訴_イメージ共有ファイルID() {
        return entity.getShusoImageSharedFileId();
    }

    /**
     * 概況特記（主訴）マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記（主訴）マスキングイメージ共有ファイルID
     */
    public RDateTime get概況特記_主訴_マスキングイメージ共有ファイルID() {
        return entity.getShusoMaskingImageSharedFileId();
    }

    /**
     * 概況特記事項（家族状況）を返します。
     *
     * @return 概況特記事項（家族状況）
     */
    public RString get概況特記事項_家族状況() {
        return entity.getKazokuJokyo();
    }

    /**
     * 概況特記（家族状況）イメージ共有ファイルIDを返します。
     *
     * @return 概況特記（家族状況）イメージ共有ファイルID
     */
    public RDateTime get概況特記_家族状況_イメージ共有ファイルID() {
        return entity.getKazokuJokyoImageSharedFileId();
    }

    /**
     * 概況特記（家族状況）マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記（家族状況）マスキングイメージ共有ファイルID
     */
    public RDateTime get概況特記_家族状況_マスキングイメージ共有ファイルID() {
        return entity.getKazokuJokyoMaskingImageSharedFileId();
    }

    /**
     * 概況特記事項（居住環境）を返します。
     *
     * @return 概況特記事項（居住環境）
     */
    public RString get概況特記事項_居住環境_() {
        return entity.getKyojuKankyo();
    }

    /**
     * 概況特記（居住環境）イメージ共有ファイルIDを返します。
     *
     * @return 概況特記（居住環境）イメージ共有ファイルID
     */
    public RDateTime get概況特記_居住環境_イメージ共有ファイルID() {
        return entity.getKyojuKankyoImageSharedFileId();
    }

    /**
     * 概況特記（居住環境）マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記（居住環境）マスキングイメージ共有ファイルID
     */
    public RDateTime get概況特記_居住環境_マスキングイメージ共有ファイルID() {
        return entity.getKyojuKankyoMaskingImageSharedFileId();
    }

    /**
     * 概況特記事項（機器・器械）を返します。
     *
     * @return 概況特記事項（機器・器械）
     */
    public RString get概況特記事項_機器_器械() {
        return entity.getKikaiKiki();
    }

    /**
     * 概況特記（機器・器械）イメージ共有ファイルIDを返します。
     *
     * @return 概況特記（機器・器械）イメージ共有ファイルID
     */
    public RDateTime get概況特記_機器_器械_イメージ共有ファイルID() {
        return entity.getKikaiKikiImageSharedFileId();
    }

    /**
     * 概況特記（機器・器械）マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記（機器・器械）マスキングイメージ共有ファイルID
     */
    public RDateTime get概況特記_機器_器械_マスキングイメージ共有ファイルID() {
        return entity.getKikaiKikiMaskingImageSharedFileId();
    }

    /**
     * {@link DbT5206GaikyoTokkiEntity}のクローンを返します。
     *
     * @return {@link DbT5206GaikyoTokkiEntity}のクローン
     */
    @Override
    public DbT5206GaikyoTokkiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（概況特記）の識別子{@link GaikyoTokkiIdentifier}を返します。
     *
     * @return 認定調査票（概況特記）の識別子{@link GaikyoTokkiIdentifier}
     */
    @Override
    public GaikyoTokkiIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（概況特記）のみを変更対象とします。<br/>
     * {@link DbT5206GaikyoTokkiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GaikyoTokki}
     */
    public GaikyoTokki modifiedModel() {
        DbT5206GaikyoTokkiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GaikyoTokki(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（概況特記）を削除対象とします。<br/>
     * {@link DbT5206GaikyoTokkiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GaikyoTokki}
     */
    @Override
    public GaikyoTokki deleted() {
        DbT5206GaikyoTokkiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GaikyoTokki(deletedEntity, id);
    }

    /**
     * {@link GaikyoTokki}のシリアライズ形式を提供します。
     *
     * @return {@link GaikyoTokki}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -8934472817016355875L;
        private final DbT5206GaikyoTokkiEntity entity;
        private final GaikyoTokkiIdentifier id;

        private _SerializationProxy(DbT5206GaikyoTokkiEntity entity, GaikyoTokkiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GaikyoTokki(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GaikyoTokkiBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GaikyoTokkiBuilder createBuilderForEdit() {
        return new GaikyoTokkiBuilder(entity, id);
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
        final GaikyoTokki other = (GaikyoTokki) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
