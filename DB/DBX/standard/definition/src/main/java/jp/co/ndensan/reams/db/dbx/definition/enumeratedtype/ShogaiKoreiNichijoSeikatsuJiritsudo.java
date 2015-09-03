/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

/**
 * 障害高齢者の日常生活自立度を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 障害高齢者日常生活自立度
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum ShogaiKoreiNichijoSeikatsuJiritsudo {

    /**
     * 自立できている。
     */
    自立,
    /**
     * 交通機関等を利用して外出する。
     */
    J1,
    /**
     * 隣近所なら外出する。
     */
    J2,
    /**
     * 介助により外出し、日中はほとんどベットから離れて生活する。
     */
    A1,
    /**
     * 外出の頻度が少なく、日中も寝たり起きたりの生活をしている。
     */
    A2,
    /**
     * 車いすに移乗し、食事、排泄はベットから離れて行う。
     */
    B1,
    /**
     * 車いすに移乗し、食事、排泄はベットから離れて行う。
     */
    B2,
    /**
     * 一日中ベット上で過ごし、排泄、食事、着替において介助を要する。
     */
    C1,
    /**
     * 自力では寝返りもうたない。
     */
    C2;
}
