/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link DbT5210GetProcess}のキーブレイククラスです。
 */
public class DbT5210GetProcessKeyBreakCore {

    private NinteiChosaDataOutputBatchRelateEntity entity;
    private int count = 0;

    /**
     * コンストラクタです。
     */
    public DbT5210GetProcessKeyBreakCore() {
        entity = new NinteiChosaDataOutputBatchRelateEntity();
    }

    /**
     * キーブレイク処理です。申請書管理番号が異なるときにキーブレイク処理を行います。
     *
     * @param before 1レコード前のEntity
     * @param current 現在のEntity
     * @return キーブレイク処理を行うEntity
     */
    public NinteiChosaDataOutputBatchRelateEntity keyBreakProcess(
            NinteiChosaDataOutputBatchRelateEntity before, NinteiChosaDataOutputBatchRelateEntity current) {
        if (!before.get申請書管理番号().equals(current.get申請書管理番号())) {
            count = 0;
            return entity;
        }
        return null;
    }

    /**
     * 通常の処理です。施設利用連番1～9、施設利用フラグ1～9にセットします。9回ループする前提
     *
     * @param current 現在のEntity
     */
    @SuppressWarnings(value = { "magicnumber"}) //他で使用しない数値のため
    public void usualProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        count++;
        switch (count) {
            case 1:
                entity = current;
                entity.set施設利用連番1(current.get施設利用連番());
                entity.set施設利用フラグ1(current.get施設利用フラグ());
                break;
            case 2:
                entity.set施設利用連番2(current.get施設利用連番());
                entity.set施設利用フラグ2(current.get施設利用フラグ());
                break;
            case 3:
                entity.set施設利用連番3(current.get施設利用連番());
                entity.set施設利用フラグ3(current.get施設利用フラグ());
                break;
            case 4:
                entity.set施設利用連番4(current.get施設利用連番());
                entity.set施設利用フラグ4(current.get施設利用フラグ());
                break;
            case 5:
                entity.set施設利用連番5(current.get施設利用連番());
                entity.set施設利用フラグ5(current.get施設利用フラグ());
                break;
            case 6:
                entity.set施設利用連番6(current.get施設利用連番());
                entity.set施設利用フラグ6(current.get施設利用フラグ());
                break;
            case 7:
                entity.set施設利用連番7(current.get施設利用連番());
                entity.set施設利用フラグ7(current.get施設利用フラグ());
                break;
            case 8:
                entity.set施設利用連番8(current.get施設利用連番());
                entity.set施設利用フラグ8(current.get施設利用フラグ());
                break;
            case 9:
                entity.set施設利用連番9(current.get施設利用連番());
                entity.set施設利用フラグ9(current.get施設利用フラグ());
                break;
            default:
                throw new SystemException("認定調査票（概況調査）施設利用テーブルのデータ数が誤っています。10以上存在します。");
        }
    }

    /**
     * 最終行の処理です。処理対象のEntityを返します。
     *
     * @return 処理対象のEntity
     */
    public NinteiChosaDataOutputBatchRelateEntity getLastLow() {
        return entity;
    }
}
