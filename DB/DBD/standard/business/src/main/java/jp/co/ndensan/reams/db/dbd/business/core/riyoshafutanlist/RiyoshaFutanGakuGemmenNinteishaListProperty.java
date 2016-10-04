/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用情報のプロパティです。
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanGakuGemmenNinteishaListProperty {

    /**
     * 帳票分類ID「DBD200002_RiyoshaFutangakuGemmenGaitoshaIchiran」(DBD介護受給)
     * 出力順設定可能項目です。
     */
    public enum DBD200002_ResultListEnum implements IReportItems {

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
         * 項目ID:0008 フォームフィールド名:世帯コードMyBatis項目名:定義なし
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
        //    世帯コード("0008", "世帯コード", "shikibetsuCode.\"setaiCode\""),
        /**
         * 項目ID:0009 フォームフィールド名:識別コードMyBatis項目名:定義なし
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho_kanaShimei\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("構成市町村マスタ.\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("要介護認定申請情報.\"hihokenshaNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD200002_ResultListEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
