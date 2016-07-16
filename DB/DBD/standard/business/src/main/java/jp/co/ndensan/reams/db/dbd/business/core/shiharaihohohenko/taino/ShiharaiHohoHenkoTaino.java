/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更滞納を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class ShiharaiHohoHenkoTaino extends
        ModelBase<ShiharaiHohoHenkoTainoIdentifier, DbT4022ShiharaiHohoHenkoTainoEntity, ShiharaiHohoHenkoTaino> implements Serializable {

    private final DbT4022ShiharaiHohoHenkoTainoEntity entity;
    private final ShiharaiHohoHenkoTainoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 支払方法変更滞納の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 滞納判定区分 滞納判定区分
     * @param 連番 連番
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 収納期_月 収納期_月
     */
    public ShiharaiHohoHenkoTaino(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            RString 滞納判定区分,
            int 連番,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 特徴_普徴区分,
            RString 収納期_月) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(滞納判定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("滞納判定区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(特徴_普徴区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特徴_普徴区分")
        );
        requireNonNull(収納期_月, UrSystemErrorMessages.値がnull.getReplacedMessage("収納期_月")
        );
        this.entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriKubun(管理区分);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setTainoHanteiKubun(滞納判定区分);
        this.entity.setRenNo(連番);
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setTokucho_fuchoKubun(特徴_普徴区分
        );
        this.entity.setShuno_Ki_Tsuki(収納期_月
        );
        this.id = new ShiharaiHohoHenkoTainoIdentifier(
                証記載保険者番号,
                被保険者番号,
                管理区分,
                履歴番号,
                滞納判定区分,
                連番,
                調定年度,
                賦課年度,
                通知書番号,
                特徴_普徴区分,
                収納期_月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4022ShiharaiHohoHenkoTainoEntity}より{@link ShiharaiHohoHenkoTaino}を生成します。
     *
     * @param entity DBより取得した{@link DbT4022ShiharaiHohoHenkoTainoEntity}
     */
    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    public ShiharaiHohoHenkoTaino(DbT4022ShiharaiHohoHenkoTainoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更滞納"));
        this.id = new ShiharaiHohoHenkoTainoIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getKanriKubun(),
                entity.getRirekiNo(),
                entity.getTainoHanteiKubun(),
                entity.getRenNo(),
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getTokucho_fuchoKubun(),
                entity.getShuno_Ki_Tsuki());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4022ShiharaiHohoHenkoTainoEntity}
     * @param id {@link ShiharaiHohoHenkoTainoIdentifier}
     */
    ShiharaiHohoHenkoTaino(
            DbT4022ShiharaiHohoHenkoTainoEntity entity,
            ShiharaiHohoHenkoTainoIdentifier id
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
     * 滞納判定区分を返します。
     *
     * @return 滞納判定区分
     */
    public RString get滞納判定区分() {
        return entity.getTainoHanteiKubun();
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
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 特徴_普徴区分を返します。
     *
     * @return 特徴_普徴区分
     */
    public RString get特徴_普徴区分() {
        return entity.getTokucho_fuchoKubun();
    }

    /**
     * 収納期_月を返します。
     *
     * @return 収納期_月
     */
    public RString get収納期_月() {
        return entity.getShuno_Ki_Tsuki();
    }

    /**
     * 滞納判定年月日を返します。
     *
     * @return 滞納判定年月日
     */
    public FlexibleDate get滞納判定年月日() {
        return entity.getTainoHanteiYMD();
    }

    /**
     * 判定基準年月日を返します。
     *
     * @return 判定基準年月日
     */
    public FlexibleDate get判定基準年月日() {
        return entity.getHanteiKijunYMD();
    }

    /**
     * 時効起算年月日を返します。
     *
     * @return 時効起算年月日
     */
    public FlexibleDate get時効起算年月日() {
        return entity.getJikoKisanYMD();
    }

    /**
     * 時効起算日区分を返します。
     *
     * @return 時効起算日区分
     */
    public RString get時効起算日区分() {
        return entity.getJikoKisanKubun();
    }

    /**
     * 完納_未納区分を返します。
     *
     * @return 完納_未納区分
     */
    public RString get完納_未納区分() {
        return entity.getKanno_MinoKubun();
    }

    /**
     * 時効区分を返します。
     *
     * @return 時効区分
     */
    public RString get時効区分() {
        return entity.getJikoKubun();
    }

    /**
     * 時効後収入区分を返します。
     *
     * @return 時効後収入区分
     */
    public RString get時効後収入区分() {
        return entity.getJikoAtoShunyuKubun();
    }

    /**
     * 対象管理区分を返します。
     *
     * @return 対象管理区分
     */
    public RString get対象管理区分() {
        return entity.getTaishoKanriKubun();
    }

    /**
     * 調定額を返します。
     *
     * @return 調定額
     */
    public Decimal get調定額() {
        return entity.getChoteigaku();
    }

    /**
     * 納期限を返します。
     *
     * @return 納期限
     */
    public FlexibleDate get納期限() {
        return entity.getNokigen();
    }

    /**
     * 滞納額を返します。
     *
     * @return 滞納額
     */
    public Decimal get滞納額() {
        return entity.getTainoGaku();
    }

    /**
     * 控除額を返します。
     *
     * @return 控除額
     */
    public Decimal get控除額() {
        return entity.getKojoGaku();
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
     * {@link DbT4022ShiharaiHohoHenkoTainoEntity}のクローンを返します。
     *
     * @return {@link DbT4022ShiharaiHohoHenkoTainoEntity}のクローン
     */
    @Override
    public DbT4022ShiharaiHohoHenkoTainoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 支払方法変更滞納の識別子{@link ShiharaiHohoHenkoTainoIdentifier}を返します。
     *
     * @return 支払方法変更滞納の識別子{@link ShiharaiHohoHenkoTainoIdentifier}
     */
    @Override
    public ShiharaiHohoHenkoTainoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する支払方法変更滞納を削除対象とします。<br/> {@link DbT4022ShiharaiHohoHenkoTainoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShiharaiHohoHenkoTaino}
     * @throws IllegalStateException DbT4022ShiharaiHohoHenkoTainoEntityのデータ状態が変更の場合
     */
    @Override
    public ShiharaiHohoHenkoTaino deleted() {
        DbT4022ShiharaiHohoHenkoTainoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShiharaiHohoHenkoTaino(deletedEntity, id);
    }

    /**
     * {@link ShiharaiHohoHenkoTaino}のシリアライズ形式を提供します。
     *
     * @return {@link ShiharaiHohoHenkoTaino}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.entity);
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ShiharaiHohoHenkoTaino other = (ShiharaiHohoHenkoTaino) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7453123531336767436L;
        private final DbT4022ShiharaiHohoHenkoTainoEntity entity;
        private final ShiharaiHohoHenkoTainoIdentifier id;

        private _SerializationProxy(DbT4022ShiharaiHohoHenkoTainoEntity entity, ShiharaiHohoHenkoTainoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShiharaiHohoHenkoTaino(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShiharaiHohoHenkoTainoBuilder createBuilderForEdit() {
        return new ShiharaiHohoHenkoTainoBuilder(entity, id);
    }
}
