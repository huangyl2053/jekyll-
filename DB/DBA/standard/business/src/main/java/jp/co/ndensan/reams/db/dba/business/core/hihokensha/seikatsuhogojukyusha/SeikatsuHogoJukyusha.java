/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShuruiIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikan;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikanIdentifier;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KaigoRyoDairiNofuKubun;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KyugoShisetsuNyuTaishoKubun;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 生活保護受給者を管理するクラスです。
 */
public class SeikatsuHogoJukyusha extends ModelBase<SeikatsuHogoJukyushaIdentifier, UrT0508SeikatsuHogoJukyushaEntity, SeikatsuHogoJukyusha> implements Serializable {

    private final UrT0508SeikatsuHogoJukyushaEntity entity;
    private final SeikatsuHogoJukyushaIdentifier id;
    private final Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui;
    private final Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan;

    /**
     * コンストラクタです。<br/>
     * 生活保護受給者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 受給開始日 受給開始日
     */
    public SeikatsuHogoJukyusha(ShikibetsuCode 識別コード,
            GyomuCode 業務コード,
            FlexibleDate 受給開始日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(受給開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始日"));
        this.entity = new UrT0508SeikatsuHogoJukyushaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setGyomuCode(業務コード);
        this.entity.setJukyuKaishiYMD(受給開始日);
        this.id = new SeikatsuHogoJukyushaIdentifier(
                識別コード,
                業務コード,
                受給開始日
        );
        this.seikatsuHogoFujoShurui = Models.create(new ArrayList<SeikatsuHogoFujoShurui>());
        this.seikatsuHogoTeishikikan = Models.create(new ArrayList<SeikatsuHogoTeishikikan>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link UrT0508SeikatsuHogoJukyushaEntity}より{@link SeikatsuHogoJukyusha}を生成します。
     *
     * @param entity DBより取得した{@link UrT0508SeikatsuHogoJukyushaEntity}
     */
    public SeikatsuHogoJukyusha(SeikatsuHogoJukyushaRelateEntity entity) {
        this.entity = requireNonNull(entity.get生活保護受給者Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護受給者"));
        this.id = new SeikatsuHogoJukyushaIdentifier(
                entity.get生活保護受給者Entity().getShikibetsuCode(),
                entity.get生活保護受給者Entity().getGyomuCode(),
                entity.get生活保護受給者Entity().getJukyuKaishiYMD());
        List<SeikatsuHogoFujoShurui> fujoShuruiList = new ArrayList<>();
        for (UrT0526SeikatsuHogoFujoShuruiEntity fujoShuruiEntity : entity.get生活保護扶助種類Entity()) {
            fujoShuruiList.add(new SeikatsuHogoFujoShurui(fujoShuruiEntity));
        }
        this.seikatsuHogoFujoShurui = Models.create(fujoShuruiList);

        List<SeikatsuHogoTeishikikan> teishikikanList = new ArrayList<>();
        for (UrT0528SeikatsuHogoTeishikikanEntity teishikikanEntity : entity.get生活保護停止期間Entity()) {
            teishikikanList.add(new SeikatsuHogoTeishikikan(teishikikanEntity));
        }
        this.seikatsuHogoTeishikikan = Models.create(teishikikanList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link UrT0508SeikatsuHogoJukyushaEntity}
     * @param id {@link SeikatsuHogoJukyushaIdentifier}
     */
    SeikatsuHogoJukyusha(
            UrT0508SeikatsuHogoJukyushaEntity entity,
            SeikatsuHogoJukyushaIdentifier id,
            Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui,
            Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan
    ) {
        this.entity = entity;
        this.id = id;
        this.seikatsuHogoFujoShurui = seikatsuHogoFujoShurui;
        this.seikatsuHogoTeishikikan = seikatsuHogoTeishikikan;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 業務コードを返します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return entity.getGyomuCode();
    }

    /**
     * 受給開始日を返します。
     *
     * @return 受給開始日
     */
    public FlexibleDate get受給開始日() {
        return entity.getJukyuKaishiYMD();
    }

    /**
     * 受給廃止日を返します。
     *
     * @return 受給廃止日
     */
    public FlexibleDate get受給廃止日() {
        return entity.getJukyuHaishiYMD();
    }

    /**
     * 受給者番号を返します。
     *
     * @return 受給者番号
     */
    public RString get受給者番号() {
        return entity.getJukyushaNo();
    }

    /**
     * 介護保険料代理納付区分を返します。
     *
     * @return 介護保険料代理納付区分
     */
    public KaigoRyoDairiNofuKubun get介護保険料代理納付区分() {
        return entity.getKaigoRyoDairiNofuKubun();
    }

    /**
     * 介護保険料代理納付年月を返します。
     *
     * @return 介護保険料代理納付年月
     */
    public FlexibleYearMonth get介護保険料代理納付年月() {
        return entity.getKaigoRyoDairiNofuYM();
    }

    /**
     * 救護施設入退所区分を返します。
     *
     * @return 救護施設入退所区分
     */
    public KyugoShisetsuNyuTaishoKubun get救護施設入退所区分() {
        return entity.getKyugoShisetsuNyuTaishoKubun();
    }

    /**
     * 救護施設入退所日を返します。
     *
     * @return 救護施設入退所日
     */
    public FlexibleDate get救護施設入退所日() {
        return entity.getKyugoShisetsuNyutaishoYMD();
    }

    /**
     * {@link UrT0508SeikatsuHogoJukyushaEntity}のクローンを返します。
     *
     * @return {@link UrT0508SeikatsuHogoJukyushaEntity}のクローン
     */
    @Override
    public UrT0508SeikatsuHogoJukyushaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 生活保護受給者の識別子{@link SeikatsuHogoJukyushaIdentifier}を返します。
     *
     * @return 生活保護受給者の識別子{@link SeikatsuHogoJukyushaIdentifier}
     */
    @Override
    public SeikatsuHogoJukyushaIdentifier identifier() {
        return this.id;
    }

    /**
     * 生活保護受給者配下の要素を削除対象とします。<br/>
     * {@link UrT0508SeikatsuHogoJukyushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 生活保護受給者配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link SeikatsuHogoJukyusha}を返します。
     *
     * @return 削除対象処理実施後の{@link SeikatsuHogoJukyusha}
     * @throws IllegalStateException
     * UrT0508SeikatsuHogoJukyushaEntityのデータ状態が変更の場合
     */
    @Override
    public SeikatsuHogoJukyusha deleted() {
        UrT0508SeikatsuHogoJukyushaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SeikatsuHogoJukyusha(
                deletedEntity, id, seikatsuHogoFujoShurui.deleted(), seikatsuHogoTeishikikan.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || seikatsuHogoFujoShurui.hasAnyChanged() || seikatsuHogoTeishikikan.hasAnyChanged();
    }

    /**
     * 生活保護受給者のみを変更対象とします。<br/>
     * {@link UrT0508SeikatsuHogoJukyushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SeikatsuHogoJukyusha}
     */
    public SeikatsuHogoJukyusha modifiedModel() {
        UrT0508SeikatsuHogoJukyushaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SeikatsuHogoJukyusha(
                modifiedEntity, id, seikatsuHogoFujoShurui, seikatsuHogoTeishikikan);
    }

    /**
     * 生活保護受給者が保持する生活保護扶助種類情報に対して、指定の識別子に該当する生活保護扶助種類情報を返します。
     *
     * @param id 生活保護扶助種類情報の識別子
     * @return 生活保護扶助種類情報
     * @throws IllegalStateException 指定の識別子に該当する生活保護扶助種類情報がない場合
     */
    public SeikatsuHogoFujoShurui getSeikatsuHogoFujoShurui(SeikatsuHogoFujoShuruiIdentifier id) {
        if (seikatsuHogoFujoShurui.contains(id)) {
            return seikatsuHogoFujoShurui.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 生活保護受給者が保持する生活保護扶助種類情報をリストで返します。
     *
     * @return 生活保護扶助種類情報リスト
     */
    public List<SeikatsuHogoFujoShurui> getSeikatsuHogoFujoShuruiList() {
        return new ArrayList<>(seikatsuHogoFujoShurui.values());

    }

    /**
     * 生活保護受給者が保持する生活保護停止期間情報に対して、指定の識別子に該当する生活保護停止期間情報を返します。
     *
     * @param id 生活保護停止期間情報の識別子
     * @return 生活保護停止期間情報
     * @throws IllegalStateException 指定の識別子に該当する生活保護停止期間情報がない場合
     */
    public SeikatsuHogoTeishikikan getSeikatsuHogoTeishikikan(SeikatsuHogoTeishikikanIdentifier id) {
        if (seikatsuHogoTeishikikan.contains(id)) {
            return seikatsuHogoTeishikikan.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 生活保護受給者が保持する届出者情報をリストで返します。
     *
     * @return 生活保護停止期間情報リスト
     */
    public List<SeikatsuHogoTeishikikan> getSeikatsuHogoTeishikikanList() {
        return new ArrayList<>(seikatsuHogoTeishikikan.values());
    }

    /**
     * {@link SeikatsuHogoJukyusha}のシリアライズ形式を提供します。
     *
     * @return {@link SeikatsuHogoJukyusha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, seikatsuHogoFujoShurui, seikatsuHogoTeishikikan);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final UrT0508SeikatsuHogoJukyushaEntity entity;
        private final SeikatsuHogoJukyushaIdentifier id;
        private final Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui;
        private final Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan;

        private _SerializationProxy(
                UrT0508SeikatsuHogoJukyushaEntity entity,
                SeikatsuHogoJukyushaIdentifier id,
                Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui,
                Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan
        ) {
            this.entity = entity;
            this.id = id;
            this.seikatsuHogoFujoShurui = seikatsuHogoFujoShurui;
            this.seikatsuHogoTeishikikan = seikatsuHogoTeishikikan;
        }

        private Object readResolve() {
            return new SeikatsuHogoJukyusha(this.entity, this.id, this.seikatsuHogoFujoShurui, this.seikatsuHogoTeishikikan);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeikatsuHogoJukyushaBuilder#build()}を使用してください。
     *
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder createBuilderForEdit() {
        return new SeikatsuHogoJukyushaBuilder(entity, id, seikatsuHogoFujoShurui, seikatsuHogoTeishikikan);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final SeikatsuHogoJukyusha other = (SeikatsuHogoJukyusha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
