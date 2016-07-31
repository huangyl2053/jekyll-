/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolistroreifukushinenkinjukyusha;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.rorei.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_老齢福祉年金受給者のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1620-030 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListRoreiFukushiNenkinJukyushaMybatisParameter implements IMyBatisParameter {

    private final RString kijunYMD;
    private final RString chushutsunichiFrom;
    private final RString chushutsunichiTo;
    private final boolean is直近;
    private final boolean is基準日;
    private final boolean is範囲;
    private final boolean is老齢開始日;
    private final boolean has範囲抽出日From;
    private final boolean has範囲抽出日To;
    private final boolean is老齢終了日;
    private final boolean is年齢;
    private final boolean has年齢範囲開始;
    private final boolean has年齢範囲終了;
    private final RDate 生年月日範囲終了;
    private final RDate 生年月日範囲開始;
    private final boolean is生年月日;
    private final boolean has生年月日範囲終了;
    private final boolean has生年月日範囲開始;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param kijunYMD 基準日
     * @param chushutsunichiFrom 範囲抽出日From
     * @param chushutsunichiTo 範囲抽出日To
     * @param is直近 日付抽出区分.直近
     * @param is基準日 日付抽出区分.基準日
     * @param is範囲 日付抽出区分.範囲
     * @param is老齢開始日 範囲抽出日区分.老齢開始日
     * @param is老齢終了日 範囲抽出日区分.老齢終了日
     * @param has範囲抽出日From 範囲抽出日Fromあり
     * @param has範囲抽出日To 範囲抽出日Toあり
     * @param is年齢 is年齢
     * @param has年齢範囲開始 has年齢範囲開始
     * @param has年齢範囲終了 has年齢範囲終了
     * @param 生年月日範囲終了 生年月日範囲終了
     * @param 生年月日範囲開始 生年月日範囲開始
     * @param is生年月日 is生年月日
     * @param has生年月日範囲終了 has生年月日範囲終了
     * @param has生年月日範囲開始 has生年月日範囲開始
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     */
    protected HanyoListRoreiFukushiNenkinJukyushaMybatisParameter(
            RString kijunYMD,
            RString chushutsunichiFrom,
            RString chushutsunichiTo,
            boolean is直近,
            boolean is基準日,
            boolean is範囲,
            boolean is老齢開始日,
            boolean is老齢終了日,
            boolean has範囲抽出日From,
            boolean has範囲抽出日To,
            boolean is年齢,
            boolean has年齢範囲開始,
            boolean has年齢範囲終了,
            RDate 生年月日範囲終了,
            RDate 生年月日範囲開始,
            boolean is生年月日,
            boolean has生年月日範囲終了,
            boolean has生年月日範囲開始,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        this.kijunYMD = kijunYMD;
        this.chushutsunichiFrom = chushutsunichiFrom;
        this.chushutsunichiTo = chushutsunichiTo;
        this.is直近 = is直近;
        this.is基準日 = is基準日;
        this.is範囲 = is範囲;
        this.is老齢開始日 = is老齢開始日;
        this.has範囲抽出日From = has範囲抽出日From;
        this.has範囲抽出日To = has範囲抽出日To;
        this.is老齢終了日 = is老齢終了日;
        this.is年齢 = is年齢;
        this.has年齢範囲開始 = has年齢範囲開始;
        this.has年齢範囲終了 = has年齢範囲終了;
        this.生年月日範囲終了 = 生年月日範囲終了;
        this.生年月日範囲開始 = 生年月日範囲開始;
        this.is生年月日 = is生年月日;
        this.has生年月日範囲終了 = has生年月日範囲終了;
        this.has生年月日範囲開始 = has生年月日範囲開始;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }

    /**
     * パラメータを作成します。
     *
     * @param 宛名抽出年齢開始 宛名抽出年齢開始
     * @param 宛名抽出年齢終了 宛名抽出年齢終了
     * @param 宛名抽出生年月日開始 宛名抽出生年月日開始
     * @param 宛名抽出生年月日終了 宛名抽出生年月日終了
     * @param 年齢基準日 年齢基準日
     * @param 年齢層抽出方法 年齢層抽出方法
     * @param 日付抽出区分 日付抽出区分
     * @param 基準日 基準日
     * @param 範囲抽出日区分 範囲抽出日区分
     * @param 範囲抽出日From 範囲抽出日From
     * @param 範囲抽出日To 範囲抽出日To
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @return HanyoListRoreiFukushiNenkinJukyushaMybatisParameter
     */
    public static HanyoListRoreiFukushiNenkinJukyushaMybatisParameter creatParameter(
            Decimal 宛名抽出年齢開始,
            Decimal 宛名抽出年齢終了,
            RDate 宛名抽出生年月日開始,
            RDate 宛名抽出生年月日終了,
            RDate 年齢基準日,
            RString 年齢層抽出方法,
            RString 日付抽出区分,
            RString 基準日,
            RString 範囲抽出日区分,
            RString 範囲抽出日From,
            RString 範囲抽出日To,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        boolean is年齢 = false;
        boolean is生年月日 = false;
        boolean isChokkinFlag = false;
        boolean isKijunYMDFlag = false;
        boolean isHaniFlag = false;
        boolean isKaishiYMDFlag = false;
        boolean isShuryoYMDFlag = false;
        boolean hasFromFlag = false;
        boolean hasToFlag = false;
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法)) {
            is年齢 = true;
        } else if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(年齢層抽出方法)) {
            is生年月日 = true;
        }
        boolean has年齢範囲開始 = nullHandan(宛名抽出年齢開始);
        boolean has年齢範囲終了 = nullHandan(宛名抽出年齢終了);
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法) && 宛名抽出年齢開始 != null) {
            宛名抽出生年月日終了 = 年齢基準日.minusYear(宛名抽出年齢開始.add(1).intValue()).plusDay(2);
        }
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法) && 宛名抽出年齢終了 != null) {
            宛名抽出生年月日開始 = 年齢基準日.minusYear(宛名抽出年齢終了.intValue()).plusDay(1);
        }
        boolean has生年月日範囲開始 = nullHandan(宛名抽出生年月日開始);
        boolean has生年月日範囲終了 = nullHandan(宛名抽出生年月日終了);
        if (HizukeChushutsuKubun.直近.getコード().equals(日付抽出区分)) {
            isChokkinFlag = true;
        }
        if (HizukeChushutsuKubun.基準日.getコード().equals(日付抽出区分)) {
            isKijunYMDFlag = true;
        }
        if (HizukeChushutsuKubun.範囲.getコード().equals(日付抽出区分)) {
            isHaniFlag = true;
        }
        if (HaniChushutsubiKubun.老齢開始日.getコード().equals(範囲抽出日区分)) {
            isKaishiYMDFlag = true;
        }
        if (HaniChushutsubiKubun.老齢終了日.getコード().equals(範囲抽出日区分)) {
            isShuryoYMDFlag = true;
        }
        if (!RString.isNullOrEmpty(範囲抽出日From)) {
            hasFromFlag = true;
        }
        if (!RString.isNullOrEmpty(範囲抽出日To)) {
            hasToFlag = true;
        }
        return new HanyoListRoreiFukushiNenkinJukyushaMybatisParameter(
                基準日,
                範囲抽出日From,
                範囲抽出日To,
                isChokkinFlag,
                isKijunYMDFlag,
                isHaniFlag,
                isKaishiYMDFlag,
                isShuryoYMDFlag,
                hasFromFlag,
                hasToFlag,
                is年齢,
                has年齢範囲開始,
                has年齢範囲終了,
                宛名抽出生年月日終了,
                宛名抽出生年月日開始,
                is生年月日,
                has生年月日範囲終了,
                has生年月日範囲開始,
                psmShikibetsuTaisho,
                psmAtesaki);
    }

    private static boolean nullHandan(Decimal 宛名抽出年齢) {
        return 宛名抽出年齢 != null;
    }

    private static boolean nullHandan(RDate 年月日) {
        return 年月日 != null;
    }
}
