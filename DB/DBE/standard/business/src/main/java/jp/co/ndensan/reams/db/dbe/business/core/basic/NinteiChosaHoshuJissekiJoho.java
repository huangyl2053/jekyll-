/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査報酬実績情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 wanghui
 */
public class NinteiChosaHoshuJissekiJoho
        extends ParentModelBase<NinteiChosaHoshuJissekiJohoIdentifier, DbT5601NinteiChosaHoshuJissekiJohoEntity, NinteiChosaHoshuJissekiJoho>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT5601NinteiChosaHoshuJissekiJohoEntity entity;
    private final NinteiChosaHoshuJissekiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査報酬実績情報の新規作成時に使用します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public NinteiChosaHoshuJissekiJoho(RString 認定調査委託先コード,
            RString 認定調査員コード,
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        this.entity = new DbT5601NinteiChosaHoshuJissekiJohoEntity();
        this.entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        this.entity.setNinteichosainCode(認定調査員コード);
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        this.id = new NinteiChosaHoshuJissekiJohoIdentifier(
                認定調査委託先コード,
                認定調査員コード,
                申請書管理番号,
                認定調査依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5601NinteiChosaHoshuJissekiJohoEntity}より{@link NinteiChosaHoshuJissekiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5601NinteiChosaHoshuJissekiJohoEntity}
     */
    public NinteiChosaHoshuJissekiJoho(DbT5601NinteiChosaHoshuJissekiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬実績情報"));
        this.id = new NinteiChosaHoshuJissekiJohoIdentifier(
                entity.getNinteichosaItakusakiCode(),
                entity.getNinteichosainCode(),
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}
     * @param id {@link NinteiChosaHoshuJissekiJohoIdentifier}
     */
    NinteiChosaHoshuJissekiJoho(
            DbT5601NinteiChosaHoshuJissekiJohoEntity entity,
            NinteiChosaHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteichosainCode();
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
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 認定調査委託料を返します。
     *
     * @return 認定調査委託料
     */
    public int get認定調査委託料() {
        return entity.getChosaItakuryo();
    }

    /**
     * 認定調査委託料支払年月日を返します。
     *
     * @return 認定調査委託料支払年月日
     */
    public FlexibleDate get認定調査委託料支払年月日() {
        return entity.getChosaItakuryoShiharaiYMD();
    }

    /**
     * 認定調査委託料支払メモを返します。
     *
     * @return 認定調査委託料支払メモ
     */
    public RString get認定調査委託料支払メモ() {
        return entity.getChosaItakuryoShiharaiMemo();
    }

    /**
     * 銀行振込出力フラグを返します。
     *
     * @return 銀行振込出力フラグ
     */
    public boolean is銀行振込出力フラグ() {
        return entity.getIsGinkoFurikomiShutsuryoku();
    }

    /**
     * {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}のクローン
     */
    @Override
    public DbT5601NinteiChosaHoshuJissekiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査報酬実績情報の識別子{@link NinteiChosaHoshuJissekiJohoIdentifier}を返します。
     *
     * @return 認定調査報酬実績情報の識別子{@link NinteiChosaHoshuJissekiJohoIdentifier}
     */
    @Override
    public NinteiChosaHoshuJissekiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査報酬実績情報のみを変更対象とします。<br/> {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiChosaHoshuJissekiJoho}
     */
    @Override
    public NinteiChosaHoshuJissekiJoho modifiedModel() {
        DbT5601NinteiChosaHoshuJissekiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiChosaHoshuJissekiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査報酬実績情報を削除対象とします。<br/> {@link DbT5601NinteiChosaHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiChosaHoshuJissekiJoho}
     */
    @Override
    public NinteiChosaHoshuJissekiJoho deleted() {
        DbT5601NinteiChosaHoshuJissekiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiChosaHoshuJissekiJoho(deletedEntity, id);
    }

    /**
     * {@link NinteiChosaHoshuJissekiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiChosaHoshuJissekiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return !toEntity().getState().equals(EntityDataState.Unchanged);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbT5601NinteiChosaHoshuJissekiJohoEntity entity;
        private final NinteiChosaHoshuJissekiJohoIdentifier id;

        private _SerializationProxy(DbT5601NinteiChosaHoshuJissekiJohoEntity entity, NinteiChosaHoshuJissekiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiChosaHoshuJissekiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiChosaHoshuJissekiJohoBuilder createBuilderForEdit() {
        return new NinteiChosaHoshuJissekiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
