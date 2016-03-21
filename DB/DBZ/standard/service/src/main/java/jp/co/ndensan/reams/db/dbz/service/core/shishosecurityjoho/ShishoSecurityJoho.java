/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho;

import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.auth.AuthItem;
import jp.co.ndensan.reams.uz.uza.auth.AuthType;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 支所情報セキュリティ
 */
public class ShishoSecurityJoho {

    private static final RString AUTHTYPE = new RString("koseiShichosonKengen");

    /**
     * コンストラクタです。
     */
    ShishoSecurityJoho() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiInputFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiInputFinder}のインスタンス
     */
    public static ShishoSecurityJoho createInstance() {
        return InstanceProvider.create(ShishoSecurityJoho.class);
    }

    /**
     *
     * 支所コードを取得する
     *
     * @param ログインユーザID RString
     * @return 支所コード
     */
    @CheckForNull
    public RString getShishoCode(RString ログインユーザID) {
        List<AuthorityItem> authorityItemList = getShichosonShikibetsuId(ログインユーザID);
        if (authorityItemList.isEmpty()) {
            return null;
        } else {
            return authorityItemList.get(0).getItemId();
        }
    }

    /**
     * @param ログインユーザID RString
     * @return 支所コードの権限項目リストを取得する
     */
    private List<AuthorityItem> getShichosonShikibetsuId(RString reamsLoginId) {
        if (RString.isNullOrEmpty(reamsLoginId)) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("ログインユーザID"));
        }
        return AuthItem.getAuthorities(reamsLoginId, new AuthType.Of().kinds(AUTHTYPE).create(), RDate.getNowDate());
    }
}
