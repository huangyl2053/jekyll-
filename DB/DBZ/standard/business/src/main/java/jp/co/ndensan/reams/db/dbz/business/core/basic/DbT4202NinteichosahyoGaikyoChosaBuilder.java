/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link DbT4202NinteichosahyoGaikyoChosa}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
public class DbT4202NinteichosahyoGaikyoChosaBuilder {

    private final DbT4202NinteichosahyoGaikyoChosaEntity entity;
    private final DbT4202NinteichosahyoGaikyoChosaIdentifier id;

    /**
     * {@link DbT4202NinteichosahyoGaikyoChosaEntity}より{@link DbT4202NinteichosahyoGaikyoChosa}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4202NinteichosahyoGaikyoChosaEntity}
     * @param id {@link DbT4202NinteichosahyoGaikyoChosaIdentifier}
     *
     */
    DbT4202NinteichosahyoGaikyoChosaBuilder(
            DbT4202NinteichosahyoGaikyoChosaEntity entity,
            DbT4202NinteichosahyoGaikyoChosaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 認定調査依頼区分コードを設定します。
     *
     * @param 認定調査依頼区分コード 認定調査依頼区分コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査依頼区分コード(Code 認定調査依頼区分コード) {
        requireNonNull(認定調査依頼区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼区分コード"));
        entity.setNinteichousaIraiKubunCode(認定調査依頼区分コード);
        return this;
    }

    /**
     * 認定調査回数を設定します。
     *
     * @param 認定調査回数 認定調査回数
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査回数(int 認定調査回数) {
        requireNonNull(認定調査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査回数"));
        entity.setNinteichosaIraiKaisu(認定調査回数);
        return this;
    }

    /**
     * 認定調査実施年月日を設定します。
     *
     * @param 認定調査実施年月日 認定調査実施年月日
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査実施年月日(FlexibleDate 認定調査実施年月日) {
        requireNonNull(認定調査実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施年月日"));
        entity.setNinteichosaJisshiYMD(認定調査実施年月日);
        return this;
    }

    /**
     * 認定調査受領年月日を設定します。
     *
     * @param 認定調査受領年月日 認定調査受領年月日
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査受領年月日(FlexibleDate 認定調査受領年月日) {
        requireNonNull(認定調査受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査受領年月日"));
        entity.setNinteichosaJuryoYMD(認定調査受領年月日);
        return this;
    }

    /**
     * 認定調査区分コードを設定します。
     *
     * @param 認定調査区分コード 認定調査区分コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査区分コード(Code 認定調査区分コード) {
        requireNonNull(認定調査区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査区分コード"));
        entity.setNinteiChosaKubunCode(認定調査区分コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査委託先コード(JigyoshaNo 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setChosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setChosainCode(認定調査員コード);
        return this;
    }

    /**
     * 認定調査実施場所コードを設定します。
     *
     * @param 認定調査実施場所コード 認定調査実施場所コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査実施場所コード(Code 認定調査実施場所コード) {
        requireNonNull(認定調査実施場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施場所コード"));
        entity.setChosaJisshiBashoCode(認定調査実施場所コード);
        return this;
    }

    /**
     * 認定調査実施場所名称を設定します。
     *
     * @param 認定調査実施場所名称 認定調査実施場所名称
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査実施場所名称(RString 認定調査実施場所名称) {
        requireNonNull(認定調査実施場所名称, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査実施場所名称"));
        entity.setChosaJisshiBashoMeisho(認定調査実施場所名称);
        return this;
    }

    /**
     * 認定調査_サービス区分コードを設定します。
     *
     * @param 認定調査_サービス区分コード 認定調査_サービス区分コード
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査_サービス区分コード(Code 認定調査_サービス区分コード) {
        requireNonNull(認定調査_サービス区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査・サービス区分コード"));
        entity.setServiceKubunCode(認定調査_サービス区分コード);
        return this;
    }

    /**
     * 利用施設名を設定します。
     *
     * @param 利用施設名 利用施設名
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set利用施設名(RString 利用施設名) {
        requireNonNull(利用施設名, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設名"));
        entity.setRiyoShisetsuShimei(利用施設名);
        return this;
    }

    /**
     * 利用施設住所を設定します。
     *
     * @param 利用施設住所 利用施設住所
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set利用施設住所(RString 利用施設住所) {
        requireNonNull(利用施設住所, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設住所"));
        entity.setRiyoShisetsuJusho(利用施設住所);
        return this;
    }

    /**
     * 利用施設電話番号を設定します。
     *
     * @param 利用施設電話番号 利用施設電話番号
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set利用施設電話番号(RString 利用施設電話番号) {
        requireNonNull(利用施設電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設電話番号"));
        entity.setRiyoShisetsuTelNo(利用施設電話番号);
        return this;
    }

    /**
     * 利用施設郵便番号を設定します。
     *
     * @param 利用施設郵便番号 利用施設郵便番号
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set利用施設郵便番号(YubinNo 利用施設郵便番号) {
        requireNonNull(利用施設郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("利用施設郵便番号"));
        entity.setRiyoShisetsuYubinNo(利用施設郵便番号);
        return this;
    }

    /**
     * 特記を設定します。
     *
     * @param 特記 特記
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set特記(RString 特記) {
        requireNonNull(特記, UrSystemErrorMessages.値がnull.getReplacedMessage("特記"));
        entity.setTokki(特記);
        return this;
    }

    /**
     * 認定調査特記事項受付年月日を設定します。
     *
     * @param 認定調査特記事項受付年月日 認定調査特記事項受付年月日
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査特記事項受付年月日(FlexibleDate 認定調査特記事項受付年月日) {
        requireNonNull(認定調査特記事項受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項受付年月日"));
        entity.setTokkijikoUketsukeYMD(認定調査特記事項受付年月日);
        return this;
    }

    /**
     * 認定調査特記事項受領年月日を設定します。
     *
     * @param 認定調査特記事項受領年月日 認定調査特記事項受領年月日
     * @return {@link DbT4202NinteichosahyoGaikyoChosaBuilder}
     */
    public DbT4202NinteichosahyoGaikyoChosaBuilder set認定調査特記事項受領年月日(FlexibleDate 認定調査特記事項受領年月日) {
        requireNonNull(認定調査特記事項受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項受領年月日"));
        entity.setTokkijikoJuryoYMD(認定調査特記事項受領年月日);
        return this;
    }

    /**
     * {@link DbT4202NinteichosahyoGaikyoChosa}のインスタンスを生成します。
     *
     * @return {@link DbT4202NinteichosahyoGaikyoChosa}のインスタンス
     */
    public DbT4202NinteichosahyoGaikyoChosa build() {
        return new DbT4202NinteichosahyoGaikyoChosa(entity, id);
    }
}
