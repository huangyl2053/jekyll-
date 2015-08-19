/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiShoteiShikkanShisetsuRyoyo}の編集を行うビルダークラスです。
 */
public class KyufujissekiShoteiShikkanShisetsuRyoyoBuilder {

    private final DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity;
    private final KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id;

    /**
     * {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}より{@link KyufujissekiShoteiShikkanShisetsuRyoyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}
     * @param id {@link KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier}
     *
     */
    KyufujissekiShoteiShikkanShisetsuRyoyoBuilder(
            DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity,
            KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 緊急時施設療養情報レコード順次番号を設定します。
     *
     * @param 緊急時施設療養情報レコード順次番号 緊急時施設療養情報レコード順次番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時施設療養情報レコード順次番号(RString 緊急時施設療養情報レコード順次番号) {
        requireNonNull(緊急時施設療養情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養情報レコード順次番号"));
        entity.setRecodeJunjiNo(緊急時施設療養情報レコード順次番号);
        return this;
    }

    /**
     * 緊急時傷病名１を設定します。
     *
     * @param 緊急時傷病名１ 緊急時傷病名１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名１(RString 緊急時傷病名１) {
        requireNonNull(緊急時傷病名１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名１"));
        entity.setKinkyuShobyoName1(緊急時傷病名１);
        return this;
    }

    /**
     * 緊急時傷病名２を設定します。
     *
     * @param 緊急時傷病名２ 緊急時傷病名２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名２(RString 緊急時傷病名２) {
        requireNonNull(緊急時傷病名２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名２"));
        entity.setKinkyuShobyoName2(緊急時傷病名２);
        return this;
    }

    /**
     * 緊急時傷病名３を設定します。
     *
     * @param 緊急時傷病名３ 緊急時傷病名３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名３(RString 緊急時傷病名３) {
        requireNonNull(緊急時傷病名３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名３"));
        entity.setKinkyuShobyoName3(緊急時傷病名３);
        return this;
    }

    /**
     * 緊急時治療開始年月日１を設定します。
     *
     * @param 緊急時治療開始年月日１ 緊急時治療開始年月日１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日１(FlexibleDate 緊急時治療開始年月日１) {
        requireNonNull(緊急時治療開始年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日１"));
        entity.setKinkyuChiryoKaishiYMD1(緊急時治療開始年月日１);
        return this;
    }

    /**
     * 緊急時治療開始年月日２を設定します。
     *
     * @param 緊急時治療開始年月日２ 緊急時治療開始年月日２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日２(FlexibleDate 緊急時治療開始年月日２) {
        requireNonNull(緊急時治療開始年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日２"));
        entity.setKinkyuChiryoKaishiYMD2(緊急時治療開始年月日２);
        return this;
    }

    /**
     * 緊急時治療開始年月日３を設定します。
     *
     * @param 緊急時治療開始年月日３ 緊急時治療開始年月日３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日３(FlexibleDate 緊急時治療開始年月日３) {
        requireNonNull(緊急時治療開始年月日３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日３"));
        entity.setKinkyuChiryoKaishiYMD3(緊急時治療開始年月日３);
        return this;
    }

    /**
     * 往診日数を設定します。
     *
     * @param 往診日数 往診日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set往診日数(Decimal 往診日数) {
        requireNonNull(往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("往診日数"));
        entity.setOshinNissu(往診日数);
        return this;
    }

    /**
     * 往診医療機関名を設定します。
     *
     * @param 往診医療機関名 往診医療機関名
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set往診医療機関名(RString 往診医療機関名) {
        requireNonNull(往診医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("往診医療機関名"));
        entity.setOshinIryoKikanName(往診医療機関名);
        return this;
    }

    /**
     * 通院日数を設定します。
     *
     * @param 通院日数 通院日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set通院日数(Decimal 通院日数) {
        requireNonNull(通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("通院日数"));
        entity.setTsuinNissu(通院日数);
        return this;
    }

    /**
     * 通院医療機関名を設定します。
     *
     * @param 通院医療機関名 通院医療機関名
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set通院医療機関名(RString 通院医療機関名) {
        requireNonNull(通院医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("通院医療機関名"));
        entity.setTsuinIryoKikanName(通院医療機関名);
        return this;
    }

    /**
     * 緊急時治療管理単位数を設定します。
     *
     * @param 緊急時治療管理単位数 緊急時治療管理単位数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理単位数(int 緊急時治療管理単位数) {
        requireNonNull(緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理単位数"));
        entity.setKinkyuChiryoKanriTanisu(緊急時治療管理単位数);
        return this;
    }

    /**
     * 緊急時治療管理日数を設定します。
     *
     * @param 緊急時治療管理日数 緊急時治療管理日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理日数(Decimal 緊急時治療管理日数) {
        requireNonNull(緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理日数"));
        entity.setKinkyuChiryoKanriNissu(緊急時治療管理日数);
        return this;
    }

    /**
     * 緊急時治療管理小計を設定します。
     *
     * @param 緊急時治療管理小計 緊急時治療管理小計
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理小計(int 緊急時治療管理小計) {
        requireNonNull(緊急時治療管理小計, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理小計"));
        entity.setKinkyuChiryoKanriSubTotal(緊急時治療管理小計);
        return this;
    }

    /**
     * リハビリテーション点数を設定します。
     *
     * @param リハビリテーション点数 リハビリテーション点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder setリハビリテーション点数(int リハビリテーション点数) {
        requireNonNull(リハビリテーション点数, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション点数"));
        entity.setRehabilitationTensu(リハビリテーション点数);
        return this;
    }

    /**
     * 処置点数を設定します。
     *
     * @param 処置点数 処置点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set処置点数(int 処置点数) {
        requireNonNull(処置点数, UrSystemErrorMessages.値がnull.getReplacedMessage("処置点数"));
        entity.setShochiTensu(処置点数);
        return this;
    }

    /**
     * 手術点数を設定します。
     *
     * @param 手術点数 手術点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set手術点数(int 手術点数) {
        requireNonNull(手術点数, UrSystemErrorMessages.値がnull.getReplacedMessage("手術点数"));
        entity.setShujutsuTensu(手術点数);
        return this;
    }

    /**
     * 麻酔点数を設定します。
     *
     * @param 麻酔点数 麻酔点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set麻酔点数(int 麻酔点数) {
        requireNonNull(麻酔点数, UrSystemErrorMessages.値がnull.getReplacedMessage("麻酔点数"));
        entity.setMasuiTensu(麻酔点数);
        return this;
    }

    /**
     * 放射線治療点数を設定します。
     *
     * @param 放射線治療点数 放射線治療点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set放射線治療点数(int 放射線治療点数) {
        requireNonNull(放射線治療点数, UrSystemErrorMessages.値がnull.getReplacedMessage("放射線治療点数"));
        entity.setHoshasenChiryoTensu(放射線治療点数);
        return this;
    }

    /**
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１(RString 摘要１) {
        requireNonNull(摘要１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１"));
        entity.setTekiyo1(摘要１);
        return this;
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要２(RString 摘要２) {
        requireNonNull(摘要２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２"));
        entity.setTekiyo2(摘要２);
        return this;
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要３(RString 摘要３) {
        requireNonNull(摘要３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要３"));
        entity.setTekiyo3(摘要３);
        return this;
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要４(RString 摘要４) {
        requireNonNull(摘要４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要４"));
        entity.setTekiyo4(摘要４);
        return this;
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要５(RString 摘要５) {
        requireNonNull(摘要５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要５"));
        entity.setTekiyo5(摘要５);
        return this;
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要６(RString 摘要６) {
        requireNonNull(摘要６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要６"));
        entity.setTekiyo6(摘要６);
        return this;
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要７(RString 摘要７) {
        requireNonNull(摘要７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要７"));
        entity.setTekiyo7(摘要７);
        return this;
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要８(RString 摘要８) {
        requireNonNull(摘要８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要８"));
        entity.setTekiyo8(摘要８);
        return this;
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要９(RString 摘要９) {
        requireNonNull(摘要９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要９"));
        entity.setTekiyo9(摘要９);
        return this;
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１０(RString 摘要１０) {
        requireNonNull(摘要１０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１０"));
        entity.setTekiyo10(摘要１０);
        return this;
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１１(RString 摘要１１) {
        requireNonNull(摘要１１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１１"));
        entity.setTekiyo11(摘要１１);
        return this;
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１２(RString 摘要１２) {
        requireNonNull(摘要１２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１２"));
        entity.setTekiyo12(摘要１２);
        return this;
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１３(RString 摘要１３) {
        requireNonNull(摘要１３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１３"));
        entity.setTekiyo13(摘要１３);
        return this;
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１４(RString 摘要１４) {
        requireNonNull(摘要１４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１４"));
        entity.setTekiyo14(摘要１４);
        return this;
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１５(RString 摘要１５) {
        requireNonNull(摘要１５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１５"));
        entity.setTekiyo15(摘要１５);
        return this;
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１６(RString 摘要１６) {
        requireNonNull(摘要１６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１６"));
        entity.setTekiyo16(摘要１６);
        return this;
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１７(RString 摘要１７) {
        requireNonNull(摘要１７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１７"));
        entity.setTekiyo17(摘要１７);
        return this;
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１８(RString 摘要１８) {
        requireNonNull(摘要１８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１８"));
        entity.setTekiyo18(摘要１８);
        return this;
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要１９(RString 摘要１９) {
        requireNonNull(摘要１９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１９"));
        entity.setTekiyo19(摘要１９);
        return this;
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set摘要２０(RString 摘要２０) {
        requireNonNull(摘要２０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２０"));
        entity.setTekiyo20(摘要２０);
        return this;
    }

    /**
     * 緊急時施設療養費合計点数を設定します。
     *
     * @param 緊急時施設療養費合計点数 緊急時施設療養費合計点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set緊急時施設療養費合計点数(int 緊急時施設療養費合計点数) {
        requireNonNull(緊急時施設療養費合計点数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費合計点数"));
        entity.setKinkyuShisetsuRyoyohiTotalTensu(緊急時施設療養費合計点数);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名１を設定します。
     *
     * @param 所定疾患施設療養費傷病名１ 所定疾患施設療養費傷病名１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名１(RString 所定疾患施設療養費傷病名１) {
        requireNonNull(所定疾患施設療養費傷病名１, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名１"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName1(所定疾患施設療養費傷病名１);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名２を設定します。
     *
     * @param 所定疾患施設療養費傷病名２ 所定疾患施設療養費傷病名２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名２(RString 所定疾患施設療養費傷病名２) {
        requireNonNull(所定疾患施設療養費傷病名２, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名２"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName2(所定疾患施設療養費傷病名２);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名３を設定します。
     *
     * @param 所定疾患施設療養費傷病名３ 所定疾患施設療養費傷病名３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名３(RString 所定疾患施設療養費傷病名３) {
        requireNonNull(所定疾患施設療養費傷病名３, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名３"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName3(所定疾患施設療養費傷病名３);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日１を設定します。
     *
     * @param 所定疾患施設療養費開始年月日１ 所定疾患施設療養費開始年月日１
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日１(FlexibleDate 所定疾患施設療養費開始年月日１) {
        requireNonNull(所定疾患施設療養費開始年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日１"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD1(所定疾患施設療養費開始年月日１);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日２を設定します。
     *
     * @param 所定疾患施設療養費開始年月日２ 所定疾患施設療養費開始年月日２
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日２(FlexibleDate 所定疾患施設療養費開始年月日２) {
        requireNonNull(所定疾患施設療養費開始年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日２"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD2(所定疾患施設療養費開始年月日２);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日３を設定します。
     *
     * @param 所定疾患施設療養費開始年月日３ 所定疾患施設療養費開始年月日３
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日３(FlexibleDate 所定疾患施設療養費開始年月日３) {
        requireNonNull(所定疾患施設療養費開始年月日３, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日３"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD3(所定疾患施設療養費開始年月日３);
        return this;
    }

    /**
     * 所定疾患施設療養費単位数を設定します。
     *
     * @param 所定疾患施設療養費単位数 所定疾患施設療養費単位数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費単位数(int 所定疾患施設療養費単位数) {
        requireNonNull(所定疾患施設療養費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費単位数"));
        entity.setShoteiShikkanShisetsuRyoyohiTanisu(所定疾患施設療養費単位数);
        return this;
    }

    /**
     * 所定疾患施設療養費日数を設定します。
     *
     * @param 所定疾患施設療養費日数 所定疾患施設療養費日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費日数(Decimal 所定疾患施設療養費日数) {
        requireNonNull(所定疾患施設療養費日数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費日数"));
        entity.setShoteiShikkanShisetsuRyoyohiNissu(所定疾患施設療養費日数);
        return this;
    }

    /**
     * 所定疾患施設療養費小計を設定します。
     *
     * @param 所定疾患施設療養費小計 所定疾患施設療養費小計
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費小計(int 所定疾患施設療養費小計) {
        requireNonNull(所定疾患施設療養費小計, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費小計"));
        entity.setShoteiShikkanShisetsuRyoyohiSubTotal(所定疾患施設療養費小計);
        return this;
    }

    /**
     * 後_往診日数を設定します。
     *
     * @param 後_往診日数 後_往診日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_往診日数(Decimal 後_往診日数) {
        requireNonNull(後_往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_往診日数"));
        entity.setAtoOshinNissu(後_往診日数);
        return this;
    }

    /**
     * 後_通院日数を設定します。
     *
     * @param 後_通院日数 後_通院日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_通院日数(Decimal 後_通院日数) {
        requireNonNull(後_通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_通院日数"));
        entity.setAtoTsuinNissu(後_通院日数);
        return this;
    }

    /**
     * 後_緊急時治療管理単位数を設定します。
     *
     * @param 後_緊急時治療管理単位数 後_緊急時治療管理単位数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_緊急時治療管理単位数(int 後_緊急時治療管理単位数) {
        requireNonNull(後_緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_緊急時治療管理単位数"));
        entity.setAtoKinkyuChiryoKanriTanisu(後_緊急時治療管理単位数);
        return this;
    }

    /**
     * 後_緊急時治療管理日数を設定します。
     *
     * @param 後_緊急時治療管理日数 後_緊急時治療管理日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_緊急時治療管理日数(Decimal 後_緊急時治療管理日数) {
        requireNonNull(後_緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_緊急時治療管理日数"));
        entity.setAtoKinkyuChiryoKanriNissu(後_緊急時治療管理日数);
        return this;
    }

    /**
     * 後_リハビリテーション点数を設定します。
     *
     * @param 後_リハビリテーション点数 後_リハビリテーション点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_リハビリテーション点数(int 後_リハビリテーション点数) {
        requireNonNull(後_リハビリテーション点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_リハビリテーション点数"));
        entity.setAtoRehabilitationTensu(後_リハビリテーション点数);
        return this;
    }

    /**
     * 後_処置点数を設定します。
     *
     * @param 後_処置点数 後_処置点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_処置点数(int 後_処置点数) {
        requireNonNull(後_処置点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_処置点数"));
        entity.setAtoShochiTensu(後_処置点数);
        return this;
    }

    /**
     * 後_手術点数を設定します。
     *
     * @param 後_手術点数 後_手術点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_手術点数(int 後_手術点数) {
        requireNonNull(後_手術点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_手術点数"));
        entity.setAtoShujutsuTensu(後_手術点数);
        return this;
    }

    /**
     * 後_麻酔点数を設定します。
     *
     * @param 後_麻酔点数 後_麻酔点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_麻酔点数(int 後_麻酔点数) {
        requireNonNull(後_麻酔点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_麻酔点数"));
        entity.setAtoMasuiTensu(後_麻酔点数);
        return this;
    }

    /**
     * 後_放射線治療点数を設定します。
     *
     * @param 後_放射線治療点数 後_放射線治療点数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_放射線治療点数(int 後_放射線治療点数) {
        requireNonNull(後_放射線治療点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_放射線治療点数"));
        entity.setAtoHoshasenChiryoTensu(後_放射線治療点数);
        return this;
    }

    /**
     * 後_所定疾患施設療養費単位数を設定します。
     *
     * @param 後_所定疾患施設療養費単位数 後_所定疾患施設療養費単位数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_所定疾患施設療養費単位数(int 後_所定疾患施設療養費単位数) {
        requireNonNull(後_所定疾患施設療養費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_所定疾患施設療養費単位数"));
        entity.setAtoShoteiShikkanShisetsuRyoyoHiTanisu(後_所定疾患施設療養費単位数);
        return this;
    }

    /**
     * 後_所定疾患施設療養費日数を設定します。
     *
     * @param 後_所定疾患施設療養費日数 後_所定疾患施設療養費日数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set後_所定疾患施設療養費日数(Decimal 後_所定疾患施設療養費日数) {
        requireNonNull(後_所定疾患施設療養費日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_所定疾患施設療養費日数"));
        entity.setAtoShoteiShikkanShisetsuRyoyoHiNissu(後_所定疾患施設療養費日数);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyoBuilder}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiShoteiShikkanShisetsuRyoyo}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyo}のインスタンス
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyo build() {
        return new KyufujissekiShoteiShikkanShisetsuRyoyo(entity, id);
    }
}
