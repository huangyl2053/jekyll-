/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import java.util.List;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】KarisanteiHokenryoNonyuTsuchishoKigotoEditor
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final int 連番;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 連番_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KarisanteiHokenryoNonyuTsuchishoKigotoItem}
     * @param 納入通知書期情報 納入通知書期情報
     * @param 連番 連番
     */
    protected KarisanteiHokenryoNonyuTsuchishoKigotoEditor(
            KarisanteiHokenryoNonyuTsuchishoKigotoItem item,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            int 連番) {
        this.仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        this.編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.連番 = 連番;
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
        editBankCode(source);
        editKozaMeigi(source);
        editKozaShurui(source);
        editKozaNo(source);
        editBankName(source);
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
        editSetaiCode(source);
        editHihokenshaName(source);
        editSetaiNushiName(source);
        editNendo1(source);
        editHokenryoGaku(source);
        editNendo2(source);
        editShotokuDankai(source);
        editNendo3(source);
        editKomokuTitle1(source);
        editSanteiKisoKingaku1(source);
        editYen1(source);
        editNendo4(source);
        editKomokuTitle2(source);
        editSanteiKisoKingaku2(source);
        editYen2(source);
        editNendo5(source);
        editKomokuTitle3(source);
        editSanteiKisoKingaku3(source);
        editYen3(source);
        editSanteiKisoKi(source);
        editSanteiKisoGenmenGaku(source);
        editSanteiKisoKariGokeiGaku(source);
        editSanteiKisoKiTitle1(source);
        editSanteiKisoZanteikiHokenryoGaku1(source);
        editSanteiKisoKiTitle2(source);
        editSanteiKisoZanteikiHokenryoGaku2(source);
        editRenban(source);
        editHokenshaName(source);
        return source;
    }

    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editKi1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ki1
                = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get期表記()
                : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(0).get期月().get期AsInt()));
    }

    private void editTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get月表記()
                : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(0).get期月().get月AsInt()));
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
        source.ki2 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(1).get期月().get期AsInt()));
    }

    private void editTsuki2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki2 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(1).get期月().get月AsInt()));
    }

    private void editNokiKaishi2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editNokiShuryo2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editKi3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ki3 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(2).get期月().get期AsInt()));
    }

    private void editTsuki3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki3 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(2).get期月().get月AsInt()));
    }

    private void editNokiKaishi3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editNokiShuryo3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editKi4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ki4 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_3).get期月().get期AsInt()));
    }

    private void editTsuki4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki4 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_3).get期月().get月AsInt()));
    }

    private void editNokiKaishi4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editNokiShuryo4(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editKi5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ki5 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_4).get期月().get期AsInt()));
    }

    private void editTsuki5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki5 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_4).get期月().get月AsInt()));
    }

    private void editNokiKaishi5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editNokiShuryo5(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editKi6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ki6 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_5).get期月().get期AsInt()));
    }

    private void editTsuki6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuki6 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_5).get期月().get月AsInt()));
    }

    private void editNokiKaishi6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiKaishi6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editNokiShuryo6(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nokiShuryo6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.bankCode = null;
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.kozaMeigi = null;
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.kozaShurui = null;
    }

    private void editKozaNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.kozaNo = null;
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.bankName = null;
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.HyojicodeName1 = RString.EMPTY;
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.HyojicodeName2 = RString.EMPTY;
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.HyojicodeName3 = RString.EMPTY;
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
        source.Hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.Hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.Hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.setaiCode = 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue();
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        //TODO
        source.hihokenshaName = null;
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.setaiNushiName = 編集後仮算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue();
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度().toDateString();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hokenryoGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計().toString());
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
        source.yen1 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
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
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計().toString());
    }

    private void editSanteiKisoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKariGokeiGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計().toString());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoKiTitle2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.santeiKisoZanteikiHokenryoGaku2
                = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            連番.padLeft(連番, 連番_6);
        }
        source.renban = 連番;
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.hokenshaName = new RString(編集後仮算定通知書共通情報.get保険者名().getText());
    }

    private RString get納期開始日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期開始日();
            }
        }
        return RString.EMPTY;
    }

    private RString get納期終了日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期終了日();
            }
        }
        return RString.EMPTY;
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return new RString(更正後普徴期別金額.get金額().toString());
            }
        }
        return RString.EMPTY;
    }

}
