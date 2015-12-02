/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMaster extends ParentModelBase<KoseiShichosonMasterIdentifier, DbT5051KoseiShichosonMasterEntity, KoseiShichosonMaster> implements Serializable {

    private static final long serialVersionUID = -2447965927672568960L;

    private final DbT5051KoseiShichosonMasterEntity entity;
    private final KoseiShichosonMasterIdentifier id;
    private final Models<NinteichosaItakusakiJohoIdentifier, NinteichosaItakusakiJoho> ninteichosaItakusakiJoho;

    /**
     * コンストラクタです。<br/>
     * 構成市町村マスタの新規作成時に使用します。
     *
     * @param 市町村識別ID 市町村識別ID
     */
    public KoseiShichosonMaster(RString 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        this.entity = new DbT5051KoseiShichosonMasterEntity();
        this.entity.setShichosonShokibetsuID(市町村識別ID);
        this.id = new KoseiShichosonMasterIdentifier(
                市町村識別ID
        );
        this.ninteichosaItakusakiJoho = Models.create(new ArrayList<NinteichosaItakusakiJoho>());

    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5051KoseiShichosonMasterEntity}より{@link KoseiShichosonMaster}を生成します。
     *
     * @param entity DBより取得した{@link DbT5051KoseiShichosonMasterEntity}
     */
    public KoseiShichosonMaster(KoseiShichosonMasterRelateEntity entity) {
        this.entity = requireNonNull(entity.get構成市町村マスタEntity(), UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));
        this.id = new KoseiShichosonMasterIdentifier(
                entity.get構成市町村マスタEntity().getShichosonShokibetsuID());
        List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = new ArrayList<>();
        for (NinteichosaItakusakiJohoRelateEntity niniEntity : entity.get認定調査委託先情報Entity()) {
            ninteichosaItakusakiJohoList.add(new NinteichosaItakusakiJoho(niniEntity));
        }
        this.ninteichosaItakusakiJoho = Models.create(ninteichosaItakusakiJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5051KoseiShichosonMasterEntity}
     * @param id {@link KoseiShichosonMasterIdentifier}
     */
    KoseiShichosonMaster(
            DbT5051KoseiShichosonMasterEntity entity,
            KoseiShichosonMasterIdentifier id,
            Models<NinteichosaItakusakiJohoIdentifier, NinteichosaItakusakiJoho> ninteichosaItakusakiJoho) {
        this.entity = entity;
        this.id = id;
        this.ninteichosaItakusakiJoho = ninteichosaItakusakiJoho;
    }

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return 国保連広域内市町村番号
     */
    public RString get国保連広域内市町村番号() {
        return entity.getKokuhorenKoikiShichosonNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return entity.getGunMeisho();
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
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
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
     * 最優先地区コードを返します。
     *
     * @return 最優先地区コード
     */
    public RString get最優先地区コード() {
        return entity.getYusenChikuCode();
    }

    /**
     * 帳票用都道府県名称表示有無を返します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    public RString get帳票用都道府県名称表示有無() {
        return entity.getTyohyoTodoufukenHyojiUmu();
    }

    /**
     * 帳票用郡名称表示有無を返します。
     *
     * @return 帳票用郡名称表示有無
     */
    public RString get帳票用郡名称表示有無() {
        return entity.getTyohyoGunHyojiUmu();
    }

    /**
     * 帳票用市町村名称表示有無を返します。
     *
     * @return 帳票用市町村名称表示有無
     */
    public RString get帳票用市町村名称表示有無() {
        return entity.getTyohyoShichosonHyojiUmu();
    }

    /**
     * 帳票用住所編集方法を返します。
     *
     * @return 帳票用住所編集方法
     */
    public RString get帳票用住所編集方法() {
        return entity.getTyohyoJushoHenshuHouhou();
    }

    /**
     * 帳票用方書表示有無を返します。
     *
     * @return 帳票用方書表示有無
     */
    public RString get帳票用方書表示有無() {
        return entity.getTyohyoKatagakiHyojiUmu();
    }

    /**
     * 外国人氏名表示方法を返します。
     *
     * @return 外国人氏名表示方法
     */
    public RString get外国人氏名表示方法() {
        return entity.getGaikokujinHyojiHouhou();
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 特徴分配集約を返します。
     *
     * @return 特徴分配集約
     */
    public RString get特徴分配集約() {
        return entity.getTokuchoBunpaishuyaku();
    }

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    /**
     * 加入日を返します。
     *
     * @return 加入日
     */
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    /**
     * 離脱日を返します。
     *
     * @return 離脱日
     */
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    /**
     * 合併旧市町村区分を返します。
     *
     * @return 合併旧市町村区分
     */
    public RString get合併旧市町村区分() {
        return entity.getGappeiKyuShichosonKubun();
    }

    /**
     * 合併旧市町村表示有無を返します。
     *
     * @return 合併旧市町村表示有無
     */
    public RString get合併旧市町村表示有無() {
        return entity.getGappeiKyuShichosonHyojiUmu();
    }

    /**
     * 合併情報地域番号を返します。
     *
     * @return 合併情報地域番号
     */
    public RString get合併情報地域番号() {
        return entity.getGappeiChiikiNo();
    }

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用保険者番号
     */
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を返します。
     *
     * @return 運用形態区分
     */
    public RString get運用形態区分() {
        return entity.getUnyoKeitaiKubun();
    }

    /**
     * {@link DbT5051KoseiShichosonMasterEntity}のクローンを返します。
     *
     * @return {@link DbT5051KoseiShichosonMasterEntity}のクローン
     */
    @Override
    public DbT5051KoseiShichosonMasterEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 構成市町村マスタの識別子{@link KoseiShichosonMasterIdentifier}を返します。
     *
     * @return 構成市町村マスタの識別子{@link KoseiShichosonMasterIdentifier}
     */
    @Override
    public KoseiShichosonMasterIdentifier identifier() {
        return this.id;
    }

    /**
     * 構成市町村マスタ配下の要素を削除対象とします。<br/>
     * {@link DbT5051KoseiShichosonMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 構成市町村マスタ配下の要素である認定調査委託先情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link KoseiShichosonMaster}を返します。
     *
     * @return 削除対象処理実施後の{@link KoseiShichosonMaster}
     * @throws IllegalStateException
     * DbT5051KoseiShichosonMasterEntityのデータ状態が変更の場合
     */
    @Override
    public KoseiShichosonMaster deleted() {
        DbT5051KoseiShichosonMasterEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoseiShichosonMaster(
                deletedEntity, id, ninteichosaItakusakiJoho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || ninteichosaItakusakiJoho.hasAnyChanged();
    }

    /**
     * 構成市町村マスタのみを変更対象とします。<br/>
     * {@link DbT5051KoseiShichosonMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoseiShichosonMaster}
     */
    @Override
    public KoseiShichosonMaster modifiedModel() {
        DbT5051KoseiShichosonMasterEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoseiShichosonMaster(
                modifiedEntity, id, ninteichosaItakusakiJoho);
    }

    /**
     * 構成市町村マスタが保持する認定調査委託先情報に対して、指定の識別子に該当する認定調査委託先情報を返します。
     *
     * @param id 認定調査委託先情報の識別子
     * @return 認定調査委託先情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査委託先情報がない場合
     */
    public NinteichosaItakusakiJoho getNinteichosaItakusakiJoho(NinteichosaItakusakiJohoIdentifier id) {
        if (ninteichosaItakusakiJoho.contains(id)) {
            return ninteichosaItakusakiJoho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 構成市町村マスタが保持する認定調査委託先情報をリストで返します。
     *
     * @return 認定調査委託先情報リスト
     */
    public List<NinteichosaItakusakiJoho> getNinteichosaItakusakiJohoiList() {
        return new ArrayList<>(ninteichosaItakusakiJoho.values());

    }

    /**
     * {@link KoseiShichosonMaster}のシリアライズ形式を提供します。
     *
     * @return {@link KoseiShichosonMaster}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, ninteichosaItakusakiJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5051KoseiShichosonMasterEntity entity;
        private final KoseiShichosonMasterIdentifier id;
        private final Models<NinteichosaItakusakiJohoIdentifier, NinteichosaItakusakiJoho> ninteichosaItakusakiJoho;

        private _SerializationProxy(
                DbT5051KoseiShichosonMasterEntity entity,
                KoseiShichosonMasterIdentifier id,
                Models<NinteichosaItakusakiJohoIdentifier, NinteichosaItakusakiJoho> ninteichosaItakusakiJoho) {
            this.entity = entity;
            this.id = id;
            this.ninteichosaItakusakiJoho = ninteichosaItakusakiJoho;
        }

        private Object readResolve() {
            return new KoseiShichosonMaster(this.entity, this.id, this.ninteichosaItakusakiJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KoseiShichosonMasterBuilder#build()}を使用してください。
     *
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder createBuilderForEdit() {
        return new KoseiShichosonMasterBuilder(entity, id, ninteichosaItakusakiJoho);
    }
    // </editor-fold>

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
        final KoseiShichosonMaster other = (KoseiShichosonMaster) obj;
        return Objects.equals(this.id, other.id);
    }

}
