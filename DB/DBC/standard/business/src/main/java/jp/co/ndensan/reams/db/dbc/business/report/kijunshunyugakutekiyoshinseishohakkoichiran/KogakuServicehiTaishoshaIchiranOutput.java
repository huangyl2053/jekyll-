/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費対象者一覧表Output
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class KogakuServicehiTaishoshaIchiranOutput {

    /**
     * 高額介護サービス費対象者一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"ShikibetsuTaisho\".\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho\".\"katakanaHyoki\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("master.市町村コード")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("master.証記載保険者番号")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("master.被保険者番号")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString("要介護度"), new RString("master.要介護認定状態区分コード")),
        /**
         * サービス提供年月
         */
        サービス提供年月(new RString("0301"), new RString("サービス提供年月"), new RString("master.サービス提供年月"));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
