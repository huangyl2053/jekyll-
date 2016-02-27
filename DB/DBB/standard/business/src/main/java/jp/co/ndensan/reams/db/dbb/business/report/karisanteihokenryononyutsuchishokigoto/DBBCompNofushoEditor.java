/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】DBBCompNofushoEditor
 */
public class DBBCompNofushoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoEditor {

    private final NofuShoKyotsu 納付書共通;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;

    /**
     * インスタンスを生成します。
     *
     * @param 納付書共通
     * @param 納入通知書期情報
     */
    protected DBBCompNofushoEditor(NofuShoKyotsu 納付書共通, NonyuTsuchiShoKiJoho 納入通知書期情報) {
        this.納付書共通 = 納付書共通;
        this.納入通知書期情報 = 納入通知書期情報;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoSource edit(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        editNofushoHonninName1(source);
        editNofushoKakko11(source);
        editNofushoKakko21(source);
        editNofushoKakko31(source);
        editNofushoKanendo1(source);
        editNofushoKanendobun1(source);
        editNofushoKi1(source);
        editNofushoNendo1(source);
        editNofushoNofugaku1(source);
        editNofushoNofuin1(source);
        editNofushoNokigen1(source);
        editNofushoOcr11(source);
        editNofushoOcr21(source);
        editNofushoOcr31(source);
        editNofushoOcr41(source);
        editNofushoRyoshuHizukein1(source);
        editNofushoSetaiCode1(source);
        editNofushoShichosonMei11(source);
        editNofushoSofusakiName1(source);
        editNofushoTsuchishoNo1(source);
        editNofushoTsuki1(source);
        editNofushoZuiji1(source);
        editNofushohyojicode11(source);
        editNofushohyojicode21(source);
        editNofushohyojicode31(source);
        editNofushohyojicodeName11(source);
        editNofushohyojicodeName21(source);
        editNofushohyojicodeName31(source);
        return source;
    }

    private void editNofushoNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoNendo1 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editNofushoKanendo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKanendo1 = RString.EMPTY;
    }

    private void editNofushoKanendobun1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKanendobun1 = RString.EMPTY;
    }

    private void editNofushoTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoTsuki1 = 納入通知書期情報.get月表記();
    }

    private void editNofushoKi1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKi1 = 納入通知書期情報.get期表記();
    }

    private void editNofushoOcr11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoOcr11 = 納入通知書期情報.getOCR().get(1);
    }

    private void editNofushoOcr21(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoOcr21 = 納入通知書期情報.getOCR().get(2);
    }

    private void editNofushoOcr31(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoOcr31 = 納入通知書期情報.getOCR().get(3);
    }

    private void editNofushoOcr41(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoOcr41 = 納入通知書期情報.getOCR().get(4);
    }

    private void editNofushoNofugaku1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
    }

    private void editNofushoSofusakiName1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
    }

    private void editNofushoHonninName1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
    }

    private void editNofushoKakko11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKakko11 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString(("("));
    }

    private void editNofushoKakko21(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKakko21 = RString.EMPTY;
    }

    private void editNofushoKakko31(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoKakko31 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editNofushoTsuchishoNo1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editNofushoSetaiCode1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
    }

    private void editNofushohyojicodeName11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicodeName11 = null;//TODO 納付書共通.表示コード.表示コード名１
    }

    private void editNofushohyojicode11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicode11 = null;//TODO 納付書共通.表示コード.表示コード１
    }

    private void editNofushohyojicodeName21(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicodeName21 = null;//TODO 納付書共通.表示コード.表示コード名2
    }

    private void editNofushohyojicode21(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicode21 = null;//TODO 納付書共通.表示コード.表示コード2
    }

    private void editNofushohyojicodeName31(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicodeName31 = null;//TODO 納付書共通.表示コード.表示コード名3
    }

    private void editNofushohyojicode31(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushohyojicode31 = null;//TODO 納付書共通.表示コード.表示コード3
    }

    private void editNofushoNokigen1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
    }

    private void editNofushoNofuin1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
    }

    private void editNofushoRyoshuHizukein1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
    }

    private void editNofushoZuiji1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
    }

    private void editNofushoShichosonMei11(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
    }

}
