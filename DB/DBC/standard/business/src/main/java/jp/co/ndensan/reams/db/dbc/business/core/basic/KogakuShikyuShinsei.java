/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費支給申請を管理するクラスです。
 *
 * @reamsid_L DBC-9999-040 quxiaodong
 */
public class KogakuShikyuShinsei extends
        ModelBase<KogakuShikyuShinseiIdentifier, DbT3056KogakuShikyuShinseiEntity, KogakuShikyuShinsei>
        implements Serializable {

    private final DbT3056KogakuShikyuShinseiEntity entity;
    private final KogakuShikyuShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額介護サービス費支給申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 履歴番号 履歴番号
     */
    public KogakuShikyuShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3056KogakuShikyuShinseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuShikyuShinseiIdentifier(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3056KogakuShikyuShinseiEntity}より{@link KogakuShikyuShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3056KogakuShikyuShinseiEntity}
     */
    public KogakuShikyuShinsei(DbT3056KogakuShikyuShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給申請"));
        this.id = new KogakuShikyuShinseiIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getShoKisaiHokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3056KogakuShikyuShinseiEntity}
     * @param id {@link KogakuShikyuShinseiIdentifier}
     */
    KogakuShikyuShinsei(
            DbT3056KogakuShikyuShinseiEntity entity,
            KogakuShikyuShinseiIdentifier id
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 申請者区分を返します。
     *
     * @return 申請者区分
     */
    public RString get申請者区分() {
        return entity.getShinseishaKubun();
    }

    /**
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho get申請者氏名() {
        return entity.getShinseishaShimei();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho get申請者氏名カナ() {
        return entity.getShinseishaShimeiKana();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaJusho();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請事業者番号を返します。
     *
     * @return 申請事業者番号
     */
    public JigyoshaNo get申請事業者番号() {
        return entity.getShinseiJigyoshaNo();
    }

    /**
     * 支払方法区分コードを返します。
     *
     * @return 支払方法区分コード
     */
    public RString get支払方法区分コード() {
        return entity.getShiharaiHohoKubunCode();
    }

    /**
     * 支払場所を返します。
     *
     * @return 支払場所
     */
    public RString get支払場所() {
        return entity.getShiharaiBasho();
    }

    /**
     * 支払期間開始年月日を返します。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get支払期間開始年月日() {
        return entity.getShiharaiKaishiYMD();
    }

    /**
     * 支払期間終了年月日を返します。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get支払期間終了年月日() {
        return entity.getShiharaiShuryoYMD();
    }

    /**
     * 閉庁内容を返します。
     *
     * @return 閉庁内容
     */
    public RString get閉庁内容() {
        return entity.getHeichoNaiyo();
    }

    /**
     * 支払窓口開始時間を返します。
     *
     * @return 支払窓口開始時間
     */
    public RString get支払窓口開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払窓口終了時間を返します。
     *
     * @return 支払窓口終了時間
     */
    public RString get支払窓口終了時間() {
        return entity.getShiharaiShuryoTime();
    }

    /**
     * 口座IDを返します。
     *
     * @return 口座ID
     */
    public long get口座ID() {
        return entity.getKozaID();
    }

    /**
     * 受領委任契約番号を返します。
     *
     * @return 受領委任契約番号
     */
    public RString get受領委任契約番号() {
        return entity.getJuryoininKeiyakuNo();
    }

    /**
     * {@link DbT3056KogakuShikyuShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT3056KogakuShikyuShinseiEntity}のクローン
     */
    @Override
    public DbT3056KogakuShikyuShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額介護サービス費支給申請の識別子{@link KogakuShikyuShinseiIdentifier}を返します。
     *
     * @return 高額介護サービス費支給申請の識別子{@link KogakuShikyuShinseiIdentifier}
     */
    @Override
    public KogakuShikyuShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額介護サービス費支給申請を削除対象とします。<br/>
     * {@link DbT3056KogakuShikyuShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuShikyuShinsei}
     */
    @Override
    public KogakuShikyuShinsei deleted() {
        DbT3056KogakuShikyuShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuShikyuShinsei(deletedEntity, id);
    }

    /**
     * 修正ShokanMeisaiJushochiTokurei
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public KogakuShikyuShinsei modified() {
        DbT3056KogakuShikyuShinseiEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        //TODO メッセージの検討
        return new KogakuShikyuShinsei(modifiedEntity, id);
    }

    /**
     * add ShokanMeisaiJushochiTokurei
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public KogakuShikyuShinsei added() {
        DbT3056KogakuShikyuShinseiEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        //TODO メッセージの検討
        return new KogakuShikyuShinsei(addedEntity, id);
    }

    /**
     * {@link KogakuShikyuShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuShikyuShinsei}のシリアライズ形式
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

        private final DbT3056KogakuShikyuShinseiEntity entity;
        private final KogakuShikyuShinseiIdentifier id;

        private _SerializationProxy(DbT3056KogakuShikyuShinseiEntity entity, KogakuShikyuShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuShikyuShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuShikyuShinseiBuilder createBuilderForEdit() {
        return new KogakuShikyuShinseiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
