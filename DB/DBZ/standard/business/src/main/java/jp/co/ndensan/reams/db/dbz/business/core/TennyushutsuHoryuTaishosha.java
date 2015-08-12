/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 転入保留対象者を管理するクラスです。
 */
public class TennyushutsuHoryuTaishosha extends ModelBase<TennyushutsuHoryuTaishoshaIdentifier, DbT1010TennyushutsuHoryuTaishoshaEntity, TennyushutsuHoryuTaishosha> implements Serializable {

    private final DbT1010TennyushutsuHoryuTaishoshaEntity entity;
    private final TennyushutsuHoryuTaishoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 転入保留対象者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public TennyushutsuHoryuTaishosha(ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new TennyushutsuHoryuTaishoshaIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1010TennyushutsuHoryuTaishoshaEntity}より{@link TennyushutsuHoryuTaishosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1010TennyushutsuHoryuTaishoshaEntity}
     */
    public TennyushutsuHoryuTaishosha(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転入保留対象者"));
        this.id = new TennyushutsuHoryuTaishoshaIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo()
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1010TennyushutsuHoryuTaishoshaEntity}
     * @param id {@link TennyushutsuHoryuTaishoshaIdentifier}
     */
    TennyushutsuHoryuTaishosha(
            DbT1010TennyushutsuHoryuTaishoshaEntity entity,
            TennyushutsuHoryuTaishoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 作成事由コードを返します。
     *
     * @return 作成事由コード
     */
    public RString get作成事由コード() {
        return entity.getSakuseiJiyuCode();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCode();
    }

    /**
     * 住民種別コードを返します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return entity.getJuminShubetsuCode();
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 住民状態コード
     */
    public RString get住民状態コード() {
        return entity.getJuminJotaiCode();
    }

    /**
     * 宛名氏名を返します。
     *
     * @return 宛名氏名
     */
    public AtenaMeisho get宛名氏名() {
        return entity.getAtenaShimei();
    }

    /**
     * 宛名カナ氏名を返します。
     *
     * @return 宛名カナ氏名
     */
    public AtenaKanaMeisho get宛名カナ氏名() {
        return entity.getAtenaKanaShimei();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.getSeibetsuCode();
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 登録異動年月日を返します。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate get登録異動年月日() {
        return entity.getTorokuIdoYMD();
    }

    /**
     * 登録届出年月日を返します。
     *
     * @return 登録届出年月日
     */
    public FlexibleDate get登録届出年月日() {
        return entity.getTorokuTodokedeYMD();
    }

    /**
     * 消除異動年月日を返します。
     *
     * @return 消除異動年月日
     */
    public FlexibleDate get消除異動年月日() {
        return entity.getShojoIdoYMD();
    }

    /**
     * 消除届出年月日を返します。
     *
     * @return 消除届出年月日
     */
    public FlexibleDate get消除届出年月日() {
        return entity.getShojoIdoTodokedeYMD();
    }

    /**
     * 転出予定異動年月日を返します。
     *
     * @return 転出予定異動年月日
     */
    public FlexibleDate get転出予定異動年月日() {
        return entity.getTenshutsuYoteiIdoYMD();
    }

    /**
     * 転出確定異動年月日を返します。
     *
     * @return 転出確定異動年月日
     */
    public FlexibleDate get転出確定異動年月日() {
        return entity.getTenshutsuKakuteiIdoYMD();
    }

    /**
     * 転出確定異動通知年月日を返します。
     *
     * @return 転出確定異動通知年月日
     */
    public FlexibleDate get転出確定異動通知年月日() {
        return entity.getTenshutsuKakuteiIdoTsuchiYMD();
    }

    /**
     * 全国住所コードを返します。
     *
     * @return 全国住所コード
     */
    public RString get全国住所コード() {
        return entity.getZenkokuJushoCode();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return entity.getBanchi();
    }

    /**
     * 方書を返します。
     *
     * @return 方書
     */
    public Katagaki get方書() {
        return entity.getKatagaki();
    }

    /**
     * 転出予定全国住所コードを返します。
     *
     * @return 転出予定全国住所コード
     */
    public ZenkokuJushoCode get転出予定全国住所コード() {
        return entity.getTenshutsuYoteiZenkokuJushoCode();
    }

    /**
     * 転出予定住所を返します。
     *
     * @return 転出予定住所
     */
    public AtenaJusho get転出予定住所() {
        return entity.getTenshutsuYoteiJusho();
    }

    /**
     * 転出予定番地を返します。
     *
     * @return 転出予定番地
     */
    public AtenaBanchi get転出予定番地() {
        return entity.getTenshutsuYoteiBanchi();
    }

    /**
     * 転出予定方書を返します。
     *
     * @return 転出予定方書
     */
    public Katagaki get転出予定方書() {
        return entity.getTenshutsuYoteiKatagaki();
    }

    /**
     * 転出確定全国住所コードを返します。
     *
     * @return 転出確定全国住所コード
     */
    public ZenkokuJushoCode get転出確定全国住所コード() {
        return entity.getTenshutsuKakuteiZenkokuJushoCode();
    }

    /**
     * 転出確定住所を返します。
     *
     * @return 転出確定住所
     */
    public AtenaJusho get転出確定住所() {
        return entity.getTenshutsuKakuteiJusho();
    }

    /**
     * 転出確定番地を返します。
     *
     * @return 転出確定番地
     */
    public AtenaBanchi get転出確定番地() {
        return entity.getTenshutsuKakuteiBanchi();
    }

    /**
     * 転出確定方書を返します。
     *
     * @return 転出確定方書
     */
    public Katagaki get転出確定方書() {
        return entity.getTenshutsuKakuteiKatagaki();
    }

    /**
     * {@link DbT1010TennyushutsuHoryuTaishoshaEntity}のクローンを返します。
     *
     * @return {@link DbT1010TennyushutsuHoryuTaishoshaEntity}のクローン
     */
    @Override
    public DbT1010TennyushutsuHoryuTaishoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 転入保留対象者の識別子{@link TennyushutsuHoryuTaishoshaIdentifier}を返します。
     *
     * @return 転入保留対象者の識別子{@link TennyushutsuHoryuTaishoshaIdentifier}
     */
    @Override
    public TennyushutsuHoryuTaishoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する転入保留対象者を削除対象とします。<br/>
     * {@link DbT1010TennyushutsuHoryuTaishoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TennyushutsuHoryuTaishosha}
     */
    @Override
    public TennyushutsuHoryuTaishosha deleted() {
        DbT1010TennyushutsuHoryuTaishoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TennyushutsuHoryuTaishosha(deletedEntity, id);
    }

    /**
     * {@link TennyushutsuHoryuTaishosha}のシリアライズ形式を提供します。
     *
     * @return {@link TennyushutsuHoryuTaishosha}のシリアライズ形式
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
        private final DbT1010TennyushutsuHoryuTaishoshaEntity entity;
        private final TennyushutsuHoryuTaishoshaIdentifier id;

        private _SerializationProxy(DbT1010TennyushutsuHoryuTaishoshaEntity entity, TennyushutsuHoryuTaishoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TennyushutsuHoryuTaishosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TennyushutsuHoryuTaishoshaBuilder createBuilderForEdit() {
        return new TennyushutsuHoryuTaishoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
