/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙） Property
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoKattokamiProperty extends ReportPropertyBase<FutanWariaiShoKattokamiSource> {

    /**
     * インスタンスを生成します。
     */
    public FutanWariaiShoKattokamiProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100065.getReportId());
    }

    /**
     * 帳票分類ID「DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo」（仮算定額変更通知書(平準化)）出力順設定可能項目です。
     */
    public enum DBB100065ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"atesaki_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"atesaki_choikiCode\"")),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), new RString("\"atesaki_banchi\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"atesaki_gyoseikuCode\"")),
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
        世帯コード(new RString("0008"), new RString(""), new RString("\"shikibetsuTaisho_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"atesaki_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), new RString("\"shikibetsuTaisho_seinengappiYMD\"")),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), new RString("\"shikibetsuTaisho_seibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"dbT1001HihokenshaDaicho_shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"dbT3113RiyoshaFutanWariai_hihokenshaNo\"")),
        /**
         * 年金コード
         */
        負担割合(new RString("0367"), new RString(""), new RString("\"futanWariKikanTemp_futanWariaiKubun1\"")),
        /**
         * 納組コード
         */
        事業対象者受給者(new RString("0368"), new RString(""), new RString("\"kubun\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB100065ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
