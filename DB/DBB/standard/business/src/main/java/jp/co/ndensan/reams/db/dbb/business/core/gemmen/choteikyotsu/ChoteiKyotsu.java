/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.gemmen.choteikyotsu;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調定共通（介護継承）を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ChoteiKyotsu extends ModelBase<ChoteiKyotsuIdentifier, UrT0705ChoteiKyotsuEntity, ChoteiKyotsu> implements Serializable {

    private final UrT0705ChoteiKyotsuEntity entity;
    private final ChoteiKyotsuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 調定共通（介護継承）の新規作成時に使用します。
     *
     * @param 調定ID 調定ID
     */
    public ChoteiKyotsu(Long 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        this.entity = new UrT0705ChoteiKyotsuEntity();
        this.entity.setChoteiId(調定ID);
        this.id = new ChoteiKyotsuIdentifier(
                調定ID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0705ChoteiKyotsuEntity}より{@link ChoteiKyotsu}を生成します。
     *
     * @param entity DBより取得した{@link UrT0705ChoteiKyotsuEntity}
     */
    public ChoteiKyotsu(UrT0705ChoteiKyotsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調定共通（介護継承）"));
        this.id = new ChoteiKyotsuIdentifier(
                entity.getChoteiId());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UrT0705ChoteiKyotsuEntity}
     * @param id {@link ChoteiKyotsuIdentifier}
     */
    ChoteiKyotsu(
            UrT0705ChoteiKyotsuEntity entity,
            ChoteiKyotsuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調定IDを返します。
     *
     * @return 調定ID
     */
    public Long get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * 収納IDを返します。
     *
     * @return 収納ID
     */
    public Long get収納ID() {
        return entity.getShunoId();
    }

    /**
     * 会計年度を返します。
     *
     * @return 会計年度
     */
    public RYear get会計年度() {
        return entity.getKaikeiNendo();
    }

    /**
     * 処理年度を返します。
     *
     * @return 処理年度
     */
    public RYear get処理年度() {
        return entity.getShoriNendo();
    }

    /**
     * 処理番号を返します。
     *
     * @return 処理番号
     */
    public long get処理番号() {
        return entity.getShoriNo();
    }

    /**
     * 更正回数を返します。
     *
     * @return 更正回数
     */
    public int get更正回数() {
        return entity.getKoseiKaisu();
    }

    /**
     * 調定事由コードを返します。
     *
     * @return 調定事由コード
     */
    public RString get調定事由コード() {
        return entity.getChoteiJiyuCode();
    }

    /**
     * 調定年月日を返します。
     *
     * @return 調定年月日
     */
    public RDate get調定年月日() {
        return entity.getChoteiYMD();
    }

    /**
     * 調定額を返します。
     *
     * @return 調定額
     */
    public Decimal get調定額() {
        return entity.getChoteigaku();
    }

    /**
     * 消費税額を返します。
     *
     * @return 消費税額
     */
    public Decimal get消費税額() {
        return entity.getShohizei();
    }

    /**
     * 納期限を返します。
     *
     * @return 納期限
     */
    public RDate get納期限() {
        return entity.getNokigenYMD();
    }

    /**
     * 法定納期限等を返します。
     *
     * @return 法定納期限等
     */
    public RDate get法定納期限等() {
        return entity.getHoteiNokigenToYMD();
    }

    /**
     * 賦課処理状況を返します。
     *
     * @return 賦課処理状況
     */
    public boolean is賦課処理状況() {
        return entity.getFukaShoriJokyo();
    }

    /**
     * {@link UrT0705ChoteiKyotsuEntity}のクローンを返します。
     *
     * @return {@link UrT0705ChoteiKyotsuEntity}のクローン
     */
    @Override
    public UrT0705ChoteiKyotsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 調定共通（介護継承）の識別子{@link ChoteiKyotsuIdentifier}を返します。
     *
     * @return 調定共通（介護継承）の識別子{@link ChoteiKyotsuIdentifier}
     */
    @Override
    public ChoteiKyotsuIdentifier identifier() {
        return this.id;
    }

    /**
     * 調定共通（介護継承）のみを変更対象とします。<br/> {@link UrT0705ChoteiKyotsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChoteiKyotsu}
     */
    public ChoteiKyotsu modifiedModel() {
        UrT0705ChoteiKyotsuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChoteiKyotsu(
                modifiedEntity, id);
    }

    /**
     * 保持する調定共通（介護継承）を削除対象とします。<br/> {@link UrT0705ChoteiKyotsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChoteiKyotsu}
     */
    @Override
    public ChoteiKyotsu deleted() {
        UrT0705ChoteiKyotsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChoteiKyotsu(deletedEntity, id);
    }

    /**
     * {@link ChoteiKyotsu}のシリアライズ形式を提供します。
     *
     * @return {@link ChoteiKyotsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5095453488456527348L;
        private final UrT0705ChoteiKyotsuEntity entity;
        private final ChoteiKyotsuIdentifier id;

        private _SerializationProxy(UrT0705ChoteiKyotsuEntity entity, ChoteiKyotsuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChoteiKyotsu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChoteiKyotsuBuilder createBuilderForEdit() {
        return new ChoteiKyotsuBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.entity);
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final ChoteiKyotsu other = (ChoteiKyotsu) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    private static final long serialVersionUID = -5095453488456527348L;

}
