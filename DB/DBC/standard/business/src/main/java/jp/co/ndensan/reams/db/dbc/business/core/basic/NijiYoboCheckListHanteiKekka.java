/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防チェックリスト判定結果を管理するクラスです。
 */
public class NijiYoboCheckListHanteiKekka extends ModelBase<NijiYoboCheckListHanteiKekkaIdentifier, DbT3103NijiYoboCheckListHanteiKekkaEntity, NijiYoboCheckListHanteiKekka> implements Serializable {

    private final DbT3103NijiYoboCheckListHanteiKekkaEntity entity;
    private final NijiYoboCheckListHanteiKekkaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 二次予防チェックリスト判定結果の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public NijiYoboCheckListHanteiKekka(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new NijiYoboCheckListHanteiKekkaIdentifier(
                識別コード,
                被保険者番号,
                受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3103NijiYoboCheckListHanteiKekkaEntity}より{@link NijiYoboCheckListHanteiKekka}を生成します。
     *
     * @param entity DBより取得した{@link DbT3103NijiYoboCheckListHanteiKekkaEntity}
     */
    public NijiYoboCheckListHanteiKekka(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防チェックリスト判定結果"));
        this.id = new NijiYoboCheckListHanteiKekkaIdentifier(
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}
     * @param id {@link NijiYoboCheckListHanteiKekkaIdentifier}
     */
    NijiYoboCheckListHanteiKekka(
            DbT3103NijiYoboCheckListHanteiKekkaEntity entity,
            NijiYoboCheckListHanteiKekkaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 点数_生活機能全般を返します。
     *
     * @return 点数_生活機能全般
     */
    public Decimal get点数_生活機能全般() {
        return entity.getTensu_SeikatsuKinoZenpan();
    }

    /**
     * 点数_運動器機能を返します。
     *
     * @return 点数_運動器機能
     */
    public Decimal get点数_運動器機能() {
        return entity.getTensu_UndokiKino();
    }

    /**
     * 点数_栄養を返します。
     *
     * @return 点数_栄養
     */
    public Decimal get点数_栄養() {
        return entity.getTensu_Eiyo();
    }

    /**
     * 点数_口腔を返します。
     *
     * @return 点数_口腔
     */
    public Decimal get点数_口腔() {
        return entity.getTensu_Koku();
    }

    /**
     * 点数_閉じこもりを返します。
     *
     * @return 点数_閉じこもり
     */
    public Decimal get点数_閉じこもり() {
        return entity.getTensu_Tojikomori();
    }

    /**
     * 点数_認知能力を返します。
     *
     * @return 点数_認知能力
     */
    public Decimal get点数_認知能力() {
        return entity.getTensu_NinchiNoryoku();
    }

    /**
     * 点数_うつを返します。
     *
     * @return 点数_うつ
     */
    public Decimal get点数_うつ() {
        return entity.getTensu_Utsu();
    }

    /**
     * 支援必要性_生活機能全般を返します。
     *
     * @return 支援必要性_生活機能全般
     */
    public Decimal get支援必要性_生活機能全般() {
        return entity.getShien_SeikatsuKinoZenpan();
    }

    /**
     * 支援必要性_運動器機能を返します。
     *
     * @return 支援必要性_運動器機能
     */
    public Decimal get支援必要性_運動器機能() {
        return entity.getShien_UndokiKino();
    }

    /**
     * 支援必要性_栄養を返します。
     *
     * @return 支援必要性_栄養
     */
    public Decimal get支援必要性_栄養() {
        return entity.getShien_Eiyo();
    }

    /**
     * 支援必要性_口腔を返します。
     *
     * @return 支援必要性_口腔
     */
    public Decimal get支援必要性_口腔() {
        return entity.getShien_Koku();
    }

    /**
     * 支援必要性_閉じこもりを返します。
     *
     * @return 支援必要性_閉じこもり
     */
    public Decimal get支援必要性_閉じこもり() {
        return entity.getShien_Tojikomori();
    }

    /**
     * 支援必要性_認知能力を返します。
     *
     * @return 支援必要性_認知能力
     */
    public Decimal get支援必要性_認知能力() {
        return entity.getShien_NinchiNoryoku();
    }

    /**
     * 支援必要性_うつを返します。
     *
     * @return 支援必要性_うつ
     */
    public Decimal get支援必要性_うつ() {
        return entity.getShien_Utsu();
    }

    /**
     * 二次予防_主観的健康感を返します。
     *
     * @return 二次予防_主観的健康感
     */
    public RString get二次予防_主観的健康感() {
        return entity.getNijiYobo_ShukantekiKenkouKan();
    }

    /**
     * {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}のクローンを返します。
     *
     * @return {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}のクローン
     */
    @Override
    public DbT3103NijiYoboCheckListHanteiKekkaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 二次予防チェックリスト判定結果の識別子{@link NijiYoboCheckListHanteiKekkaIdentifier}を返します。
     *
     * @return 二次予防チェックリスト判定結果の識別子{@link NijiYoboCheckListHanteiKekkaIdentifier}
     */
    @Override
    public NijiYoboCheckListHanteiKekkaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する二次予防チェックリスト判定結果を削除対象とします。<br/>
     * {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NijiYoboCheckListHanteiKekka}
     */
    @Override
    public NijiYoboCheckListHanteiKekka deleted() {
        DbT3103NijiYoboCheckListHanteiKekkaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NijiYoboCheckListHanteiKekka(deletedEntity, id);
    }

    /**
     * {@link NijiYoboCheckListHanteiKekka}のシリアライズ形式を提供します。
     *
     * @return {@link NijiYoboCheckListHanteiKekka}のシリアライズ形式
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

        private final DbT3103NijiYoboCheckListHanteiKekkaEntity entity;
        private final NijiYoboCheckListHanteiKekkaIdentifier id;

        private _SerializationProxy(DbT3103NijiYoboCheckListHanteiKekkaEntity entity, NijiYoboCheckListHanteiKekkaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NijiYoboCheckListHanteiKekka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NijiYoboCheckListHanteiKekkaBuilder createBuilderForEdit() {
        return new NijiYoboCheckListHanteiKekkaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
