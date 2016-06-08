/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

/**
 * 認知症高齢者の日常生活自立度を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 認知症高齢者日常生活自立度
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum NinchishoKoreishaNichijoSeikatsuJiritsudo {

    /**
     *
     */
    自立,
    /**
     * 何らかの認知症を有するが、日常生活は家庭内及び社会的にほぼ自立している。
     */
    Ⅰ,
    /**
     * 家庭外で日常生活に支障を来たすような症状・行動や意思疎通の困難さが多少見られても、誰かが注意していれば自立できる。
     */
    Ⅱa,
    /**
     * 家庭内で日常生活に支障を来たすような症状・行動や意思疎通の困難さが多少見られても、誰かが注意していれば自立できる。
     */
    Ⅱb,
    /**
     * 日中を中心として日常生活に支障を来たすような症状・行動や意思疎通の困難さが見られ、介護を必要とする。
     */
    Ⅲa,
    /**
     * 夜間を中心として日常生活に支障を来たすような症状・行動や意思疎通の困難さが見られ、介護を必要とする。
     */
    Ⅲb,
    /**
     * 日常生活に支障を来たすような症状・行動や意思疎通の困難さが頻繁に見られ、常に介護を必要とする。
     */
    Ⅳ,
    /**
     * 著しい精神症状や周辺症状あるいは重篤な身体疾患が見られ、専門医療を必要とする。
     */
    Ｍ;
}
