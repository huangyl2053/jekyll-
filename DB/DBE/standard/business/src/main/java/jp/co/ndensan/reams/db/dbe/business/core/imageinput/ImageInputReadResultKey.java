/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ImageInputReadResult}の同一申請に関するキー項目です。
 */
public final class ImageInputReadResultKey {

    /**
     * すべて空文字の場合の値です。
     */
    public static final ImageInputReadResultKey EMPTY;

    static {
        EMPTY = new ImageInputReadResultKey(RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RString 認定申請日;

    /**
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     */
    public ImageInputReadResultKey(RString 証記載保険者番号, RString 被保険者番号, RString 認定申請日) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
    }

    /**
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * @return 認定申請日
     */
    public RString get認定申請日() {
        return 認定申請日;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImageInputReadResultKey other = (ImageInputReadResultKey) obj;
        if (!Objects.equals(this.証記載保険者番号, other.証記載保険者番号)) {
            return false;
        }
        if (!Objects.equals(this.被保険者番号, other.被保険者番号)) {
            return false;
        }
        return Objects.equals(this.認定申請日, other.認定申請日);
    }
}
