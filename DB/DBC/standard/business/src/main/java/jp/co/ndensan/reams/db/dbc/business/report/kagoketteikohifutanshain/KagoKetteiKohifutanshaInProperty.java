/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource.ReportSourceFields;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 過誤決定通知書情報取込一覧表（公費負担者分）帳票のプロパティです。
 *
 * @reamsid_L DBC-0980-510 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiKohifutanshaInProperty
        extends ReportPropertyBase<KagoKetteiKohifutanshaInSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public KagoKetteiKohifutanshaInProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200051.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ReportSourceFields.kohiFutanshaNo.name()));
    }

    /**
     * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表 出力順設定可能項目です。
     */
    public enum KagoKetteiKohifutanshaInBreakerFieldsEnum implements IReportItems {

        /**
         * 公費負担者番号
         */
        公費負担者番号(new RString("0134"), new RString("kohiFutanshaNo"), new RString("DbWT3060.\"hdrShoHokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0360"), new RString("listLower_2"), new RString("DbWT0001.\"hihokenshaNo\"")),
        /**
         * サービス提供年月
         */
        サービス提供年月(new RString("0361"), new RString("listUpper_6"), new RString("DbWT3061.\"serviceTeikyoYm\"")),
        /**
         * 事業所番号
         */
        事業所番号(new RString("0362"), new RString("listUpper_3"), new RString("DbWT3061.\"jigyoshoNo\"")),
        /**
         * 取り扱い年月
         */
        取り扱い年月(new RString("0363"), new RString("listUpper_2"), new RString("DbWT3061.\"toriatsukaiYm\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private KagoKetteiKohifutanshaInBreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
