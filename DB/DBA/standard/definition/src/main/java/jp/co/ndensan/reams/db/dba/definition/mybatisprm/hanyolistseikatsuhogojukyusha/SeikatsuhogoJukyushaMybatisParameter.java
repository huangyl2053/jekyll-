/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolistseikatsuhogojukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.seiho.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 汎用リスト_生活保護受給者のMyBatisパラメータ。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SeikatsuhogoJukyushaMybatisParameter implements IMyBatisParameter {

    private final RString hitsukeChushutsuKubun;
    private final RString kijunYMD;
    private final RString chushutsunichiKubun;
    private final RString chushutsunichiFrom;
    private final RString chushutsunichiTo;
    private final List<RString> fujoShurui;
    private final boolean isFujoShuruiFlag;
    private final boolean isChokkinFlag;
    private final boolean isKijunYMDFlag;
    private final boolean isHaniFlag;
    private final boolean isKaishiYMDFlag;
    private final boolean isShuryoYMDFlag;
    private final boolean isFromFlag;
    private final boolean isToFlag;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;
    private final boolean is年齢;
    private final boolean has年齢範囲開始;
    private final boolean has年齢範囲終了;
    private final RString 生年月日範囲終了;
    private final RString 生年月日範囲開始;
    private final boolean is生年月日;
    private final boolean has生年月日範囲終了;
    private final boolean has生年月日範囲開始;

    /**
     * コンストラクタです。
     *
     * @param hitsukeChushutsuKubun 日付抽出区分
     * @param kijunYMD 基準日
     * @param chushutsunichiKubun 範囲抽出日区分
     * @param chushutsunichiFrom 範囲抽出日From
     * @param chushutsunichiTo 範囲抽出日To
     * @param fujoShurui 扶助種類
     * @param isFujoShuruiFlag 扶助種類あり
     * @param isChokkinFlag 日付抽出区分.直近
     * @param isKijunYMDFlag 日付抽出区分.基準日
     * @param isHaniFlag 日付抽出区分.範囲
     * @param isKaishiYMDFlag 範囲抽出日区分.生保開始日
     * @param isShuryoYMDFlag 範囲抽出日区分.生保終了日
     * @param isFromFlag 範囲抽出日Fromあり
     * @param isToFlag 範囲抽出日Toあり
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @param is年齢 is年齢
     * @param has年齢範囲開始 has年齢範囲開始
     * @param has年齢範囲終了 has年齢範囲終了
     * @param 生年月日範囲終了 生年月日範囲終了
     * @param 生年月日範囲開始 生年月日範囲開始
     * @param is生年月日 is生年月日
     * @param has生年月日範囲終了 has生年月日範囲終了
     * @param has生年月日範囲開始 has生年月日範囲開始
     */
    protected SeikatsuhogoJukyushaMybatisParameter(
            RString hitsukeChushutsuKubun,
            RString kijunYMD,
            RString chushutsunichiKubun,
            RString chushutsunichiFrom,
            RString chushutsunichiTo,
            List<RString> fujoShurui,
            boolean isFujoShuruiFlag,
            boolean isChokkinFlag,
            boolean isKijunYMDFlag,
            boolean isHaniFlag,
            boolean isKaishiYMDFlag,
            boolean isShuryoYMDFlag,
            boolean isFromFlag,
            boolean isToFlag,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            boolean is年齢,
            boolean has年齢範囲開始,
            boolean has年齢範囲終了,
            RDate 生年月日範囲終了,
            RDate 生年月日範囲開始,
            boolean is生年月日,
            boolean has生年月日範囲終了,
            boolean has生年月日範囲開始) {

        this.hitsukeChushutsuKubun = hitsukeChushutsuKubun;
        this.kijunYMD = kijunYMD;
        this.chushutsunichiKubun = chushutsunichiKubun;
        this.chushutsunichiFrom = chushutsunichiFrom;
        this.chushutsunichiTo = chushutsunichiTo;
        this.fujoShurui = fujoShurui;
        this.isFujoShuruiFlag = isFujoShuruiFlag;
        this.isChokkinFlag = isChokkinFlag;
        this.isKijunYMDFlag = isKijunYMDFlag;
        this.isHaniFlag = isHaniFlag;
        this.isKaishiYMDFlag = isKaishiYMDFlag;
        this.isShuryoYMDFlag = isShuryoYMDFlag;
        this.isFromFlag = isFromFlag;
        this.isToFlag = isToFlag;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.is年齢 = is年齢;
        this.has年齢範囲開始 = has年齢範囲開始;
        this.has年齢範囲終了 = has年齢範囲終了;
        if (nullHandan(生年月日範囲終了)) {
            this.生年月日範囲終了 = 生年月日範囲終了.toDateString();
        } else {
            this.生年月日範囲終了 = RString.EMPTY;
        }
        if (nullHandan(生年月日範囲開始)) {
            this.生年月日範囲開始 = 生年月日範囲開始.toDateString();
        } else {
            this.生年月日範囲開始 = RString.EMPTY;
        }
        this.is生年月日 = is生年月日;
        this.has生年月日範囲終了 = has生年月日範囲終了;
        this.has生年月日範囲開始 = has生年月日範囲開始;
    }

    /**
     * パラメータを作成します。
     *
     * @param hitsukeChushutsuKubun 日付抽出区分
     * @param kijunYMD 基準日
     * @param chushutsunichiKubun 範囲抽出日区分
     * @param chushutsunichiFrom 範囲抽出日From
     * @param chushutsunichiTo 範囲抽出日To
     * @param fujoShurui 扶助種類
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @param 宛名抽出年齢開始 宛名抽出年齢開始
     * @param 宛名抽出年齢終了 宛名抽出年齢終了
     * @param 宛名抽出生年月日開始 宛名抽出生年月日開始
     * @param 宛名抽出生年月日終了 宛名抽出生年月日終了
     * @param 年齢基準日 年齢基準日
     * @param 年齢層抽出方法 年齢層抽出方法
     * @return SeikatsuhogoJukyushaMybatisParameter
     */
    public static SeikatsuhogoJukyushaMybatisParameter creatParameter(
            RString hitsukeChushutsuKubun,
            RString kijunYMD,
            RString chushutsunichiKubun,
            RString chushutsunichiFrom,
            RString chushutsunichiTo,
            List<RString> fujoShurui,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            Decimal 宛名抽出年齢開始,
            Decimal 宛名抽出年齢終了,
            RDate 宛名抽出生年月日開始,
            RDate 宛名抽出生年月日終了,
            RDate 年齢基準日,
            RString 年齢層抽出方法) {
        boolean isFujoShuruiFlag = false;
        boolean isChokkinFlag = false;
        boolean isKijunYMDFlag = false;
        boolean isHaniFlag = false;
        boolean isKaishiYMDFlag = false;
        boolean isShuryoYMDFlag = false;
        boolean isFromFlag = false;
        boolean isToFlag = false;
        boolean is年齢 = false;
        boolean is生年月日 = false;
        if (!fujoShurui.isEmpty()) {
            isFujoShuruiFlag = true;
        }
        if (HizukeChushutsuKubun.直近.getコード().equals(hitsukeChushutsuKubun)) {
            isChokkinFlag = true;
        }
        if (HizukeChushutsuKubun.基準日.getコード().equals(hitsukeChushutsuKubun)) {
            isKijunYMDFlag = true;
        }
        if (HizukeChushutsuKubun.範囲.getコード().equals(hitsukeChushutsuKubun)) {
            isHaniFlag = true;
        }
        if (HaniChushutsubiKubun.生保開始日.getコード().equals(chushutsunichiKubun)) {
            isKaishiYMDFlag = true;
        }
        if (HaniChushutsubiKubun.生保終了日.getコード().equals(chushutsunichiKubun)) {
            isShuryoYMDFlag = true;
        }
        if (!RString.isNullOrEmpty(chushutsunichiFrom)) {
            isFromFlag = true;
        }
        if (!RString.isNullOrEmpty(chushutsunichiTo)) {
            isToFlag = true;
        }
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
        return new SeikatsuhogoJukyushaMybatisParameter(
                hitsukeChushutsuKubun,
                kijunYMD,
                chushutsunichiKubun,
                chushutsunichiFrom,
                chushutsunichiTo,
                fujoShurui,
                isFujoShuruiFlag,
                isChokkinFlag,
                isKijunYMDFlag,
                isHaniFlag,
                isKaishiYMDFlag,
                isShuryoYMDFlag,
                isFromFlag,
                isToFlag,
                psmShikibetsuTaisho,
                psmAtesaki,
                is年齢,
                has年齢範囲開始,
                has年齢範囲終了,
                宛名抽出生年月日終了,
                宛名抽出生年月日開始,
                is生年月日,
                has生年月日範囲終了,
                has生年月日範囲開始);
    }

    private static boolean nullHandan(Decimal 宛名抽出年齢) {
        return 宛名抽出年齢 != null;
    }

    private static boolean nullHandan(RDate 年月日) {
        return 年月日 != null;
    }
}
