/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShujiiIryoKikanJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShujiiIryoKikanJohoBuilder {

    private final DbT5911ShujiiIryoKikanJohoEntity entity;
    private final ShujiiIryoKikanJohoIdentifier id;
    private final Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho;

    /**
     * {@link DbT5911ShujiiIryoKikanJohoEntity}より{@link ShujiiIryoKikanJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5911ShujiiIryoKikanJohoEntity}
     * @param id {@link ShujiiIryoKikanJohoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShujiiIryoKikanJohoBuilder(
            DbT5911ShujiiIryoKikanJohoEntity entity,
            ShujiiIryoKikanJohoIdentifier id,
            Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shujiiJoho = shujiiJoho.clone();

    }

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
        requireNonNull(医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関コード"));
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
    public ShujiiIryoKikanJohoBuilder setFAX番号(TelNo fax番号) {
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
    public ShujiiIryoKikanJohoBuilder set代表者名(RString 代表者名) {
        requireNonNull(代表者名, UrSystemErrorMessages.値がnull.getReplacedMessage("代表者名"));
        entity.setDaihyoshaName(代表者名);
        return this;
    }

    /**
     * 代表者名カナを設定します。
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
     * 主治医情報のキー情報について判定します。<br>
     * 主治医医療機関情報に関連できる主治医情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は主治医情報リストに主治医情報{@link ShujiiJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 主治医情報 {@link ShujiiJoho}
     * @return ShujiiJohoBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShujiiIryoKikanJohoBuilder setShujiiJoho(ShujiiJoho 主治医情報) {
        if (hasSameIdentifier(主治医情報.identifier())) {
            shujiiJoho.add(主治医情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShujiiJohoIdentifier 主治医情報識別子) {
        return (id.get市町村コード().equals(主治医情報識別子.get市町村コード())
                && id.get主治医医療機関コード().equals(主治医情報識別子.get主治医医療機関コード()));
    }

    /**
     * {@link ShujiiIryoKikanJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiIryoKikanJoho}のインスタンス
     */
    public ShujiiIryoKikanJoho build() {
        return new ShujiiIryoKikanJoho(entity, id, shujiiJoho);
    }

}
