/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 保険料段階判定パラメータというクラスです。
 *
 */
public class NengakuHokenryoKeisanParameter {

    private FlexibleYear 賦課年度;
    private NengakuFukaKonkyo 年額賦課根拠;
    private NengakuSeigyoJoho 年額制御情報;

    /**
     * 賦課年度を取得する。
     *
     * @return FlexibleDate
     */
    public FlexibleYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 年額賦課根拠を取得する。
     *
     * @return NengakuFukaKonkyo
     */
    public NengakuFukaKonkyo get年額賦課根拠() {
        return 年額賦課根拠;
    }

    /**
     * 年額制御情報を取得する。
     *
     * @return NengakuSeigyoJoho
     */
    public NengakuSeigyoJoho get年額制御情報() {
        return 年額制御情報;
    }

    /**
     * 賦課年度を設定する。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        this.賦課年度 = 賦課年度;
    }

    /**
     * 年額賦課根拠を設定する。
     *
     * @param 年額賦課根拠 年額賦課根拠
     */
    public void set年額賦課根拠(NengakuFukaKonkyo 年額賦課根拠) {
        this.年額賦課根拠 = 年額賦課根拠;
    }

    /**
     * 年額制御情報を設定する。
     *
     * @param 年額制御情報 年額制御情報
     */
    public void set年額制御情報(NengakuSeigyoJoho 年額制御情報) {
        this.年額制御情報 = 年額制御情報;
    }
}
