/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuForPrinting;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.OCRShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuHizukeRan;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuinranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshushoHizukeranKiHyoji;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SagakuReishoHakkoShijiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SanteiKiso;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.noki.nokikanri.UrT0729NokiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 納入通知書データ編集のクラスです。
 *
 * @reamsid_L DBB-9110-010 wangjie2
 */
public class NonyuTsuchiShoDataHenshu {

    private final RString 空白 = RString.EMPTY;
    private final RString 単位_円 = new RString("円");
    private final RString 口座振替 = new RString("口座振替");
    private static final int 整数1 = 1;
    private static final int 整数2 = 2;
    private static final int 整数3 = 3;
    private static final int 整数4 = 4;
    private static final int 整数5 = 5;
    private static final int 整数6 = 6;
    private static final int 整数7 = 7;
    private static final int 整数8 = 8;
    private static final int 整数9 = 9;
    private static final int 整数10 = 10;
    private static final int 整数11 = 11;
    private static final int 整数12 = 12;
    private static final int 整数14 = 14;
    private static final int 整数15 = 15;
    private static final RString 星10 = new RString("**********");

    /**
     * 仮算定納入通知書情報を作成する。
     *
     * @param 仮算定通知書情報 仮算定通知書情報
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 請求情報リスト 請求情報リスト
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @param 出力期リスト 出力期リスト
     * @param 編集範囲区分 編集範囲区分
     * @return 仮算定納入通知書情報
     */
    public KariSanteiNonyuTsuchiShoJoho create仮算定納入通知書情報(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報,
            List<SeikyuForPrinting> 請求情報リスト,
            IShunoKamoku 収納科目,
            IName 代納人氏名,
            List<Kitsuki> 出力期リスト,
            HenshuHaniKubun 編集範囲区分) {
        KariSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = new KariSanteiTsuchiShoKyotsuKomokuHenshu();
        EditedKariSanteiTsuchiShoKyotsu 編集後納入通知書共通情報 = 賦課帳票共通項目編集.create仮算定通知書共通情報(仮算定通知書情報);
        List<SamantabhadraIncomeInformation> 普徴収入情報リスト = get普徴収入情報リスト(編集後納入通知書共通情報);
        List<UniversalPhase> 更正後普徴期別金額リスト = new ArrayList<>();
        KozaKubun 口座区分 = null;
        if (編集後納入通知書共通情報.get更正後() != null) {
            更正後普徴期別金額リスト = 編集後納入通知書共通情報.get更正後().get更正後普徴期別金額リスト();
            口座区分 = 編集後納入通知書共通情報.get更正後().get更正後口座区分();
        }
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        if (仮算定納入通知書制御情報 != null && 仮算定納入通知書制御情報.get納入通知書制御情報() != null) {
            納入通知書制御情報 = 仮算定納入通知書制御情報.get納入通知書制御情報();
        }
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        if (編集後納入通知書共通情報.get調定年度() != null) {
            調定年度 = 編集後納入通知書共通情報.get調定年度();
        }
        if (編集後納入通知書共通情報.get賦課年度() != null) {
            賦課年度 = 編集後納入通知書共通情報.get賦課年度();
        }
        if (編集後納入通知書共通情報.get通知書番号() != null) {
            通知書番号 = 編集後納入通知書共通情報.get通知書番号();
        }
        Boolean 前年度情報有無 = 編集後納入通知書共通情報.get前年度情報有無();
        EditedAtesaki 編集後宛先 = 編集後納入通知書共通情報.get編集後宛先();
        EditedKojin 編集後個人 = 編集後納入通知書共通情報.get編集後個人();
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        if (仮算定通知書情報.get普徴納期情報リスト() != null) {
            普徴納期情報リスト = 仮算定通知書情報.get普徴納期情報リスト();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト
                = create納入通知書期情報(普徴納期情報リスト, 更正後普徴期別金額リスト,
                        口座区分, 請求情報リスト, 納入通知書制御情報, 普徴収入情報リスト, 出力期リスト, 調定年度, 賦課年度);
        SanteiNoKiso 算定基礎情報 = new SanteiNoKiso();
        SanteiKiso 算定の基礎1 = SanteiKiso.空白;
        SanteiKiso 算定の基礎2 = SanteiKiso.空白;
        SanteiKiso 算定の基礎3 = SanteiKiso.空白;
        SanteiNoKiso 基礎1 = get算定の基礎_基礎(算定の基礎1, 前年度情報有無, 編集後納入通知書共通情報);
        SanteiNoKiso 基礎2 = get算定の基礎_基礎(算定の基礎2, 前年度情報有無, 編集後納入通知書共通情報);
        SanteiNoKiso 基礎3 = get算定の基礎_基礎(算定の基礎3, 前年度情報有無, 編集後納入通知書共通情報);
        算定基礎情報.set基礎1(基礎1);
        算定基礎情報.set基礎2(基礎2);
        算定基礎情報.set基礎3(基礎3);
        FlexibleDate 発行日 = 仮算定通知書情報.get発行日();
        HyojiCodes 表示コード = get表示コード(編集後納入通知書共通情報);
        NofuShoKyotsu 納付書共通 = create納付書共通(
                調定年度,
                賦課年度,
                編集後宛先,
                null == 編集後個人 ? SetaiCode.EMPTY : 編集後個人.get世帯コード(),
                通知書番号,
                new RDate(発行日.getYearValue(), 発行日.getMonthValue(), 発行日.getDayValue()),
                代納人氏名,
                表示コード,
                収納科目,
                納入通知書制御情報);
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Return = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報Return.set発行日(仮算定通知書情報.get発行日());
        仮算定納入通知書情報Return.set帳票分類ID(仮算定通知書情報.get帳票分類ID());
        仮算定納入通知書情報Return.set帳票ID(仮算定通知書情報.get帳票ID());
        仮算定納入通知書情報Return.set処理区分(仮算定通知書情報.get処理区分());
        仮算定納入通知書情報Return.set編集後仮算定通知書共通情報(編集後納入通知書共通情報);
        仮算定納入通知書情報Return.set仮算定納入通知書制御情報(仮算定納入通知書制御情報);
        仮算定納入通知書情報Return.set算定の基礎(算定基礎情報);
        仮算定納入通知書情報Return.set地方公共団体(仮算定通知書情報.get地方公共団体());
        仮算定納入通知書情報Return.set納入通知書期情報リスト(納入通知書期情報リスト);
        仮算定納入通知書情報Return.set納付書共通(納付書共通);
        仮算定納入通知書情報Return.set編集範囲区分(編集範囲区分);
        仮算定納入通知書情報Return.set出力期リスト(出力期リスト);
        return 仮算定納入通知書情報Return;
    }

    private HyojiCodes get表示コード(EditedKariSanteiTsuchiShoKyotsu 編集後納入通知書共通情報) {
        HyojiCodes 表示コード = new HyojiCodes();
        if (編集後納入通知書共通情報 != null) {
            表示コード.set表示コード名１(編集後納入通知書共通情報.get表示コード１名());
            表示コード.set表示コード名２(編集後納入通知書共通情報.get表示コード２名());
            表示コード.set表示コード名３(編集後納入通知書共通情報.get表示コード３名());
            表示コード.set表示コード１(編集後納入通知書共通情報.get表示コード1());
            表示コード.set表示コード２(編集後納入通知書共通情報.get表示コード２());
            表示コード.set表示コード３(編集後納入通知書共通情報.get表示コード３());
        }
        return 表示コード;
    }

    private List<SamantabhadraIncomeInformation> get普徴収入情報リスト(EditedKariSanteiTsuchiShoKyotsu 編集後納入通知書共通情報) {
        List<SamantabhadraIncomeInformation> 普徴収入情報リスト = new ArrayList<>();
        if (編集後納入通知書共通情報 != null && 編集後納入通知書共通情報.get普徴収入情報リスト() != null) {
            for (OrdinaryIncomeInformation 普徴収入情報 : 編集後納入通知書共通情報.get普徴収入情報リスト()) {
                SamantabhadraIncomeInformation new普徴収入情報 = new SamantabhadraIncomeInformation();
                new普徴収入情報.set期月(普徴収入情報.get期月());
                new普徴収入情報.set収入額(普徴収入情報.get収入額());
                普徴収入情報リスト.add(new普徴収入情報);
            }
        }
        return 普徴収入情報リスト;
    }

    /**
     * 算定の基礎の基礎1/基礎2/基礎3を設定する。
     *
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @return 算定の基礎の基礎1/基礎2/基礎3
     */
    private SanteiNoKiso get算定の基礎_基礎(SanteiKiso 算定基礎, Boolean 前年度情報有無, EditedKariSanteiTsuchiShoKyotsu 編集後納入通知書共通情報) {
        PrecedingFiscalYearInformation 前年度情報 = new PrecedingFiscalYearInformation();
        if (編集後納入通知書共通情報 != null && 編集後納入通知書共通情報.get前年度情報() != null) {
            前年度情報 = 編集後納入通知書共通情報.get前年度情報();
        }
        RString 前年度賦課年度 = 前年度情報.get前年度賦課年度();
        SanteiNoKiso 基礎 = new SanteiNoKiso();
        if (null == 算定基礎 || SanteiKiso.空白.equals(算定基礎)) {
            基礎.set名称(空白);
            基礎.set年度(空白);
            基礎.set金額(空白);
            基礎.set単位(空白);
        } else {
            基礎.set単位(単位_円);
            基礎.set名称(算定基礎.get名称());
            if (SanteiKiso.保険料率.equals(算定基礎)) {
                基礎.set年度(前年度賦課年度);
                基礎.set金額(前年度情報有無 ? decimalToRString(前年度情報.get前年度保険料率()) : 空白);
            } else if (SanteiKiso.年額保険料.equals(算定基礎)) {
                基礎.set年度(前年度賦課年度);
                基礎.set金額(前年度情報有無 ? decimalToRString(前年度情報.get前年度確定介護保険料_年額()) : 空白);
            } else if (SanteiKiso.最終期保険料額.equals(算定基礎)) {
                基礎.set年度(前年度賦課年度);
                基礎.set金額(前年度情報有無 ? decimalToRString(前年度情報.get前年度最終期普徴期別介護保険料()) : 空白);
            } else {
                基礎.set年度(編集後納入通知書共通情報.get賦課年度().toDateString());
                基礎.set金額(null == 編集後納入通知書共通情報.get更正後() ? 空白 : 編集後納入通知書共通情報.get更正後().get保険料率());
            }
        }
        return 基礎;
    }

    private RString decimalToRString(Decimal decimal) {
        if (null == decimal) {
            return RString.EMPTY;
        }
        return new RString(decimal.intValue());
    }

    /**
     * 本算定納入通知書情報を作成する。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @param 本算定納入通知書制御情報 本算定納入通知書制御情報
     * @param 請求情報リスト 請求情報リスト
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @param 出力期リスト 出力期リスト
     * @param 編集範囲区分 編集範囲区分
     * @return 本算定納入通知書情報
     */
    public HonSanteiNonyuTsuchiShoJoho create本算定納入通知書情報(HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報,
            List<SeikyuForPrinting> 請求情報リスト,
            IShunoKamoku 収納科目,
            IName 代納人氏名,
            List<Kitsuki> 出力期リスト,
            HenshuHaniKubun 編集範囲区分) {
        HonSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = new HonSanteiTsuchiShoKyotsuKomokuHenshu();
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 賦課帳票共通項目編集.create本算定通知書共通情報(本算定通知書情報);
        List<UniversalPhase> 普徴期別金額リスト = new ArrayList<>();
        KozaKubun 口座区分 = null;
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        List<SamantabhadraIncomeInformation> 普徴収入情報リスト = new ArrayList<>();
        SetaiCode 世帯コード = SetaiCode.EMPTY;
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        HyojiCodes 表示コード = new HyojiCodes();
        if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト() != null) {
            普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト();
        }
        if (編集後本算定通知書共通情報.get更正後() != null) {
            口座区分 = 編集後本算定通知書共通情報.get更正後().get口座区分();
        }
        if (編集後本算定通知書共通情報.get調定年度() != null) {
            調定年度 = 編集後本算定通知書共通情報.get調定年度();
        }
        if (編集後本算定通知書共通情報.get賦課年度() != null) {
            賦課年度 = 編集後本算定通知書共通情報.get賦課年度();
        }
        if (本算定納入通知書制御情報.get納入通知書制御情報() != null) {
            納入通知書制御情報 = 本算定納入通知書制御情報.get納入通知書制御情報();
        }
        if (編集後本算定通知書共通情報.get普徴収入情報リスト() != null) {
            普徴収入情報リスト = 編集後本算定通知書共通情報.get普徴収入情報リスト();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
            世帯コード = 編集後本算定通知書共通情報.get編集後個人().get世帯コード();
        }
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            通知書番号 = 編集後本算定通知書共通情報.get通知書番号();
        }
        if (編集後本算定通知書共通情報.get表示コード() != null) {
            表示コード = 編集後本算定通知書共通情報.get表示コード();
        }
        EditedAtesaki 編集後宛先 = 編集後本算定通知書共通情報.get編集後宛先();
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        if (本算定通知書情報.get普徴納期情報リスト() != null) {
            普徴納期情報リスト = 本算定通知書情報.get普徴納期情報リスト();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = create納入通知書期情報(普徴納期情報リスト, 普徴期別金額リスト,
                口座区分, 請求情報リスト, 納入通知書制御情報, 普徴収入情報リスト, 出力期リスト, 調定年度, 賦課年度);
        NofuShoKyotsu 納付書共通 = create納付書共通(
                調定年度,
                賦課年度,
                編集後宛先,
                世帯コード,
                通知書番号,
                本算定通知書情報.get発行日(),
                代納人氏名,
                表示コード,
                収納科目,
                本算定納入通知書制御情報.get納入通知書制御情報());
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        本算定納入通知書情報.set現年度_過年度区分(本算定通知書情報.get現年度_過年度区分());
        本算定納入通知書情報.set発行日(本算定通知書情報.get発行日());
        本算定納入通知書情報.set帳票分類ID(本算定通知書情報.get帳票分類ID());
        本算定納入通知書情報.set帳票ID(本算定通知書情報.get帳票ID());
        本算定納入通知書情報.set処理区分(本算定通知書情報.get処理区分());
        本算定納入通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        本算定納入通知書情報.set本算定納入通知書制御情報(本算定納入通知書制御情報);
        本算定納入通知書情報.set地方公共団体(本算定通知書情報.get地方公共団体());
        本算定納入通知書情報.set納付書共通(納付書共通);
        本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        本算定納入通知書情報.set編集範囲区分(編集範囲区分);
        本算定納入通知書情報.set出力期リスト(出力期リスト);
        return 本算定納入通知書情報;
    }

