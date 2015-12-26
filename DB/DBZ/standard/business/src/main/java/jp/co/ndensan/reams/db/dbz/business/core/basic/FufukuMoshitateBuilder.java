/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FufukuMoshitate}の編集を行うビルダークラスです。
 */
public class FufukuMoshitateBuilder {

    private final DbT7001FufukuMoshitateEntity entity;
    private final FufukuMoshitateIdentifier id;

    /**
     * {@link DbT7001FufukuMoshitateEntity}より{@link FufukuMoshitate}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7001FufukuMoshitateEntity}
     * @param id {@link FufukuMoshitateIdentifier}
     *
     */
    FufukuMoshitateBuilder(
            DbT7001FufukuMoshitateEntity entity,
            FufukuMoshitateIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
       // entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 原処分被保険者番号を設定します。
     *
     * @param 原処分被保険者番号 原処分被保険者番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者番号(HihokenshaNo 原処分被保険者番号) {
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        entity.setGenshobunsHihokennshaNo(原処分被保険者番号);
        return this;
    }

    /**
     * 審査請求届出日を設定します。
     *
     * @param 審査請求届出日 審査請求届出日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求届出日(FlexibleDate 審査請求届出日) {
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        entity.setShinsaSeikyuTodokedeYMD(審査請求届出日);
        return this;
    }

    /**
     * 原処分被保険者郵便番号を設定します。
     *
     * @param 原処分被保険者郵便番号 原処分被保険者郵便番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者郵便番号(YubinNo 原処分被保険者郵便番号) {
        requireNonNull(原処分被保険者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者郵便番号"));
       // entity.setGenshobunHihokenshaYubinNo(原処分被保険者郵便番号);
        return this;
    }

    /**
     * 原処分被保険者住所を設定します。
     *
     * @param 原処分被保険者住所 原処分被保険者住所
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者住所(AtenaJusho 原処分被保険者住所) {
        requireNonNull(原処分被保険者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者住所"));
       // entity.setGenshobunHihokenshaJusho(原処分被保険者住所);
        return this;
    }

    /**
     * 原処分被保険者氏名を設定します。
     *
     * @param 原処分被保険者氏名 原処分被保険者氏名
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者氏名(AtenaMeisho 原処分被保険者氏名) {
        requireNonNull(原処分被保険者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者氏名"));
      //  entity.setGenshobunHihokenshaShimei(原処分被保険者氏名);
        return this;
    }

    /**
     * 原処分被保険者電話番号を設定します。
     *
     * @param 原処分被保険者電話番号 原処分被保険者電話番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者電話番号(TelNo 原処分被保険者電話番号) {
        requireNonNull(原処分被保険者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者電話番号"));
       // entity.setGenshobunHihokenshaTelNo(原処分被保険者電話番号);
        return this;
    }

    /**
     * 原処分被保険者生年月日を設定します。
     *
     * @param 原処分被保険者生年月日 原処分被保険者生年月日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set原処分被保険者生年月日(FlexibleDate 原処分被保険者生年月日) {
        requireNonNull(原処分被保険者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者生年月日"));
       // entity.setGenshobunHihokenshaBirthYMD(原処分被保険者生年月日);
        return this;
    }

    /**
     * 審査請求人郵便番号を設定します。
     *
     * @param 審査請求人郵便番号 審査請求人郵便番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求人郵便番号(YubinNo 審査請求人郵便番号) {
        requireNonNull(審査請求人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人郵便番号"));
        entity.setShinsaSeikyuninYubinNo(審査請求人郵便番号);
        return this;
    }

    /**
     * 審査請求人住所を設定します。
     *
     * @param 審査請求人住所 審査請求人住所
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求人住所(AtenaJusho 審査請求人住所) {
        requireNonNull(審査請求人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人住所"));
        entity.setShinsaSeikyuninJusho(審査請求人住所);
        return this;
    }

    /**
     * 審査請求人氏名を設定します。
     *
     * @param 審査請求人氏名 審査請求人氏名
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求人氏名(AtenaMeisho 審査請求人氏名) {
        requireNonNull(審査請求人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人氏名"));
        entity.setShinsaSeikyuninShimei(審査請求人氏名);
        return this;
    }

    /**
     * 審査請求人電話番号を設定します。
     *
     * @param 審査請求人電話番号 審査請求人電話番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求人電話番号(TelNo 審査請求人電話番号) {
        requireNonNull(審査請求人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求人電話番号"));
        entity.setShinsaSeikyuninTelNo(審査請求人電話番号);
        return this;
    }

    /**
     * 被保険者との関係コードを設定します。
     *
     * @param 被保険者との関係コード 被保険者との関係コード
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set被保険者との関係コード(Code 被保険者との関係コード) {
        requireNonNull(被保険者との関係コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者との関係コード"));
     //   entity.setHihokenshaTonoKankeiCode(被保険者との関係コード);
        return this;
    }

    /**
     * 代理人郵便番号を設定します。
     *
     * @param 代理人郵便番号 代理人郵便番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set代理人郵便番号(YubinNo 代理人郵便番号) {
        requireNonNull(代理人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人郵便番号"));
        entity.setDairininYubinNo(代理人郵便番号);
        return this;
    }

    /**
     * 代理人住所を設定します。
     *
     * @param 代理人住所 代理人住所
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set代理人住所(AtenaJusho 代理人住所) {
        requireNonNull(代理人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人住所"));
        entity.setDairininJusho(代理人住所);
        return this;
    }

    /**
     * 代理人氏名を設定します。
     *
     * @param 代理人氏名 代理人氏名
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set代理人氏名(AtenaMeisho 代理人氏名) {
        requireNonNull(代理人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人氏名"));
        entity.setDairininShimei(代理人氏名);
        return this;
    }

    /**
     * 代理人電話番号を設定します。
     *
     * @param 代理人電話番号 代理人電話番号
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set代理人電話番号(TelNo 代理人電話番号) {
        requireNonNull(代理人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("代理人電話番号"));
        entity.setDairininTelNo(代理人電話番号);
        return this;
    }

    /**
     * 処分庁を設定します。
     *
     * @param 処分庁 処分庁
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set処分庁(RString 処分庁) {
        requireNonNull(処分庁, UrSystemErrorMessages.値がnull.getReplacedMessage("処分庁"));
        entity.setShobunCho(処分庁);
        return this;
    }

    /**
     * 処分日を設定します。
     *
     * @param 処分日 処分日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set処分日(FlexibleDate 処分日) {
        requireNonNull(処分日, UrSystemErrorMessages.値がnull.getReplacedMessage("処分日"));
        entity.setShobunYMD(処分日);
        return this;
    }

    /**
     * 処分種類コードを設定します。
     *
     * @param 処分種類コード 処分種類コード
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set処分種類コード(Code 処分種類コード) {
        requireNonNull(処分種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("処分種類コード"));
       // entity.setShobunShuruiCode(処分種類コード);
        return this;
    }

    /**
     * 処分があったことを知った日を設定します。
     *
     * @param 処分があったことを知った日 処分があったことを知った日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set処分があったことを知った日(FlexibleDate 処分があったことを知った日) {
        requireNonNull(処分があったことを知った日, UrSystemErrorMessages.値がnull.getReplacedMessage("処分があったことを知った日"));
        entity.setShobunKakuninYMD(処分があったことを知った日);
        return this;
    }

    /**
     * 審査請求の理由を設定します。
     *
     * @param 審査請求の理由 審査請求の理由
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求の理由(RString 審査請求の理由) {
        requireNonNull(審査請求の理由, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求の理由"));
        entity.setShinsaSeikyuRiyu(審査請求の理由);
        return this;
    }

    /**
     * 処分庁教示の有無及び教示の内容を設定します。
     *
     * @param 処分庁教示の有無及び教示の内容 処分庁教示の有無及び教示の内容
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set処分庁教示の有無及び教示の内容(RString 処分庁教示の有無及び教示の内容) {
        requireNonNull(処分庁教示の有無及び教示の内容, UrSystemErrorMessages.値がnull.getReplacedMessage("処分庁教示の有無及び教示の内容"));
        entity.setShobunChoKyojiNaiyo(処分庁教示の有無及び教示の内容);
        return this;
    }

    /**
     * 添付書類等を設定します。
     *
     * @param 添付書類等 添付書類等
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set添付書類等(boolean 添付書類等) {
        requireNonNull(添付書類等, UrSystemErrorMessages.値がnull.getReplacedMessage("添付書類等"));
        entity.setTempuShoruiTo(添付書類等);
        return this;
    }

    /**
     * 審査請求取下日を設定します。
     *
     * @param 審査請求取下日 審査請求取下日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set審査請求取下日(FlexibleDate 審査請求取下日) {
        requireNonNull(審査請求取下日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求取下日"));
        entity.setShinsaSeikyuTorisageYMD(審査請求取下日);
        return this;
    }

    /**
     * 弁明書登録フラグを設定します。
     *
     * @param 弁明書登録フラグ 弁明書登録フラグ
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set弁明書登録フラグ(boolean 弁明書登録フラグ) {
        requireNonNull(弁明書登録フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書登録フラグ"));
        entity.setBemmeishoTorokuFlag(弁明書登録フラグ);
        return this;
    }

    /**
     * 弁明書作成日を設定します。
     *
     * @param 弁明書作成日 弁明書作成日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set弁明書作成日(FlexibleDate 弁明書作成日) {
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        entity.setBemmeishoSakuseiYMD(弁明書作成日);
        return this;
    }

    /**
     * 裁決日を設定します。
     *
     * @param 裁決日 裁決日
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set裁決日(FlexibleDate 裁決日) {
        requireNonNull(裁決日, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決日"));
        entity.setSaiketsuYMD(裁決日);
        return this;
    }

    /**
     * 裁決結果を設定します。
     *
     * @param 裁決結果 裁決結果
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set裁決結果(RString 裁決結果) {
        requireNonNull(裁決結果, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決結果"));
        entity.setSaiketsuKekka(裁決結果);
        return this;
    }

    /**
     * 裁決理由を設定します。
     *
     * @param 裁決理由 裁決理由
     * @return {@link FufukuMoshitateBuilder}
     */
    public FufukuMoshitateBuilder set裁決理由(RString 裁決理由) {
        requireNonNull(裁決理由, UrSystemErrorMessages.値がnull.getReplacedMessage("裁決理由"));
        entity.setSaiketsuRiyu(裁決理由);
        return this;
    }

    /**
     * {@link FufukuMoshitate}のインスタンスを生成します。
     *
     * @return {@link FufukuMoshitate}のインスタンス
     */
    public FufukuMoshitate build() {
        return new FufukuMoshitate(entity, id);
    }

    /**
     * setBemmeiNaiyo
     *
     * @param createBemmeiNaiyo BemmeiNaiyo
     * @return FufukuMoshitateBuilder
     */
    public FufukuMoshitateBuilder setBemmeiNaiyo(BemmeiNaiyo createBemmeiNaiyo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
