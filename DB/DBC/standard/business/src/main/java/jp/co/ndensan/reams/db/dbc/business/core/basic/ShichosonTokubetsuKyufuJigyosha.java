/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
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
 * 市町村特別給付サービス事業者を管理するクラスです。
 */
public class ShichosonTokubetsuKyufuJigyosha extends
        ModelBase<ShichosonTokubetsuKyufuJigyoshaIdentifier, DbT3065ShichosonTokubetsuKyufuJigyoshaEntity, ShichosonTokubetsuKyufuJigyosha>
        implements Serializable {

    private final DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity;
    private final ShichosonTokubetsuKyufuJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 市町村特別給付サービス事業者の新規作成時に使用します。
     *
     * @param 市町村特別給付用事業者番号 市町村特別給付用事業者番号
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @param 履歴番号 履歴番号
     */
    public ShichosonTokubetsuKyufuJigyosha(JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            int 履歴番号) {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
        this.entity.setJigyoshaNo(市町村特別給付用事業者番号);
        this.entity.setServiceCode(市町村特別給付用サービスコード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShichosonTokubetsuKyufuJigyoshaIdentifier(
                市町村特別給付用事業者番号,
                市町村特別給付用サービスコード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}より{@link ShichosonTokubetsuKyufuJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}
     */
    public ShichosonTokubetsuKyufuJigyosha(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス事業者"));
        this.id = new ShichosonTokubetsuKyufuJigyoshaIdentifier(
                entity.getJigyoshaNo(),
                entity.getServiceCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}
     * @param id {@link ShichosonTokubetsuKyufuJigyoshaIdentifier}
     */
    ShichosonTokubetsuKyufuJigyosha(
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity,
            ShichosonTokubetsuKyufuJigyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村特別給付用事業者番号を返します。
     *
     * @return 市町村特別給付用事業者番号
     */
    public JigyoshaNo get市町村特別給付用事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 市町村特別給付用サービスコードを返します。
     *
     * @return 市町村特別給付用サービスコード
     */
    public ServiceCode get市町村特別給付用サービスコード() {
        return entity.getServiceCode();
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
     * 介護国保連ＩＦ異動区分を返します。
     *
     * @return 介護国保連ＩＦ異動区分
     */
    public RString get介護国保連ＩＦ異動区分() {
        return entity.getIdoKubun();
    }

    /**
     * 介護国保連ＩＦ異動年月日を返します。
     *
     * @return 介護国保連ＩＦ異動年月日
     */
    public FlexibleDate get介護国保連ＩＦ異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 介護国保連ＩＦ法人種別を返します。
     *
     * @return 介護国保連ＩＦ法人種別
     */
    public RString get介護国保連ＩＦ法人種別() {
        return entity.getHojinShubetsu();
    }

    /**
     * 申請者氏名（漢字）を返します。
     *
     * @return 申請者氏名（漢字）
     */
    public RString get申請者氏名_漢字() {
        return entity.getShinseishaNameKanji();
    }

    /**
     * 申請者氏名（カナ）を返します。
     *
     * @return 申請者氏名（カナ）
     */
    public RString get申請者氏名_カナ() {
        return entity.getShinseishaNameKana();
    }

    /**
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaAddressKanji();
    }

    /**
     * 申請者住所（カナ）を返します。
     *
     * @return 申請者住所（カナ）
     */
    public RString get申請者住所_カナ() {
        return entity.getShinseishaAddressKana();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public RString get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請者FAX番号を返します。
     *
     * @return 申請者FAX番号
     */
    public RString get申請者FAX番号() {
        return entity.getShinseishaFaxNo();
    }

    /**
     * 事業所代表者役職を返します。
     *
     * @return 事業所代表者役職
     */
    public RString get事業所代表者役職() {
        return entity.getJigyoshoDaihyoshaYakushoku();
    }

    /**
     * 事業所代表者氏名を返します。
     *
     * @return 事業所代表者氏名
     */
    public RString get事業所代表者氏名() {
        return entity.getJigyoshoDaihyoshaNameKanji();
    }

    /**
     * 事業所代表者氏名カナを返します。
     *
     * @return 事業所代表者氏名カナ
     */
    public RString get事業所代表者氏名カナ() {
        return entity.getJigyoshoDaihyoshaNameKana();
    }

    /**
     * 事業所代表者郵便番号を返します。
     *
     * @return 事業所代表者郵便番号
     */
    public YubinNo get事業所代表者郵便番号() {
        return entity.getJigyoshoDaihyoshaYubinNo();
    }

    /**
     * 事業所代表者住所を返します。
     *
     * @return 事業所代表者住所
     */
    public RString get事業所代表者住所() {
        return entity.getJigyoshoDaihyoshaAddressKanji();
    }

    /**
     * 事業所代表者住所カナを返します。
     *
     * @return 事業所代表者住所カナ
     */
    public RString get事業所代表者住所カナ() {
        return entity.getJigyoshoDaihyoshaAddressKana();
    }

    /**
     * 事業所管理者氏名を返します。
     *
     * @return 事業所管理者氏名
     */
    public RString get事業所管理者氏名() {
        return entity.getJigyoshoKanrishaNameKanji();
    }

    /**
     * 事業所管理者氏名カナを返します。
     *
     * @return 事業所管理者氏名カナ
     */
    public RString get事業所管理者氏名カナ() {
        return entity.getJigyoshoKanrishaNameKana();
    }

    /**
     * 事業所管理者郵便番号を返します。
     *
     * @return 事業所管理者郵便番号
     */
    public YubinNo get事業所管理者郵便番号() {
        return entity.getJigyoshoKanrishaYubinNo();
    }

    /**
     * 事業所管理者住所を返します。
     *
     * @return 事業所管理者住所
     */
    public RString get事業所管理者住所() {
        return entity.getJigyoshoKanrishaAddressKanji();
    }

    /**
     * 事業所管理者住所カナを返します。
     *
     * @return 事業所管理者住所カナ
     */
    public RString get事業所管理者住所カナ() {
        return entity.getJigyoshoKanrishaAddressKana();
    }

    /**
     * サービス事業所名を返します。
     *
     * @return サービス事業所名
     */
    public RString getサービス事業所名() {
        return entity.getServiceJigyoshoNameKanji();
    }

    /**
     * サービス事業所名カナを返します。
     *
     * @return サービス事業所名カナ
     */
    public RString getサービス事業所名カナ() {
        return entity.getServiceJigyoshoNameKana();
    }

    /**
     * サービス事業所郵便番号を返します。
     *
     * @return サービス事業所郵便番号
     */
    public YubinNo getサービス事業所郵便番号() {
        return entity.getServiceJigyoshoYubinNo();
    }

    /**
     * サービス事業所住所を返します。
     *
     * @return サービス事業所住所
     */
    public RString getサービス事業所住所() {
        return entity.getServiceJigyoshoAddressKanji();
    }

    /**
     * サービス事業所住所カナを返します。
     *
     * @return サービス事業所住所カナ
     */
    public RString getサービス事業所住所カナ() {
        return entity.getServiceJigyoshoAddressKana();
    }

    /**
     * サービス事業所電話番号を返します。
     *
     * @return サービス事業所電話番号
     */
    public RString getサービス事業所電話番号() {
        return entity.getServiceJigyoshoTelNo();
    }

    /**
     * サービス事業所FAX番号を返します。
     *
     * @return サービス事業所FAX番号
     */
    public RString getサービス事業所FAX番号() {
        return entity.getServiceJigyoshoFaxNo();
    }

    /**
     * サービス事業所事業開始年月日を返します。
     *
     * @return サービス事業所事業開始年月日
     */
    public FlexibleDate getサービス事業所事業開始年月日() {
        return entity.getServiceJigyoshoJigyoKaisiYMD();
    }

    /**
     * サービス事業所事業休止年月日を返します。
     *
     * @return サービス事業所事業休止年月日
     */
    public FlexibleDate getサービス事業所事業休止年月日() {
        return entity.getServiceJigyoshoJigyoKyushiYMD();
    }

    /**
     * サービス事業所事業廃止年月日を返します。
     *
     * @return サービス事業所事業廃止年月日
     */
    public FlexibleDate getサービス事業所事業廃止年月日() {
        return entity.getServiceJigyoshoJigyoHaishiYMD();
    }

    /**
     * サービス事業所事業再開年月日を返します。
     *
     * @return サービス事業所事業再開年月日
     */
    public FlexibleDate getサービス事業所事業再開年月日() {
        return entity.getServiceJigyoshoJigyoSaikaiYMD();
    }

    /**
     * 受領委任区分を返します。
     *
     * @return 受領委任区分
     */
    public RString get受領委任区分() {
        return entity.getJuryoIninKubu();
    }

    /**
     * 市町村特別給付登録開始年月日を返します。
     *
     * @return 市町村特別給付登録開始年月日
     */
    public FlexibleDate get市町村特別給付登録開始年月日() {
        return entity.getTorokuKaishiYMD();
    }

    /**
     * 市町村特別給付登録終了年月日を返します。
     *
     * @return 市町村特別給付登録終了年月日
     */
    public FlexibleDate get市町村特別給付登録終了年月日() {
        return entity.getTorokuShuryoYMD();
    }

    /**
     * 生活保護法による指定の有を返します。
     *
     * @return 生活保護法による指定の有
     */
    public boolean is生活保護法による指定の有() {
        return entity.getSeikatsuhogoShiteiFlag();
    }

    /**
     * {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}のクローン
     */
    @Override
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 市町村特別給付サービス事業者の識別子{@link ShichosonTokubetsuKyufuJigyoshaIdentifier}を返します。
     *
     * @return 市町村特別給付サービス事業者の識別子{@link ShichosonTokubetsuKyufuJigyoshaIdentifier}
     */
    @Override
    public ShichosonTokubetsuKyufuJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村特別給付サービス事業者を削除対象とします。<br/>
     * {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShichosonTokubetsuKyufuJigyosha}
     */
    @Override
    public ShichosonTokubetsuKyufuJigyosha deleted() {
        DbT3065ShichosonTokubetsuKyufuJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShichosonTokubetsuKyufuJigyosha(deletedEntity, id);
    }

    /**
     * {@link ShichosonTokubetsuKyufuJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link ShichosonTokubetsuKyufuJigyosha}のシリアライズ形式
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

        private final DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity;
        private final ShichosonTokubetsuKyufuJigyoshaIdentifier id;

        private _SerializationProxy(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity, ShichosonTokubetsuKyufuJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShichosonTokubetsuKyufuJigyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder createBuilderForEdit() {
        return new ShichosonTokubetsuKyufuJigyoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
