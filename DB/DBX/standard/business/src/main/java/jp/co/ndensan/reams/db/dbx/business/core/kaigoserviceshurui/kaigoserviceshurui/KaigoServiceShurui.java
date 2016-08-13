/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護サービス種類を管理するクラスです。
 *
 * @reamsid_L DBX-9999-011 sunhaidi
 */
public class KaigoServiceShurui
        extends ParentModelBase<KaigoServiceShuruiIdentifier, DbT7130KaigoServiceShuruiEntity, KaigoServiceShurui>
        implements Serializable {

    private final DbT7130KaigoServiceShuruiEntity entity;
    private final KaigoServiceShuruiIdentifier id;
    private final Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou;

    /**
     * コンストラクタです。<br/>
     * 介護サービス種類の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供開始年月 提供開始年月
     */
    public KaigoServiceShurui(ServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        this.entity = new DbT7130KaigoServiceShuruiEntity();
        this.entity.setServiceShuruiCd(サービス種類コード);
        this.entity.setTeikyoKaishiYM(提供開始年月);
        this.id = new KaigoServiceShuruiIdentifier(
                サービス種類コード,
                提供開始年月
        );
        this.kaigoServiceNaiyou = Models.create(new ArrayList<KaigoServiceNaiyou>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7130KaigoServiceShuruiEntity}より{@link KaigoServiceShurui}を生成します。
     *
     * @param entity DBより取得した{@link DbT7130KaigoServiceShuruiEntity}
     */
    public KaigoServiceShurui(KaigoServiceShuruiEntity entity) {
        this.entity = requireNonNull(entity.get介護サービス種類Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類"));
        this.id = new KaigoServiceShuruiIdentifier(
                entity.get介護サービス種類Entity().getServiceShuruiCd(),
                entity.get介護サービス種類Entity().getTeikyoKaishiYM());
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = new ArrayList<>();
        for (DbT7131KaigoServiceNaiyouEntity niniEntity : entity.get介護サービス内容Entity()) {
            kaigoServiceNaiyouList.add(new KaigoServiceNaiyou(niniEntity));
        }
        this.kaigoServiceNaiyou = Models.create(kaigoServiceNaiyouList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7130KaigoServiceShuruiEntity}
     * @param id {@link KaigoServiceShuruiIdentifier}
     * @param kaigoServiceNaiyou {@link KaigoServiceNaiyou}
     */
    KaigoServiceShurui(
            DbT7130KaigoServiceShuruiEntity entity,
            KaigoServiceShuruiIdentifier id,
            Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou
    ) {
        this.entity = entity;
        this.id = id;
        this.kaigoServiceNaiyou = kaigoServiceNaiyou;
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
     * 提供開始年月を返します。
     *
     * @return 提供開始年月
     */
    public FlexibleYearMonth get提供開始年月() {
        return entity.getTeikyoKaishiYM();
    }

    /**
     * 提供終了年月を返します。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth get提供終了年月() {
        return entity.getTeikyoshuryoYM();
    }

    /**
     * サービス種類名称を返します。
     *
     * @return サービス種類名称
     */
    public RString getサービス種類名称() {
        return entity.getServiceShuruiMeisho();
    }

    /**
     * サービス種類略称を返します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getServiceShuruiRyakusho();
    }

    /**
     * サービス分類コードを返します。
     *
     * @return サービス分類コード
     */
    public Code getサービス分類コード() {
        return entity.getServiceBunrruicode();
    }

    /**
     * 限度額区分を返します。
     *
     * @return 限度額区分
     */
    public RString get限度額区分() {
        return entity.getGendogakuKubun();
    }

    /**
     * 居宅サービス区分を返します。
     *
     * @return 居宅サービス区分
     */
    public RString get居宅サービス区分() {
        return entity.getKyotakuServiceKubun();
    }

    /**
     * 指定サービス区分を返します。
     *
     * @return 指定サービス区分
     */
    public RString get指定サービス区分() {
        return entity.getShiteiServiceKubun();
    }

    /**
     * 基準該当サービス区分を返します。
     *
     * @return 基準該当サービス区分
     */
    public RString get基準該当サービス区分() {
        return entity.getKijunGaitoServiceKubun();
    }

    /**
     * {@link DbT7130KaigoServiceShuruiEntity}のクローンを返します。
     *
     * @return {@link DbT7130KaigoServiceShuruiEntity}のクローン
     */
    @Override
    public DbT7130KaigoServiceShuruiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護サービス種類の識別子{@link KaigoServiceShuruiIdentifier}を返します。
     *
     * @return 介護サービス種類の識別子{@link KaigoServiceShuruiIdentifier}
     */
    @Override
    public KaigoServiceShuruiIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護サービス種類配下の要素を削除対象とします。<br/>
     * {@link DbT7130KaigoServiceShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 介護サービス種類配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link KaigoServiceShurui}を返します。
     *
     * @return 削除対象処理実施後の{@link KaigoServiceShurui}
     * @throws IllegalStateException DbT7130KaigoServiceShuruiEntityのデータ状態が変更の場合
     */
    @Override
    public KaigoServiceShurui deleted() {
        DbT7130KaigoServiceShuruiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoServiceShurui(
                deletedEntity, id, kaigoServiceNaiyou.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kaigoServiceNaiyou.hasAnyChanged();
    }

    /**
     * 介護サービス種類のみを変更対象とします。<br/>
     * {@link DbT7130KaigoServiceShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoServiceShurui}
     */
    @Override
    public KaigoServiceShurui modifiedModel() {
        DbT7130KaigoServiceShuruiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoServiceShurui(
                modifiedEntity, id, kaigoServiceNaiyou);
    }

    /**
     * 介護サービス種類が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public KaigoServiceNaiyou getKaigoServiceNaiyou(KaigoServiceNaiyouIdentifier id) {
        if (kaigoServiceNaiyou.contains(id)) {
            return kaigoServiceNaiyou.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 介護サービス種類が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<KaigoServiceNaiyou> getKaigoServiceNaiyouList() {
        return new ArrayList<>(kaigoServiceNaiyou.values());

    }

    /**
     * {@link KaigoServiceShurui}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoServiceShurui}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kaigoServiceNaiyou);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT7130KaigoServiceShuruiEntity entity;
        private final KaigoServiceShuruiIdentifier id;
        private final Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou;

        private _SerializationProxy(
                DbT7130KaigoServiceShuruiEntity entity,
                KaigoServiceShuruiIdentifier id,
                Models<KaigoServiceNaiyouIdentifier, KaigoServiceNaiyou> kaigoServiceNaiyou
        ) {
            this.entity = entity;
            this.id = id;
            this.kaigoServiceNaiyou = kaigoServiceNaiyou;
        }

        private Object readResolve() {
            return new KaigoServiceShurui(this.entity, this.id, this.kaigoServiceNaiyou);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KaigoServiceShuruiBuilder#build()}を使用してください。
     *
     * @return {@link KaigoServiceShuruiBuilder}
     */
    public KaigoServiceShuruiBuilder createBuilderForEdit() {
        return new KaigoServiceShuruiBuilder(entity, id, kaigoServiceNaiyou);
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
        final KaigoServiceShurui other = (KaigoServiceShurui) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
