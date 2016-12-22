/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiIryoKikanJoho}の編集を行うビルダークラスです。
 */
public class ShujiiIryoKikanJohoBuilder {

    private final DbT5911ShujiiIryoKikanJohoEntity entity;
    private final ShujiiIryoKikanJohoIdentifier id;

    /**
     * {@link DbT5911ShujiiIryoKikanJohoEntity}より{@link ShujiiIryoKikanJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5911ShujiiIryoKikanJohoEntity}
     * @param id {@link ShujiiIryoKikanJohoIdentifier}
     *
     */
    ShujiiIryoKikanJohoBuilder(
            DbT5911ShujiiIryoKikanJohoEntity entity,
            ShujiiIryoKikanJohoIdentifier id
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
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set主治医医療機関コード(ShujiiIryokikanCode 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryokikanCode(主治医医療機関コード);
        return this;
    }

    /**
     * 医療機関コードを設定します。
     *
     * @param 医療機関コード 医療機関コード
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set医療機関コード(IryoKikanCode 医療機関コード) {
        entity.setIryokikanCode(医療機関コード);
        return this;
    }

    /**
     * 医療機関名称を設定します。
     *
     * @param 医療機関名称 医療機関名称
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set医療機関名称(RString 医療機関名称) {
        requireNonNull(医療機関名称, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関名称"));
        entity.setIryoKikanMeisho(医療機関名称);
        return this;
    }

    /**
     * 医療機関名称カナを設定します。
     *
     * @param 医療機関名称カナ 医療機関名称カナ
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set医療機関名称カナ(RString 医療機関名称カナ) {
        requireNonNull(医療機関名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関名称カナ"));
        entity.setIryoKikanMeishoKana(医療機関名称カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set住所(RString 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param fax番号 FAX番号
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder setFax番号(TelNo fax番号) {
        requireNonNull(fax番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(fax番号);
        return this;
    }

    /**
     * 代表者名を設定します。
     *
     * @param 代表者名 代表者名
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set代表者名(AtenaMeisho 代表者名) {
        requireNonNull(代表者名, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名"));
        entity.setDaihyoshaName(代表者名.getColumnValue());
        return this;
    }

    /**
     * 代表者名を設定します。
     *
     * @param 代表者名カナ 代表者名カナ
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set代表者名カナ(RString 代表者名カナ) {
        requireNonNull(代表者名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名カナ"));
        entity.setDaihyoshaNameKana(代表者名カナ);
        return this;
    }

    /**
     * 状況フラグを設定します。
     *
     * @param 状況フラグ 状況フラグ
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder set状況フラグ(boolean 状況フラグ) {
        requireNonNull(状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("状況フラグ"));
        entity.setJokyoFlag(状況フラグ);
        return this;
    }

    /**
     * {@link ShujiiIryoKikanJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiIryoKikanJoho}のインスタンス
     */
    public ShujiiIryoKikanJoho build() {
        return new ShujiiIryoKikanJoho(entity, id);
    }
}
