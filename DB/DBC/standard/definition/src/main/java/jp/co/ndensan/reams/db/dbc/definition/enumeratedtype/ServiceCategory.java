/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 給付実績集計の合計対象を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ServiceCategory {

    /**
     * 合計対象が「居宅サービス合計」であることを表します。 <br />
     */
    居宅サービス,
    /**
     * 合計対象が「施設サービス合計」であることを表します。 <br />
     */
    施設サービス,
    /**
     * 合計対象が「地域密着型サービス合計」であることを表します。 <br />
     */
    地域密着型サービス;
//    private final RString code;

//    private ServiceCategory(String code) {
//        this.code = new RString(code);
//    }
    /**
     * コードを返します。
     *
     * @return コード
     */
//    public RString getCode() {
//        return code;
//    }
    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return コードに対応する列挙型
     */
//    public static ServiceCategory toValue(RString code) {
//        for (ServiceCategory data : values()) {
//            if (data.getCode().equals(code)) {
//                return data;
//            }
//        }
//        throw new IllegalArgumentException(Messages.E00006.replace("対応する給付実績集計の合計対象").getMessage());
//    }
}
