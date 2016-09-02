/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.hanyolistkogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * バッチ設計_DBCBT23015_汎用リスト出力(高額合算自己負担額情報) Property
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
public class HanyoListKogakuGassanJikoFutangakuProperty extends ReportPropertyBase<FutanWariaiShoKattokamiSource> {

    /**
     * インスタンスを生成します。
     */
    public HanyoListKogakuGassanJikoFutangakuProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701015.getReportId());
    }

    /**
     * 帳票分類ID「DBC701015_HanyoList_KogakuGassanJikoFutangaku」出力順設定可能項目です。
     */
    public enum DBC701015HanyoList_KogakuGassanJikoFutangaku implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString(""), new RString("\"高額合算自己負担額_保険者番号\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0360"), new RString(""), new RString("\"高額合算自己負担額_被保険者番号\"")),
        /**
         * 対象年度
         */
        対象年度(new RString("0334"), new RString(""), new RString("\"高額合算自己負担額_対象年度\"")),
        /**
         * 申請書整理番号
         */
        申請書整理番号(new RString("0337"), new RString(""), new RString("\"高額合算自己負担額_支給申請書整理番号\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC701015HanyoList_KogakuGassanJikoFutangaku(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
