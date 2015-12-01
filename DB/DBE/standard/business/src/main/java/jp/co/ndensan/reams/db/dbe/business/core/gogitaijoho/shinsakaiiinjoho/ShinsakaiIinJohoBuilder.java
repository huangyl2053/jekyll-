/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiIinJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiIinJohoBuilder {

    private final DbT5594ShinsakaiIinJohoEntity entity;
    private final ShinsakaiIinJohoIdentifier id;

    /**
     * {@link DbT5594ShinsakaiIinJohoEntity}より{@link ShinsakaiIinJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5594ShinsakaiIinJohoEntity}
     * @param id {@link ShinsakaiIinJohoIdentifier}
     *
     */
    ShinsakaiIinJohoBuilder(
            DbT5594ShinsakaiIinJohoEntity entity,
            ShinsakaiIinJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 介護認定審査会委員開始年月日を設定します。
     *
     * @param 介護認定審査会委員開始年月日 介護認定審査会委員開始年月日
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set介護認定審査会委員開始年月日(FlexibleDate 介護認定審査会委員開始年月日) {
        requireNonNull(介護認定審査会委員開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員開始年月日"));
        entity.setShinsakaiIinKaishiYMD(介護認定審査会委員開始年月日);
        return this;
    }

    /**
     * 介護認定審査会委員終了年月日を設定します。
     *
     * @param 介護認定審査会委員終了年月日 介護認定審査会委員終了年月日
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set介護認定審査会委員終了年月日(FlexibleDate 介護認定審査会委員終了年月日) {
        requireNonNull(介護認定審査会委員終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員終了年月日"));
        entity.setShinsakaiIinShuryoYMD(介護認定審査会委員終了年月日);
        return this;
    }

    /**
     * 介護認定審査会委員氏名を設定します。
     *
     * @param 介護認定審査会委員氏名 介護認定審査会委員氏名
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set介護認定審査会委員氏名(AtenaMeisho 介護認定審査会委員氏名) {
        requireNonNull(介護認定審査会委員氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員氏名"));
        entity.setShinsakaiIinShimei(介護認定審査会委員氏名);
        return this;
    }

    /**
     * 介護認定審査会委員氏名カナを設定します。
     *
     * @param 介護認定審査会委員氏名カナ 介護認定審査会委員氏名カナ
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set介護認定審査会委員氏名カナ(AtenaKanaMeisho 介護認定審査会委員氏名カナ) {
        requireNonNull(介護認定審査会委員氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員氏名カナ"));
        entity.setShinsakaiIinKanaShimei(介護認定審査会委員氏名カナ);
        return this;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set性別(RString 性別) {
        requireNonNull(性別, UrSystemErrorMessages.値がnull.getReplacedMessage("性別"));
        entity.setSeibetsu(性別);
        return this;
    }

    /**
     * 介護認定審査員資格コードを設定します。
     *
     * @param 介護認定審査員資格コード 介護認定審査員資格コード
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set介護認定審査員資格コード(Code 介護認定審査員資格コード) {
        requireNonNull(介護認定審査員資格コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査員資格コード"));
        entity.setShinsakaiIinShikakuCode(介護認定審査員資格コード);
        return this;
    }

    /**
     * 審査員郵送区分を設定します。
     *
     * @param 審査員郵送区分 審査員郵送区分
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set審査員郵送区分(RString 審査員郵送区分) {
        requireNonNull(審査員郵送区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査員郵送区分"));
        entity.setShinsainYusoKubun(審査員郵送区分);
        return this;
    }

    /**
     * 担当地区コードを設定します。
     *
     * @param 担当地区コード 担当地区コード
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set担当地区コード(ChikuCode 担当地区コード) {
        requireNonNull(担当地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("担当地区コード"));
        entity.setTantoChikuCode(担当地区コード);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setSeinengappiYMD(生年月日);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 廃止フラグを設定します。
     *
     * @param 廃止フラグ 廃止フラグ
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set廃止フラグ(boolean 廃止フラグ) {
        requireNonNull(廃止フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("廃止フラグ"));
        entity.setHaishiFlag(廃止フラグ);
        return this;
    }

    /**
     * 廃止年月日を設定します。
     *
     * @param 廃止年月日 廃止年月日
     * @return {@link ShinsakaiIinJohoBuilder}
     */
    public ShinsakaiIinJohoBuilder set廃止年月日(FlexibleDate 廃止年月日) {
        requireNonNull(廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("廃止年月日"));
        entity.setHaishiYMD(廃止年月日);
        return this;
    }

    /**
     * {@link ShinsakaiIinJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiIinJoho}のインスタンス
     */
    public ShinsakaiIinJoho build() {
        return new ShinsakaiIinJoho(entity, id);
    }
}
