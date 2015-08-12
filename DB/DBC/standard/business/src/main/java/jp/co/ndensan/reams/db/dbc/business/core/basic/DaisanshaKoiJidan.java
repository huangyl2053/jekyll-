/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為示談を管理するクラスです。
 */
public class DaisanshaKoiJidan extends ParentModelBase<DaisanshaKoiJidanIdentifier, DbT3080DaisanshaKoiJidanEntity, DaisanshaKoiJidan> implements Serializable {

    private final DbT3080DaisanshaKoiJidanEntity entity;
    private final DaisanshaKoiJidanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為示談の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 示談報告書受付年月日 示談報告書受付年月日
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiJidan(HihokenshaNo 被保険者番号,
RString 第三者行為届出管理番号,
FlexibleDate 示談報告書受付年月日,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3080DaisanshaKoiJidanEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setJidanHokokushoUketukeYMD(示談報告書受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiJidanIdentifier(
        被保険者番号,
        第三者行為届出管理番号,
        示談報告書受付年月日,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3080DaisanshaKoiJidanEntity}より{@link DaisanshaKoiJidan}を生成します。
     *
     * @param entity DBより取得した{@link DbT3080DaisanshaKoiJidanEntity}
     */
    public DaisanshaKoiJidan(DbT3080DaisanshaKoiJidanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為示談"));
        this.id = new DaisanshaKoiJidanIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getJidanHokokushoUketukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3080DaisanshaKoiJidanEntity}
     * @param id {@link DaisanshaKoiJidanIdentifier}
     */
    DaisanshaKoiJidan(
            DbT3080DaisanshaKoiJidanEntity entity,
            DaisanshaKoiJidanIdentifier id
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
     * 示談報告書受付年月日を返します。
     *
     * @return 示談報告書受付年月日
     */
    public FlexibleDate get示談報告書受付年月日() {
        return entity.getJidanHokokushoUketukeYMD();
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
     * 第三者行為求償協議区分を返します。
     *
     * @return 第三者行為求償協議区分
     */
    public RString get第三者行為求償協議区分() {
        return entity.getKyushoKyogiKubun();
    }

    /**
     * 示談報告書提出年月日を返します。
     *
     * @return 示談報告書提出年月日
     */
    public FlexibleDate get示談報告書提出年月日() {
        return entity.getJidanHokokushoTeishutsuYMD();
    }

    /**
     * 示談成立年月日を返します。
     *
     * @return 示談成立年月日
     */
    public FlexibleDate get示談成立年月日() {
        return entity.getJidanSeiritsuYMD();
    }

    /**
     * 給付期間開始年月を返します。
     *
     * @return 給付期間開始年月
     */
    public FlexibleYearMonth get給付期間開始年月() {
        return entity.getKyufuKaishiYMD();
    }

    /**
     * 給付期間終了年月を返します。
     *
     * @return 給付期間終了年月
     */
    public FlexibleYearMonth get給付期間終了年月() {
        return entity.getKyufuShuryoYMD();
    }

    /**
     * 過失割合・加害者を返します。
     *
     * @return 過失割合・加害者
     */
    public RString get過失割合・加害者() {
        return entity.getKashitsuWariai_Kagaisha();
    }

    /**
     * 過失割合・被害者を返します。
     *
     * @return 過失割合・被害者
     */
    public RString get過失割合・被害者() {
        return entity.getKashitsuWariai_Higaisha();
    }

    /**
     * {@link DbT3080DaisanshaKoiJidanEntity}のクローンを返します。
     *
     * @return {@link DbT3080DaisanshaKoiJidanEntity}のクローン
     */
    @Override
    public DbT3080DaisanshaKoiJidanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為示談の識別子{@link DaisanshaKoiJidanIdentifier}を返します。
     *
     * @return 介護第三者行為示談の識別子{@link DaisanshaKoiJidanIdentifier}
     */
    @Override
    public DaisanshaKoiJidanIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護第三者行為示談のみを変更対象とします。<br/>
     * {@link DbT3080DaisanshaKoiJidanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DaisanshaKoiJidan}
     */
    @Override
    public DaisanshaKoiJidan modifiedModel() {
        DbT3080DaisanshaKoiJidanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DaisanshaKoiJidan(
                modifiedEntity, id);
    }

    /**
     * 保持する介護第三者行為示談を削除対象とします。<br/>
     * {@link DbT3080DaisanshaKoiJidanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiJidan}
     */
    @Override
    public DaisanshaKoiJidan deleted() {
        DbT3080DaisanshaKoiJidanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiJidan(deletedEntity, id);
    }
    /**
     * {@link DaisanshaKoiJidan}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiJidan}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3080DaisanshaKoiJidanEntity entity;
        private final DaisanshaKoiJidanIdentifier id;

        private _SerializationProxy(DbT3080DaisanshaKoiJidanEntity entity,DaisanshaKoiJidanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiJidan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiJidanBuilder createBuilderForEdit() {
        return new DaisanshaKoiJidanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
