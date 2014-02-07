/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunIryo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査特別医療）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihonIryo {

    private final ChosaKekkaKubunIryo.Tenteki 点滴の管理;
    private final ChosaKekkaKubunIryo.ChushinJomyakuEiyo 中心静脈栄養;
    private final ChosaKekkaKubunIryo.Toseki 透析;
    private final ChosaKekkaKubunIryo.StomaShochi ストーマの処置;
    private final ChosaKekkaKubunIryo.SansoRyoho 酸素療法;
    private final ChosaKekkaKubunIryo.Respirator レスピレーター;
    private final ChosaKekkaKubunIryo.KikanSekkai 気管切開の処置;
    private final ChosaKekkaKubunIryo.TotsuKango 疼痛の看護;
    private final ChosaKekkaKubunIryo.KeikanEiyo 経管栄養;
    private final ChosaKekkaKubunIryo.MonitorSokutei モニター測定;
    private final ChosaKekkaKubunIryo.JokusoShochi じょくそうの処置;
    private final ChosaKekkaKubunIryo.Catheter カテーテル;

    /**
     * インスタンスを生成します。
     *
     * @param 点滴の管理 点滴の管理
     * @param 中心静脈栄養 中心静脈栄養
     * @param 透析 透析
     * @param ストーマの処置 ストーマの処置
     * @param 酸素療法 酸素療法
     * @param レスピレーター レスピレーター
     * @param 気管切開の処置 気管切開の処置
     * @param 疼痛の看護 疼痛の看護
     * @param 経管栄養 経管栄養
     * @param モニター測定 モニター測定
     * @param じょくそうの処置 じょくそうの処置
     * @param カテーテル カテーテル
     */
    public ChosaKekkaKihonIryo(
            ChosaKekkaKubunIryo.Tenteki 点滴の管理,
            ChosaKekkaKubunIryo.ChushinJomyakuEiyo 中心静脈栄養,
            ChosaKekkaKubunIryo.Toseki 透析,
            ChosaKekkaKubunIryo.StomaShochi ストーマの処置,
            ChosaKekkaKubunIryo.SansoRyoho 酸素療法,
            ChosaKekkaKubunIryo.Respirator レスピレーター,
            ChosaKekkaKubunIryo.KikanSekkai 気管切開の処置,
            ChosaKekkaKubunIryo.TotsuKango 疼痛の看護,
            ChosaKekkaKubunIryo.KeikanEiyo 経管栄養,
            ChosaKekkaKubunIryo.MonitorSokutei モニター測定,
            ChosaKekkaKubunIryo.JokusoShochi じょくそうの処置,
            ChosaKekkaKubunIryo.Catheter カテーテル) {
        this.点滴の管理 = requireNonNull(点滴の管理, Messages.E00001.replace("点滴の管理").getMessage());
        this.中心静脈栄養 = requireNonNull(中心静脈栄養, Messages.E00001.replace("中心静脈栄養").getMessage());
        this.透析 = requireNonNull(透析, Messages.E00001.replace("透析").getMessage());
        this.ストーマの処置 = requireNonNull(ストーマの処置, Messages.E00001.replace("ストーマの処置").getMessage());
        this.酸素療法 = requireNonNull(酸素療法, Messages.E00001.replace("酸素療法").getMessage());
        this.レスピレーター = requireNonNull(レスピレーター, Messages.E00001.replace("レスピレーター").getMessage());
        this.気管切開の処置 = requireNonNull(気管切開の処置, Messages.E00001.replace("気管切開の処置").getMessage());
        this.疼痛の看護 = requireNonNull(疼痛の看護, Messages.E00001.replace("疼痛の看護").getMessage());
        this.経管栄養 = requireNonNull(経管栄養, Messages.E00001.replace("経管栄養").getMessage());
        this.モニター測定 = requireNonNull(モニター測定, Messages.E00001.replace("モニター測定").getMessage());
        this.じょくそうの処置 = requireNonNull(じょくそうの処置, Messages.E00001.replace("じょくそうの処置").getMessage());
        this.カテーテル = requireNonNull(カテーテル, Messages.E00001.replace("カテーテル").getMessage());
    }

    /**
     * 点滴の管理を返します。
     *
     * @return 点滴の管理
     */
    public ChosaKekkaKubunIryo.Tenteki get点滴の管理() {
        return 点滴の管理;
    }

    /**
     * 中心静脈栄養を返します。
     *
     * @return 中心静脈栄養
     */
    public ChosaKekkaKubunIryo.ChushinJomyakuEiyo get中心静脈栄養() {
        return 中心静脈栄養;
    }

    /**
     * 透析を返します。
     *
     * @return 透析
     */
    public ChosaKekkaKubunIryo.Toseki get透析() {
        return 透析;
    }

    /**
     * ストーマの処置を返します。
     *
     * @return ストーマの処置
     */
    public ChosaKekkaKubunIryo.StomaShochi getストーマの処置() {
        return ストーマの処置;
    }

    /**
     * 酸素療法を返します。
     *
     * @return 酸素療法
     */
    public ChosaKekkaKubunIryo.SansoRyoho get酸素療法() {
        return 酸素療法;
    }

    /**
     * レスピレーターを返します。
     *
     * @return レスピレーター
     */
    public ChosaKekkaKubunIryo.Respirator getレスピレーター() {
        return レスピレーター;
    }

    /**
     * 気管切開の処置を返します。
     *
     * @return 気管切開の処置
     */
    public ChosaKekkaKubunIryo.KikanSekkai get気管切開の処置() {
        return 気管切開の処置;
    }

    /**
     * 疼痛の看護を返します。
     *
     * @return 疼痛の看護
     */
    public ChosaKekkaKubunIryo.TotsuKango get疼痛の看護() {
        return 疼痛の看護;
    }

    /**
     * 経管栄養を返します。
     *
     * @return 経管栄養
     */
    public ChosaKekkaKubunIryo.KeikanEiyo get経管栄養() {
        return 経管栄養;
    }

    /**
     * モニター測定を返します。
     *
     * @return モニター測定
     */
    public ChosaKekkaKubunIryo.MonitorSokutei getモニター測定() {
        return モニター測定;
    }

    /**
     * じょくそうの処置を返します。
     *
     * @return じょくそうの処置
     */
    public ChosaKekkaKubunIryo.JokusoShochi getじょくそうの処置() {
        return じょくそうの処置;
    }

    /**
     * カテーテルを返します。
     *
     * @return カテーテル
     */
    public ChosaKekkaKubunIryo.Catheter getカテーテル() {
        return カテーテル;
    }
}
