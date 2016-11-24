/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class KogakuKaigoTaishosBusiness {

    /**
     * 帳票分類ID「DBC200100_KogakuServicehiTaishoshaIchiranSokyubun」（高額介護サービス費対象者一覧表（遡及分）） 出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("listTaishosha_12"), new RString("\"郵便番号\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("listTaishosha_13"), new RString("\"町域コード\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("listTaishosha_14"), new RString("\"行政区コード\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("listTaishosha_15"), new RString("\"カナ名称\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("hokenshaNo"), new RString("\"shichosonCode\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("listTaishosha_16"), new RString("証記載保険者番号\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("被保険者番号\"")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString("listTaishosha_17"), new RString("要介護認定状態区分コード\"")),
        /**
         * サービス年月
         */
        サービス年月(new RString("301"), new RString("listTaishosha_3"), new RString("サービス提供年月\""));
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
