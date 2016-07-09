/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolistseikatsuhogojukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
            RString psmAtesaki) {

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
            RString psmAtesaki) {
        boolean isFujoShuruiFlag = false;
        boolean isChokkinFlag = false;
        boolean isKijunYMDFlag = false;
        boolean isHaniFlag = false;
        boolean isKaishiYMDFlag = false;
        boolean isShuryoYMDFlag = false;
        boolean isFromFlag = false;
        boolean isToFlag = false;
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
        if (RString.isNullOrEmpty(chushutsunichiFrom)) {
            isFromFlag = true;
        }
        if (RString.isNullOrEmpty(chushutsunichiTo)) {
            isToFlag = true;
        }
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
                psmAtesaki);
    }
}
