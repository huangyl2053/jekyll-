/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.KogakuKaigoServicehiOshiraseHakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付お知らせ通知書作成のハンドラクラスです。
 *
 * @reamsid DBC-0430-011 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServicehiOshiraseHakkoParameter {

    private FlexibleYearMonth 処理年月;
    private FlexibleDate 作成日;
    private HihokenshaNo 被保険者番号;
    private boolean is申請書発行;
    private boolean isお知らせ通知書発行;
    private boolean is発行一覧表発行;
    private boolean is金融機関表示;
    private long 出力順ID;
    private FlexibleDate 申請日;
    private FlexibleDate 受付日;
    private FlexibleDate 決定日;
    private FlexibleDate 申請書提出期限;
    private RString 抽出条件;
    private RString メニューID;
    private RString 文書番号文字列;
    private boolean is受託あり;

    public enum ShutsuryokuJoken {

        /**
         * 審査年月
         */
        審査年月("審査年月"),
        /**
         * 被保険者番号
         */
        被保険者番号("被保険者番号"),
        /**
         * 白紙
         */
        白紙("白紙");
        private final RString fullName;

        private ShutsuryokuJoken(String fullname) {
            this.fullName = new RString(fullname);
        }

        /**
         * 処理名の名称を返します。
         *
         * @return 処理名の名称
         */
        public RString get名称() {
            return fullName;
        }
    }
}
