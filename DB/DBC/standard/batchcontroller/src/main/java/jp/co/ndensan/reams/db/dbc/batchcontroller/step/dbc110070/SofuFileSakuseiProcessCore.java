/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoTmpEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaTmpEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理ロジッククラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuFileSakuseiProcessCore {

    private static final RString ENCLOSURE = new RString("\"");
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

    /**
     * 帳票分類ID「DBC200036_GassanShikyugakuKeisankekkaRanrakuhyoSofuIchiran」<br>
     * 高額合算支給額計算結果連絡票情報送付一覧表の出力順設定可能項目です。
     */
    public enum DBC200036GassanShikyugakuKeisankekkaRanrakuhyoSofuIchiranEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT1001Hihokensha_yubinNo").concat(ENCLOSURE))),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT1001Hihokensha_choikiCode").concat(ENCLOSURE))),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT1001Hihokensha_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT1001Hihokensha_shimei50onKana").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT1001Hihokensha_shichosonCode").concat(ENCLOSURE))),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT3811_shoKisaiHokenshaNo").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT3811_hihokenshaNo").concat(ENCLOSURE))),
        /**
         * 対象年度
         */
        対象年度(new RString("0334"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT3811_taishoNendo").concat(ENCLOSURE))),
        /**
         * 申請書整理番号
         */
        申請書整理番号(new RString("0337"), new RString(""),
                ENCLOSURE.concat(new RString("dbWT3811_shikyuShinseishoSeiriNo").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200036GassanShikyugakuKeisankekkaRanrakuhyoSofuIchiranEnum(
                RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
