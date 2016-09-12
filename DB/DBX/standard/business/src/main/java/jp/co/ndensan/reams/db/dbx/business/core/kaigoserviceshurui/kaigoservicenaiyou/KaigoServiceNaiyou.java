/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護サービス内容を管理するクラスです。
 *
 * @reamsid_L DBX-9999-011 sunhaidi
 */
public class KaigoServiceNaiyou
        extends ModelBase<KaigoServiceNaiyouIdentifier, DbT7131KaigoServiceNaiyouEntity, KaigoServiceNaiyou>
        implements Serializable {

    private final DbT7131KaigoServiceNaiyouEntity entity;
    private final KaigoServiceNaiyouIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護サービス内容の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 提供開始年月 提供開始年月
     * @param 履歴番号 履歴番号
     */
    public KaigoServiceNaiyou(ServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7131KaigoServiceNaiyouEntity();
        this.entity.setServiceShuruiCd(サービス種類コード);
        this.entity.setServiceKoumokuCd(サービス項目コード);
        this.entity.setTeikyoKaishiYM(提供開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KaigoServiceNaiyouIdentifier(
                サービス種類コード,
                サービス項目コード,
                提供開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7131KaigoServiceNaiyouEntity}より{@link KaigoServiceNaiyou}を生成します。
     *
     * @param entity DBより取得した{@link DbT7131KaigoServiceNaiyouEntity}
     */
    public KaigoServiceNaiyou(DbT7131KaigoServiceNaiyouEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容"));
        this.id = new KaigoServiceNaiyouIdentifier(
                entity.getServiceShuruiCd(),
                entity.getServiceKoumokuCd(),
                entity.getTeikyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7131KaigoServiceNaiyouEntity}
     * @param id {@link KaigoServiceNaiyouIdentifier}
     */
    KaigoServiceNaiyou(
            DbT7131KaigoServiceNaiyouEntity entity,
            KaigoServiceNaiyouIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCd();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return entity.getServiceKoumokuCd();
    }

    /**
     * 提供開始年月を返します。
     *
     * @return 提供開始年月
     */
    public FlexibleYearMonth get提供開始年月() {
        return entity.getTeikyoKaishiYM();
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
     * 提供終了年月を返します。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth get提供終了年月() {
        return entity.getTeikyoShuryoYM();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getServiceName();
    }

    /**
     * サービス略称を返します。
     *
     * @return サービス略称
     */
    public RString getサービス略称() {
        return entity.getServiceNameRyaku();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 単位数識別を返します。
     *
     * @return 単位数識別
     */
    public Code get単位数識別() {
        return entity.getTanisuShikibetsuCode();
    }

    /**
     * 単位数算定単位を返します。
     *
     * @return 単位数算定単位
     */
    public Code get単位数算定単位() {
        return entity.getTanisuSanteiTaniCode();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public Code get異動事由() {
        return entity.getIdouJiyuCode();
    }

    /**
     * 限度額対象外フラグを返します。
     *
     * @return 限度額対象外フラグ
     */
    public RString get限度額対象外フラグ() {
        return entity.getGendogakuTaishogaiFlag();
    }

    /**
     * 外部サービス利用型区分を返します。
     *
     * @return 外部サービス利用型区分
     */
    public RString get外部サービス利用型区分() {
        return entity.getGaibuServiceRiyoKataKubun();
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
     * 利用者負担定率・定額区分を返します。
     *
     * @return 利用者負担定率・定額区分
     */
    public RString get利用者負担定率定額区分() {
        return entity.getRiyosyaFutanTeiritsuTeigakuKubun();
    }

    /**
     * 更新有無フラグを返します。
     *
     * @return 更新有無フラグ
     */
    public RString get更新有無フラグ() {
        return entity.getKoshinUmuFoag();
    }

    /**
     * 元点数を返します。
     *
     * @return 元点数
     */
    public RString get元点数() {
        return entity.getMotoTensu();
    }

    /**
     * 元限度額対象外フラグを返します。
     *
     * @return 元限度額対象外フラグ
     */
    public RString get元限度額対象外フラグ() {
        return entity.getMotoGendogakuTaishogaiFlag();
    }

    /**
     * 元単位数識別コードを返します。
     *
     * @return 元単位数識別コード
     */
    public RString get元単位数識別コード() {
        return entity.getMotoTaniShikibetsuCd();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public RString get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public RString get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 二次予防事業対象者実施区分（非該当）を返します。
     *
     * @return 二次予防事業対象者実施区分（非該当）
     */
    public RString get二次予防事業対象者実施区分非該当() {
        return entity.getNijiyoboJigyoTaishaJishiKubunHigaito();
    }

    /**
     * 要支援１受給者実施区分を返します。
     *
     * @return 要支援１受給者実施区分
     */
    public RString get要支援１受給者実施区分() {
        return entity.getYoshien1JukyushaJishiKubun();
    }

    /**
     * 要支援２受給者実施区分を返します。
     *
     * @return 要支援２受給者実施区分
     */
    public RString get要支援２受給者実施区分() {
        return entity.getYoshien2JukyushaJishiKubun();
    }

    /**
     * 対象事業者実施区分を返します。
     *
     * @return 対象事業者実施区分
     */
    public RString get対象事業者実施区分() {
        return entity.getTaishoJigyoJishiKubun();
    }

    /**
     * 総合事業サービス区分を返します。
     *
     * @return 総合事業サービス区分
     */
    public RString get総合事業サービス区分() {
        return entity.getSogoJigyoServiceKubun();
    }

    /**
     * {@link DbT7131KaigoServiceNaiyouEntity}のクローンを返します。
     *
     * @return {@link DbT7131KaigoServiceNaiyouEntity}のクローン
     */
    @Override
    public DbT7131KaigoServiceNaiyouEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護サービス内容の識別子{@link KaigoServiceNaiyouIdentifier}を返します。
     *
     * @return 介護サービス内容の識別子{@link KaigoServiceNaiyouIdentifier}
     */
    @Override
    public KaigoServiceNaiyouIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護サービス内容のみを変更対象とします。<br/>
     * {@link DbT7131KaigoServiceNaiyouEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoServiceNaiyou}
     */
    public KaigoServiceNaiyou modifiedModel() {
        DbT7131KaigoServiceNaiyouEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoServiceNaiyou(
                modifiedEntity, id);
    }

    /**
     * 保持する介護サービス内容を削除対象とします。<br/>
     * {@link DbT7131KaigoServiceNaiyouEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoServiceNaiyou}
     */
    @Override
    public KaigoServiceNaiyou deleted() {
        DbT7131KaigoServiceNaiyouEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoServiceNaiyou(deletedEntity, id);
    }

    /**
     * {@link KaigoServiceNaiyou}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoServiceNaiyou}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2702026391207130486L;

        private final DbT7131KaigoServiceNaiyouEntity entity;
        private final KaigoServiceNaiyouIdentifier id;

        private _SerializationProxy(DbT7131KaigoServiceNaiyouEntity entity, KaigoServiceNaiyouIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoServiceNaiyou(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoServiceNaiyouBuilder createBuilderForEdit() {
        return new KaigoServiceNaiyouBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final KaigoServiceNaiyou other = (KaigoServiceNaiyou) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
