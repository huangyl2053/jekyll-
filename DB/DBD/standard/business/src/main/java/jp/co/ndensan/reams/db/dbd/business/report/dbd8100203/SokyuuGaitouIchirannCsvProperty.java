/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd8100203;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果一覧CSV出力のプロパティです。
 *
 * @reamsid_L DBD-4910-050 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuGaitouIchirannCsvProperty {

    /**
     * 帳票分類ID「DBD900004_HikazeiNenkinUmareYMDSeibetsuNameChackList」(DBD介護受給) 出力順設定可能項目です。
     */
    public enum DBD900006_ResultListEnum implements IReportItems {

        /**
         * DT市町村コード
         */
        DT市町村コード(new RString("0425"), new RString("DT市町村コード"), new RString("")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), new RString("")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("")),
        /**
         * 宛名カナ氏名
         */
        宛名カナ氏名(new RString("0437"), new RString("宛名カナ氏名"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("")),
        /**
         * DT郵便番号
         */
        DT郵便番号(new RString("0426"), new RString("DT郵便番号"), new RString("")),
        /**
         * DTカナ氏名
         */
        DTカナ氏名(new RString("0427"), new RString("DTカナ氏名"), new RString("")),
        /**
         * DT生年月日
         */
        DT生年月日(new RString("0428"), new RString("DT生年月日"), new RString("")),
        /**
         * DT性別
         */
        DT性別(new RString("0429"), new RString("DT性別"), new RString("")),
        /**
         * DT年金保険者コード
         */
        DT年金保険者コード(new RString("0430"), new RString("DT年金保険者コード"), new RString("")),
        /**
         * DT基礎年金番号
         */
        DT基礎年金番号(new RString("0431"), new RString("DT基礎年金番号"), new RString("")),
        /**
         * DT年金コード
         */
        DT年金コード(new RString("0432"), new RString("DT年金コード"), new RString("")),
        /**
         * DT対象年
         */
        DT対象年(new RString("0433"), new RString("DT対象年"), new RString("")),
        /**
         * DT訂正表示
         */
        DT訂正表示(new RString("0434"), new RString("DT訂正表示"), new RString("")),
        /**
         * DT各種区分
         */
        DT各種区分(new RString("0435"), new RString("DT各種区分"), new RString("")),
        /**
         * DT処理結果
         */
        DT処理結果(new RString("0436"), new RString("DT処理結果"), new RString(""));
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD900006_ResultListEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
