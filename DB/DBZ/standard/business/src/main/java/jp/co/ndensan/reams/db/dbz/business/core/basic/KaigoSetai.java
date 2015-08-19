/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護世帯を管理するクラスです。
 */
public class KaigoSetai extends ParentModelBase<KaigoSetaiIdentifier, DbT7014KaigoSetaiEntity, KaigoSetai> implements Serializable {

    private final DbT7014KaigoSetaiEntity entity;
    private final KaigoSetaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護世帯の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理識別区分 管理識別区分
     * @param 世帯把握基準年月日 世帯把握基準年月日
     * @param 世帯員管理連番 世帯員管理連番
     * @param 世帯員識別コード 世帯員識別コード
     * @param 本人区分 本人区分
     * @param 課税年度 課税年度
     * @param 課税非課税区分 課税非課税区分
     */
    public KaigoSetai(HihokenshaNo 被保険者番号,
            RString 管理識別区分,
            FlexibleDate 世帯把握基準年月日,
            int 世帯員管理連番,
            ShikibetsuCode 世帯員識別コード,
            RString 本人区分,
            FlexibleYear 課税年度,
            RString 課税非課税区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理識別区分"));
        requireNonNull(世帯把握基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯把握基準年月日"));
        requireNonNull(世帯員管理連番, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員管理連番"));
        requireNonNull(世帯員識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コード"));
        requireNonNull(本人区分, UrSystemErrorMessages.値がnull.getReplacedMessage("本人区分"));
        requireNonNull(課税年度, UrSystemErrorMessages.値がnull.getReplacedMessage("課税年度"));
        requireNonNull(課税非課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税非課税区分"));
        this.entity = new DbT7014KaigoSetaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriShikibetsuKubun(管理識別区分);
        this.entity.setSetaiHaakuKijunYMD(世帯把握基準年月日);
        this.entity.setSetaiInkanriRenban(世帯員管理連番);
        this.entity.setSetaiInshikibetsuCode(世帯員識別コード);
        this.entity.setHonninKubun(本人区分);
        this.entity.setKazeiNendo(課税年度);
        this.entity.setKazeiHikazeiKubun(課税非課税区分);
        this.id = new KaigoSetaiIdentifier(
                被保険者番号,
                管理識別区分,
                世帯把握基準年月日,
                世帯員管理連番,
                世帯員識別コード,
                本人区分,
                課税年度,
                課税非課税区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7014KaigoSetaiEntity}より{@link KaigoSetai}を生成します。
     *
     * @param entity DBより取得した{@link DbT7014KaigoSetaiEntity}
     */
    public KaigoSetai(DbT7014KaigoSetaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護世帯"));
        this.id = new KaigoSetaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getKanriShikibetsuKubun(),
                entity.getSetaiHaakuKijunYMD(),
                entity.getSetaiInkanriRenban(),
                entity.getSetaiInshikibetsuCode(),
                entity.getHonninKubun(),
                entity.getKazeiNendo(),
                entity.getKazeiHikazeiKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7014KaigoSetaiEntity}
     * @param id {@link KaigoSetaiIdentifier}
     */
    KaigoSetai(
            DbT7014KaigoSetaiEntity entity,
            KaigoSetaiIdentifier id
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
        return entity.getHihokenshaNo();
    }

    /**
     * 管理識別区分を返します。
     *
     * @return 管理識別区分
     */
    public RString get管理識別区分() {
        return entity.getKanriShikibetsuKubun();
    }

    /**
     * 世帯把握基準年月日を返します。
     *
     * @return 世帯把握基準年月日
     */
    public FlexibleDate get世帯把握基準年月日() {
        return entity.getSetaiHaakuKijunYMD();
    }

    /**
     * 世帯員管理連番を返します。
     *
     * @return 世帯員管理連番
     */
    public int get世帯員管理連番() {
        return entity.getSetaiInkanriRenban();
    }

    /**
     * 世帯員識別コードを返します。
     *
     * @return 世帯員識別コード
     */
    public ShikibetsuCode get世帯員識別コード() {
        return entity.getSetaiInshikibetsuCode();
    }

    /**
     * 本人区分を返します。
     *
     * @return 本人区分
     */
    public RString get本人区分() {
        return entity.getHonninKubun();
    }

    /**
     * 課税年度を返します。
     *
     * @return 課税年度
     */
    public FlexibleYear get課税年度() {
        return entity.getKazeiNendo();
    }

    /**
     * 課税非課税区分を返します。
     *
     * @return 課税非課税区分
     */
    public RString get課税非課税区分() {
        return entity.getKazeiHikazeiKubun();
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.getGokeiShotokuKingaku();
    }

    /**
     * 課税年金収入額を返します。
     *
     * @return 課税年金収入額
     */
    public Decimal get課税年金収入額() {
        return entity.getKazeiNenkinShunyugaku();
    }

    /**
     * {@link DbT7014KaigoSetaiEntity}のクローンを返します。
     *
     * @return {@link DbT7014KaigoSetaiEntity}のクローン
     */
    @Override
    public DbT7014KaigoSetaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護世帯の識別子{@link KaigoSetaiIdentifier}を返します。
     *
     * @return 介護世帯の識別子{@link KaigoSetaiIdentifier}
     */
    @Override
    public KaigoSetaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護世帯のみを変更対象とします。<br/>
     * {@link DbT7014KaigoSetaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoSetai}
     */
    @Override
    public KaigoSetai modifiedModel() {
        DbT7014KaigoSetaiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoSetai(
                modifiedEntity, id);
    }

    /**
     * 保持する介護世帯を削除対象とします。<br/>
     * {@link DbT7014KaigoSetaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoSetai}
     */
    @Override
    public KaigoSetai deleted() {
        DbT7014KaigoSetaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoSetai(deletedEntity, id);
    }

    /**
     * {@link KaigoSetai}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoSetai}のシリアライズ形式
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
        private final DbT7014KaigoSetaiEntity entity;
        private final KaigoSetaiIdentifier id;

        private _SerializationProxy(DbT7014KaigoSetaiEntity entity, KaigoSetaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoSetai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoSetaiBuilder createBuilderForEdit() {
        return new KaigoSetaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
