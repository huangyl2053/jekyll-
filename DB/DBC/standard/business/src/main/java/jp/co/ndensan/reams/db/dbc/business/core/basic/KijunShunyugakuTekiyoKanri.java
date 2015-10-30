/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 基準収入額適用管理を管理するクラスです。
 */
public class KijunShunyugakuTekiyoKanri
        extends ModelBase<KijunShunyugakuTekiyoKanriIdentifier, DbT3116KijunShunyugakuTekiyoKanriEntity, KijunShunyugakuTekiyoKanri>
        implements Serializable {

    private final DbT3116KijunShunyugakuTekiyoKanriEntity entity;
    private final KijunShunyugakuTekiyoKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 基準収入額適用管理の新規作成時に使用します。
     *
     * @param 世帯コード 世帯コード
     * @param 年度 年度
     * @param 履歴番号 履歴番号
     * @param 被保険者番号 被保険者番号
     */
    public KijunShunyugakuTekiyoKanri(SetaiCode 世帯コード,
            FlexibleYear 年度,
            Decimal 履歴番号,
            HokenshaNo 被保険者番号) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.entity = new DbT3116KijunShunyugakuTekiyoKanriEntity();
        this.entity.setSetaiCode(世帯コード);
        this.entity.setNendo(年度);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.id = new KijunShunyugakuTekiyoKanriIdentifier(
                世帯コード,
                年度,
                履歴番号,
                被保険者番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3116KijunShunyugakuTekiyoKanriEntity}より{@link KijunShunyugakuTekiyoKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT3116KijunShunyugakuTekiyoKanriEntity}
     */
    public KijunShunyugakuTekiyoKanri(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("基準収入額適用管理"));
        this.id = new KijunShunyugakuTekiyoKanriIdentifier(
                entity.getSetaiCode(),
                entity.getNendo(),
                entity.getRirekiNo(),
                entity.getHihokenshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3116KijunShunyugakuTekiyoKanriEntity}
     * @param id {@link KijunShunyugakuTekiyoKanriIdentifier}
     */
    KijunShunyugakuTekiyoKanri(
            DbT3116KijunShunyugakuTekiyoKanriEntity entity,
            KijunShunyugakuTekiyoKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCode();
    }

    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 公的年金収入額を返します。
     *
     * @return 公的年金収入額
     */
    public Decimal get公的年金収入額() {
        return entity.getKotekiNenkinShunyugaku();
    }

    /**
     * 給与収入額を返します。
     *
     * @return 給与収入額
     */
    public Decimal get給与収入額() {
        return entity.getKyuyoShunyugaku();
    }

    /**
     * その他の収入額を返します。
     *
     * @return その他の収入額
     */
    public Decimal getその他の収入額() {
        return entity.getSonotaShunyugaku();
    }

    /**
     * 算定基準額を返します。
     *
     * @return 算定基準額
     */
    public Decimal get算定基準額() {
        return entity.getSanteiKijungaku();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 申請日を返します。
     *
     * @return 申請日
     */
    public FlexibleDate get申請日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定日を返します。
     *
     * @return 決定日
     */
    public FlexibleDate get決定日() {
        return entity.getKetteiYMD();
    }

    /**
     * 申請書作成日を返します。
     *
     * @return 申請書作成日
     */
    public FlexibleDate get申請書作成日() {
        return entity.getShinseishoSakuseiYMD();
    }

    /**
     * 申請書作成の世帯基準日を返します。
     *
     * @return 申請書作成の世帯基準日
     */
    public FlexibleDate get申請書作成の世帯基準日() {
        return entity.getShinseishoSakuseiSetaiKijunYMD();
    }

    /**
     * 決定通知書発行日を返します。
     *
     * @return 決定通知書発行日
     */
    public FlexibleDate get決定通知書発行日() {
        return entity.getKetteiTsuchishoHakkoYMD();
    }

    /**
     * 宛先印字対象者フラグを返します。
     *
     * @return 宛先印字対象者フラグ
     */
    public boolean is宛先印字対象者フラグ() {
        return entity.getAtesakiInjiTaishoshaFlag();
    }

    /**
     * 年少扶養控除（16歳未満）人数を返します。
     *
     * @return 年少扶養控除（16歳未満）人数
     */
    public Decimal get年少扶養控除_16歳未満人数() {
        return entity.getNenshoFuyokojoUnder16Ninzu();
    }

    /**
     * 年少扶養控除（16～18歳未満）人数を返します。
     *
     * @return 年少扶養控除（16～18歳未満）人数
     */
    public Decimal get年少扶養控除_16から18歳未満人数() {
        return entity.getNenshoFuyokojoOver16Ninzu();
    }

    /**
     * 世帯員の総収入額を返します。
     *
     * @return 世帯員の総収入額
     */
    public Decimal get世帯員の総収入額() {
        return entity.getSetaiinSoShunyugaku();
    }

    /**
     * 世帯主フラグを返します。
     *
     * @return 世帯主フラグ
     */
    public boolean is世帯主フラグ() {
        return entity.getSetainushiFlag();
    }

    /**
     * 課税所得額を返します。
     *
     * @return 課税所得額
     */
    public Decimal get課税所得額() {
        return entity.getKazeiShotokugaku();
    }

    /**
     * 課税所得額（控除後）を返します。
     *
     * @return 課税所得額（控除後）
     */
    public Decimal get課税所得額_控除後() {
        return entity.getKazeiShotokugakuKojogo();
    }

    /**
     * {@link DbT3116KijunShunyugakuTekiyoKanriEntity}のクローンを返します。
     *
     * @return {@link DbT3116KijunShunyugakuTekiyoKanriEntity}のクローン
     */
    @Override
    public DbT3116KijunShunyugakuTekiyoKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 基準収入額適用管理の識別子{@link KijunShunyugakuTekiyoKanriIdentifier}を返します。
     *
     * @return 基準収入額適用管理の識別子{@link KijunShunyugakuTekiyoKanriIdentifier}
     */
    @Override
    public KijunShunyugakuTekiyoKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する基準収入額適用管理を削除対象とします。<br/>
     * {@link DbT3116KijunShunyugakuTekiyoKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KijunShunyugakuTekiyoKanri}
     */
    @Override
    public KijunShunyugakuTekiyoKanri deleted() {
        DbT3116KijunShunyugakuTekiyoKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KijunShunyugakuTekiyoKanri(deletedEntity, id);
    }

    /**
     * {@link KijunShunyugakuTekiyoKanri}のシリアライズ形式を提供します。
     *
     * @return {@link KijunShunyugakuTekiyoKanri}のシリアライズ形式
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

        private final DbT3116KijunShunyugakuTekiyoKanriEntity entity;
        private final KijunShunyugakuTekiyoKanriIdentifier id;

        private _SerializationProxy(DbT3116KijunShunyugakuTekiyoKanriEntity entity, KijunShunyugakuTekiyoKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KijunShunyugakuTekiyoKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KijunShunyugakuTekiyoKanriBuilder createBuilderForEdit() {
        return new KijunShunyugakuTekiyoKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
