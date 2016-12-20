/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link DbT5207GetProcess}のキーブレイククラスです。
 */
public class DbT5207GetProcessKeyBreakCore {

    private NinteiChosaDataOutputBatchRelateEntity entity;
    private int count = 0;

    /**
     * コンストラクタです。
     */
    public DbT5207GetProcessKeyBreakCore() {
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
     * 通常の処理です。状況連番1～20、状況1～20にセットします。20回ループする前提
     *
     * @param current 現在のEntity
     */
    @SuppressWarnings(value = {"cyclomaticcomplexity", "magicnumber"}) //項目数が20件あるため無視する。
    public void usualProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        count++;
        switch (count) {
            case 1:
                entity = current;
                entity.set状況連番1(current.get状況連番());
                entity.set状況1(current.get状況());
                break;
            case 2:
                entity.set状況連番2(current.get状況連番());
                entity.set状況2(current.get状況());
                break;
            case 3:
                entity.set状況連番3(current.get状況連番());
                entity.set状況3(current.get状況());
                break;
            case 4:
                entity.set状況連番4(current.get状況連番());
                entity.set状況4(current.get状況());
                break;
            case 5:
                entity.set状況連番5(current.get状況連番());
                entity.set状況5(current.get状況());
                break;
            case 6:
                entity.set状況連番6(current.get状況連番());
                entity.set状況6(current.get状況());
                break;
            case 7:
                entity.set状況連番7(current.get状況連番());
                entity.set状況7(current.get状況());
                break;
            case 8:
                entity.set状況連番8(current.get状況連番());
                entity.set状況8(current.get状況());
                break;
            case 9:
                entity.set状況連番9(current.get状況連番());
                entity.set状況9(current.get状況());
                break;
            case 10:
                entity.set状況連番10(current.get状況連番());
                entity.set状況10(current.get状況());
                break;
            case 11:
                entity.set状況連番11(current.get状況連番());
                entity.set状況11(current.get状況());
                break;
            case 12:
                entity.set状況連番12(current.get状況連番());
                entity.set状況12(current.get状況());
                break;
            case 13:
                entity.set状況連番13(current.get状況連番());
                entity.set状況13(current.get状況());
                break;
            case 14:
                entity.set状況連番14(current.get状況連番());
                entity.set状況14(current.get状況());
                break;
            case 15:
                entity.set状況連番15(current.get状況連番());
                entity.set状況15(current.get状況());
                break;
            case 16:
                entity.set状況連番16(current.get状況連番());
                entity.set状況16(current.get状況());
                break;
            case 17:
                entity.set状況連番17(current.get状況連番());
                entity.set状況17(current.get状況());
                break;
            case 18:
                entity.set状況連番18(current.get状況連番());
                entity.set状況18(current.get状況());
                break;
            case 19:
                entity.set状況連番19(current.get状況連番());
                entity.set状況19(current.get状況());
                break;
            case 20:
                entity.set状況連番20(current.get状況連番());
                entity.set状況20(current.get状況());
                break;
            default:
                throw new SystemException("認定調査票（概況調査）サービスの状況テーブルのデータ数が誤っています。21以上存在します。");
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
