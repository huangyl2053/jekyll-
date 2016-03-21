/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKey;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuForPrinting;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuItem;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuItemMeisai;
import jp.co.ndensan.reams.ca.cax.definition.core.nofusho.FukusuKibetsuShuyakuKamoku;
import jp.co.ndensan.reams.ca.cax.definition.core.nofusho.FukusuKibetsuShuyakuNendo;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.SeikyushoType;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.ToriatsukaiKigenCheckKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.ocr.OcrPattern;
import jp.co.ndensan.reams.ca.cax.service.core.seikyu.SeikyuManager;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoDataHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokitsuki.NokitsukiCollection;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.authority.AuthorityKind;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.noki.nokitsuki.NokitsukiManager;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.shunokamoku.ShunoKamokuManager;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 納入通知書情報作成サービスのクラスです。
 */
public class NonyuTsuchiShoJohoFactory {

    private final IShunoKamoku 収納科目;
    private final Map<FlexibleYear, NokitsukiCollection> 納期月コレクションマップ;
    private static Map<ReportId, OcrPattern> OCRパターン;

    /**
     * コンストラクタです。
     */
    public NonyuTsuchiShoJohoFactory() {
        ShunoKamokuManager shunoKamokuManager = new ShunoKamokuManager(AuthorityKind.参照権限収納科目);
        this.収納科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        this.納期月コレクションマップ = new HashMap<>();
    }

