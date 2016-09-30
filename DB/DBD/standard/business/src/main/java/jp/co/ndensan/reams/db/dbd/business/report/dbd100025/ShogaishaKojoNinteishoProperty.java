/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link NinteishoJohoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoProperty extends ReportPropertyBase<NinteishoJohoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShogaishaKojoNinteishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId());
    }

    /**
     * 帳票分類ID「DBD100025_ShogaishaKojoNinteisho」（障害者控除認定書）出力順設定可能項目です。
     */
    public enum DBD100025ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"ShikibetsuTaisho_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"ShikibetsuTaisho_choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("T4001.\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("被保険者番号"));
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD100025ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
