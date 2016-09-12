/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NenkinTokuchoKaifuJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBZ-9999-012 yangchenbing
 */
public class NenkinTokuchoKaifuJohoBuilder {

    private final UeT0511NenkinTokuchoKaifuJohoEntity entity;
    private final NenkinTokuchoKaifuJohoIdentifier id;

    /**
     * {@link UeT0511NenkinTokuchoKaifuJohoEntity}より{@link NenkinTokuchoKaifuJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UeT0511NenkinTokuchoKaifuJohoEntity}
     * @param id {@link NenkinTokuchoKaifuJohoIdentifier}
     *
     */
    NenkinTokuchoKaifuJohoBuilder(
            UeT0511NenkinTokuchoKaifuJohoEntity entity,
            NenkinTokuchoKaifuJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 業務コードを設定します。
     *
     * @param 業務コード 業務コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set業務コード(GyomuCode 業務コード) {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        entity.setGyomuCode(業務コード);
        return this;
    }

    /**
     * 処理年度を設定します。
     *
     * @param 処理年度 処理年度
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set処理年度(FlexibleYear 処理年度) {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        entity.setShoriNendo(処理年度);
        return this;
    }

    /**
     * 通知内容コードを設定します。
     *
     * @param 通知内容コード 通知内容コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set通知内容コード(RString 通知内容コード) {
        requireNonNull(通知内容コード, UrSystemErrorMessages.値がnull.getReplacedMessage("通知内容コード"));
        entity.setTsuchiNaiyoCode(通知内容コード);
        return this;
    }

    /**
     * 処理対象年月を設定します。
     *
     * @param 処理対象年月 処理対象年月
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set処理対象年月(FlexibleYearMonth 処理対象年月) {
        requireNonNull(処理対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理対象年月"));
        entity.setShoriTaishoYM(処理対象年月);
        return this;
    }

    /**
     * 基礎年金番号を設定します。
     *
     * @param 基礎年金番号 基礎年金番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set基礎年金番号(RString 基礎年金番号) {
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        entity.setKisoNenkinNo(基礎年金番号);
        return this;
    }

    /**
     * 年金コードを設定します。
     *
     * @param 年金コード 年金コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set年金コード(RString 年金コード) {
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        entity.setNenkinCode(年金コード);
        return this;
    }

    /**
     * 構成市町村コードを設定します。
     *
     * @param 構成市町村コード 構成市町村コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set構成市町村コード(RString 構成市町村コード) {
        requireNonNull(構成市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村コード"));
        entity.setKoseiCityCode(構成市町村コード);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
        return this;
    }

    /**
     * 連携種別を設定します。
     *
     * @param 連携種別 連携種別
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set連携種別(RString 連携種別) {
        requireNonNull(連携種別, UrSystemErrorMessages.値がnull.getReplacedMessage("連携種別"));
        entity.setRenkeiShubetsu(連携種別);
        return this;
    }

    /**
     * 捕捉月を設定します。
     *
     * @param 捕捉月 捕捉月
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set捕捉月(RString 捕捉月) {
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("捕捉月"));
        entity.setHosokuTsuki(捕捉月);
        return this;
    }

    /**
     * 天引月を設定します。
     *
     * @param 天引月 天引月
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set天引月(RString 天引月) {
        requireNonNull(天引月, UrSystemErrorMessages.値がnull.getReplacedMessage("天引月"));
        entity.setTenbikiTsuki(天引月);
        return this;
    }

    /**
     * dT市町村コードを設定します。
     *
     * @param dT市町村コード dT市町村コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT市町村コード(RString dT市町村コード) {
        requireNonNull(dT市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT市町村コード"));
        entity.setDtCityCode(dT市町村コード);
        return this;
    }

    /**
     * dT特別徴収義務者コードを設定します。
     *
     * @param dT特別徴収義務者コード dT特別徴収義務者コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT特別徴収義務者コード(Code dT特別徴収義務者コード) {
        requireNonNull(dT特別徴収義務者コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT特別徴収義務者コード"));
        entity.setDtTokubetsuChoshuGimushaCode(dT特別徴収義務者コード);
        return this;
    }

    /**
     * dT通知内容コードを設定します。
     *
     * @param dT通知内容コード dT通知内容コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT通知内容コード(RString dT通知内容コード) {
        requireNonNull(dT通知内容コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT通知内容コード"));
        entity.setDtTsuchiNaiyoCode(dT通知内容コード);
        return this;
    }

    /**
     * dT媒体コードを設定します。
     *
     * @param dT媒体コード dT媒体コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT媒体コード(RString dT媒体コード) {
        requireNonNull(dT媒体コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT媒体コード"));
        entity.setDtBaitaiCode(dT媒体コード);
        return this;
    }

    /**
     * dT特別徴収制度コードを設定します。
     *
     * @param dT特別徴収制度コード dT特別徴収制度コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT特別徴収制度コード(RString dT特別徴収制度コード) {
        requireNonNull(dT特別徴収制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT特別徴収制度コード"));
        entity.setDtTokubetsuChoshuSeidoCode(dT特別徴収制度コード);
        return this;
    }

    /**
     * dT作成年月日を設定します。
     *
     * @param dT作成年月日 dT作成年月日
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT作成年月日(RString dT作成年月日) {
        requireNonNull(dT作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("DT作成年月日"));
        entity.setDtSakuseiYMD(dT作成年月日);
        return this;
    }

    /**
     * dT基礎年金番号を設定します。
     *
     * @param dT基礎年金番号 dT基礎年金番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT基礎年金番号(RString dT基礎年金番号) {
        requireNonNull(dT基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("DT基礎年金番号"));
        entity.setDtKisoNenkinNo(dT基礎年金番号);
        return this;
    }

    /**
     * dT年金コードを設定します。
     *
     * @param dT年金コード dT年金コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT年金コード(RString dT年金コード) {
        requireNonNull(dT年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT年金コード"));
        entity.setDtNenkinCode(dT年金コード);
        return this;
    }

    /**
     * dT予備１を設定します。
     *
     * @param dT予備１ dT予備１
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT予備１(RString dT予備１) {
        requireNonNull(dT予備１, UrSystemErrorMessages.値がnull.getReplacedMessage("DT予備１"));
        entity.setDtYobi1(dT予備１);
        return this;
    }

    /**
     * dT生年月日を設定します。
     *
     * @param dT生年月日 dT生年月日
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT生年月日(RString dT生年月日) {
        requireNonNull(dT生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("DT生年月日"));
        entity.setDtBirthDay(dT生年月日);
        return this;
    }

    /**
     * dT性別を設定します。
     *
     * @param dT性別 dT性別
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT性別(RString dT性別) {
        requireNonNull(dT性別, UrSystemErrorMessages.値がnull.getReplacedMessage("DT性別"));
        entity.setDtSeibetsu(dT性別);
        return this;
    }

    /**
     * dTカナ氏名を設定します。
     *
     * @param dTカナ氏名 dTカナ氏名
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTカナ氏名(RString dTカナ氏名) {
        requireNonNull(dTカナ氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("DTカナ氏名"));
        entity.setDtKanaShimei(dTカナ氏名);
        return this;
    }

    /**
     * dTシフトコード１を設定します。
     *
     * @param dTシフトコード１ dTシフトコード１
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTシフトコード１(RString dTシフトコード１) {
        requireNonNull(dTシフトコード１, UrSystemErrorMessages.値がnull.getReplacedMessage("DTシフトコード１"));
        entity.setDtShiftCode1(dTシフトコード１);
        return this;
    }

    /**
     * dT漢字氏名を設定します。
     *
     * @param dT漢字氏名 dT漢字氏名
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT漢字氏名(RString dT漢字氏名) {
        requireNonNull(dT漢字氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("DT漢字氏名"));
        entity.setDtKanjiShimei(dT漢字氏名);
        return this;
    }

    /**
     * dTシフトコード２を設定します。
     *
     * @param dTシフトコード２ dTシフトコード２
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTシフトコード２(RString dTシフトコード２) {
        requireNonNull(dTシフトコード２, UrSystemErrorMessages.値がnull.getReplacedMessage("DTシフトコード２"));
        entity.setDtShiftCode2(dTシフトコード２);
        return this;
    }

    /**
     * dT郵便番号を設定します。
     *
     * @param dT郵便番号 dT郵便番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT郵便番号(RString dT郵便番号) {
        requireNonNull(dT郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("DT郵便番号"));
        entity.setDtYubinNo(dT郵便番号);
        return this;
    }

    /**
     * dTカナ住所を設定します。
     *
     * @param dTカナ住所 dTカナ住所
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTカナ住所(RString dTカナ住所) {
        requireNonNull(dTカナ住所, UrSystemErrorMessages.値がnull.getReplacedMessage("DTカナ住所"));
        entity.setDtKanaJusho(dTカナ住所);
        return this;
    }

    /**
     * dTシフトコード３を設定します。
     *
     * @param dTシフトコード３ dTシフトコード３
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTシフトコード３(RString dTシフトコード３) {
        requireNonNull(dTシフトコード３, UrSystemErrorMessages.値がnull.getReplacedMessage("DTシフトコード３"));
        entity.setDtShiftCode3(dTシフトコード３);
        return this;
    }

    /**
     * dT漢字住所を設定します。
     *
     * @param dT漢字住所 dT漢字住所
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT漢字住所(RString dT漢字住所) {
        requireNonNull(dT漢字住所, UrSystemErrorMessages.値がnull.getReplacedMessage("DT漢字住所"));
        entity.setDtKanjiJusho(dT漢字住所);
        return this;
    }

    /**
     * dTシフトコード４を設定します。
     *
     * @param dTシフトコード４ dTシフトコード４
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdTシフトコード４(RString dTシフトコード４) {
        requireNonNull(dTシフトコード４, UrSystemErrorMessages.値がnull.getReplacedMessage("DTシフトコード４"));
        entity.setDtShiftCode4(dTシフトコード４);
        return this;
    }

    /**
     * dT各種区分を設定します。
     *
     * @param dT各種区分 dT各種区分
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種区分(RString dT各種区分) {
        requireNonNull(dT各種区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種区分"));
        entity.setDtKakushuKubun(dT各種区分);
        return this;
    }

    /**
     * dT処理結果を設定します。
     *
     * @param dT処理結果 dT処理結果
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT処理結果(RString dT処理結果) {
        requireNonNull(dT処理結果, UrSystemErrorMessages.値がnull.getReplacedMessage("DT処理結果"));
        entity.setDtShoriKekka(dT処理結果);
        return this;
    }

    /**
     * dT後期移管コードを設定します。
     *
     * @param dT後期移管コード dT後期移管コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT後期移管コード(RString dT後期移管コード) {
        requireNonNull(dT後期移管コード, UrSystemErrorMessages.値がnull.getReplacedMessage("DT後期移管コード"));
        entity.setDtKokiIkanCode(dT後期移管コード);
        return this;
    }

    /**
     * dT各種年月日を設定します。
     *
     * @param dT各種年月日 dT各種年月日
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種年月日(RString dT各種年月日) {
        requireNonNull(dT各種年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種年月日"));
        entity.setDtKakushuYMD(dT各種年月日);
        return this;
    }

    /**
     * dT各種金額欄１を設定します。
     *
     * @param dT各種金額欄１ dT各種金額欄１
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄１(RString dT各種金額欄１) {
        requireNonNull(dT各種金額欄１, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄１"));
        entity.setDtKakushuKingaku1(dT各種金額欄１);
        return this;
    }

    /**
     * dT各種金額欄２を設定します。
     *
     * @param dT各種金額欄２ dT各種金額欄２
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄２(RString dT各種金額欄２) {
        requireNonNull(dT各種金額欄２, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄２"));
        entity.setDtKakushuKingaku2(dT各種金額欄２);
        return this;
    }

    /**
     * dT各種金額欄３を設定します。
     *
     * @param dT各種金額欄３ dT各種金額欄３
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄３(RString dT各種金額欄３) {
        requireNonNull(dT各種金額欄３, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄３"));
        entity.setDtKakushuKingaku3(dT各種金額欄３);
        return this;
    }

    /**
     * dT予備２を設定します。
     *
     * @param dT予備２ dT予備２
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT予備２(RString dT予備２) {
        requireNonNull(dT予備２, UrSystemErrorMessages.値がnull.getReplacedMessage("DT予備２"));
        entity.setDtYobi2(dT予備２);
        return this;
    }

    /**
     * dT共済年金証書記号番号を設定します。
     *
     * @param dT共済年金証書記号番号 dT共済年金証書記号番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT共済年金証書記号番号(RString dT共済年金証書記号番号) {
        requireNonNull(dT共済年金証書記号番号, UrSystemErrorMessages.値がnull.getReplacedMessage("DT共済年金証書記号番号"));
        entity.setDtKyosaiNenkinshoshoKigoNo(dT共済年金証書記号番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set被保険者番号(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 国保世帯コードを設定します。
     *
     * @param 国保世帯コード 国保世帯コード
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set国保世帯コード(SetaiCode 国保世帯コード) {
        requireNonNull(国保世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("国保世帯コード"));
        entity.setKokuhoSetaiCode(国保世帯コード);
        return this;
    }

    /**
     * dT各種金額欄４を設定します。
     *
     * @param dT各種金額欄４ dT各種金額欄４
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄４(RString dT各種金額欄４) {
        requireNonNull(dT各種金額欄４, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄４"));
        entity.setDtKakushuKingaku4(dT各種金額欄４);
        return this;
    }

    /**
     * dT各種金額欄５を設定します。
     *
     * @param dT各種金額欄５ dT各種金額欄５
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄５(RString dT各種金額欄５) {
        requireNonNull(dT各種金額欄５, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄５"));
        entity.setDtKakushuKingaku5(dT各種金額欄５);
        return this;
    }

    /**
     * dT各種金額欄６を設定します。
     *
     * @param dT各種金額欄６ dT各種金額欄６
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄６(RString dT各種金額欄６) {
        requireNonNull(dT各種金額欄６, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄６"));
        entity.setDtKakushuKingaku6(dT各種金額欄６);
        return this;
    }

    /**
     * dT各種金額欄７を設定します。
     *
     * @param dT各種金額欄７ dT各種金額欄７
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄７(RString dT各種金額欄７) {
        requireNonNull(dT各種金額欄７, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄７"));
        entity.setDtKakushuKingaku7(dT各種金額欄７);
        return this;
    }

    /**
     * dT各種金額欄８を設定します。
     *
     * @param dT各種金額欄８ dT各種金額欄８
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT各種金額欄８(RString dT各種金額欄８) {
        requireNonNull(dT各種金額欄８, UrSystemErrorMessages.値がnull.getReplacedMessage("DT各種金額欄８"));
        entity.setDtKakushuKingaku8(dT各種金額欄８);
        return this;
    }

    /**
     * dT停止年月を設定します。
     *
     * @param dT停止年月 dT停止年月
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT停止年月(RString dT停止年月) {
        requireNonNull(dT停止年月, UrSystemErrorMessages.値がnull.getReplacedMessage("DT停止年月"));
        entity.setDtTeishiYM(dT停止年月);
        return this;
    }

    /**
     * dT予備４住民税を設定します。
     *
     * @param dT予備４住民税 dT予備４住民税
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT予備４住民税(RString dT予備４住民税) {
        requireNonNull(dT予備４住民税, UrSystemErrorMessages.値がnull.getReplacedMessage("DT予備４住民税"));
        entity.setDtYobi4Juminzei(dT予備４住民税);
        return this;
    }

    /**
     * dT個人番号を設定します。
     *
     * @param dT個人番号 dT個人番号
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder setdT個人番号(RString dT個人番号) {
        requireNonNull(dT個人番号, UrSystemErrorMessages.値がnull.getReplacedMessage("DT個人番号"));
        entity.setDtKojinNo(dT個人番号);
        return this;
    }

    /**
     * 国保予定喪失区分を設定します。
     *
     * @param 国保予定喪失区分 国保予定喪失区分
     * @return {@link NenkinTokuchoKaifuJohoBuilder}
     */
    public NenkinTokuchoKaifuJohoBuilder set国保予定喪失区分(RString 国保予定喪失区分) {
        requireNonNull(国保予定喪失区分, UrSystemErrorMessages.値がnull.getReplacedMessage("国保予定喪失区分"));
        entity.setKokuhoYoteiSoshitsuKubun(国保予定喪失区分);
        return this;
    }

    /**
     * {@link NenkinTokuchoKaifuJoho}のインスタンスを生成します。
     *
     * @return {@link NenkinTokuchoKaifuJoho}のインスタンス
     */
    public NenkinTokuchoKaifuJoho build() {
        return new NenkinTokuchoKaifuJoho(entity, id);
    }
}
