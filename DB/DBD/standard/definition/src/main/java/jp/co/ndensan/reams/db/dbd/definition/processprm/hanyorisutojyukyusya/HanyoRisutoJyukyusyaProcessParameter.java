/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutojyukyusya;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutojyukyusya.HanyoRisutoJyukyusyaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト受給者台帳のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoJyukyusyaProcessParameter implements IBatchProcessParameter {

    private final RString 直近 = new RString("1");
    private ChushutsuHohoKubun 抽出方法区分;
    private boolean is直近 = false;
    private boolean is有効データ内最新;
    private boolean is抽出方法区分_基準日 = false;
    private boolean is抽出方法区分_範囲 = false;
    private boolean is日付範囲From = false;
    private boolean is日付範囲To = false;
    private boolean is資格取得者のみ = false;
    private boolean is資格喪失者のみ = false;
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
    private boolean 認定結果_0;
    private boolean 認定結果_1;
    private boolean 認定結果_2;
    private boolean 認定結果_3;
    private boolean 認定結果_4;
    private boolean 認定結果_5;
    private boolean 認定結果_6;
    private boolean 認定結果_7;
    private boolean 認定結果_8;
    private boolean 認定結果_9;
    private boolean 認定結果_10;
    private SoshitsuKubun 喪失区分;
    private boolean 一号被保険者;
    private boolean 二号被保険者;
    private boolean サービス指定者;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private Long 出力順Id;
    private RString 出力項目;
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
     * @param 抽出方法区分 ChushutsuHohoKubun
     * @param 有効データ内最新 boolean
     * @param 基準日 FlexibleDate
     * @param 日付範囲From FlexibleDate
     * @param 日付範囲To FlexibleDate
     * @param 認定結果_0 boolean
     * @param 認定結果_1 boolean
     * @param 認定結果_2 boolean
     * @param 認定結果_3 boolean
     * @param 認定結果_4 boolean
     * @param 認定結果_5 boolean
     * @param 認定結果_6 boolean
     * @param 認定結果_7 boolean
     * @param 認定結果_8 boolean
     * @param 認定結果_9 boolean
     * @param 認定結果_10 boolean
     * @param 喪失区分 SoshitsuKubun
     * @param 旧措置者 boolean
     * @param 一号被保険者 boolean
     * @param 二号被保険者 boolean
     * @param サービス指定者 boolean
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付スラッシュ付加 boolean
     * @param 宛名抽出条件 AtenaSelectBatchParameter
     * @param 出力順 Long
     * @param 出力項目 RString
     */
    public HanyoRisutoJyukyusyaProcessParameter(ChushutsuHohoKubun 抽出方法区分,
            boolean 有効データ内最新,
            FlexibleDate 基準日,
            FlexibleDate 日付範囲From,
            FlexibleDate 日付範囲To,
            boolean 認定結果_0,
            boolean 認定結果_1,
            boolean 認定結果_2,
            boolean 認定結果_3,
            boolean 認定結果_4,
            boolean 認定結果_5,
            boolean 認定結果_6,
            boolean 認定結果_7,
            boolean 認定結果_8,
            boolean 認定結果_9,
            boolean 認定結果_10,
            SoshitsuKubun 喪失区分,
            boolean 旧措置者,
            boolean 一号被保険者,
            boolean 二号被保険者,
            boolean サービス指定者,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            AtenaSelectBatchParameter 宛名抽出条件,
            Long 出力順,
            RString 出力項目) {
        this.抽出方法区分 = 抽出方法区分;
        this.is有効データ内最新 = 有効データ内最新;
        this.kijunYMD = 基準日;
        this.startYMD = 日付範囲From;
        this.endYMD = 日付範囲To;
        this.認定結果_0 = 認定結果_0;
        this.認定結果_1 = 認定結果_1;
        this.認定結果_2 = 認定結果_2;
        this.認定結果_3 = 認定結果_3;
        this.認定結果_4 = 認定結果_4;
        this.認定結果_5 = 認定結果_5;
        this.認定結果_6 = 認定結果_6;
        this.認定結果_7 = 認定結果_7;
        this.認定結果_8 = 認定結果_8;
        this.認定結果_9 = 認定結果_9;
        this.認定結果_10 = 認定結果_10;
        this.喪失区分 = 喪失区分;
        this.is旧措置者 = 旧措置者;
        this.一号被保険者 = 一号被保険者;
        this.二号被保険者 = 二号被保険者;
        this.サービス指定者 = サービス指定者;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順Id = 出力順;
        this.出力項目 = 出力項目;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @param 出力順 RString
     * @return HanyoRisutoJyukyusyaDaichoMybatisParameter
     */
    public HanyoRisutoJyukyusyaMybatisParameter toHanyoRisutoJyukyusyaMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順) {
        if (ChushutsuHohoKubun.直近.equals(抽出方法区分)) {
            is直近 = true;
        }
        if (ChushutsuHohoKubun.基準日.equals(抽出方法区分)) {
            is抽出方法区分_基準日 = true;
        }
        if (ChushutsuHohoKubun.範囲.equals(抽出方法区分)) {
            is抽出方法区分_範囲 = true;
        }
        if (startYMD != null && !startYMD.isEmpty()) {
            is日付範囲From = true;
        }
        if (endYMD != null && !endYMD.isEmpty()) {
            is日付範囲To = true;
        }
        int count = 0;
        if (認定結果_0) {
            is認定結果0length0 = true;
            count++;
        }
        if (認定結果_1 && count == 0) {
            is認定結果1length0 = true;
            count++;
        } else if (認定結果_1 && count != 0) {
            is認定結果1length非0 = true;
        }
        if (認定結果_2 && count == 0) {
            is認定結果2length0 = true;
            count++;
        } else if (認定結果_2 && count != 0) {
            is認定結果2length非0 = true;
        }
        set項目(count);
        set項目1();
        set項目2();
        set項目3();
        return new HanyoRisutoJyukyusyaMybatisParameter(psmShikibetsuTaisho,
                psmAtesaki, is直近, is有効データ内最新, is抽出方法区分_基準日,
                is抽出方法区分_範囲, is日付範囲From, is日付範囲To,
                is資格取得者のみ, is資格喪失者のみ, is旧措置者, is1号被保険者true2号被保険者true,
                is1号被保険者true2号被保険者false, is1号被保険者false2号被保険者true,
                isサービス指定者true, is宛名抽出区分_年齢, is宛名抽出区分_年齢From,
                is宛名抽出区分_年齢To, is宛名抽出区分_生年月日, is宛名抽出区分_生年月日From,
                is宛名抽出区分_生年月日To, is宛名抽出条件_保険者コード_非全部,
                is住所, is行政区, is地区1, is地区2, is地区3, 地区選択From, 地区選択To, kijunYMD, startYMD,
                endYMD, ageFrom, ageTo, seinengappiYMDFrom, seinengappiYMDTo, hokenshaNo, tiiki_From, tiiki_To,
                is認定結果0length0, is認定結果1length0, is認定結果1length非0, is認定結果2length0, is認定結果2length非0,
                is認定結果3length0, is認定結果3length非0, is認定結果4length0, is認定結果4length非0,
                is認定結果5length0, is認定結果5length非0, is認定結果6length0, is認定結果6length非0,
                is認定結果7length0, is認定結果7length非0, is認定結果8length0, is認定結果8length非0,
                is認定結果9length0, is認定結果9length非0, is認定結果10length0, is認定結果10length非0,
                出力順);
    }

    private void set項目(int count) {
        if (認定結果_3 && count == 0) {
            is認定結果3length0 = true;
            count++;
        } else if (認定結果_3 && count != 0) {
            is認定結果3length非0 = true;
        }
        if (認定結果_4 && count == 0) {
            is認定結果4length0 = true;
            count++;
        } else if (認定結果_4 && count != 0) {
            is認定結果4length非0 = true;
        }
        if (認定結果_5 && count == 0) {
            is認定結果5length0 = true;
            count++;
        } else if (認定結果_5 && count != 0) {
            is認定結果5length非0 = true;
        }
        if (認定結果_6 && count == 0) {
            is認定結果6length0 = true;
            count++;
        } else if (認定結果_6 && count != 0) {
            is認定結果6length非0 = true;
        }
        set項目4(count);
    }

    private void set項目4(int count) {
        if (認定結果_7 && count == 0) {
            is認定結果7length0 = true;
            count++;
        } else if (認定結果_7 && count != 0) {
            is認定結果7length非0 = true;
        }
        if (認定結果_8 && count == 0) {
            is認定結果8length0 = true;
            count++;
        } else if (認定結果_8 && count != 0) {
            is認定結果8length非0 = true;
        }
        if (認定結果_9 && count == 0) {
            is認定結果9length0 = true;
            count++;
        } else if (認定結果_9 && count != 0) {
            is認定結果9length非0 = true;
        }
        if (認定結果_10 && count == 0) {
            is認定結果10length0 = true;
            count++;
        } else if (認定結果_10 && count != 0) {
            is認定結果10length非0 = true;
        }
    }

    private void set項目1() {

        if (SoshitsuKubun.資格喪失者のみ.equals(喪失区分)) {
            is資格喪失者のみ = true;
        }
        if (一号被保険者 && 二号被保険者) {
            is1号被保険者true2号被保険者true = true;
        }
        if (一号被保険者 && !二号被保険者) {
            is1号被保険者true2号被保険者false = true;
        }
        if (!一号被保険者 && 二号被保険者) {
            is1号被保険者false2号被保険者true = true;
        }
        if (サービス指定者) {
            isサービス指定者true = true;
        }
        if (NenreiSoChushutsuHoho.年齢範囲.equals(宛名抽出条件.getAgeSelectKijun())) {
            is宛名抽出区分_年齢 = true;
            if (宛名抽出条件.getNenreiRange() != null && 宛名抽出条件.getNenreiRange().getFrom() != null) {
                ageFrom = FlexibleDate.getNowDate().minusYear(宛名抽出条件.getNenreiRange().getFrom().intValue());
                is宛名抽出区分_年齢From = true;
            }
            if (宛名抽出条件.getNenreiRange() != null && 宛名抽出条件.getNenreiRange().getTo() != null) {
                ageTo = FlexibleDate.getNowDate().minusYear(宛名抽出条件.getNenreiRange().getTo().intValue());
                is宛名抽出区分_年齢To = true;
            }
        }
        if (NenreiSoChushutsuHoho.生年月日範囲.equals(宛名抽出条件.getAgeSelectKijun())) {
            is宛名抽出区分_生年月日 = true;
            if (宛名抽出条件.getSeinengappiRange() != null && 宛名抽出条件.getSeinengappiRange().getFrom() != null) {
                seinengappiYMDFrom = 宛名抽出条件.getSeinengappiRange().getFrom().toFlexibleDate();
                is宛名抽出区分_生年月日From = true;
            }
            if (宛名抽出条件.getSeinengappiRange() != null && 宛名抽出条件.getSeinengappiRange().getTo() != null) {
                seinengappiYMDTo = 宛名抽出条件.getSeinengappiRange().getTo().toFlexibleDate();
                is宛名抽出区分_生年月日To = true;
            }
        }
    }

    private void set項目2() {
        if (SoshitsuKubun.資格取得者のみ.equals(喪失区分)) {
            is資格取得者のみ = true;
        }
        if (宛名抽出条件.getShichoson_Code() != null && !宛名抽出条件.getShichoson_Code().isEmpty()) {
            is宛名抽出条件_保険者コード_非全部 = true;
            hokenshaNo = 宛名抽出条件.getShichoson_Code().getColumnValue();
        }
        if (Chiku.住所.equals(宛名抽出条件.getChiku_Kubun())) {
            is住所 = true;
            if (宛名抽出条件.getJusho_From() != null && !宛名抽出条件.getJusho_From().isEmpty()) {
                地区選択From = true;
                tiiki_From = 宛名抽出条件.getJusho_From();
            }
            if (宛名抽出条件.getJusho_To() != null && !宛名抽出条件.getJusho_To().isEmpty()) {
                地区選択To = true;
                tiiki_To = 宛名抽出条件.getJusho_To();
            }
        }
        if (Chiku.行政区.equals(宛名抽出条件.getChiku_Kubun())) {
            is行政区 = true;
            if (宛名抽出条件.getGyoseiku_From() != null && !宛名抽出条件.getGyoseiku_From().isEmpty()) {
                地区選択From = true;
                tiiki_From = 宛名抽出条件.getGyoseiku_From();
            }
            if (宛名抽出条件.getGyoseiku_To() != null && !宛名抽出条件.getGyoseiku_To().isEmpty()) {
                地区選択To = true;
                tiiki_To = 宛名抽出条件.getGyoseiku_To();
            }
        }
    }

    private void set項目3() {
        if (Chiku.地区.equals(宛名抽出条件.getChiku_Kubun())) {
            is地区1 = true;
            is地区2 = true;
            is地区3 = true;
            if (宛名抽出条件.getChiku1_From() != null && !宛名抽出条件.getChiku1_From().isEmpty()) {
                地区選択From = true;
                tiiki_From = 宛名抽出条件.getChiku1_From();
            }
            if (宛名抽出条件.getChiku1_To() != null && !宛名抽出条件.getChiku1_To().isEmpty()) {
                地区選択To = true;
                tiiki_To = 宛名抽出条件.getChiku1_To();
            }
            if (宛名抽出条件.getChiku2_From() != null && !宛名抽出条件.getChiku2_From().isEmpty()) {
                地区選択From = true;
                tiiki_From = 宛名抽出条件.getChiku2_From();
            }
            if (宛名抽出条件.getChiku2_To() != null && !宛名抽出条件.getChiku2_To().isEmpty()) {
                地区選択To = true;
                tiiki_To = 宛名抽出条件.getChiku2_To();
            }
            if (宛名抽出条件.getChiku3_From() != null && !宛名抽出条件.getChiku3_From().isEmpty()) {
                地区選択From = true;
                tiiki_From = 宛名抽出条件.getChiku3_From();
            }
            if (宛名抽出条件.getChiku3_To() != null && !宛名抽出条件.getChiku3_To().isEmpty()) {
                地区選択To = true;
                tiiki_To = 宛名抽出条件.getChiku3_To();
            }
        }
    }
}
