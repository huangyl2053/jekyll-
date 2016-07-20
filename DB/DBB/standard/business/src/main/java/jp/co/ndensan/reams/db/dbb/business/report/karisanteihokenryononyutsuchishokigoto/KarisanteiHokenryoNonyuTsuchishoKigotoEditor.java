/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalSignDeliveryInformation;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】KarisanteiHokenryoNonyuTsuchishoKigotoEditor
 *
 * @reamsid_L DBB-9110-020 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final EditedKoza 編集後口座;
    private final int 連番;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 連番_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報 納入通知書期情報
     */
    protected KarisanteiHokenryoNonyuTsuchishoKigotoEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = null == 仮算定納入通知書情報.get仮算定納入通知書制御情報()
                ? new KariSanteiNonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = null == 仮算定納入通知書制御情報.get納入通知書制御情報()
                ? new NonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.編集後口座 = 編集後仮算定通知書共通情報.get編集後口座();
        this.連番 = 仮算定納入通知書情報.get連番();
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoSource edit(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        editTitleNendo(source);
        editKi1(source);
        editTsuki1(source);
        editNokiKaishi1(source);
        editNokiShuryo1(source);
        editKi2(source);
        editTsuki2(source);
        editNokiKaishi2(source);
        editNokiShuryo2(source);
        editKi3(source);
        editTsuki3(source);
        editNokiKaishi3(source);
        editNokiShuryo3(source);
        editKi4(source);
        editTsuki4(source);
        editNokiKaishi4(source);
        editNokiShuryo4(source);
        editKi5(source);
        editTsuki5(source);
        editNokiKaishi5(source);
        editNokiShuryo5(source);
        editKi6(source);
        editTsuki6(source);
        editNokiKaishi6(source);
        editNokiShuryo6(source);
        if (編集後口座 != null) {
            editBankCode(source);
            editKozaMeigi(source);
            editKozaShurui(source);
            editKozaNo(source);
            editBankName(source);
        }
        editHyojicodeName1(source);
        editHyojicodeName2(source);
        editHyojicodeName3(source);
        editHyojiKomoku11(source);
        editHyojiKomoku21(source);
        editHyojiKomoku31(source);
        editHyojicode1(source);
        editHyojicode2(source);
        editHyojicode3(source);
        editTsuchishoNo(source);
        if (編集後仮算定通知書共通情報.get編集後個人() != null) {
            editSetaiCode(source);
            editHihokenshaName(source);
            editSetaiNushiName(source);
        }
        editNendo1(source);
        editHokenryoGaku(source);
        if (編集後仮算定通知書共通情報.get前年度情報() != null) {
            editNendo2(source);
            editShotokuDankai(source);
        }
        if (仮算定納入通知書情報.get算定の基礎() != null) {
            if (仮算定納入通知書情報.get算定の基礎().get基礎1() != null) {
                editNendo3(source);
                editKomokuTitle1(source);
                editSanteiKisoKingaku1(source);
                editYen1(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎2() != null) {
                editNendo4(source);
                editKomokuTitle2(source);
                editSanteiKisoKingaku2(source);
                editYen2(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎3() != null) {
                editNendo5(source);
                editKomokuTitle3(source);
                editSanteiKisoKingaku3(source);
                editYen3(source);
            }
        }
        editSanteiKisoKi(source);
        if (編集後仮算定通知書共通情報.get更正後() != null) {
            editSanteiKisoKariGokeiGaku(source);
            editSanteiKisoGenmenGaku(source);
        }
        editSanteiKisoKiTitle1(source);
        editSanteiKisoZanteikiHokenryoGaku1(source);
        editSanteiKisoKiTitle2(source);
        editSanteiKisoZanteikiHokenryoGaku2(source);
        editRenban(source);
        editHokenshaName(source);
        return source;
    }

    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get調定年度_年度なし()) {
            return;
        }
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editKi1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki1 = 納入通知書期情報.get期表記();
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().isEmpty()) {
            return;
        }
        source.ki1
                = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(0).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki1 = 納入通知書期情報.get月表記();
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().isEmpty()) {
            return;
        }
        source.tsuki1 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(0).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期開始日表記() : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 1);
    }

    private void editNokiShuryo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期終了日表記() : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 1);
    }

    private void editKi2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki2 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 2) {
            return;
        }
        source.ki2 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(1).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki2 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 2) {
            return;
        }
        source.tsuki2 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(1).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editNokiShuryo2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editKi3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki3 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_3) {
            return;
        }
        source.ki3 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(2).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki3 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_3) {
            return;
        }
        source.tsuki3 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(2).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editNokiShuryo3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editKi4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki4 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_4) {
            return;
        }
        source.ki4 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_3).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki4 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_4) {
            return;
        }
        source.tsuki4 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_3).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editNokiShuryo4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editKi5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki5 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_5) {
            return;
        }
        source.ki5 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_4).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki5 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_5) {
            return;
        }
        source.tsuki5 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_4).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editNokiShuryo5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editKi6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki6 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_6) {
            return;
        }
        source.ki6 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_5).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki6 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴納期情報リスト() || 編集後仮算定通知書共通情報.get普徴納期情報リスト().size() < 期_6) {
            return;
        }
        source.tsuki6 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴納期情報リスト().get(期_5).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editNokiShuryo6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.kozaMeigi = 編集後口座.get口座名義人優先();
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.kozaShurui = 編集後口座.get口座種別略称();
    }

    private void editKozaNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicodeName1 = RString.EMPTY;
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicodeName2 = RString.EMPTY;
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicodeName3 = RString.EMPTY;
    }

    private void editHyojiKomoku11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojiKomoku11 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editHyojiKomoku21(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojiKomoku21 = 編集後仮算定通知書共通情報.get表示コード２名();
    }

    private void editHyojiKomoku31(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojiKomoku31 = 編集後仮算定通知書共通情報.get表示コード３名();
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get通知書番号()) {
            return;
        }
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.setaiCode = 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue();
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hihokenshaName = 編集後仮算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue();
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.setaiNushiName = 編集後仮算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue();
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get賦課年度()) {
            return;
        }
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度().toDateString();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.hokenryoGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計());
    }

    private void editNendo2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nendo2 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editShotokuDankai(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.shotokuDankai = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階());
    }

    private void editNendo3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nendo3 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get年度();
    }

    private void editKomokuTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.komokuTitle1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get名称();
    }

    private void editSanteiKisoKingaku1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKingaku1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get金額();
    }

    private void editYen1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.yen1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get単位();
    }

    private void editNendo4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nendo4 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get年度();
    }

    private void editKomokuTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.komokuTitle2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get名称();
    }

    private void editSanteiKisoKingaku2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKingaku2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get金額();
    }

    private void editYen2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.yen2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
    }

    private void editNendo5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nendo5 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get年度();
    }

    private void editKomokuTitle3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.komokuTitle3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get名称();
    }

    private void editSanteiKisoKingaku3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKingaku3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get金額();
    }

    private void editYen3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.yen3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get単位();
    }

    private void editSanteiKisoKi(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKi = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
    }

    private void editSanteiKisoGenmenGaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoGenmenGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額());
    }

    private void editSanteiKisoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKariGokeiGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 仮算定納入通知書情報.get出力期リスト() || 仮算定納入通知書情報.get出力期リスト().isEmpty()) {
            return;
        }
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()
                || null == 仮算定納入通知書情報.get出力期リスト() || 仮算定納入通知書情報.get出力期リスト().isEmpty()) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 仮算定納入通知書情報.get出力期リスト()) {
            return;
        }
        source.santeiKisoKiTitle2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()
                || null == 仮算定納入通知書情報.get出力期リスト()) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku2
                = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            source.renban = 連番.padLeft("0", 連番_6);
        } else {
            source.renban = RString.EMPTY;
        }
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hokenshaName = 編集後仮算定通知書共通情報.get保険者名();
    }

    private RString get納期開始日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        if (null == 普徴納期情報リスト) {
            return RString.EMPTY;
        }
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期開始日();
            }
        }
        return RString.EMPTY;
    }

    private RString get納期終了日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        if (null == 普徴納期情報リスト) {
            return RString.EMPTY;
        }
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期終了日();
            }
        }
        return RString.EMPTY;
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        if (null == 更正後普徴期別金額リスト) {
            return RString.EMPTY;
        }
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return NotsuReportEditorUtil.get共通ポリシー金額1(更正後普徴期別金額.get金額());
            }
        }
        return RString.EMPTY;
    }

}
