/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokkiIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlagIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（概況調査）を管理するクラスです。
 */
public class NinteichosahyoGaikyoChosa extends ModelBase<NinteichosahyoGaikyoChosaIdentifier, DbT5202NinteichosahyoGaikyoChosaEntity, NinteichosahyoGaikyoChosa> implements Serializable {

    private final DbT5202NinteichosahyoGaikyoChosaEntity entity;
    private final NinteichosahyoGaikyoChosaIdentifier id;
    private final Models<GaikyoTokkiIdentifier, GaikyoTokki> gaikyoTokki;
    private final Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> ninteichosahyoKihonChosa;
    private final Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> ninteichosahyoKinyuItem;
    private final Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> ninteichosahyoServiceJokyo;
    private final Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> ninteichosahyoServiceJokyoFlag;
    private final Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> ninteichosahyoShisetsuRiyo;
    private final Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> ninteichosahyoTokkijiko;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（概況調査）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public NinteichosahyoGaikyoChosa(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        this.entity = new DbT5202NinteichosahyoGaikyoChosaEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.id = new NinteichosahyoGaikyoChosaIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号
        );
        this.gaikyoTokki = Models.create(new ArrayList<GaikyoTokki>());
        this.ninteichosahyoKihonChosa = Models.create(new ArrayList<NinteichosahyoKihonChosa>());
        this.ninteichosahyoKinyuItem = Models.create(new ArrayList<NinteichosahyoKinyuItem>());
        this.ninteichosahyoServiceJokyo = Models.create(new ArrayList<NinteichosahyoServiceJokyo>());
        this.ninteichosahyoServiceJokyoFlag = Models.create(new ArrayList<NinteichosahyoServiceJokyoFlag>());
        this.ninteichosahyoShisetsuRiyo = Models.create(new ArrayList<NinteichosahyoShisetsuRiyo>());
        this.ninteichosahyoTokkijiko = Models.create(new ArrayList<NinteichosahyoTokkijiko>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5202NinteichosahyoGaikyoChosaEntity}より{@link NinteichosahyoGaikyoChosa}を生成します。
     *
     * @param entity DBより取得した{@link DbT5202NinteichosahyoGaikyoChosaEntity}
     */
    public NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity entity) {
        this.entity = requireNonNull(entity.get認定調査票_概況調査Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）"));
        this.id = new NinteichosahyoGaikyoChosaIdentifier(
                entity.get認定調査票_概況調査Entity().getShinseishoKanriNo(),
                entity.get認定調査票_概況調査Entity().getNinteichosaRirekiNo());
        List<GaikyoTokki> gaikyoTokkiList = new ArrayList<>();
        for (DbT5206GaikyoTokkiEntity niniEntity : entity.get認定調査票_概況特記Entity()) {
            gaikyoTokkiList.add(new GaikyoTokki(niniEntity));
        }
        this.gaikyoTokki = Models.create(gaikyoTokkiList);

        List<NinteichosahyoKihonChosa> ninteichosahyoKihonChosaList = new ArrayList<>();
        for (NinteichosahyoKihonChosaEntity todokedeshaEntity : entity.get認定調査票_基本調査Entity()) {
            ninteichosahyoKihonChosaList.add(new NinteichosahyoKihonChosa(todokedeshaEntity));
        }
        this.ninteichosahyoKihonChosa = Models.create(ninteichosahyoKihonChosaList);

        List<NinteichosahyoKinyuItem> ninteichosahyoKinyuItemList = new ArrayList<>();
        for (DbT5209NinteichosahyoKinyuItemEntity todokedeshaEntity : entity.get認定調査票_概況調査_記入項目Entity()) {
            ninteichosahyoKinyuItemList.add(new NinteichosahyoKinyuItem(todokedeshaEntity));
        }
        this.ninteichosahyoKinyuItem = Models.create(ninteichosahyoKinyuItemList);

        List<NinteichosahyoServiceJokyo> ninteichosahyoServiceJokyoList = new ArrayList<>();
        for (DbT5207NinteichosahyoServiceJokyoEntity todokedeshaEntity : entity.get認定調査票_概況調査_サービスの状況Entity()) {
            ninteichosahyoServiceJokyoList.add(new NinteichosahyoServiceJokyo(todokedeshaEntity));
        }
        this.ninteichosahyoServiceJokyo = Models.create(ninteichosahyoServiceJokyoList);

        List<NinteichosahyoServiceJokyoFlag> ninteichosahyoServiceJokyoFlagList = new ArrayList<>();
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity todokedeshaEntity : entity.get認定調査票_概況調査_サービスの状況フラグEntity()) {
            ninteichosahyoServiceJokyoFlagList.add(new NinteichosahyoServiceJokyoFlag(todokedeshaEntity));
        }
        this.ninteichosahyoServiceJokyoFlag = Models.create(ninteichosahyoServiceJokyoFlagList);

        List<NinteichosahyoShisetsuRiyo> ninteichosahyoShisetsuRiyoList = new ArrayList<>();
        for (DbT5210NinteichosahyoShisetsuRiyoEntity todokedeshaEntity : entity.get認定調査票_概況調査_施設利用Entity()) {
            ninteichosahyoShisetsuRiyoList.add(new NinteichosahyoShisetsuRiyo(todokedeshaEntity));
        }
        this.ninteichosahyoShisetsuRiyo = Models.create(ninteichosahyoShisetsuRiyoList);

        List<NinteichosahyoTokkijiko> ninteichosahyoTokkijikoList = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity todokedeshaEntity : entity.get認定調査票_特記情報Entity()) {
            ninteichosahyoTokkijikoList.add(new NinteichosahyoTokkijiko(todokedeshaEntity));
        }
        this.ninteichosahyoTokkijiko = Models.create(ninteichosahyoTokkijikoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param id {@link NinteichosahyoGaikyoChosaIdentifier}
     */
    NinteichosahyoGaikyoChosa(
            DbT5202NinteichosahyoGaikyoChosaEntity entity,
            NinteichosahyoGaikyoChosaIdentifier id,
            Models<GaikyoTokkiIdentifier, GaikyoTokki> gaikyoTokki,
            Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> ninteichosahyoKihonChosa,
            Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> ninteichosahyoKinyuItem,
            Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> ninteichosahyoServiceJokyo,
            Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> ninteichosahyoServiceJokyoFlag,
            Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> ninteichosahyoShisetsuRiyo,
            Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> ninteichosahyoTokkijiko
    ) {
        this.entity = entity;
        this.id = id;
        this.gaikyoTokki = gaikyoTokki;
        this.ninteichosahyoKihonChosa = ninteichosahyoKihonChosa;
        this.ninteichosahyoKinyuItem = ninteichosahyoKinyuItem;
        this.ninteichosahyoServiceJokyo = ninteichosahyoServiceJokyo;
        this.ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag;
        this.ninteichosahyoShisetsuRiyo = ninteichosahyoShisetsuRiyo;
        this.ninteichosahyoTokkijiko = ninteichosahyoTokkijiko;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 認定調査依頼区分コードを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.getNinteichousaIraiKubunCode();
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return entity.getNinteichosaIraiKaisu();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 調査委託区分コードを返します。
     *
     * @return 調査委託区分コード
     */
    public Code get調査委託区分コード() {
        return entity.getChosaItakuKubunCode();
    }

    /**
     * 認定調査区分コードを返します。
     *
     * @return 認定調査区分コード
     */
    public Code get認定調査区分コード() {
        return entity.getNinteiChosaKubunCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo get認定調査委託先コード() {
        return entity.getChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getChosainCode();
    }

    /**
     * 認定調査実施場所コードを返します。
     *
     * @return 認定調査実施場所コード
     */
    public Code get認定調査実施場所コード() {
        return entity.getChosaJisshiBashoCode();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return entity.getChosaJisshiBashoMeisho();
    }

    /**
     * 実施場所イメージ共有ファイルIDを返します。
     *
     * @return 実施場所イメージ共有ファイルID
     */
    public RDateTime get実施場所イメージ共有ファイルID() {
        return entity.getJisshiBashoImageSharedFileId();
    }

    /**
     * 認定調査・サービス区分コードを返します。
     *
     * @return 認定調査_サービス区分コード
     */
    public Code get認定調査_サービス区分コード() {
        return entity.getServiceKubunCode();
    }

    /**
     * 利用施設名を返します。
     *
     * @return 利用施設名
     */
    public RString get利用施設名() {
        return entity.getRiyoShisetsuShimei();
    }

    /**
     * 利用施設住所を返します。
     *
     * @return 利用施設住所
     */
    public AtenaJusho get利用施設住所() {
        return entity.getRiyoShisetsuJusho();
    }

    /**
     * 利用施設電話番号を返します。
     *
     * @return 利用施設電話番号
     */
    public TelNo get利用施設電話番号() {
        return entity.getRiyoShisetsuTelNo();
    }

    /**
     * 利用施設郵便番号を返します。
     *
     * @return 利用施設郵便番号
     */
    public YubinNo get利用施設郵便番号() {
        return entity.getRiyoShisetsuYubinNo();
    }

    /**
     * 利用施設名イメージ共有ファイルIDを返します。
     *
     * @return 利用施設名イメージ共有ファイルID
     */
    public RDateTime get利用施設名イメージ共有ファイルID() {
        return entity.getRiyoShisetsuNameImageSharedFileId();
    }

    /**
     * 利用施設住所イメージ共有ファイルIDを返します。
     *
     * @return 利用施設住所イメージ共有ファイルID
     */
    public RDateTime get利用施設住所イメージ共有ファイルID() {
        return entity.getRiyoShisetsuJushoImageSharedFileId();
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDを返します。
     *
     * @return 利用施設電話番号イメージ共有ファイルID
     */
    public RDateTime get利用施設電話番号イメージ共有ファイルID() {
        return entity.getRiyoShisetsuTelNoImageSharedFileId();
    }

    /**
     * 特記を返します。
     *
     * @return 特記
     */
    public RString get特記() {
        return entity.getTokki();
    }

    /**
     * 特記イメージ共有ファイルIDを返します。
     *
     * @return 特記イメージ共有ファイルID
     */
    public RDateTime get特記イメージ共有ファイルID() {
        return entity.getTokkiImageSharedFileId();
    }

    /**
     * 認定調査特記事項受付年月日を返します。
     *
     * @return 認定調査特記事項受付年月日
     */
    public FlexibleDate get認定調査特記事項受付年月日() {
        return entity.getTokkijikoUketsukeYMD();
    }

    /**
     * 認定調査特記事項受領年月日を返します。
     *
     * @return 認定調査特記事項受領年月日
     */
    public FlexibleDate get認定調査特記事項受領年月日() {
        return entity.getTokkijikoJuryoYMD();
    }

    /**
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}のクローンを返します。
     *
     * @return {@link DbT5202NinteichosahyoGaikyoChosaEntity}のクローン
     */
    @Override
    public DbT5202NinteichosahyoGaikyoChosaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（概況調査）の識別子{@link NinteichosahyoGaikyoChosaIdentifier}を返します。
     *
     * @return 認定調査票（概況調査）の識別子{@link NinteichosahyoGaikyoChosaIdentifier}
     */
    @Override
    public NinteichosahyoGaikyoChosaIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（概況調査）配下の要素を削除対象とします。<br/>
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 認定調査票（概況調査）配下の要素である認定調査票（概況特記）情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（基本調査）情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（概況調査）記入項目情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（概況調査）サービスの状況情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（概況調査）サービスの状況フラグ情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（概況調査）施設利用情報の{@link Models#deleteOrRemoveAll() }と
     * 認定調査票（特記情報）情報の{@link Models#deleteOrRemoveAll() }とを実行します。
     * 削除処理結果となる{@link NinteichosahyoGaikyoChosa}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoGaikyoChosa}
     * @throws IllegalStateException
     * DbT5202NinteichosahyoGaikyoChosaEntityのデータ状態が変更の場合
     */
    @Override
    public NinteichosahyoGaikyoChosa deleted() {
        DbT5202NinteichosahyoGaikyoChosaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoGaikyoChosa(
                deletedEntity, id, gaikyoTokki.deleted(), ninteichosahyoKihonChosa.deleted(),
                ninteichosahyoKinyuItem.deleted(), ninteichosahyoServiceJokyo.deleted(),
                ninteichosahyoServiceJokyoFlag.deleted(), ninteichosahyoShisetsuRiyo.deleted(),
                ninteichosahyoTokkijiko.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gaikyoTokki.hasAnyChanged() || ninteichosahyoKihonChosa.hasAnyChanged()
                || ninteichosahyoKinyuItem.hasAnyChanged() || ninteichosahyoServiceJokyo.hasAnyChanged()
                || ninteichosahyoServiceJokyoFlag.hasAnyChanged() || ninteichosahyoShisetsuRiyo.hasAnyChanged()
                || ninteichosahyoTokkijiko.hasAnyChanged();
    }

    /**
     * 認定調査票（概況調査）のみを変更対象とします。<br/>
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoGaikyoChosa}
     */
    public NinteichosahyoGaikyoChosa modifiedModel() {
        DbT5202NinteichosahyoGaikyoChosaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoGaikyoChosa(
                modifiedEntity, id, gaikyoTokki, ninteichosahyoKihonChosa, ninteichosahyoKinyuItem,
                ninteichosahyoServiceJokyo, ninteichosahyoServiceJokyoFlag, ninteichosahyoShisetsuRiyo, ninteichosahyoTokkijiko);
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況特記）情報に対して、指定の識別子に該当する認定調査票（概況特記）情報を返します。
     *
     * @param id 認定調査票（概況特記）情報の識別子
     * @return 認定調査票（概況特記）情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況特記）情報がない場合
     */
    public GaikyoTokki getGaikyoTokki(GaikyoTokkiIdentifier id) {
        if (gaikyoTokki.contains(id)) {
            return gaikyoTokki.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況特記）情報をリストで返します。
     *
     * @return 認定調査票（概況特記）情報リスト
     */
    public List<GaikyoTokki> getGaikyoTokkiList() {
        return new ArrayList<>(gaikyoTokki.values());

    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（基本調査）情報に対して、指定の識別子に該当する認定調査票（基本調査）情報を返します。
     *
     * @param id 認定調査票（基本調査）情報の識別子
     * @return 認定調査票（基本調査）情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（基本調査）情報がない場合
     */
    public NinteichosahyoKihonChosa getNinteichosahyoKihonChosa(NinteichosahyoKihonChosaIdentifier id) {
        if (ninteichosahyoKihonChosa.contains(id)) {
            return ninteichosahyoKihonChosa.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（基本調査）情報をリストで返します。
     *
     * @return 認定調査票（基本調査）情報リスト
     */
    public List<NinteichosahyoKihonChosa> getNinteichosahyoKihonChosaList() {
        return new ArrayList<>(ninteichosahyoKihonChosa.values());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）記入項目情報に対して、指定の識別子に該当する認定調査票（概況調査）記入項目情報を返します。
     *
     * @param id 認定調査票（概況調査）記入項目情報の識別子
     * @return 認定調査票（概況調査）記入項目情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況調査）記入項目情報がない場合
     */
    public NinteichosahyoKinyuItem getNinteichosahyoKinyuItem(NinteichosahyoKinyuItemIdentifier id) {
        if (ninteichosahyoKinyuItem.contains(id)) {
            return ninteichosahyoKinyuItem.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）記入項目情報をリストで返します。
     *
     * @return 認定調査票（概況調査）記入項目情報リスト
     */
    public List<NinteichosahyoKinyuItem> getNinteichosahyoKinyuItemList() {
        return new ArrayList<>(ninteichosahyoKinyuItem.values());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）サービスの状況情報に対して、指定の識別子に該当する認定調査票（概況調査）サービスの状況情報を返します。
     *
     * @param id 認定調査票（概況調査）サービスの状況情報の識別子
     * @return 認定調査票（概況調査）サービスの状況情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況調査）サービスの状況情報がない場合
     */
    public NinteichosahyoServiceJokyo getNinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoIdentifier id) {
        if (ninteichosahyoServiceJokyo.contains(id)) {
            return ninteichosahyoServiceJokyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）サービスの状況情報をリストで返します。
     *
     * @return 認定調査票（概況調査）サービスの状況情報リスト
     */
    public List<NinteichosahyoServiceJokyo> getNinteichosahyoServiceJokyoList() {
        return new ArrayList<>(ninteichosahyoServiceJokyo.values());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）サービスの状況フラグ情報に対して、指定の識別子に該当する認定調査票（概況調査）サービスの状況フラグ情報を返します。
     *
     * @param id 認定調査票（概況調査）サービスの状況フラグ情報の識別子
     * @return 認定調査票（概況調査）サービスの状況フラグ情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況調査）サービスの状況フラグ情報がない場合
     */
    public NinteichosahyoServiceJokyoFlag getNinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagIdentifier id) {
        if (ninteichosahyoServiceJokyoFlag.contains(id)) {
            return ninteichosahyoServiceJokyoFlag.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）サービスの状況フラグ情報をリストで返します。
     *
     * @return 認定調査票（概況調査）サービスの状況フラグ情報リスト
     */
    public List<NinteichosahyoServiceJokyoFlag> getNinteichosahyoServiceJokyoFlagList() {
        return new ArrayList<>(ninteichosahyoServiceJokyoFlag.values());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）施設利用情報に対して、指定の識別子に該当する認定調査票（概況調査）施設利用情報を返します。
     *
     * @param id 認定調査票（概況調査）施設利用情報の識別子
     * @return 認定調査票（概況調査）施設利用情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況調査）施設利用情報がない場合
     */
    public NinteichosahyoShisetsuRiyo getNinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoIdentifier id) {
        if (ninteichosahyoShisetsuRiyo.contains(id)) {
            return ninteichosahyoShisetsuRiyo.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）施設利用情報をリストで返します。
     *
     * @return 認定調査票（概況調査）施設利用情報リスト
     */
    public List<NinteichosahyoShisetsuRiyo> getNinteichosahyoShisetsuRiyoList() {
        return new ArrayList<>(ninteichosahyoShisetsuRiyo.values());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）施設利用情報に対して、指定の識別子に該当する認定調査票（概況調査）施設利用情報を返します。
     *
     * @param id 認定調査票（概況調査）施設利用情報の識別子
     * @return 認定調査票（概況調査）施設利用情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（概況調査）施設利用情報がない場合
     */
    public NinteichosahyoTokkijiko getNinteichosahyoTokkijiko(NinteichosahyoTokkijikoIdentifier id) {
        if (ninteichosahyoTokkijiko.contains(id)) {
            return ninteichosahyoTokkijiko.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（概況調査）が保持する認定調査票（概況調査）施設利用情報をリストで返します。
     *
     * @return 認定調査票（概況調査）施設利用情報リスト
     */
    public List<NinteichosahyoTokkijiko> getNinteichosahyoTokkijikoList() {
        return new ArrayList<>(ninteichosahyoTokkijiko.values());
    }

    /**
     * {@link NinteichosahyoGaikyoChosa}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoGaikyoChosa}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gaikyoTokki, ninteichosahyoKihonChosa, ninteichosahyoKinyuItem,
                ninteichosahyoServiceJokyo, ninteichosahyoServiceJokyoFlag, ninteichosahyoShisetsuRiyo, ninteichosahyoTokkijiko);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5202NinteichosahyoGaikyoChosaEntity entity;
        private final NinteichosahyoGaikyoChosaIdentifier id;
        private final Models<GaikyoTokkiIdentifier, GaikyoTokki> gaikyoTokki;
        private final Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> ninteichosahyoKihonChosa;
        private final Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> ninteichosahyoKinyuItem;
        private final Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> ninteichosahyoServiceJokyo;
        private final Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> ninteichosahyoServiceJokyoFlag;
        private final Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> ninteichosahyoShisetsuRiyo;
        private final Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> ninteichosahyoTokkijiko;

        private _SerializationProxy(
                DbT5202NinteichosahyoGaikyoChosaEntity entity,
                NinteichosahyoGaikyoChosaIdentifier id,
                Models<GaikyoTokkiIdentifier, GaikyoTokki> gaikyoTokki,
                Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> ninteichosahyoKihonChosa,
                Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> ninteichosahyoKinyuItem,
                Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> ninteichosahyoServiceJokyo,
                Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> ninteichosahyoServiceJokyoFlag,
                Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> ninteichosahyoShisetsuRiyo,
                Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> ninteichosahyoTokkijiko
        ) {
            this.entity = entity;
            this.id = id;
            this.gaikyoTokki = gaikyoTokki;
            this.ninteichosahyoKihonChosa = ninteichosahyoKihonChosa;
            this.ninteichosahyoKinyuItem = ninteichosahyoKinyuItem;
            this.ninteichosahyoServiceJokyo = ninteichosahyoServiceJokyo;
            this.ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag;
            this.ninteichosahyoShisetsuRiyo = ninteichosahyoShisetsuRiyo;
            this.ninteichosahyoTokkijiko = ninteichosahyoTokkijiko;
        }

        private Object readResolve() {
            return new NinteichosahyoGaikyoChosa(this.entity, this.id, this.gaikyoTokki, this.ninteichosahyoKihonChosa, this.ninteichosahyoKinyuItem,
                    this.ninteichosahyoServiceJokyo, this.ninteichosahyoServiceJokyoFlag, this.ninteichosahyoShisetsuRiyo, this.ninteichosahyoTokkijiko);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosahyoGaikyoChosaBuilder#build()}を使用してください。
     *
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder createBuilderForEdit() {
        return new NinteichosahyoGaikyoChosaBuilder(entity, id, gaikyoTokki, ninteichosahyoKihonChosa, ninteichosahyoKinyuItem,
                ninteichosahyoServiceJokyo, ninteichosahyoServiceJokyoFlag, ninteichosahyoShisetsuRiyo, ninteichosahyoTokkijiko);
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
        final NinteichosahyoGaikyoChosa other = (NinteichosahyoGaikyoChosa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
