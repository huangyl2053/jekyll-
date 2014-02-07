/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun1;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査第1群）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon1 {

    private final ChosaKekkaKubun1.MahiHidariJoshi 麻痺左上肢;
    private final ChosaKekkaKubun1.MahiMigiJoshi 麻痺右上肢;
    private final ChosaKekkaKubun1.MahiHidariKashi 麻痺左下肢;
    private final ChosaKekkaKubun1.MahiMigiKashi 麻痺右下肢;
    private final ChosaKekkaKubun1.MahiSonota 麻痺その他;
    private final ChosaKekkaKubun1.KoshukuKata 拘縮肩関節;
    private final ChosaKekkaKubun1.KoshukuMata 拘縮股関節;
    private final ChosaKekkaKubun1.KoshukuHiza 拘縮膝関節;
    private final ChosaKekkaKubun1.KoshukuSonota 拘縮その他;
    private final ChosaKekkaKubun1.Negaeri 寝返り;
    private final ChosaKekkaKubun1.Okiagari 起き上がり;
    private final ChosaKekkaKubun1.Zaihoji 座位保持;
    private final ChosaKekkaKubun1.RyoashiRitsui 両足での立位;
    private final ChosaKekkaKubun1.Hoko 歩行;
    private final ChosaKekkaKubun1.Tachiagari 立ち上がり;
    private final ChosaKekkaKubun1.KataashiRitsui 片足での立位;
    private final ChosaKekkaKubun1.Senshin 洗身;
    private final ChosaKekkaKubun1.Tsumekiri つめ切り;
    private final ChosaKekkaKubun1.Shiryoku 視力;
    private final ChosaKekkaKubun1.Choryoku 聴力;

    /**
     * インスタンスを生成します。
     *
     * @param 麻痺左上肢 麻痺左上肢
     * @param 麻痺右上肢 麻痺右上肢
     * @param 麻痺左下肢 麻痺左下肢
     * @param 麻痺右下肢 麻痺右下肢
     * @param 麻痺その他 麻痺その他
     * @param 拘縮肩関節 拘縮肩関節
     * @param 拘縮股関節 拘縮股関節
     * @param 拘縮膝関節 拘縮膝関節
     * @param 拘縮その他 拘縮その他
     * @param 寝返り 寝返り
     * @param 起き上がり 起き上がり
     * @param 座位保持 座位保持
     * @param 両足での立位 両足での立位
     * @param 歩行 歩行
     * @param 立ち上がり 立ち上がり
     * @param 片足での立位 片足での立位
     * @param 洗身 洗身
     * @param つめ切り つめ切り
     * @param 視力 視力
     * @param 聴力 聴力
     */
    public ChosaKekkaKihon1(
            ChosaKekkaKubun1.MahiHidariJoshi 麻痺左上肢,
            ChosaKekkaKubun1.MahiMigiJoshi 麻痺右上肢,
            ChosaKekkaKubun1.MahiHidariKashi 麻痺左下肢,
            ChosaKekkaKubun1.MahiMigiKashi 麻痺右下肢,
            ChosaKekkaKubun1.MahiSonota 麻痺その他,
            ChosaKekkaKubun1.KoshukuKata 拘縮肩関節,
            ChosaKekkaKubun1.KoshukuMata 拘縮股関節,
            ChosaKekkaKubun1.KoshukuHiza 拘縮膝関節,
            ChosaKekkaKubun1.KoshukuSonota 拘縮その他,
            ChosaKekkaKubun1.Negaeri 寝返り,
            ChosaKekkaKubun1.Okiagari 起き上がり,
            ChosaKekkaKubun1.Zaihoji 座位保持,
            ChosaKekkaKubun1.RyoashiRitsui 両足での立位,
            ChosaKekkaKubun1.Hoko 歩行,
            ChosaKekkaKubun1.Tachiagari 立ち上がり,
            ChosaKekkaKubun1.KataashiRitsui 片足での立位,
            ChosaKekkaKubun1.Senshin 洗身,
            ChosaKekkaKubun1.Tsumekiri つめ切り,
            ChosaKekkaKubun1.Shiryoku 視力,
            ChosaKekkaKubun1.Choryoku 聴力) {
        this.麻痺左上肢 = requireNonNull(麻痺左上肢, Messages.E00001.replace("麻痺左上肢").getMessage());
        this.麻痺右上肢 = requireNonNull(麻痺右上肢, Messages.E00001.replace("麻痺右上肢").getMessage());
        this.麻痺左下肢 = requireNonNull(麻痺左下肢, Messages.E00001.replace("麻痺左下肢").getMessage());
        this.麻痺右下肢 = requireNonNull(麻痺右下肢, Messages.E00001.replace("麻痺右下肢").getMessage());
        this.麻痺その他 = requireNonNull(麻痺その他, Messages.E00001.replace("麻痺その他").getMessage());
        this.拘縮肩関節 = requireNonNull(拘縮肩関節, Messages.E00001.replace("拘縮肩関節").getMessage());
        this.拘縮股関節 = requireNonNull(拘縮股関節, Messages.E00001.replace("拘縮股関節").getMessage());
        this.拘縮膝関節 = requireNonNull(拘縮膝関節, Messages.E00001.replace("拘縮膝関節").getMessage());
        this.拘縮その他 = requireNonNull(拘縮その他, Messages.E00001.replace("拘縮その他").getMessage());
        this.寝返り = requireNonNull(寝返り, Messages.E00001.replace("寝返り").getMessage());
        this.起き上がり = requireNonNull(起き上がり, Messages.E00001.replace("起き上がり").getMessage());
        this.座位保持 = requireNonNull(座位保持, Messages.E00001.replace("座位保持").getMessage());
        this.両足での立位 = requireNonNull(両足での立位, Messages.E00001.replace("両足での立位").getMessage());
        this.歩行 = requireNonNull(歩行, Messages.E00001.replace("歩行").getMessage());
        this.立ち上がり = requireNonNull(立ち上がり, Messages.E00001.replace("立ち上がり").getMessage());
        this.片足での立位 = requireNonNull(片足での立位, Messages.E00001.replace("片足での立位").getMessage());
        this.洗身 = requireNonNull(洗身, Messages.E00001.replace("洗身").getMessage());
        this.つめ切り = requireNonNull(つめ切り, Messages.E00001.replace("つめ切り").getMessage());
        this.視力 = requireNonNull(視力, Messages.E00001.replace("視力").getMessage());
        this.聴力 = requireNonNull(聴力, Messages.E00001.replace("聴力").getMessage());
    }

    /**
     * 麻痺左上肢を返します。
     *
     * @return 麻痺左上肢
     */
    public ChosaKekkaKubun1.MahiHidariJoshi get麻痺左上肢() {
        return 麻痺左上肢;
    }

    /**
     * 麻痺右上肢を返します。
     *
     * @return 麻痺右上肢
     */
    public ChosaKekkaKubun1.MahiMigiJoshi get麻痺右上肢() {
        return 麻痺右上肢;
    }

    /**
     * 麻痺左下肢を返します。
     *
     * @return 麻痺左下肢
     */
    public ChosaKekkaKubun1.MahiHidariKashi get麻痺左下肢() {
        return 麻痺左下肢;
    }

    /**
     * 麻痺右下肢を返します。
     *
     * @return 麻痺右下肢
     */
    public ChosaKekkaKubun1.MahiMigiKashi get麻痺右下肢() {
        return 麻痺右下肢;
    }

    /**
     * 麻痺その他を返します。
     *
     * @return 麻痺その他
     */
    public ChosaKekkaKubun1.MahiSonota get麻痺その他() {
        return 麻痺その他;
    }

    /**
     * 拘縮肩関節を返します。
     *
     * @return 拘縮肩関節
     */
    public ChosaKekkaKubun1.KoshukuKata get拘縮肩関節() {
        return 拘縮肩関節;
    }

    /**
     * 拘縮股関節を返します。
     *
     * @return 拘縮股関節
     */
    public ChosaKekkaKubun1.KoshukuMata get拘縮股関節() {
        return 拘縮股関節;
    }

    /**
     * 拘縮膝関節を返します。
     *
     * @return 拘縮膝関節
     */
    public ChosaKekkaKubun1.KoshukuHiza get拘縮膝関節() {
        return 拘縮膝関節;
    }

    /**
     * 拘縮その他を返します。
     *
     * @return 拘縮その他
     */
    public ChosaKekkaKubun1.KoshukuSonota get拘縮その他() {
        return 拘縮その他;
    }

    /**
     * 寝返りを返します。
     *
     * @return 寝返り
     */
    public ChosaKekkaKubun1.Negaeri get寝返り() {
        return 寝返り;
    }

    /**
     * 起き上がりを返します。
     *
     * @return 起き上がり
     */
    public ChosaKekkaKubun1.Okiagari get起き上がり() {
        return 起き上がり;
    }

    /**
     * 座位保持を返します。
     *
     * @return 座位保持
     */
    public ChosaKekkaKubun1.Zaihoji get座位保持() {
        return 座位保持;
    }

    /**
     * 両足での立位を返します。
     *
     * @return 両足での立位
     */
    public ChosaKekkaKubun1.RyoashiRitsui get両足での立位() {
        return 両足での立位;
    }

    /**
     * 歩行を返します。
     *
     * @return 歩行
     */
    public ChosaKekkaKubun1.Hoko get歩行() {
        return 歩行;
    }

    /**
     * 立ち上がりを返します。
     *
     * @return 立ち上がり
     */
    public ChosaKekkaKubun1.Tachiagari get立ち上がり() {
        return 立ち上がり;
    }

    /**
     * 片足での立位を返します。
     *
     * @return 片足での立位
     */
    public ChosaKekkaKubun1.KataashiRitsui get片足での立位() {
        return 片足での立位;
    }

    /**
     * 洗身を返します。
     *
     * @return 洗身
     */
    public ChosaKekkaKubun1.Senshin get洗身() {
        return 洗身;
    }

    /**
     * つめ切りを返します。
     *
     * @return つめ切り
     */
    public ChosaKekkaKubun1.Tsumekiri getつめ切り() {
        return つめ切り;
    }

    /**
     * 視力を返します。
     *
     * @return 視力
     */
    public ChosaKekkaKubun1.Shiryoku get視力() {
        return 視力;
    }

    /**
     * 聴力を返します。
     *
     * @return 聴力
     */
    public ChosaKekkaKubun1.Choryoku get聴力() {
        return 聴力;
    }
}
