/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会割当情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 sunhaidi
 */
public class ShinsakaiWariateJoho
        extends ModelBase<ShinsakaiWariateJohoIdentifier, DbT5502ShinsakaiWariateJohoEntity, ShinsakaiWariateJoho>
        implements Serializable {

    private final DbT5502ShinsakaiWariateJohoEntity entity;
    private final ShinsakaiWariateJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会割当情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinsakaiWariateJoho(RString 介護認定審査会開催番号,
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5502ShinsakaiWariateJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new ShinsakaiWariateJohoIdentifier(
                介護認定審査会開催番号,
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5502ShinsakaiWariateJohoEntity}より{@link ShinsakaiWariateJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5502ShinsakaiWariateJohoEntity}
     */
    public ShinsakaiWariateJoho(DbT5502ShinsakaiWariateJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報"));
        this.id = new ShinsakaiWariateJohoIdentifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5502ShinsakaiWariateJohoEntity}
     * @param id {@link ShinsakaiWariateJohoIdentifier}
     */
    ShinsakaiWariateJoho(
            DbT5502ShinsakaiWariateJohoEntity entity,
            ShinsakaiWariateJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
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
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 介護認定審査会割当年月日を返します。
     *
     * @return 介護認定審査会割当年月日
     */
    public FlexibleDate get介護認定審査会割当年月日() {
        return entity.getShinsakaiWariateYMD();
    }

    /**
     * 介護認定審査会審査順を返します。
     *
     * @return 介護認定審査会審査順
     */
    public int get介護認定審査会審査順() {
        return entity.getShinsakaiOrder();
    }

    /**
     * 介護認定審査会審査順確定フラグを返します。
     *
     * @return 介護認定審査会審査順確定フラグ
     */
    public boolean is介護認定審査会審査順確定フラグ() {
        return entity.getShinsakaiOrderKakuteiFlag();
    }

    /**
     * 審査会自動割付フラグを返します。
     *
     * @return 審査会自動割付フラグ
     */
    public boolean is審査会自動割付フラグ() {
        return entity.getShinsakaiJidoWaritsukeFlag();
    }

    /**
     * 審査会資料作成年月日を返します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 審査会資料送付年月日を返します。
     *
     * @return 審査会資料送付年月日
     */
    public FlexibleDate get審査会資料送付年月日() {
        return entity.getShinsakaiShiryoSofuYMD();
    }

    /**
     * 判定結果コードを返します。
     *
     * @return 判定結果コード
     */
    public Code get判定結果コード() {
        return entity.getHanteiKekkaCode();
    }

    /**
     * @return {@link HanteiKekkaCode}
     */
    @CheckForNull
    public HanteiKekkaCode getHanteiKekkaCode() {
        Code code = entity.getHanteiKekkaCode();
        if (code == null || !HanteiKekkaCode.existsCode(code.value())) {
            return null;
        }
        return HanteiKekkaCode.toValue(code.value());
    }

    /**
     * {@link DbT5502ShinsakaiWariateJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5502ShinsakaiWariateJohoEntity}のクローン
     */
    @Override
    public DbT5502ShinsakaiWariateJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会割当情報の識別子{@link ShinsakaiWariateJohoIdentifier}を返します。
     *
     * @return 介護認定審査会割当情報の識別子{@link ShinsakaiWariateJohoIdentifier}
     */
    @Override
    public ShinsakaiWariateJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会割当情報のみを変更対象とします。<br/>
     * {@link DbT5502ShinsakaiWariateJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiWariateJoho}
     */
    public ShinsakaiWariateJoho modifiedModel() {
        DbT5502ShinsakaiWariateJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiWariateJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会割当情報を削除対象とします。<br/>
     * {@link DbT5502ShinsakaiWariateJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiWariateJoho}
     */
    @Override
    public ShinsakaiWariateJoho deleted() {
        DbT5502ShinsakaiWariateJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiWariateJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiWariateJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiWariateJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 6858126069994624792L;
        private final DbT5502ShinsakaiWariateJohoEntity entity;
        private final ShinsakaiWariateJohoIdentifier id;

        private _SerializationProxy(DbT5502ShinsakaiWariateJohoEntity entity, ShinsakaiWariateJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiWariateJoho(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiWariateJohoBuilder createBuilderForEdit() {
        return new ShinsakaiWariateJohoBuilder(entity, id);
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
        final ShinsakaiWariateJoho other = (ShinsakaiWariateJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
