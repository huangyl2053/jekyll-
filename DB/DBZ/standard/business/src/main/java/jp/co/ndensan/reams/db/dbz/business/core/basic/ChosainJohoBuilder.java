/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChosainJoho}の編集を行うビルダークラスです。
 */
public class ChosainJohoBuilder {

    private final DbT5913ChosainJohoEntity entity;
    private final ChosainJohoIdentifier id;

    /**
     * {@link DbT5913ChosainJohoEntity}より{@link ChosainJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5913ChosainJohoEntity}
     * @param id {@link ChosainJohoIdentifier}
     *
     */
    ChosainJohoBuilder(
            DbT5913ChosainJohoEntity entity,
            ChosainJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set認定調査委託先コード(ChosaItakusakiCode 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set認定調査員コード(ChosainCode 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteiChosainNo(認定調査員コード);
        return this;
    }

    /**
     * 調査員氏名を設定します。
     *
     * @param 調査員氏名 調査員氏名
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set調査員氏名(RString 調査員氏名) {
        requireNonNull(調査員氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員氏名"));
        entity.setChosainShimei(調査員氏名);
        return this;
    }

    /**
     * 調査員氏名カナを設定します。
     *
     * @param 調査員氏名カナ 調査員氏名カナ
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set調査員氏名カナ(RString 調査員氏名カナ) {
        requireNonNull(調査員氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員氏名カナ"));
        entity.setChosainKanaShimei(調査員氏名カナ);
        return this;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set性別(RString 性別) {
        requireNonNull(性別, UrSystemErrorMessages.値がnull.getReplacedMessage("性別"));
        entity.setSeibetsu(性別);
        return this;
    }

    /**
     * 調査員資格を設定します。
     *
     * @param 調査員資格 調査員資格
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set調査員資格(RString 調査員資格) {
        requireNonNull(調査員資格, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員資格"));
        entity.setChosainShikaku(調査員資格);
        return this;
    }

    /**
     * 地区コードを設定します。
     *
     * @param 地区コード 地区コード
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set地区コード(RString 地区コード) {
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));
        entity.setChikuCode(地区コード);
        return this;
    }

    /**
     * 調査可能人数_月を設定します。
     *
     * @param 調査可能人数_月 調査可能人数_月
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set調査可能人数_月(int 調査可能人数_月) {
        requireNonNull(調査可能人数_月, UrSystemErrorMessages.値がnull.getReplacedMessage("調査可能人数_月"));
        entity.setChosaKanoNinzuPerMonth(調査可能人数_月);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
        return this;
    }

    /**
     * 状況フラグを設定します。
     *
     * @param 状況フラグ 状況フラグ
     * @return {@link ChosainJohoBuilder}
     */
    public ChosainJohoBuilder set状況フラグ(boolean 状況フラグ) {
        requireNonNull(状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("状況フラグ"));
        entity.setJokyoFlag(状況フラグ);
        return this;
    }

    /**
     * {@link ChosainJoho}のインスタンスを生成します。
     *
     * @return {@link ChosainJoho}のインスタンス
     */
    public ChosainJoho build() {
        return new ChosainJoho(entity, id);
    }
}
