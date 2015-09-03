/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定送信済みマスタを管理するクラスです。
 */
public class NinteiSoshinzumiMaster extends ParentModelBase<NinteiSoshinzumiMasterIdentifier, DbT5190NinteiSoshinzumiMasterEntity, NinteiSoshinzumiMaster> implements Serializable {

    private final DbT5190NinteiSoshinzumiMasterEntity entity;
    private final NinteiSoshinzumiMasterIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定送信済みマスタの新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiSoshinzumiMaster(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5190NinteiSoshinzumiMasterEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new NinteiSoshinzumiMasterIdentifier(申請書管理番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5190NinteiSoshinzumiMasterEntity}より{@link NinteiSoshinzumiMaster}を生成します。
     *
     * @param entity DBより取得した{@link DbT5190NinteiSoshinzumiMasterEntity}
     */
    public NinteiSoshinzumiMaster(DbT5190NinteiSoshinzumiMasterEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定送信済みマスタ"));
        this.id = new NinteiSoshinzumiMasterIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5190NinteiSoshinzumiMasterEntity}
     * @param id {@link NinteiSoshinzumiMasterIdentifier}
     */
    NinteiSoshinzumiMaster(
            DbT5190NinteiSoshinzumiMasterEntity entity,
            NinteiSoshinzumiMasterIdentifier id
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
     * 同一連番を返します。
     *
     * @return 同一連番
     */
    public int get同一連番() {
        return entity.getDoitsuRemban();
    }

    /**
     * 引き渡しフラグを返します。
     *
     * @return 引き渡しフラグ
     */
    public boolean get引き渡しフラグ() {
        return entity.getIsHikiwatashi();
    }

    /**
     * 引き渡し日時を返します。
     *
     * @return 引き渡し日時
     */
    public YMDHM get引き渡し日時() {
        return entity.getHikiwatashiYMDHM();
    }

    /**
     * 引き渡し解除日時を返します。
     *
     * @return 引き渡し解除日時
     */
    public YMDHM get引き渡し解除日時() {
        return entity.getHikiwatashiKaijoYMDHM();
    }

    /**
     * 引き渡しカウントを返します。
     *
     * @return 引き渡しカウント
     */
    public int get引き渡しカウント() {
        return entity.getHikiwatashiCount();
    }

    /**
     * 取り込み日時を返します。
     *
     * @return 取り込み日時
     */
    public YMDHM get取り込み日時() {
        return entity.getTorikomiYMDHM();
    }

    /**
     * 再送付区分を返します。
     *
     * @return 再送付区分
     */
    public RString get再送付区分() {
        return entity.getSaiSofuKubun();
    }

    /**
     * 再調査送付区分を返します。
     *
     * @return 再調査送付区分
     */
    public RString get再調査送付区分() {
        return entity.getSaiChosaSofuKubun();
    }

    /**
     * 再意見書送付区分を返します。
     *
     * @return 再意見書送付区分
     */
    public RString get再意見書送付区分() {
        return entity.getSaiIkenshoSofuKubun();
    }

    /**
     * {@link DbT5190NinteiSoshinzumiMasterEntity}のクローンを返します。
     *
     * @return {@link DbT5190NinteiSoshinzumiMasterEntity}のクローン
     */
    @Override
    public DbT5190NinteiSoshinzumiMasterEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定送信済みマスタの識別子{@link NinteiSoshinzumiMasterIdentifier}を返します。
     *
     * @return 要介護認定送信済みマスタの識別子{@link NinteiSoshinzumiMasterIdentifier}
     */
    @Override
    public NinteiSoshinzumiMasterIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定送信済みマスタのみを変更対象とします。<br/>
     * {@link DbT5190NinteiSoshinzumiMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiSoshinzumiMaster}
     */
    @Override
    public NinteiSoshinzumiMaster modifiedModel() {
        DbT5190NinteiSoshinzumiMasterEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiSoshinzumiMaster(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定送信済みマスタを削除対象とします。<br/>
     * {@link DbT5190NinteiSoshinzumiMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiSoshinzumiMaster}
     */
    @Override
    public NinteiSoshinzumiMaster deleted() {
        DbT5190NinteiSoshinzumiMasterEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiSoshinzumiMaster(deletedEntity, id);
    }

    /**
     * {@link NinteiSoshinzumiMaster}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiSoshinzumiMaster}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5190NinteiSoshinzumiMasterEntity entity;
        private final NinteiSoshinzumiMasterIdentifier id;

        private _SerializationProxy(DbT5190NinteiSoshinzumiMasterEntity entity, NinteiSoshinzumiMasterIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiSoshinzumiMaster(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiSoshinzumiMasterBuilder createBuilderForEdit() {
        return new NinteiSoshinzumiMasterBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
