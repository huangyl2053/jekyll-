/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護保険被保険者証一括作成モードクラスです。
 */
public class HihokenshashoIkkatsuHakkoModel implements Serializable {

    private YMDHMS kijunTimestamp;
    private FlexibleDate taishoKaishiYMD;
    private FlexibleDate taishoShuryoYMD;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;

    /**
     * 基準日時のgetメソッドです。
     *
     * @return 基準日時
     */
    public YMDHMS getKijunTimestamp() {
        return kijunTimestamp;
    }

    /**
     * 基準日時のsetメソッドです。
     *
     * @param kijunTimestamp 基準日時
     */
    public void setKijunTimestamp(YMDHMS kijunTimestamp) {
        this.kijunTimestamp = kijunTimestamp;
    }

    /**
     * 対象終了年月日のsetメソッドです。
     *
     * @param taishoShuryoYMD 対象終了年月日
     */
    public void setTaishoShuryoYMD(FlexibleDate taishoShuryoYMD) {
        this.taishoShuryoYMD = taishoShuryoYMD;
    }

    /**
     * 対象終了年月日のgetメソッドです。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate getTaishoShuryoYMD() {
        return taishoShuryoYMD;
    }

    /**
     * 対象開始日時のgetメソッドです。
     *
     * @return 対象開始日時
     */
    public YMDHMS getTaishoKaishiTimestamp() {
        return taishoKaishiTimestamp;
    }

    /**
     * 対象開始日時のsetメソッドです。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     */
    public void setTaishoKaishiTimestamp(YMDHMS taishoKaishiTimestamp) {
        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
    }

    /**
     * 対象終了日時のgetメソッドです。
     *
     * @return 対象終了日時
     */
    public YMDHMS getTaishoShuryoTimestamp() {
        return taishoShuryoTimestamp;
    }

    /**
     * 対象終了日時のsetメソッドです。
     *
     * @param taishoShuryoTimestamp 対象終了日時
     */
    public void setTaishoShuryoTimestamp(YMDHMS taishoShuryoTimestamp) {
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
    }

    /**
     * 対象開始年月日のgetメソッドです。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate getTaishoKaishiYMD() {
        return taishoKaishiYMD;
    }

    /**
     * 対象開始年月日のsetメソッドです。
     *
     * @param taishoKaishiYMD 対象開始年月日
     */
    public void setTaishoKaishiYMD(FlexibleDate taishoKaishiYMD) {
        this.taishoKaishiYMD = taishoKaishiYMD;
    }
}
