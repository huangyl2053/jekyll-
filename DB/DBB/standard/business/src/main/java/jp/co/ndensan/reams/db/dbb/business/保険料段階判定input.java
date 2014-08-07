/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

/**
 *
 * @author n3336
 */
public class 保険料段階判定input {
    public String 賦課年度;
    public NengakuFukaKonkyo 年額賦課根拠;
    public NengakuSeigyoJoho 年額制御情報;

    public String get賦課年度() {
        return 賦課年度;
    }

    public NengakuFukaKonkyo get年額賦課根拠() {
        return 年額賦課根拠;
    }

    public NengakuSeigyoJoho get年額制御情報() {
        return 年額制御情報;
    }

    public void set賦課年度(String 賦課年度) {
        this.賦課年度 = 賦課年度;
    }

    public void set年額賦課根拠(NengakuFukaKonkyo 年額賦課根拠) {
        this.年額賦課根拠 = 年額賦課根拠;
    }

    public void set年額制御情報(NengakuSeigyoJoho 年額制御情報) {
        this.年額制御情報 = 年額制御情報;
    }
}
