/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文種別の列挙型です。
 *
 * @author n9606 漢那憲作
 */
public enum TeikeibunShubetsu implements IRStringConvertable {

    /**
     * 申請理由 ("001")
     */
    申請理由(new RString("001")),
    /**
     * 認定理由 ("002")
     */
    認定理由(new RString("002")),
    /**
     * サービス変更理由 ("003")
     */
    サービス変更理由(new RString("003")),
    /**
     * 取消理由 ("004")
     */
    取消理由(new RString("004")),
    /**
     * 却下理由 ("005")
     */
    却下理由(new RString("005")),
    /**
     * 延期理由 ("006")
     */
    延期理由(new RString("006")),
    /**
     * サービス種類 ("007")
     */
    サービス種類(new RString("007")),
    /**
     * 審査会意見 ("008")
     */
    意見書意見(new RString("008"));
    private final RString code;

    private TeikeibunShubetsu(RString code) {
        this.code = code;
    }

    /**
     * 指定された定型文種別コードに該当する定型文種別を返します。
     *
     * @param code 定型文種別コード
     * @return 引数のコードに対応するTeikeibunShubetsu型のenum
     * @throws IllegalArgumentException 実在しない定型文種別コードの場合
     */
    public static TeikeibunShubetsu toValue(RString code) throws NullPointerException, IllegalArgumentException {

        for (TeikeibunShubetsu item : TeikeibunShubetsu.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("該当する定型文種別").getMessage());
    }

    /**
     * 定型文種別を返します。
     *
     * @return 定型文種別コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
