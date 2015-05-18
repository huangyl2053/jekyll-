/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

//import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 台帳種別を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum DaichoType {

    /**
     * 台帳種別が「被保険者」であることを表します。 <br />
     * コード：1
     */
    被保険者("1"),
    /**
     * 台帳種別が「他市町村住所地特例者」であることを表します。 <br />
     * コード：3
     */
    他市町村住所地特例者("3"),
    /**
     * 台帳種別が「適用除外者」であることを表します。 <br />
     * コード：2
     */
    適用除外者("2");
    private final RString code;
    private final RString name;

    private DaichoType(String code) {
        this.code = new RString(code);
        this.name = new RString(name());
    }

    /**
     * RString型の台帳種別コードを返します。
     *
     * @return 台帳種別コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の台帳種別名称を返します。
     *
     * @return 台帳種別名称
     */
    public RString getName() {
        return name;
    }

    /**
     * RString型の台帳種別コードをもらい、コードに対応するDaichoType型のenumを返します。
     *
     * @param code 台帳種別コード
     * @return 引数のコードに対応するDaichoType型のenum
     */
    public static DaichoType toValue(RString code) {
        for (DaichoType data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }

//TODO n8235 船山 Ver1.0.0への変更に伴いエラーが発生したため、コメントアウト
//        throw new IllegalArgumentException(Messages.E00006.replace("指定したコードに対応する台帳種別").getMessage());
        throw new IllegalArgumentException(UrErrorMessages.データが存在しない.getMessage().replace("指定したコードに対応する台帳種別").evaluate());
    }
}
