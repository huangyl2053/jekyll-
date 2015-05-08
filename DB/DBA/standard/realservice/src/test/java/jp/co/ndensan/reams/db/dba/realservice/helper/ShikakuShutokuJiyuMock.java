/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.helper;

//TODO:クラスが削除されてしまっているため、このクラスをどうするか決める必要がある。
//import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得事由のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuShutokuJiyuMock {

    private ShikakuShutokuJiyuMock() {
    }

    /**
     * 指定したコードと名称を持った、資格取得事由を生成します。
     *
     * @param code コード
     * @param name 名称
     * @return 資格取得事由
     */
    public static IShikakuShutokuJiyu createInstance(final RString code, final RString name) {
        return new IShikakuShutokuJiyu() {
//            @Override
//            public RString getCode() {
//                return code;
//            }
//
//            @Override
//            public RString getName() {
//                return name;
//            }
//
//            @Override
//            public RString getShortName() {
//                return RString.EMPTY;
//            }
        };
    }

    /**
     * 空の資格取得事由を生成します。
     *
     * @return 空の資格取得事由
     */
    public static IShikakuShutokuJiyu createInstance() {
        return createInstance(RString.EMPTY, RString.EMPTY);
    }
}
