/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550004.YokaigoNinteiTorikeshiTshuchishoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定取消通知書エディターのクラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class YokaigoNinteiTorikeshiTshuchishoEditor implements IYokaigoNinteiTorikeshiTshuchishoEditor {

    private final IAtesaki 宛先;
    private final Association 地方公共団体;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<RString> 通知書定型文リスト;
    private final NinshoshaSource 認証者ソースビルダー;
    private final RString bunshoNo;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString riyu;
    private final RString teishutsuKigenYMD;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private static final int NO_5 = 5;
    private static final int NO_6 = 6;
    private static final int NO_7 = 7;
    private static final int NO_8 = 8;
    private static final int NO_9 = 9;

    /**
     * インスタンスを生成します。
     *
     * @param 宛先 IAtesaki
     * @param 地方公共団体 Association
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 通知書定型文リスト List<RString>
     * @param 認証者ソースビルダー NinshoshaSource
     * @param bunshoNo RString
     * @param hihokenshaNo RString
     * @param hihokenshaName RString
     * @param riyu RString
     * @param teishutsuKigenYMD RString
     */
    public YokaigoNinteiTorikeshiTshuchishoEditor(IAtesaki 宛先, Association 地方公共団体, ChohyoSeigyoKyotsu 帳票制御共通,
            List<RString> 通知書定型文リスト, NinshoshaSource 認証者ソースビルダー, RString bunshoNo, RString hihokenshaNo, RString hihokenshaName,
            RString riyu, RString teishutsuKigenYMD) {
        this.宛先 = 宛先;
        this.地方公共団体 = 地方公共団体;
        this.帳票制御共通 = 帳票制御共通;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.認証者ソースビルダー = 認証者ソースビルダー;
        this.bunshoNo = bunshoNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.riyu = riyu;
        this.teishutsuKigenYMD = teishutsuKigenYMD;
    }

    /**
     * 要介護認定取消通知書Editorです。
     *
     * @param source YokaigoNinteiTorikeshiTshuchishoSource
     * @return YokaigoNinteiTorikeshiTshuchishoSource
     */
    @Override
    public YokaigoNinteiTorikeshiTshuchishoSource edit(YokaigoNinteiTorikeshiTshuchishoSource source) {
        setTitle(source);
        setYokaigoNinteiTorikeshiTshuchishoSource(source);
        set宛先情報(source);
        set認証者情報(source);
        set通知文(source);
        return source;
    }

    private void set宛先情報(YokaigoNinteiTorikeshiTshuchishoSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.宛先, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
        source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.jusho1 = sofubutsuAtesakiSource.jusho1;
        source.jusho2 = sofubutsuAtesakiSource.jusho2;
        source.jusho3 = sofubutsuAtesakiSource.jusho3;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.shimei1 = sofubutsuAtesakiSource.shimei1;
        source.shimei2 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
    }

    private void set認証者情報(YokaigoNinteiTorikeshiTshuchishoSource source) {
        source.denshiKoin = 認証者ソースビルダー.denshiKoin;
        source.hakkoYMD1 = 認証者ソースビルダー.hakkoYMD;
        source.ninshoshaYakushokuMei = 認証者ソースビルダー.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = 認証者ソースビルダー.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = 認証者ソースビルダー.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = 認証者ソースビルダー.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = 認証者ソースビルダー.ninshoshaShimeiKakeru;
        source.koinShoryaku = 認証者ソースビルダー.koinShoryaku;
        source.koinMojiretsu = 認証者ソースビルダー.koinShoryaku;
    }

    private void set通知文(YokaigoNinteiTorikeshiTshuchishoSource source) {
        source.tsuchibun1 = 通知書定型文リスト.get(0);
        source.tsuchibun2 = 通知書定型文リスト.get(1);
        source.tsuchibun3 = 通知書定型文リスト.get(2);
        if (TeikeibunMojiSize.フォント大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            source.tsuchibun5 = 通知書定型文リスト.get(NO_4);
            return;
        }
        if (TeikeibunMojiSize.フォント上小下大.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            source.tsuchibun6 = 通知書定型文リスト.get(NO_5);
            source.tsuchibun7 = 通知書定型文リスト.get(NO_6);
            return;
        }
        if (TeikeibunMojiSize.フォント上大下小.getコード().equals(帳票制御共通.get定型文文字サイズ())) {
            source.tsuchibun9 = 通知書定型文リスト.get(NO_7);
            source.tsuchibun8 = 通知書定型文リスト.get(NO_8);
            return;
        } else {
            source.tsuchibun4 = 通知書定型文リスト.get(NO_3);
        }

    }

    private void setYokaigoNinteiTorikeshiTshuchishoSource(YokaigoNinteiTorikeshiTshuchishoSource source) {
        source.bunshoNo = bunshoNo;
        source.hihokenshaName = hihokenshaName;
        source.teishutsuKigenYMD = teishutsuKigenYMD;
        source.hihokenshaNo1 = hihokenshaNo.substring(0);
        source.hihokenshaNo2 = hihokenshaNo.substring(1);
        source.hihokenshaNo3 = hihokenshaNo.substring(2);
        source.hihokenshaNo4 = hihokenshaNo.substring(NO_3);
        source.hihokenshaNo5 = hihokenshaNo.substring(NO_4);
        source.hihokenshaNo6 = hihokenshaNo.substring(NO_5);
        source.hihokenshaNo7 = hihokenshaNo.substring(NO_6);
        source.hihokenshaNo8 = hihokenshaNo.substring(NO_7);
        source.hihokenshaNo9 = hihokenshaNo.substring(NO_8);
        source.hihokenshaNo10 = hihokenshaNo.substring(NO_9);
        source.riyu = riyu;
    }

    private void setTitle(YokaigoNinteiTorikeshiTshuchishoSource source) {
        source.title = DbBusinessConfig.get(ConfigNameDBE.要介護認定取消通知書, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    }
}
