/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額介護サービス費支給判定結果を管理するクラスです。
 */
public class JigyoKogakuShikyuHanteiKekka
        extends ModelBase<JigyoKogakuShikyuHanteiKekkaIdentifier, DbT3111JigyoKogakuShikyuHanteiKekkaEntity, JigyoKogakuShikyuHanteiKekka>
        implements Serializable {

    private final DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity;
    private final JigyoKogakuShikyuHanteiKekkaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額介護サービス費支給判定結果の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 履歴番号 履歴番号
     */
    public JigyoKogakuShikyuHanteiKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JigyoKogakuShikyuHanteiKekkaIdentifier(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}より{@link JigyoKogakuShikyuHanteiKekka}を生成します。
     *
     * @param entity DBより取得した{@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}
     */
    public JigyoKogakuShikyuHanteiKekka(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給判定結果"));
        this.id = new JigyoKogakuShikyuHanteiKekkaIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getShoKisaiHokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}
     * @param id {@link JigyoKogakuShikyuHanteiKekkaIdentifier}
     */
    JigyoKogakuShikyuHanteiKekka(
            DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity,
            JigyoKogakuShikyuHanteiKekkaIdentifier id
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 本人支払額を返します。
     *
     * @return 本人支払額
     */
    public Decimal get本人支払額() {
        return entity.getHonninShiharaiGaku();
    }

    /**
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShiharaiKubunCode();
    }

    /**
     * 支給金額を返します。
     *
     * @return 支給金額
     */
    public Decimal get支給金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 不支給理由を返します。
     *
     * @return 不支給理由
     */
    public RString get不支給理由() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 審査方法区分を返します。
     *
     * @return 審査方法区分
     */
    public RString get審査方法区分() {
        return entity.getShinsaHohoKubun();
    }

    /**
     * 判定結果送付年月を返します。
     *
     * @return 判定結果送付年月
     */
    public FlexibleYearMonth get判定結果送付年月() {
        return entity.getHanteiKekkaSofuYM();
    }

    /**
     * 再送付フラグを返します。
     *
     * @return 再送付フラグ
     */
    public boolean is再送付フラグ() {
        return entity.getSaiSofuFlag();
    }

    /**
     * 判定結果送付不要フラグを返します。
     *
     * @return 判定結果送付不要フラグ
     */
    public boolean is判定結果送付不要フラグ() {
        return entity.getHanteiKekkaSofuFuyoFlag();
    }

    /**
     * 審査結果反映区分を返します。
     *
     * @return 審査結果反映区分
     */
    public RString get審査結果反映区分() {
        return entity.getShinsaKekkaHaneiKubun();
    }

    /**
     * 決定通知書作成年月日を返します。
     *
     * @return 決定通知書作成年月日
     */
    public FlexibleDate get決定通知書作成年月日() {
        return entity.getKetteiTsuchishoSakuseiYMD();
    }

    /**
     * 振込明細書作成年月日を返します。
     *
     * @return 振込明細書作成年月日
     */
    public FlexibleDate get振込明細書作成年月日() {
        return entity.getFurikomiMeisaishoSakuseiYMD();
    }

    /**
     * 決定通知リアル発行区分を返します。
     *
     * @return 決定通知リアル発行区分
     */
    public RString get決定通知リアル発行区分() {
        return entity.getKetteiTsuchiHakkoKubun();
    }

    /**
     * {@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}のクローンを返します。
     *
     * @return {@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}のクローン
     */
    @Override
    public DbT3111JigyoKogakuShikyuHanteiKekkaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額介護サービス費支給判定結果の識別子{@link JigyoKogakuShikyuHanteiKekkaIdentifier}を返します。
     *
     * @return 事業高額介護サービス費支給判定結果の識別子{@link JigyoKogakuShikyuHanteiKekkaIdentifier}
     */
    @Override
    public JigyoKogakuShikyuHanteiKekkaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する事業高額介護サービス費支給判定結果を削除対象とします。<br/> {@link DbT3111JigyoKogakuShikyuHanteiKekkaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuShikyuHanteiKekka}
     */
    @Override
    public JigyoKogakuShikyuHanteiKekka deleted() {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Deleted);
        return new JigyoKogakuShikyuHanteiKekka(deletedEntity, id);
    }

    /**
     * add JigyoKogakuShikyuHanteiKekka
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public JigyoKogakuShikyuHanteiKekka added() {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        //TODO メッセージの検討
        return new JigyoKogakuShikyuHanteiKekka(addedEntity, id);
    }

    /**
     * 修正 JigyoKogakuShikyuHanteiKekka
     *
     * @return JigyoKogakuShikyuHanteiKekka {@link ShokanMeisai}のクローン
     */
    public JigyoKogakuShikyuHanteiKekka modified() {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        //TODO メッセージの検討
        return new JigyoKogakuShikyuHanteiKekka(modifiedEntity, id);
    }

    /**
     * {@link JigyoKogakuShikyuHanteiKekka}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuShikyuHanteiKekka}のシリアライズ形式
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

        private final DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity;
        private final JigyoKogakuShikyuHanteiKekkaIdentifier id;

        private _SerializationProxy(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity, JigyoKogakuShikyuHanteiKekkaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuShikyuHanteiKekka(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuShikyuHanteiKekkaBuilder createBuilderForEdit() {
        return new JigyoKogakuShikyuHanteiKekkaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
