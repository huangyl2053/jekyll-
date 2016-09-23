/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoTmpEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理ロジッククラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public class HanyoListFukaDaichoProcessCore {

    private static final RString ENCLOSURE = new RString("\"");

    private HanyoListFukaDaichoEntity 賦課台帳;

    /**
     * 値の設定です。
     *
     * @param before 前レコード
     * @param current currentレコード
     * @return HanyoListFukaDaichoEntity
     */
    public HanyoListFukaDaichoEntity keyBreakProcess(HanyoListFukaDaichoTmpEntity before,
            HanyoListFukaDaichoTmpEntity current) {
        if (賦課台帳 == null) {
            賦課台帳 = new HanyoListFukaDaichoEntity();
            賦課台帳.set介護賦課(before.get介護賦課());
            賦課台帳.get調定共通リスト().add(before.get調定共通());
            賦課台帳.get介護期別リスト().add(before.get介護期別());
            賦課台帳.set介護徴収方法(before.get介護徴収方法());
            賦課台帳.set受給者台帳Newest(before.get受給者台帳Newest());
            賦課台帳.set被保険者台帳管理Newest(before.get被保険者台帳管理Newest());
            賦課台帳.set宛名(before.get宛名());
            賦課台帳.set宛先(before.get宛先());
            賦課台帳.set特別徴収義務者コード(before.get特別徴収義務者コード());
            賦課台帳.set本算定後(before.is本算定後());
        }
        if (before.get介護賦課().getChoteiNendo().compareTo(current.get介護賦課().getChoteiNendo()) == 0
                && before.get介護賦課().getFukaNendo().compareTo(current.get介護賦課().getFukaNendo()) == 0
                && before.get介護賦課().getRirekiNo() == current.get介護賦課().getRirekiNo()
                && before.get介護賦課().getTsuchishoNo().equals(current.get介護賦課().getTsuchishoNo())) {
            賦課台帳.get調定共通リスト().add(current.get調定共通());
            賦課台帳.get介護期別リスト().add(current.get介護期別());
        } else {
            HanyoListFukaDaichoEntity tmpEntity = 賦課台帳;
            賦課台帳 = new HanyoListFukaDaichoEntity();
            賦課台帳.set介護賦課(current.get介護賦課());
            賦課台帳.get調定共通リスト().add(current.get調定共通());
            賦課台帳.get介護期別リスト().add(current.get介護期別());
            賦課台帳.set介護徴収方法(current.get介護徴収方法());
            賦課台帳.set受給者台帳Newest(current.get受給者台帳Newest());
            賦課台帳.set被保険者台帳管理Newest(current.get被保険者台帳管理Newest());
            賦課台帳.set宛名(current.get宛名());
            賦課台帳.set宛先(current.get宛先());
            賦課台帳.set特別徴収義務者コード(current.get特別徴収義務者コード());
            賦課台帳.set本算定後(current.is本算定後());
            return tmpEntity;
        }
        return null;
    }

    /**
     * データを取得します。
     *
     * @return HanyoListFukaDaichoEntity
     */
    public HanyoListFukaDaichoEntity getFinal賦課台帳() {
        return this.賦課台帳;
    }

    /**
     * 帳票分類ID「DBB200033_HanyoListFukaDaicho」汎用リスト 賦課台帳の出力順設定可能項目です。
     */
    public enum DBB200033HanyoListFukaDaichoEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_choikiCode").concat(ENCLOSURE))),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_setaiCode").concat(ENCLOSURE))),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_shikibetsuCode").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_kanaShimei").concat(ENCLOSURE))),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""),
                ENCLOSURE.concat(new RString("ShikibetsuTaisho_seinengappiYMD").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""),
                ENCLOSURE.concat(new RString("dbV4001JukyushaDaicho_shichosonCode").concat(ENCLOSURE))),
        /**
         * 保険料段階
         */
        保険料段階(new RString("0201"), new RString(""),
                ENCLOSURE.concat(new RString("dbT2002Fuka_hokenryoDankai").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""),
                ENCLOSURE.concat(new RString("dbT2002Fuka_hihokenshaNo").concat(ENCLOSURE))),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString(""),
                ENCLOSURE.concat(new RString("dbV4001JukyushaDaicho_yokaigoJotaiKubunCode").concat(ENCLOSURE))),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString(""),
                ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_nenkinCode").concat(ENCLOSURE))),
        /**
         * 年金番号
         */
        年金番号(new RString("0207"), new RString(""),
                ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_kisoNenkinNo").concat(ENCLOSURE))),
        /**
         * 徴収方法
         */
        徴収方法(new RString("0209"), new RString(""),
                ENCLOSURE.concat(new RString("dbT2003Kibetsu_choshuHouhou").concat(ENCLOSURE))),
        /**
         * 生活保護種別
         */
        生活保護種別(new RString("0116"), new RString(""),
                ENCLOSURE.concat(new RString("dbT2002Fuka_seihofujoShurui").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200033HanyoListFukaDaichoEnum(
                RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
