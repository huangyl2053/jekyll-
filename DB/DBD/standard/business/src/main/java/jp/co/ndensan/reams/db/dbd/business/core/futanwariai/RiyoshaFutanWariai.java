/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futanwariai;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担割合を管理するクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariai
        extends ModelBase<RiyoshaFutanWariaiIdentifier, DbT3113RiyoshaFutanWariaiEntity, RiyoshaFutanWariai> implements Serializable {

    private final DbT3113RiyoshaFutanWariaiEntity entity;
    private final RiyoshaFutanWariaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 利用者負担割合の新規作成時に使用します。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public RiyoshaFutanWariai(FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3113RiyoshaFutanWariaiEntity();
        this.entity.setNendo(年度);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new RiyoshaFutanWariaiIdentifier(
                年度,
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3113RiyoshaFutanWariaiEntity}より{@link RiyoshaFutanWariai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3113RiyoshaFutanWariaiEntity}
     */
    public RiyoshaFutanWariai(DbT3113RiyoshaFutanWariaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合"));
        this.id = new RiyoshaFutanWariaiIdentifier(
                entity.getNendo(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3113RiyoshaFutanWariaiEntity}
     * @param id {@link RiyoshaFutanWariaiIdentifier}
     */
    RiyoshaFutanWariai(
            DbT3113RiyoshaFutanWariaiEntity entity,
            RiyoshaFutanWariaiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 発行不要フラグを返します。
     *
     * @return 発行不要フラグ
     */
    public boolean is発行不要フラグ() {
        return entity.getHakoFuyoFlag();
    }

    /**
     * 職権変更フラグを返します。
     *
     * @return 職権変更フラグ
     */
    public boolean is職権変更フラグ() {
        return entity.getShokenFlag();
    }

    /**
     * 判定日を返します。
     *
     * @return 判定日
     */
    public FlexibleDate get判定日() {
        return entity.getHanteiYMD();
    }

    /**
     * 判定区分を返します。
     *
     * @return 判定区分
     */
    public RString get判定区分() {
        return entity.getHanteiKubun();
    }

    /**
     * 更正事由を返します。
     *
     * @return 更正事由
     */
    public Code get更正事由() {
        return entity.getKoseiJiyu();
    }

    /**
     * 発行区分を返します。
     *
     * @return 発行区分
     */
    public RString get発行区分() {
        return entity.getHakoKubun();
    }

    /**
     * 発行日を返します。
     *
     * @return 発行日
     */
    public FlexibleDate get発行日() {
        return entity.getHakoYMD();
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日
     */
    public FlexibleDate get交付日() {
        return entity.getKofuYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT3113RiyoshaFutanWariaiEntity}のクローンを返します。
     *
     * @return {@link DbT3113RiyoshaFutanWariaiEntity}のクローン
     */
    @Override
    public DbT3113RiyoshaFutanWariaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 利用者負担割合の識別子{@link RiyoshaFutanWariaiIdentifier}を返します。
     *
     * @return 利用者負担割合の識別子{@link RiyoshaFutanWariaiIdentifier}
     */
    @Override
    public RiyoshaFutanWariaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する利用者負担割合を削除対象とします。
     * <br/> {@link DbT3113RiyoshaFutanWariaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RiyoshaFutanWariai}
     */
    @Override
    public RiyoshaFutanWariai deleted() {
        DbT3113RiyoshaFutanWariaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RiyoshaFutanWariai(deletedEntity, id);
    }

    /**
     * {@link RiyoshaFutanWariai}のシリアライズ形式を提供します。
     *
     * @return {@link RiyoshaFutanWariai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * modifiedModel
     *
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public RiyoshaFutanWariai modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getRiyoshaFutanWariaiMeisaiList
     *
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public List<RiyoshaFutanWariaiMeisai> getRiyoshaFutanWariaiMeisaiList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3113RiyoshaFutanWariaiEntity entity;
        private final RiyoshaFutanWariaiIdentifier id;

        private _SerializationProxy(DbT3113RiyoshaFutanWariaiEntity entity, RiyoshaFutanWariaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RiyoshaFutanWariai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RiyoshaFutanWariaiBuilder createBuilderForEdit() {
        return new RiyoshaFutanWariaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
