/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給判定結果を管理するクラスです。
 */
public class ShokanHanteiKekka
        extends ModelBase<ShokanHanteiKekkaIdentifier, DbT3036ShokanHanteiKekkaEntity, ShokanHanteiKekka> implements Serializable {

    private final DbT3036ShokanHanteiKekkaEntity entity;
    private final ShokanHanteiKekkaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払支給判定結果の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     */
    public ShokanHanteiKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        this.entity = new DbT3036ShokanHanteiKekkaEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.id = new ShokanHanteiKekkaIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3036ShokanHanteiKekkaEntity}より{@link ShokanHanteiKekka}を生成します。
     *
     * @param entity DBより取得した{@link DbT3036ShokanHanteiKekkaEntity}
     */
    public ShokanHanteiKekka(DbT3036ShokanHanteiKekkaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給判定結果"));
        this.id = new ShokanHanteiKekkaIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3036ShokanHanteiKekkaEntity}
     * @param id {@link ShokanHanteiKekkaIdentifier}
     */
    ShokanHanteiKekka(
            DbT3036ShokanHanteiKekkaEntity entity,
            ShokanHanteiKekkaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 支給・不支給決定区分を返します。
     *
     * @return 支給・不支給決定区分
     */
    public RString get支給_不支給決定区分() {
        return entity.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public Decimal get支払金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 支払金額内訳・利用者分を返します。
     *
     * @return 支払金額内訳・利用者分
     */
    public Decimal get支払金額内訳_利用者分() {
        return entity.getShiharaiKingakuUchiwakeRiyoshabun();
    }

    /**
     * 決定一覧取込年月を返します。
     *
     * @return 決定一覧取込年月
     */
    public FlexibleYearMonth get決定一覧取込年月() {
        return entity.getKetteiIchiranTorikomiYM();
    }

    /**
     * {@link DbT3036ShokanHanteiKekkaEntity}のクローンを返します。
     *
     * @return {@link DbT3036ShokanHanteiKekkaEntity}のクローン
     */
    @Override
    public DbT3036ShokanHanteiKekkaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払支給判定結果の識別子{@link ShokanHanteiKekkaIdentifier}を返します。
     *
     * @return 償還払支給判定結果の識別子{@link ShokanHanteiKekkaIdentifier}
     */
    @Override
    public ShokanHanteiKekkaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払支給判定結果を削除対象とします。<br/> {@link DbT3036ShokanHanteiKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanHanteiKekka}
     */
    @Override
    public ShokanHanteiKekka deleted() {
        DbT3036ShokanHanteiKekkaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanHanteiKekka(deletedEntity, id);
    }

    /**
     * 保持する償還払支給判定結果を更新対象とします。<br/> {@link DbT3036ShokanHanteiKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば更新状態にします。
     *
     * @return 更新対象処理実施後の{@link ShokanHanteiKekka}
     */
    public ShokanHanteiKekka modified() {
        DbT3036ShokanHanteiKekkaEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanHanteiKekka(modifiedEntity, id);
    }

    /**
     * 保持する償還払支給判定結果を新規対象とします。<br/> {@link DbT3036ShokanHanteiKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば新規状態にします。
     *
     * @return 新規対象処理実施後の{@link ShokanHanteiKekka}
     */
    public ShokanHanteiKekka added() {
        DbT3036ShokanHanteiKekkaEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ShokanHanteiKekka(addedEntity, id);
    }

    /**
     * {@link ShokanHanteiKekka}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanHanteiKekka}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3036ShokanHanteiKekkaEntity entity;
        private final ShokanHanteiKekkaIdentifier id;

        private _SerializationProxy(DbT3036ShokanHanteiKekkaEntity entity, ShokanHanteiKekkaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanHanteiKekka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanHanteiKekkaBuilder createBuilderForEdit() {
        return new ShokanHanteiKekkaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
