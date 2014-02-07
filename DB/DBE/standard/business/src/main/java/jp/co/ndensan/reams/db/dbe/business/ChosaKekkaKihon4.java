/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun4;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査第4群）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon4 {

    private final ChosaKekkaKubun4.Higaiteki 被害的;
    private final ChosaKekkaKubun4.Sakuwa 作話;
    private final ChosaKekkaKubun4.KanjoHuantei 感情が不安定;
    private final ChosaKekkaKubun4.ChuyaGyakuten 昼夜逆転;
    private final ChosaKekkaKubun4.OnajiHanashi 同じ話をする;
    private final ChosaKekkaKubun4.Ogoe 大声を出す;
    private final ChosaKekkaKubun4.KaigoNiTeiko 介護に抵抗;
    private final ChosaKekkaKubun4.Ochitsuki 落ち着きなし;
    private final ChosaKekkaKubun4.HitoriDeDetagaru 一人で出たがる;
    private final ChosaKekkaKubun4.Shushuheki 収集癖;
    private final ChosaKekkaKubun4.MonoYaIruiWoKowasu 物や衣類を壊す;
    private final ChosaKekkaKubun4.HidoiMonowasure ひどい物忘れ;
    private final ChosaKekkaKubun4.HitorigotoHitoriwarai 独り言独り笑い;
    private final ChosaKekkaKubun4.JibunKatte 自分勝手に行動する;
    private final ChosaKekkaKubun4.HanashiGaMatomaranai 話がまとまらない;

    /**
     * インスタンスを生成します。
     *
     * @param 被害的 被害的
     * @param 作話 作話
     * @param 感情が不安定 感情が不安定
     * @param 昼夜逆転 昼夜逆転
     * @param 同じ話をする 同じ話をする
     * @param 大声を出す 大声を出す
     * @param 介護に抵抗 介護に抵抗
     * @param 落ち着きなし 落ち着きなし
     * @param 一人で出たがる 一人で出たがる
     * @param 収集癖 収集癖
     * @param 物や衣類を壊す 物や衣類を壊す
     * @param ひどい物忘れ ひどい物忘れ
     * @param 独り言独り笑い 独り言独り笑い
     * @param 自分勝手に行動する 自分勝手に行動する
     * @param 話がまとまらない 話がまとまらない
     */
    public ChosaKekkaKihon4(
            ChosaKekkaKubun4.Higaiteki 被害的,
            ChosaKekkaKubun4.Sakuwa 作話,
            ChosaKekkaKubun4.KanjoHuantei 感情が不安定,
            ChosaKekkaKubun4.ChuyaGyakuten 昼夜逆転,
            ChosaKekkaKubun4.OnajiHanashi 同じ話をする,
            ChosaKekkaKubun4.Ogoe 大声を出す,
            ChosaKekkaKubun4.KaigoNiTeiko 介護に抵抗,
            ChosaKekkaKubun4.Ochitsuki 落ち着きなし,
            ChosaKekkaKubun4.HitoriDeDetagaru 一人で出たがる,
            ChosaKekkaKubun4.Shushuheki 収集癖,
            ChosaKekkaKubun4.MonoYaIruiWoKowasu 物や衣類を壊す,
            ChosaKekkaKubun4.HidoiMonowasure ひどい物忘れ,
            ChosaKekkaKubun4.HitorigotoHitoriwarai 独り言独り笑い,
            ChosaKekkaKubun4.JibunKatte 自分勝手に行動する,
            ChosaKekkaKubun4.HanashiGaMatomaranai 話がまとまらない) {
        this.被害的 = requireNonNull(被害的, Messages.E00001.replace("被害的").getMessage());
        this.作話 = requireNonNull(作話, Messages.E00001.replace("作話").getMessage());
        this.感情が不安定 = requireNonNull(感情が不安定, Messages.E00001.replace("感情が不安定").getMessage());
        this.昼夜逆転 = requireNonNull(昼夜逆転, Messages.E00001.replace("昼夜逆転").getMessage());
        this.同じ話をする = requireNonNull(同じ話をする, Messages.E00001.replace("同じ話をする").getMessage());
        this.大声を出す = requireNonNull(大声を出す, Messages.E00001.replace("大声を出す").getMessage());
        this.介護に抵抗 = requireNonNull(介護に抵抗, Messages.E00001.replace("介護に抵抗").getMessage());
        this.落ち着きなし = requireNonNull(落ち着きなし, Messages.E00001.replace("落ち着きなし").getMessage());
        this.一人で出たがる = requireNonNull(一人で出たがる, Messages.E00001.replace("一人で出たがる").getMessage());
        this.収集癖 = requireNonNull(収集癖, Messages.E00001.replace("収集癖").getMessage());
        this.物や衣類を壊す = requireNonNull(物や衣類を壊す, Messages.E00001.replace("物や衣類を壊す").getMessage());
        this.ひどい物忘れ = requireNonNull(ひどい物忘れ, Messages.E00001.replace("ひどい物忘れ").getMessage());
        this.独り言独り笑い = requireNonNull(独り言独り笑い, Messages.E00001.replace("独り言独り笑い").getMessage());
        this.自分勝手に行動する = requireNonNull(自分勝手に行動する, Messages.E00001.replace("自分勝手に行動する").getMessage());
        this.話がまとまらない = requireNonNull(話がまとまらない, Messages.E00001.replace("話がまとまらない").getMessage());
    }

    /**
     * 被害的を返します。
     *
     * @return 被害的
     */
    public ChosaKekkaKubun4.Higaiteki get被害的() {
        return 被害的;
    }

    /**
     * 作話を返します。
     *
     * @return 作話
     */
    public ChosaKekkaKubun4.Sakuwa get作話() {
        return 作話;
    }

    /**
     * 感情が不安定を返します。
     *
     * @return 感情が不安定
     */
    public ChosaKekkaKubun4.KanjoHuantei get感情が不安定() {
        return 感情が不安定;
    }

    /**
     * 昼夜逆転を返します。
     *
     * @return 昼夜逆転
     */
    public ChosaKekkaKubun4.ChuyaGyakuten get昼夜逆転() {
        return 昼夜逆転;
    }

    /**
     * 同じ話をするを返します。
     *
     * @return 同じ話をする
     */
    public ChosaKekkaKubun4.OnajiHanashi get同じ話をする() {
        return 同じ話をする;
    }

    /**
     * 大声を出すを返します。
     *
     * @return 大声を出す
     */
    public ChosaKekkaKubun4.Ogoe get大声を出す() {
        return 大声を出す;
    }

    /**
     * 介護に抵抗を返します。
     *
     * @return 介護に抵抗
     */
    public ChosaKekkaKubun4.KaigoNiTeiko get介護に抵抗() {
        return 介護に抵抗;
    }

    /**
     * 落ち着きなしを返します。
     *
     * @return 落ち着きなし
     */
    public ChosaKekkaKubun4.Ochitsuki get落ち着きなし() {
        return 落ち着きなし;
    }

    /**
     * 一人で出たがるを返します。
     *
     * @return 一人で出たがる
     */
    public ChosaKekkaKubun4.HitoriDeDetagaru get一人で出たがる() {
        return 一人で出たがる;
    }

    /**
     * 収集癖を返します。
     *
     * @return 収集癖
     */
    public ChosaKekkaKubun4.Shushuheki get収集癖() {
        return 収集癖;
    }

    /**
     * 物や衣類を壊すを返します。
     *
     * @return 物や衣類を壊す
     */
    public ChosaKekkaKubun4.MonoYaIruiWoKowasu get物や衣類を壊す() {
        return 物や衣類を壊す;
    }

    /**
     * ひどい物忘れを返します。
     *
     * @return ひどい物忘れ
     */
    public ChosaKekkaKubun4.HidoiMonowasure getひどい物忘れ() {
        return ひどい物忘れ;
    }

    /**
     * 独り言独り笑いを返します。
     *
     * @return 独り言独り笑い
     */
    public ChosaKekkaKubun4.HitorigotoHitoriwarai get独り言独り笑い() {
        return 独り言独り笑い;
    }

    /**
     * 自分勝手に行動するを返します。
     *
     * @return 自分勝手に行動する
     */
    public ChosaKekkaKubun4.JibunKatte get自分勝手に行動する() {
        return 自分勝手に行動する;
    }

    /**
     * 話がまとまらないを返します。
     *
     * @return 話がまとまらない
     */
    public ChosaKekkaKubun4.HanashiGaMatomaranai get話がまとまらない() {
        return 話がまとまらない;
    }
}
