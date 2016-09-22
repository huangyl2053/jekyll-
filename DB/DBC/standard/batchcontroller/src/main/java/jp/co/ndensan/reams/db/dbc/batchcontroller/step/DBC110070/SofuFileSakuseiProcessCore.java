/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaTmpEntity;

/**
 * 処理ロジッククラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuFileSakuseiProcessCore {

    private KogakuGassanKeisanKekkaRenrakuJohoRelateEntity 連絡票情報;
    private KogakuGassanShikyuGakuKeisanKekkaRelateEntity 高額合算支給額計算結果;

    /**
     * 値の設定です。
     *
     * @param before 前レコード
     * @param current currentレコード
     * @return KogakuGassanKeisanKekkaRenrakuJohoRelateEntity
     */
    public KogakuGassanKeisanKekkaRenrakuJohoRelateEntity keyBreakProcess(KogakuGassanKeisanKekkaRenrakuJohoTmpEntity before,
            KogakuGassanKeisanKekkaRenrakuJohoTmpEntity current) {
        if (連絡票情報 == null) {
            連絡票情報 = new KogakuGassanKeisanKekkaRenrakuJohoRelateEntity();
            連絡票情報.set高額合算支給額計算結果一時(before.get高額合算支給額計算結果一時());
            連絡票情報.set被保険者一時(before.get被保険者一時());
            連絡票情報.get高額合算支給額計算結果明細リスト().add(before.get高額合算支給額計算結果明細());
        }
        if (before.get高額合算支給額計算結果一時().getRenban() == current.get高額合算支給額計算結果一時().getRenban()) {
            連絡票情報.get高額合算支給額計算結果明細リスト().add(current.get高額合算支給額計算結果明細());
        } else {
            KogakuGassanKeisanKekkaRenrakuJohoRelateEntity tmpEntity = 連絡票情報;
            連絡票情報 = new KogakuGassanKeisanKekkaRenrakuJohoRelateEntity();
            連絡票情報.set高額合算支給額計算結果一時(current.get高額合算支給額計算結果一時());
            連絡票情報.set被保険者一時(current.get被保険者一時());
            連絡票情報.get高額合算支給額計算結果明細リスト().add(current.get高額合算支給額計算結果明細());
            return tmpEntity;
        }
        return null;
    }

    /**
     * データを取得します。
     *
     * @return KogakuGassanKeisanKekkaRenrakuJohoRelateEntity
     */
    public KogakuGassanKeisanKekkaRenrakuJohoRelateEntity getFinal連絡票情報() {
        return this.連絡票情報;
    }

    /**
     * 値の設定です。
     *
     * @param before 前レコード
     * @param current currentレコード
     * @return KogakuGassanShikyuGakuKeisanKekkaRelateEntity
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateEntity keyBreakProcess２(KogakuGassanShikyuGakuKeisanKekkaTmpEntity before,
            KogakuGassanShikyuGakuKeisanKekkaTmpEntity current) {
        if (高額合算支給額計算結果 == null) {
            高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekkaRelateEntity();
            高額合算支給額計算結果.set高額合算支給額計算結果(before.get高額合算支給額計算結果());
            高額合算支給額計算結果.get高額合算支給額計算結果明細リスト().add(before.get高額合算支給額計算結果明細());
        }
        if (before.get高額合算支給額計算結果().equalsPrimaryKeys(current.get高額合算支給額計算結果())) {
            高額合算支給額計算結果.get高額合算支給額計算結果明細リスト().add(current.get高額合算支給額計算結果明細());
        } else {
            KogakuGassanShikyuGakuKeisanKekkaRelateEntity tmpEntity = 高額合算支給額計算結果;
            高額合算支給額計算結果 = new KogakuGassanShikyuGakuKeisanKekkaRelateEntity();
            高額合算支給額計算結果.set高額合算支給額計算結果(current.get高額合算支給額計算結果());
            高額合算支給額計算結果.get高額合算支給額計算結果明細リスト().add(current.get高額合算支給額計算結果明細());
            return tmpEntity;
        }
        return null;
    }

    /**
     * データを取得します。
     *
     * @return KogakuGassanShikyuGakuKeisanKekkaRelateEntity
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateEntity getFinal高額合算支給額計算結果() {
        return this.高額合算支給額計算結果;
    }
}
