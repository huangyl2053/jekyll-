/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosaItakusakiJoho}の編集を行うビルダークラスです。
 */
public class NinteichosaItakusakiJohoBuilder {

    private final DbT5910NinteichosaItakusakiJohoEntity entity;
    private final NinteichosaItakusakiJohoIdentifier id;

    /**
     * {@link DbT5910NinteichosaItakusakiJohoEntity}より{@link NinteichosaItakusakiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5910NinteichosaItakusakiJohoEntity}
     * @param id {@link NinteichosaItakusakiJohoIdentifier}
     *
     */
    NinteichosaItakusakiJohoBuilder(
            DbT5910NinteichosaItakusakiJohoEntity entity,
            NinteichosaItakusakiJohoIdentifier id
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
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set認定調査委託先コード(ChosaItakusakiCode 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
      //  entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set事業者名称(RString 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaMeisho(事業者名称);
        return this;
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set事業者名称カナ(RString 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaMeishoKana(事業者名称カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set住所(RString 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * fax番号を設定します。
     *
     * @param fax番号 FAX番号
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder setFax番号(TelNo fax番号) {
        requireNonNull(fax番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(fax番号);
        return this;
    }

    /**
     * 代表者名を設定します。
     *
     * @param 代表者名 代表者名
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set代表者名(AtenaMeisho 代表者名) {
        requireNonNull(代表者名, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名"));
       // entity.setDaihyoshaName(代表者名);
        return this;
    }

    /**
     * 調査委託区分を設定します。
     *
     * @param 調査委託区分 調査委託区分
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set調査委託区分(RString 調査委託区分) {
        requireNonNull(調査委託区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託区分"));
        entity.setChosaItakuKubun(調査委託区分);
        return this;
    }

    /**
     * 割付定員を設定します。
     *
     * @param 割付定員 割付定員
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set割付定員(int 割付定員) {
        requireNonNull(割付定員, UrSystemErrorMessages.値がnull.getReplacedMessage("割付定員"));
        entity.setWaritsukeTeiin(割付定員);
        return this;
    }

    /**
     * 割付地区を設定します。
     *
     * @param 割付地区 割付地区
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set割付地区(ChikuCode 割付地区) {
        requireNonNull(割付地区, UrSystemErrorMessages.値がnull.getReplacedMessage("割付地区"));
        entity.setWaritsukeChiku(割付地区);
        return this;
    }

    /**
     * 自動割付フラグを設定します。
     *
     * @param 自動割付フラグ 自動割付フラグ
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set自動割付フラグ(boolean 自動割付フラグ) {
        requireNonNull(自動割付フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("自動割付フラグ"));
        entity.setAutoWaritsukeFlag(自動割付フラグ);
        return this;
    }

    /**
     * 機関の区分を設定します。
     *
     * @param 機関の区分 機関の区分
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set機関の区分(RString 機関の区分) {
        requireNonNull(機関の区分, UrSystemErrorMessages.値がnull.getReplacedMessage("機関の区分"));
        entity.setKikanKubun(機関の区分);
        return this;
    }

    /**
     * 状況フラグを設定します。
     *
     * @param 状況フラグ 状況フラグ
     * @return {@link NinteichosaItakusakiJohoBuilder}
     */
    public NinteichosaItakusakiJohoBuilder set状況フラグ(boolean 状況フラグ) {
        requireNonNull(状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("状況フラグ"));
        entity.setJokyoFlag(状況フラグ);
        return this;
    }

    /**
     * {@link NinteichosaItakusakiJoho}のインスタンスを生成します。
     *
     * @return {@link NinteichosaItakusakiJoho}のインスタンス
     */
    public NinteichosaItakusakiJoho build() {
        return new NinteichosaItakusakiJoho(entity, id);
    }
}
