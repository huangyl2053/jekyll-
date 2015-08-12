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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為損害賠償金受領を管理するクラスです。
 */
public class DaisanshaKoiSongaiBaishoKinJuryo extends ParentModelBase<DaisanshaKoiSongaiBaishoKinJuryoIdentifier, DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity, DaisanshaKoiSongaiBaishoKinJuryo> implements Serializable {

    private final DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity;
    private final DaisanshaKoiSongaiBaishoKinJuryoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為損害賠償金受領の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiSongaiBaishoKinJuryo(HihokenshaNo 被保険者番号,
RString 第三者行為届出管理番号,
RString 第三者行為求償請求番号,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setKyushoSeikyuNo(第三者行為求償請求番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiSongaiBaishoKinJuryoIdentifier(
        被保険者番号,
        第三者行為届出管理番号,
        第三者行為求償請求番号,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}より{@link DaisanshaKoiSongaiBaishoKinJuryo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}
     */
    public DaisanshaKoiSongaiBaishoKinJuryo(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為損害賠償金受領"));
        this.id = new DaisanshaKoiSongaiBaishoKinJuryoIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getKyushoSeikyuNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}
     * @param id {@link DaisanshaKoiSongaiBaishoKinJuryoIdentifier}
     */
    DaisanshaKoiSongaiBaishoKinJuryo(
            DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity,
            DaisanshaKoiSongaiBaishoKinJuryoIdentifier id
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
     * 入金確認年月日を返します。
     *
     * @return 入金確認年月日
     */
    public FlexibleDate get入金確認年月日() {
        return entity.getNyukinKakuninYMD();
    }

    /**
     * 領収年月日を返します。
     *
     * @return 領収年月日
     */
    public FlexibleDate get領収年月日() {
        return entity.getRyoshuYMD();
    }

    /**
     * 領収金額を返します。
     *
     * @return 領収金額
     */
    public Decimal get領収金額() {
        return entity.getRyoshuKingaku();
    }

    /**
     * 過不足金有無を返します。
     *
     * @return 過不足金有無
     */
    public RString get過不足金有無() {
        return entity.getMabusokuKinUMU();
    }

    /**
     * 過不足額を返します。
     *
     * @return 過不足額
     */
    public Decimal get過不足額() {
        return entity.getKabusokuGaku();
    }

    /**
     * {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}のクローンを返します。
     *
     * @return {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}のクローン
     */
    @Override
    public DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為損害賠償金受領の識別子{@link DaisanshaKoiSongaiBaishoKinJuryoIdentifier}を返します。
     *
     * @return 介護第三者行為損害賠償金受領の識別子{@link DaisanshaKoiSongaiBaishoKinJuryoIdentifier}
     */
    @Override
    public DaisanshaKoiSongaiBaishoKinJuryoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護第三者行為損害賠償金受領のみを変更対象とします。<br/>
     * {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DaisanshaKoiSongaiBaishoKinJuryo}
     */
    @Override
    public DaisanshaKoiSongaiBaishoKinJuryo modifiedModel() {
        DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DaisanshaKoiSongaiBaishoKinJuryo(
                modifiedEntity, id);
    }

    /**
     * 保持する介護第三者行為損害賠償金受領を削除対象とします。<br/>
     * {@link DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiSongaiBaishoKinJuryo}
     */
    @Override
    public DaisanshaKoiSongaiBaishoKinJuryo deleted() {
        DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiSongaiBaishoKinJuryo(deletedEntity, id);
    }
    /**
     * {@link DaisanshaKoiSongaiBaishoKinJuryo}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiSongaiBaishoKinJuryo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity;
        private final DaisanshaKoiSongaiBaishoKinJuryoIdentifier id;

        private _SerializationProxy(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity,DaisanshaKoiSongaiBaishoKinJuryoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiSongaiBaishoKinJuryo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiSongaiBaishoKinJuryoBuilder createBuilderForEdit() {
        return new DaisanshaKoiSongaiBaishoKinJuryoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
