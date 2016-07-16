/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更減額明細を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengakuMeisai
        extends ModelBase<ShiharaiHohoHenkoGengakuMeisaiIdentifier, DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity, ShiharaiHohoHenkoGengakuMeisai>
        implements Serializable {

    private final DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity;
    private final ShiharaiHohoHenkoGengakuMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 支払方法変更減額明細の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 対象年度 対象年度
     */
    public ShiharaiHohoHenkoGengakuMeisai(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            FlexibleYear 対象年度) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        this.entity = new DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriKubun(管理区分);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setTaishoNendo(対象年度);
        this.id = new ShiharaiHohoHenkoGengakuMeisaiIdentifier(
                証記載保険者番号,
                被保険者番号,
                管理区分,
                履歴番号,
                対象年度
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}より{@link ShiharaiHohoHenkoGengakuMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}
     */
    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    public ShiharaiHohoHenkoGengakuMeisai(DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額明細"));
        this.id = new ShiharaiHohoHenkoGengakuMeisaiIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getKanriKubun(),
                entity.getRirekiNo(),
                entity.getTaishoNendo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}
     * @param id {@link ShiharaiHohoHenkoGengakuMeisaiIdentifier}
     */
    ShiharaiHohoHenkoGengakuMeisai(
            DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity,
            ShiharaiHohoHenkoGengakuMeisaiIdentifier id
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 未納_時効消滅減額を返します。
     *
     * @return 未納・時効消滅減額
     */
    public Decimal get未納_時効消滅減額() {
        return entity.getMino_JikoShometsuGengaku();
    }

    /**
     * 納付額を返します。
     *
     * @return 納付額
     */
    public Decimal get納付額() {
        return entity.getNofugaku();
    }

    /**
     * 年賦課額を返します。
     *
     * @return 年賦課額
     */
    public Decimal get年賦課額() {
        return entity.getNenFukagaku();
    }

    /**
     * {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}のクローン
     */
    @Override
    public DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 支払方法変更減額明細の識別子{@link ShiharaiHohoHenkoGengakuMeisaiIdentifier}を返します。
     *
     * @return 支払方法変更減額明細の識別子{@link ShiharaiHohoHenkoGengakuMeisaiIdentifier}
     */
    @Override
    public ShiharaiHohoHenkoGengakuMeisaiIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * 保持する支払方法変更減額明細を削除対象とします。<br/> {@link DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShiharaiHohoHenkoGengakuMeisai}
     * @throws IllegalStateException DbT4026ShiharaiHohoHenkoGengakuMeisaiEntityのデータ状態が変更の場合
     */
    @Override
    public ShiharaiHohoHenkoGengakuMeisai deleted() {
        DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShiharaiHohoHenkoGengakuMeisai(deletedEntity, id);
    }

    /**
     * {@link ShiharaiHohoHenkoGengakuMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link ShiharaiHohoHenkoGengakuMeisai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 825009531318602931L;
        private final DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity;
        private final ShiharaiHohoHenkoGengakuMeisaiIdentifier id;

        private _SerializationProxy(DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity, ShiharaiHohoHenkoGengakuMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShiharaiHohoHenkoGengakuMeisai(this.entity, this.id);
        }
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShiharaiHohoHenkoGengakuMeisaiBuilder createBuilderForEdit() {
        return new ShiharaiHohoHenkoGengakuMeisaiBuilder(entity, id);
    }
}
