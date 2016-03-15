/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関＆主治医ビジネスクラスです。
 */
public class ShujiiIryokikanAndShujii {

    private final ShujiiIryokikanAndShujiiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医医療機関＆主治医RelateEntity
     */
    public ShujiiIryokikanAndShujii(ShujiiIryokikanAndShujiiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関コードを取得します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.getIryokikanCode();
    }

    /**
     * 主治医医療機関名称を取得します。
     *
     * @return 主治医医療機関名称
     */
    public RString get主治医医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医医療機関カナを取得します。
     *
     * @return 主治医医療機関カナ
     */
    public RString get主治医医療機関カナ() {
        return entity.getIryoKikanMeishoKana();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号(主治医医療機関情報)
     */
    public RString get主治医医療機関情報_郵便番号() {
        return entity.getShujiiIryoKikanyubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所(主治医医療機関情報)
     */
    public RString get主治医医療機関情報_住所() {
        return entity.getShujiiIryoKikanjusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号(主治医医療機関情報)
     */
    public RString get主治医医療機関情報_電話番号() {
        return entity.getShujiiIryoKikantelNo();
    }

    /**
     * FAX番号を取得します。
     *
     * @return FAX番号(主治医医療機関情報)
     */
    public RString get主治医医療機関情報_FAX番号() {
        return entity.getShujiiIryoKikanfaxNo();
    }

    /**
     * 代表者名を取得します。
     *
     * @return 代表者名
     */
    public RString get代表者名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 状況フラグを取得します。
     *
     * @return 状況フラグ(主治医医療機関情報)
     */
    public boolean is主治医医療機関情報_状況フラグ() {
        return entity.isShujiiIryoKikanjokyoFlag();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医カナを取得します。
     *
     * @return 主治医カナ
     */
    public RString get主治医カナ() {
        return entity.getShujiiKana();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号(主治医情報)
     */
    public RString get主治医情報_郵便番号() {
        return entity.getShujiiJohoyubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所(主治医情報)
     */
    public RString get主治医情報_住所() {
        return entity.getShujiiJohojusho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号(主治医情報)
     */
    public RString get主治医情報_電話番号() {
        return entity.getShujiiJohotelNo();
    }

    /**
     * FAX番号を取得します。
     *
     * @return FAX番号(主治医情報)
     */
    public RString get主治医情報_FAX番号() {
        return entity.getShujiiJohofaxNo();
    }

    /**
     * 診療科名称を取得します。
     *
     * @return 診療科名称
     */
    public RString get診療科名称() {
        return entity.getShinryokaName();
    }

    /**
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.isShiteiiFlag();
    }

    /**
     * 状況フラグを取得します。
     *
     * @return 状況フラグ(主治医情報)
     */
    public boolean is主治医情報_状況フラグ() {
        return entity.isShujiiJohojokyoFlag();
    }
}
