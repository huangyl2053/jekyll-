/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 市町村特別給付・サービス事業者の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class TokubetsuKyufuJigyoshaSearchBuilder {

    private final TokubetsuKyufuJigyoshaSearchEntity entity;
    private final TokubetsuKyufuJigyoshaSearchIdentifier id;

    /**
     * {@link TokubetsuKyufuJigyoshaSearchEntity}より{@link TokubetsuKyufuJigyoshaSearchBusiness}の編集用Builderクラスを生成します。
     *
     * @param entity.get事業者 {@link TokubetsuKyufuJigyoshaSearchEntity}
     * @param id {@link TokubetsuKyufuJigyoshaSearchIdentifier}
     *
     */
    TokubetsuKyufuJigyoshaSearchBuilder(
            TokubetsuKyufuJigyoshaSearchEntity entity,
            TokubetsuKyufuJigyoshaSearchIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 市町村特別給付用事業者番号を設定します。
     *
     * @param 市町村特別給付用事業者番号 市町村特別給付用事業者番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set市町村特別給付用事業者番号(JigyoshaNo 市町村特別給付用事業者番号) {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        entity.get事業者().setJigyoshaNo(市町村特別給付用事業者番号);
        return this;
    }

    /**
     * 市町村特別給付用サービスコードを設定します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set市町村特別給付用サービスコード(ServiceCode 市町村特別給付用サービスコード) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        entity.get事業者().setServiceCode(市町村特別給付用サービスコード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.get事業者().setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 介護国保連ＩＦ異動区分を設定します。
     *
     * @param 介護国保連ＩＦ異動区分 介護国保連ＩＦ異動区分
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set介護国保連ＩＦ異動区分(RString 介護国保連ＩＦ異動区分) {
        requireNonNull(介護国保連ＩＦ異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動区分"));
        entity.get事業者().setIdoKubun(介護国保連ＩＦ異動区分);
        return this;
    }

    /**
     * 介護国保連ＩＦ異動年月日を設定します。
     *
     * @param 介護国保連ＩＦ異動年月日 介護国保連ＩＦ異動年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set介護国保連ＩＦ異動年月日(FlexibleDate 介護国保連ＩＦ異動年月日) {
        requireNonNull(介護国保連ＩＦ異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動年月日"));
        entity.get事業者().setIdoYMD(介護国保連ＩＦ異動年月日);
        return this;
    }

    /**
     * 介護国保連ＩＦ法人種別を設定します。
     *
     * @param 介護国保連ＩＦ法人種別 介護国保連ＩＦ法人種別
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set介護国保連ＩＦ法人種別(RString 介護国保連ＩＦ法人種別) {
        requireNonNull(介護国保連ＩＦ法人種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ法人種別"));
        entity.get事業者().setHojinShubetsu(介護国保連ＩＦ法人種別);
        return this;
    }

    /**
     * 申請者氏名_漢字を設定します。
     *
     * @param 申請者氏名_漢字 申請者氏名_漢字
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者氏名_漢字(RString 申請者氏名_漢字) {
        requireNonNull(申請者氏名_漢字, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_漢字"));
        entity.get事業者().setShinseishaNameKanji(申請者氏名_漢字);
        return this;
    }

    /**
     * 申請者氏名_カナを設定します。
     *
     * @param 申請者氏名_カナ 申請者氏名_カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者氏名_カナ(RString 申請者氏名_カナ) {
        requireNonNull(申請者氏名_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_カナ"));
        entity.get事業者().setShinseishaNameKana(申請者氏名_カナ);
        return this;
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.get事業者().setShinseishaYubinNo(申請者郵便番号);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.get事業者().setShinseishaAddressKanji(申請者住所);
        return this;
    }

    /**
     * 申請者住所_カナを設定します。
     *
     * @param 申請者住所_カナ 申請者住所_カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者住所_カナ(RString 申請者住所_カナ) {
        requireNonNull(申請者住所_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所_カナ"));
        entity.get事業者().setShinseishaAddressKana(申請者住所_カナ);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者電話番号(RString 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.get事業者().setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請者FAX番号を設定します。
     *
     * @param 申請者FAX番号 申請者FAX番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set申請者FAX番号(RString 申請者FAX番号) {
        requireNonNull(申請者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者FAX番号"));
        entity.get事業者().setShinseishaFaxNo(申請者FAX番号);
        return this;
    }

    /**
     * 事業所代表者役職を設定します。
     *
     * @param 事業所代表者役職 事業所代表者役職
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者役職(RString 事業所代表者役職) {
        requireNonNull(事業所代表者役職, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者役職"));
        entity.get事業者().setJigyoshoDaihyoshaYakushoku(事業所代表者役職);
        return this;
    }

    /**
     * 事業所代表者氏名を設定します。
     *
     * @param 事業所代表者氏名 事業所代表者氏名
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者氏名(RString 事業所代表者氏名) {
        requireNonNull(事業所代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名"));
        entity.get事業者().setJigyoshoDaihyoshaNameKanji(事業所代表者氏名);
        return this;
    }

    /**
     * 事業所代表者氏名カナを設定します。
     *
     * @param 事業所代表者氏名カナ 事業所代表者氏名カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者氏名カナ(RString 事業所代表者氏名カナ) {
        requireNonNull(事業所代表者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名カナ"));
        entity.get事業者().setJigyoshoDaihyoshaNameKana(事業所代表者氏名カナ);
        return this;
    }

    /**
     * 事業所代表者郵便番号を設定します。
     *
     * @param 事業所代表者郵便番号 事業所代表者郵便番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者郵便番号(YubinNo 事業所代表者郵便番号) {
        requireNonNull(事業所代表者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者郵便番号"));
        entity.get事業者().setJigyoshoDaihyoshaYubinNo(事業所代表者郵便番号);
        return this;
    }

    /**
     * 事業所代表者住所を設定します。
     *
     * @param 事業所代表者住所 事業所代表者住所
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者住所(RString 事業所代表者住所) {
        requireNonNull(事業所代表者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所"));
        entity.get事業者().setJigyoshoDaihyoshaAddressKanji(事業所代表者住所);
        return this;
    }

    /**
     * 事業所代表者住所カナを設定します。
     *
     * @param 事業所代表者住所カナ 事業所代表者住所カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所代表者住所カナ(RString 事業所代表者住所カナ) {
        requireNonNull(事業所代表者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所カナ"));
        entity.get事業者().setJigyoshoDaihyoshaAddressKana(事業所代表者住所カナ);
        return this;
    }

    /**
     * 事業所管理者氏名を設定します。
     *
     * @param 事業所管理者氏名 事業所管理者氏名
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所管理者氏名(RString 事業所管理者氏名) {
        requireNonNull(事業所管理者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名"));
        entity.get事業者().setJigyoshoKanrishaNameKanji(事業所管理者氏名);
        return this;
    }

    /**
     * 事業所管理者氏名カナを設定します。
     *
     * @param 事業所管理者氏名カナ 事業所管理者氏名カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所管理者氏名カナ(RString 事業所管理者氏名カナ) {
        requireNonNull(事業所管理者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名カナ"));
        entity.get事業者().setJigyoshoKanrishaNameKana(事業所管理者氏名カナ);
        return this;
    }

    /**
     * 事業所管理者郵便番号を設定します。
     *
     * @param 事業所管理者郵便番号 事業所管理者郵便番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所管理者郵便番号(YubinNo 事業所管理者郵便番号) {
        requireNonNull(事業所管理者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者郵便番号"));
        entity.get事業者().setJigyoshoKanrishaYubinNo(事業所管理者郵便番号);
        return this;
    }

    /**
     * 事業所管理者住所を設定します。
     *
     * @param 事業所管理者住所 事業所管理者住所
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所管理者住所(RString 事業所管理者住所) {
        requireNonNull(事業所管理者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所"));
        entity.get事業者().setJigyoshoKanrishaAddressKanji(事業所管理者住所);
        return this;
    }

    /**
     * 事業所管理者住所カナを設定します。
     *
     * @param 事業所管理者住所カナ 事業所管理者住所カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set事業所管理者住所カナ(RString 事業所管理者住所カナ) {
        requireNonNull(事業所管理者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所カナ"));
        entity.get事業者().setJigyoshoKanrishaAddressKana(事業所管理者住所カナ);
        return this;
    }

    /**
     * サービス事業所名を設定します。
     *
     * @param サービス事業所名 サービス事業所名
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所名(RString サービス事業所名) {
        requireNonNull(サービス事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名"));
        entity.get事業者().setServiceJigyoshoNameKanji(サービス事業所名);
        return this;
    }

    /**
     * サービス事業所名カナを設定します。
     *
     * @param サービス事業所名カナ サービス事業所名カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所名カナ(RString サービス事業所名カナ) {
        requireNonNull(サービス事業所名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名カナ"));
        entity.get事業者().setServiceJigyoshoNameKana(サービス事業所名カナ);
        return this;
    }

    /**
     * サービス事業所郵便番号を設定します。
     *
     * @param サービス事業所郵便番号 サービス事業所郵便番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所郵便番号(YubinNo サービス事業所郵便番号) {
        requireNonNull(サービス事業所郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所郵便番号"));
        entity.get事業者().setServiceJigyoshoYubinNo(サービス事業所郵便番号);
        return this;
    }

    /**
     * サービス事業所住所を設定します。
     *
     * @param サービス事業所住所 サービス事業所住所
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所住所(RString サービス事業所住所) {
        requireNonNull(サービス事業所住所, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所"));
        entity.get事業者().setServiceJigyoshoAddressKanji(サービス事業所住所);
        return this;
    }

    /**
     * サービス事業所住所カナを設定します。
     *
     * @param サービス事業所住所カナ サービス事業所住所カナ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所住所カナ(RString サービス事業所住所カナ) {
        requireNonNull(サービス事業所住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所カナ"));
        entity.get事業者().setServiceJigyoshoAddressKana(サービス事業所住所カナ);
        return this;
    }

    /**
     * サービス事業所電話番号を設定します。
     *
     * @param サービス事業所電話番号 サービス事業所電話番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所電話番号(RString サービス事業所電話番号) {
        requireNonNull(サービス事業所電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所電話番号"));
        entity.get事業者().setServiceJigyoshoTelNo(サービス事業所電話番号);
        return this;
    }

    /**
     * サービス事業所FAX番号を設定します。
     *
     * @param サービス事業所FAX番号 サービス事業所FAX番号
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所FAX番号(RString サービス事業所FAX番号) {
        requireNonNull(サービス事業所FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所FAX番号"));
        entity.get事業者().setServiceJigyoshoFaxNo(サービス事業所FAX番号);
        return this;
    }

    /**
     * サービス事業所事業開始年月日を設定します。
     *
     * @param サービス事業所事業開始年月日 サービス事業所事業開始年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所事業開始年月日(FlexibleDate サービス事業所事業開始年月日) {
        requireNonNull(サービス事業所事業開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業開始年月日"));
        entity.get事業者().setServiceJigyoshoJigyoKaisiYMD(サービス事業所事業開始年月日);
        return this;
    }

    /**
     * サービス事業所事業休止年月日を設定します。
     *
     * @param サービス事業所事業休止年月日 サービス事業所事業休止年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所事業休止年月日(FlexibleDate サービス事業所事業休止年月日) {
        requireNonNull(サービス事業所事業休止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業休止年月日"));
        entity.get事業者().setServiceJigyoshoJigyoKyushiYMD(サービス事業所事業休止年月日);
        return this;
    }

    /**
     * サービス事業所事業廃止年月日を設定します。
     *
     * @param サービス事業所事業廃止年月日 サービス事業所事業廃止年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所事業廃止年月日(FlexibleDate サービス事業所事業廃止年月日) {
        requireNonNull(サービス事業所事業廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業廃止年月日"));
        entity.get事業者().setServiceJigyoshoJigyoHaishiYMD(サービス事業所事業廃止年月日);
        return this;
    }

    /**
     * サービス事業所事業再開年月日を設定します。
     *
     * @param サービス事業所事業再開年月日 サービス事業所事業再開年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder setサービス事業所事業再開年月日(FlexibleDate サービス事業所事業再開年月日) {
        requireNonNull(サービス事業所事業再開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業再開年月日"));
        entity.get事業者().setServiceJigyoshoJigyoSaikaiYMD(サービス事業所事業再開年月日);
        return this;
    }

    /**
     * 受領委任区分を設定します。
     *
     * @param 受領委任区分 受領委任区分
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set受領委任区分(RString 受領委任区分) {
        requireNonNull(受領委任区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任区分"));
        entity.get事業者().setJuryoIninKubu(受領委任区分);
        return this;
    }

    /**
     * 市町村特別給付登録開始年月日を設定します。
     *
     * @param 市町村特別給付登録開始年月日 市町村特別給付登録開始年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set市町村特別給付登録開始年月日(FlexibleDate 市町村特別給付登録開始年月日) {
        requireNonNull(市町村特別給付登録開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録開始年月日"));
        entity.get事業者().setTorokuKaishiYMD(市町村特別給付登録開始年月日);
        return this;
    }

    /**
     * 市町村特別給付登録終了年月日を設定します。
     *
     * @param 市町村特別給付登録終了年月日 市町村特別給付登録終了年月日
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set市町村特別給付登録終了年月日(FlexibleDate 市町村特別給付登録終了年月日) {
        requireNonNull(市町村特別給付登録終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録終了年月日"));
        entity.get事業者().setTorokuShuryoYMD(市町村特別給付登録終了年月日);
        return this;
    }

    /**
     * 生活保護法による指定の有を設定します。
     *
     * @param 生活保護法による指定の有 生活保護法による指定の有
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set生活保護法による指定の有(boolean 生活保護法による指定の有) {
        requireNonNull(生活保護法による指定の有, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護法による指定の有"));
        entity.get事業者().setSeikatsuhogoShiteiFlag(生活保護法による指定の有);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link TokubetsuKyufuJigyoshaSearchBuilder}
     */
    public TokubetsuKyufuJigyoshaSearchBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.get事業者().setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link ShichosonTokubetsuKyufuJigyosha}のインスタンスを生成します。
     *
     * @return {@link ShichosonTokubetsuKyufuJigyosha}のインスタンス
     */
    public TokubetsuKyufuJigyoshaSearchBusiness build() {
        return new TokubetsuKyufuJigyoshaSearchBusiness(entity, id);
    }
}
