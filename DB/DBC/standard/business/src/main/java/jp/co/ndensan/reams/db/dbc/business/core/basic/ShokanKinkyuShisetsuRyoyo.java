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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求緊急時施設療養を管理するクラスです。
 */
public class ShokanKinkyuShisetsuRyoyo extends ParentModelBase<ShokanKinkyuShisetsuRyoyoIdentifier, DbT3040ShokanKinkyuShisetsuRyoyoEntity, ShokanKinkyuShisetsuRyoyo> implements Serializable {

    private final DbT3040ShokanKinkyuShisetsuRyoyoEntity entity;
    private final ShokanKinkyuShisetsuRyoyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求緊急時施設療養の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 順次番号 順次番号
     * @param 履歴番号 履歴番号
     */
    public ShokanKinkyuShisetsuRyoyo(HihokenshaNo 被保険者番号,
FlexibleYearMonth サービス提供年月,
RString 整理番号,
JigyoshaNo 事業者番号,
RString 様式番号,
RString 順次番号,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setJunjiNo(順次番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanKinkyuShisetsuRyoyoIdentifier(
        被保険者番号,
        サービス提供年月,
        整理番号,
        事業者番号,
        様式番号,
        順次番号,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}より{@link ShokanKinkyuShisetsuRyoyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}
     */
    public ShokanKinkyuShisetsuRyoyo(DbT3040ShokanKinkyuShisetsuRyoyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求緊急時施設療養"));
        this.id = new ShokanKinkyuShisetsuRyoyoIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getJunjiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}
     * @param id {@link ShokanKinkyuShisetsuRyoyoIdentifier}
     */
    ShokanKinkyuShisetsuRyoyo(
            DbT3040ShokanKinkyuShisetsuRyoyoEntity entity,
            ShokanKinkyuShisetsuRyoyoIdentifier id
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
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
    public Decimal get往診日数() {
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
    public Decimal get通院日数() {
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
    public Decimal get緊急時治療管理日数() {
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
     * {@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}のクローン
     */
    @Override
    public DbT3040ShokanKinkyuShisetsuRyoyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求緊急時施設療養の識別子{@link ShokanKinkyuShisetsuRyoyoIdentifier}を返します。
     *
     * @return 償還払請求緊急時施設療養の識別子{@link ShokanKinkyuShisetsuRyoyoIdentifier}
     */
    @Override
    public ShokanKinkyuShisetsuRyoyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 償還払請求緊急時施設療養のみを変更対象とします。<br/>
     * {@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanKinkyuShisetsuRyoyo}
     */
    @Override
    public ShokanKinkyuShisetsuRyoyo modifiedModel() {
        DbT3040ShokanKinkyuShisetsuRyoyoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShokanKinkyuShisetsuRyoyo(
                modifiedEntity, id);
    }

    /**
     * 保持する償還払請求緊急時施設療養を削除対象とします。<br/>
     * {@link DbT3040ShokanKinkyuShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanKinkyuShisetsuRyoyo}
     */
    @Override
    public ShokanKinkyuShisetsuRyoyo deleted() {
        DbT3040ShokanKinkyuShisetsuRyoyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanKinkyuShisetsuRyoyo(deletedEntity, id);
    }
    /**
     * {@link ShokanKinkyuShisetsuRyoyo}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanKinkyuShisetsuRyoyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3040ShokanKinkyuShisetsuRyoyoEntity entity;
        private final ShokanKinkyuShisetsuRyoyoIdentifier id;

        private _SerializationProxy(DbT3040ShokanKinkyuShisetsuRyoyoEntity entity,ShokanKinkyuShisetsuRyoyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanKinkyuShisetsuRyoyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanKinkyuShisetsuRyoyoBuilder createBuilderForEdit() {
        return new ShokanKinkyuShisetsuRyoyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
