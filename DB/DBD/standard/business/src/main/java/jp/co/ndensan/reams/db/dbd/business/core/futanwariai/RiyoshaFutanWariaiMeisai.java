/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.futanwariai;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担割合明細を管理するクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiMeisai
        extends ModelBase<RiyoshaFutanWariaiMeisaiIdentifier, DbT3114RiyoshaFutanWariaiMeisaiEntity, RiyoshaFutanWariaiMeisai>
        implements Serializable {

    private final DbT3114RiyoshaFutanWariaiMeisaiEntity entity;
    private final RiyoshaFutanWariaiMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 利用者負担割合明細の新規作成時に使用します。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番号 枝番号
     */
    public RiyoshaFutanWariaiMeisai(FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            int 枝番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        this.entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        this.entity.setNendo(年度);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setEdaNo(枝番号);
        this.id = new RiyoshaFutanWariaiMeisaiIdentifier(
                年度,
                被保険者番号,
                履歴番号,
                枝番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3114RiyoshaFutanWariaiMeisaiEntity}より{@link RiyoshaFutanWariaiMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3114RiyoshaFutanWariaiMeisaiEntity}
     */
    public RiyoshaFutanWariaiMeisai(DbT3114RiyoshaFutanWariaiMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細"));
        this.id = new RiyoshaFutanWariaiMeisaiIdentifier(
                entity.getNendo(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getEdaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}
     * @param id {@link RiyoshaFutanWariaiMeisaiIdentifier}
     */
    RiyoshaFutanWariaiMeisai(
            DbT3114RiyoshaFutanWariaiMeisaiEntity entity,
            RiyoshaFutanWariaiMeisaiIdentifier id
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
     * 枝番号を返します。
     *
     * @return 枝番号
     */
    public int get枝番号() {
        return entity.getEdaNo();
    }

    /**
     * 資格区分を返します。
     *
     * @return 資格区分
     */
    public RString get資格区分() {
        return entity.getShikakuKubun();
    }

    /**
     * 負担割合区分を返します。
     *
     * @return 負担割合区分
     */
    public RString get負担割合区分() {
        return entity.getFutanWariaiKubun();
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 本人合計所得金額を返します。
     *
     * @return 本人合計所得金額
     */
    public Decimal get本人合計所得金額() {
        return entity.getHonninGoukeiShotokuGaku();
    }

    /**
     * 世帯１号被保険者数を返します。
     *
     * @return 世帯１号被保険者数
     */
    public int get世帯１号被保険者数() {
        return entity.getSetaiIchigouHihokenshaSu();
    }

    /**
     * 年金収入合計を返します。
     *
     * @return 年金収入合計
     */
    public Decimal get年金収入合計() {
        return entity.getNenkinShunyuGoukei();
    }

    /**
     * その他の合計所得金額合計を返します。
     *
     * @return その他の合計所得金額合計
     */
    public Decimal getその他の合計所得金額合計() {
        return entity.getSonotanoGoukeiShotokuKingakuGoukei();
    }

    /**
     * 更正理由を返します。
     *
     * @return 更正理由
     */
    public RString get更正理由() {
        return entity.getKoseiRiyu();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCd();
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
     * {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}のクローン
     */
    @Override
    public DbT3114RiyoshaFutanWariaiMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 利用者負担割合明細の識別子{@link RiyoshaFutanWariaiMeisaiIdentifier}を返します。
     *
     * @return 利用者負担割合明細の識別子{@link RiyoshaFutanWariaiMeisaiIdentifier}
     */
    @Override
    public RiyoshaFutanWariaiMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する利用者負担割合明細を削除対象とします。<br/>
     * {@link DbT3114RiyoshaFutanWariaiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RiyoshaFutanWariaiMeisai}
     */
    @Override
    public RiyoshaFutanWariaiMeisai deleted() {
        DbT3114RiyoshaFutanWariaiMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RiyoshaFutanWariaiMeisai(deletedEntity, id);
    }

    /**
     * {@link RiyoshaFutanWariaiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link RiyoshaFutanWariaiMeisai}のシリアライズ形式
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
    public RiyoshaFutanWariaiMeisai modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getRiyoshaFutanWariaiKonkyoList
     *
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public List<RiyoshaFutanWariaiKonkyo> getRiyoshaFutanWariaiKonkyoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3114RiyoshaFutanWariaiMeisaiEntity entity;
        private final RiyoshaFutanWariaiMeisaiIdentifier id;

        private _SerializationProxy(DbT3114RiyoshaFutanWariaiMeisaiEntity entity, RiyoshaFutanWariaiMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RiyoshaFutanWariaiMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RiyoshaFutanWariaiMeisaiBuilder createBuilderForEdit() {
        return new RiyoshaFutanWariaiMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
