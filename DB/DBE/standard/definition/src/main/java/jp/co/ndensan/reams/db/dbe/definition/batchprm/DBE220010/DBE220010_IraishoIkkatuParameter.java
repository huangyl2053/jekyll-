/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 依頼書一括発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE220010_IraishoIkkatuParameter extends BatchParameterBase {

    private static final long serialVersionUID = 5290964985893247352L;
    private static final String IRAIFROMYMD = "iraibiFrom";
    private static final String IRAITOYMD = "iraibiTo";
    private static final String NINTEIO_CHOSA_IRAISHO = "ninteioChosaIraisho";
    private static final String NINTEI_CHOSAHYO = "ninteiChosahyo";
    private static final String SHUJIIIKENSHO_SAKUSEI_IRAI = "shujiiIkenshoSakuseiIraisho";
    private static final String SHUJIIIKENSHO = "shujiiIkensho";
    private static final String HAKKOBI = "hakkobi";
    private static final String TEISHUTSU_KIGEN = "teishutsuKigen";
    private static final String KYOTSU_HIZUKE = "kyotsuHizuke";
    private static final String IS_NINTEI_CHOSA_IRAI_ICHIRAN = "isNinteiChosaIraiIchiran";
    private static final String NINTEI_CHOSAIRAI_HAKKO = "ninteiChosairaiHakko";
    private static final String IKENSHO_SAKUSEIIRAI = "ikenshoSakuseiirai";
    private static final String IKENSHO_SAKUSEI_SEIKYU = "ikenshoSakuseiSeikyuu";
    private static final String IKENSHO_SAKUSEI_IRAISHO = "shujiiIkenshoSakuseiIraisho";
    private static final String IKENSHO_KINYU = "ikenshoKinyuu";
    private static final String IKENSHO_SAKUSEI_SEIKYUSHO = "ikenshoSakuseiSeikyuusho";
    private static final String IKENSHO_SAKUSEI_IRAI_HAKKO = "ikenshoSakuseiIraiHakkou";
    private static final String NINTEICHOSAIRAILIST = "ninteiChosaIraiList";
    private static final String SHUJIIIKENSHOSAKUSEIIRAILIST = "shujiiIkenshoSakuseiIraiList";
    private static final String 認定調査依頼履歴一覧 = "認定調査依頼履歴一覧";
    private static final String 主治医意見書作成依頼履歴一覧 = "主治医意見書作成依頼履歴一覧";
    private static final String 文書番号 = "文書番号";
    private static final String 市町村コード = "市町村コード";
    private static final String IS_NINTEI_CHOSA_IRAISHO = "isNinteiChosaIraisho";
    private static final String IS_NINTEI_CHOSAHYO_GAIKYO = "isNinteiChosahyoGaikyo";
    private static final String IS_NINTEI_CHOSAHYO_KIHON = "isNinteiChosahyoKihon";
    private static final String IS_NINTEI_CHOSAHYO_TOKKI = "isNinteiChosahyoTokki";
    private static final String IS_NINTEI_CHOSAHYO_GAIKYOKIHON = "isNinteiChosahyoGaikyoKihon";
    private static final String IS_NINTEI_CHOSAHYO_GAIKYOTOKKI = "isNinteiChosahyoGaikyoTokki";
    private static final String IS_NINTEI_CHOSA_CHECK_HYO = "isNinteiChosaCheckHyo";
    private static final String IS_TOKKI_HAS_CHOSAGUN = "isTokkiHasChosagun";
    private static final String IS_TOKKI_FREE_TYPE = "isTokkiFreeType";

    @BatchParameter(key = NINTEIO_CHOSA_IRAISHO, name = "認定調査依頼書印刷区分")
    private RString ninteioChosaIraisho;
    @BatchParameter(key = NINTEI_CHOSAHYO, name = "認定調査票印刷区分")
    private RString ninteiChosahyo;
    @BatchParameter(key = NINTEICHOSAIRAILIST, name = "認定調査依頼リスト")
    private transient List<GridParameter> ninteiChosaIraiList;

    @BatchParameter(key = IS_NINTEI_CHOSA_IRAISHO, name = "認定調査依頼書")
    private boolean is認定調査依頼書;
    @BatchParameter(key = IS_NINTEI_CHOSA_IRAI_ICHIRAN, name = "認定調査依頼一覧表出力区分")
    private boolean is認定調査依頼一覧;
    @BatchParameter(key = IS_NINTEI_CHOSAHYO_GAIKYO, name = "認定調査票(概況調査)")
    private boolean is認定調査票_概況調査;
    @BatchParameter(key = IS_NINTEI_CHOSAHYO_KIHON, name = "認定調査票(基本調査)")
    private boolean is認定調査票_基本調査;
    @BatchParameter(key = IS_NINTEI_CHOSAHYO_TOKKI, name = "認定調査票(特記事項)")
    private boolean is認定調査票_特記事項;
    @BatchParameter(key = IS_NINTEI_CHOSAHYO_GAIKYOKIHON, name = "認定調査票(概況基本)")
    private boolean is認定調査票_概況基本;
    @BatchParameter(key = IS_NINTEI_CHOSAHYO_GAIKYOTOKKI, name = "認定調査票(概況特記)")
    private boolean is認定調査票_概況特記;
    @BatchParameter(key = IS_NINTEI_CHOSA_CHECK_HYO, name = "認定調査差異チェック票")
    private boolean is認定調査差異チェック票;
    @BatchParameter(key = IS_TOKKI_HAS_CHOSAGUN, name = "特記事項(調査群記載あり)")
    private boolean is特記事項_調査群;
    @BatchParameter(key = IS_TOKKI_FREE_TYPE, name = "特記事項(フリータイプ)")
    private boolean is特記事項_フリータイプ;
    @BatchParameter(key = NINTEI_CHOSAIRAI_HAKKO, name = "認定調査依頼発行一覧表出力区分")
    private boolean is認定調査依頼発行一覧;
    @BatchParameter(key = 認定調査依頼履歴一覧, name = "認定調査依頼履歴一覧")
    private boolean is認定調査依頼履歴一覧;

    @BatchParameter(key = SHUJIIIKENSHO_SAKUSEI_IRAI, name = "主治医意見書作成依頼印刷区分")
    private RString shujiiikenshoSakuseiIrai;
    @BatchParameter(key = SHUJIIIKENSHO, name = "意見書印刷区分")
    private RString shujiiIkensho;
    @BatchParameter(key = SHUJIIIKENSHOSAKUSEIIRAILIST, name = "主治医意見書作成依頼リスト")
    private transient List<GridParameter> shujiiIkenshoSakuseiIraiList;

    @BatchParameter(key = IKENSHO_SAKUSEIIRAI, name = "主治医意見書作成依頼一覧表出力区分")
    private boolean ikenshoSakuseiIraiIchiran;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAISHO, name = "主治医意見書作成依頼書出力区分")
    private boolean shujiiIkenshoSakuseiIraisho;
    @BatchParameter(key = IKENSHO_KINYU, name = "主治医意見書記入用紙出力区分")
    private boolean ikenshoKinyu;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYUSHO, name = "主治医意見書作成料請求書出力区分")
    private boolean ikenshoSakuseiSeikyusho;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYU, name = "主治医意見書作成料請求一覧表出力区分")
    private boolean ikenshoSakuseiSeikyuIchiran;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAI_HAKKO, name = "主治医意見書作成依頼発行一覧表出力区分")
    private boolean ikenshoSakuseiHakkoIchiran;
    @BatchParameter(key = 主治医意見書作成依頼履歴一覧, name = "主治医意見書作成依頼履歴一覧")
    private boolean ikenshoSakuseiRirekiIchiran;

    @BatchParameter(key = IRAIFROMYMD, name = "依頼開始日")
    private RString iraiFromYMD;
    @BatchParameter(key = IRAITOYMD, name = "依頼終了日")
    private RString iraiToYMD;
    @BatchParameter(key = HAKKOBI, name = "発行日")
    private RString hakkobi;
    @BatchParameter(key = TEISHUTSU_KIGEN, name = "提出期限")
    private RString teishutsuKigen;
    @BatchParameter(key = KYOTSU_HIZUKE, name = "共通日付")
    private RString kyotsuHizuke;
    @BatchParameter(key = 文書番号, name = "文書番号")
    private RString bunshoNo;
    @BatchParameter(key = 市町村コード, name = "市町村コード")
    private RString shichosonCode;

    /**
     * 主治医意見書作成依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiProcessParamter
     */
    public ShujiiIkenshoSakuseiProcessParamter toShujiiIkenshoSakuseiProcessParamter() {
        return new ShujiiIkenshoSakuseiProcessParamter(iraiFromYMD,
                iraiToYMD,
                shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList);
    }

    /**
     * 認定調査依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return NinteiChosaIraiProcessParamter
     */
    public NinteiChosaIraiProcessParamter toNinteiChosaIraiProcessParamter() {
        return new NinteiChosaIraiProcessParamter(iraiFromYMD,
                iraiToYMD,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList);
    }

    /**
     * 訪問調査依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return HomonChosaIraishoProcessParamter
     */
    public NinteiChosaProcessParamter toNinteiChosaProcessParamter() {
        return new NinteiChosaProcessParamter(
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList,
                is認定調査依頼書,
                is認定調査依頼一覧,
                is認定調査票_概況調査,
                is認定調査票_基本調査,
                is認定調査票_特記事項,
                is認定調査票_概況基本,
                is認定調査票_概況特記,
                is認定調査差異チェック票,
                is特記事項_調査群,
                is特記事項_フリータイプ,
                is認定調査依頼発行一覧,
                is認定調査依頼履歴一覧,
                iraiFromYMD,
                iraiToYMD,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke,
                bunshoNo,
                shichosonCode);
    }

    /**
     * 主治医意見書提出依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter
     */
    public ShujiiIkenshoProcessParamter toShujiiIkenshoProcessParamter() {
        return new ShujiiIkenshoProcessParamter(shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList,
                shujiiIkenshoSakuseiIraisho,
                ikenshoSakuseiIraiIchiran,
                ikenshoKinyu,
                ikenshoSakuseiSeikyusho,
                ikenshoSakuseiSeikyuIchiran,
                ikenshoSakuseiHakkoIchiran,
                ikenshoSakuseiRirekiIchiran,
                iraiFromYMD,
                iraiToYMD,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke,
                bunshoNo,
                shichosonCode);
    }
}
