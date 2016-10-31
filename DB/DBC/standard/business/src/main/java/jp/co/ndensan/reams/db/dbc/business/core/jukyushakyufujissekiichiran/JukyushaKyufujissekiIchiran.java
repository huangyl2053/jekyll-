/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績一覧表 のbusinessクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public class JukyushaKyufujissekiIchiran {

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param 導入団体コード 導入団体コード
     * @param 市町村名 市町村名
     * @param 出力順entity 出力順entity
     * @return JukyushaKyufuJissekiIchiranData 受給者給付実績一覧表
     */
    public JukyushaKyufuJissekiIchiranData get受給者給付実績一覧表の帳票情報(
            JukyushaKyufujissekiIchiranRelateEntity entity, RString 導入団体コード, RString 市町村名, ShutsuryokujunRelateEntity 出力順entity) {
        JukyushaKyufuJissekiIchiranData reportEntity = new JukyushaKyufuJissekiIchiranData();
        reportEntity.set作成日時(RDate.getNowDateTime());
        reportEntity.set市町村コード(導入団体コード);
        reportEntity.set市町村名(市町村名);
        reportEntity.set出力順1(出力順entity.get出力順1());
        reportEntity.set出力順2(出力順entity.get出力順2());
        reportEntity.set出力順3(出力順entity.get出力順3());
        reportEntity.set出力順4(出力順entity.get出力順4());
        reportEntity.set出力順5(出力順entity.get出力順5());
        reportEntity.set改頁1(出力順entity.get改頁項目1());
        reportEntity.set改頁2(出力順entity.get改頁項目2());
        reportEntity.set改頁3(出力順entity.get改頁項目3());
        reportEntity.set改頁4(出力順entity.get改頁項目4());
        reportEntity.set改頁5(出力順entity.get改頁項目5());
        reportEntity.set被保険者番号(entity.getShichosonCode());
        reportEntity.set被保険者氏名(entity.get被保険者氏名());
        reportEntity.set要介護度(entity.get要介護状態区分名称());
        reportEntity.setサービス提供年月(new FlexibleYearMonth(entity.getServiceTeikyoYM()));
        reportEntity.set公費負担者1(entity.get公費1_負担者番号());
        reportEntity.set公費受給者1(entity.get公費1_受給者番号());
        reportEntity.setサービス単位数_保険(entity.get後_保険_サービス単位数());
        reportEntity.setサービス単位数_公費1(entity.get後_公費1_サービス単位数());
        reportEntity.set請求額_保険(entity.get後_保険_請求額());
        reportEntity.set請求額_公費1(entity.get後_公費1_請求額());
        reportEntity.set負担額_利用者(entity.get後_保険_利用者負担額());
        reportEntity.set負担額_公費本人1(entity.get後_公費1_本人負担額());
        reportEntity.set緊急時施設療養請求合計額_保険(entity.get後_緊急時施設療養費請求額());
        reportEntity.set緊急時施設療養請求合計額_公費1(entity.get後_公費1_緊急時施設療養費請求額());
        reportEntity.set特定診療請求合計額_保険(entity.get後_保険_特定診療費請求額());
        reportEntity.set特定診療請求合計額_公費1(entity.get後_公費1_特定入所者介護サービス費等請求額());
        reportEntity.set特定入所者介護費等請求額_保険(entity.get後_公費1_特定入所者介護サービス費等請求額());
        reportEntity.set特定入所者介護費等請求額_公費1(entity.get後_公費1_特定入所者介護サービス費等請求額());
        reportEntity.set識別コード(entity.get識別コード());
        reportEntity.set住所(entity.get住所());
        reportEntity.set様式(entity.getMeishoCode());
        reportEntity.set公費負担者2(entity.get公費2_負担者番号());
        reportEntity.set公費受給者2(entity.get公費2_受給者番号());
        reportEntity.setサービス単位数_公費2(entity.get後_公費2_サービス単位数());
        reportEntity.set請求額_公費2(entity.get後_公費2_請求額());
        reportEntity.set負担額_公費本人2(entity.get後_公費2_本人負担額());
        reportEntity.set緊急時施設療養請求合計額_公費2(entity.get後_公費2_緊急時施設療養費請求額());
        reportEntity.set特定診療請求合計額_公費2(entity.get後_公費2_特定入所者介護サービス費等請求額());
        reportEntity.set特定入所者介護費等請求額_公費2(entity.get後_公費2_特定入所者介護サービス費等請求額());
        reportEntity.set審査年月(new FlexibleYearMonth(entity.getShinsaYM()));
        reportEntity.set世帯コード(entity.getSetaiCode());
        reportEntity.set事業者番号(entity.getJigyoshoNo());
        reportEntity.set事業者名称(entity.get事業者名称());
        reportEntity.set実績区分(entity.get給付実績区分名称());
        reportEntity.set公費負担者3(entity.get公費3_負担者番号());
        reportEntity.set公費受給者3(entity.get公費3_受給者番号());
        reportEntity.setサービス単位数_公費3(entity.get後_公費3_サービス単位数());
        reportEntity.set請求額_公費3(entity.get後_公費2_請求額());
        reportEntity.set負担額_公費本人3(entity.get後_公費3_本人負担額());
        reportEntity.set緊急時施設療養請求合計額_公費3(entity.get後_公費3_緊急時施設療養費請求額());
        reportEntity.set特定診療請求合計額_公費3(entity.get後_公費3_特定入所者介護サービス費等請求額());
        reportEntity.set特定入所者介護費等請求額_公費3(entity.get後_公費3_特定入所者介護サービス費等請求額());
        return reportEntity;
    }

    /**
     * 帳票分類ID「DBC200002_JukyushaKyufuJissekiIchiran」（受給者給付実績一覧表）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

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
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("list_hiHokenshaNo"), new RString("\"hiHokenshaNo\"")),
        /**
         * サービス年月
         */
        サービス年月(new RString("0301"), new RString("list_serviceTeikyoYM"), new RString("\"serviceTeikyoYM\"")),
        /**
         * 審査年月
         */
        審査年月(new RString("0402"), new RString("list_shinsaYM"), new RString("\"shinsaYM\"")),
        /**
         * 指定事業者番号
         */
        指定事業者番号(new RString("0303"), new RString("list_jigyoshoNo"), new RString("\"jigyoshoNo\"")),
        /**
         * 現物償還の別
         */
        現物償還の別(new RString("0306"), new RString("list_shoKisaiHokenshaNo"), new RString("\"shoKisaiHokenshaNo\"")),
        /**
         * 様式番号
         */
        様式番号(new RString("0315"), new RString("list_inputShikibetsuNo"), new RString("\"inputShikibetsuNo\"")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString("list_yoKaigoJotaiKubunCode"), new RString("\"yoKaigoJotaiKubunCode\""));

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
