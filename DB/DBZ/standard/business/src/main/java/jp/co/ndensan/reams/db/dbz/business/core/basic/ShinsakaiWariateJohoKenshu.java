/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * @author n3213
 */
public class ShinsakaiWariateJohoKenshu extends
        ModelBase<ShinsakaiWariateJohoKenshuIdentifier, DbT5504ShinsakaiWariateJohoKenshuEntity, ShinsakaiWariateJohoKenshu> implements Serializable {
    
    private final DbT5504ShinsakaiWariateJohoKenshuEntity entity;
    private final ShinsakaiWariateJohoKenshuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定結果情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinsakaiWariateJohoKenshu(RString 介護認定審査会開催番号, ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5504ShinsakaiWariateJohoKenshuEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new ShinsakaiWariateJohoKenshuIdentifier(
                介護認定審査会開催番号,
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5102NinteiKekkaJohoEntity}より{@link NinteiKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5102NinteiKekkaJohoEntity}
     */
    public ShinsakaiWariateJohoKenshu(DbT5504ShinsakaiWariateJohoKenshuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会割付情報研修"));
        this.id = new ShinsakaiWariateJohoKenshuIdentifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5102NinteiKekkaJohoEntity}
     * @param id {@link NinteiKekkaJohoIdentifier}
     */
    ShinsakaiWariateJohoKenshu(DbT5504ShinsakaiWariateJohoKenshuEntity entity,
            ShinsakaiWariateJohoKenshuIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * {@link DbT5504ShinsakaiWariateJohoKenshuEntity}のクローンを返します。
     *
     * @return {@link DbT5504ShinsakaiWariateJohoKenshuEntity}のクローン
     */
    @Override
    public DbT5504ShinsakaiWariateJohoKenshuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定結果情報のみを変更対象とします。<br/>
     * {@link DbT5504ShinsakaiWariateJohoKenshuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiWariateJohoKenshu}
     */
    public ShinsakaiWariateJohoKenshu modifiedModel() {
        DbT5504ShinsakaiWariateJohoKenshuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiWariateJohoKenshu(
                modifiedEntity, id);
    }

    
    @Override
    public ShinsakaiWariateJohoKenshu deleted() {
        DbT5504ShinsakaiWariateJohoKenshuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiWariateJohoKenshu(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiWariateJohoKenshu}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiWariateJohoKenshu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 審査会割付情報研修の識別子{@link ShinsakaiWariateJohoKenshuIdentifier}を返します。
     *
     * @return 審査会割付情報研修の識別子{@link ShinsakaiWariateJohoKenshuIdentifier}
     */
    @Override
    public ShinsakaiWariateJohoKenshuIdentifier identifier() {
        return this.id;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5504ShinsakaiWariateJohoKenshuEntity entity;
        private final ShinsakaiWariateJohoKenshuIdentifier id;

        private _SerializationProxy(DbT5504ShinsakaiWariateJohoKenshuEntity entity, ShinsakaiWariateJohoKenshuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiWariateJohoKenshu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiWariateJohoKenshuBuilder createBuilderForEdit() {
        return new ShinsakaiWariateJohoKenshuBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiWariateJohoKenshu other = (ShinsakaiWariateJohoKenshu) obj;
        if (!Objects.equals(this.identifier(), other.identifier())) {
            return false;
        }
        return true;
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
}
