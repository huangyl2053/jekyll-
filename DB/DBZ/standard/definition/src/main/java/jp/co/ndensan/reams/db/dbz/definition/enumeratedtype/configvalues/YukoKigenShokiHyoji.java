/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの資格者証期限_有効期限初期表示の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum YukoKigenShokiHyoji {

    /**
     * 資格者証期限_有効期限初期表示が「常にシステム日付+有効期限加算値」であることを表します。<br />
     * コード : 1
     */
    システム日付plus有効期限加算値("1"),
    /**
     * 資格者証期限_有効期限初期表示が「更新申請時、従前認定終値比較」であることを表します。<br />
     * コード : 2
     */
    更新申請時_従前認定終値比較("2"),
    /**
     * 資格者証期限_有効期限初期表示が「更新・区分申請時、従前認定終値比較」であることを表します。<br />
     * コード : 3
     */
    更新区分申請時_従前認定終値比較("3");

    private final RString theCode;

    private YukoKigenShokiHyoji(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return 有効期限初期表示
     */
    public RString code() {
        return theCode;
    }

    /**
     * 引数のコードに対応する{@link YukoKigenShokiHyoji}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link YukoKigenShokiHyoji}
     * @throws IllegalArgumentException コードに対応する{@link YukoKigenShokiHyoji}が無い時
     */
    public static YukoKigenShokiHyoji toValue(RString code) {
        for (YukoKigenShokiHyoji data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(YukoKigenShokiHyoji.class.getSimpleName()));
    }

}
