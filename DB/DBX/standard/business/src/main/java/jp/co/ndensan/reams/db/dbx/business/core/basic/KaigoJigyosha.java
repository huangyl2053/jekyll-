/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護事業者を管理するクラスです。
 *
 * @reamsid_L DBX-9999-022 tianshuai
 */
public class KaigoJigyosha extends ParentModelBase<KaigoJigyoshaIdentifier, DbT7060KaigoJigyoshaEntity, KaigoJigyosha> implements Serializable {

    private final DbT7060KaigoJigyoshaEntity entity;
    private final KaigoJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護事業者の新規作成時に使用します。
     *
     * @param 事業者番号 事業者番号
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyosha(JigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));
        this.entity = new DbT7060KaigoJigyoshaEntity();
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYukoKaishiYMD(有効開始日);
        this.id = new KaigoJigyoshaIdentifier(
                事業者番号,
                有効開始日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7060KaigoJigyoshaEntity}より{@link KaigoJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT7060KaigoJigyoshaEntity}
     */
    public KaigoJigyosha(DbT7060KaigoJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービス"));
        this.id = new KaigoJigyoshaIdentifier(
                entity.getJigyoshaNo(),
                entity.getYukoKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7060KaigoJigyoshaEntity}
     * @param id {@link KaigoJigyoshaIdentifier}
     */
    KaigoJigyosha(
            DbT7060KaigoJigyoshaEntity entity,
            KaigoJigyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public RString get異動事由() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 事業開始日を返します。
     *
     * @return 事業開始日
     */
    public FlexibleDate get事業開始日() {
        return entity.getJigyoKaishiYMD();
    }

    /**
     * 事業休止日を返します。
     *
     * @return 事業休止日
     */
    public FlexibleDate get事業休止日() {
        return entity.getJigyoKyushiYMD();
    }

    /**
     * 事業再開日を返します。
     *
     * @return 事業再開日
     */
    public FlexibleDate get事業再開日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * 事業廃止日を返します。
     *
     * @return 事業廃止日
     */
    public FlexibleDate get事業廃止日() {
        return entity.getJigyoHaishiYMD();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get事業者名称カナ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public AtenaJusho get事業者住所() {
        return entity.getJigyoshaAddress();
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    public RString get事業者住所カナ() {
        return entity.getJigyoshaKanaAddress();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 宛先部署を返します。
     *
     * @return 宛先部署
     */
    public RString get宛先部署() {
        return entity.getAtesakiBusho();
    }

    /**
     * 宛先人名を返します。
     *
     * @return 宛先人名
     */
    public AtenaMeisho get宛先人名() {
        return entity.getAtesakininName();
    }

    /**
     * 宛先人名カナを返します。
     *
     * @return 宛先人名カナ
     */
    public AtenaKanaMeisho get宛先人名カナ() {
        return entity.getAtesakininNamekana();
    }

    /**
     * 指定_基準該当等事業所区分を返します。
     *
     * @return 指定_基準該当等事業所区分
     */
    public Code get指定_基準該当等事業所区分() {
        return entity.getShiteiKijungaitoJigyoshaKubun();
    }

    /**
     * 所在市町村を返します。
     *
     * @return 所在市町村
     */
    public RString get所在市町村() {
        return entity.getShozaiShichoson();
    }

    /**
     * サービス実施地域を返します。
     *
     * @return サービス実施地域
     */
    public RString getサービス実施地域() {
        return entity.getServiceJisshiChiiki();
    }

    /**
     * 法人等種別を返します。
     *
     * @return 法人等種別
     */
    public Code get法人等種別() {
        return entity.getHojinShubetsu();
    }

    /**
     * ベッド数を返します。
     *
     * @return ベッド数
     */
    public int getベッド数() {
        return entity.getBedSu();
    }

    /**
     * 所属人数を返します。
     *
     * @return 所属人数
     */
    public int get所属人数() {
        return entity.getShozokuNinzu();
    }

    /**
     * 利用者数を返します。
     *
     * @return 利用者数
     */
    public int get利用者数() {
        return entity.getRiyoshaSu();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * {@link DbT7060KaigoJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT7060KaigoJigyoshaEntity}のクローン
     */
    @Override
    public DbT7060KaigoJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護事業者の識別子{@link KaigoJigyoshaIdentifier}を返します。
     *
     * @return 介護事業者の識別子{@link KaigoJigyoshaIdentifier}
     */
    @Override
    public KaigoJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護事業者を削除対象とします。<br/> {@link DbT7060KaigoJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoJigyosha}
     */
    @Override
    public KaigoJigyosha deleted() {
        DbT7060KaigoJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoJigyosha(deletedEntity, id);
    }

    /**
     * {@link KaigoJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoJigyosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 介護事業者のみを変更対象とします。<br/> {@link DbT7060KaigoJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoJigyosha}
     */
    @Override
    public KaigoJigyosha modifiedModel() {
        DbT7060KaigoJigyoshaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoJigyosha(modifiedEntity, id);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -7979436055984750761L;
        private final DbT7060KaigoJigyoshaEntity entity;
        private final KaigoJigyoshaIdentifier id;

        private _SerializationProxy(
                DbT7060KaigoJigyoshaEntity entity,
                KaigoJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoJigyosha(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoJigyoshaBuilder createBuilderForEdit() {
        return new KaigoJigyoshaBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KaigoJigyosha other = (KaigoJigyosha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