    /**
     * 納入通知書期情報を作成する。
     *
     * @param 普徴納期情報リスト 普徴納期情報リスト
     * @param 更正後普徴期別金額リスト 更正後普徴期別金額リスト
     * @param 口座区分 口座区分
     * @param 納入通知書制御情報 納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 普徴収入情報リスト 普徴収入情報リスト
     * @param 請求情報リスト 請求情報リスト
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return 納入通知書期情報リスト
     */
    public List<NonyuTsuchiShoKiJoho> create納入通知書期情報(
            List<NokiJoho> 普徴納期情報リスト,
            List<UniversalPhase> 更正後普徴期別金額リスト,
            KozaKubun 口座区分,
            List<SeikyuForPrinting> 請求情報リスト,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            List<SamantabhadraIncomeInformation> 普徴収入情報リスト,
            List<Kitsuki> 出力期リスト,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = new ArrayList<>();
        for (Kitsuki 出力期 : 出力期リスト) {
            int 期 = 出力期.get期AsInt();
            int 月 = 出力期.get月AsInt();
            Decimal 金額 = get金額(更正後普徴期別金額リスト, 期);
            Decimal 収入額 = get収入額(普徴収入情報リスト, 出力期);
            Decimal 納付額
                    = SagakuReishoHakkoShijiKubun.差額令書で発行する.equals(納入通知書制御情報.get差額令書発行指示()) ? 金額.subtract(収入額) : 金額;
            int 銀振印字位置;
            int ブック開始位置;
            int コンビニ連帳印字位置;
            int コンビニカット印字位置;
            if (調定年度.equals(賦課年度)) {
                List<RString> 各印字位置 = get各印字位置(月);
                銀振印字位置 = RString.isNullOrEmpty(各印字位置.get(0)) ? 0 : Integer.parseInt(各印字位置.get(0).toString());
                if (0 == 銀振印字位置) {
                    continue;
                }
                ブック開始位置 = RString.isNullOrEmpty(各印字位置.get(整数1)) ? 0 : Integer.parseInt(各印字位置.get(整数1).toString());
                コンビニ連帳印字位置
                        = RString.isNullOrEmpty(各印字位置.get(整数3)) ? 0 : Integer.parseInt(各印字位置.get(整数3).toString());
                コンビニカット印字位置
                        = RString.isNullOrEmpty(各印字位置.get(整数2)) ? 0 : Integer.parseInt(各印字位置.get(整数2).toString());
            } else {
                List<RString> 各印字位置 = get各印字位置2(月);
                銀振印字位置 = RString.isNullOrEmpty(各印字位置.get(0)) ? 0 : Integer.parseInt(各印字位置.get(0).toString());
                if (0 == 銀振印字位置) {
                    continue;
                }
                ブック開始位置 = RString.isNullOrEmpty(各印字位置.get(整数1)) ? 0 : Integer.parseInt(各印字位置.get(整数1).toString());
                コンビニ連帳印字位置 = RString.isNullOrEmpty(各印字位置.get(整数2)) ? 0 : Integer.parseInt(各印字位置.get(整数2).toString());
                コンビニカット印字位置 = RString.isNullOrEmpty(各印字位置.get(整数3)) ? 0 : Integer.parseInt(各印字位置.get(整数3).toString());
            }
            if (is処理中の期月の物である(請求情報リスト, 出力期.get期())) {
                continue;
            }
            NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(普徴納期情報リスト, 請求情報リスト, 期, 出力期, 銀振印字位置,
                    ブック開始位置, コンビニ連帳印字位置, コンビニカット印字位置, 納入通知書制御情報, 金額, 収入額, 納付額, 口座区分);
            納入通知書期情報リスト.add(納入通知書期情報);
        }
        return 納入通知書期情報リスト;
    }

