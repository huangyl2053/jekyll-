package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-1-09B-2015を表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09B2015_1 {

    /**
     * コード:001 名称:（介護予防）訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ）・訪問型サービス 略称:定義なし
     */
    _介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ__訪問型サービス("001", "（介護予防）訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ）・訪問型サービス");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B2015_1(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-1-09B-2015のコードを返します。
     * 
     * @return 在宅利用-1-09B-2015のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-1-09B-2015の名称を返します。
     * 
     * @return 在宅利用-1-09B-2015の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-1-09B-2015のコードと一致する内容を探します。
     * 
     * @param code 在宅利用-1-09B-2015のコード
     * @return {@code code} に対応する在宅利用-1-09B-2015
     */
    public static GaikyochosaKomoku09B2015_1 toValue(RString code) {
        for (GaikyochosaKomoku09B2015_1 gaikyochosaKomoku09B2015_1 : GaikyochosaKomoku09B2015_1.values()) {
            if (gaikyochosaKomoku09B2015_1.code.equals(code)) {
                return gaikyochosaKomoku09B2015_1;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-1-09B-2015"));
    }
}
