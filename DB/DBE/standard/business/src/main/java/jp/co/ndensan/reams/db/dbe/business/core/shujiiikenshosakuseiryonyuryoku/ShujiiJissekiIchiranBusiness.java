/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医実績一覧のBusinessです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ShujiiJissekiIchiranBusiness {

    private final ShujiiJissekiIchiranRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医実績一覧のEntity
     */
    public ShujiiJissekiIchiranBusiness(ShujiiJissekiIchiranRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 主治医意見書作成依頼履歴番号(要介護認定主治医意見書情報)を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号(要介護認定主治医意見書情報)
     */
    public RString get主治医意見書作成依頼履歴番号_意見書情報() {
        return entity.getDbT5302_ikenshoIraiRirekiNo();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryoKikanCode();
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
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
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
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.isShiteiiFlag();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分（申請時）コードを取得します。
     *
     * @return 申請区分（申請時）コード
     */
    public RString get申請区分_申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 主治医意見書受領年月日を取得します。
     *
     * @return 主治医意見書受領年月日
     */
    public RString get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 主治医意見書記入年月日を取得します。
     *
     * @return 主治医意見書記入年月日
     */
    public RString get主治医意見書記入年月日() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 主治医意見書作成依頼年月日を取得します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public RString get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 医師区分コードを取得します。
     *
     * @return 医師区分コード
     */
    public RString get医師区分コード() {
        return entity.getIshiKubunCode();
    }

    /**
     * 主治医意見書作成依頼履歴番号(主治医意見書作成報酬実績情報)を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号(主治医意見書作成報酬実績情報)
     */
    public RString get主治医意見書作成依頼履歴番号_報酬実績情報() {
        return entity.getDbT5602_ikenshoIraiRirekiNo();
    }

    /**
     * 主治医意見書作成料を取得します。
     *
     * @return 主治医意見書作成料
     */
    public int get主治医意見書作成料() {
        return entity.getIkenshoSakuseiryo();
    }

    /**
     * 主治医意見書別途診療費を取得します。
     *
     * @return 主治医意見書別途診療費
     */
    public int get主治医意見書別途診療費() {
        return entity.getIkenshoBettoShinryohi();
    }

    /**
     * 主治医意見書報酬を取得します。
     *
     * @return 主治医意見書報酬
     */
    public int get主治医意見書報酬() {
        return entity.getIkenshoHoshu();
    }

    /**
     * 主治医意見書報酬支払メモを取得します。
     *
     * @return 主治医意見書報酬支払メモ
     */
    public RString get主治医意見書報酬支払メモ() {
        return entity.getHoshuShiharaiMemo();
    }

    /**
     * 銀行振込出力済フラグを取得します。
     *
     * @return 銀行振込出力済フラグ
     */
    public boolean is銀行振込出力済フラグ() {
        return entity.isGinkoFurikomiShutsuryokuFlag();
    }
}
