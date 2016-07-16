/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更差止を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class ShiharaiHohoHenkoSashitome extends ModelBase<
        ShiharaiHohoHenkoSashitomeIdentifier, DbT4024ShiharaiHohoHenkoSashitomeEntity, ShiharaiHohoHenkoSashitome>
        implements Serializable {

    private final DbT4024ShiharaiHohoHenkoSashitomeEntity entity;
    private final ShiharaiHohoHenkoSashitomeIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 支払方法変更差止の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 情報分類区分 情報分類区分
     * @param 連番 連番
     */
    public ShiharaiHohoHenkoSashitome(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            RString 情報分類区分,
            int 連番) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(情報分類区分, UrSystemErrorMessages.値がnull.getReplacedMessage("情報分類区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT4024ShiharaiHohoHenkoSashitomeEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriKubun(管理区分);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setJohoBunruiKubun(情報分類区分);
        this.entity.setRenNo(連番);
        this.id = new ShiharaiHohoHenkoSashitomeIdentifier(
                証記載保険者番号,
                被保険者番号,
                管理区分,
                履歴番号,
                情報分類区分,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4024ShiharaiHohoHenkoSashitomeEntity}より{@link ShiharaiHohoHenkoSashitome}を生成します。
     *
     * @param entity DBより取得した{@link DbT4024ShiharaiHohoHenkoSashitomeEntity}
     */
    public ShiharaiHohoHenkoSashitome(DbT4024ShiharaiHohoHenkoSashitomeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更差止"));
        this.id = new ShiharaiHohoHenkoSashitomeIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getKanriKubun(),
                entity.getRirekiNo(),
                entity.getJohoBunruiKubun(),
                entity.getRenNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}
     * @param id {@link ShiharaiHohoHenkoSashitomeIdentifier}
     */
    ShiharaiHohoHenkoSashitome(
            DbT4024ShiharaiHohoHenkoSashitomeEntity entity,
            ShiharaiHohoHenkoSashitomeIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 管理区分を返します。
     *
     * @return 管理区分
     */
    public RString get管理区分() {
        return entity.getKanriKubun();
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
     * 情報分類区分を返します。
     *
     * @return 情報分類区分
     */
    public RString get情報分類区分() {
        return entity.getJohoBunruiKubun();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenNo();
    }

    /**
     * 差止控除状態区分を返します。
     *
     * @return 差止控除状態区分
     */
    public RString get差止控除状態区分() {
        return entity.getSashitomeKojoJotaiKubun();
    }

    /**
     * 差止決定年月日を返します。
     *
     * @return 差止決定年月日
     */
    public FlexibleDate get差止決定年月日() {
        return entity.getSashitome_KetteiYMD();
    }

    /**
     * 差止通知書発行年月日を返します。
     *
     * @return 差止通知書発行年月日
     */
    public FlexibleDate get差止通知書発行年月日() {
        return entity.getSashitome_TsuchiHakkoYMD();
    }

    /**
     * 差止通知書再発行フラグを返します。
     *
     * @return 差止通知書再発行フラグ
     */
    public boolean get差止通知書再発行フラグ() {
        return entity.getSashitome_TsuchiSaiHakkoFlag();
    }

    /**
     * 差止控除番号を返します。
     *
     * @return 差止控除番号
     */
    public RString get差止控除番号() {
        return entity.getSashitomeKojoNo();
    }

    /**
     * 差止納付期限を返します。
     *
     * @return 差止納付期限
     */
    public FlexibleDate get差止納付期限() {
        return entity.getSashitome_NofuYMD();
    }

    /**
     * 差止解除年月日を返します。
     *
     * @return 差止解除年月日
     */
    public FlexibleDate get差止解除年月日() {
        return entity.getSashitome_KaijoYMD();
    }

    /**
     * 差止サービス提供年月を返します。
     *
     * @return 差止サービス提供年月
     */
    public FlexibleYearMonth get差止サービス提供年月() {
        return entity.getSashitome_ServiceTeikyoYM();
    }

    /**
     * 差止償還整理番号を返します。
     *
     * @return 差止償還整理番号
     */
    public RString get差止償還整理番号() {
        return entity.getSashitome_ShokanSeiriNo();
    }

    /**
     * 控除決定年月日を返します。
     *
     * @return 控除決定年月日
     */
    public FlexibleDate get控除決定年月日() {
        return entity.getKojo_KetteiYMD();
    }

    /**
     * 控除通知書発行年月日を返します。
     *
     * @return 控除通知書発行年月日
     */
    public FlexibleDate get控除通知書発行年月日() {
        return entity.getKojo_TsuchiHakkoYMD();
    }

    /**
     * 控除通知書再発行フラグを返します。
     *
     * @return 控除通知書再発行フラグ
     */
    public boolean get控除通知書再発行フラグ() {
        return entity.getKojo_TsuchiSaiHakkoFlag();
    }

    /**
     * 控除被保険者証提出期限を返します。
     *
     * @return 控除被保険者証提出期限
     */
    public FlexibleDate get控除被保険者証提出期限() {
        return entity.getKojo_ShoTeishutsuYMD();
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
     * {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}のクローンを返します。
     *
     * @return {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}のクローン
     */
    @Override
    public DbT4024ShiharaiHohoHenkoSashitomeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 支払方法変更差止の識別子{@link ShiharaiHohoHenkoSashitomeIdentifier}を返します。
     *
     * @return 支払方法変更差止の識別子{@link ShiharaiHohoHenkoSashitomeIdentifier}
     */
    @Override
    public ShiharaiHohoHenkoSashitomeIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * 保持する支払方法変更差止を削除対象とします。<br/> {@link DbT4024ShiharaiHohoHenkoSashitomeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShiharaiHohoHenkoSashitome}
     * @throws IllegalStateException DbT4024ShiharaiHohoHenkoSashitomeEntityのデータ状態が変更の場合
     */
    @Override
    public ShiharaiHohoHenkoSashitome deleted() {
        DbT4024ShiharaiHohoHenkoSashitomeEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShiharaiHohoHenkoSashitome(deletedEntity, id);
    }

    /**
     * {@link ShiharaiHohoHenkoSashitome}のシリアライズ形式を提供します。
     *
     * @return {@link ShiharaiHohoHenkoSashitome}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -7710879697308516585L;
        private final DbT4024ShiharaiHohoHenkoSashitomeEntity entity;
        private final ShiharaiHohoHenkoSashitomeIdentifier id;

        private _SerializationProxy(DbT4024ShiharaiHohoHenkoSashitomeEntity entity, ShiharaiHohoHenkoSashitomeIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShiharaiHohoHenkoSashitome(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShiharaiHohoHenkoSashitomeBuilder createBuilderForEdit() {
        return new ShiharaiHohoHenkoSashitomeBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ShiharaiHohoHenkoSashitome other = (ShiharaiHohoHenkoSashitome) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
