/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RenrakusakiJoho}の編集を行うビルダークラスです。
 * 
 * @author n3213
 */
public class DbT4150RenrakusakiJohoBuilder {

    private final DbT4150RenrakusakiJohoEntity entity;
    private final DbT4150RenrakusakiJohoIdentifier id;

    /**
     * {@link DbT4150RenrakusakiJohoEntity}より{@link DbT4150RenrakusakiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4150RenrakusakiJohoEntity}
     * @param id {@link DbT4150RenrakusakiJohoIdentifier}
     *
     */
    DbT4150RenrakusakiJohoBuilder(
            DbT4150RenrakusakiJohoEntity entity,
            DbT4150RenrakusakiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }
    
    public DbT4150RenrakusakiJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 連絡先区分番号を設定します。
     *
     * @param 連絡先区分番号 連絡先区分番号
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先区分番号(RString 連絡先区分番号) {
        requireNonNull(連絡先区分番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先区分番号"));
        entity.setRenrakusakiKubunNo(連絡先区分番号);
        return this;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set支所コード(ShishoCode 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
        return this;
    }

    /**
     * 連絡先氏名を設定します。
     *
     * @param 連絡先氏名 連絡先氏名
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先氏名(AtenaMeisho 連絡先氏名) {
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
    public DbT4150RenrakusakiJohoBuilder set連絡先氏名カナ(AtenaKanaMeisho 連絡先氏名カナ) {
        requireNonNull(連絡先氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先氏名カナ"));
        entity.setRenrakusakiKanaSimei(連絡先氏名カナ);
        return this;
    }

    /**
     * 連絡先続柄を設定します。
     *
     * @param 連絡先続柄 連絡先続柄
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先続柄(RString 連絡先続柄) {
        requireNonNull(連絡先続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先続柄"));
        entity.setRenrakusakiTuzukigara(連絡先続柄);
        return this;
    }

    /**
     * 連絡先郵便番号を設定します。
     *
     * @param 連絡先郵便番号 連絡先郵便番号
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先郵便番号(YubinNo 連絡先郵便番号) {
        requireNonNull(連絡先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先郵便番号"));
        entity.setRenrakusakiYubinNo(連絡先郵便番号);
        return this;
    }

    /**
     * 連絡先住所を設定します。
     *
     * @param 連絡先住所 連絡先住所
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先住所(AtenaJusho 連絡先住所) {
        requireNonNull(連絡先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先住所"));
        entity.setRenrakusakiJusho(連絡先住所);
        return this;
    }

    /**
     * 連絡先電話番号を設定します。
     *
     * @param 連絡先電話番号 連絡先電話番号
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先電話番号(TelNo 連絡先電話番号) {
        requireNonNull(連絡先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先電話番号"));
        entity.setRenrakusakiTelNo(連絡先電話番号);
        return this;
    }

    /**
     * 連絡先携帯番号を設定します。
     *
     * @param 連絡先携帯番号 連絡先携帯番号
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set連絡先携帯番号(TelNo 連絡先携帯番号) {
        requireNonNull(連絡先携帯番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡先携帯番号"));
        entity.setRenrakusakiKeitaiTelNo(連絡先携帯番号);
        return this;
    }

    /**
     * 優先順位を設定します。
     *
     * @param 優先順位 優先順位
     * @return {@link DbT4150RenrakusakiJohoBuilder}
     */
    public DbT4150RenrakusakiJohoBuilder set優先順位(int 優先順位) {
        requireNonNull(優先順位, UrSystemErrorMessages.値がnull.getReplacedMessage("優先順位"));
        entity.setPriority(優先順位);
        return this;
    }

    /**
     * {@link DbT4150RenrakusakiJoho}のインスタンスを生成します。
     *
     * @return {@link DbT4150RenrakusakiJoho}のインスタンス
     */
    public DbT4150RenrakusakiJoho build() {
        return new DbT4150RenrakusakiJoho(entity, id);
    }
}
