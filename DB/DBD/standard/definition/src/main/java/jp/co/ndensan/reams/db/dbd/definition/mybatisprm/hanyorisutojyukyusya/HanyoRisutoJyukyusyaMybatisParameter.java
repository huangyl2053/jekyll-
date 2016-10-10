/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusya;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoJyukyusyaMybatisParameter implements IMyBatisParameter {

    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private boolean is直近;
    private boolean is有効データ内最新;
    private boolean is抽出方法区分_基準日;
    private boolean is抽出方法区分_範囲;
    private boolean is日付範囲From;
    private boolean is日付範囲To;
    private boolean is資格取得者のみ;
    private boolean is資格喪失者のみ;
    private boolean is旧措置者;
    private boolean is1号被保険者true2号被保険者true;
    private boolean is1号被保険者true2号被保険者false;
    private boolean is1号被保険者false2号被保険者true;
    private boolean isサービス指定者true;
    private boolean is宛名抽出区分_年齢;
    private boolean is宛名抽出区分_年齢From;
    private boolean is宛名抽出区分_年齢To;
    private boolean is宛名抽出区分_生年月日;
    private boolean is宛名抽出区分_生年月日From;
    private boolean is宛名抽出区分_生年月日To;
    private boolean is宛名抽出条件_保険者コード_非全部;
    private boolean is住所;
    private boolean is行政区;
    private boolean is地区1;
    private boolean is地区2;
    private boolean is地区3;
    private boolean 地区選択From;
    private boolean 地区選択To;
    private FlexibleDate kijunYMD;
    private FlexibleDate startYMD;
    private FlexibleDate endYMD;
    private FlexibleDate ageFrom;
    private FlexibleDate ageTo;
    private FlexibleDate seinengappiYMDFrom;
    private FlexibleDate seinengappiYMDTo;
    private RString hokenshaNo;
    private RString tiiki_From;
    private RString tiiki_To;
    private RString 出力順;
    private boolean is認定結果0length0;
    private boolean is認定結果1length0;
    private boolean is認定結果1length非0;
    private boolean is認定結果2length0;
    private boolean is認定結果2length非0;
    private boolean is認定結果3length0;
    private boolean is認定結果3length非0;
    private boolean is認定結果4length0;
    private boolean is認定結果4length非0;
    private boolean is認定結果5length0;
    private boolean is認定結果5length非0;
    private boolean is認定結果6length0;
    private boolean is認定結果6length非0;
    private boolean is認定結果7length0;
    private boolean is認定結果7length非0;
    private boolean is認定結果8length0;
    private boolean is認定結果8length非0;
    private boolean is認定結果9length0;
    private boolean is認定結果9length非0;
    private boolean is認定結果10length0;
    private boolean is認定結果10length非0;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛名識別対象PSM
     * @param is直近 boolean
     * @param is有効データ内最新 boolean
     * @param is抽出方法区分_基準日 boolean
     * @param is抽出方法区分_範囲 boolean
     * @param is日付範囲From boolean
     * @param is日付範囲To boolean
     * @param is資格取得者のみ boolean
     * @param is資格喪失者のみ boolean
     * @param is1号被保険者true2号被保険者true boolean
     * @param is旧措置者 boolean
     * @param is1号被保険者true2号被保険者false boolean
     * @param isサービス指定者true boolean
     * @param is1号被保険者false2号被保険者true boolean
     * @param is宛名抽出区分_年齢 boolean
     * @param is宛名抽出区分_年齢From boolean
     * @param is宛名抽出区分_年齢To boolean
     * @param is宛名抽出区分_生年月日 boolean
     * @param is宛名抽出区分_生年月日From boolean
     * @param is宛名抽出区分_生年月日To boolean
     * @param is宛名抽出条件_保険者コード_非全部 boolean
     * @param is住所 boolean
     * @param is行政区 boolean
     * @param is地区1 boolean
     * @param is地区2 boolean
     * @param 地区選択From boolean
     * @param kijunYMD boolean
     * @param 地区選択To boolean
     * @param is地区3 boolean
     * @param startYMD FlexibleDate
     * @param endYMD FlexibleDate
     * @param ageFrom FlexibleDate
     * @param ageTo FlexibleDate
     * @param seinengappiYMDFrom FlexibleDate
     * @param hokenshaNo RString
     * @param seinengappiYMDTo FlexibleDate
     * @param tiiki_From RString
     * @param tiiki_To RString
     * @param is認定結果0length0 boolean
     * @param is認定結果1length0 boolean
     * @param is認定結果1length非0 boolean
     * @param is認定結果2length0 boolean
     * @param is認定結果2length非0 boolean
     * @param is認定結果3length0 boolean
     * @param is認定結果3length非0 boolean
     * @param is認定結果4length0 boolean
     * @param is認定結果4length非0 boolean
     * @param is認定結果5length0 boolean
     * @param is認定結果5length非0 boolean
     * @param is認定結果6length0 boolean
     * @param is認定結果6length非0 boolean
     * @param is認定結果7length0 boolean
     * @param is認定結果7length非0 boolean
     * @param is認定結果8length0 boolean
     * @param is認定結果8length非0 boolean
     * @param is認定結果9length0 boolean
     * @param is認定結果9length非0 boolean
     * @param is認定結果10length0 boolean
     * @param is認定結果10length非0 boolean
     * @param 出力順 RString
     */
    public HanyoRisutoJyukyusyaMybatisParameter(
            RString psmShikibetsuTaisho, RString psmAtesaki, boolean is直近, boolean is有効データ内最新, boolean is抽出方法区分_基準日,
            boolean is抽出方法区分_範囲, boolean is日付範囲From, boolean is日付範囲To, boolean is資格取得者のみ, boolean is資格喪失者のみ,
            boolean is旧措置者, boolean is1号被保険者true2号被保険者true, boolean is1号被保険者true2号被保険者false,
            boolean is1号被保険者false2号被保険者true, boolean isサービス指定者true, boolean is宛名抽出区分_年齢,
            boolean is宛名抽出区分_年齢From, boolean is宛名抽出区分_年齢To, boolean is宛名抽出区分_生年月日,
            boolean is宛名抽出区分_生年月日From, boolean is宛名抽出区分_生年月日To, boolean is宛名抽出条件_保険者コード_非全部,
            boolean is住所, boolean is行政区, boolean is地区1, boolean is地区2, boolean is地区3, boolean 地区選択From, boolean 地区選択To,
            FlexibleDate kijunYMD, FlexibleDate startYMD, FlexibleDate endYMD, FlexibleDate ageFrom, FlexibleDate ageTo,
            FlexibleDate seinengappiYMDFrom, FlexibleDate seinengappiYMDTo, RString hokenshaNo, RString tiiki_From,
            RString tiiki_To, boolean is認定結果0length0, boolean is認定結果1length0, boolean is認定結果1length非0,
            boolean is認定結果2length0, boolean is認定結果2length非0, boolean is認定結果3length0, boolean is認定結果3length非0,
            boolean is認定結果4length0, boolean is認定結果4length非0, boolean is認定結果5length0, boolean is認定結果5length非0,
            boolean is認定結果6length0, boolean is認定結果6length非0, boolean is認定結果7length0, boolean is認定結果7length非0,
            boolean is認定結果8length0, boolean is認定結果8length非0, boolean is認定結果9length0, boolean is認定結果9length非0,
            boolean is認定結果10length0, boolean is認定結果10length非0, RString 出力順) {

        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.is有効データ内最新 = is有効データ内最新;
        this.is直近 = is直近;
        this.is抽出方法区分_基準日 = is抽出方法区分_基準日;
        this.is抽出方法区分_範囲 = is抽出方法区分_範囲;
        this.is日付範囲From = is日付範囲From;
        this.is日付範囲To = is日付範囲To;
        this.is資格取得者のみ = is資格取得者のみ;
        this.is資格喪失者のみ = is資格喪失者のみ;
        this.is旧措置者 = is旧措置者;
        this.is1号被保険者true2号被保険者true = is1号被保険者true2号被保険者true;
        this.is1号被保険者true2号被保険者false = is1号被保険者true2号被保険者false;
        this.is1号被保険者false2号被保険者true = is1号被保険者false2号被保険者true;
        this.isサービス指定者true = isサービス指定者true;
        this.is宛名抽出区分_年齢 = is宛名抽出区分_年齢;
        this.is宛名抽出区分_年齢From = is宛名抽出区分_年齢From;
        this.is宛名抽出区分_年齢To = is宛名抽出区分_年齢To;
        this.is宛名抽出区分_生年月日 = is宛名抽出区分_生年月日;
        this.is宛名抽出区分_生年月日From = is宛名抽出区分_生年月日From;
        this.is宛名抽出区分_生年月日To = is宛名抽出区分_生年月日To;
        this.is宛名抽出条件_保険者コード_非全部 = is宛名抽出条件_保険者コード_非全部;
        this.is住所 = is住所;
        this.is行政区 = is行政区;
        this.is地区1 = is地区1;
        this.is地区2 = is地区2;
        this.is地区3 = is地区3;
        this.地区選択From = 地区選択From;
        this.地区選択To = 地区選択To;
        this.kijunYMD = kijunYMD;
        this.startYMD = startYMD;
        this.endYMD = endYMD;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.seinengappiYMDFrom = seinengappiYMDFrom;
        this.seinengappiYMDTo = seinengappiYMDTo;
        this.hokenshaNo = hokenshaNo;
        this.tiiki_From = tiiki_From;
        this.tiiki_To = tiiki_To;
        this.is認定結果0length0 = is認定結果0length0;
        this.is認定結果1length0 = is認定結果1length0;
        this.is認定結果1length非0 = is認定結果1length非0;
        this.is認定結果2length0 = is認定結果2length0;
        this.is認定結果2length非0 = is認定結果2length非0;
        this.is認定結果3length0 = is認定結果3length0;
        this.is認定結果3length非0 = is認定結果3length非0;
        this.is認定結果4length0 = is認定結果4length0;
        this.is認定結果4length非0 = is認定結果4length非0;
        this.is認定結果5length0 = is認定結果5length0;
        this.is認定結果5length非0 = is認定結果5length非0;
        this.is認定結果6length0 = is認定結果6length0;
        this.is認定結果6length非0 = is認定結果6length非0;
        this.is認定結果7length0 = is認定結果7length0;
        this.is認定結果7length非0 = is認定結果7length非0;
        this.is認定結果8length0 = is認定結果8length0;
        this.is認定結果8length非0 = is認定結果8length非0;
        this.is認定結果9length0 = is認定結果9length0;
        this.is認定結果9length非0 = is認定結果9length非0;
        this.is認定結果10length0 = is認定結果10length0;
        this.is認定結果10length非0 = is認定結果10length非0;
        this.出力順 = 出力順;
    }
}
