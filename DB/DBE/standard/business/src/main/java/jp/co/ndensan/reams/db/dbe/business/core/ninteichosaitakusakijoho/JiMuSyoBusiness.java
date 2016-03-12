/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiMuSyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事務所の場合で認定調査スケジュール登録9Businessです。
 */
public class JiMuSyoBusiness {

    private final JiMuSyoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link JiMuSyoEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link NinteiChosainMasterRelateEntity}
     */
    public JiMuSyoBusiness(JiMuSyoEntity entity) {
        this.entity = entity;
    }

    /**
     * Temp_ninteiChosaYoteiYMDを返します。
     *
     * @return Temp_ninteiChosaYoteiYMD
     */
    public FlexibleDate get認定調査予定日() {
        return entity.getTemp_ninteiChosaYoteiYMD();
    }

    /**
     * 空きの午前イメージを返します。
     *
     * @return 空きの午前イメージ
     */
    public RString get空きの午前イメージ() {
        return entity.get空きの午前イメージ();
    }

    /**
     * 空きの午前件数を返します。
     *
     * @return 空きの午前件数
     */
    public int get空きの午前件数() {
        return entity.get空きの午前件数();
    }

    /**
     * 空きの午後イメージを返します。
     *
     * @return 空きの午後イメージ
     */
    public RString get空きの午後イメージ() {
        return entity.get空きの午後イメージ();
    }

    /**
     * 空きの午後件数を返します。
     *
     * @return 空きの午後件数
     */
    public int get空きの午後件数() {
        return entity.get空きの午後件数();
    }

    /**
     * 仮予約の午前イメージを返します。
     *
     * @return 仮予約の午前イメージ
     */
    public RString get仮予約の午前イメージ() {
        return entity.get仮予約の午前イメージ();
    }

    /**
     * 仮予約の午前件数を返します。
     *
     * @return 仮予約の午前件数
     */
    public int get仮予約の午前件数() {
        return entity.get仮予約の午前件数();
    }

    /**
     * 仮予約の午後イメージを返します。
     *
     * @return 仮予約の午後イメージ
     */
    public RString get仮予約の午後イメージ() {
        return entity.get仮予約の午後イメージ();
    }

    /**
     * 仮予約の午後件数を返します。
     *
     * @return 仮予約の午後件数
     */
    public int get仮予約の午後件数() {
        return entity.get仮予約の午後件数();
    }

    /**
     * 確定の午前イメージを返します。
     *
     * @return 確定の午前イメージ
     */
    public RString get確定の午前イメージ() {
        return entity.get確定の午前イメージ();
    }

    /**
     * 確定の午前件数を返します。
     *
     * @return 確定の午前件数
     */
    public int get確定の午前件数() {
        return entity.get確定の午前件数();
    }

    /**
     * 確定の午後イメージを返します。
     *
     * @return 確定の午後イメージ
     */
    public RString get確定の午後イメージ() {
        return entity.get確定の午後イメージ();
    }

    /**
     * 確定の午後件数を返します。
     *
     * @return 確定の午後件数
     */
    public int get確定の午後件数() {
        return entity.get確定の午後件数();
    }
}
