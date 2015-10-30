/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tennyushibo;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 転入・死亡情報を管理するクラスです。
 */
public class TennyuShibo extends ModelBase<TennyuShiboIdentifier, DbT5129TennyuShiboEntity, TennyuShibo> implements Serializable {

    private final DbT5129TennyuShiboEntity entity;
    private final TennyuShiboIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 転入・死亡情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public TennyuShibo(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5129TennyuShiboEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new TennyuShiboIdentifier(
                申請書管理番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5129TennyuShiboEntity}より{@link TennyuShibo}を生成します。
     *
     * @param entity DBより取得した{@link DbT5129TennyuShiboEntity}
     */
    public TennyuShibo(DbT5129TennyuShiboEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転入・死亡情報"));
        this.id = new TennyuShiboIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5129TennyuShiboEntity}
     * @param id {@link TennyuShiboIdentifier}
     */
    TennyuShibo(
            DbT5129TennyuShiboEntity entity,
            TennyuShiboIdentifier id
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
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    public int get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 二時判定認定有効開始年月日を返します。
     *
     * @return 二時判定認定有効開始年月日
     */
    public FlexibleDate get二時判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二時判定認定有効終了年月日を返します。
     *
     * @return 二時判定認定有効終了年月日
     */
    public FlexibleDate get二時判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
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
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    public RString get一次判定結果変更理由() {
        return entity.getIchijiHanteiKekkaHenkoRiyu();
    }

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    public Code get要介護状態像例コード() {
        return entity.getYokaigoJotaizoReiCode();
    }

    /**
     * 認定審査会意見種類を返します。
     *
     * @return 認定審査会意見種類
     */
    public RString get認定審査会意見種類() {
        return entity.getNinteishinsakaiIkenShurui();
    }

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return entity.getShinsakaiMemo();
    }

    /**
     * 二次判定結果入力方法を返します。
     *
     * @return 二次判定結果入力方法
     */
    public Code get二次判定結果入力方法() {
        return entity.getNijiHanteiKekkaInputHoho();
    }

    /**
     * 二次判定結果入力年月日を返します。
     *
     * @return 二次判定結果入力年月日
     */
    public FlexibleDate get二次判定結果入力年月日() {
        return entity.getNijiHanteiKekkaInputYMD();
    }

    /**
     * {@link DbT5129TennyuShiboEntity}のクローンを返します。
     *
     * @return {@link DbT5129TennyuShiboEntity}のクローン
     */
    @Override
    public DbT5129TennyuShiboEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 転入・死亡情報の識別子{@link TennyuShiboIdentifier}を返します。
     *
     * @return 転入・死亡情報の識別子{@link TennyuShiboIdentifier}
     */
    @Override
    public TennyuShiboIdentifier identifier() {
        return this.id;
    }

    /**
     * 転入・死亡情報のみを変更対象とします。<br/> {@link DbT5129TennyuShiboEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TennyuShibo}
     */
    public TennyuShibo modifiedModel() {
        DbT5129TennyuShiboEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TennyuShibo(
                modifiedEntity, id);
    }

    /**
     * 保持する転入・死亡情報を削除対象とします。<br/> {@link DbT5129TennyuShiboEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TennyuShibo}
     */
    @Override
    public TennyuShibo deleted() {
        DbT5129TennyuShiboEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TennyuShibo(deletedEntity, id);
    }

    /**
     * {@link TennyuShibo}のシリアライズ形式を提供します。
     *
     * @return {@link TennyuShibo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5129TennyuShiboEntity entity;
        private final TennyuShiboIdentifier id;

        private _SerializationProxy(DbT5129TennyuShiboEntity entity, TennyuShiboIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TennyuShibo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TennyuShiboBuilder createBuilderForEdit() {
        return new TennyuShiboBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final TennyuShibo other = (TennyuShibo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
