/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

//import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設種類を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum ShisetsuType {

    /**
     * 施設種類が「介護保険施設」であることを表します。 <br />
     * コード：11
     */
    介護保険施設("11"),
    /**
     * 施設種類が「住所地特例対象施設」であることを表します。 <br />
     * コード：12
     */
    住所地特例対象施設("12"),
    /**
     * 施設種類が「適用除外施設」であることを表します。 <br />
     * コード：21
     */
    適用除外施設("21");
    private final RString code;
    private final RString name;

    private ShisetsuType(String code) {
        this.code = new RString(code);
        this.name = new RString(name());
    }

    /**
     * RString型の施設種類コードを返します。
     *
     * @return 施設種類コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の施設種類名称を返します。
     *
     * @return 施設種類名称
     */
    public RString getName() {
        return name;
    }

    /**
     * RString型の施設種類コードをもらい、コードに対応するShisetsuType型のenumを返します。
     *
     * @param code 施設種類コード
     * @return 引数のコードに対応するShisetsuType型のenum
     */
    public static ShisetsuType toValue(RString code) {
        for (ShisetsuType data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
//TODO n8235 船山 Ver1.0.0への変更に伴いエラーが発生したため、コメントアウト
//        throw new IllegalArgumentException(Messages.E00006.replace("指定したコードに対応する台帳種別").getMessage());
        throw new IllegalArgumentException();
    }
}
