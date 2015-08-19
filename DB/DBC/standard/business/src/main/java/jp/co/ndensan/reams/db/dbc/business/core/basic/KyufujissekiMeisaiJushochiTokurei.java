/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3106KyufujissekiMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績明細_住所地特例を管理するクラスです。
 */
public class KyufujissekiMeisaiJushochiTokurei extends ModelBase<KyufujissekiMeisaiJushochiTokureiIdentifier, DbT3106KyufujissekiMeisaiJushochiTokureiEntity, KyufujissekiMeisaiJushochiTokurei> implements Serializable {

    private final DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity;
    private final KyufujissekiMeisaiJushochiTokureiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績明細_住所地特例の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     */
    public KyufujissekiMeisaiJushochiTokurei(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        this.entity = new DbT3106KyufujissekiMeisaiJushochiTokureiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.id = new KyufujissekiMeisaiJushochiTokureiIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                サービス種類コード,
                サービス項目コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}より{@link KyufujissekiMeisaiJushochiTokurei}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}
     */
    public KyufujissekiMeisaiJushochiTokurei(DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績明細_住所地特例"));
        this.id = new KyufujissekiMeisaiJushochiTokureiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getServiceShuruiCode(),
                entity.getServiceKomokuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}
     * @param id {@link KyufujissekiMeisaiJushochiTokureiIdentifier}
     */
    KyufujissekiMeisaiJushochiTokurei(
            DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity,
            KyufujissekiMeisaiJushochiTokureiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
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
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTanisu();
    }

    /**
     * 日数_回数を返します。
     *
     * @return 日数_回数
     */
    public Decimal get日数_回数() {
        return entity.getNissuKaisu();
    }

    /**
     * 公費１対象日数_回数を返します。
     *
     * @return 公費１対象日数_回数
     */
    public Decimal get公費１対象日数_回数() {
        return entity.getKohi1TaishoNissuKaisu();
    }

    /**
     * 公費２対象日数_回数を返します。
     *
     * @return 公費２対象日数_回数
     */
    public Decimal get公費２対象日数_回数() {
        return entity.getKohi2TaishoNissuKaisu();
    }

    /**
     * 公費３対象日数_回数を返します。
     *
     * @return 公費３対象日数_回数
     */
    public Decimal get公費３対象日数_回数() {
        return entity.getKohi3TaishoNissuKaisu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * 公費１対象サービス単位数を返します。
     *
     * @return 公費１対象サービス単位数
     */
    public int get公費１対象サービス単位数() {
        return entity.getKohi1TaishoServiceTanisu();
    }

    /**
     * 公費２対象サービス単位数を返します。
     *
     * @return 公費２対象サービス単位数
     */
    public int get公費２対象サービス単位数() {
        return entity.getKohi2TaishoServiceTanisu();
    }

    /**
     * 公費３対象サービス単位数を返します。
     *
     * @return 公費３対象サービス単位数
     */
    public int get公費３対象サービス単位数() {
        return entity.getKohi3TaishoServiceTanisu();
    }

    /**
     * 施設所在保険者番号を返します。
     *
     * @return 施設所在保険者番号
     */
    public ShoKisaiHokenshaNo get施設所在保険者番号() {
        return entity.getShisetsuShozaiHokenshaNo();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public Decimal get後_単位数() {
        return entity.getAtoTanisu();
    }

    /**
     * 後_日数_回数を返します。
     *
     * @return 後_日数_回数
     */
    public Decimal get後_日数_回数() {
        return entity.getAtoNissuKaisu();
    }

    /**
     * 後_公費１対象日数_回数を返します。
     *
     * @return 後_公費１対象日数_回数
     */
    public Decimal get後_公費１対象日数_回数() {
        return entity.getAtoKohi1TaishoNissuKaisu();
    }

    /**
     * 後_公費２対象日数_回数を返します。
     *
     * @return 後_公費２対象日数_回数
     */
    public Decimal get後_公費２対象日数_回数() {
        return entity.getAtoKohi2TaishoNissukaisu();
    }

    /**
     * 後_公費３対象日数_回数を返します。
     *
     * @return 後_公費３対象日数_回数
     */
    public Decimal get後_公費３対象日数_回数() {
        return entity.getAtoKohi3TaishoNissuKaisu();
    }

    /**
     * 後_サービス単位数を返します。
     *
     * @return 後_サービス単位数
     */
    public int get後_サービス単位数() {
        return entity.getAtoServiceTanisu();
    }

    /**
     * 後_公費１対象サービス単位数を返します。
     *
     * @return 後_公費１対象サービス単位数
     */
    public int get後_公費１対象サービス単位数() {
        return entity.getAtoKohi1TaishoServiceTanisu();
    }

    /**
     * 後_公費２対象サービス単位数を返します。
     *
     * @return 後_公費２対象サービス単位数
     */
    public int get後_公費２対象サービス単位数() {
        return entity.getAtoKohi2TaishoServiceTanisu();
    }

    /**
     * 後_公費３対象サービス単位数を返します。
     *
     * @return 後_公費３対象サービス単位数
     */
    public int get後_公費３対象サービス単位数() {
        return entity.getAtoKohi3TaishoServiceTanisu();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public Decimal get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public Decimal get過誤回数() {
        return entity.getKagoKaisu();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
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
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}のクローンを返します。
     *
     * @return {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}のクローン
     */
    @Override
    public DbT3106KyufujissekiMeisaiJushochiTokureiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績明細_住所地特例の識別子{@link KyufujissekiMeisaiJushochiTokureiIdentifier}を返します。
     *
     * @return
     * 給付実績明細_住所地特例の識別子{@link KyufujissekiMeisaiJushochiTokureiIdentifier}
     */
    @Override
    public KyufujissekiMeisaiJushochiTokureiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績明細_住所地特例を削除対象とします。<br/>
     * {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiMeisaiJushochiTokurei}
     */
    @Override
    public KyufujissekiMeisaiJushochiTokurei deleted() {
        DbT3106KyufujissekiMeisaiJushochiTokureiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiMeisaiJushochiTokurei(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiMeisaiJushochiTokurei}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiMeisaiJushochiTokurei}のシリアライズ形式
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

        private final DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity;
        private final KyufujissekiMeisaiJushochiTokureiIdentifier id;

        private _SerializationProxy(DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity, KyufujissekiMeisaiJushochiTokureiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiMeisaiJushochiTokurei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder createBuilderForEdit() {
        return new KyufujissekiMeisaiJushochiTokureiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
