/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開催場所のクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBasho {

    private final ShinsakaiKaisaiBashoCode 開催場所コード;
    private final RString 開催場所名称;
    private final ShinsakaiKaisaiChiku 開催地区;
    private final AtenaJusho 開催場所住所;
    private final TelNo 開催場所電話番号;
    private final ShinsakaiKaisaiBashoJokyo 開催場所状況;

    /**
     * コンストラクタです。
     *
     * @param 開催場所コード 開催場所コード
     * @param 開催場所名称 開催場所名称
     * @param 開催地区 開催地区
     * @param 開催場所住所 開催場所住所
     * @param 開催場所電話番号 開催場所電話番号
     * @param 開催場所状況 開催場所状況
     */
    public ShinsakaiKaisaiBasho(ShinsakaiKaisaiBashoCode 開催場所コード,
            RString 開催場所名称,
            ShinsakaiKaisaiChiku 開催地区,
            AtenaJusho 開催場所住所,
            TelNo 開催場所電話番号,
            ShinsakaiKaisaiBashoJokyo 開催場所状況) {
        Objects.requireNonNull(開催場所コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("開催場所コード", "審査会開催場所"));
        Objects.requireNonNull(開催場所名称, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("開催場所名称", "審査会開催場所"));
        Objects.requireNonNull(開催場所状況, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("開催場所状況", "審査会開催場所"));
        this.開催場所コード = 開催場所コード;
        this.開催場所名称 = 開催場所名称;
        this.開催地区 = 開催地区;
        this.開催場所住所 = 開催場所住所;
        this.開催場所電話番号 = 開催場所電話番号;
        this.開催場所状況 = 開催場所状況;
    }

    /**
     * 開催場所コードを取得します。
     *
     * @return 開催場所コード
     */
    public ShinsakaiKaisaiBashoCode get開催場所コード() {
        return 開催場所コード;
    }

    /**
     * 開催場所名称を取得します。
     *
     * @return 開催場所名称
     */
    public RString get開催場所名称() {
        return 開催場所名称;
    }

    /**
     * 開催場所地区コードを取得します。
     *
     * @return 開催場所地区コード
     */
    public ShinsakaiKaisaiChiku get開催地区() {
        return 開催地区;
    }

    /**
     * 開催場所住所を取得します。
     *
     * @return 開催場所住所
     */
    public AtenaJusho get開催場所住所() {
        return 開催場所住所;
    }

    /**
     * 開催場所電話番号を取得します。
     *
     * @return 開催場所電話番号
     */
    public TelNo get開催場所電話番号() {
        return 開催場所電話番号;
    }

    /**
     * 開催場所の状況を判定します。
     *
     * @return 開催場所状況
     */
    public ShinsakaiKaisaiBashoJokyo get開催場所状況() {
        return 開催場所状況;
    }

    /**
     * 開催場所状況の有効・無効判定を行います。
     *
     * @return 有効・無効の判定結果
     */
    public boolean is有効() {
        return 開催場所状況.is有効();
    }

    @Override
    public int hashCode() {
        int hash = 97 * Objects.hashCode(this.開催場所コード)
                * Objects.hashCode(this.開催場所名称)
                * Objects.hashCode(this.開催地区)
                * Objects.hashCode(this.開催場所住所)
                * Objects.hashCode(this.開催場所電話番号)
                * Objects.hashCode(this.開催場所状況);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }

        final ShinsakaiKaisaiBasho other = (ShinsakaiKaisaiBasho) 比較対象;
        if (!Objects.equals(this.開催場所コード, other.開催場所コード)) {
            return false;
        }
        if (!Objects.equals(this.開催場所名称, other.開催場所名称)) {
            return false;
        }
        if (!Objects.equals(this.開催地区, other.開催地区)) {
            return false;
        }
        if (!Objects.equals(this.開催場所住所, other.開催場所住所)) {
            return false;
        }
        if (!Objects.equals(this.開催場所電話番号, other.開催場所電話番号)) {
            return false;
        }
        if (this.開催場所状況 != other.開催場所状況) {
            return false;
        }
        return true;
    }
}
