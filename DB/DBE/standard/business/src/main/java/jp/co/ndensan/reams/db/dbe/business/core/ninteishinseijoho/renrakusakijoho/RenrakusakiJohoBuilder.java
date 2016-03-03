/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RenrakusakiJoho}の編集を行うビルダークラスです。
 */
public class RenrakusakiJohoBuilder {

    private final DbT5150RenrakusakiJohoEntity entity;
    private final RenrakusakiJohoIdentifier id;

    /**
     * {@link DbT5150RenrakusakiJohoEntity}より{@link RenrakusakiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5150RenrakusakiJohoEntity}
     * @param id {@link RenrakusakiJohoIdentifier}
     *
     */
    RenrakusakiJohoBuilder(
            DbT5150RenrakusakiJohoEntity entity,
            RenrakusakiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 連絡先区分番号を設定します。
     *
     * @param 連絡先区分番号 連絡先区分番号
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先区分番号(RString 連絡先区分番号) {
        requireNonNull(連絡先区分番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先区分番号"));
        entity.setRenrakusakiKubunNo(連絡先区分番号);
        return this;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set支所コード(ShishoCode 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
        return this;
    }

    /**
     * 連絡先氏名を設定します。
     *
     * @param 連絡先氏名 連絡先氏名
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先氏名(AtenaMeisho 連絡先氏名) {
        requireNonNull(連絡先氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先氏名"));
        entity.setRenrakusakiShimei(連絡先氏名);
        return this;
    }

    /**
     * 連絡先氏名カナを設定します。
     *
     * @param 連絡先氏名カナ 連絡先氏名カナ
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先氏名カナ(AtenaKanaMeisho 連絡先氏名カナ) {
        requireNonNull(連絡先氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先氏名カナ"));
        entity.setRenrakusakiKanaSimei(連絡先氏名カナ);
        return this;
    }

    /**
     * 連絡先続柄を設定します。
     *
     * @param 連絡先続柄 連絡先続柄
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先続柄(RString 連絡先続柄) {
        requireNonNull(連絡先続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先続柄"));
        entity.setRenrakusakiTuzukigara(連絡先続柄);
        return this;
    }

    /**
     * 連絡先郵便番号を設定します。
     *
     * @param 連絡先郵便番号 連絡先郵便番号
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先郵便番号(YubinNo 連絡先郵便番号) {
        requireNonNull(連絡先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先郵便番号"));
        entity.setRenrakusakiYubinNo(連絡先郵便番号);
        return this;
    }

    /**
     * 連絡先住所を設定します。
     *
     * @param 連絡先住所 連絡先住所
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先住所(AtenaJusho 連絡先住所) {
        requireNonNull(連絡先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先住所"));
        entity.setRenrakusakiJusho(連絡先住所);
        return this;
    }

    /**
     * 連絡先電話番号を設定します。
     *
     * @param 連絡先電話番号 連絡先電話番号
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先電話番号(TelNo 連絡先電話番号) {
        requireNonNull(連絡先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先電話番号"));
        entity.setRenrakusakiTelNo(連絡先電話番号);
        return this;
    }

    /**
     * 連絡先携帯番号を設定します。
     *
     * @param 連絡先携帯番号 連絡先携帯番号
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set連絡先携帯番号(TelNo 連絡先携帯番号) {
        requireNonNull(連絡先携帯番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先携帯番号"));
        entity.setRenrakusakiKeitaiTelNo(連絡先携帯番号);
        return this;
    }

    /**
     * 優先順位を設定します。
     *
     * @param 優先順位 優先順位
     * @return {@link RenrakusakiJohoBuilder}
     */
    public RenrakusakiJohoBuilder set優先順位(int 優先順位) {
        requireNonNull(優先順位, UrSystemErrorMessages.値がnull.getReplacedMessage("優先順位"));
        entity.setPriority(優先順位);
        return this;
    }

    /**
     * {@link RenrakusakiJoho}のインスタンスを生成します。
     *
     * @return {@link RenrakusakiJoho}のインスタンス
     */
    public RenrakusakiJoho build() {
        return new RenrakusakiJoho(entity, id);
    }
}
