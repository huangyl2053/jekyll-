/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufutsuchigenmenhosei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 給付費通知減免補正一覧表のbusinessクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
public class KyufuhiTsuchiGenmenHosei {

    /**
     * コンストラクタです。
     *
     * @param entity 給付費通知減免補正一覧表情報
     * @param 保険者コード 保険者コード
     * @param 保険者名 保険者名
     * @param 出力順entity 出力順entity
     * @return KyufuhiTuchiGenmenhoseiIchiranEntity 付費通知減免補正一覧表の帳票情報
     */
    public KyufuhiTuchiGenmenhoseiIchiranEntity get給付費通知減免補正一覧表の帳票情報(
            KyufuTsuchiGenmenHoseiEntity entity, RString 保険者コード, RString 保険者名, ShutsuryokujunRelateEntity 出力順entity) {
        KyufuhiTuchiGenmenhoseiIchiranEntity reportEntity = new KyufuhiTuchiGenmenhoseiIchiranEntity();
        reportEntity.set保険者コード(保険者コード);
        reportEntity.set保険者名(保険者名);
        reportEntity.set出力順1(出力順entity.get出力順1());
        reportEntity.set出力順2(出力順entity.get出力順2());
        reportEntity.set出力順3(出力順entity.get出力順3());
        reportEntity.set出力順4(出力順entity.get出力順4());
        reportEntity.set出力順5(出力順entity.get出力順5());
        reportEntity.set改ページ条件1(出力順entity.get改頁項目1());
        reportEntity.set改ページ条件2(出力順entity.get改頁項目2());
        reportEntity.set改ページ条件3(出力順entity.get改頁項目3());
        reportEntity.set改ページ条件4(出力順entity.get改頁項目4());
        reportEntity.set改ページ条件5(出力順entity.get改頁項目5());
        reportEntity.set被保険者番号(entity.getHiHokenshaNo().value());
        reportEntity.set被保険者名(entity.getMeisho());
        reportEntity.set年月(getパターン54(entity.getServiceTeikyoYM()));
        reportEntity.setサービス事業者コード(entity.getJigyoshoNo().value());
        reportEntity.setサービス事業者(entity.getJigyoshaName());
        reportEntity.setサービス種類コード(entity.getServiceShuruiCode().value());
        reportEntity.setサービス種類(entity.getServiceShuruiMeisho());
        reportEntity.set利用者負担額(entity.getRiyoshaFutangaku());
        reportEntity.setサービス費用(entity.getServiceHiyoTotal());
        return reportEntity;
    }

    private RString getパターン54(FlexibleYearMonth サービス提供年月) {
        if (サービス提供年月 == null || サービス提供年月.isEmpty()) {
            return RString.EMPTY;
        }
        return サービス提供年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 帳票分類ID「DBC200043_KyufuhiTuchiGenmenhoseiIchiran」（給付費通知減免補正一覧表）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("list_yubinNo"), new RString("\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("list_choikiCode"), new RString("\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("list_gyoseikuCode"), new RString("\"gyoseikuCode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("list_setaiCode"), new RString("\"setaiCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("list_kanaMeisho"), new RString("\"kanaMeisho\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("list_shichosonCode"), new RString("\"shichosonCode\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("list_shoKisaiHokenshaNo"), new RString("\"shoKisaiHokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("list_1"), new RString("\"hiHokenshaNo\""));

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
