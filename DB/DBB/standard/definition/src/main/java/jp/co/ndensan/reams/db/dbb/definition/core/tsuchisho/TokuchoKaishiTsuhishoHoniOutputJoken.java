package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書本算定出力条件を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoKaishiTsuhishoHoniOutputJoken {

    /**
     * コード:1 名称:本算定分 略称:本算定分
     */
    本算定分("1", "本算定分", "本算定分"),
    /**
     * コード:2 名称:_12月特徴開始者のみ 略称:12月特徴開始者のみ
     */
    _12月特徴開始者のみ("2", "_12月特徴開始者のみ", "12月特徴開始者のみ"),
    /**
     * コード:3 名称:_2月特徴開始者のみ 略称:2月特徴開始者のみ
     */
    _2月特徴開始者のみ("3", "_2月特徴開始者のみ", "2月特徴開始者のみ"),
    /**
     * コード:4 名称:_4月特徴開始者のみ 略称:4月特徴開始者のみ
     */
    _4月特徴開始者のみ("4", "_4月特徴開始者のみ", "4月特徴開始者のみ");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoKaishiTsuhishoHoniOutputJoken(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴開始通知書本算定出力条件のコードを返します。
     *
     * @return 特徴開始通知書本算定出力条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始通知書本算定出力条件の名称を返します。
     *
     * @return 特徴開始通知書本算定出力条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始通知書本算定出力条件の略称を返します。
     *
     * @return 特徴開始通知書本算定出力条件の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴開始通知書本算定出力条件のコードと一致する内容を探します。
     *
     * @param code 特徴開始通知書本算定出力条件のコード
     * @return {@code code} に対応する特徴開始通知書本算定出力条件
     */
    public static TokuchoKaishiTsuhishoHoniOutputJoken toValue(RString code) {
        for (TokuchoKaishiTsuhishoHoniOutputJoken value : TokuchoKaishiTsuhishoHoniOutputJoken.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始通知書本算定出力条件"));
    }
}
