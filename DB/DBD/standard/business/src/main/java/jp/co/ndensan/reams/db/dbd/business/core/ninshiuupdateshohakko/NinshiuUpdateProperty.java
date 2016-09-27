/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninshiuupdateshohakko;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用情報のプロパティです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinshiuUpdateProperty {

    /**
     * 帳票分類ID「DBD511002_KoshinShinseiTsuchishoHakkoIchiranhyo」(DBD介護受給) 出力順設定可能項目です。
     */
    public enum DBD511002_ResultListEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"ShikibetsuTaisho_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("\"ShikibetsuTaisho_choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho_kanaShimei\"")),
        /**
         * 氏名50音ｶﾅ(送付先)
         */
        //        氏名50音ｶﾅ_送付先(new RString("0015"), new RString("氏名50音ｶﾅ(送付先)"), new RString("")), // QA #101093
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"dbT7051KoseiShichosonMaster_shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"dbT4101NinteiShinseiJoho_hihokenshaNo\""));
        /**
         * 指定事業者番号
         */
//        指定事業者番号(new RString("0303"), new RString("指定事業者番号"), new RString("")), // QA #101093
        /**
         * 計画事業者番号
         */
//        計画事業者番号(new RString("0311"), new RString("計画事業者番号"), new RString("")); // QA #101093
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD511002_ResultListEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
