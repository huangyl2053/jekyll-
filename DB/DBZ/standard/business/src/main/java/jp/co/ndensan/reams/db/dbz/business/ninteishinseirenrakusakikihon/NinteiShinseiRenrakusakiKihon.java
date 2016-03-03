/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
 * 介護連絡先情報を管理するクラスです。
 */
public class NinteiShinseiRenrakusakiKihon {

    private final DbT5150RenrakusakiJohoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5150RenrakusakiJohoEntity}より{@link RenrakusakiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5150RenrakusakiJohoEntity}
     */
    public NinteiShinseiRenrakusakiKihon(DbT5150RenrakusakiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護連絡先情報"));
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 連絡先区分番号を返します。
     *
     * @return 連絡先区分番号
     */
    public RString get連絡先区分番号() {
        return entity.getRenrakusakiKubunNo();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 連絡先氏名を返します。
     *
     * @return 連絡先氏名
     */
    public AtenaMeisho get連絡先氏名() {
        return entity.getRenrakusakiShimei();
    }

    /**
     * 連絡先氏名カナを返します。
     *
     * @return 連絡先氏名カナ
     */
    public AtenaKanaMeisho get連絡先氏名カナ() {
        return entity.getRenrakusakiKanaSimei();
    }

    /**
     * 連絡先続柄を返します。
     *
     * @return 連絡先続柄
     */
    public RString get連絡先続柄() {
        return entity.getRenrakusakiTuzukigara();
    }

    /**
     * 連絡先郵便番号を返します。
     *
     * @return 連絡先郵便番号
     */
    public YubinNo get連絡先郵便番号() {
        return entity.getRenrakusakiYubinNo();
    }

    /**
     * 連絡先住所を返します。
     *
     * @return 連絡先住所
     */
    public AtenaJusho get連絡先住所() {
        return entity.getRenrakusakiJusho();
    }

    /**
     * 連絡先電話番号を返します。
     *
     * @return 連絡先電話番号
     */
    public TelNo get連絡先電話番号() {
        return entity.getRenrakusakiTelNo();
    }

    /**
     * 連絡先携帯番号を返します。
     *
     * @return 連絡先携帯番号
     */
    public TelNo get連絡先携帯番号() {
        return entity.getRenrakusakiKeitaiTelNo();
    }

    /**
     * 優先順位を返します。
     *
     * @return 優先順位
     */
    public int get優先順位() {
        return entity.getPriority();
    }
}
