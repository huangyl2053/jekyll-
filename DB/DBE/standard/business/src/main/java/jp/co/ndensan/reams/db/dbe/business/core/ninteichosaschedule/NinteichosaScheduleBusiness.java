/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosaschedule;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichousasukejuru.NinteiChousaSukejuruRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 認定調査スケジュール登録1を管理するクラスです。
 */
public class NinteichosaScheduleBusiness {

    private final NinteiChousaSukejuruRelateEntity entity;

    /**
     * 認定調査スケジュール登録1項目を返します。
     *
     * @param entity NinnteiChousairaiEntity
     */
    public NinteichosaScheduleBusiness(NinteiChousaSukejuruRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 全午前件数を返します。
     *
     * @return 全午前件数
     */
    public int get全午前件数() {
        return entity.get全午前件数();
    }

    /**
     * 全午後件数を返します。
     *
     * @return 全午後件数
     */
    public int get全午後件数() {
        return entity.get全午後件数();
    }

    /**
     * 午前の仮予約件数を返します。
     *
     * @return 午前の仮予約件数
     */
    public int get午前の仮予約件数() {
        return entity.get午前の仮予約件数();
    }

    /**
     * 午後の仮予約件数を返します。
     *
     * @return 午後の仮予約件数
     */
    public int get午後の仮予約件数() {
        return entity.get午後の仮予約件数();
    }

    /**
     * 午前の確定件数を返します。
     *
     * @return 午前の確定件数
     */
    public int get午前の確定件数() {
        return entity.get午前の確定件数();
    }

    /**
     * 午後の確定件数を返します。
     *
     * @return 午後の確定件数
     */
    public int get午後の確定件数() {
        return entity.get午後の確定件数();
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.get認定調査予定年月日();
    }

    /**
     * メモ年月日を返します。
     *
     * @return メモ年月日
     */
    public FlexibleDate getメモ年月日() {
        return entity.getメモ年月日();
    }

    /**
     * 通常メモ件数を返します。
     *
     * @return 通常メモ件数
     */
    public int get通常メモ件数() {
        return entity.get通常メモ件数();
    }

    /**
     * 重要メモ件数を返します。
     *
     * @return 重要メモ件数
     */
    public int get重要メモ件数() {
        return entity.get重要メモ件数();
    }

}
