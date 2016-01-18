/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層該当者を管理するクラスです。
 */
public class KyokaisoGaitosha extends ModelBase<KyokaisoGaitoshaIdentifier, DbT1006KyokaisoGaitoshaEntity, KyokaisoGaitosha> implements Serializable {

    private final DbT1006KyokaisoGaitoshaEntity entity;
    private final KyokaisoGaitoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 境界層該当者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KyokaisoGaitosha(HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT1006KyokaisoGaitoshaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyokaisoGaitoshaIdentifier(
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1006KyokaisoGaitoshaEntity}より{@link KyokaisoGaitosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1006KyokaisoGaitoshaEntity}
     */
    public KyokaisoGaitosha(DbT1006KyokaisoGaitoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者"));
        this.id = new KyokaisoGaitoshaIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1006KyokaisoGaitoshaEntity}
     * @param id {@link KyokaisoGaitoshaIdentifier}
     */
    KyokaisoGaitosha(
            DbT1006KyokaisoGaitoshaEntity entity,
            KyokaisoGaitoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 境界層措置決定年月日を返します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.getKyokaisoSochiKetteiYMD();
    }

    /**
     * 給付額減額記載解除フラグを返します。
     *
     * @return 給付額減額記載解除フラグ
     */
    public RString get給付額減額記載解除フラグ() {
        return entity.getKyuufugakuGengakuKisaiKiajoFlag();
    }

    /**
     * 標準負担額額該当フラグを返します。
     *
     * @return 標準負担額額該当フラグ
     */
    public RString get標準負担額額該当フラグ() {
        return entity.getHyojunFutanGengakuGaitoFlag();
    }

    /**
     * 標準負担軽減後負担額を返します。
     *
     * @return 標準負担軽減後負担額
     */
    public Decimal get標準負担軽減後負担額() {
        return entity.getHyojunFutanKeigengoFutangaku();
    }

    /**
     * 居住費等負担額減額該当フラグを返します。
     *
     * @return 居住費等負担額減額該当フラグ
     */
    public RString get居住費等負担額減額該当フラグ() {
        return entity.getKyojuhinadoFutangakugengakuGaitoFlag();
    }

    /**
     * 居住費軽減後居室種類コードを返します。
     *
     * @return 居住費軽減後居室種類コード
     */
    public RString get居住費軽減後居室種類コード() {
        return entity.getKyojuhiKeigengoKyoshitsuShuruiCode();
    }

    /**
     * 居住費軽減後負担額を返します。
     *
     * @return 居住費軽減後負担額
     */
    public Decimal get居住費軽減後負担額() {
        return entity.getKyojuhiKeigengoHutangaku();
    }

    /**
     * 食費負担額減額該当フラグを返します。
     *
     * @return 食費負担額減額該当フラグ
     */
    public RString get食費負担額減額該当フラグ() {
        return entity.getShokuhiKeigengoHutangakuGaitoFlag();
    }

    /**
     * 食費軽減後負担額を返します。
     *
     * @return 食費軽減後負担額
     */
    public Decimal get食費軽減後負担額() {
        return entity.getShokuhiKeigengoHutangaku();
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを返します。
     *
     * @return 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public RString get高額ｻｰﾋﾞｽ費上限額減額該当フラグ() {
        return entity.getKogakuServicehiJogengakuGengakuGaitoFlag();
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を返します。
     *
     * @return 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public Decimal get高額ｻｰﾋﾞｽ費減額後上限額() {
        return entity.getKogakuServicehiJogengakuGengakugoJogengaku();
    }

    /**
     * 保険料納付減額フラグを返します。
     *
     * @return 保険料納付減額フラグ
     */
    public RString get保険料納付減額フラグ() {
        return entity.getHokenryoNofuGengakuFlag();
    }

    /**
     * {@link DbT1006KyokaisoGaitoshaEntity}のクローンを返します。
     *
     * @return {@link DbT1006KyokaisoGaitoshaEntity}のクローン
     */
    @Override
    public DbT1006KyokaisoGaitoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 境界層該当者の識別子{@link KyokaisoGaitoshaIdentifier}を返します。
     *
     * @return 境界層該当者の識別子{@link KyokaisoGaitoshaIdentifier}
     */
    @Override
    public KyokaisoGaitoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する境界層該当者を削除対象とします。<br/>
     * {@link DbT1006KyokaisoGaitoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyokaisoGaitosha}
     */
    @Override
    public KyokaisoGaitosha deleted() {
        DbT1006KyokaisoGaitoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyokaisoGaitosha(deletedEntity, id);
    }

    /**
     * {@link KyokaisoGaitosha}のシリアライズ形式を提供します。
     *
     * @return {@link KyokaisoGaitosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    /**
     * 境界層該当者情報のみを変更対象とします。<br/>
     * {@link DbT1006KyokaisoGaitoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyokaisoGaitosha}
     */
    public KyokaisoGaitosha modifiedModel() {
        DbT1006KyokaisoGaitoshaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyokaisoGaitosha(
                modifiedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -4772548934045114858L;
        private final DbT1006KyokaisoGaitoshaEntity entity;
        private final KyokaisoGaitoshaIdentifier id;

        private _SerializationProxy(DbT1006KyokaisoGaitoshaEntity entity, KyokaisoGaitoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyokaisoGaitosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyokaisoGaitoshaBuilder createBuilderForEdit() {
        return new KyokaisoGaitoshaBuilder(entity, id);
    }
}
