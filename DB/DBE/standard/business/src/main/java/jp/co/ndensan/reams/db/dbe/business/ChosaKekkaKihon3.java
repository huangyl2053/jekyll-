/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun3;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査第3群）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon3 {

    private final ChosaKekkaKubun3.IshiDentatsu 意思の伝達;
    private final ChosaKekkaKubun3.Nikka 毎日の日課を理解;
    private final ChosaKekkaKubun3.Seinengappi 生年月日をいう;
    private final ChosaKekkaKubun3.TankiKioku 短期記憶;
    private final ChosaKekkaKubun3.Namae 自分の名前をいう;
    private final ChosaKekkaKubun3.Kisetsu 今の季節を理解;
    private final ChosaKekkaKubun3.Basho 場所の理解;
    private final ChosaKekkaKubun3.Haikai 徘徊;
    private final ChosaKekkaKubun3.Gaishutsu 外出して戻れない;

    /**
     * インスタンスを生成します。
     *
     * @param 意思の伝達 意思の伝達
     * @param 毎日の日課を理解 毎日の日課を理解
     * @param 生年月日をいう 生年月日をいう
     * @param 短期記憶 短期記憶
     * @param 自分の名前をいう 自分の名前をいう
     * @param 今の季節を理解 今の季節を理解
     * @param 場所の理解 場所の理解
     * @param 徘徊 徘徊
     * @param 外出して戻れない 外出して戻れない
     */
    public ChosaKekkaKihon3(
            ChosaKekkaKubun3.IshiDentatsu 意思の伝達,
            ChosaKekkaKubun3.Nikka 毎日の日課を理解,
            ChosaKekkaKubun3.Seinengappi 生年月日をいう,
            ChosaKekkaKubun3.TankiKioku 短期記憶,
            ChosaKekkaKubun3.Namae 自分の名前をいう,
            ChosaKekkaKubun3.Kisetsu 今の季節を理解,
            ChosaKekkaKubun3.Basho 場所の理解,
            ChosaKekkaKubun3.Haikai 徘徊,
            ChosaKekkaKubun3.Gaishutsu 外出して戻れない) {
        this.意思の伝達 = requireNonNull(意思の伝達, Messages.E00001.replace("意思の伝達").getMessage());
        this.毎日の日課を理解 = requireNonNull(毎日の日課を理解, Messages.E00001.replace("毎日の日課を理解").getMessage());
        this.生年月日をいう = requireNonNull(生年月日をいう, Messages.E00001.replace("生年月日をいう").getMessage());
        this.短期記憶 = requireNonNull(短期記憶, Messages.E00001.replace("短期記憶").getMessage());
        this.自分の名前をいう = requireNonNull(自分の名前をいう, Messages.E00001.replace("自分の名前をいう").getMessage());
        this.今の季節を理解 = requireNonNull(今の季節を理解, Messages.E00001.replace("今の季節を理解").getMessage());
        this.場所の理解 = requireNonNull(場所の理解, Messages.E00001.replace("場所の理解").getMessage());
        this.徘徊 = requireNonNull(徘徊, Messages.E00001.replace("徘徊").getMessage());
        this.外出して戻れない = requireNonNull(外出して戻れない, Messages.E00001.replace("外出して戻れない").getMessage());
    }

    /**
     * 意思の伝達を返します。
     *
     * @return 意思の伝達
     */
    public ChosaKekkaKubun3.IshiDentatsu get意思の伝達() {
        return 意思の伝達;
    }

    /**
     * 毎日の日課を理解を返します。
     *
     * @return 毎日の日課を理解
     */
    public ChosaKekkaKubun3.Nikka get毎日の日課を理解() {
        return 毎日の日課を理解;
    }

    /**
     * 生年月日をいうを返します。
     *
     * @return 生年月日をいう
     */
    public ChosaKekkaKubun3.Seinengappi get生年月日をいう() {
        return 生年月日をいう;
    }

    /**
     * 短期記憶を返します。
     *
     * @return 短期記憶
     */
    public ChosaKekkaKubun3.TankiKioku get短期記憶() {
        return 短期記憶;
    }

    /**
     * 自分の名前をいうを返します。
     *
     * @return 自分の名前をいう
     */
    public ChosaKekkaKubun3.Namae get自分の名前をいう() {
        return 自分の名前をいう;
    }

    /**
     * 今の季節を理解を返します。
     *
     * @return 今の季節を理解
     */
    public ChosaKekkaKubun3.Kisetsu get今の季節を理解() {
        return 今の季節を理解;
    }

    /**
     * 場所の理解を返します。
     *
     * @return 場所の理解
     */
    public ChosaKekkaKubun3.Basho get場所の理解() {
        return 場所の理解;
    }

    /**
     * 徘徊を返します。
     *
     * @return 徘徊
     */
    public ChosaKekkaKubun3.Haikai get徘徊() {
        return 徘徊;
    }

    /**
     * 外出して戻れないを返します。
     *
     * @return 外出して戻れない
     */
    public ChosaKekkaKubun3.Gaishutsu get外出して戻れない() {
        return 外出して戻れない;
    }
}
