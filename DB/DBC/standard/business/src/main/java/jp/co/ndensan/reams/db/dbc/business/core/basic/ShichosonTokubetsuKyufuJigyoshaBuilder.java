/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShichosonTokubetsuKyufuJigyosha}の編集を行うビルダークラスです。
 */
public class ShichosonTokubetsuKyufuJigyoshaBuilder {

    private final DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity;
    private final ShichosonTokubetsuKyufuJigyoshaIdentifier id;

    /**
     * {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}より{@link ShichosonTokubetsuKyufuJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}
     * @param id {@link ShichosonTokubetsuKyufuJigyoshaIdentifier}
     *
     */
    ShichosonTokubetsuKyufuJigyoshaBuilder(
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity,
            ShichosonTokubetsuKyufuJigyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村特別給付用事業者番号を設定します。
     *
     * @param 市町村特別給付用事業者番号 市町村特別給付用事業者番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set市町村特別給付用事業者番号(JigyoshaNo 市町村特別給付用事業者番号) {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        entity.setJigyoshaNo(市町村特別給付用事業者番号);
        return this;
    }

    /**
     * 市町村特別給付用サービスコードを設定します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set市町村特別給付用サービスコード(ServiceCode 市町村特別給付用サービスコード) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        entity.setServiceCode(市町村特別給付用サービスコード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 介護国保連ＩＦ異動区分を設定します。
     *
     * @param 介護国保連ＩＦ異動区分 介護国保連ＩＦ異動区分
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set介護国保連ＩＦ異動区分(RString 介護国保連ＩＦ異動区分) {
        requireNonNull(介護国保連ＩＦ異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動区分"));
        entity.setIdoKubun(介護国保連ＩＦ異動区分);
        return this;
    }

    /**
     * 介護国保連ＩＦ異動年月日を設定します。
     *
     * @param 介護国保連ＩＦ異動年月日 介護国保連ＩＦ異動年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set介護国保連ＩＦ異動年月日(FlexibleDate 介護国保連ＩＦ異動年月日) {
        requireNonNull(介護国保連ＩＦ異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動年月日"));
        entity.setIdoYMD(介護国保連ＩＦ異動年月日);
        return this;
    }

    /**
     * 介護国保連ＩＦ法人種別を設定します。
     *
     * @param 介護国保連ＩＦ法人種別 介護国保連ＩＦ法人種別
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set介護国保連ＩＦ法人種別(RString 介護国保連ＩＦ法人種別) {
        requireNonNull(介護国保連ＩＦ法人種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ法人種別"));
        entity.setHojinShubetsu(介護国保連ＩＦ法人種別);
        return this;
    }

    /**
     * 申請者氏名_漢字を設定します。
     *
     * @param 申請者氏名_漢字 申請者氏名_漢字
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者氏名_漢字(RString 申請者氏名_漢字) {
        requireNonNull(申請者氏名_漢字, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_漢字"));
        entity.setShinseishaNameKanji(申請者氏名_漢字);
        return this;
    }

    /**
     * 申請者氏名_カナを設定します。
     *
     * @param 申請者氏名_カナ 申請者氏名_カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者氏名_カナ(RString 申請者氏名_カナ) {
        requireNonNull(申請者氏名_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_カナ"));
        entity.setShinseishaNameKana(申請者氏名_カナ);
        return this;
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
        return this;
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaAddressKanji(申請者住所);
        return this;
    }

    /**
     * 申請者住所_カナを設定します。
     *
     * @param 申請者住所_カナ 申請者住所_カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者住所_カナ(RString 申請者住所_カナ) {
        requireNonNull(申請者住所_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所_カナ"));
        entity.setShinseishaAddressKana(申請者住所_カナ);
        return this;
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者電話番号(RString 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
        return this;
    }

    /**
     * 申請者FAX番号を設定します。
     *
     * @param 申請者FAX番号 申請者FAX番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set申請者FAX番号(RString 申請者FAX番号) {
        requireNonNull(申請者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者FAX番号"));
        entity.setShinseishaFaxNo(申請者FAX番号);
        return this;
    }

    /**
     * 事業所代表者役職を設定します。
     *
     * @param 事業所代表者役職 事業所代表者役職
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者役職(RString 事業所代表者役職) {
        requireNonNull(事業所代表者役職, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者役職"));
        entity.setJigyoshoDaihyoshaYakushoku(事業所代表者役職);
        return this;
    }

    /**
     * 事業所代表者氏名を設定します。
     *
     * @param 事業所代表者氏名 事業所代表者氏名
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者氏名(RString 事業所代表者氏名) {
        requireNonNull(事業所代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名"));
        entity.setJigyoshoDaihyoshaNameKanji(事業所代表者氏名);
        return this;
    }

    /**
     * 事業所代表者氏名カナを設定します。
     *
     * @param 事業所代表者氏名カナ 事業所代表者氏名カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者氏名カナ(RString 事業所代表者氏名カナ) {
        requireNonNull(事業所代表者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名カナ"));
        entity.setJigyoshoDaihyoshaNameKana(事業所代表者氏名カナ);
        return this;
    }

    /**
     * 事業所代表者郵便番号を設定します。
     *
     * @param 事業所代表者郵便番号 事業所代表者郵便番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者郵便番号(YubinNo 事業所代表者郵便番号) {
        requireNonNull(事業所代表者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者郵便番号"));
        entity.setJigyoshoDaihyoshaYubinNo(事業所代表者郵便番号);
        return this;
    }

    /**
     * 事業所代表者住所を設定します。
     *
     * @param 事業所代表者住所 事業所代表者住所
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者住所(RString 事業所代表者住所) {
        requireNonNull(事業所代表者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所"));
        entity.setJigyoshoDaihyoshaAddressKanji(事業所代表者住所);
        return this;
    }

    /**
     * 事業所代表者住所カナを設定します。
     *
     * @param 事業所代表者住所カナ 事業所代表者住所カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所代表者住所カナ(RString 事業所代表者住所カナ) {
        requireNonNull(事業所代表者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所カナ"));
        entity.setJigyoshoDaihyoshaAddressKana(事業所代表者住所カナ);
        return this;
    }

    /**
     * 事業所管理者氏名を設定します。
     *
     * @param 事業所管理者氏名 事業所管理者氏名
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所管理者氏名(RString 事業所管理者氏名) {
        requireNonNull(事業所管理者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名"));
        entity.setJigyoshoKanrishaNameKanji(事業所管理者氏名);
        return this;
    }

    /**
     * 事業所管理者氏名カナを設定します。
     *
     * @param 事業所管理者氏名カナ 事業所管理者氏名カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所管理者氏名カナ(RString 事業所管理者氏名カナ) {
        requireNonNull(事業所管理者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名カナ"));
        entity.setJigyoshoKanrishaNameKana(事業所管理者氏名カナ);
        return this;
    }

    /**
     * 事業所管理者郵便番号を設定します。
     *
     * @param 事業所管理者郵便番号 事業所管理者郵便番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所管理者郵便番号(YubinNo 事業所管理者郵便番号) {
        requireNonNull(事業所管理者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者郵便番号"));
        entity.setJigyoshoKanrishaYubinNo(事業所管理者郵便番号);
        return this;
    }

    /**
     * 事業所管理者住所を設定します。
     *
     * @param 事業所管理者住所 事業所管理者住所
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所管理者住所(RString 事業所管理者住所) {
        requireNonNull(事業所管理者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所"));
        entity.setJigyoshoKanrishaAddressKanji(事業所管理者住所);
        return this;
    }

    /**
     * 事業所管理者住所カナを設定します。
     *
     * @param 事業所管理者住所カナ 事業所管理者住所カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set事業所管理者住所カナ(RString 事業所管理者住所カナ) {
        requireNonNull(事業所管理者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所カナ"));
        entity.setJigyoshoKanrishaAddressKana(事業所管理者住所カナ);
        return this;
    }

    /**
     * サービス事業所名を設定します。
     *
     * @param サービス事業所名 サービス事業所名
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所名(RString サービス事業所名) {
        requireNonNull(サービス事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名"));
        entity.setServiceJigyoshoNameKanji(サービス事業所名);
        return this;
    }

    /**
     * サービス事業所名カナを設定します。
     *
     * @param サービス事業所名カナ サービス事業所名カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所名カナ(RString サービス事業所名カナ) {
        requireNonNull(サービス事業所名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名カナ"));
        entity.setServiceJigyoshoNameKana(サービス事業所名カナ);
        return this;
    }

    /**
     * サービス事業所郵便番号を設定します。
     *
     * @param サービス事業所郵便番号 サービス事業所郵便番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所郵便番号(YubinNo サービス事業所郵便番号) {
        requireNonNull(サービス事業所郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所郵便番号"));
        entity.setServiceJigyoshoYubinNo(サービス事業所郵便番号);
        return this;
    }

    /**
     * サービス事業所住所を設定します。
     *
     * @param サービス事業所住所 サービス事業所住所
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所住所(RString サービス事業所住所) {
        requireNonNull(サービス事業所住所, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所"));
        entity.setServiceJigyoshoAddressKanji(サービス事業所住所);
        return this;
    }

    /**
     * サービス事業所住所カナを設定します。
     *
     * @param サービス事業所住所カナ サービス事業所住所カナ
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所住所カナ(RString サービス事業所住所カナ) {
        requireNonNull(サービス事業所住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所カナ"));
        entity.setServiceJigyoshoAddressKana(サービス事業所住所カナ);
        return this;
    }

    /**
     * サービス事業所電話番号を設定します。
     *
     * @param サービス事業所電話番号 サービス事業所電話番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所電話番号(RString サービス事業所電話番号) {
        requireNonNull(サービス事業所電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所電話番号"));
        entity.setServiceJigyoshoTelNo(サービス事業所電話番号);
        return this;
    }

    /**
     * サービス事業所FAX番号を設定します。
     *
     * @param サービス事業所FAX番号 サービス事業所FAX番号
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所FAX番号(RString サービス事業所FAX番号) {
        requireNonNull(サービス事業所FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所FAX番号"));
        entity.setServiceJigyoshoFaxNo(サービス事業所FAX番号);
        return this;
    }

    /**
     * サービス事業所事業開始年月日を設定します。
     *
     * @param サービス事業所事業開始年月日 サービス事業所事業開始年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所事業開始年月日(FlexibleDate サービス事業所事業開始年月日) {
        requireNonNull(サービス事業所事業開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業開始年月日"));
        entity.setServiceJigyoshoJigyoKaisiYMD(サービス事業所事業開始年月日);
        return this;
    }

    /**
     * サービス事業所事業休止年月日を設定します。
     *
     * @param サービス事業所事業休止年月日 サービス事業所事業休止年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所事業休止年月日(FlexibleDate サービス事業所事業休止年月日) {
        requireNonNull(サービス事業所事業休止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業休止年月日"));
        entity.setServiceJigyoshoJigyoKyushiYMD(サービス事業所事業休止年月日);
        return this;
    }

    /**
     * サービス事業所事業廃止年月日を設定します。
     *
     * @param サービス事業所事業廃止年月日 サービス事業所事業廃止年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所事業廃止年月日(FlexibleDate サービス事業所事業廃止年月日) {
        requireNonNull(サービス事業所事業廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業廃止年月日"));
        entity.setServiceJigyoshoJigyoHaishiYMD(サービス事業所事業廃止年月日);
        return this;
    }

    /**
     * サービス事業所事業再開年月日を設定します。
     *
     * @param サービス事業所事業再開年月日 サービス事業所事業再開年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder setサービス事業所事業再開年月日(FlexibleDate サービス事業所事業再開年月日) {
        requireNonNull(サービス事業所事業再開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業再開年月日"));
        entity.setServiceJigyoshoJigyoSaikaiYMD(サービス事業所事業再開年月日);
        return this;
    }

    /**
     * 受領委任区分を設定します。
     *
     * @param 受領委任区分 受領委任区分
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set受領委任区分(RString 受領委任区分) {
        requireNonNull(受領委任区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任区分"));
        entity.setJuryoIninKubu(受領委任区分);
        return this;
    }

    /**
     * 市町村特別給付登録開始年月日を設定します。
     *
     * @param 市町村特別給付登録開始年月日 市町村特別給付登録開始年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set市町村特別給付登録開始年月日(FlexibleDate 市町村特別給付登録開始年月日) {
        requireNonNull(市町村特別給付登録開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録開始年月日"));
        entity.setTorokuKaishiYMD(市町村特別給付登録開始年月日);
        return this;
    }

    /**
     * 市町村特別給付登録終了年月日を設定します。
     *
     * @param 市町村特別給付登録終了年月日 市町村特別給付登録終了年月日
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set市町村特別給付登録終了年月日(FlexibleDate 市町村特別給付登録終了年月日) {
        requireNonNull(市町村特別給付登録終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録終了年月日"));
        entity.setTorokuShuryoYMD(市町村特別給付登録終了年月日);
        return this;
    }

    /**
     * 生活保護法による指定の有を設定します。
     *
     * @param 生活保護法による指定の有 生活保護法による指定の有
     * @return {@link ShichosonTokubetsuKyufuJigyoshaBuilder}
     */
    public ShichosonTokubetsuKyufuJigyoshaBuilder set生活保護法による指定の有(boolean 生活保護法による指定の有) {
        requireNonNull(生活保護法による指定の有, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護法による指定の有"));
        entity.setSeikatsuhogoShiteiFlag(生活保護法による指定の有);
        return this;
    }

    /**
     * {@link ShichosonTokubetsuKyufuJigyosha}のインスタンスを生成します。
     *
     * @return {@link ShichosonTokubetsuKyufuJigyosha}のインスタンス
     */
    public ShichosonTokubetsuKyufuJigyosha build() {
        return new ShichosonTokubetsuKyufuJigyosha(entity, id);
    }
}
