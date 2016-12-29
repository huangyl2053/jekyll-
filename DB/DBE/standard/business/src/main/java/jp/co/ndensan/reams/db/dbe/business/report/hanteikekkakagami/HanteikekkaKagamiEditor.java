/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査判定結果（鑑）Editorです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiEditor implements IHanteikekkaKagamiEditor {

    private final HanteikekkaKagamiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteikekkaKagamiEntity}
     */
    protected HanteikekkaKagamiEditor(HanteikekkaKagamiEntity item) {
        this.item = item;
    }

    @Override
    public HanteikekkaKagamiReportSource edit(HanteikekkaKagamiReportSource source) {
        if (item != null) {
            editCompNinshosha(source);
            source.title = DbBusinessConfig
                    .get(ConfigNameDBE.介護認定審査判定結果_鑑, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            source.shinsakaiKaisaiYMD = item.getShinsakaiKaisaiYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            source.shimeiText = ZanteiAtenaText.toValue(item.getShoKisaiHokenshaNo().value()).首長宛名文字列;
            source.gogitaiNo = new RString(item.getGogitaiNo());
            source.tsuchibun1 = item.getTsuchibun1();
            source.tsuchibun2 = item.getTsuchibun2();
        }
        return source;
    }

    private void editCompNinshosha(HanteikekkaKagamiReportSource source) {
        if (item.getNinshoshaSource() != null) {
            source.hakkoYMD1 = new RDate(item.getNinshoshaSource().hakkoYMD.toString()).wareki()
                    .eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
            source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
            source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
            source.ninshoshaYakushokuMei = item.getNinshoshaSource().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        }
    }

    /**
     * TODO 構成市町村の首長名等を管理する方法を検討中であるため、
     * 20161228現在は北信広域連合向けの暫定対応として当列挙型により首長の宛名を管理する。
     */
    public enum ZanteiAtenaText {

        中野市長(new RString("202119"), new RString("中野市長　池田　茂　様")),
        飯山市長(new RString("202135"), new RString("飯山市長　足立　正則　様")),
        山ノ内町長(new RString("205617"), new RString("山ノ内町長　竹節　義孝　様")),
        木島平村長(new RString("205625"), new RString("木島平村長　日䑓　正博　様")),
        野沢温泉村長(new RString("205633"), new RString("野沢温泉村長　富井　俊雄　様")),
        栄村長(new RString("206029"), new RString("栄村長　森川　浩市　様"));
        private final RString 証記載保険者番号;
        private final RString 首長宛名文字列;

        private ZanteiAtenaText(RString 証記載保険者番号, RString 首長宛名文字列) {
            this.証記載保険者番号 = 証記載保険者番号;
            this.首長宛名文字列 = 首長宛名文字列;
        }

        /**
         * 証記載保険者番号を返します。
         *
         * @return 証記載保険者番号
         */
        public RString get証記載保険者番号() {
            return 証記載保険者番号;
        }

        /**
         * 首長宛名文字列を返します。
         *
         * @return 首長宛名文字列
         */
        public RString get首長宛名文字列() {
            return 首長宛名文字列;
        }

        /**
         * 証記載保険者番号のコードと一致する内容を探します。
         *
         * @param 証記載保険者番号 証記載保険者番号
         * @return 構成市町村の首長名
         */
        public static ZanteiAtenaText toValue(RString 証記載保険者番号) {

            for (ZanteiAtenaText zanteiAtenaText : ZanteiAtenaText.values()) {
                if (zanteiAtenaText.証記載保険者番号.equals(証記載保険者番号)) {
                    return zanteiAtenaText;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("証記載保険者番号"));
        }
    }
}
