/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査委託先情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public class NinteichosaItakusakiJoho extends
        ModelBase<NinteichosaItakusakiJohoIdentifier, DbT5910NinteichosaItakusakiJohoEntity, NinteichosaItakusakiJoho> implements Serializable {

    private static final long serialVersionUID = 5013160557608226847L;

    private final DbT5910NinteichosaItakusakiJohoEntity entity;
    private final NinteichosaItakusakiJohoIdentifier id;

    private final Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho;

    /**
     * コンストラクタです。<br/>
     * 認定調査委託先情報の新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     */
    public NinteichosaItakusakiJoho(LasdecCode 市町村コード,
            RString 認定調査委託先コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        this.entity = new DbT5910NinteichosaItakusakiJohoEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        this.id = new NinteichosaItakusakiJohoIdentifier(
                市町村コード,
                new ChosaItakusakiCode(認定調査委託先コード)
        );
        this.chosainJoho = Models.create(new ArrayList<ChosainJoho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5913ChosainJohoEntity}より{@link NinteichosaItakusakiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5910NinteichosaItakusakiJohoEntity}
     */
    public NinteichosaItakusakiJoho(NinteichosaItakusakiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get認定調査委託先情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報"));
        this.id = new NinteichosaItakusakiJohoIdentifier(
                entity.get認定調査委託先情報Entity().getShichosonCode(),
                new ChosaItakusakiCode(entity.get認定調査委託先情報Entity().getNinteichosaItakusakiCode()));
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        for (DbT5913ChosainJohoEntity niniEntity : entity.get調査員情報Entity()) {
            chosainJohoList.add(new ChosainJoho(niniEntity));
        }
        this.chosainJoho = Models.create(chosainJohoList);

    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5910NinteichosaItakusakiJohoEntity}
     * @param id {@link NinteichosaItakusakiJohoIdentifier}
     */
    NinteichosaItakusakiJoho(
            DbT5910NinteichosaItakusakiJohoEntity entity,
            NinteichosaItakusakiJohoIdentifier id,
            Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho) {
        this.entity = entity;
        this.id = id;
        this.chosainJoho = chosainJoho;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
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
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者カナ名称() {
        return entity.getJigyoshaMeishoKana();
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
    public RString get住所() {
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
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 代表者氏名を返します。
     *
     * @return 代表者氏名
     */
    public RString get代表者氏名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 代表者カナ氏名を返します。
     *
     * @return 代表者カナ氏名
     */
    public RString get代表者カナ氏名() {
        return entity.getDaihyoshaNameKana();
    }

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 特定調査員表示フラグを返します。
     *
     * @return 特定調査員表示フラグ
     */
    public Boolean is特定調査員表示フラグ() {
        return entity.getTokuteiChosainDisplayFlag();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    public int get割付定員() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    public ChikuCode get割付地区() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 自動割付フラグを返します。
     *
     * @return 自動割付フラグ
     */
    public boolean is自動割付フラグTrue() {
        return entity.getAutoWaritsukeFlag();
    }

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    public RString get機関の区分() {
        return entity.getKikanKubun();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.getJokyoFlag();
    }

    /**
     * 金融機関コードを返します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return entity.getKinyuKikanCode();
    }

    /**
     * 金融機関支店コードを返します。
     *
     * @return 金融機関支店コード
     */
    public KinyuKikanShitenCode get金融機関支店コード() {
        return entity.getKinyuKikanShitenCode();
    }

    /**
     * 預金種別を返します。
     *
     * @return 預金種別
     */
    public RString get預金種別() {
        return entity.getYokinShubetsu();
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaNo();
    }

    /**
     * 口座名義人カナを返します。
     *
     * @return 口座名義人カナ
     */
    public AtenaKanaMeisho get口座名義人カナ() {
        return entity.getKozaMeigininKana();
    }

    /**
     * 漢字名義人を返します。
     *
     * @return 漢字名義人
     */
    public AtenaMeisho get漢字名義人() {
        return entity.getKozaMeiginin();
    }

    /**
     * {@link DbT5910NinteichosaItakusakiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5910NinteichosaItakusakiJohoEntity}のクローン
     */
    @Override
    public DbT5910NinteichosaItakusakiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査委託先情報の識別子{@link NinteichosaItakusakiJohoIdentifier}を返します。
     *
     * @return 認定調査委託先情報の識別子{@link NinteichosaItakusakiJohoIdentifier}
     */
    @Override
    public NinteichosaItakusakiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査委託先情報配下の要素を削除対象とします。<br/>
     * {@link DbT5910NinteichosaItakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 認定調査委託先情報配下の要素である調査員情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link NinteichosaItakusakiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteichosaItakusakiJoho}
     * @throws IllegalStateException
     * DbT5910NinteichosaItakusakiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public NinteichosaItakusakiJoho deleted() {
        DbT5910NinteichosaItakusakiJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosaItakusakiJoho(
                deletedEntity, id, chosainJoho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || chosainJoho.hasAnyChanged();
    }

    /**
     * 認定調査委託先情報のみを変更対象とします。<br/>
     * {@link DbT5910NinteichosaItakusakiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosaItakusakiJoho}
     */
    public NinteichosaItakusakiJoho modifiedModel() {
        DbT5910NinteichosaItakusakiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosaItakusakiJoho(
                modifiedEntity, id, chosainJoho);
    }

    /**
     * 認定調査委託先情報が保持する調査員情報に対して、指定の識別子に該当する調査員情報を返します。
     *
     * @param id 調査員情報の識別子
     * @return 調査員情報
     * @throws IllegalStateException 指定の識別子に該当する調査員情報がない場合
     */
    public ChosainJoho getChosainJoho(ChosainJohoIdentifier id) {
        if (chosainJoho.contains(id)) {
            return chosainJoho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査委託先情報が保持する調査員情報をリストで返します。
     *
     * @return 調査員情報リスト
     */
    public List<ChosainJoho> getChosainJohoList() {
        return new ArrayList<>(chosainJoho.values());

    }

    /**
     * {@link NinteichosaItakusakiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosaItakusakiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, chosainJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5910NinteichosaItakusakiJohoEntity entity;
        private final NinteichosaItakusakiJohoIdentifier id;
        private final Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho;

        private _SerializationProxy(
                DbT5910NinteichosaItakusakiJohoEntity entity,
                NinteichosaItakusakiJohoIdentifier id,
                Models<ChosainJohoIdentifier, ChosainJoho> chosainJoho) {
            this.entity = entity;
            this.id = id;
            this.chosainJoho = chosainJoho;
        }

        private Object readResolve() {
            return new NinteichosaItakusakiJoho(this.entity, this.id, this.chosainJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosaItakusakiJohoBuilder#build()}を使用してください。
     *
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder createBuilderForEdit() {
        return new NinteichosaItakusakiJohoBuilder(entity, id, chosainJoho);
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
        final NinteichosaItakusakiJoho other = (NinteichosaItakusakiJoho) obj;
        return Objects.equals(this.id, other.id);
    }
}
