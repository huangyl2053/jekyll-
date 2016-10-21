package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表のプロパティです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty {

    /**
     * 帳票分類ID「DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo」（仮算定額変更通知書(平準化)）出力順設定可能項目です。
     */
    public enum DBB100012ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"atena_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"atena_choikiCode\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), new RString("\"atesaki_banchi\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"atena_gyoseikuCode\"")),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString(""), new RString("\"atesaki_chiku1\"")),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString(""), new RString("\"atesaki_chiku2\"")),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString(""), new RString("\"atesaki_chiku3\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"atena_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"atena_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"atena_kanaMeisho\"")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), new RString("\"atena_seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), new RString("\"atena_seibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"koseigo_fukaShichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"koseigo_hihokenshaNo\"")),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString(""), new RString("\"nenkinTokuchoKaifuJoho_nenkinCode\"")),
        /**
         * 納組コード
         */
        納組コード(new RString("0208"), new RString(""), new RString("\"caT0714SeikyuHoho_nokumiCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB100012ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
