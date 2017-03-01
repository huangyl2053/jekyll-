/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteijohoteikyoisshiki;

/**
 * 要介護認定情報提供一式の列挙型です。
 *
 * @author N3212 竹内 和紀
 */
public enum JohoTeikyoIsshiki {

    /**
     * NinteiChosaJohohyo_DBE091002<br/>
     * formGroupIndex：1
     */
    NinteiChosaJohohyo_DBE091002(1),
    /**
     * NinteiChosaTokkiImage1<br/>
     * formGroupIndex：2
     */
    NinteiChosaTokkiImage1(2),
    /**
     * NinteiChosaTokkiImage2<br/>
     * formGroupIndex：3
     */
    NinteiChosaTokkiImage2(3),
    /**
     * NinteiChosaJohohyo_DBE091012<br/>
     * formGroupIndex：4
     */
    NinteiChosaJohohyo_DBE091012(4),
    /**
     * NinteiChosaJohohyo_DBE091022<br/>
     * formGroupIndex：5
     */
    NinteiChosaJohohyo_DBE091022(5),
    /**
     * _06ANinteiChosaJohohyo<br/>
     * formGroupIndex：6
     */
    _06ANinteiChosaJohohyo(6),
    /**
     * _02ANinteiChosaJohohyo<br/>
     * formGroupIndex：7
     */
    _02ANinteiChosaJohohyo(7),
    /**
     * _99ANinteiChosaJohohyo<br/>
     * formGroupIndex：8
     */
    _99ANinteiChosaJohohyo(8),
    /**
     * TokkiTextAll_text_separate<br/>
     * formGroupIndex：11
     */
    TokkiTextAll_text_separate(11),
    /**
     * TokkiTextAll_text2_separate<br/>
     * formGroupIndex：12
     */
    TokkiTextAll_text2_separate(12),
    /**
     * TokkiTextAll_image_all<br/>
     * formGroupIndex：13
     */
    TokkiTextAll_image_all(13),
    /**
     * TokkiTextAll_image2_all<br/>
     * formGroupIndex：14
     */
    TokkiTextAll_image2_all(14),
    /**
     * TokkiTextAll_image_separate<br/>
     * formGroupIndex：15
     */
    TokkiTextAll_image_separate(15),
    /**
     * TokkiTextAll_image2_separate<br/>
     * formGroupIndex：16
     */
    TokkiTextAll_image2_separate(16),
    /**
     * TokkiTextSeparate1<br/>
     * formGroupIndex：18
     */
    TokkiTextSeparate1(18),
    /**
     * TokkiTextSeparate2<br/>
     * formGroupIndex：19
     */
    TokkiTextSeparate2(19),
    /**
     * TokkiImageSeparate1<br/>
     * formGroupIndex：21
     */
    TokkiImageSeparate1(21),
    /**
     * TokkiImageSeparate2<br/>
     * formGroupIndex：22
     */
    TokkiImageSeparate2(22),
    /**
     * Shujiiikensho1<br/>
     * formGroupIndex：31
     */
    Shujiiikensho1(31),
    /**
     * Shujiiikensho2<br/>
     * formGroupIndex：32
     */
    Shujiiikensho2(32),
    /**
     * Sonotashiryo<br/>
     * formGroupIndex：40
     */
    Sonotashiryo(40),
    /**
     * Ichijihanteikekkahyo<br/>
     * formGroupIndex：50
     */
    Ichijihanteikekkahyo(50);

    private final int formGroupIndex;

    private JohoTeikyoIsshiki(int formGroupIndex) {
        this.formGroupIndex = formGroupIndex;
    }

    /**
     * formGroupIndexを返します。
     *
     * @return formGroupIndex
     */
    public int getFormGroupIndex() {
        return formGroupIndex;
    }
}
