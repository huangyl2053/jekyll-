/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給申請事由の列挙型です。
 *
 */
public enum JuKyuShinSeiZiYu implements IYokaigoJotaiKubun {

    /**
     * 要介護状態区分が「非該当」であることを表します。<br />
     * コード：01
     */
    初回申請("1"),
    /**
     * 要介護状態区分が「要支援１」であることを表します。<br />
     * コード：12
     */
    再申請_有効期限内("2"),
    /**
     * 要介護状態区分が「要支援２」であることを表します。<br />
     * コード：13
     */
    再申請_有効期限外("3"),
    /**
     * 要介護状態区分が「要介護１」であることを表します。<br />
     * コード：21
     */
    要介護度変更申請("4"),
    /**
     * 要介護状態区分が「要介護２」であることを表します。<br />
     * コード：22
     */
    指定サービス種類変更申請("5"),
    /**
     * 要介護状態区分が「要介護３」であることを表します。<br />
     * コード：23
     */
    申請_法施行前("6"),
    /**
     * 要介護状態区分が「要介護４」であることを表します。<br />
     * コード：24
     */
    追加_申請なしの追加_転入("7"),

    区分変更申請中で_認定調査("区分変更申請中で、認定調査"),
    要介護認定申請中で_認定審査("要介護認定申請中で、認定審査"),
    済("済"),
    未("未"),
    更新認定申請中で_認定結果未("更新認定申請中で、認定結果未");
    
    private final RString code;

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }
    private final RString name;

    private JuKyuShinSeiZiYu(String code) {
        this.code = new RString(code);
        this.name = new RString(this.name());
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static JuKyuShinSeiZiYu toValue(RString code) throws IllegalArgumentException {
        for (JuKyuShinSeiZiYu data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給申請事由"));
    }
}
