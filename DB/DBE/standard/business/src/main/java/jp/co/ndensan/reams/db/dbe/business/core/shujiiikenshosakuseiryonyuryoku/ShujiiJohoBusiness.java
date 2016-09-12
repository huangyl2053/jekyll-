/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報のBusinessです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ShujiiJohoBusiness {

    private final ShujiiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医情報のEntity
     */
    public ShujiiJohoBusiness(ShujiiJohoRelateEntity entity) {
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
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
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
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
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
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
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
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.isJokyoFlag();
    }
}
