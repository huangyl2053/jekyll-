/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求所定疾患施設療養費等を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanShoteiShikkanShisetsuRyoyo
        extends ModelBase<ShokanShoteiShikkanShisetsuRyoyoIdentifier, DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity, ShokanShoteiShikkanShisetsuRyoyo>
        implements Serializable {

    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity;
    private final ShokanShoteiShikkanShisetsuRyoyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求所定疾患施設療養費等の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     */
    public ShokanShoteiShikkanShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setMeisaiNo(明細番号);
        this.entity.setRenban(連番);
        this.id = new ShokanShoteiShikkanShisetsuRyoyoIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}より{@link ShokanShoteiShikkanShisetsuRyoyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}
     */
    public ShokanShoteiShikkanShisetsuRyoyo(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求所定疾患施設療養費等"));
        this.id = new ShokanShoteiShikkanShisetsuRyoyoIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getMeisaiNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}
     * @param id {@link ShokanShoteiShikkanShisetsuRyoyoIdentifier}
     */
    ShokanShoteiShikkanShisetsuRyoyo(
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity,
            ShokanShoteiShikkanShisetsuRyoyoIdentifier id
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
        return entity.getHiHokenshaNo();
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.getMeisaiNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRenban();
    }

    /**
     * 緊急時傷病名１を返します。
     *
     * @return 緊急時傷病名１
     */
    public RString get緊急時傷病名１() {
        return entity.getKinkyuShobyoName1();
    }

    /**
     * 緊急時傷病名２を返します。
     *
     * @return 緊急時傷病名２
     */
    public RString get緊急時傷病名２() {
        return entity.getKinkyuShobyoName2();
    }

    /**
     * 緊急時傷病名３を返します。
     *
     * @return 緊急時傷病名３
     */
    public RString get緊急時傷病名３() {
        return entity.getKinkyuShobyoName3();
    }

    /**
     * 緊急時治療開始年月日１を返します。
     *
     * @return 緊急時治療開始年月日１
     */
    public FlexibleDate get緊急時治療開始年月日１() {
        return entity.getKinkyuChiryoKaishiYMD1();
    }

    /**
     * 緊急時治療開始年月日２を返します。
     *
     * @return 緊急時治療開始年月日２
     */
    public FlexibleDate get緊急時治療開始年月日２() {
        return entity.getKinkyuChiryoKaishiYMD2();
    }

    /**
     * 緊急時治療開始年月日３を返します。
     *
     * @return 緊急時治療開始年月日３
     */
    public FlexibleDate get緊急時治療開始年月日３() {
        return entity.getKinkyuChiryoKaishiYMD3();
    }

    /**
     * 往診日数を返します。
     *
     * @return 往診日数
     */
    public int get往診日数() {
        return entity.getOshinNissu();
    }

    /**
     * 往診医療機関名を返します。
     *
     * @return 往診医療機関名
     */
    public RString get往診医療機関名() {
        return entity.getOshinIryoKikanName();
    }

    /**
     * 通院日数を返します。
     *
     * @return 通院日数
     */
    public int get通院日数() {
        return entity.getTsuinNissu();
    }

    /**
     * 通院医療機関名を返します。
     *
     * @return 通院医療機関名
     */
    public RString get通院医療機関名() {
        return entity.getTsuinKikanName();
    }

    /**
     * 緊急時治療管理単位数を返します。
     *
     * @return 緊急時治療管理単位数
     */
    public int get緊急時治療管理単位数() {
        return entity.getKinkyuChiryoKanriTanisu();
    }

    /**
     * 緊急時治療管理日数を返します。
     *
     * @return 緊急時治療管理日数
     */
    public int get緊急時治療管理日数() {
        return entity.getKinkyuChiryoKanriNissu();
    }

    /**
     * 緊急時治療管理小計を返します。
     *
     * @return 緊急時治療管理小計
     */
    public int get緊急時治療管理小計() {
        return entity.getKinkyuChiryoKanriSubTotal();
    }

    /**
     * リハビリテーション単位数を返します。
     *
     * @return リハビリテーション単位数
     */
    public int getリハビリテーション単位数() {
        return entity.getRehabilitationTanisu();
    }

    /**
     * 処置単位数を返します。
     *
     * @return 処置単位数
     */
    public int get処置単位数() {
        return entity.getShochiTanisu();
    }

    /**
     * 手術単位数を返します。
     *
     * @return 手術単位数
     */
    public int get手術単位数() {
        return entity.getShujutsuTanisu();
    }

    /**
     * 麻酔単位数を返します。
     *
     * @return 麻酔単位数
     */
    public int get麻酔単位数() {
        return entity.getMasuiTanisu();
    }

    /**
     * 放射線治療単位数を返します。
     *
     * @return 放射線治療単位数
     */
    public int get放射線治療単位数() {
        return entity.getHoshasenChiryoTanisu();
    }

    /**
     * 摘要１を返します。
     *
     * @return 摘要１
     */
    public RString get摘要１() {
        return entity.getTekiyo1();
    }

    /**
     * 摘要２を返します。
     *
     * @return 摘要２
     */
    public RString get摘要２() {
        return entity.getTekiyo2();
    }

    /**
     * 摘要３を返します。
     *
     * @return 摘要３
     */
    public RString get摘要３() {
        return entity.getTekiyo3();
    }

    /**
     * 摘要４を返します。
     *
     * @return 摘要４
     */
    public RString get摘要４() {
        return entity.getTekiyo4();
    }

    /**
     * 摘要５を返します。
     *
     * @return 摘要５
     */
    public RString get摘要５() {
        return entity.getTekiyo5();
    }

    /**
     * 摘要６を返します。
     *
     * @return 摘要６
     */
    public RString get摘要６() {
        return entity.getTekiyo6();
    }

    /**
     * 摘要７を返します。
     *
     * @return 摘要７
     */
    public RString get摘要７() {
        return entity.getTekiyo7();
    }

    /**
     * 摘要８を返します。
     *
     * @return 摘要８
     */
    public RString get摘要８() {
        return entity.getTekiyo8();
    }

    /**
     * 摘要９を返します。
     *
     * @return 摘要９
     */
    public RString get摘要９() {
        return entity.getTekiyo9();
    }

    /**
     * 摘要１０を返します。
     *
     * @return 摘要１０
     */
    public RString get摘要１０() {
        return entity.getTekiyo10();
    }

    /**
     * 摘要１１を返します。
     *
     * @return 摘要１１
     */
    public RString get摘要１１() {
        return entity.getTekiyo11();
    }

    /**
     * 摘要１２を返します。
     *
     * @return 摘要１２
     */
    public RString get摘要１２() {
        return entity.getTekiyo12();
    }

    /**
     * 摘要１３を返します。
     *
     * @return 摘要１３
     */
    public RString get摘要１３() {
        return entity.getTekiyo13();
    }

    /**
     * 摘要１４を返します。
     *
     * @return 摘要１４
     */
    public RString get摘要１４() {
        return entity.getTekiyo14();
    }

    /**
     * 摘要１５を返します。
     *
     * @return 摘要１５
     */
    public RString get摘要１５() {
        return entity.getTekiyo15();
    }

    /**
     * 摘要１６を返します。
     *
     * @return 摘要１６
     */
    public RString get摘要１６() {
        return entity.getTekiyo16();
    }

    /**
     * 摘要１７を返します。
     *
     * @return 摘要１７
     */
    public RString get摘要１７() {
        return entity.getTekiyo17();
    }

    /**
     * 摘要１８を返します。
     *
     * @return 摘要１８
     */
    public RString get摘要１８() {
        return entity.getTekiyo18();
    }

    /**
     * 摘要１９を返します。
     *
     * @return 摘要１９
     */
    public RString get摘要１９() {
        return entity.getTekiyo19();
    }

    /**
     * 摘要２０を返します。
     *
     * @return 摘要２０
     */
    public RString get摘要２０() {
        return entity.getTekiyo20();
    }

    /**
     * 緊急時施設療養費合計単位数を返します。
     *
     * @return 緊急時施設療養費合計単位数
     */
    public int get緊急時施設療養費合計単位数() {
        return entity.getKinkyuShisetsuRyoyohiTotalTanisu();
    }

    /**
     * 所定疾患施設療養費傷病名１を返します。
     *
     * @return 所定疾患施設療養費傷病名１
     */
    public RString get所定疾患施設療養費傷病名１() {
        return entity.getShoteiShikkanShobyoName1();
    }

    /**
     * 所定疾患施設療養費傷病名２を返します。
     *
     * @return 所定疾患施設療養費傷病名２
     */
    public RString get所定疾患施設療養費傷病名２() {
        return entity.getShoteiShikkanShobyoName2();
    }

    /**
     * 所定疾患施設療養費傷病名３を返します。
     *
     * @return 所定疾患施設療養費傷病名３
     */
    public RString get所定疾患施設療養費傷病名３() {
        return entity.getShoteiShikkanShobyoName3();
    }

    /**
     * 所定疾患施設療養費開始年月日１を返します。
     *
     * @return 所定疾患施設療養費開始年月日１
     */
    public FlexibleDate get所定疾患施設療養費開始年月日１() {
        return entity.getShoteiShikkanShobyoKaishiYMD1();
    }

    /**
     * 所定疾患施設療養費開始年月日２を返します。
     *
     * @return 所定疾患施設療養費開始年月日２
     */
    public FlexibleDate get所定疾患施設療養費開始年月日２() {
        return entity.getShoteiShikkanShobyoKaishiYMD2();
    }

    /**
     * 所定疾患施設療養費開始年月日３を返します。
     *
     * @return 所定疾患施設療養費開始年月日３
     */
    public FlexibleDate get所定疾患施設療養費開始年月日３() {
        return entity.getShoteiShikkanShobyoKaishiYMD3();
    }

    /**
     * 所定疾患施設療養費単位数を返します。
     *
     * @return 所定疾患施設療養費単位数
     */
    public int get所定疾患施設療養費単位数() {
        return entity.getShoteiShikkanTanisu();
    }

    /**
     * 所定疾患施設療養費日数を返します。
     *
     * @return 所定疾患施設療養費日数
     */
    public int get所定疾患施設療養費日数() {
        return entity.getShoteiShikkanNissu();
    }

    /**
     * 所定疾患施設療養費小計を返します。
     *
     * @return 所定疾患施設療養費小計
     */
    public int get所定疾患施設療養費小計() {
        return entity.getShoteiShikkanSubTotal();
    }

    /**
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}のクローン
     */
    public DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity toRealEntity() {
        return this.entity;
    }

    /**
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}のクローン
     */
    @Override
    public DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求所定疾患施設療養費等の識別子{@link ShokanShoteiShikkanShisetsuRyoyoIdentifier}を返します。
     *
     * @return 償還払請求所定疾患施設療養費等の識別子{@link ShokanShoteiShikkanShisetsuRyoyoIdentifier}
     */
    @Override
    public ShokanShoteiShikkanShisetsuRyoyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求所定疾患施設療養費等を削除対象とします。<br/>
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShoteiShikkanShisetsuRyoyo}
     */
    @Override
    public ShokanShoteiShikkanShisetsuRyoyo deleted() {
        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShoteiShikkanShisetsuRyoyo(deletedEntity, id);
    }

    /**
     * 保持する償還払請求所定疾患施設療養費等を登録対象とします。<br/>
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば登録状態にします。
     *
     * @return 登録対象処理実施後の{@link ShokanShoteiShikkanShisetsuRyoyo}
     */
    public ShokanShoteiShikkanShisetsuRyoyo added() {
        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ShokanShoteiShikkanShisetsuRyoyo(addedEntity, id);
    }

    /**
     * 保持する償還払請求所定疾患施設療養費等を修正対象とします。<br/>
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link ShokanShoteiShikkanShisetsuRyoyo}
     */
    public ShokanShoteiShikkanShisetsuRyoyo modified() {
        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanShoteiShikkanShisetsuRyoyo(modifiedEntity, id);
    }

    /**
     * {@link ShokanShoteiShikkanShisetsuRyoyo}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShoteiShikkanShisetsuRyoyo}のシリアライズ形式
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

        private final DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity;
        private final ShokanShoteiShikkanShisetsuRyoyoIdentifier id;

        private _SerializationProxy(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity, ShokanShoteiShikkanShisetsuRyoyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShoteiShikkanShisetsuRyoyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder createBuilderForEdit() {
        return new ShokanShoteiShikkanShisetsuRyoyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
