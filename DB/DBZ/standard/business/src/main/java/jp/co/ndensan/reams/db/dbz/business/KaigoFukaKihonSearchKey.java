/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 介護賦課基本情報の検索キークラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoFukaKihonSearchKey {

    private final RString 通知書番号;
    private final FlexibleYear 賦課年度;
    private final LasdecCode 市町村コード;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param builder 介護賦課基本情報の検索キーBuilder
     * @throws NullPointerException 引数がnullの場合
     */
    public KaigoFukaKihonSearchKey(KaigoFukaKihonSearchKeyBuilder builder) throws NullPointerException {
        requireNonNull(builder, UrSystemErrorMessages.値がnull.getReplacedMessage("builder"));
        this.通知書番号 = builder.get通知書番号();
        this.賦課年度 = builder.get賦課年度();
        this.市町村コード = builder.get市町村コード();
        this.識別コード = builder.get識別コード();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public RString get通知書番号() {
        return 通知書番号;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }
}
