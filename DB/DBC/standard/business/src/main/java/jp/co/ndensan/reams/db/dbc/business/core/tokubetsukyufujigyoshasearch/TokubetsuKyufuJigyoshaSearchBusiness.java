/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 市町村特別給付・サービス事業者を管理するクラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class TokubetsuKyufuJigyoshaSearchBusiness extends
        ModelBase<TokubetsuKyufuJigyoshaSearchIdentifier, TokubetsuKyufuJigyoshaSearchEntity, TokubetsuKyufuJigyoshaSearchBusiness>
        implements Serializable {

    private final TokubetsuKyufuJigyoshaSearchEntity entity;
    private final TokubetsuKyufuJigyoshaSearchIdentifier id;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link TokubetsuKyufuJigyoshaSearchEntity}より{@link TokubetsuKyufuJigyoshaSearchBusiness}を生成します。
     *
     * @param entity DBより取得した{@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}
     */
    public TokubetsuKyufuJigyoshaSearchBusiness(TokubetsuKyufuJigyoshaSearchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス事業者"));
        this.id = new TokubetsuKyufuJigyoshaSearchIdentifier(
                entity.get事業者().getJigyoshaNo(),
                entity.get事業者().getServiceCode(),
                entity.get事業者().getRirekiNo());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link TokubetsuKyufuJigyoshaSearchEntity}より{@link TokubetsuKyufuJigyoshaSearchBusiness}を生成します。
     *
     * @param 市町村特別給付用事業者番号 JigyoshaNo
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 履歴番号 int
     */
    public TokubetsuKyufuJigyoshaSearchBusiness(
            JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            int 履歴番号) {
        entity = new TokubetsuKyufuJigyoshaSearchEntity();
        entity.set事業者((new ShichosonTokubetsuKyufuJigyosha(
                市町村特別給付用事業者番号, 市町村特別給付用サービスコード, 履歴番号)).toEntity());
        this.id = new TokubetsuKyufuJigyoshaSearchIdentifier(
                entity.get事業者().getJigyoshaNo(),
                entity.get事業者().getServiceCode(),
                entity.get事業者().getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}
     * @param id {@link TokubetsuKyufuJigyoshaSearchIdentifier}
     */
    TokubetsuKyufuJigyoshaSearchBusiness(
            TokubetsuKyufuJigyoshaSearchEntity entity,
            TokubetsuKyufuJigyoshaSearchIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 市町村特別給付サービス事業者を返します。
     *
     * @return 市町村特別給付サービス事業者
     */
    public TokubetsuKyufuJigyoshaSearchEntity get市町村特別給付サービス事業者() {
        return entity;
    }

    /**
     * 市町村特別給付用事業者番号を返します。
     *
     * @return 市町村特別給付用事業者番号
     */
    public JigyoshaNo get市町村特別給付用事業者番号() {
        return entity.get事業者().getJigyoshaNo();
    }

    /**
     * 市町村特別給付用サービスコードを返します。
     *
     * @return 市町村特別給付用サービスコード
     */
    public ServiceCode get市町村特別給付用サービスコード() {
        return entity.get事業者().getServiceCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.get事業者().getRirekiNo();
    }

    /**
     * 介護国保連ＩＦ異動区分を返します。
     *
     * @return 介護国保連ＩＦ異動区分
     */
    public RString get介護国保連ＩＦ異動区分() {
        return entity.get事業者().getIdoKubun();
    }

    /**
     * 介護国保連ＩＦ異動年月日を返します。
     *
     * @return 介護国保連ＩＦ異動年月日
     */
    public FlexibleDate get介護国保連ＩＦ異動年月日() {
        return entity.get事業者().getIdoYMD();
    }

    /**
     * 介護国保連ＩＦ法人種別を返します。
     *
     * @return 介護国保連ＩＦ法人種別
     */
    public RString get介護国保連ＩＦ法人種別() {
        return entity.get事業者().getHojinShubetsu();
    }

    /**
     * 申請者氏名（漢字）を返します。
     *
     * @return 申請者氏名（漢字）
     */
    public RString get申請者氏名_漢字() {
        return entity.get事業者().getShinseishaNameKanji();
    }

    /**
     * 申請者氏名（カナ）を返します。
     *
     * @return 申請者氏名（カナ）
     */
    public RString get申請者氏名_カナ() {
        return entity.get事業者().getShinseishaNameKana();
    }

    /**
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.get事業者().getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.get事業者().getShinseishaAddressKanji();
    }

    /**
     * 申請者住所（カナ）を返します。
     *
     * @return 申請者住所（カナ）
     */
    public RString get申請者住所_カナ() {
        return entity.get事業者().getShinseishaAddressKana();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public RString get申請者電話番号() {
        return entity.get事業者().getShinseishaTelNo();
    }

    /**
     * 申請者FAX番号を返します。
     *
     * @return 申請者FAX番号
     */
    public RString get申請者FAX番号() {
        return entity.get事業者().getShinseishaFaxNo();
    }

    /**
     * 事業所代表者役職を返します。
     *
     * @return 事業所代表者役職
     */
    public RString get事業所代表者役職() {
        return entity.get事業者().getJigyoshoDaihyoshaYakushoku();
    }

    /**
     * 事業所代表者氏名を返します。
     *
     * @return 事業所代表者氏名
     */
    public RString get事業所代表者氏名() {
        return entity.get事業者().getJigyoshoDaihyoshaNameKanji();
    }

    /**
     * 事業所代表者氏名カナを返します。
     *
     * @return 事業所代表者氏名カナ
     */
    public RString get事業所代表者氏名カナ() {
        return entity.get事業者().getJigyoshoDaihyoshaNameKana();
    }

    /**
     * 事業所代表者郵便番号を返します。
     *
     * @return 事業所代表者郵便番号
     */
    public YubinNo get事業所代表者郵便番号() {
        return entity.get事業者().getJigyoshoDaihyoshaYubinNo();
    }

    /**
     * 事業所代表者住所を返します。
     *
     * @return 事業所代表者住所
     */
    public RString get事業所代表者住所() {
        return entity.get事業者().getJigyoshoDaihyoshaAddressKanji();
    }

    /**
     * 事業所代表者住所カナを返します。
     *
     * @return 事業所代表者住所カナ
     */
    public RString get事業所代表者住所カナ() {
        return entity.get事業者().getJigyoshoDaihyoshaAddressKana();
    }

    /**
     * 事業所管理者氏名を返します。
     *
     * @return 事業所管理者氏名
     */
    public RString get事業所管理者氏名() {
        return entity.get事業者().getJigyoshoKanrishaNameKanji();
    }

    /**
     * 事業所管理者氏名カナを返します。
     *
     * @return 事業所管理者氏名カナ
     */
    public RString get事業所管理者氏名カナ() {
        return entity.get事業者().getJigyoshoKanrishaNameKana();
    }

    /**
     * 事業所管理者郵便番号を返します。
     *
     * @return 事業所管理者郵便番号
     */
    public YubinNo get事業所管理者郵便番号() {
        return entity.get事業者().getJigyoshoKanrishaYubinNo();
    }

    /**
     * 事業所管理者住所を返します。
     *
     * @return 事業所管理者住所
     */
    public RString get事業所管理者住所() {
        return entity.get事業者().getJigyoshoKanrishaAddressKanji();
    }

    /**
     * 事業所管理者住所カナを返します。
     *
     * @return 事業所管理者住所カナ
     */
    public RString get事業所管理者住所カナ() {
        return entity.get事業者().getJigyoshoKanrishaAddressKana();
    }

    /**
     * サービス事業所名を返します。
     *
     * @return サービス事業所名
     */
    public RString getサービス事業所名() {
        return entity.get事業者().getServiceJigyoshoNameKanji();
    }

    /**
     * サービス事業所名カナを返します。
     *
     * @return サービス事業所名カナ
     */
    public RString getサービス事業所名カナ() {
        return entity.get事業者().getServiceJigyoshoNameKana();
    }

    /**
     * サービス事業所郵便番号を返します。
     *
     * @return サービス事業所郵便番号
     */
    public YubinNo getサービス事業所郵便番号() {
        return entity.get事業者().getServiceJigyoshoYubinNo();
    }

    /**
     * サービス事業所住所を返します。
     *
     * @return サービス事業所住所
     */
    public RString getサービス事業所住所() {
        return entity.get事業者().getServiceJigyoshoAddressKanji();
    }

    /**
     * サービス事業所住所カナを返します。
     *
     * @return サービス事業所住所カナ
     */
    public RString getサービス事業所住所カナ() {
        return entity.get事業者().getServiceJigyoshoAddressKana();
    }

    /**
     * サービス事業所電話番号を返します。
     *
     * @return サービス事業所電話番号
     */
    public RString getサービス事業所電話番号() {
        return entity.get事業者().getServiceJigyoshoTelNo();
    }

    /**
     * サービス事業所FAX番号を返します。
     *
     * @return サービス事業所FAX番号
     */
    public RString getサービス事業所FAX番号() {
        return entity.get事業者().getServiceJigyoshoFaxNo();
    }

    /**
     * サービス事業所事業開始年月日を返します。
     *
     * @return サービス事業所事業開始年月日
     */
    public FlexibleDate getサービス事業所事業開始年月日() {
        return entity.get事業者().getServiceJigyoshoJigyoKaisiYMD();
    }

    /**
     * サービス事業所事業休止年月日を返します。
     *
     * @return サービス事業所事業休止年月日
     */
    public FlexibleDate getサービス事業所事業休止年月日() {
        return entity.get事業者().getServiceJigyoshoJigyoKyushiYMD();
    }

    /**
     * サービス事業所事業廃止年月日を返します。
     *
     * @return サービス事業所事業廃止年月日
     */
    public FlexibleDate getサービス事業所事業廃止年月日() {
        return entity.get事業者().getServiceJigyoshoJigyoHaishiYMD();
    }

    /**
     * サービス事業所事業再開年月日を返します。
     *
     * @return サービス事業所事業再開年月日
     */
    public FlexibleDate getサービス事業所事業再開年月日() {
        return entity.get事業者().getServiceJigyoshoJigyoSaikaiYMD();
    }

    /**
     * 受領委任区分を返します。
     *
     * @return 受領委任区分
     */
    public RString get受領委任区分() {
        return entity.get事業者().getJuryoIninKubu();
    }

    /**
     * 市町村特別給付登録開始年月日を返します。
     *
     * @return 市町村特別給付登録開始年月日
     */
    public FlexibleDate get市町村特別給付登録開始年月日() {
        return entity.get事業者().getTorokuKaishiYMD();
    }

    /**
     * 市町村特別給付登録終了年月日を返します。
     *
     * @return 市町村特別給付登録終了年月日
     */
    public FlexibleDate get市町村特別給付登録終了年月日() {
        return entity.get事業者().getTorokuShuryoYMD();
    }

    /**
     * 生活保護法による指定の有を返します。
     *
     * @return 生活保護法による指定の有
     */
    public boolean is生活保護法による指定の有() {
        return entity.get事業者().getSeikatsuhogoShiteiFlag();
    }

    /**
     * {@link TokubetsuKyufuJigyoshaSearchEntity}のクローンを返します。
     *
     * @return {@link TokubetsuKyufuJigyoshaSearchEntity}のクローン
     */
    @Override
    public TokubetsuKyufuJigyoshaSearchEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}のクローン
     */
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity to事業者Entity() {
        return this.entity.get事業者().clone();
    }

    /**
     * 市町村特別給付サービス事業者の識別子{@link TokubetsuKyufuJigyoshaSearchIdentifier}を返します。
     *
     * @return 市町村特別給付サービス事業者の識別子{@link TokubetsuKyufuJigyoshaSearchIdentifier}
     */
    @Override
    public TokubetsuKyufuJigyoshaSearchIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村特別給付サービス事業者を削除対象とします。<br/>
     * {@link TokubetsuKyufuJigyoshaSearchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokubetsuKyufuJigyoshaSearchBusiness}
     */
    @Override
    public TokubetsuKyufuJigyoshaSearchBusiness deleted() {
        TokubetsuKyufuJigyoshaSearchEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokubetsuKyufuJigyoshaSearchBusiness(deletedEntity, id);
    }

    /**
     * {@link TokubetsuKyufuJigyoshaSearchBusiness}のシリアライズ形式を提供します。
     *
     * @return {@link TokubetsuKyufuJigyoshaSearchBusiness}のシリアライズ形式
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

        private final TokubetsuKyufuJigyoshaSearchEntity entity;
        private final TokubetsuKyufuJigyoshaSearchIdentifier id;

        private _SerializationProxy(TokubetsuKyufuJigyoshaSearchEntity entity, TokubetsuKyufuJigyoshaSearchIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokubetsuKyufuJigyoshaSearchBusiness(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokubetsuKyufuJigyoshaSearchBuilder createBuilderForEdit() {
        return new TokubetsuKyufuJigyoshaSearchBuilder(entity, id);
    }
}