    /**
     * 本算定納入通知書情報を作成する。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @param 本算定納入通知書制御情報 本算定納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 代納人氏名 代納人氏名
     * @return 本算定納入通知書情報
     * @throws ApplicationException ①　パラメータのいずれかがNullの場合、NullPointerException
     */
    public HonSanteiNonyuTsuchiShoJoho create本算定納入通知書情報(
            HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報,
            List<Kitsuki> 出力期リスト,
            IName 代納人氏名) {
        requireNonNull(本算定通知書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("本算定通知書情報"));
        requireNonNull(本算定納入通知書制御情報, UrSystemErrorMessages.値がnull.getReplacedMessage("本算定納入通知書制御情報"));
        requireNonNull(出力期リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("出力期リスト"));
        requireNonNull(代納人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代納人氏名"));
        DbT2002FukaEntity 賦課の情報_更正後 = 本算定通知書情報.get賦課の情報_更正後();
        //TODO 入力.本算定通知書情報.賦課の情報（更正後）.調定年度 QA #75549
        if (!this.納期月コレクションマップ.containsKey(賦課の情報_更正後.getChoteiNendo())) {
            NokitsukiManager nokitsukiManager = new NokitsukiManager();
            //TODO 入力.本算定通知書情報.賦課の情報（更正後）.現年過年区分　が　現年度の場合false、過年度の場合true
            NokitsukiCollection 納期月コレクションマップ = nokitsukiManager.get納期月Collection(
                    収納科目, Code.EMPTY, new RYear(賦課の情報_更正後.getChoteiNendo().toDateString()), true);
            this.納期月コレクションマップ.put(賦課の情報_更正後.getChoteiNendo(), 納期月コレクションマップ);
        }
        //TODO 普徴期別金額リス 賦課の情報（更正後）から作成
        List<SeikyuForPrinting> 請求情報リスト = create請求情報(収納科目, this.納期月コレクションマップ.get(賦課の情報_更正後.getChoteiNendo()),
                本算定通知書情報.get地方公共団体().getLasdecCode_().getColumnValue(), 賦課の情報_更正後.getChoteiNendo(),
                賦課の情報_更正後.getFukaNendo(), new TsuchishoNo(new Decimal(賦課の情報_更正後.getTsuchishoNo().getColumnValue().toString())),
                賦課の情報_更正後.getShikibetsuCode(), getOcrPatternOf(本算定通知書情報.get帳票ID()), null, 本算定通知書情報.get普徴納期情報リスト());
        NonyuTsuchiShoDataHenshu 納入通知書データ編集 = new NonyuTsuchiShoDataHenshu();
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = 納入通知書データ編集.create本算定納入通知書情報(
                本算定通知書情報,
                本算定納入通知書制御情報,
                請求情報リスト,
                収納科目,
                代納人氏名,
                出力期リスト,
                HenshuHaniKubun.全てのレイアウト);
        return 本算定納入通知書情報;
    }

    /**
     * 仮算定納入通知書情報を作成する。
     *
     * @param 仮算定通知書情報 仮算定通知書情報
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 代納人氏名 代納人氏名
     * @return 仮算定納入通知書情報
     * @throws ApplicationException ①　パラメータのいずれかがNullの場合、NullPointerException
     */
    public KariSanteiNonyuTsuchiShoJoho create仮算定納入通知書情報(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報,
            List<Kitsuki> 出力期リスト,
            IName 代納人氏名) {
        requireNonNull(仮算定通知書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("仮算定通知書情報"));
        requireNonNull(仮算定納入通知書制御情報, UrSystemErrorMessages.値がnull.getReplacedMessage("仮算定納入通知書制御情報"));
        requireNonNull(出力期リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("出力期リスト"));
        requireNonNull(代納人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("代納人氏名"));
        //TODO 入力.仮算定通知書情報.賦課の情報（更正後）.調定年度
        DbT2002FukaEntity 賦課の情報_更正後 = 仮算定通知書情報.get賦課の情報_更正後();
        if (!this.納期月コレクションマップ.containsKey(賦課の情報_更正後.getChoteiNendo())) {
            NokitsukiManager nokitsukiManager = new NokitsukiManager();
            NokitsukiCollection 納期月コレクションマップ = nokitsukiManager.get納期月Collection(収納科目, Code.EMPTY,
                    new RYear(賦課の情報_更正後.getChoteiNendo().toDateString()), false);
            this.納期月コレクションマップ.put(賦課の情報_更正後.getChoteiNendo(), 納期月コレクションマップ);
        }
        //TODO 普徴期別金額リス 賦課の情報（更正後）から作成
        List<SeikyuForPrinting> 請求情報リスト = create請求情報(収納科目, this.納期月コレクションマップ.get(賦課の情報_更正後.getChoteiNendo()),
                仮算定通知書情報.get地方公共団体().getLasdecCode_().getColumnValue(), 賦課の情報_更正後.getChoteiNendo(),
                賦課の情報_更正後.getFukaNendo(), new TsuchishoNo(new Decimal(賦課の情報_更正後.getTsuchishoNo().getColumnValue().toString())),
                賦課の情報_更正後.getShikibetsuCode(), getOcrPatternOf(仮算定通知書情報.get帳票ID()), null, 仮算定通知書情報.get普徴納期情報リスト());
        NonyuTsuchiShoDataHenshu 納入通知書データ編集 = new NonyuTsuchiShoDataHenshu();
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = 納入通知書データ編集.create仮算定納入通知書情報(
                仮算定通知書情報,
                仮算定納入通知書制御情報,
                請求情報リスト,
                収納科目,
                代納人氏名,
                出力期リスト,
                HenshuHaniKubun.全てのレイアウト);
        return 仮算定納入通知書情報;
    }

    /**
     * 請求情報取得作成する。
     *
     * @param 収納科目 収納科目
     * @param 納期月リスト 納期月リスト
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param 通知書番号 通知書番号
     * @param 地方公共団体コード 地方公共団体コード
     * @param 納付書タイプ 納付書タイプ
     * @param 識別コード 識別コード
     * @param 普徴期別金額リスト 普徴期別金額リスト
     * @param 普徴納期情報リスト 普徴納期情報リスト
     * @return 請求情報リスト
     */
    public List<SeikyuForPrinting> create請求情報(IShunoKamoku 収納科目, NokitsukiCollection 納期月リスト, RString 地方公共団体コード,
            FlexibleYear 賦課年度, FlexibleYear 調定年度, TsuchishoNo 通知書番号, ShikibetsuCode 識別コード, OcrPattern 納付書タイプ,
            List<UniversalPhase> 普徴期別金額リスト, List<NokiJoho> 普徴納期情報リスト) {
        List<SeikyuForPrinting> 請求情報リスト = new ArrayList<>();
        for (NokiJoho 納期情報 : 普徴納期情報リスト) {
            int 期 = 納期情報.get期月().get期AsInt();
            ShunoKanri shunoKanri = ShunoKanri.newBuilder().build();
            shunoKanri.toEntity().setKamokuCode(収納科目.getコード());
            shunoKanri.toEntity().setKamokuEdabanCode(収納科目.get枝番コード());
            shunoKanri.toEntity().setChoteiNendo(new RYear(調定年度.toDateString()));
            shunoKanri.toEntity().setKazeiNendo(new RYear(賦課年度.toDateString()));
            shunoKanri.toEntity().setTsuchishoNo(通知書番号);
            shunoKanri.toEntity().setShikibetsuCode(識別コード);
            shunoKanri.toEntity().setJigyoKubunCode(JigyoKubun.未使用.getJigyoKubunCd());
            shunoKanri.toEntity().setChoshukenUmu(true);
            shunoKanri.toEntity().setKibetsu(期);
            ShunoKey 収納キー = new ShunoKey(shunoKanri, 収納科目, 納期月リスト.get納期月From期(期));
            SeikyuItemMeisai 請求明細 = new SeikyuItemMeisai(
                    収納キー, get金額By期(普徴期別金額リスト, 期), Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Collections.EMPTY_LIST);
            List<SeikyuItemMeisai> 請求明細リスト = new ArrayList<>();
            請求明細リスト.add(請求明細);
            SeikyuItem 編集元情報 = new SeikyuItem(地方公共団体コード, SeikyushoType.納付書, new RYear(調定年度.toDateString()),
                    納期情報.get納期().get通知書発行日(), 識別コード, 納期情報.get納期().get納期限(), null,
                    ToriatsukaiKigenCheckKubun.発行日を取扱期限とする, false, RString.EMPTY, false,
                    0, FukusuKibetsuShuyakuKamoku.複数科目を集約しない, FukusuKibetsuShuyakuNendo.年度毎に集約する, 請求明細リスト,
                    納期情報.get納期().get現年過年区分());
            SeikyuManager seikyuManager = new SeikyuManager();
            List<SeikyuForPrinting> 請求情報リスト1 = seikyuManager.get印字用請求情報(SubGyomuCode.DBB介護賦課, 納付書タイプ, 編集元情報);
            請求情報リスト.addAll(請求情報リスト1);
        }
        return 請求情報リスト;
    }

    private Decimal get金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (期 == 普徴期別金額.get期()) {
                return 普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    /**
     * 帳票IDからOcrPatternを判定する。
     *
     * @param 帳票ID
     * @return OcrPattern
     */
    public OcrPattern getOcrPatternOf(ReportId 帳票ID) {
        if (null == OCRパターン) {
            OCRパターン = new HashMap<>();
        }
        if (OCRパターン.isEmpty()) {
            OCRパターン.put(new ReportId("DBB100045_HokenryoNonyuTsuchishoKigoto"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100046_HokenryoNonyuTsuchishoKigotoRencho"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100053_HokenryoNonyuTsuchishoGinfuriFiveKi"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100054_HokenryoNonyuTsuchishoGinfuriFiveKiRencho"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100051_HokenryoNonyuTsuchishoGinfuriFourKi"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100052_HokenryoNonyuTsuchishoGinfuriFourKiRencho"), OcrPattern.期別納付書_OCRID300);
            OCRパターン.put(new ReportId("DBB100056_HokenryoNonyuTsuchishoBookFuriKaeNashi"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            OCRパターン.put(new ReportId("DBB100058_HokenryoNonyuTsuchishoBookFuriKaeNashiRencho"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            OCRパターン.put(new ReportId("DBB100055_NonyuTsuchishoBookFuriKaeAri"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            OCRパターン.put(new ReportId("DBB100057_NonyuTsuchishoBookFuriKaeAriRencho"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            OCRパターン.put(new ReportId("DBB100061_NonyuTsuchishoCVSMulti"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            OCRパターン.put(new ReportId("DBB100062_NonyuTsuchishoCVSMultiRencho"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            OCRパターン.put(new ReportId("DBB100063_NonyuTsuchishoCVSKigoto"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            OCRパターン.put(new ReportId("DBB100064_NonyuTsuchishoCVSKigotoRencho"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            OCRパターン.put(new ReportId("DBB100059_NonyuTsuchishoCVSKakuko"), OcrPattern.マルペイ納付書_ＭＴ_OCRID375);
            OCRパターン.put(new ReportId("DBB100060_NonyuTsuchishoCVSKakukoRencho"), OcrPattern.マルペイ納付書_ＭＴ_OCRID375);
        }
        return OCRパターン.get(帳票ID);
    }
}
