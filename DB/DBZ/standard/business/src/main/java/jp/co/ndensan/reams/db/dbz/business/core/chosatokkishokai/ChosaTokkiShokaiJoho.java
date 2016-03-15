/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.chosatokkishokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査特記事項照会情報
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaTokkiShokaiJoho implements Serializable {

    private NinteichosahyoTokkijiko 特記情報;
    private RString 原本特記事項;
    private RString マスク特記事項;

    /**
     * コンストラクタです。<br/>
     * 認定調査特記事項照会情報の新規作成時に使用します。
     *
     */
    public ChosaTokkiShokaiJoho() {
        this.特記情報 = null;
        this.原本特記事項 = null;
        this.マスク特記事項 = null;
    }

    /**
     * コンストラクタです。<br/>
     * 認定調査特記事項照会情報の新規作成時に使用します。
     *
     * @param 特記情報 特記情報
     * @param 原本特記事項 原本特記事項
     * @param マスク特記事項 マスク特記事項
     */
    public ChosaTokkiShokaiJoho(NinteichosahyoTokkijiko 特記情報, RString 原本特記事項, RString マスク特記事項) {
        this.特記情報 = 特記情報;
        this.原本特記事項 = 原本特記事項;
        this.マスク特記事項 = マスク特記事項;
    }

    /**
     * 認定調査特記事項照会情報が空かどうかを判断する。
     *
     * @return isEmpty
     */
    public boolean isEmpty() {
        return this.特記情報 == null;
    }

    /**
     * {@link NinteichosahyoTokkijiko}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoTokkijiko}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new ChosaTokkiShokaiJoho._SerializationProxy(特記情報, 原本特記事項, マスク特記事項);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final NinteichosahyoTokkijiko 特記情報;
        private final RString 原本特記事項;
        private final RString マスク特記事項;

        private _SerializationProxy(NinteichosahyoTokkijiko 特記情報, RString 原本特記事項, RString マスク特記事項) {
            this.特記情報 = 特記情報;
            this.原本特記事項 = 原本特記事項;
            this.マスク特記事項 = マスク特記事項;
        }

        private Object readResolve() {
            return new ChosaTokkiShokaiJoho(this.特記情報, this.原本特記事項, this.マスク特記事項);
        }
    }
}
