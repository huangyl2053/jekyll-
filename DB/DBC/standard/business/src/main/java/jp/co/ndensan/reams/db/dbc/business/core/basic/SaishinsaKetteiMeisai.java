/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査決定明細を管理するクラスです。
 */
public class SaishinsaKetteiMeisai 
extends ModelBase<SaishinsaKetteiMeisaiIdentifier, 
        DbT3064SaishinsaKetteiMeisaiEntity, 
        SaishinsaKetteiMeisai> implements Serializable {

    private final DbT3064SaishinsaKetteiMeisaiEntity entity;
    private final SaishinsaKetteiMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 再審査決定明細の新規作成時に使用します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     */
    public SaishinsaKetteiMeisai(FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3064SaishinsaKetteiMeisaiEntity();
        this.entity.setToriatsukaiYM(取扱年月);
        this.entity.setHokenshaKubun(保険者区分);
        this.entity.setRirekiNo(履歴番号.intValue());
        this.id = new SaishinsaKetteiMeisaiIdentifier(
                取扱年月,
                保険者区分,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3064SaishinsaKetteiMeisaiEntity}より{@link SaishinsaKetteiMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3064SaishinsaKetteiMeisaiEntity}
     */
    public SaishinsaKetteiMeisai(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査決定明細"));
        this.id = new SaishinsaKetteiMeisaiIdentifier(
                entity.getToriatsukaiYM(),
                entity.getHokenshaKubun(),
                new Decimal(entity.getRirekiNo()));
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3064SaishinsaKetteiMeisaiEntity}
     * @param id {@link SaishinsaKetteiMeisaiIdentifier}
     */
    SaishinsaKetteiMeisai(
            DbT3064SaishinsaKetteiMeisaiEntity entity,
            SaishinsaKetteiMeisaiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 取扱年月を返します。
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth get取扱年月() {
        return entity.getToriatsukaiYM();
    }

    /**
     * 保険者区分を返します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.getHokenshaKubun();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return new Decimal(entity.getRirekiNo());
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 事業所名を返します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return entity.getJigyoshoName();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohiJukyushaNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス種類名を返します。
     *
     * @return サービス種類名
     */
    public RString getサービス種類名() {
        return entity.getServiceShuruiName();
    }

    /**
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoushitateJiyuCode();
    }

    /**
     * 申立事由を返します。
     *
     * @return 申立事由
     */
    public RString get申立事由() {
        return entity.getMoushitateJiyu();
    }

    /**
     * 再審査結果コードを返します。
     *
     * @return 再審査結果コード
     */
    public RString get再審査結果コード() {
        return entity.getSaishinsaResultCode();
    }

    /**
     * 当初請求単位数を返します。
     *
     * @return 当初請求単位数
     */
    public Decimal get当初請求単位数() {
        return entity.getToshoSeikyuTanisu();
    }

    /**
     * 原審単位数を返します。
     *
     * @return 原審単位数
     */
    public Decimal get原審単位数() {
        return entity.getGenshinSeikyuTanisu();
    }

    /**
     * 申立単位数を返します。
     *
     * @return 申立単位数
     */
    public Decimal get申立単位数() {
        return entity.getMoushitateTanisu();
    }

    /**
     * 決定単位数を返します。
     *
     * @return 決定単位数
     */
    public Decimal get決定単位数() {
        return entity.getKetteiTanisu();
    }

    /**
     * 調整単位数を返します。
     *
     * @return 調整単位数
     */
    public Decimal get調整単位数() {
        return entity.getChoseiTanisu();
    }

    /**
     * 保険者負担額を返します。
     *
     * @return 保険者負担額
     */
    public Decimal get保険者負担額() {
        return entity.getHokenshaFutangaku();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * {@link DbT3064SaishinsaKetteiMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3064SaishinsaKetteiMeisaiEntity}のクローン
     */
    @Override
    public DbT3064SaishinsaKetteiMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 再審査決定明細の識別子{@link SaishinsaKetteiMeisaiIdentifier}を返します。
     *
     * @return 再審査決定明細の識別子{@link SaishinsaKetteiMeisaiIdentifier}
     */
    @Override
    public SaishinsaKetteiMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する再審査決定明細を削除対象とします。<br/>
     * {@link DbT3064SaishinsaKetteiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SaishinsaKetteiMeisai}
     */
    @Override
    public SaishinsaKetteiMeisai deleted() {
        DbT3064SaishinsaKetteiMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SaishinsaKetteiMeisai(deletedEntity, id);
    }

    /**
     * {@link SaishinsaKetteiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link SaishinsaKetteiMeisai}のシリアライズ形式
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

        private final DbT3064SaishinsaKetteiMeisaiEntity entity;
        private final SaishinsaKetteiMeisaiIdentifier id;

        private _SerializationProxy(DbT3064SaishinsaKetteiMeisaiEntity entity, SaishinsaKetteiMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SaishinsaKetteiMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SaishinsaKetteiMeisaiBuilder createBuilderForEdit() {
        return new SaishinsaKetteiMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
