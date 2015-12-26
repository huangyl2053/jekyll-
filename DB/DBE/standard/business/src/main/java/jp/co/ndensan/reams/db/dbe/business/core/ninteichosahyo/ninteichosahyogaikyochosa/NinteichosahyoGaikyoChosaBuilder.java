/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa;

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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link NinteichosahyoGaikyoChosa}の編集を行うビルダークラスです。
 */
public class NinteichosahyoGaikyoChosaBuilder {

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
     * {@link DbT5202NinteichosahyoGaikyoChosaEntity}より{@link NinteichosahyoGaikyoChosa}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param id {@link NinteichosahyoGaikyoChosaIdentifier}
     * @param gaikyoTokki {@link Models<GaikyoTokkiIdentifier, GaikyoTokki>}
     * @param ninteichosahyoKihonChosa
     * {@link Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa>}
     * @param ninteichosahyoKinyuItem
     * {@link Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem>}
     * @param ninteichosahyoServiceJokyo
     * {@link Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo>}
     * @param ninteichosahyoServiceJokyoFlag
     * {@link Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag>}
     * @param ninteichosahyoShisetsuRiyo
     * {@link Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo>}
     * @param ninteichosahyoTokkijiko
     * {@link Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko>}
     *
     */
    NinteichosahyoGaikyoChosaBuilder(
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
        this.entity = entity.clone();
        this.id = id;
        this.gaikyoTokki = gaikyoTokki.clone();
        this.ninteichosahyoKihonChosa = ninteichosahyoKihonChosa.clone();
        this.ninteichosahyoKinyuItem = ninteichosahyoKinyuItem.clone();
        this.ninteichosahyoServiceJokyo = ninteichosahyoServiceJokyo.clone();
        this.ninteichosahyoServiceJokyoFlag = ninteichosahyoServiceJokyoFlag.clone();
        this.ninteichosahyoShisetsuRiyo = ninteichosahyoShisetsuRiyo.clone();
        this.ninteichosahyoTokkijiko = ninteichosahyoTokkijiko.clone();
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 認定調査依頼区分コードを設定します。
     *
     * @param 認定調査依頼区分コード 認定調査依頼区分コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査依頼区分コード(Code 認定調査依頼区分コード) {
        requireNonNull(認定調査依頼区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼区分コード"));
        entity.setNinteichousaIraiKubunCode(認定調査依頼区分コード);
        return this;
    }

    /**
     * 認定調査回数を設定します。
     *
     * @param 認定調査回数 認定調査回数
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査回数(int 認定調査回数) {
        requireNonNull(認定調査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査回数"));
        entity.setNinteichosaIraiKaisu(認定調査回数);
        return this;
    }

    /**
     * 認定調査実施年月日を設定します。
     *
     * @param 認定調査実施年月日 認定調査実施年月日
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査実施年月日(FlexibleDate 認定調査実施年月日) {
        requireNonNull(認定調査実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施年月日"));
        entity.setNinteichosaJisshiYMD(認定調査実施年月日);
        return this;
    }

    /**
     * 認定調査受領年月日を設定します。
     *
     * @param 認定調査受領年月日 認定調査受領年月日
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査受領年月日(FlexibleDate 認定調査受領年月日) {
        requireNonNull(認定調査受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査受領年月日"));
        entity.setNinteichosaJuryoYMD(認定調査受領年月日);
        return this;
    }

    /**
     * 調査委託区分コードを設定します。
     *
     * @param 調査委託区分コード 調査委託区分コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set調査委託区分コード(Code 調査委託区分コード) {
        requireNonNull(調査委託区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託区分コード"));
        entity.setChosaItakuKubunCode(調査委託区分コード);
        return this;
    }

    /**
     * 認定調査区分コードを設定します。
     *
     * @param 認定調査区分コード 認定調査区分コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査区分コード(Code 認定調査区分コード) {
        requireNonNull(認定調査区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査区分コード"));
        entity.setNinteiChosaKubunCode(認定調査区分コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査委託先コード(JigyoshaNo 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setChosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setChosainCode(認定調査員コード);
        return this;
    }

    /**
     * 認定調査実施場所コードを設定します。
     *
     * @param 認定調査実施場所コード 認定調査実施場所コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査実施場所コード(Code 認定調査実施場所コード) {
        requireNonNull(認定調査実施場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施場所コード"));
        entity.setChosaJisshiBashoCode(認定調査実施場所コード);
        return this;
    }

    /**
     * 認定調査実施場所名称を設定します。
     *
     * @param 認定調査実施場所名称 認定調査実施場所名称
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査実施場所名称(RString 認定調査実施場所名称) {
        requireNonNull(認定調査実施場所名称, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施場所名称"));
        entity.setChosaJisshiBashoMeisho(認定調査実施場所名称);
        return this;
    }

    /**
     * 実施場所イメージ共有ファイルIDを設定します。
     *
     * @param 実施場所イメージ共有ファイルID 実施場所イメージ共有ファイルID
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set実施場所イメージ共有ファイルID(RDateTime 実施場所イメージ共有ファイルID) {
        requireNonNull(実施場所イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("実施場所イメージ共有ファイルID"));
        entity.setJisshiBashoImageSharedFileId(実施場所イメージ共有ファイルID);
        return this;
    }

    /**
     * 認定調査・サービス区分コードを設定します。
     *
     * @param 認定調査_サービス区分コード 認定調査_サービス区分コード
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査_サービス区分コード(Code 認定調査_サービス区分コード) {
        requireNonNull(認定調査_サービス区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査・サービス区分コード"));
        entity.setServiceKubunCode(認定調査_サービス区分コード);
        return this;
    }

    /**
     * 利用施設名を設定します。
     *
     * @param 利用施設名 利用施設名
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設名(RString 利用施設名) {
        requireNonNull(利用施設名, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設名"));
        entity.setRiyoShisetsuShimei(利用施設名);
        return this;
    }

    /**
     * 利用施設住所を設定します。
     *
     * @param 利用施設住所 利用施設住所
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設住所(AtenaJusho 利用施設住所) {
        requireNonNull(利用施設住所, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設住所"));
        entity.setRiyoShisetsuJusho(利用施設住所);
        return this;
    }

    /**
     * 利用施設電話番号を設定します。
     *
     * @param 利用施設電話番号 利用施設電話番号
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設電話番号(TelNo 利用施設電話番号) {
        requireNonNull(利用施設電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設電話番号"));
        entity.setRiyoShisetsuTelNo(利用施設電話番号);
        return this;
    }

    /**
     * 利用施設郵便番号を設定します。
     *
     * @param 利用施設郵便番号 利用施設郵便番号
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設郵便番号(YubinNo 利用施設郵便番号) {
        requireNonNull(利用施設郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設郵便番号"));
        entity.setRiyoShisetsuYubinNo(利用施設郵便番号);
        return this;
    }

    /**
     * 利用施設名イメージ共有ファイルIDを設定します。
     *
     * @param 利用施設名イメージ共有ファイルID 利用施設名イメージ共有ファイルID
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設名イメージ共有ファイルID(RDateTime 利用施設名イメージ共有ファイルID) {
        requireNonNull(利用施設名イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設名イメージ共有ファイルID"));
        entity.setRiyoShisetsuNameImageSharedFileId(利用施設名イメージ共有ファイルID);
        return this;
    }

    /**
     * 利用施設住所イメージ共有ファイルIDを設定します。
     *
     * @param 利用施設住所イメージ共有ファイルID 利用施設住所イメージ共有ファイルID
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設住所イメージ共有ファイルID(RDateTime 利用施設住所イメージ共有ファイルID) {
        requireNonNull(利用施設住所イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設住所イメージ共有ファイルID"));
        entity.setRiyoShisetsuJushoImageSharedFileId(利用施設住所イメージ共有ファイルID);
        return this;
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDを設定します。
     *
     * @param 利用施設電話番号イメージ共有ファイルID 利用施設電話番号イメージ共有ファイルID
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set利用施設電話番号イメージ共有ファイルID(RDateTime 利用施設電話番号イメージ共有ファイルID) {
        requireNonNull(利用施設電話番号イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設電話番号イメージ共有ファイルID"));
        entity.setRiyoShisetsuTelNoImageSharedFileId(利用施設電話番号イメージ共有ファイルID);
        return this;
    }

    /**
     * 特記を設定します。
     *
     * @param 特記 特記
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set特記(RString 特記) {
        requireNonNull(特記, UrSystemErrorMessages.値がnull.getReplacedMessage("特記"));
        entity.setTokki(特記);
        return this;
    }

    /**
     * 特記イメージ共有ファイルIDを設定します。
     *
     * @param 特記イメージ共有ファイルID 特記イメージ共有ファイルID
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set特記イメージ共有ファイルID(RDateTime 特記イメージ共有ファイルID) {
        requireNonNull(特記イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("特記イメージ共有ファイルID"));
        entity.setTokkiImageSharedFileId(特記イメージ共有ファイルID);
        return this;
    }

    /**
     * 認定調査特記事項受付年月日を設定します。
     *
     * @param 認定調査特記事項受付年月日 認定調査特記事項受付年月日
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査特記事項受付年月日(FlexibleDate 認定調査特記事項受付年月日) {
        requireNonNull(認定調査特記事項受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項受付年月日"));
        entity.setTokkijikoUketsukeYMD(認定調査特記事項受付年月日);
        return this;
    }

    /**
     * 認定調査特記事項受領年月日を設定します。
     *
     * @param 認定調査特記事項受領年月日 認定調査特記事項受領年月日
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public NinteichosahyoGaikyoChosaBuilder set認定調査特記事項受領年月日(FlexibleDate 認定調査特記事項受領年月日) {
        requireNonNull(認定調査特記事項受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項受領年月日"));
        entity.setTokkijikoJuryoYMD(認定調査特記事項受領年月日);
        return this;
    }

    /**
     * 認定調査票（概況特記）情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（概況特記）情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（概況特記）情報リストに認定調査票（概況特記）情報{@link GaikyoTokki}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_概況特記_情報 {@link GaikyoTokki}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setGaikyoTokki(GaikyoTokki 認定調査票_概況特記_情報) {
        if (hasSameIdentifier(認定調査票_概況特記_情報.identifier())) {
            gaikyoTokki.add(認定調査票_概況特記_情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(GaikyoTokkiIdentifier 認定調査票_概況特記_情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_概況特記_情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_概況特記_情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * 認定調査票（基本調査）情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（基本調査）情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（基本調査）情報リストに認定調査票（基本調査）情報{@link NinteichosahyoKihonChosa}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_基本調査_情報 {@link NinteichosahyoKihonChosa}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoKihonChosa(NinteichosahyoKihonChosa 認定調査票_基本調査_情報) {
        if (hasSameIdentifier(認定調査票_基本調査_情報.identifier())) {
            ninteichosahyoKihonChosa.add(認定調査票_基本調査_情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoKihonChosaIdentifier 認定調査票_基本調査_情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_基本調査_情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_基本調査_情報識別子.get要介護認定調査履歴番号());
    }

    /**
     * 認定調査票（概況調査）記入項目情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（概況調査）記入項目情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（概況調査）記入項目情報リストに認定調査票（概況調査）記入項目情報{@link NinteichosahyoKinyuItem}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_概況調査_記入項目情報 {@link NinteichosahyoKinyuItem}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoKinyuItem(NinteichosahyoKinyuItem 認定調査票_概況調査_記入項目情報) {
        if (hasSameIdentifier(認定調査票_概況調査_記入項目情報.identifier())) {
            ninteichosahyoKinyuItem.add(認定調査票_概況調査_記入項目情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoKinyuItemIdentifier 認定調査票_概況調査_記入項目情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_概況調査_記入項目情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_概況調査_記入項目情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * 認定調査票（概況調査）サービスの状況情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（概況調査）サービスの状況情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（概況調査）サービスの状況情報リストに認定調査票（概況調査）サービスの状況情報{@link NinteichosahyoServiceJokyo}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_概況調査_サービスの状況情報 {@link NinteichosahyoServiceJokyo}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoServiceJokyo(NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況情報) {
        if (hasSameIdentifier(認定調査票_概況調査_サービスの状況情報.identifier())) {
            ninteichosahyoServiceJokyo.add(認定調査票_概況調査_サービスの状況情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoServiceJokyoIdentifier 認定調査票_概況調査_サービスの状況情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_概況調査_サービスの状況情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_概況調査_サービスの状況情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * 認定調査票（概況調査）サービスの状況フラグ情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（概況調査）サービスの状況フラグ情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（概況調査）サービスの状況フラグ情報リストに認定調査票（概況調査）サービスの状況フラグ情報{@link NinteichosahyoServiceJokyoFlag}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_概況調査_サービスの状況フラグ情報 {@link NinteichosahyoServiceJokyoFlag}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ情報) {
        if (hasSameIdentifier(認定調査票_概況調査_サービスの状況フラグ情報.identifier())) {
            ninteichosahyoServiceJokyoFlag.add(認定調査票_概況調査_サービスの状況フラグ情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoServiceJokyoFlagIdentifier 認定調査票_概況調査_サービスの状況フラグ情報情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_概況調査_サービスの状況フラグ情報情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_概況調査_サービスの状況フラグ情報情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * 認定調査票（概況調査）施設利用情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（概況調査）施設利用情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（概況調査）施設利用情報リストに認定調査票（概況調査）施設利用情報{@link NinteichosahyoShisetsuRiyo}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_概況調査_施設利用情報 {@link NinteichosahyoShisetsuRiyo}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyo 認定調査票_概況調査_施設利用情報) {
        if (hasSameIdentifier(認定調査票_概況調査_施設利用情報.identifier())) {
            ninteichosahyoShisetsuRiyo.add(認定調査票_概況調査_施設利用情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoShisetsuRiyoIdentifier 認定調査票_概況調査_施設利用情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_概況調査_施設利用情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_概況調査_施設利用情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * 認定調査票（特記情報）情報のキー情報について判定します。<br>
     * 認定調査票（概況調査）情報に関連できる認定調査票（特記情報）情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は認定調査票（特記情報）情報リストに認定調査票（特記情報）情報{@link NinteichosahyoTokkijiko}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 認定調査票_特記情報 {@link NinteichosahyoTokkijiko}
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public NinteichosahyoGaikyoChosaBuilder setNinteichosahyoTokkijiko(NinteichosahyoTokkijiko 認定調査票_特記情報) {
        if (hasSameIdentifier(認定調査票_特記情報.identifier())) {
            ninteichosahyoTokkijiko.add(認定調査票_特記情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(NinteichosahyoTokkijikoIdentifier 認定調査票_特記情報識別子) {
        return (id.get申請書管理番号().equals(認定調査票_特記情報識別子.get申請書管理番号())
                && id.get認定調査依頼履歴番号() == 認定調査票_特記情報識別子.get認定調査依頼履歴番号());
    }

    /**
     * {@link NinteichosahyoGaikyoChosa}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoGaikyoChosa}のインスタンス
     */
    public NinteichosahyoGaikyoChosa build() {
        return new NinteichosahyoGaikyoChosa(entity, id, gaikyoTokki,
                ninteichosahyoKihonChosa, ninteichosahyoKinyuItem,
                ninteichosahyoServiceJokyo, ninteichosahyoServiceJokyoFlag,
                ninteichosahyoShisetsuRiyo, ninteichosahyoTokkijiko);
    }
}
