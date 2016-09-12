/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】DBBCompNofushoItemEditor
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class DBBCompNofushoItemEditor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor {

    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final RString 星2 = new RString("**");
    private static final RString 星6 = new RString("******");
    private static final RString 星10 = new RString("**********");
    private static final RString 星11 = new RString("***********");
    private static final RString 星12 = new RString("************");
    private static final RString 星16 = new RString("****************");
    private static final RString 星17 = new RString("*****************");
    private final NofuShoKyotsu 納付書共通;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    private final ShoriKubun 処理区分;

    /**
     * インスタンスを生成します。
     *
     * @param 納付書共通 納付書共通
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     * @param 処理区分 処理区分
     * @param 連番 連番
     */
    protected DBBCompNofushoItemEditor(NofuShoKyotsu 納付書共通, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, int 連番, ShoriKubun 処理区分) {
        this.納付書共通 = null == 納付書共通 ? new NofuShoKyotsu() : 納付書共通;
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 連番;
        this.処理区分 = 処理区分;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        RString 調定年度表記 = 納付書共通.get調定年度表記();
        if (null == 調定年度表記) {
            調定年度表記 = RString.EMPTY;
        }
        source.nofushoKanendo3 = RString.EMPTY;
        source.nofushoNendo4
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(INT4) ? 調定年度表記 : 星6);
        source.nofushoKanendo2 = RString.EMPTY;
        source.nofushoKanendo1 = RString.EMPTY;
        source.nofushoKanendo4 = RString.EMPTY;
        source.nofushoNendo3
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(INT3) ? 調定年度表記 : 星6);
        source.nofushoNendo2
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(2) ? 調定年度表記 : 星6);
        source.nofushoNendo1
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(1) ? 調定年度表記 : 星6);
        source.nofushoKanendobun2 = RString.EMPTY;
        source.nofushoKanendobun3 = RString.EMPTY;
        source.nofushoKanendobun4 = RString.EMPTY;
        source.nofushoKanendobun1 = RString.EMPTY;
        edit納入通知書期情報(source);
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName2 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName3 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName4 = 納付書共通.get納付者氏名();
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName2 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName3 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName4 = 納付書共通.get被代納人氏名();
        source.nofushoKakko11 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : new RString("(");
        source.nofushoKakko12 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : new RString("(");
        source.nofushoKakko13 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : new RString("(");
        source.nofushoKakko14 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : new RString("(");
        source.nofushoKakko21 = RString.EMPTY;
        source.nofushoKakko31 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko22 = RString.EMPTY;
        source.nofushoKakko32 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko23 = RString.EMPTY;
        source.nofushoKakko33 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko24 = RString.EMPTY;
        source.nofushoKakko34 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        if (納付書共通.get通知書番号() != null) {
            source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        }
        if (納付書共通.get表示コード() != null) {
            source.nofushohyojicodeName11 = 納付書共通.get表示コード().get表示コード名１();
            source.nofushohyojicode11 = 納付書共通.get表示コード().get表示コード１();
            source.nofushohyojicodeName12 = 納付書共通.get表示コード().get表示コード名１();
            source.nofushohyojicode12 = 納付書共通.get表示コード().get表示コード１();
            source.nofushohyojicodeName13 = 納付書共通.get表示コード().get表示コード名１();
            source.nofushohyojicode13 = 納付書共通.get表示コード().get表示コード１();
            source.nofushohyojicodeName14 = 納付書共通.get表示コード().get表示コード名１();
            source.nofushohyojicode14 = 納付書共通.get表示コード().get表示コード１();
            source.nofushohyojicodeName21 = 納付書共通.get表示コード().get表示コード名２();
            source.nofushohyojicode21 = 納付書共通.get表示コード().get表示コード２();
            source.nofushohyojicodeName22 = 納付書共通.get表示コード().get表示コード名２();
            source.nofushohyojicode22 = 納付書共通.get表示コード().get表示コード２();
            source.nofushohyojicodeName23 = 納付書共通.get表示コード().get表示コード名２();
            source.nofushohyojicode23 = 納付書共通.get表示コード().get表示コード２();
            source.nofushohyojicodeName24 = 納付書共通.get表示コード().get表示コード名２();
            source.nofushohyojicode24 = 納付書共通.get表示コード().get表示コード２();
            source.nofushohyojicodeName31 = 納付書共通.get表示コード().get表示コード名３();
            source.nofushohyojicode31 = 納付書共通.get表示コード().get表示コード３();
            source.nofushohyojicodeName32 = 納付書共通.get表示コード().get表示コード名３();
            source.nofushohyojicode32 = 納付書共通.get表示コード().get表示コード３();
            source.nofushohyojicodeName33 = 納付書共通.get表示コード().get表示コード名３();
            source.nofushohyojicode33 = 納付書共通.get表示コード().get表示コード３();
            source.nofushohyojicodeName34 = 納付書共通.get表示コード().get表示コード名３();
            source.nofushohyojicode34 = 納付書共通.get表示コード().get表示コード３();
        }
        editMRenban(source);
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei12 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei13 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei14 = 納付書共通.get納付書市町村名();
        return source;
    }

    private void editMRenban(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(処理区分)) {
            source.mRenban = 連番.padLeft("0", INT6);
        } else {
            source.mRenban = RString.EMPTY;
        }
    }

    private boolean is銀振印字位置の納入通知書期情報がある(int 銀振印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (銀振印字位置 == 納入通知書期情報.get銀振印字位置()) {
                return true;
            }
        }
        return false;
    }

    private void edit納入通知書期情報(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        boolean 納入通知書期情報1有無 = false;
        boolean 納入通知書期情報2有無 = false;
        boolean 納入通知書期情報3有無 = false;
        boolean 納入通知書期情報4有無 = false;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            if (銀振印字位置 == 1) {
                source.nofushoKi1 = 納入通知書期情報.get期表記();
                source.nofushoTsuki1 = 納入通知書期情報.get月表記();
                if (納入通知書期情報.getOcr() != null) {
                    source.nofushoOcr11 = 納入通知書期情報.getOcr().get(1);
                    source.nofushoOcr21 = 納入通知書期情報.getOcr().get(2);
                    source.nofushoOcr31 = 納入通知書期情報.getOcr().get(INT3);
                    source.nofushoOcr41 = 納入通知書期情報.getOcr().get(INT4);
                }
                source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
                source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
                source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
                source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
                source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
                納入通知書期情報1有無 = true;
            } else if (銀振印字位置 == 2) {
                source.nofushoKi2 = 納入通知書期情報.get期表記();
                source.nofushoTsuki2 = 納入通知書期情報.get月表記();
                if (納入通知書期情報.getOcr() != null) {
                    source.nofushoOcr12 = 納入通知書期情報.getOcr().get(1);
                    source.nofushoOcr22 = 納入通知書期情報.getOcr().get(2);
                    source.nofushoOcr32 = 納入通知書期情報.getOcr().get(INT3);
                    source.nofushoOcr42 = 納入通知書期情報.getOcr().get(INT4);
                }
                source.nofushoNofugaku2 = 納入通知書期情報.get納付書納付額欄();
                source.nofushoNokigen2 = 納入通知書期情報.get納期限表記();
                source.nofushoNofuin2 = 納入通知書期情報.get領収日付欄();
                source.nofushoRyoshuHizukein2 = 納入通知書期情報.get納付書領収印欄();
                source.nofushoZuiji2 = 納入通知書期情報.get随時表記();
                納入通知書期情報2有無 = true;
            } else if (銀振印字位置 == INT3) {
                source.nofushoKi3 = 納入通知書期情報.get期表記();
                source.nofushoTsuki3 = 納入通知書期情報.get月表記();
                if (納入通知書期情報.getOcr() != null) {
                    source.nofushoOcr13 = 納入通知書期情報.getOcr().get(1);
                    source.nofushoOcr23 = 納入通知書期情報.getOcr().get(2);
                    source.nofushoOcr33 = 納入通知書期情報.getOcr().get(INT3);
                    source.nofushoOcr43 = 納入通知書期情報.getOcr().get(INT4);
                }
                source.nofushoNofugaku3 = 納入通知書期情報.get納付書納付額欄();
                source.nofushoNokigen3 = 納入通知書期情報.get納期限表記();
                source.nofushoNofuin3 = 納入通知書期情報.get領収日付欄();
                source.nofushoRyoshuHizukein3 = 納入通知書期情報.get納付書領収印欄();
                source.nofushoZuiji3 = 納入通知書期情報.get随時表記();
                納入通知書期情報3有無 = true;
            } else if (銀振印字位置 == INT4) {
                source.nofushoKi4 = 納入通知書期情報.get期表記();
                source.nofushoTsuki4 = 納入通知書期情報.get月表記();
                if (納入通知書期情報.getOcr() != null) {
                    source.nofushoOcr14 = 納入通知書期情報.getOcr().get(1);
                    source.nofushoOcr24 = 納入通知書期情報.getOcr().get(2);
                    source.nofushoOcr34 = 納入通知書期情報.getOcr().get(INT3);
                    source.nofushoOcr44 = 納入通知書期情報.getOcr().get(INT4);
                }
                source.nofushoNofugaku4 = 納入通知書期情報.get納付書納付額欄();
                source.nofushoNokigen4 = 納入通知書期情報.get納期限表記();
                source.nofushoNofuin4 = 納入通知書期情報.get領収日付欄();
                source.nofushoRyoshuHizukein4 = 納入通知書期情報.get納付書領収印欄();
                source.nofushoZuiji4 = 納入通知書期情報.get随時表記();
                納入通知書期情報4有無 = true;
            }
        }
        if (!納入通知書期情報1有無) {
            source.nofushoKi1 = 星2;
            source.nofushoTsuki1 = 星2;
            source.nofushoOcr11 = 星6;
            source.nofushoOcr21 = 星16;
            source.nofushoOcr31 = 星17;
            source.nofushoOcr41 = 星12;
            source.nofushoNofugaku1 = 星10;
            source.nofushoNokigen1 = 星11;
            source.nofushoNofuin1 = 星2;
            source.nofushoRyoshuHizukein1 = RString.EMPTY;
            source.nofushoZuiji1 = RString.EMPTY;
        }
        if (!納入通知書期情報2有無) {
            source.nofushoKi2 = 星2;
            source.nofushoTsuki2 = 星2;
            source.nofushoOcr12 = 星6;
            source.nofushoOcr22 = 星16;
            source.nofushoOcr32 = 星17;
            source.nofushoOcr42 = 星12;
            source.nofushoNofugaku2 = 星10;
            source.nofushoNokigen2 = 星11;
            source.nofushoNofuin2 = 星2;
            source.nofushoRyoshuHizukein2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
        }
        if (!納入通知書期情報3有無) {
            source.nofushoKi3 = 星2;
            source.nofushoTsuki3 = 星2;
            source.nofushoOcr13 = 星6;
            source.nofushoOcr23 = 星16;
            source.nofushoOcr33 = 星17;
            source.nofushoOcr43 = 星12;
            source.nofushoNofugaku3 = 星10;
            source.nofushoNokigen3 = 星11;
            source.nofushoNofuin3 = 星2;
            source.nofushoRyoshuHizukein3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
        }
        if (!納入通知書期情報4有無) {
            source.nofushoKi4 = 星2;
            source.nofushoTsuki4 = 星2;
            source.nofushoOcr14 = 星6;
            source.nofushoOcr24 = 星16;
            source.nofushoOcr34 = 星17;
            source.nofushoOcr44 = 星12;
            source.nofushoNofugaku4 = 星10;
            source.nofushoNokigen4 = 星11;
            source.nofushoNofuin4 = 星2;
            source.nofushoRyoshuHizukein4 = RString.EMPTY;
            source.nofushoZuiji4 = RString.EMPTY;
        }
    }

}
