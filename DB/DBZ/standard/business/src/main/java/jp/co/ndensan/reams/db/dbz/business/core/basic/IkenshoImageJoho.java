/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定意見書イメージ情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 chengsanyuan
 */
public class IkenshoImageJoho extends
        ParentModelBase<IkenshoImageJohoIdentifier, DbT5305IkenshoImageJohoEntity, IkenshoImageJoho> implements Serializable {

    private static final long serialVersionUID = -338823555606394862L;
    private final DbT5305IkenshoImageJohoEntity entity;
    private final IkenshoImageJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定意見書イメージ情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 帳票ID 帳票ID
     * @param マスキングデータ区分 マスキングデータ区分
     * @param 取込みページ番号 取込みページ番号
     */
    public IkenshoImageJoho(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            Code 帳票ID,
            RString マスキングデータ区分,
            int 取込みページ番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        requireNonNull(マスキングデータ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("マスキングデータ区分"));
        requireNonNull(取込みページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込みページ番号"));
        this.entity = new DbT5305IkenshoImageJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.entity.setChoyoID(帳票ID);
        this.entity.setMaskDataKubun(マスキングデータ区分);
        this.entity.setTorikomiPageNo(取込みページ番号);
        this.id = new IkenshoImageJohoIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号,
                帳票ID,
                マスキングデータ区分,
                取込みページ番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5305IkenshoImageJohoEntity}より{@link IkenshoImageJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5305IkenshoImageJohoEntity}
     */
    public IkenshoImageJoho(DbT5305IkenshoImageJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定意見書イメージ情報"));
        this.id = new IkenshoImageJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIraiRirekiNo(),
                entity.getChoyoID(),
                entity.getMaskDataKubun(),
                entity.getTorikomiPageNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5305IkenshoImageJohoEntity}
     * @param id {@link IkenshoImageJohoIdentifier}
     */
    IkenshoImageJoho(
            DbT5305IkenshoImageJohoEntity entity,
            IkenshoImageJohoIdentifier id
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
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIraiRirekiNo();
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID
     */
    public Code get帳票ID() {
        return entity.getChoyoID();
    }

    /**
     * マスキングデータ区分を返します。
     *
     * @return マスキングデータ区分
     */
    public RString getマスキングデータ区分() {
        return entity.getMaskDataKubun();
    }

    /**
     * 取込みページ番号を返します。
     *
     * @return 取込みページ番号
     */
    public int get取込みページ番号() {
        return entity.getTorikomiPageNo();
    }

    /**
     * 認定申請年を返します。
     *
     * @return 認定申請年
     */
    public int get認定申請年() {
        return entity.getNinteiShinseiNen();
    }

    /**
     * 共有ファイルIDを返します。
     *
     * @return 共有ファイルID
     */
    public RDateTime get共有ファイルID() {
        return entity.getSharedFileId();
    }

    /**
     * {@link DbT5305IkenshoImageJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5305IkenshoImageJohoEntity}のクローン
     */
    @Override
    public DbT5305IkenshoImageJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定意見書イメージ情報の識別子{@link IkenshoImageJohoIdentifier}を返します。
     *
     * @return 要介護認定意見書イメージ情報の識別子{@link IkenshoImageJohoIdentifier}
     */
    @Override
    public IkenshoImageJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定意見書イメージ情報のみを変更対象とします。<br/>
     * {@link DbT5305IkenshoImageJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IkenshoImageJoho}
     */
    @Override
    public IkenshoImageJoho modifiedModel() {
        DbT5305IkenshoImageJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IkenshoImageJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定意見書イメージ情報を削除対象とします。<br/>
     * {@link DbT5305IkenshoImageJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IkenshoImageJoho}
     */
    @Override
    public IkenshoImageJoho deleted() {
        DbT5305IkenshoImageJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IkenshoImageJoho(deletedEntity, id);
    }

    /**
     * {@link IkenshoImageJoho}のシリアライズ形式を提供します。
     *
     * @return {@link IkenshoImageJoho}のシリアライズ形式
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
        private final DbT5305IkenshoImageJohoEntity entity;
        private final IkenshoImageJohoIdentifier id;

        private _SerializationProxy(DbT5305IkenshoImageJohoEntity entity, IkenshoImageJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IkenshoImageJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IkenshoImageJohoBuilder createBuilderForEdit() {
        return new IkenshoImageJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
