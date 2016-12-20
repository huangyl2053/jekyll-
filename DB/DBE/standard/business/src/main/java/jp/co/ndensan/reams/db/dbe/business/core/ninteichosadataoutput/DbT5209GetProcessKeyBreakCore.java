/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link DbT5209GetProcess}のキーブレイククラスです。
 */
public class DbT5209GetProcessKeyBreakCore {

    private NinteiChosaDataOutputBatchRelateEntity entity;
    private int count = 0;

    /**
     * コンストラクタです。
     */
    public DbT5209GetProcessKeyBreakCore() {
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
     * 通常の処理です。状況連番1～2、状況1～2にセットします。2回ループする前提
     *
     * @param current 現在のEntity
     */
    public void usualProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        count++;
        switch (count) {
            case 1:
                entity = current;
                entity.set記入項目連番1(current.get記入項目連番());
                entity.set状況記入1(current.get状況記入());
                break;
            case 2:
                entity.set記入項目連番2(current.get記入項目連番());
                entity.set状況記入2(current.get状況記入());
                break;
            default:
                throw new SystemException("認定調査票（概況調査）記入項目テーブルのデータ数が誤っています。3以上存在します。");
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