    private boolean is処理中の期月の物である(List<SeikyuForPrinting> 請求情報リスト, RString 処理中の期) {
        for (SeikyuForPrinting 請求情報 : 請求情報リスト) {
            if (処理中の期.equals(請求情報.get請求対象情報().get請求明細リスト().get(0).get収納期別明細().get期別())) {
                return true;
            }
        }
        return false;
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報(List<NokiJoho> 普徴納期情報リスト, List<SeikyuForPrinting> 請求情報リスト, int 期,
            Kitsuki 出力期, int 銀振印字位置, int ブック開始位置, int コンビニ連帳印字位置, int コンビニカット印字位置,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Decimal 金額, Decimal 収入額, Decimal 納付額, KozaKubun 口座区分) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = new NonyuTsuchiShoKiJoho();
        NokiJoho 普徴納期情報 = get普徴納期情報By期(普徴納期情報リスト, 期);
        Noki 納期 = null == 普徴納期情報.get納期() ? new Noki(new UrT0729NokiKanriEntity()) : 普徴納期情報.get納期();
        SeikyuForPrinting 請求情報 = get請求情報By期(請求情報リスト, 出力期.get期());
        納入通知書期情報.set銀振印字位置(銀振印字位置);
        納入通知書期情報.setコンビニ連帳印字位置(コンビニ連帳印字位置);
        納入通知書期情報.setコンビニカット印字位置(コンビニカット印字位置);
        納入通知書期情報.setブック開始位置(ブック開始位置);
        納入通知書期情報.set期(出力期.get期AsInt());
        納入通知書期情報.set月(出力期.get月());
        納入通知書期情報.set期表記(new RString(String.valueOf(出力期.get期AsInt())).padLeft(RString.HALF_SPACE, 2));
        納入通知書期情報.set月表記(new RString(String.valueOf(出力期.get月AsInt())).padLeft(RString.HALF_SPACE, 2));
        納入通知書期情報.set随時表記(KanendoMongon.随時.equals(納入通知書制御情報.get過年度文言1()) ? KanendoMongon.随時.get名称() : RString.EMPTY);
        納入通知書期情報.set納期開始日(納期.get納期開始日());
        納入通知書期情報.set納期開始日表記(納期.get納期開始日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納期終了日(納期.get納期終了日());
        納入通知書期情報.set納期終了日表記(納期.get納期終了日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納期限(納期.get納期限());
        納入通知書期情報.set納期限表記(納付額.compareTo(Decimal.ZERO) <= 0 ? new RString("***********") : 納期.get納期限().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納付額(納付額);
        納入通知書期情報.set納付額表記(new RString(String.valueOf(納付額)));
        納入通知書期情報.set調定額(金額);
        納入通知書期情報.set調定額表記(new RString(String.valueOf(金額)));
        納入通知書期情報.set収入額(収入額);
        納入通知書期情報.set収入額表記(new RString(String.valueOf(収入額)));
        納入通知書期情報.set差額(金額.subtract(収入額));
        納入通知書期情報.set差額表記(new RString(String.valueOf(金額.subtract(収入額))));
        boolean is口座振替 = KozaKubun.口座振替.equals(口座区分);
        boolean is現金納付 = KozaKubun.現金納付.equals(口座区分);
        if (is該当する請求情報ある(請求情報)) {
            if (請求情報.getMpn() != null) {
                納入通知書期情報.set収納機関番号表示用(請求情報.getMpn().get収納機関番号表示用());
                納入通知書期情報.set納付番号(請求情報.getMpn().get納付番号());
                納入通知書期情報.set確認番号(請求情報.getMpn().get確認番号());
                納入通知書期情報.set納付区分(請求情報.getMpn().get納付区分());
            }
            if (is口座振替) {
                納入通知書期情報.setOcrid(請求情報.getOcr().getOCRID());
                OCRShutsuryokuHoho 口座振替のOCR出力方法 = 納入通知書制御情報.get口座振替のOCR出力方法();
                納入通知書期情報.setOcr(getOCRBy口座振替のOCR出力方法(請求情報, 口座振替のOCR出力方法));
            } else if (is現金納付) {
                納入通知書期情報.setOcrid(空白);
                納入通知書期情報.setOcr(getNewOCR(請求情報, 空白));
            }
            納入通知書期情報.setOcrid(請求情報.getOcr().getOCRID());
            納入通知書期情報.setOcr(null);
            納入通知書期情報.setバーコード情報((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報() : 空白));
            納入通知書期情報.setバーコード情報上段((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報上段() : 空白));
            納入通知書期情報.setバーコード情報下段((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報下段() : 空白));
            納入通知書期情報.setコンビニ支払期限((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニ納付書取扱期限表示())
                    ? 請求情報.getCvs().getコンビニ支払期限() : null));
        } else {
            納入通知書期情報.set収納機関番号表示用(空白);
            納入通知書期情報.set納付番号(空白);
            納入通知書期情報.set確認番号(空白);
            納入通知書期情報.set納付区分(空白);
            納入通知書期情報.setOcrid(空白);
            納入通知書期情報.setOcr(null);
            納入通知書期情報.setバーコード情報(空白);
            納入通知書期情報.setバーコード情報上段(空白);
            納入通知書期情報.setバーコード情報下段(空白);
        }
        set納付額欄(is現金納付, is口座振替, 納入通知書期情報, 納付額, 納入通知書制御情報);
        納入通知書期情報.set領収証書領収印欄(RyoshuinranHyojiKubun._口座振替_を印字する.equals(納入通知書制御情報.get領収証書領収印欄()) ? 口座振替 : 空白);
        納入通知書期情報.set納付書領収印欄(RyoshuinranHyojiKubun._口座振替_を印字する.equals(納入通知書制御情報.get納付書領収印欄()) ? 口座振替 : 空白);
        set納入通知書期情報領収欄(納入通知書期情報, 納入通知書制御情報, 出力期);
        return 納入通知書期情報;
    }

    private void set納入通知書期情報領収欄(NonyuTsuchiShoKiJoho 納入通知書期情報, NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Kitsuki 出力期) {
        RString 領収日付印欄;
        RString 領収日付欄;
        RString 領収書日付欄期月;
        if (RyoshuHizukeRan.期で出力する.equals(納入通知書制御情報.get領収書領収日付印欄())) {
            領収日付印欄 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshuHizukeRan.月で出力する.equals(納入通知書制御情報.get領収書領収日付印欄())) {
            領収日付印欄 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収日付印欄 = 空白;
        }
        if (RyoshuHizukeRan.期で出力する.equals(納入通知書制御情報.get納付書領収日付欄())) {
            領収日付欄 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshuHizukeRan.月で出力する.equals(納入通知書制御情報.get納付書領収日付欄())) {
            領収日付欄 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収日付欄 = 空白;
        }
        if (RyoshushoHizukeranKiHyoji.期表示.equals(納入通知書制御情報.get領収書日付印欄の期())) {
            領収書日付欄期月 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshushoHizukeranKiHyoji.月表示.equals(納入通知書制御情報.get領収書日付印欄の期())) {
            領収書日付欄期月 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収書日付欄期月 = 空白;
        }
        納入通知書期情報.set領収日付印欄(領収日付印欄);
        納入通知書期情報.set領収日付欄(領収日付欄);
        納入通知書期情報.set領収書日付欄期月(領収書日付欄期月);
    }

    private void set納付額欄(boolean is現金納付, boolean is口座振替,
            NonyuTsuchiShoKiJoho 納入通知書期情報, Decimal 納付額, NonyuTsuchiShoSeigyoJoho 納入通知書制御情報) {
        if (is現金納付) {
            納入通知書期情報.set領収証書納付額欄(納付額.compareTo(Decimal.ZERO) <= 0 ? 星10 : new RString(納付額.toString()));
            納入通知書期情報.set納付書納付額欄(納付額.compareTo(Decimal.ZERO) <= 0 ? 星10 : new RString(納付額.toString()));
        } else if (is口座振替) {
            NofugakuranHyojiKubun 納付書納付額欄 = 納入通知書制御情報.get納付書納付額欄();
            if (NofugakuranHyojiKubun._口座振替_を印字する.equals(納付書納付額欄)) {
                納入通知書期情報.set領収証書納付額欄(口座振替);
                納入通知書期情報.set納付書納付額欄(口座振替);
            } else if (NofugakuranHyojiKubun.__を印字する.equals(納付書納付額欄)) {
                納入通知書期情報.set領収証書納付額欄(空白);
                納入通知書期情報.set納付書納付額欄(空白);
            } else if (NofugakuranHyojiKubun.星印を印字する.equals(納付書納付額欄)) {
                納入通知書期情報.set領収証書納付額欄(星10);
                納入通知書期情報.set納付書納付額欄(星10);
            } else if (NofugakuranHyojiKubun.金額出力.equals(納付書納付額欄)) {
                納入通知書期情報.set領収証書納付額欄(納付額.compareTo(Decimal.ZERO) <= 0 ? 星10 : new RString(納付額.toString()));
                納入通知書期情報.set納付書納付額欄(納付額.compareTo(Decimal.ZERO) <= 0 ? 星10 : new RString(納付額.toString()));
            }
        }
    }

    private Map<Integer, RString> getOCRBy口座振替のOCR出力方法(SeikyuForPrinting 請求情報, OCRShutsuryokuHoho 口座振替のOCR出力方法) {
        if (OCRShutsuryokuHoho._口座振替_ならOCR欄を_星印_でつぶす.equals(口座振替のOCR出力方法)) {
            return getNewOCR(請求情報, new RString("＊"));
        } else if (OCRShutsuryokuHoho._口座振替_ならOCR欄を印字する.equals(口座振替のOCR出力方法)) {
            return 請求情報.getOcr().getOcr();
        } else if (OCRShutsuryokuHoho._口座振替_ならOCR欄を印字しない.equals(口座振替のOCR出力方法)) {
            return getNewOCR(請求情報, 空白);
        }
        return new HashMap<>();
    }

    private Map<Integer, RString> getNewOCR(SeikyuForPrinting 請求情報, RString 印字文字列) {
        Map<Integer, RString> newOCR = new HashMap<>();
        Map<Integer, RString> 請求情報OCR = 請求情報.getOcr().getOcr();
        if (請求情報OCR != null && !請求情報OCR.isEmpty()) {
            Set<Integer> 行目Keys = 請求情報OCR.keySet();
            for (Integer 行目 : 行目Keys) {
                newOCR.put(行目, 印字文字列);
            }
        }
        return newOCR;
    }

    private List<RString> get各印字位置2(int 月) {
        RString 過年度期情報_納付書の印字位置;
        RString 過年度期情報_ブック開始位置;
        RString 過年度期情報_コンビニカット印字位置;
        RString 過年度期情報_コンビニ連帳印字位置;
        switch (月) {
            case 整数4:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数5:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数6:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数7:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数8:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数9:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数10:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数11:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数12:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数1:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数2:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数3:
                過年度期情報_納付書の印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            default:
                過年度期情報_納付書の印字位置 = RString.EMPTY;
                過年度期情報_ブック開始位置 = RString.EMPTY;
                過年度期情報_コンビニカット印字位置 = RString.EMPTY;
                過年度期情報_コンビニ連帳印字位置 = RString.EMPTY;
                break;
        }
        List<RString> 各印字位置 = new ArrayList<>();
        各印字位置.add(過年度期情報_納付書の印字位置);
        各印字位置.add(過年度期情報_ブック開始位置);
        各印字位置.add(過年度期情報_コンビニカット印字位置);
        各印字位置.add(過年度期情報_コンビニ連帳印字位置);
        return 各印字位置;
    }

    private List<RString> get各印字位置(int 月) {
        RString 納付書の印字位置 = RString.EMPTY;
        RString ブック開始位置 = RString.EMPTY;
        RString コンビニカット印字位置 = RString.EMPTY;
        RString コンビニ連帳印字位置 = RString.EMPTY;
        switch (月) {
            case 整数4:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数5:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数6:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数7:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数8:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数9:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数10:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数11:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数12:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数1:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数2:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数3:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数14:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 整数15:
                納付書の印字位置 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                ブック開始位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニカット印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                コンビニ連帳印字位置
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return get各印字位置(納付書の印字位置, ブック開始位置, コンビニカット印字位置, コンビニ連帳印字位置);
    }

    private List<RString> get各印字位置(RString 普徴期情報_納付書の印字位置,
            RString 普徴期情報_ブック開始位置, RString 普徴期情報_コンビニカット印字位置, RString 普徴期情報_コンビニ連帳印字位置) {
        List<RString> 各印字位置 = new ArrayList<>();
        各印字位置.add(普徴期情報_納付書の印字位置);
        各印字位置.add(普徴期情報_ブック開始位置);
        各印字位置.add(普徴期情報_コンビニカット印字位置);
        各印字位置.add(普徴期情報_コンビニ連帳印字位置);
        return 各印字位置;
    }

    private boolean is該当する請求情報ある(SeikyuForPrinting 請求情報) {
        return 請求情報 != null;
    }

    private SeikyuForPrinting get請求情報By期(List<SeikyuForPrinting> 請求情報リスト, RString 期別) {
        for (SeikyuForPrinting 請求情報 : 請求情報リスト) {
            if (期別.padLeft("0", 整数2)
                    .equals(請求情報.get請求対象情報().get請求明細リスト().get(0).get収納期別明細().get期別().padLeft("0", 整数2))) {
                return 請求情報;
            }
        }
        return null;
    }

    private NokiJoho get普徴納期情報By期(List<NokiJoho> 普徴納期情報リスト, int 期) {
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報;
            }
        }
        return new NokiJoho();
    }

    private Decimal get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (更正後普徴期別金額.get期() == 期) {
                return 更正後普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    private Decimal get収入額(List<SamantabhadraIncomeInformation> 普徴収入情報リスト, Kitsuki 出力期) {
        for (SamantabhadraIncomeInformation 普徴収入情報 : 普徴収入情報リスト) {
            if (出力期.equals(普徴収入情報.get期月())) {
                return 普徴収入情報.get収入額();
            }
        }
        return Decimal.ZERO;
    }

    /**
     * 納付書共通を作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 編集後宛先 編集後宛先
     * @param 世帯コード 世帯コード
     * @param 通知書番号 通知書番号
     * @param 発行日 発行日
     * @param 収納科目 収納科目
     * @param 表示コード 表示コード
     * @param 代納人氏名 代納人氏名
     * @param 納入通知書制御情報 納入通知書制御情報
     * @return 納付書共通 納付書共通
     */
    public NofuShoKyotsu create納付書共通(FlexibleYear 調定年度, FlexibleYear 賦課年度, EditedAtesaki 編集後宛先, SetaiCode 世帯コード,
            TsuchishoNo 通知書番号, RDate 発行日, IName 代納人氏名, HyojiCodes 表示コード, IShunoKamoku 収納科目,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報) {
        NofuShoKyotsu 納付書共通 = new NofuShoKyotsu();
        納付書共通.set調定年度(調定年度);
        納付書共通.set調定年度表記(get共通ポリシーターン107(調定年度));
        納付書共通.set賦課年度(賦課年度);
        納付書共通.set調定年度表記(get共通ポリシーターン107(賦課年度).concat("分"));
        納付書共通.set年度年分表記(get共通ポリシーターン107(調定年度).concat("△").concat(get共通ポリシーターン107(賦課年度)).concat("分"));
        納付書共通.set通知書番号(通知書番号);
        納付書共通.set世帯コード(世帯コード);
        納付書共通.set表示コード(表示コード);
        納付書共通.set科目名称(収納科目.get名称());
        納付書共通.set発行日(発行日);
        納付書共通.set発行日表記(HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニ納付書発行日表示())
                ? 発行日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString() : 空白);
        if (編集後宛先 != null) {
            納付書共通.set住所(編集後宛先.get編集後住所());
            納付書共通.set郵便番号(編集後宛先.get郵便番号());
            納付書共通.set行政区名(編集後宛先.get行政区名());
            納付書共通.set方書(編集後宛先.get方書());
            納付書共通.set代納人氏名(null == 代納人氏名 ? AtenaMeisho.EMPTY : 代納人氏名.getName());
            納付書共通.set被保険者氏名(編集後宛先.get本人名称().getName());
            if (AtesakiShubetsu.代納人送付先.equals(編集後宛先.get宛先種別()) || AtesakiShubetsu.代納人.equals(編集後宛先.get宛先種別())) {
                納付書共通.set納付者氏名(null == 代納人氏名 ? RString.EMPTY : 代納人氏名.getName().getColumnValue());
                納付書共通.set被代納人氏名(納付書共通.get被保険者氏名().getColumnValue());
            } else {
                納付書共通.set納付者氏名(空白);
                納付書共通.set被代納人氏名(空白);
            }
            納付書共通.set被代納人敬称(編集後宛先.get本人敬称());
        }
        納付書共通.set納付書市町村名(HyojiUmu.表示する.equals(納入通知書制御情報.get納付書市町村名表示()) ? 納入通知書制御情報.get納付書市町村名() : 空白);
        return 納付書共通;
    }

    private RString get共通ポリシーターン107(FlexibleYear 年度) {
        return null == 年度 ? RString.EMPTY
                : 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

}
