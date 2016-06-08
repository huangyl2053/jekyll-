/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者種別を表す列挙体です。 介護保険施設入退所の施設分類についても表します。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護保険入所施設分類
 * @bizDomain
 * @category -
 * @subCategory
 * @mainClass
 * @reference
 */
public enum KaigoHokenNyushoShisetsuBunrui {

    /**
     * 介護保険施設します。
     */
    介護保険施設("11"),
    /**
     * 住所地特例対象施設します。
     */
    住所地特例対象施設("12"),
    /**
     * 適用除外施設します。
     */
    適用除外施設("21");
    private final RString shubetsuCd;

    private KaigoHokenNyushoShisetsuBunrui(final String shubetsuCd) {
        this.shubetsuCd = new RString(shubetsuCd);
    }

    /**
     * 該当の事業者種別が持つ種別コードを取得します。
     *
     * @return 種別コード
     */
    public RString getValue() {
        return shubetsuCd;
    }

    /**
     * 指定されたコードのEnum値を返します。<br/>
     * 指定されたコードがEnumに変換できない場合、IllegalArgumentExceptionが発生します。
     *
     * @param shubetsuCd 種別コード
     * @return 種別名
     * @throws IllegalArgumentException 対応する項目が存在しない場合
     */
    public static KaigoHokenNyushoShisetsuBunrui toValue(RString shubetsuCd) throws IllegalArgumentException {
        for (KaigoHokenNyushoShisetsuBunrui 分類 : values()) {
            if (分類.getValue().equals(shubetsuCd)) {
                return 分類;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("引数に対応した項目").evaluate());
    }
}
