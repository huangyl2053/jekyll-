/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連携用データ送付記録を管理するクラスです。
 */
public class RenkeiyoDataSofuKiroku extends ParentModelBase<RenkeiyoDataSofuKirokuIdentifier, DbT5191RenkeiyoDataSofuKirokuEntity, RenkeiyoDataSofuKiroku> implements Serializable {

    private final DbT5191RenkeiyoDataSofuKirokuEntity entity;
    private final RenkeiyoDataSofuKirokuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 連携用データ送付記録の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 資料作成日 資料作成日
     */
    public RenkeiyoDataSofuKiroku(ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 資料作成日) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(資料作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("資料作成日"));
        this.entity = new DbT5191RenkeiyoDataSofuKirokuEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setShiryoSakuseiYMD(資料作成日);
        this.id = new RenkeiyoDataSofuKirokuIdentifier(
                申請書管理番号,
                資料作成日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5191RenkeiyoDataSofuKirokuEntity}より{@link RenkeiyoDataSofuKiroku}を生成します。
     *
     * @param entity DBより取得した{@link DbT5191RenkeiyoDataSofuKirokuEntity}
     */
    public RenkeiyoDataSofuKiroku(DbT5191RenkeiyoDataSofuKirokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連携用データ送付記録"));
        this.id = new RenkeiyoDataSofuKirokuIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getShiryoSakuseiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5191RenkeiyoDataSofuKirokuEntity}
     * @param id {@link RenkeiyoDataSofuKirokuIdentifier}
     */
    RenkeiyoDataSofuKiroku(
            DbT5191RenkeiyoDataSofuKirokuEntity entity,
            RenkeiyoDataSofuKirokuIdentifier id
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
     * 資料作成日を返します。
     *
     * @return 資料作成日
     */
    public FlexibleDate get資料作成日() {
        return entity.getShiryoSakuseiYMD();
    }

    /**
     * 引渡し区分を返します。
     *
     * @return 引渡し区分
     */
    public RString get引渡し区分() {
        return entity.getHikiwatashiKubun();
    }

    /**
     * 引渡日時を返します。
     *
     * @return 引渡日時
     */
    public YMDHMS get引渡日時() {
        return entity.getHikiwatashiTimeStamp();
    }

    /**
     * 再送付区分を返します。
     *
     * @return 再送付区分
     */
    public RString get再送付区分() {
        return entity.getSaiSoufuKubun();
    }

    /**
     * 再調査送付区分を返します。
     *
     * @return 再調査送付区分
     */
    public RString get再調査送付区分() {
        return entity.getSaiChousaSofuKubun();
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
     * 再イメージ送付区分を返します。
     *
     * @return 再イメージ送付区分
     */
    public RString get再イメージ送付区分() {
        return entity.getSaiImageSofuKubun();
    }

    /**
     * 再送信年月日を返します。
     *
     * @return 再送信年月日
     */
    public FlexibleDate get再送信年月日() {
        return entity.getSaiSoshinYMD();
    }

    /**
     * {@link DbT5191RenkeiyoDataSofuKirokuEntity}のクローンを返します。
     *
     * @return {@link DbT5191RenkeiyoDataSofuKirokuEntity}のクローン
     */
    @Override
    public DbT5191RenkeiyoDataSofuKirokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 連携用データ送付記録の識別子{@link RenkeiyoDataSofuKirokuIdentifier}を返します。
     *
     * @return 連携用データ送付記録の識別子{@link RenkeiyoDataSofuKirokuIdentifier}
     */
    @Override
    public RenkeiyoDataSofuKirokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 連携用データ送付記録のみを変更対象とします。<br/>
     * {@link DbT5191RenkeiyoDataSofuKirokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RenkeiyoDataSofuKiroku}
     */
    @Override
    public RenkeiyoDataSofuKiroku modifiedModel() {
        DbT5191RenkeiyoDataSofuKirokuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RenkeiyoDataSofuKiroku(
                modifiedEntity, id);
    }

    /**
     * 保持する連携用データ送付記録を削除対象とします。<br/>
     * {@link DbT5191RenkeiyoDataSofuKirokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RenkeiyoDataSofuKiroku}
     */
    @Override
    public RenkeiyoDataSofuKiroku deleted() {
        DbT5191RenkeiyoDataSofuKirokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RenkeiyoDataSofuKiroku(deletedEntity, id);
    }

    /**
     * {@link RenkeiyoDataSofuKiroku}のシリアライズ形式を提供します。
     *
     * @return {@link RenkeiyoDataSofuKiroku}のシリアライズ形式
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
        private final DbT5191RenkeiyoDataSofuKirokuEntity entity;
        private final RenkeiyoDataSofuKirokuIdentifier id;

        private _SerializationProxy(DbT5191RenkeiyoDataSofuKirokuEntity entity, RenkeiyoDataSofuKirokuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RenkeiyoDataSofuKiroku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RenkeiyoDataSofuKirokuBuilder createBuilderForEdit() {
        return new RenkeiyoDataSofuKirokuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
