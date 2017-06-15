/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.viewbox.dbeuc22001;

import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 調査委託先と調査員のキーを保持します。
 */
@lombok.Getter
public class ChosaItakusakiChosainKey implements java.io.Serializable {

    private enum ViewStateKey {

        調査委託先And調査員
    }

    private final LasdecCode shichosonCode;
    private final ChosaItakusakiCode chosaItakusakiCode;
    private final ChosainCode chosainCode;

    private ChosaItakusakiChosainKey() {
        this.shichosonCode = LasdecCode.EMPTY;
        this.chosaItakusakiCode = ChosaItakusakiCode.EMPTY;
        this.chosainCode = ChosainCode.EMPTY;
    }

    private ChosaItakusakiChosainKey(Builder other) {
        this.shichosonCode = other.shichosonCode;
        this.chosaItakusakiCode = other.chosaItakusakiCode;
        this.chosainCode = other.chosainCode;
    }

    /**
     * @return ViewState内にインスタンスが存在する場合はそれを、以外は新しいインスタンス
     */
    public static ChosaItakusakiChosainKey get() {
        ChosaItakusakiChosainKey o = ViewStateHolder.get(ViewStateKey.調査委託先And調査員, ChosaItakusakiChosainKey.class);
        return o == null ? new ChosaItakusakiChosainKey() : o;
    }

    /**
     * ViewStateへ保存します。
     */
    public void putToViewState() {
        ViewStateHolder.put(ViewStateKey.調査委託先And調査員, this);
    }

    /**
     * @return 自身をベースに編集するためのビルダ
     */
    public Builder newBuilder() {
        return new Builder(this);
    }

    /**
     * {@link ChosaItakusakiChosainKey}のビルダです。
     */
    public static class Builder {

        private LasdecCode shichosonCode = LasdecCode.EMPTY;
        private ChosaItakusakiCode chosaItakusakiCode = ChosaItakusakiCode.EMPTY;
        private ChosainCode chosainCode = ChosainCode.EMPTY;

        private Builder(ChosaItakusakiChosainKey key) {
            this.shichosonCode = key.shichosonCode;
            this.chosaItakusakiCode = key.chosaItakusakiCode;
            this.chosainCode = key.chosainCode;
        }

        /**
         * すべての値が空の状態でビルダを生成します。
         */
        public Builder() {
        }

        /**
         * @param shichosonCode 市町村コード
         * @return ビルダのインスタンス
         */
        public Builder shichosonCode(RString shichosonCode) {
            this.shichosonCode = new LasdecCode(ObjectUtil.defaultIfNull(shichosonCode, RString.EMPTY));
            return this;
        }

        /**
         * @param chosaItakusakiCode 調査委託先コード
         * @return ビルダのインスタンス
         */
        public Builder chosaItakusakiCode(RString chosaItakusakiCode) {
            this.chosaItakusakiCode = new ChosaItakusakiCode(ObjectUtil.defaultIfNull(chosaItakusakiCode, RString.EMPTY));
            return this;
        }

        /**
         * @param chosainCode 調査員コード
         * @return ビルダのインスタンス
         */
        public Builder chosainCode(RString chosainCode) {
            this.chosainCode = new ChosainCode(ObjectUtil.defaultIfNull(chosainCode, RString.EMPTY));
            return this;
        }

        /**
         * @return {@link ChosaItakusakiChosainKey}のインスタンス
         */
        public ChosaItakusakiChosainKey build() {
            return new ChosaItakusakiChosainKey(this);
        }

    }

}
