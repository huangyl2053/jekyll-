/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票_概況特記を管理するクラスです。
 */
public class GaikyoTokki extends ModelBase<GaikyoTokkiIdentifier, DbT5206GaikyoTokkiEntity, GaikyoTokki> implements Serializable {

    private final DbT5206GaikyoTokkiEntity entity;
    private final GaikyoTokkiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票_概況特記の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     */
    public GaikyoTokki(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況特記テキストイメージ区分) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(概況特記テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況特記テキストイメージ区分"));
        this.entity = new DbT5206GaikyoTokkiEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.entity.setGaikyoTokkiTextImageKubun(概況特記テキストイメージ区分);
        this.id = new GaikyoTokkiIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況特記テキストイメージ区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5206GaikyoTokkiEntity}より{@link GaikyoTokki}を生成します。
     *
     * @param entity DBより取得した{@link DbT5206GaikyoTokkiEntity}
     */
    public GaikyoTokki(DbT5206GaikyoTokkiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況特記"));
        this.id = new GaikyoTokkiIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getGaikyoTokkiTextImageKubun());
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

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * 概況特記テキストイメージ区分を返します。
     *
     * @return 概況特記テキストイメージ区分
     */
    public RString get概況特記テキストイメージ区分() {
        return entity.getGaikyoTokkiTextImageKubun();
    }

    /**
     * 住宅改修(回収箇所)を返します。
     *
     * @return 住宅改修(回収箇所)
     */
    public RString get住宅改修() {
        return entity.getJutakuKaishu();
    }

    /**
     * 市町村特別給付サービス種類名を返します。
     *
     * @return 市町村特別給付サービス種類名
     */
    public RString get市町村特別給付サービス種類名() {
        return entity.getTokubetsuKyufuService();
    }

    /**
     * 介護保険給付以外の在宅サービス種類名を返します。
     *
     * @return 介護保険給付以外の在宅サービス種類名
     */
    public RString get介護保険給付以外の在宅サービス種類名() {
        return entity.getZaitakuService();
    }

    /**
     * 概況特記事項_主訴を返します。
     *
     * @return 概況特記事項_主訴
     */
    public RString get概況特記事項_主訴() {
        return entity.getShuso();
    }

    /**
     * 概況特記_主訴_イメージ共有ファイルIDを返します。
     *
     * @return 概況特記_主訴_イメージ共有ファイルID
     */
//    public RDateTime get概況特記_主訴_イメージ共有ファイルID() {
//        return entity.getShusoImageSharedFileId();
//    }
    /**
     * 概況特記_主訴_マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記_主訴_マスキングイメージ共有ファイルID
     */
//    public RDateTime get概況特記_主訴_マスキングイメージ共有ファイルID() {
//        return entity.getShusoMaskingImageSharedFileId();
//    }
    /**
     * 概況特記事項_家族状況を返します。
     *
     * @return 概況特記事項_家族状況
     */
    public RString get概況特記事項_家族状況() {
        return entity.getKazokuJokyo();
    }

    /**
     * 概況特記_家族状況_イメージ共有ファイルIDを返します。
     *
     * @return 概況特記_家族状況_イメージ共有ファイルID
     */
//    public RDateTime get概況特記_家族状況_イメージ共有ファイルID() {
//        return entity.getKazokuJokyoImageSharedFileId();
//    }
    /**
     * 概況特記_家族状況_マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記_家族状況_マスキングイメージ共有ファイルID
     */
//    public RDateTime get概況特記_家族状況_マスキングイメージ共有ファイルID() {
//        return entity.getKazokuJokyoMaskingImageSharedFileId();
//    }
    /**
     * 概況特記事項_居住環境を返します。
     *
     * @return 概況特記事項_居住環境
     */
    public RString get概況特記事項_居住環境() {
        return entity.getKyojuKankyo();
    }

    /**
     * 概況特記_居住環境_イメージ共有ファイルIDを返します。
     *
     * @return 概況特記_居住環境_イメージ共有ファイルID
     */
//    public RDateTime get概況特記_居住環境_イメージ共有ファイルID() {
//        return entity.getKyojuKankyoImageSharedFileId();
//    }
    /**
     * 概況特記_居住環境_マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記_居住環境_マスキングイメージ共有ファイルID
     */
//    public RDateTime get概況特記_居住環境_マスキングイメージ共有ファイルID() {
//        return entity.getKyojuKankyoMaskingImageSharedFileId();
//    }
    /**
     * 概況特記事項_機器_器械を返します。
     *
     * @return 概況特記事項_機器_器械
     */
    public RString get概況特記事項_機器_器械() {
        return entity.getKikaiKiki();
    }

    /**
     * 概況特記_機器_器械_イメージ共有ファイルIDを返します。
     *
     * @return 概況特記_機器_器械_イメージ共有ファイルID
     */
//    public RDateTime get概況特記_機器_器械_イメージ共有ファイルID() {
//        return entity.getKikaiKikiImageSharedFileId();
//    }
    /**
     * 概況特記_機器_器械_マスキングイメージ共有ファイルIDを返します。
     *
     * @return 概況特記_機器_器械_マスキングイメージ共有ファイルID
     */
//    public RDateTime get概況特記_機器_器械_マスキングイメージ共有ファイルID() {
//        return entity.getKikaiKikiMaskingImageSharedFileId();
//    }
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
     * 認定調査票_概況特記の識別子{@link GaikyoTokkiIdentifier}を返します。
     *
     * @return 認定調査票_概況特記の識別子{@link GaikyoTokkiIdentifier}
     */
    @Override
    public GaikyoTokkiIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票_概況特記のみを変更対象とします。<br/>
     * {@link DbT5206GaikyoTokkiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GaikyoTokki}
     */
    public GaikyoTokki modifiedModel() {
        DbT5206GaikyoTokkiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GaikyoTokki(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票_概況特記を削除対象とします。<br/>
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

        private static final long serialVersionUID = 1L;
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
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GaikyoTokkiBuilder createBuilderForEdit() {
        return new GaikyoTokkiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
