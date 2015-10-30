/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為求償を管理するクラスです。
 */
public class DaisanshaKoiKyusho
        extends ModelBase<DaisanshaKoiKyushoIdentifier, DbT3082DaisanshaKoiKyushoEntity, DaisanshaKoiKyusho>
        implements Serializable {

    private final DbT3082DaisanshaKoiKyushoEntity entity;
    private final DaisanshaKoiKyushoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為求償の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiKyusho(HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3082DaisanshaKoiKyushoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setKyushoSeikyuNo(第三者行為求償請求番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiKyushoIdentifier(
                被保険者番号,
                第三者行為届出管理番号,
                第三者行為求償請求番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3082DaisanshaKoiKyushoEntity}より{@link DaisanshaKoiKyusho}を生成します。
     *
     * @param entity DBより取得した{@link DbT3082DaisanshaKoiKyushoEntity}
     */
    public DaisanshaKoiKyusho(DbT3082DaisanshaKoiKyushoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為求償"));
        this.id = new DaisanshaKoiKyushoIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getKyushoSeikyuNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3082DaisanshaKoiKyushoEntity}
     * @param id {@link DaisanshaKoiKyushoIdentifier}
     */
    DaisanshaKoiKyusho(
            DbT3082DaisanshaKoiKyushoEntity entity,
            DaisanshaKoiKyushoIdentifier id
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
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
    }

    /**
     * 第三者行為求償請求番号を返します。
     *
     * @return 第三者行為求償請求番号
     */
    public RString get第三者行為求償請求番号() {
        return entity.getKyushoSeikyuNo();
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
     * 給付額合計を返します。
     *
     * @return 給付額合計
     */
    public Decimal get給付額合計() {
        return entity.getKyufuGakuGokei();
    }

    /**
     * 過失相殺額を返します。
     *
     * @return 過失相殺額
     */
    public Decimal get過失相殺額() {
        return entity.getKashitsuSosatsuGaku();
    }

    /**
     * 保険給付請求額を返します。
     *
     * @return 保険給付請求額
     */
    public Decimal get保険給付請求額() {
        return entity.getHokenKyufuSeikyuGaku();
    }

    /**
     * 損害賠償金納入期限を返します。
     *
     * @return 損害賠償金納入期限
     */
    public FlexibleDate get損害賠償金納入期限() {
        return entity.getSongaiBaishoKinNonyuYMD();
    }

    /**
     * 請求先郵便番号を返します。
     *
     * @return 請求先郵便番号
     */
    public YubinNo get請求先郵便番号() {
        return entity.getSeikyusakiYubinNo();
    }

    /**
     * 請求先住所を返します。
     *
     * @return 請求先住所
     */
    public RString get請求先住所() {
        return entity.getSeikyusakiJusho();
    }

    /**
     * 請求先名称を返します。
     *
     * @return 請求先名称
     */
    public AtenaMeisho get請求先名称() {
        return entity.getSeikyusakiMeisho();
    }

    /**
     * 請求先部署を返します。
     *
     * @return 請求先部署
     */
    public RString get請求先部署() {
        return entity.getSeikyusakiBusho();
    }

    /**
     * 請求先担当者を返します。
     *
     * @return 請求先担当者
     */
    public AtenaMeisho get請求先担当者() {
        return entity.getSeikyusakiTantosha();
    }

    /**
     * 請求先電話番号を返します。
     *
     * @return 請求先電話番号
     */
    public TelNo get請求先電話番号() {
        return entity.getSeikyusakiTelNo();
    }

    /**
     * {@link DbT3082DaisanshaKoiKyushoEntity}のクローンを返します。
     *
     * @return {@link DbT3082DaisanshaKoiKyushoEntity}のクローン
     */
    @Override
    public DbT3082DaisanshaKoiKyushoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為求償の識別子{@link DaisanshaKoiKyushoIdentifier}を返します。
     *
     * @return 介護第三者行為求償の識別子{@link DaisanshaKoiKyushoIdentifier}
     */
    @Override
    public DaisanshaKoiKyushoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護第三者行為求償を削除対象とします。<br/>
     * {@link DbT3082DaisanshaKoiKyushoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiKyusho}
     */
    @Override
    public DaisanshaKoiKyusho deleted() {
        DbT3082DaisanshaKoiKyushoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiKyusho(deletedEntity, id);
    }

    /**
     * {@link DaisanshaKoiKyusho}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiKyusho}のシリアライズ形式
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

        private final DbT3082DaisanshaKoiKyushoEntity entity;
        private final DaisanshaKoiKyushoIdentifier id;

        private _SerializationProxy(DbT3082DaisanshaKoiKyushoEntity entity, DaisanshaKoiKyushoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiKyusho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiKyushoBuilder createBuilderForEdit() {
        return new DaisanshaKoiKyushoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
