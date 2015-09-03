/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * サービスコードを管理するクラスです。
 */
public class ServiceCode extends ModelBase<ServiceCodeIdentifier, DbT7119ServiceCodeEntity, ServiceCode> implements Serializable {

    private final DbT7119ServiceCodeEntity entity;
    private final ServiceCodeIdentifier id;

    /**
     * コンストラクタです。<br/>
     * サービスコードの新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public ServiceCode(ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7119ServiceCodeEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ServiceCodeIdentifier(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7119ServiceCodeEntity}より{@link ServiceCode}を生成します。
     *
     * @param entity DBより取得した{@link DbT7119ServiceCodeEntity}
     */
    public ServiceCode(DbT7119ServiceCodeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        this.id = new ServiceCodeIdentifier(
                entity.getServiceShuruiCode(),
                entity.getServiceKomokuCode(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7119ServiceCodeEntity}
     * @param id {@link ServiceCodeIdentifier}
     */
    ServiceCode(
            DbT7119ServiceCodeEntity entity,
            ServiceCodeIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
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
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getServiceMeisho();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 限度額対象外フラグを返します。
     *
     * @return 限度額対象外フラグ
     */
    public RString get限度額対象外フラグ() {
        return entity.getGendoGakuTaishogaiFlag();
    }

    /**
     * 単位数識別コードを返します。
     *
     * @return 単位数識別コード
     */
    public RString get単位数識別コード() {
        return entity.getTaniSuShikibetsuCode();
    }

    /**
     * 外部サービス利用型区分を返します。
     *
     * @return 外部サービス利用型区分
     */
    public RString get外部サービス利用型区分() {
        return entity.getGaibuServiceRiyogataKubun();
    }

    /**
     * 特別地域加算フラグを返します。
     *
     * @return 特別地域加算フラグ
     */
    public RString get特別地域加算フラグ() {
        return entity.getTokubetsuChiikiKasanFlag();
    }

    /**
     * 利用者負担定率_定額区分を返します。
     *
     * @return 利用者負担定率_定額区分
     */
    public RString get利用者負担定率_定額区分() {
        return entity.getTeiRitsu_TeiGakuKubun();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * {@link DbT7119ServiceCodeEntity}のクローンを返します。
     *
     * @return {@link DbT7119ServiceCodeEntity}のクローン
     */
    @Override
    public DbT7119ServiceCodeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * サービスコードの識別子{@link ServiceCodeIdentifier}を返します。
     *
     * @return サービスコードの識別子{@link ServiceCodeIdentifier}
     */
    @Override
    public ServiceCodeIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持するサービスコードを削除対象とします。<br/>
     * {@link DbT7119ServiceCodeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ServiceCode}
     */
    @Override
    public ServiceCode deleted() {
        DbT7119ServiceCodeEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ServiceCode(deletedEntity, id);
    }

    /**
     * {@link ServiceCode}のシリアライズ形式を提供します。
     *
     * @return {@link ServiceCode}のシリアライズ形式
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

        private final DbT7119ServiceCodeEntity entity;
        private final ServiceCodeIdentifier id;

        private _SerializationProxy(DbT7119ServiceCodeEntity entity, ServiceCodeIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ServiceCode(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ServiceCodeBuilder createBuilderForEdit() {
        return new ServiceCodeBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
