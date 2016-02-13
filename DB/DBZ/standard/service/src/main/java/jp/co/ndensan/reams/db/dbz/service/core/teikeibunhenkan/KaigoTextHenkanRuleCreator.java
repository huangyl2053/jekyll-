/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigotoiawasesaki.KaigoToiawsaesakiItem;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.teikeibunhenkan.TextHenkanRuleCreator;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護問合せ先の定型文を変換するクラス
 */
public final class KaigoTextHenkanRuleCreator {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoTextHenkanRuleCreator() {
    }

    /**
     * 定型文変換ルール生成
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     * @return ITextHenkanRule
     */
    public static ITextHenkanRule createRule(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));

        ITextHenkanRule henkanRule = TextHenkanRuleCreator.createOrdinalRule();
        KaigoToiawasesaki 問合せ先 = new KaigoToiawasesakiManager().get介護問合せ先(サブ業務コード, 帳票ID);
        RDate nowDate = RDate.getNowDate();

        henkanRule.add(
                KaigoToiawsaesakiItem.郵便番号.get名称(),
                問合せ先.get郵便番号().value());
        henkanRule.add(
                KaigoToiawsaesakiItem.所在地.get名称(),
                問合せ先.get所在地());
        henkanRule.add(
                KaigoToiawsaesakiItem.庁舎名.get名称(),
                問合せ先.get庁舎名());
        henkanRule.add(
                KaigoToiawsaesakiItem.電話番号.get名称(),
                問合せ先.get電話番号().value());
        henkanRule.add(
                KaigoToiawsaesakiItem.内線番号.get名称(),
                問合せ先.get内線番号());
        henkanRule.add(
                KaigoToiawsaesakiItem.部署名.get名称(),
                問合せ先.get部署名());
        henkanRule.add(
                KaigoToiawsaesakiItem.担当者名.get名称(),
                問合せ先.get担当者名());
        henkanRule.add(
                KaigoToiawsaesakiItem.当年度.get名称(),
                nowDate.getNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        henkanRule.add(
                KaigoToiawsaesakiItem.翌年度.get名称(),
                nowDate.getNendo().plusYear(1).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());

        return henkanRule;
    }
}
