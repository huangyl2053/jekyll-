/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護予防・日常生活支援総合事業サービスコードを管理するクラスです。
 */
public class SogoJigyoServiceCode extends ParentModelBase<SogoJigyoServiceCodeIdentifier, DbT7122SogoJigyoServiceCodeEntity, SogoJigyoServiceCode> implements Serializable {

    private final DbT7122SogoJigyoServiceCodeEntity entity;
    private final SogoJigyoServiceCodeIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護予防・日常生活支援総合事業サービスコードの新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public SogoJigyoServiceCode(ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7122SogoJigyoServiceCodeEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SogoJigyoServiceCodeIdentifier(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7122SogoJigyoServiceCodeEntity}より{@link SogoJigyoServiceCode}を生成します。
     *
     * @param entity DBより取得した{@link DbT7122SogoJigyoServiceCodeEntity}
     */
    public SogoJigyoServiceCode(DbT7122SogoJigyoServiceCodeEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業サービスコード"));
        this.id = new SogoJigyoServiceCodeIdentifier(
                entity.getServiceShuruiCode(),
                entity.getServiceKomokuCode(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7122SogoJigyoServiceCodeEntity}
     * @param id {@link SogoJigyoServiceCodeIdentifier}
     */
    SogoJigyoServiceCode(
            DbT7122SogoJigyoServiceCodeEntity entity,
            SogoJigyoServiceCodeIdentifier id
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
        return entity.getGaibuServiceRiyoKubun();
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
     * 利用者負担定率／定額区分を返します。
     *
     * @return 利用者負担定率／定額区分
     */
    public RString get利用者負担定率

    ／定額区分() {
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
     * 二次予防事業対象者実施区分を返します。
     *
     * @return 二次予防事業対象者実施区分
     */
    public RString get二次予防事業対象者実施区分() {
        return entity.getNijiYoboTaishosha_JissiKubun();
    }

    /**
     * 要支援１受給者実施区分を返します。
     *
     * @return 要支援１受給者実施区分
     */
    public RString get要支援１受給者実施区分() {
        return entity.getYoShien1_JisshiKubun();
    }

    /**
     * 要支援２受給者実施区分を返します。
     *
     * @return 要支援２受給者実施区分
     */
    public RString get要支援２受給者実施区分() {
        return entity.getYoShien2_JisshiKubun();
    }

    /**
     * {@link DbT7122SogoJigyoServiceCodeEntity}のクローンを返します。
     *
     * @return {@link DbT7122SogoJigyoServiceCodeEntity}のクローン
     */
    @Override
    public DbT7122SogoJigyoServiceCodeEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護予防・日常生活支援総合事業サービスコードの識別子{@link SogoJigyoServiceCodeIdentifier}を返します。
     *
     * @return 介護予防・日常生活支援総合事業サービスコードの識別子{@link SogoJigyoServiceCodeIdentifier}
     */
    @Override
    public SogoJigyoServiceCodeIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護予防・日常生活支援総合事業サービスコードのみを変更対象とします。<br/>
     * {@link DbT7122SogoJigyoServiceCodeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SogoJigyoServiceCode}
     */
    @Override
    public SogoJigyoServiceCode modifiedModel() {
        DbT7122SogoJigyoServiceCodeEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SogoJigyoServiceCode(
                modifiedEntity, id);
    }

    /**
     * 保持する介護予防・日常生活支援総合事業サービスコードを削除対象とします。<br/>
     * {@link DbT7122SogoJigyoServiceCodeEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SogoJigyoServiceCode}
     */
    @Override
    public SogoJigyoServiceCode deleted() {
        DbT7122SogoJigyoServiceCodeEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SogoJigyoServiceCode(deletedEntity, id);
    }

    /**
     * {@link SogoJigyoServiceCode}のシリアライズ形式を提供します。
     *
     * @return {@link SogoJigyoServiceCode}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT7122SogoJigyoServiceCodeEntity entity;
        private final SogoJigyoServiceCodeIdentifier id;

        private _SerializationProxy(DbT7122SogoJigyoServiceCodeEntity entity, SogoJigyoServiceCodeIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SogoJigyoServiceCode(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SogoJigyoServiceCodeBuilder createBuilderForEdit() {
        return new SogoJigyoServiceCodeBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
