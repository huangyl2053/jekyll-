/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuUmu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 一次判定警告配列コードを表すクラスです。<br/>
 * 警告配列コードは "01000011001...." という形になっており、1が警告有り、0は警告無しを表します。
 * この例だと、2・7・8・11番目に対応する警告が出ているということを表しています。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuHairetsuCode {

    private final RString 警告配列コード;
    private final IchijiHanteiKeikokuShubetsu 警告種別;

    /**
     * 引数から一次判定警告配列コードと判定を行った日付を受け取り、その情報を元にインスタンスを生成します。
     *
     * @param 警告配列コード 警告配列コード
     * @param 判定年月日 判定を行った日付
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public IchijiHanteiKeikokuHairetsuCode(RString 警告配列コード, FlexibleDate 判定年月日)
            throws NullPointerException {
        requireNonNull(警告配列コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("警告配列コード", getClass().getName()));
        requireNonNull(判定年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("警告コード種別", getClass().getName()));

        this.警告配列コード = 警告配列コード;
        this.警告種別 = IchijiHanteiKeikokuShubetsu.toValue(判定年月日);

        if (警告配列コード.length() != 警告種別.get警告数()) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace("警告配列コード", 警告種別.get警告数() + "桁").evaluate());
        }
    }

    /**
     * 警告配列種別コードを文字列で返します。
     *
     * @return 警告配列コードを表す文字列
     */
    public RString toRString() {
        return 警告配列コード;
    }

    /**
     * 警告コードがいつの制度のものなのかを返します。
     *
     * @return 警告種別
     */
    public IchijiHanteiKeikokuShubetsu get警告種別() {
        return 警告種別;
    }

    /**
     * 警告配列コードの長さを返します。
     *
     * @return 警告コード長
     */
    public int length() {
        return 警告種別.get警告数();
    }

    /**
     * 引数から渡されたindexに対応する警告について、警告有無区分を返します。<br/>
     * 指定したindexに対応する警告が存在しない場合、nullが返ります。
     *
     * @param index 警告配列コードを表す文字列の何番目かを指定するindex
     * @return 一次判定警告有無
     * @throws IllegalArgumentException indexに0より小さい値、もしくは警告配列コード長よりも大きい値が渡された場合
     */
    public IchijiHanteiKeikokuUmu valueAt(int index) throws IllegalArgumentException {
        if (index < 0 || this.length() - 1 < index) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace("引数のindexは",
                    "0より小さい値、もしくは警告配列コード長よりも大きい値").evaluate());
        }
        return IchijiHanteiKeikokuUmu.toValue(警告配列コード.stringAt(index));
    }
}
