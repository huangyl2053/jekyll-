/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun2;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査第2群）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon2 {

    private final ChosaKekkaKubun2.Ijo 移乗;
    private final ChosaKekkaKubun2.Ido 移動;
    private final ChosaKekkaKubun2.Enge 嚥下;
    private final ChosaKekkaKubun2.ShokujiSesshu 食事摂取;
    private final ChosaKekkaKubun2.Hainyo 排尿;
    private final ChosaKekkaKubun2.Haiben 排便;
    private final ChosaKekkaKubun2.KokoSeiketsu 口腔清潔;
    private final ChosaKekkaKubun2.Sengan 洗顔;
    private final ChosaKekkaKubun2.Seihatsu 整髪;
    private final ChosaKekkaKubun2.JoiChakudatsu 上衣の着脱;
    private final ChosaKekkaKubun2.ZubonChakudatsu ズボン等の着脱;
    private final ChosaKekkaKubun2.GaishutsuHindo 外出頻度;

    /**
     * インスタンスを生成します。
     *
     * @param 移乗 移乗
     * @param 移動 移動
     * @param 嚥下 嚥下
     * @param 食事摂取 食事摂取
     * @param 排尿 排尿
     * @param 排便 排便
     * @param 口腔清潔 口腔清潔
     * @param 洗顔 洗顔
     * @param 整髪 整髪
     * @param 上衣の着脱 上衣の着脱
     * @param ズボン等の着脱 ズボン等の着脱
     * @param 外出頻度 外出頻度
     */
    public ChosaKekkaKihon2(
            ChosaKekkaKubun2.Ijo 移乗,
            ChosaKekkaKubun2.Ido 移動,
            ChosaKekkaKubun2.Enge 嚥下,
            ChosaKekkaKubun2.ShokujiSesshu 食事摂取,
            ChosaKekkaKubun2.Hainyo 排尿,
            ChosaKekkaKubun2.Haiben 排便,
            ChosaKekkaKubun2.KokoSeiketsu 口腔清潔,
            ChosaKekkaKubun2.Sengan 洗顔,
            ChosaKekkaKubun2.Seihatsu 整髪,
            ChosaKekkaKubun2.JoiChakudatsu 上衣の着脱,
            ChosaKekkaKubun2.ZubonChakudatsu ズボン等の着脱,
            ChosaKekkaKubun2.GaishutsuHindo 外出頻度) {
        this.移乗 = requireNonNull(移乗, Messages.E00001.replace("移乗").getMessage());
        this.移動 = requireNonNull(移動, Messages.E00001.replace("移動").getMessage());
        this.嚥下 = requireNonNull(嚥下, Messages.E00001.replace("嚥下").getMessage());
        this.食事摂取 = requireNonNull(食事摂取, Messages.E00001.replace("食事摂取").getMessage());
        this.排尿 = requireNonNull(排尿, Messages.E00001.replace("排尿").getMessage());
        this.排便 = requireNonNull(排便, Messages.E00001.replace("排便").getMessage());
        this.口腔清潔 = requireNonNull(口腔清潔, Messages.E00001.replace("口腔清潔").getMessage());
        this.洗顔 = requireNonNull(洗顔, Messages.E00001.replace("洗顔").getMessage());
        this.整髪 = requireNonNull(整髪, Messages.E00001.replace("整髪").getMessage());
        this.上衣の着脱 = requireNonNull(上衣の着脱, Messages.E00001.replace("上衣の着脱").getMessage());
        this.ズボン等の着脱 = requireNonNull(ズボン等の着脱, Messages.E00001.replace("ズボン等の着脱").getMessage());
        this.外出頻度 = requireNonNull(外出頻度, Messages.E00001.replace("外出頻度").getMessage());
    }

    /**
     * 移乗を返します。
     *
     * @return 移乗
     */
    public ChosaKekkaKubun2.Ijo get移乗() {
        return 移乗;
    }

    /**
     * 移動を返します。
     *
     * @return 移動
     */
    public ChosaKekkaKubun2.Ido get移動() {
        return 移動;
    }

    /**
     * 嚥下を返します。
     *
     * @return 嚥下
     */
    public ChosaKekkaKubun2.Enge get嚥下() {
        return 嚥下;
    }

    /**
     * 食事摂取を返します。
     *
     * @return 食事摂取
     */
    public ChosaKekkaKubun2.ShokujiSesshu get食事摂取() {
        return 食事摂取;
    }

    /**
     * 排尿を返します。
     *
     * @return 排尿
     */
    public ChosaKekkaKubun2.Hainyo get排尿() {
        return 排尿;
    }

    /**
     * 排便を返します。
     *
     * @return 排便
     */
    public ChosaKekkaKubun2.Haiben get排便() {
        return 排便;
    }

    /**
     * 口腔清潔を返します。
     *
     * @return 口腔清潔
     */
    public ChosaKekkaKubun2.KokoSeiketsu get口腔清潔() {
        return 口腔清潔;
    }

    /**
     * 洗顔を返します。
     *
     * @return 洗顔
     */
    public ChosaKekkaKubun2.Sengan get洗顔() {
        return 洗顔;
    }

    /**
     * 整髪を返します。
     *
     * @return 整髪
     */
    public ChosaKekkaKubun2.Seihatsu get整髪() {
        return 整髪;
    }

    /**
     * 上衣の着脱を返します。
     *
     * @return 上衣の着脱
     */
    public ChosaKekkaKubun2.JoiChakudatsu get上衣の着脱() {
        return 上衣の着脱;
    }

    /**
     * ズボン等の着脱を返します。
     *
     * @return ズボン等の着脱
     */
    public ChosaKekkaKubun2.ZubonChakudatsu getズボン等の着脱() {
        return ズボン等の着脱;
    }

    /**
     * 外出頻度を返します。
     *
     * @return 外出頻度
     */
    public ChosaKekkaKubun2.GaishutsuHindo get外出頻度() {
        return 外出頻度;
    }
}
