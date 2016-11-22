/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.riyojokyotokeihyomeisailist;

import jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator.IBreakPageColumnMapping;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況一覧表Outputです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class RiyoJokyoIchiranOutput {

    /**
     * 利用状況一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("DbWT1513RiyoJokyoTokeihyo.\"hihokenshaNo\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("DbWT1513RiyoJokyoTokeihyo.\"shimei50onKana\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("DbWT1513RiyoJokyoTokeihyo.\"shikibetsuCode\"")),
        /**
         * 識別コード
         */
        サービス年月(new RString("0364"), new RString("サービス提供年月"), new RString("DbWT1513RiyoJokyoTokeihyo.\"serviceTeikyoYM\"")),
        /**
         * 要介護度
         */
        要介護度(new RString("0373"), new RString("要介護度"), new RString("DbWT1513RiyoJokyoTokeihyo.\"yoKaigoJotaiKubunCode\""));

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

    /**
     * 帳票「利用状況一覧表」を表す列挙型です。
     */
    public enum BreakPageRelateItem implements IBreakPageColumnMapping {

        /**
         * 保険者番号
         */
        hihokennshaNo("hihokennshaNo", "被保険者番号", "list1Upper_1"),
        /**
         * 氏名５０音カナ
         */
        shimei50onKana("shimei50onKana", "氏名５０音カナ", "list1Lower_2"),
        /**
         * 識別コード
         */
        shikibetsuCode("shikibetsuCode", "識別コード", "list1Lower_1"),
        /**
         * サービス年月
         */
        serviceTeikyoYM("serviceTeikyoYM", "サービス年月", "list1Lower_3"),
        /**
         * 要介護度
         */
        yoKaigoJotaiKubunCode("yoKaigoJotaiKubunCode", "要介護度", "listGokeiJoho_2");

        private final RString column;
        private final RString item;
        private final RString breakPageName;

        /**
         * コンストラクタです。
         *
         * @param column 項目名
         * @param tableName テーブル名
         */
        BreakPageRelateItem(String column, String item, String breakPageName) {
            this.column = new RString(column);
            this.item = new RString(item);
            this.breakPageName = new RString(breakPageName);
        }

        @Override
        public RString getColumn() {
            return this.column;
        }

        @Override
        public RString getItem() {
            return this.item;
        }

        @Override
        public RString getBreakPageName() {
            return this.breakPageName;
        }

        @Override
        public BreakPageRelateItem toValue(RString item) {
            for (BreakPageRelateItem relateitem : BreakPageRelateItem.values()) {
                if (relateitem.item.equals(item)) {
                    return relateitem;
                }
            }
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("該当の項目名").toString());
        }
    }
}
